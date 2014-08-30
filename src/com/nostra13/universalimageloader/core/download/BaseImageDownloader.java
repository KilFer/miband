package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader
  implements ImageDownloader
{
  protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
  protected static final int BUFFER_SIZE = 32768;
  protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
  public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
  public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
  protected static final int MAX_REDIRECT_COUNT = 5;
  private static final String a = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
  protected final int connectTimeout;
  protected final Context context;
  protected final int readTimeout;

  public BaseImageDownloader(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = 5000;
    this.readTimeout = 20000;
  }

  public BaseImageDownloader(Context paramContext, int paramInt1, int paramInt2)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = paramInt1;
    this.readTimeout = paramInt2;
  }

  protected HttpURLConnection createConnection(String paramString, Object paramObject)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
    localHttpURLConnection.setConnectTimeout(this.connectTimeout);
    localHttpURLConnection.setReadTimeout(this.readTimeout);
    return localHttpURLConnection;
  }

  public InputStream getStream(String paramString, Object paramObject)
  {
    switch (a.a[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default:
      return getStreamFromOtherSource(paramString, paramObject);
    case 1:
    case 2:
      return getStreamFromNetwork(paramString, paramObject);
    case 3:
      return getStreamFromFile(paramString, paramObject);
    case 4:
      return getStreamFromContent(paramString, paramObject);
    case 5:
      return getStreamFromAssets(paramString, paramObject);
    case 6:
    }
    return getStreamFromDrawable(paramString, paramObject);
  }

  protected InputStream getStreamFromAssets(String paramString, Object paramObject)
  {
    String str = ImageDownloader.Scheme.ASSETS.crop(paramString);
    return this.context.getAssets().open(str);
  }

  protected InputStream getStreamFromContent(String paramString, Object paramObject)
  {
    ContentResolver localContentResolver = this.context.getContentResolver();
    Uri localUri = Uri.parse(paramString);
    if (paramString.startsWith("content://com.android.contacts/"))
      return ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, localUri);
    return localContentResolver.openInputStream(localUri);
  }

  protected InputStream getStreamFromDrawable(String paramString, Object paramObject)
  {
    int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(paramString));
    return this.context.getResources().openRawResource(i);
  }

  protected InputStream getStreamFromFile(String paramString, Object paramObject)
  {
    String str = ImageDownloader.Scheme.FILE.crop(paramString);
    return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(str), 32768), (int)new File(str).length());
  }

  protected InputStream getStreamFromNetwork(String paramString, Object paramObject)
  {
    HttpURLConnection localHttpURLConnection = createConnection(paramString, paramObject);
    for (int i = 0; (localHttpURLConnection.getResponseCode() / 100 == 3) && (i < 5); i++)
      localHttpURLConnection = createConnection(localHttpURLConnection.getHeaderField("Location"), paramObject);
    try
    {
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      return new ContentLengthInputStream(new BufferedInputStream(localInputStream, 32768), localHttpURLConnection.getContentLength());
    }
    catch (IOException localIOException)
    {
      IoUtils.readAndCloseStream(localHttpURLConnection.getErrorStream());
      throw localIOException;
    }
  }

  protected InputStream getStreamFromOtherSource(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] { paramString }));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.BaseImageDownloader
 * JD-Core Version:    0.6.2
 */