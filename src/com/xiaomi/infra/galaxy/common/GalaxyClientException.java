package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.Result;

public class GalaxyClientException extends Exception
{
  private static final long serialVersionUID = 1L;
  private String additionMessage;
  private ReturnCode returnCode;

  public GalaxyClientException(ReturnCode paramReturnCode)
  {
    this.returnCode = paramReturnCode;
  }

  public GalaxyClientException(ReturnCode paramReturnCode, String paramString)
  {
    super(paramReturnCode.getResult().getCode() + ":" + paramReturnCode.getResult().getMessage() + "," + paramString);
    this.returnCode = paramReturnCode;
    this.additionMessage = paramString;
  }

  public GalaxyClientException(ReturnCode paramReturnCode, String paramString, Throwable paramThrowable)
  {
    super(paramReturnCode.getResult().getCode() + ":" + paramReturnCode.getResult().getMessage() + "," + paramString, paramThrowable);
    this.returnCode = paramReturnCode;
    this.additionMessage = paramString;
  }

  public String getAdditionMessage()
  {
    return this.additionMessage;
  }

  public ReturnCode getReturnCode()
  {
    return this.returnCode;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.GalaxyClientException
 * JD-Core Version:    0.6.2
 */