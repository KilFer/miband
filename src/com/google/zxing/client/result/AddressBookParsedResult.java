package com.google.zxing.client.result;

public final class AddressBookParsedResult extends ParsedResult
{
  private final String[] a;
  private final String b;
  private final String[] c;
  private final String[] d;
  private final String[] e;
  private final String[] f;
  private final String g;
  private final String h;
  private final String[] i;
  private final String[] j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;

  public AddressBookParsedResult(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, String[] paramArrayOfString5, String paramString2, String paramString3, String[] paramArrayOfString6, String[] paramArrayOfString7, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    super(ParsedResultType.ADDRESSBOOK);
    this.a = paramArrayOfString1;
    this.b = paramString1;
    this.c = paramArrayOfString2;
    this.d = paramArrayOfString3;
    this.e = paramArrayOfString4;
    this.f = paramArrayOfString5;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramArrayOfString6;
    this.j = paramArrayOfString7;
    this.k = paramString4;
    this.l = paramString5;
    this.m = paramString6;
    this.n = paramString7;
  }

  public final String[] getAddressTypes()
  {
    return this.j;
  }

  public final String[] getAddresses()
  {
    return this.i;
  }

  public final String getBirthday()
  {
    return this.l;
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    maybeAppend(this.a, localStringBuilder);
    maybeAppend(this.b, localStringBuilder);
    maybeAppend(this.m, localStringBuilder);
    maybeAppend(this.k, localStringBuilder);
    maybeAppend(this.i, localStringBuilder);
    maybeAppend(this.c, localStringBuilder);
    maybeAppend(this.e, localStringBuilder);
    maybeAppend(this.g, localStringBuilder);
    maybeAppend(this.n, localStringBuilder);
    maybeAppend(this.l, localStringBuilder);
    maybeAppend(this.h, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String[] getEmailTypes()
  {
    return this.f;
  }

  public final String[] getEmails()
  {
    return this.e;
  }

  public final String getInstantMessenger()
  {
    return this.g;
  }

  public final String[] getNames()
  {
    return this.a;
  }

  public final String getNote()
  {
    return this.h;
  }

  public final String getOrg()
  {
    return this.k;
  }

  public final String[] getPhoneNumbers()
  {
    return this.c;
  }

  public final String[] getPhoneTypes()
  {
    return this.d;
  }

  public final String getPronunciation()
  {
    return this.b;
  }

  public final String getTitle()
  {
    return this.m;
  }

  public final String getURL()
  {
    return this.n;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AddressBookParsedResult
 * JD-Core Version:    0.6.2
 */