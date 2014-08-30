package com.nineoldandroids.animation;

final class i extends Keyframe
{
  private int d;

  i(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Integer.TYPE;
  }

  i(float paramFloat, int paramInt)
  {
    this.a = paramFloat;
    this.d = paramInt;
    this.b = Integer.TYPE;
    this.c = true;
  }

  private i b()
  {
    i locali = new i(getFraction(), this.d);
    locali.setInterpolator(getInterpolator());
    return locali;
  }

  public final int a()
  {
    return this.d;
  }

  public final Object getValue()
  {
    return Integer.valueOf(this.d);
  }

  public final void setValue(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Integer.class))
    {
      this.d = ((Integer)paramObject).intValue();
      this.c = true;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.i
 * JD-Core Version:    0.6.2
 */