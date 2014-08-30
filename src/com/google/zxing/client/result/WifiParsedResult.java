package com.google.zxing.client.result;

public final class WifiParsedResult extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;

  public WifiParsedResult(String paramString1, String paramString2, String paramString3)
  {
    super(ParsedResultType.WIFI);
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.b, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String getNetworkEncryption()
  {
    return this.b;
  }

  public final String getPassword()
  {
    return this.c;
  }

  public final String getSsid()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.WifiParsedResult
 * JD-Core Version:    0.6.2
 */