package com.nineoldandroids.animation;

final class j extends Keyframe
{
  private Object d;

  j(float paramFloat, Object paramObject)
  {
    this.a = paramFloat;
    this.d = paramObject;
    boolean bool;
    if (paramObject != null)
    {
      bool = true;
      this.c = bool;
      if (!this.c)
        break label50;
    }
    label50: for (Object localObject = paramObject.getClass(); ; localObject = Object.class)
    {
      this.b = ((Class)localObject);
      return;
      bool = false;
      break;
    }
  }

  private j a()
  {
    j localj = new j(getFraction(), this.d);
    localj.setInterpolator(getInterpolator());
    return localj;
  }

  public final Object getValue()
  {
    return this.d;
  }

  public final void setValue(Object paramObject)
  {
    this.d = paramObject;
    if (paramObject != null);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.j
 * JD-Core Version:    0.6.2
 */