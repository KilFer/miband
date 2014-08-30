package com.google.zxing.client.result;

public final class TelParsedResult extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;

  public TelParsedResult(String paramString1, String paramString2, String paramString3)
  {
    super(ParsedResultType.TEL);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String getNumber()
  {
    return this.a;
  }

  public final String getTelURI()
  {
    return this.b;
  }

  public final String getTitle()
  {
    return this.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.TelParsedResult
 * JD-Core Version:    0.6.2
 */