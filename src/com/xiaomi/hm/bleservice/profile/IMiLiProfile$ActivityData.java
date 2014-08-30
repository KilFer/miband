package com.xiaomi.hm.bleservice.profile;

public final class IMiLiProfile$ActivityData
{
  public static final int N = 3;
  public int category = 0;
  public int intensity = 0;
  public int steps = 0;

  public IMiLiProfile$ActivityData(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.intensity = paramByte1;
    this.steps = paramByte2;
    this.category = paramByte3;
  }

  public final String toString()
  {
    return "ActivityData [intensity=" + this.intensity + ", steps=" + this.steps + ", category=" + this.category + "]";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData
 * JD-Core Version:    0.6.2
 */