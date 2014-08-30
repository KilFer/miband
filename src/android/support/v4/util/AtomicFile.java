package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File a;
  private final File b;

  public AtomicFile(File paramFile)
  {
    this.a = paramFile;
    this.b = new File(paramFile.getPath() + ".bak");
  }

  private static boolean a(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null);
    try
    {
      paramFileOutputStream.getFD().sync();
      return true;
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public void delete()
  {
    this.a.delete();
    this.b.delete();
  }

  public void failWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
      a(paramFileOutputStream);
    try
    {
      paramFileOutputStream.close();
      this.a.delete();
      this.b.renameTo(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("AtomicFile", "failWrite: Got exception:", localIOException);
    }
  }

  public void finishWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null)
      a(paramFileOutputStream);
    try
    {
      paramFileOutputStream.close();
      this.b.delete();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("AtomicFile", "finishWrite: Got exception:", localIOException);
    }
  }

  public File getBaseFile()
  {
    return this.a;
  }

  public FileInputStream openRead()
  {
    if (this.b.exists())
    {
      this.a.delete();
      this.b.renameTo(this.a);
    }
    return new FileInputStream(this.a);
  }

  public byte[] readFully()
  {
    int i = 0;
    FileInputStream localFileInputStream = openRead();
    while (true)
    {
      Object localObject2;
      try
      {
        localObject2 = new byte[localFileInputStream.available()];
        int j = localFileInputStream.read((byte[])localObject2, i, localObject2.length - i);
        if (j <= 0)
          return localObject2;
        int k = j + i;
        int m = localFileInputStream.available();
        if (m > localObject2.length - k)
        {
          localObject3 = new byte[m + k];
          System.arraycopy(localObject2, 0, localObject3, 0, k);
          localObject2 = localObject3;
          i = k;
          continue;
        }
      }
      finally
      {
        localFileInputStream.close();
      }
      Object localObject3 = localObject2;
    }
  }

  public FileOutputStream startWrite()
  {
    if (this.a.exists())
    {
      if (this.b.exists())
        break label85;
      if (!this.a.renameTo(this.b))
        Log.w("AtomicFile", "Couldn't rename file " + this.a + " to backup file " + this.b);
    }
    try
    {
      while (true)
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream(this.a);
        return localFileOutputStream1;
        label85: this.a.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      if (!this.a.getParentFile().mkdir())
        throw new IOException("Couldn't create directory " + this.a);
      try
      {
        FileOutputStream localFileOutputStream2 = new FileOutputStream(this.a);
        return localFileOutputStream2;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
      }
    }
    throw new IOException("Couldn't create " + this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.AtomicFile
 * JD-Core Version:    0.6.2
 */