package com.xiaomi.hm.bleservice.profile;

public final class IMiLiProfile$Usage
{
  public final int adv;
  public final int conn;
  public final int light;
  public final int vibrate;
  public final int wake;

  public IMiLiProfile$Usage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.wake = paramInt1;
    this.vibrate = paramInt2;
    this.light = paramInt3;
    this.conn = paramInt4;
    this.adv = paramInt5;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder.append("\n     wake: " + this.wake + "ms");
    localStringBuilder.append("\n  vibrate: " + this.vibrate + "ms");
    localStringBuilder.append("\n    light: " + this.light + "ms");
    localStringBuilder.append("\n     conn: " + this.conn + "s");
    localStringBuilder.append("\n      adv: " + this.adv + "s");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.Usage
 * JD-Core Version:    0.6.2
 */