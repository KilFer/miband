package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe
  implements Cloneable
{
  float a;
  Class b;
  boolean c = false;
  private Interpolator d = null;

  public static Keyframe ofFloat(float paramFloat)
  {
    return new h(paramFloat);
  }

  public static Keyframe ofFloat(float paramFloat1, float paramFloat2)
  {
    return new h(paramFloat1, paramFloat2);
  }

  public static Keyframe ofInt(float paramFloat)
  {
    return new i(paramFloat);
  }

  public static Keyframe ofInt(float paramFloat, int paramInt)
  {
    return new i(paramFloat, paramInt);
  }

  public static Keyframe ofObject(float paramFloat)
  {
    return new j(paramFloat, null);
  }

  public static Keyframe ofObject(float paramFloat, Object paramObject)
  {
    return new j(paramFloat, paramObject);
  }

  public abstract Keyframe clone();

  public float getFraction()
  {
    return this.a;
  }

  public Interpolator getInterpolator()
  {
    return this.d;
  }

  public Class getType()
  {
    return this.b;
  }

  public abstract Object getValue();

  public boolean hasValue()
  {
    return this.c;
  }

  public void setFraction(float paramFloat)
  {
    this.a = paramFloat;
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }

  public abstract void setValue(Object paramObject);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Keyframe
 * JD-Core Version:    0.6.2
 */