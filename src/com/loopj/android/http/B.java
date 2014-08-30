package com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

final class B
{
  public File a;
  public byte[] b = a(paramString1, paramFile.getName(), paramString2);

  public B(A paramA, String paramString1, File paramFile, String paramString2)
  {
    this.a = paramFile;
  }

  private byte[] a(String paramString1, String paramString2, String paramString3)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localByteArrayOutputStream.write(A.a(this.c));
      localByteArrayOutputStream.write(A.a(this.c, paramString1, paramString2));
      localByteArrayOutputStream.write(A.a(this.c, paramString3));
      localByteArrayOutputStream.write(A.a());
      localByteArrayOutputStream.write(A.b());
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", localIOException);
    }
  }

  public final long a()
  {
    return this.a.length() + A.b().length + this.b.length;
  }

  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(this.b);
    A.a(this.c, this.b.length);
    FileInputStream localFileInputStream = new FileInputStream(this.a);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i = localFileInputStream.read(arrayOfByte);
      if (i == -1)
      {
        paramOutputStream.write(A.b());
        A.a(this.c, A.b().length);
        paramOutputStream.flush();
        AsyncHttpClient.silentCloseInputStream(localFileInputStream);
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      A.a(this.c, i);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.B
 * JD-Core Version:    0.6.2
 */