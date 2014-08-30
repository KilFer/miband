package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class e
{
  private final String a;
  private final HashMap<String, File> b;

  public e(String paramString)
  {
    this.b = new HashMap();
    this.a = paramString;
  }

  public final Uri a(File paramFile)
  {
    while (true)
    {
      String str1;
      Object localObject1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        localObject1 = null;
        Iterator localIterator = this.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (Map.Entry)localIterator.next();
          String str5 = ((File)((Map.Entry)localObject2).getValue()).getPath();
          if ((!str1.startsWith(str5)) || ((localObject1 != null) && (str5.length() <= ((File)localObject1.getValue()).getPath().length())))
            break label281;
          localObject1 = localObject2;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile);
      }
      if (localObject1 == null)
        throw new IllegalArgumentException("Failed to find configured root that contains " + str1);
      String str2 = ((File)localObject1.getValue()).getPath();
      if (str2.endsWith("/"));
      for (String str3 = str1.substring(str2.length()); ; str3 = str1.substring(1 + str2.length()))
      {
        String str4 = Uri.encode((String)localObject1.getKey()) + '/' + Uri.encode(str3, "/");
        return new Uri.Builder().scheme("content").authority(this.a).encodedPath(str4).build();
      }
      label281: Object localObject2 = localObject1;
    }
  }

  public final File a(Uri paramUri)
  {
    String str1 = paramUri.getEncodedPath();
    int i = str1.indexOf('/', 1);
    String str2 = Uri.decode(str1.substring(1, i));
    String str3 = Uri.decode(str1.substring(i + 1));
    File localFile1 = (File)this.b.get(str2);
    if (localFile1 == null)
      throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
    File localFile2 = new File(localFile1, str3);
    File localFile3;
    try
    {
      localFile3 = localFile2.getCanonicalFile();
      if (!localFile3.getPath().startsWith(localFile1.getPath()))
        throw new SecurityException("Resolved path jumped beyond configured root");
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + localFile2);
    }
    return localFile3;
  }

  public final void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Name must not be empty");
    try
    {
      File localFile = paramFile.getCanonicalFile();
      this.b.put(paramString, localFile);
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, localIOException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.e
 * JD-Core Version:    0.6.2
 */