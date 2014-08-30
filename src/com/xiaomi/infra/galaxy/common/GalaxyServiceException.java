package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public class GalaxyServiceException extends GalaxyClientException
{
  private static final long serialVersionUID = 1L;
  private String errorCode;
  private GalaxyServiceException.ErrorType errorType = GalaxyServiceException.ErrorType.Unknown;
  private String serviceName;
  private int statusCode;

  public GalaxyServiceException(ReturnCode paramReturnCode)
  {
    super(paramReturnCode);
  }

  public String getErrorCode()
  {
    return this.errorCode;
  }

  public GalaxyServiceException.ErrorType getErrorType()
  {
    return this.errorType;
  }

  public String getServiceName()
  {
    return this.serviceName;
  }

  public int getStatusCode()
  {
    return this.statusCode;
  }

  public void setErrorCode(String paramString)
  {
    this.errorCode = paramString;
  }

  public void setErrorType(GalaxyServiceException.ErrorType paramErrorType)
  {
    this.errorType = paramErrorType;
  }

  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }

  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }

  public String toString()
  {
    return getClass().getSimpleName() + ": Status Code: " + getStatusCode() + ", Galaxy Service: " + getServiceName() + ", , Galaxy Error Code: " + getErrorCode() + ", Galaxy Error Message: " + getMessage();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.GalaxyServiceException
 * JD-Core Version:    0.6.2
 */