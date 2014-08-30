package com.umeng.analytics;

import u.aly.ap;

public enum Gender
{
  public int value;

  static
  {
    Female = new i("Female", 1, 2);
    Unknown = new j("Unknown", 2, 0);
    Gender[] arrayOfGender = new Gender[3];
    arrayOfGender[0] = Male;
    arrayOfGender[1] = Female;
    arrayOfGender[2] = Unknown;
  }

  private Gender(int arg3)
  {
    int j;
    this.value = j;
  }

  public static Gender getGender(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Unknown;
    case 1:
      return Male;
    case 2:
    }
    return Female;
  }

  public static ap transGender(Gender paramGender)
  {
    switch (a()[paramGender.ordinal()])
    {
    default:
      return ap.c;
    case 1:
      return ap.a;
    case 2:
    }
    return ap.b;
  }

  public int value()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.Gender
 * JD-Core Version:    0.6.2
 */