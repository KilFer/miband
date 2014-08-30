package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult
{
  private final double a;
  private final double b;
  private final double c;
  private final String d;

  GeoParsedResult(double paramDouble1, double paramDouble2, double paramDouble3, String paramString)
  {
    super(ParsedResultType.GEO);
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramString;
  }

  public final double getAltitude()
  {
    return this.c;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    if (this.c > 0.0D)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(this.c);
      localStringBuilder.append('m');
    }
    if (this.d != null)
    {
      localStringBuilder.append(" (");
      localStringBuilder.append(this.d);
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }

  public final String getGeoURI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("geo:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(',');
    localStringBuilder.append(this.b);
    if (this.c > 0.0D)
    {
      localStringBuilder.append(',');
      localStringBuilder.append(this.c);
    }
    if (this.d != null)
    {
      localStringBuilder.append('?');
      localStringBuilder.append(this.d);
    }
    return localStringBuilder.toString();
  }

  public final double getLatitude()
  {
    return this.a;
  }

  public final double getLongitude()
  {
    return this.b;
  }

  public final String getQuery()
  {
    return this.d;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.GeoParsedResult
 * JD-Core Version:    0.6.2
 */