package com.xiaomi.hm.bleservice.profile;

public final class IMiLiProfile$UserInfo
{
  public static final byte CLEAR_DATA = 1;
  public static final byte NORMAL = 0;
  public static final byte RETAIN_DATA = 2;
  public static final UserInfo SAMPLE = new UserInfo(170420175, (byte)0, (byte)23, (byte)-88, (byte)50, "".getBytes());
  public final byte age;
  public final byte[] alias;
  public final byte gender;
  public final byte height;
  public final byte type;
  public final int uid;
  public final byte weight;

  public IMiLiProfile$UserInfo(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte[] paramArrayOfByte)
  {
    this.uid = paramInt;
    this.gender = paramByte1;
    this.age = paramByte2;
    this.height = paramByte3;
    this.weight = paramByte4;
    this.alias = paramArrayOfByte;
    this.type = paramByte5;
  }

  public IMiLiProfile$UserInfo(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte[] paramArrayOfByte)
  {
    this.uid = paramInt;
    this.gender = paramByte1;
    this.age = paramByte2;
    this.height = paramByte3;
    this.weight = paramByte4;
    this.alias = paramArrayOfByte;
    this.type = 0;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder1.append("\n     uid: " + this.uid);
    StringBuilder localStringBuilder2 = new StringBuilder("\n  gender: ");
    if (this.gender == 0);
    for (String str = "female"; ; str = "male")
    {
      localStringBuilder1.append(str);
      localStringBuilder1.append("\n     age: " + this.age + "yrs");
      localStringBuilder1.append("\n  height: " + (0xFF & this.height) + "cm");
      localStringBuilder1.append("\n  weight: " + (0xFF & this.weight) + "kg");
      localStringBuilder1.append("\n   alias: " + new String(this.alias));
      return localStringBuilder1.toString();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo
 * JD-Core Version:    0.6.2
 */