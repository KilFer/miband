package com.xiaomi.account.openauth.utils;

import java.util.Map;

public class Network$HttpHeaderInfo
{
  public Map<String, String> AllHeaders;
  public String ContentType;
  public int ResponseCode;
  public String UserAgent;
  public String realUrl;

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.ResponseCode);
    arrayOfObject[1] = this.AllHeaders.toString();
    return String.format("resCode = %1$d, headers = %2$s", arrayOfObject);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.utils.Network.HttpHeaderInfo
 * JD-Core Version:    0.6.2
 */