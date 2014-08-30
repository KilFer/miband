package com.google.zxing.client.result;

import java.util.Map;

public final class ExpandedProductParsedResult extends ParsedResult
{
  public static final String KILOGRAM = "KG";
  public static final String POUND = "LB";
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final Map<String, String> n;

  public ExpandedProductParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, Map<String, String> paramMap)
  {
    super(ParsedResultType.PRODUCT);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
    this.l = paramString12;
    this.m = paramString13;
    this.n = paramMap;
  }

  private static int a(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }

  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ExpandedProductParsedResult));
    ExpandedProductParsedResult localExpandedProductParsedResult;
    do
    {
      return false;
      localExpandedProductParsedResult = (ExpandedProductParsedResult)paramObject;
    }
    while ((!a(this.a, localExpandedProductParsedResult.a)) || (!a(this.b, localExpandedProductParsedResult.b)) || (!a(this.c, localExpandedProductParsedResult.c)) || (!a(this.d, localExpandedProductParsedResult.d)) || (!a(this.f, localExpandedProductParsedResult.f)) || (!a(this.g, localExpandedProductParsedResult.g)) || (!a(this.h, localExpandedProductParsedResult.h)) || (!a(this.i, localExpandedProductParsedResult.i)) || (!a(this.j, localExpandedProductParsedResult.j)) || (!a(this.k, localExpandedProductParsedResult.k)) || (!a(this.l, localExpandedProductParsedResult.l)) || (!a(this.m, localExpandedProductParsedResult.m)) || (!a(this.n, localExpandedProductParsedResult.n)));
    return true;
  }

  public final String getBestBeforeDate()
  {
    return this.f;
  }

  public final String getDisplayResult()
  {
    return String.valueOf(this.a);
  }

  public final String getExpirationDate()
  {
    return this.g;
  }

  public final String getLotNumber()
  {
    return this.c;
  }

  public final String getPackagingDate()
  {
    return this.e;
  }

  public final String getPrice()
  {
    return this.k;
  }

  public final String getPriceCurrency()
  {
    return this.m;
  }

  public final String getPriceIncrement()
  {
    return this.l;
  }

  public final String getProductID()
  {
    return this.a;
  }

  public final String getProductionDate()
  {
    return this.d;
  }

  public final String getSscc()
  {
    return this.b;
  }

  public final Map<String, String> getUncommonAIs()
  {
    return this.n;
  }

  public final String getWeight()
  {
    return this.h;
  }

  public final String getWeightIncrement()
  {
    return this.j;
  }

  public final String getWeightType()
  {
    return this.i;
  }

  public final int hashCode()
  {
    return 0x0 ^ a(this.a) ^ a(this.b) ^ a(this.c) ^ a(this.d) ^ a(this.f) ^ a(this.g) ^ a(this.h) ^ a(this.i) ^ a(this.j) ^ a(this.k) ^ a(this.l) ^ a(this.m) ^ a(this.n);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ExpandedProductParsedResult
 * JD-Core Version:    0.6.2
 */