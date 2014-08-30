package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider
{
  private static final String[] a = { "_display_name", "_size" };
  private static final String b = "android.support.FILE_PROVIDER_PATHS";
  private static final String c = "root-path";
  private static final String d = "files-path";
  private static final String e = "cache-path";
  private static final String f = "external-path";
  private static final String g = "name";
  private static final String h = "path";
  private static final File i = new File("/");
  private static HashMap<String, b> j = new HashMap();
  private b k;

  private static int a(String paramString)
  {
    if ("r".equals(paramString))
      return 268435456;
    if (("w".equals(paramString)) || ("wt".equals(paramString)))
      return 738197504;
    if ("wa".equals(paramString))
      return 704643072;
    if ("rw".equals(paramString))
      return 939524096;
    if ("rwt".equals(paramString))
      return 1006632960;
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }

  private static b a(Context paramContext, String paramString)
  {
    b localb;
    synchronized (j)
    {
      localb = (b)j.get(paramString);
      if (localb != null);
    }
    while (true)
    {
      String str1;
      String str3;
      Object localObject2;
      try
      {
        localb = new b(paramString);
        localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (localXmlResourceParser == null)
          throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
      }
      catch (IOException localIOException)
      {
        XmlResourceParser localXmlResourceParser;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localIOException);
        localObject1 = finally;
        throw localObject1;
        int m = localXmlResourceParser.next();
        if (m == 1)
          break label297;
        if (m != 2)
          continue;
        str1 = localXmlResourceParser.getName();
        String str2 = localXmlResourceParser.getAttributeValue(null, "name");
        str3 = localXmlResourceParser.getAttributeValue(null, "path");
        if ("root-path".equals(str1))
        {
          localObject2 = a(i, new String[] { str3 });
          if (localObject2 == null)
            continue;
          localb.a(str2, (File)localObject2);
          continue;
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localXmlPullParserException);
      }
      if ("files-path".equals(str1))
      {
        localObject2 = a(paramContext.getFilesDir(), new String[] { str3 });
      }
      else if ("cache-path".equals(str1))
      {
        localObject2 = a(paramContext.getCacheDir(), new String[] { str3 });
      }
      else if ("external-path".equals(str1))
      {
        File localFile = a(Environment.getExternalStorageDirectory(), new String[] { str3 });
        localObject2 = localFile;
        continue;
        label297: j.put(paramString, localb);
        return localb;
      }
      else
      {
        localObject2 = null;
      }
    }
  }

  private static File a(File paramFile, String[] paramArrayOfString)
  {
    int m = paramArrayOfString.length;
    int n = 0;
    Object localObject1 = paramFile;
    String str;
    if (n < m)
    {
      str = paramArrayOfString[n];
      if (str == null)
        break label49;
    }
    label49: for (Object localObject2 = new File((File)localObject1, str); ; localObject2 = localObject1)
    {
      n++;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }

  private static Object[] a(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }

  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }

  private static b b(Context paramContext, String paramString)
  {
    b localb = new b(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null)
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    label235: 
    while (true)
    {
      int m = localXmlResourceParser.next();
      String str1;
      String str2;
      String str3;
      File localFile;
      if (m != 1)
      {
        if (m == 2)
        {
          str1 = localXmlResourceParser.getName();
          str2 = localXmlResourceParser.getAttributeValue(null, "name");
          str3 = localXmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(str1))
            localFile = a(i, new String[] { str3 });
        }
      }
      else
        while (true)
        {
          if (localFile == null)
            break label235;
          localb.a(str2, localFile);
          break;
          if ("files-path".equals(str1))
          {
            localFile = a(paramContext.getFilesDir(), new String[] { str3 });
          }
          else if ("cache-path".equals(str1))
          {
            localFile = a(paramContext.getCacheDir(), new String[] { str3 });
          }
          else if ("external-path".equals(str1))
          {
            localFile = a(Environment.getExternalStorageDirectory(), new String[] { str3 });
            continue;
            return localb;
          }
          else
          {
            localFile = null;
          }
        }
    }
  }

  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return a(paramContext, paramString).a(paramFile);
  }

  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported)
      throw new SecurityException("Provider must not be exported");
    if (!paramProviderInfo.grantUriPermissions)
      throw new SecurityException("Provider must grant uri permissions");
    this.k = a(paramContext, paramProviderInfo.authority);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.k.a(paramUri).delete())
      return 1;
    return 0;
  }

  public String getType(Uri paramUri)
  {
    File localFile = this.k.a(paramUri);
    int m = localFile.getName().lastIndexOf('.');
    if (m >= 0)
    {
      String str1 = localFile.getName().substring(m + 1);
      String str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
      if (str2 != null)
        return str2;
    }
    return "application/octet-stream";
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }

  public boolean onCreate()
  {
    return true;
  }

  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    File localFile = this.k.a(paramUri);
    int m;
    if ("r".equals(paramString))
      m = 268435456;
    while (true)
    {
      return ParcelFileDescriptor.open(localFile, m);
      if (("w".equals(paramString)) || ("wt".equals(paramString)))
      {
        m = 738197504;
      }
      else if ("wa".equals(paramString))
      {
        m = 704643072;
      }
      else if ("rw".equals(paramString))
      {
        m = 939524096;
      }
      else
      {
        if (!"rwt".equals(paramString))
          break;
        m = 1006632960;
      }
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    File localFile = this.k.a(paramUri);
    if (paramArrayOfString1 == null)
      paramArrayOfString1 = a;
    String[] arrayOfString1 = new String[paramArrayOfString1.length];
    Object[] arrayOfObject1 = new Object[paramArrayOfString1.length];
    int m = paramArrayOfString1.length;
    int n = 0;
    int i1 = 0;
    String str;
    int i2;
    if (n < m)
    {
      str = paramArrayOfString1[n];
      if ("_display_name".equals(str))
      {
        arrayOfString1[i1] = "_display_name";
        i2 = i1 + 1;
        arrayOfObject1[i1] = localFile.getName();
      }
    }
    while (true)
    {
      n++;
      i1 = i2;
      break;
      if ("_size".equals(str))
      {
        arrayOfString1[i1] = "_size";
        i2 = i1 + 1;
        arrayOfObject1[i1] = Long.valueOf(localFile.length());
        continue;
        String[] arrayOfString2 = new String[i1];
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i1);
        Object[] arrayOfObject2 = new Object[i1];
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i1);
        MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString2, 1);
        localMatrixCursor.addRow(arrayOfObject2);
        return localMatrixCursor;
      }
      else
      {
        i2 = i1;
      }
    }
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.6.2
 */