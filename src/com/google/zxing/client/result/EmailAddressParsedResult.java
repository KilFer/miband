package com.google.zxing.client.result;

public final class EmailAddressParsedResult extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;

  EmailAddressParsedResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(ParsedResultType.EMAIL_ADDRESS);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }

  public final String getBody()
  {
    return this.c;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.b, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String getEmailAddress()
  {
    return this.a;
  }

  public final String getMailtoURI()
  {
    return this.d;
  }

  public final String getSubject()
  {
    return this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.EmailAddressParsedResult
 * JD-Core Version:    0.6.2
 */