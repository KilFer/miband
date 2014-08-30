package com.xiaomi.infra.galaxy.common;

public enum Protocol
{
  private final String protocol;

  static
  {
    Protocol[] arrayOfProtocol = new Protocol[2];
    arrayOfProtocol[0] = HTTP;
    arrayOfProtocol[1] = HTTPS;
  }

  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }

  public final String toString()
  {
    return this.protocol;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.Protocol
 * JD-Core Version:    0.6.2
 */