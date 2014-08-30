package com.tencent.b.b;

public final class m$b
  implements Cloneable
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;

  public m$b(m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
  }

  public final Object clone()
  {
    try
    {
      b localb = (b)super.clone();
      return localb;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.m.b
 * JD-Core Version:    0.6.2
 */