package com.google.zxing.client.result;

public final class TextParsedResult extends ParsedResult
{
  private final String a;
  private final String b;

  public TextParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.TEXT);
    this.a = paramString1;
    this.b = paramString2;
  }

  public final String getDisplayResult()
  {
    return this.a;
  }

  public final String getLanguage()
  {
    return this.b;
  }

  public final String getText()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.TextParsedResult
 * JD-Core Version:    0.6.2
 */