package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler
{
  private static final String a = "RangeFileAsyncHttpResponseHandler";
  private long b = 0L;
  private boolean c = false;

  public RangeFileAsyncHttpResponseHandler(File paramFile)
  {
    super(paramFile);
  }

  protected byte[] getResponseData(HttpEntity paramHttpEntity)
  {
    InputStream localInputStream;
    long l;
    FileOutputStream localFileOutputStream;
    if (paramHttpEntity != null)
    {
      localInputStream = paramHttpEntity.getContent();
      l = paramHttpEntity.getContentLength() + this.b;
      localFileOutputStream = new FileOutputStream(getTargetFile(), this.c);
      if (localInputStream == null);
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i;
        if (this.b < l)
        {
          i = localInputStream.read(arrayOfByte);
          if (i != -1)
          {
            boolean bool = Thread.currentThread().isInterrupted();
            if (!bool)
              break label103;
          }
        }
        return null;
        label103: this.b += i;
        localFileOutputStream.write(arrayOfByte, 0, i);
        sendProgressMessage((int)this.b, (int)l);
      }
    }
    finally
    {
      localInputStream.close();
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
  }

  public void sendResponseMessage(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine;
    if (!Thread.currentThread().isInterrupted())
    {
      localStatusLine = paramHttpResponse.getStatusLine();
      if (localStatusLine.getStatusCode() != 416)
        break label55;
      if (!Thread.currentThread().isInterrupted())
        sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null);
    }
    label55: 
    do
    {
      do
      {
        return;
        if (localStatusLine.getStatusCode() < 300)
          break;
      }
      while (Thread.currentThread().isInterrupted());
      sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()));
      return;
    }
    while (Thread.currentThread().isInterrupted());
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Range");
    if (localHeader == null)
    {
      this.c = false;
      this.b = 0L;
    }
    while (true)
    {
      sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), getResponseData(paramHttpResponse.getEntity()));
      return;
      Log.v("RangeFileAsyncHttpResponseHandler", "Content-Rnage: " + localHeader.getValue());
    }
  }

  public void updateRequestHeaders(HttpUriRequest paramHttpUriRequest)
  {
    if ((this.mFile.exists()) && (this.mFile.canWrite()))
      this.b = this.mFile.length();
    if (this.b > 0L)
    {
      this.c = true;
      paramHttpUriRequest.setHeader("Range", "bytes=" + this.b + "-");
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RangeFileAsyncHttpResponseHandler
 * JD-Core Version:    0.6.2
 */