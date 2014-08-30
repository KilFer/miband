package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{
  private static final String a = "FileAsyncHttpResponseHandler";
  protected final File mFile;

  static
  {
    if (!FileAsyncHttpResponseHandler.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      return;
    }
  }

  public FileAsyncHttpResponseHandler(Context paramContext)
  {
    this.mFile = getTemporaryFile(paramContext);
  }

  public FileAsyncHttpResponseHandler(File paramFile)
  {
    if ((!b) && (paramFile == null))
      throw new AssertionError();
    this.mFile = paramFile;
  }

  public boolean deleteTargetFile()
  {
    return (getTargetFile() != null) && (getTargetFile().delete());
  }

  protected byte[] getResponseData(HttpEntity paramHttpEntity)
  {
    int i = 0;
    InputStream localInputStream;
    long l;
    FileOutputStream localFileOutputStream;
    if (paramHttpEntity != null)
    {
      localInputStream = paramHttpEntity.getContent();
      l = paramHttpEntity.getContentLength();
      localFileOutputStream = new FileOutputStream(getTargetFile());
      if (localInputStream == null);
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int j = localInputStream.read(arrayOfByte);
        if (j != -1)
        {
          boolean bool = Thread.currentThread().isInterrupted();
          if (!bool);
        }
        else
        {
          return null;
        }
        i += j;
        localFileOutputStream.write(arrayOfByte, 0, j);
        sendProgressMessage(i, (int)l);
      }
    }
    finally
    {
      AsyncHttpClient.silentCloseInputStream(localInputStream);
      localFileOutputStream.flush();
      AsyncHttpClient.silentCloseOutputStream(localFileOutputStream);
    }
  }

  protected File getTargetFile()
  {
    if ((!b) && (this.mFile == null))
      throw new AssertionError();
    return this.mFile;
  }

  protected File getTemporaryFile(Context paramContext)
  {
    if ((!b) && (paramContext == null))
      throw new AssertionError();
    try
    {
      File localFile = File.createTempFile("temp_", "_handled", paramContext.getCacheDir());
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      Log.e("FileAsyncHttpResponseHandler", "Cannot create temporary file", localThrowable);
    }
    return null;
  }

  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, File paramFile);

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, getTargetFile());
  }

  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, File paramFile);

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, getTargetFile());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.FileAsyncHttpResponseHandler
 * JD-Core Version:    0.6.2
 */