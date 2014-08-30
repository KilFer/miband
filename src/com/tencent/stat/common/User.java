package com.tencent.stat.common;

public class User
{
  private String a = null;
  private String b = null;
  private int c;

  public User(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
  }

  public String getMac()
  {
    return this.b;
  }

  public int getType()
  {
    return this.c;
  }

  public String getUid()
  {
    return this.a;
  }

  public void setType(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.User
 * JD-Core Version:    0.6.2
 */