package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public enum AccessMethod
{
  private String value;

  static
  {
    AnonReadLoginWrite = new AccessMethod("AnonReadLoginWrite", 2, "AnonReadLoginWrite");
    LoginReadLoginWrite = new AccessMethod("LoginReadLoginWrite", 3, "LoginReadLoginWrite");
    AccessMethod[] arrayOfAccessMethod = new AccessMethod[4];
    arrayOfAccessMethod[0] = AnonReadOwnerWrite;
    arrayOfAccessMethod[1] = LoginReadOwnerWrite;
    arrayOfAccessMethod[2] = AnonReadLoginWrite;
    arrayOfAccessMethod[3] = LoginReadLoginWrite;
  }

  private AccessMethod(String paramString)
  {
    this.value = paramString;
  }

  public static AccessMethod fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_BLANK, "access method is blank");
    if ("AnonReadOwnerWrite".equals(paramString))
      return AnonReadOwnerWrite;
    if ("LoginReadOwnerWrite".equals(paramString))
      return LoginReadOwnerWrite;
    if ("AnonReadLoginWrite".equals(paramString))
      return AnonReadLoginWrite;
    if ("LoginReadLoginWrite".equals(paramString))
      return LoginReadLoginWrite;
    throw new GalaxyClientException(ReturnCode.ACCESS_METHOD_IS_INVALID, paramString);
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AccessMethod
 * JD-Core Version:    0.6.2
 */