package com.tencent.utils;

public class Util$Statistic
{
  public long reqSize;
  public String response;
  public long rspSize;

  public Util$Statistic(String paramString, int paramInt)
  {
    this.response = paramString;
    this.reqSize = paramInt;
    if (this.response != null)
      this.rspSize = this.response.length();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.Util.Statistic
 * JD-Core Version:    0.6.2
 */