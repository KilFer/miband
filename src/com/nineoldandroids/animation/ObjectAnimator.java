package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator
{
  private static final boolean h;
  private static final Map<String, Property> i;
  private Object j;
  private String k;
  private Property l;

  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put("alpha", l.a);
    i.put("pivotX", l.b);
    i.put("pivotY", l.c);
    i.put("translationX", l.d);
    i.put("translationY", l.e);
    i.put("rotation", l.f);
    i.put("rotationX", l.g);
    i.put("rotationY", l.h);
    i.put("scaleX", l.i);
    i.put("scaleY", l.j);
    i.put("scrollX", l.k);
    i.put("scrollY", l.l);
    i.put("x", l.m);
    i.put("y", l.n);
  }

  public ObjectAnimator()
  {
  }

  private <T> ObjectAnimator(T paramT, Property<T, ?> paramProperty)
  {
    this.j = paramT;
    setProperty(paramProperty);
  }

  private ObjectAnimator(Object paramObject, String paramString)
  {
    this.j = paramObject;
    setPropertyName(paramString);
  }

  public static <T> ObjectAnimator ofFloat(T paramT, Property<T, Float> paramProperty, float[] paramArrayOfFloat)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramT, paramProperty);
    localObjectAnimator.setFloatValues(paramArrayOfFloat);
    return localObjectAnimator;
  }

  public static ObjectAnimator ofFloat(Object paramObject, String paramString, float[] paramArrayOfFloat)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramObject, paramString);
    localObjectAnimator.setFloatValues(paramArrayOfFloat);
    return localObjectAnimator;
  }

  public static <T> ObjectAnimator ofInt(T paramT, Property<T, Integer> paramProperty, int[] paramArrayOfInt)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramT, paramProperty);
    localObjectAnimator.setIntValues(paramArrayOfInt);
    return localObjectAnimator;
  }

  public static ObjectAnimator ofInt(Object paramObject, String paramString, int[] paramArrayOfInt)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramObject, paramString);
    localObjectAnimator.setIntValues(paramArrayOfInt);
    return localObjectAnimator;
  }

  public static <T, V> ObjectAnimator ofObject(T paramT, Property<T, V> paramProperty, TypeEvaluator<V> paramTypeEvaluator, V[] paramArrayOfV)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramT, paramProperty);
    localObjectAnimator.setObjectValues(paramArrayOfV);
    localObjectAnimator.setEvaluator(paramTypeEvaluator);
    return localObjectAnimator;
  }

  public static ObjectAnimator ofObject(Object paramObject, String paramString, TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramObject, paramString);
    localObjectAnimator.setObjectValues(paramArrayOfObject);
    localObjectAnimator.setEvaluator(paramTypeEvaluator);
    return localObjectAnimator;
  }

  public static ObjectAnimator ofPropertyValuesHolder(Object paramObject, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.j = paramObject;
    localObjectAnimator.setValues(paramArrayOfPropertyValuesHolder);
    return localObjectAnimator;
  }

  final void a()
  {
    int m;
    if (!this.e)
    {
      if ((this.l == null) && (AnimatorProxy.NEEDS_PROXY) && ((this.j instanceof View)) && (i.containsKey(this.k)))
        setProperty((Property)i.get(this.k));
      m = this.f.length;
    }
    for (int n = 0; ; n++)
    {
      if (n >= m)
      {
        super.a();
        return;
      }
      this.f[n].a(this.j);
    }
  }

  final void a(float paramFloat)
  {
    super.a(paramFloat);
    int m = this.f.length;
    for (int n = 0; ; n++)
    {
      if (n >= m)
        return;
      this.f[n].d(this.j);
    }
  }

  public final ObjectAnimator clone()
  {
    return (ObjectAnimator)super.clone();
  }

  public final String getPropertyName()
  {
    return this.k;
  }

  public final Object getTarget()
  {
    return this.j;
  }

  public final ObjectAnimator setDuration(long paramLong)
  {
    super.setDuration(paramLong);
    return this;
  }

  public final void setFloatValues(float[] paramArrayOfFloat)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.l != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.ofFloat(this.l, paramArrayOfFloat);
        setValues(arrayOfPropertyValuesHolder2);
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.ofFloat(this.k, paramArrayOfFloat);
      setValues(arrayOfPropertyValuesHolder1);
      return;
    }
    super.setFloatValues(paramArrayOfFloat);
  }

  public final void setIntValues(int[] paramArrayOfInt)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.l != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.ofInt(this.l, paramArrayOfInt);
        setValues(arrayOfPropertyValuesHolder2);
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.ofInt(this.k, paramArrayOfInt);
      setValues(arrayOfPropertyValuesHolder1);
      return;
    }
    super.setIntValues(paramArrayOfInt);
  }

  public final void setObjectValues(Object[] paramArrayOfObject)
  {
    if ((this.f == null) || (this.f.length == 0))
    {
      if (this.l != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.ofObject(this.l, null, paramArrayOfObject);
        setValues(arrayOfPropertyValuesHolder2);
        return;
      }
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.ofObject(this.k, null, paramArrayOfObject);
      setValues(arrayOfPropertyValuesHolder1);
      return;
    }
    super.setObjectValues(paramArrayOfObject);
  }

  public final void setProperty(Property paramProperty)
  {
    if (this.f != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.f[0];
      String str = localPropertyValuesHolder.getPropertyName();
      localPropertyValuesHolder.setProperty(paramProperty);
      this.g.remove(str);
      this.g.put(this.k, localPropertyValuesHolder);
    }
    if (this.l != null)
      this.k = paramProperty.getName();
    this.l = paramProperty;
    this.e = false;
  }

  public final void setPropertyName(String paramString)
  {
    if (this.f != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.f[0];
      String str = localPropertyValuesHolder.getPropertyName();
      localPropertyValuesHolder.setPropertyName(paramString);
      this.g.remove(str);
      this.g.put(paramString, localPropertyValuesHolder);
    }
    this.k = paramString;
    this.e = false;
  }

  public final void setTarget(Object paramObject)
  {
    if (this.j != paramObject)
    {
      Object localObject = this.j;
      this.j = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass()));
    }
    else
    {
      return;
    }
    this.e = false;
  }

  public final void setupEndValues()
  {
    a();
    int m = this.f.length;
    for (int n = 0; ; n++)
    {
      if (n >= m)
        return;
      this.f[n].c(this.j);
    }
  }

  public final void setupStartValues()
  {
    a();
    int m = this.f.length;
    for (int n = 0; ; n++)
    {
      if (n >= m)
        return;
      this.f[n].b(this.j);
    }
  }

  public final void start()
  {
    super.start();
  }

  public final String toString()
  {
    String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.j;
    if (this.f != null);
    for (int m = 0; ; m++)
    {
      if (m >= this.f.length)
        return str;
      str = str + "\n    " + this.f[m].toString();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.ObjectAnimator
 * JD-Core Version:    0.6.2
 */