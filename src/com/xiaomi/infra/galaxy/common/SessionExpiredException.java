package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.Result;

public class SessionExpiredException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private String additionMessage;
  private ReturnCode returnCode;

  public SessionExpiredException(ReturnCode paramReturnCode)
  {
    this.returnCode = paramReturnCode;
  }

  public SessionExpiredException(ReturnCode paramReturnCode, String paramString)
  {
    super(paramReturnCode.getResult().getCode() + ":" + paramReturnCode.getResult().getMessage() + "," + paramString);
    this.returnCode = paramReturnCode;
    this.additionMessage = paramString;
  }

  public SessionExpiredException(String paramString)
  {
    super(paramString);
  }

  public SessionExpiredException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
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
 * Qualified Name:     com.xiaomi.infra.galaxy.common.SessionExpiredException
 * JD-Core Version:    0.6.2
 */