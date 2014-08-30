package com.google.zxing.client.result;

public final class SMSParsedResult extends ParsedResult
{
  private final String[] a;
  private final String[] b;
  private final String c;
  private final String d;

  public SMSParsedResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(ParsedResultType.SMS);
    this.a = new String[] { paramString1 };
    this.b = new String[] { paramString2 };
    this.c = paramString3;
    this.d = paramString4;
  }

  public SMSParsedResult(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2)
  {
    super(ParsedResultType.SMS);
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.c = paramString1;
    this.d = paramString2;
  }

  public final String getBody()
  {
    return this.d;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    maybeAppend(this.d, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String[] getNumbers()
  {
    return this.a;
  }

  public final String getSMSURI()
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sms:");
    int j = 0;
    int k = i;
    if (j < this.a.length)
    {
      if (k != 0)
        k = 0;
      while (true)
      {
        localStringBuilder.append(this.a[j]);
        if ((this.b != null) && (this.b[j] != null))
        {
          localStringBuilder.append(";via=");
          localStringBuilder.append(this.b[j]);
        }
        j++;
        break;
        localStringBuilder.append(',');
      }
    }
    int m;
    if (this.d != null)
    {
      m = i;
      if (this.c == null)
        break label202;
    }
    while (true)
    {
      if ((m != 0) || (i != 0))
      {
        localStringBuilder.append('?');
        if (m != 0)
        {
          localStringBuilder.append("body=");
          localStringBuilder.append(this.d);
        }
        if (i != 0)
        {
          if (m != 0)
            localStringBuilder.append('&');
          localStringBuilder.append("subject=");
          localStringBuilder.append(this.c);
        }
      }
      return localStringBuilder.toString();
      m = 0;
      break;
      label202: i = 0;
    }
  }

  public final String getSubject()
  {
    return this.c;
  }

  public final String[] getVias()
  {
    return this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.SMSParsedResult
 * JD-Core Version:    0.6.2
 */