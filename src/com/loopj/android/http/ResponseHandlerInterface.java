package com.loopj.android.http;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public abstract interface ResponseHandlerInterface
{
  public abstract Header[] getRequestHeaders();

  public abstract URI getRequestURI();

  public abstract boolean getUseSynchronousMode();

  public abstract void sendCancelMessage();

  public abstract void sendFailureMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);

  public abstract void sendFinishMessage();

  public abstract void sendProgressMessage(int paramInt1, int paramInt2);

  public abstract void sendResponseMessage(HttpResponse paramHttpResponse);

  public abstract void sendRetryMessage(int paramInt);

  public abstract void sendStartMessage();

  public abstract void sendSuccessMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte);

  public abstract void setRequestHeaders(Header[] paramArrayOfHeader);

  public abstract void setRequestURI(URI paramURI);

  public abstract void setUseSynchronousMode(boolean paramBoolean);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.ResponseHandlerInterface
 * JD-Core Version:    0.6.2
 */