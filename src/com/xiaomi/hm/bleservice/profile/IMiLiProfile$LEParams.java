package com.xiaomi.hm.bleservice.profile;

public final class IMiLiProfile$LEParams
{
  public final int advInt;
  public final int connInt;
  public final int connIntMax;
  public final int connIntMin;
  public final int latency;
  public final int timeout;

  public IMiLiProfile$LEParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.connIntMin = paramInt1;
    this.connIntMax = paramInt2;
    this.latency = paramInt3;
    this.timeout = paramInt4;
    this.connInt = paramInt5;
    this.advInt = paramInt6;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(160);
    localStringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
    localStringBuilder.append("\n  connIntMin: " + (int)(1.25D * this.connIntMin) + "ms");
    localStringBuilder.append("\n  connIntMax: " + (int)(1.25D * this.connIntMax) + "ms");
    localStringBuilder.append("\n     latency: " + this.latency + "ms");
    localStringBuilder.append("\n     timeout: " + 10 * this.timeout + "ms");
    localStringBuilder.append("\n     connInt: " + (int)(1.25D * this.connInt) + "ms");
    localStringBuilder.append("\n      advInt: " + (int)(0.625D * this.advInt) + "ms");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.IMiLiProfile.LEParams
 * JD-Core Version:    0.6.2
 */