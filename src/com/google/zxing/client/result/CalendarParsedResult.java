package com.google.zxing.client.result;

public final class CalendarParsedResult extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final double g;
  private final double h;

  public CalendarParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, (0.0D / 0.0D), (0.0D / 0.0D));
  }

  public CalendarParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, double paramDouble2)
  {
    super(ParsedResultType.CALENDAR);
    a(paramString2);
    this.a = paramString1;
    this.b = paramString2;
    if (paramString3 != null)
      a(paramString3);
    for (this.c = paramString3; ; this.c = null)
    {
      this.d = paramString4;
      this.e = paramString5;
      this.f = paramString6;
      this.g = paramDouble1;
      this.h = paramDouble2;
      return;
    }
  }

  private static void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      int i = paramCharSequence.length();
      if ((i != 8) && (i != 15) && (i != 16))
        throw new IllegalArgumentException();
      for (int j = 0; j < 8; j++)
        if (!Character.isDigit(paramCharSequence.charAt(j)))
          throw new IllegalArgumentException();
      if (i > 8)
      {
        if (paramCharSequence.charAt(8) != 'T')
          throw new IllegalArgumentException();
        for (int k = 9; k < 15; k++)
          if (!Character.isDigit(paramCharSequence.charAt(k)))
            throw new IllegalArgumentException();
        if ((i == 16) && (paramCharSequence.charAt(15) != 'Z'))
          throw new IllegalArgumentException();
      }
    }
  }

  public final String getAttendee()
  {
    return this.e;
  }

  public final String getDescription()
  {
    return this.f;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.b, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    maybeAppend(this.d, localStringBuilder);
    maybeAppend(this.e, localStringBuilder);
    maybeAppend(this.f, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String getEnd()
  {
    return this.c;
  }

  public final double getLatitude()
  {
    return this.g;
  }

  public final String getLocation()
  {
    return this.d;
  }

  public final double getLongitude()
  {
    return this.h;
  }

  public final String getStart()
  {
    return this.b;
  }

  public final String getSummary()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.CalendarParsedResult
 * JD-Core Version:    0.6.2
 */