package com.google.zxing.client.result;

public final class ProductParsedResult extends ParsedResult
{
  private final String a;
  private final String b;

  private ProductParsedResult(String paramString)
  {
    this(paramString, paramString);
  }

  ProductParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.PRODUCT);
    this.a = paramString1;
    this.b = paramString2;
  }

  public final String getDisplayResult()
  {
    return this.a;
  }

  public final String getNormalizedProductID()
  {
    return this.b;
  }

  public final String getProductID()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ProductParsedResult
 * JD-Core Version:    0.6.2
 */