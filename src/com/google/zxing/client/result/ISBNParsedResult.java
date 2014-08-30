package com.google.zxing.client.result;

public final class ISBNParsedResult extends ParsedResult
{
  private final String a;

  ISBNParsedResult(String paramString)
  {
    super(ParsedResultType.ISBN);
    this.a = paramString;
  }

  public final String getDisplayResult()
  {
    return this.a;
  }

  public final String getISBN()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ISBNParsedResult
 * JD-Core Version:    0.6.2
 */