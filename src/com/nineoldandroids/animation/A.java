package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class A extends PropertyValuesHolder
{
  private FloatProperty e;
  private f f;
  private float g;

  public A(Property paramProperty, f paramf)
  {
    super(paramProperty, (byte)0);
    this.b = Float.TYPE;
    this.c = paramf;
    this.f = ((f)this.c);
    if ((paramProperty instanceof FloatProperty))
      this.e = ((FloatProperty)this.mProperty);
  }

  public A(Property paramProperty, float[] paramArrayOfFloat)
  {
    super(paramProperty, (byte)0);
    setFloatValues(paramArrayOfFloat);
    if ((paramProperty instanceof FloatProperty))
      this.e = ((FloatProperty)this.mProperty);
  }

  public A(String paramString, f paramf)
  {
    super(paramString, (byte)0);
    this.b = Float.TYPE;
    this.c = paramf;
    this.f = ((f)this.c);
  }

  public A(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString, (byte)0);
    setFloatValues(paramArrayOfFloat);
  }

  private A c()
  {
    A localA = (A)super.clone();
    localA.f = ((f)localA.c);
    return localA;
  }

  final void a(float paramFloat)
  {
    this.g = this.f.b(paramFloat);
  }

  final void a(Class paramClass)
  {
    if (this.mProperty != null)
      return;
    super.a(paramClass);
  }

  final Object b()
  {
    return Float.valueOf(this.g);
  }

  final void d(Object paramObject)
  {
    if (this.e != null)
      this.e.setValue(paramObject, this.g);
    do
    {
      return;
      if (this.mProperty != null)
      {
        this.mProperty.set(paramObject, Float.valueOf(this.g));
        return;
      }
    }
    while (this.a == null);
    try
    {
      this.d[0] = Float.valueOf(this.g);
      this.a.invoke(paramObject, this.d);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
    }
  }

  public final void setFloatValues(float[] paramArrayOfFloat)
  {
    super.setFloatValues(paramArrayOfFloat);
    this.f = ((f)this.c);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.A
 * JD-Core Version:    0.6.2
 */