package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class B extends PropertyValuesHolder
{
  private IntProperty e;
  private g f;
  private int g;

  public B(Property paramProperty, g paramg)
  {
    super(paramProperty, (byte)0);
    this.b = Integer.TYPE;
    this.c = paramg;
    this.f = ((g)this.c);
    if ((paramProperty instanceof IntProperty))
      this.e = ((IntProperty)this.mProperty);
  }

  public B(Property paramProperty, int[] paramArrayOfInt)
  {
    super(paramProperty, (byte)0);
    setIntValues(paramArrayOfInt);
    if ((paramProperty instanceof IntProperty))
      this.e = ((IntProperty)this.mProperty);
  }

  public B(String paramString, g paramg)
  {
    super(paramString, (byte)0);
    this.b = Integer.TYPE;
    this.c = paramg;
    this.f = ((g)this.c);
  }

  public B(String paramString, int[] paramArrayOfInt)
  {
    super(paramString, (byte)0);
    setIntValues(paramArrayOfInt);
  }

  private B c()
  {
    B localB = (B)super.clone();
    localB.f = ((g)localB.c);
    return localB;
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
    return Integer.valueOf(this.g);
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
        this.mProperty.set(paramObject, Integer.valueOf(this.g));
        return;
      }
    }
    while (this.a == null);
    try
    {
      this.d[0] = Integer.valueOf(this.g);
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

  public final void setIntValues(int[] paramArrayOfInt)
  {
    super.setIntValues(paramArrayOfInt);
    this.f = ((g)this.c);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.B
 * JD-Core Version:    0.6.2
 */