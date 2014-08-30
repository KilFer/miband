package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class PropertyValuesHolder
  implements Cloneable
{
  private static final TypeEvaluator g = new IntEvaluator();
  private static final TypeEvaluator h = new FloatEvaluator();
  private static Class[] i;
  private static Class[] j;
  private static Class[] k = arrayOfClass3;
  private static final HashMap<Class, HashMap<String, Method>> l = new HashMap();
  private static final HashMap<Class, HashMap<String, Method>> m = new HashMap();
  Method a = null;
  Class b;
  k c = null;
  final Object[] d = new Object[1];
  private String e;
  private Method f = null;
  protected Property mProperty;
  private ReentrantReadWriteLock n = new ReentrantReadWriteLock();
  private TypeEvaluator o;
  private Object p;

  static
  {
    Class[] arrayOfClass1 = new Class[6];
    arrayOfClass1[0] = Float.TYPE;
    arrayOfClass1[1] = Float.class;
    arrayOfClass1[2] = Double.TYPE;
    arrayOfClass1[3] = Integer.TYPE;
    arrayOfClass1[4] = Double.class;
    arrayOfClass1[5] = Integer.class;
    i = arrayOfClass1;
    Class[] arrayOfClass2 = new Class[6];
    arrayOfClass2[0] = Integer.TYPE;
    arrayOfClass2[1] = Integer.class;
    arrayOfClass2[2] = Float.TYPE;
    arrayOfClass2[3] = Double.TYPE;
    arrayOfClass2[4] = Float.class;
    arrayOfClass2[5] = Double.class;
    j = arrayOfClass2;
    Class[] arrayOfClass3 = new Class[6];
    arrayOfClass3[0] = Double.TYPE;
    arrayOfClass3[1] = Double.class;
    arrayOfClass3[2] = Float.TYPE;
    arrayOfClass3[3] = Integer.TYPE;
    arrayOfClass3[4] = Float.class;
    arrayOfClass3[5] = Integer.class;
  }

  private PropertyValuesHolder(Property paramProperty)
  {
    this.mProperty = paramProperty;
    if (paramProperty != null)
      this.e = paramProperty.getName();
  }

  private PropertyValuesHolder(String paramString)
  {
    this.e = paramString;
  }

  private static String a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
      return paramString1;
    char c1 = Character.toUpperCase(paramString2.charAt(0));
    String str = paramString2.substring(1);
    return paramString1 + c1 + str;
  }

  private Method a(Class paramClass1, String paramString, Class paramClass2)
  {
    Method localMethod1 = null;
    String str1 = this.e;
    while (true)
      if (((str1 != null) && (str1.length() != 0)) || (paramClass2 == null))
        try
        {
          Method localMethod4 = paramClass1.getMethod(paramString, null);
          return localMethod4;
          char c1 = Character.toUpperCase(str1.charAt(0));
          String str2 = str1.substring(1);
          paramString = paramString + c1 + str2;
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
        }
    try
    {
      Method localMethod3 = paramClass1.getDeclaredMethod(paramString, null);
      localMethod2 = localMethod3;
      try
      {
        localMethod2.setAccessible(true);
        return localMethod2;
      }
      catch (NoSuchMethodException localNoSuchMethodException5)
      {
      }
      Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.e + ": " + localNoSuchMethodException3);
      return localMethod2;
      Class[] arrayOfClass1 = new Class[1];
      Class[] arrayOfClass2;
      int i1;
      int i2;
      if (this.b.equals(Float.class))
      {
        arrayOfClass2 = i;
        i1 = arrayOfClass2.length;
        i2 = 0;
      }
      while (true)
      {
        if (i2 >= i1)
        {
          Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.e + " with value type " + this.b);
          return localMethod1;
          if (this.b.equals(Integer.class))
          {
            arrayOfClass2 = j;
            break;
          }
          if (this.b.equals(Double.class))
          {
            arrayOfClass2 = k;
            break;
          }
          arrayOfClass2 = new Class[1];
          arrayOfClass2[0] = this.b;
          break;
        }
        Class localClass = arrayOfClass2[i2];
        arrayOfClass1[0] = localClass;
        try
        {
          localMethod1 = paramClass1.getMethod(paramString, arrayOfClass1);
          this.b = localClass;
          return localMethod1;
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          try
          {
            localMethod1 = paramClass1.getDeclaredMethod(paramString, arrayOfClass1);
            localMethod1.setAccessible(true);
            this.b = localClass;
            return localMethod1;
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            i2++;
          }
        }
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      while (true)
        Method localMethod2 = null;
    }
  }

  private Method a(Class paramClass1, HashMap<Class, HashMap<String, Method>> paramHashMap, String paramString, Class paramClass2)
  {
    while (true)
    {
      Method localMethod1;
      try
      {
        this.n.writeLock().lock();
        HashMap localHashMap = (HashMap)paramHashMap.get(paramClass1);
        localMethod1 = null;
        if (localHashMap != null)
          localMethod1 = (Method)localHashMap.get(this.e);
        if (localMethod1 == null)
        {
          Method localMethod2 = a(paramClass1, paramString, paramClass2);
          if (localHashMap == null)
          {
            localHashMap = new HashMap();
            paramHashMap.put(paramClass1, localHashMap);
          }
          localHashMap.put(this.e, localMethod2);
          localMethod3 = localMethod2;
          return localMethod3;
        }
      }
      finally
      {
        this.n.writeLock().unlock();
      }
      Method localMethod3 = localMethod1;
    }
  }

  private void a(Object paramObject, Keyframe paramKeyframe)
  {
    if (this.mProperty != null)
      paramKeyframe.setValue(this.mProperty.get(paramObject));
    try
    {
      if (this.f == null)
        b(paramObject.getClass());
      paramKeyframe.setValue(this.f.invoke(paramObject, new Object[0]));
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

  private void b(Class paramClass)
  {
    this.f = a(paramClass, m, "get", null);
  }

  public static PropertyValuesHolder ofFloat(Property<?, Float> paramProperty, float[] paramArrayOfFloat)
  {
    return new A(paramProperty, paramArrayOfFloat);
  }

  public static PropertyValuesHolder ofFloat(String paramString, float[] paramArrayOfFloat)
  {
    return new A(paramString, paramArrayOfFloat);
  }

  public static PropertyValuesHolder ofInt(Property<?, Integer> paramProperty, int[] paramArrayOfInt)
  {
    return new B(paramProperty, paramArrayOfInt);
  }

  public static PropertyValuesHolder ofInt(String paramString, int[] paramArrayOfInt)
  {
    return new B(paramString, paramArrayOfInt);
  }

  public static PropertyValuesHolder ofKeyframe(Property paramProperty, Keyframe[] paramArrayOfKeyframe)
  {
    k localk = k.a(paramArrayOfKeyframe);
    if ((localk instanceof g))
      return new B(paramProperty, (g)localk);
    if ((localk instanceof f))
      return new A(paramProperty, (f)localk);
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramProperty);
    localPropertyValuesHolder.c = localk;
    localPropertyValuesHolder.b = paramArrayOfKeyframe[0].getType();
    return localPropertyValuesHolder;
  }

  public static PropertyValuesHolder ofKeyframe(String paramString, Keyframe[] paramArrayOfKeyframe)
  {
    k localk = k.a(paramArrayOfKeyframe);
    if ((localk instanceof g))
      return new B(paramString, (g)localk);
    if ((localk instanceof f))
      return new A(paramString, (f)localk);
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramString);
    localPropertyValuesHolder.c = localk;
    localPropertyValuesHolder.b = paramArrayOfKeyframe[0].getType();
    return localPropertyValuesHolder;
  }

  public static <V> PropertyValuesHolder ofObject(Property paramProperty, TypeEvaluator<V> paramTypeEvaluator, V[] paramArrayOfV)
  {
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramProperty);
    localPropertyValuesHolder.setObjectValues(paramArrayOfV);
    localPropertyValuesHolder.setEvaluator(paramTypeEvaluator);
    return localPropertyValuesHolder;
  }

  public static PropertyValuesHolder ofObject(String paramString, TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
  {
    PropertyValuesHolder localPropertyValuesHolder = new PropertyValuesHolder(paramString);
    localPropertyValuesHolder.setObjectValues(paramArrayOfObject);
    localPropertyValuesHolder.setEvaluator(paramTypeEvaluator);
    return localPropertyValuesHolder;
  }

  final void a()
  {
    TypeEvaluator localTypeEvaluator;
    if (this.o == null)
    {
      if (this.b != Integer.class)
        break label44;
      localTypeEvaluator = g;
    }
    while (true)
    {
      this.o = localTypeEvaluator;
      if (this.o != null)
        this.c.d = this.o;
      return;
      label44: if (this.b == Float.class)
        localTypeEvaluator = h;
      else
        localTypeEvaluator = null;
    }
  }

  void a(float paramFloat)
  {
    this.p = this.c.a(paramFloat);
  }

  void a(Class paramClass)
  {
    this.a = a(paramClass, l, "set", this.b);
  }

  final void a(Object paramObject)
  {
    if (this.mProperty != null)
      try
      {
        this.mProperty.get(paramObject);
        Iterator localIterator2 = this.c.c.iterator();
        while (true)
        {
          if (!localIterator2.hasNext())
            return;
          Keyframe localKeyframe2 = (Keyframe)localIterator2.next();
          if (!localKeyframe2.hasValue())
            localKeyframe2.setValue(this.mProperty.get(paramObject));
        }
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("PropertyValuesHolder", "No such property (" + this.mProperty.getName() + ") on target object " + paramObject + ". Trying reflection instead");
        this.mProperty = null;
      }
    Class localClass = paramObject.getClass();
    if (this.a == null)
      a(localClass);
    Iterator localIterator1 = this.c.c.iterator();
    while (localIterator1.hasNext())
    {
      Keyframe localKeyframe1 = (Keyframe)localIterator1.next();
      if (!localKeyframe1.hasValue())
      {
        if (this.f == null)
          b(localClass);
        try
        {
          localKeyframe1.setValue(this.f.invoke(paramObject, new Object[0]));
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
      }
    }
  }

  Object b()
  {
    return this.p;
  }

  final void b(Object paramObject)
  {
    a(paramObject, (Keyframe)this.c.c.get(0));
  }

  final void c(Object paramObject)
  {
    a(paramObject, (Keyframe)this.c.c.get(-1 + this.c.c.size()));
  }

  public PropertyValuesHolder clone()
  {
    try
    {
      PropertyValuesHolder localPropertyValuesHolder = (PropertyValuesHolder)super.clone();
      localPropertyValuesHolder.e = this.e;
      localPropertyValuesHolder.mProperty = this.mProperty;
      localPropertyValuesHolder.c = this.c.a();
      localPropertyValuesHolder.o = this.o;
      return localPropertyValuesHolder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  void d(Object paramObject)
  {
    if (this.mProperty != null)
      this.mProperty.set(paramObject, b());
    if (this.a != null);
    try
    {
      this.d[0] = b();
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

  public String getPropertyName()
  {
    return this.e;
  }

  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    this.o = paramTypeEvaluator;
    this.c.d = paramTypeEvaluator;
  }

  public void setFloatValues(float[] paramArrayOfFloat)
  {
    int i1 = 1;
    this.b = Float.TYPE;
    int i2 = paramArrayOfFloat.length;
    h[] arrayOfh = new h[Math.max(i2, 2)];
    if (i2 == i1)
    {
      arrayOfh[0] = ((h)Keyframe.ofFloat(0.0F));
      arrayOfh[i1] = ((h)Keyframe.ofFloat(1.0F, paramArrayOfFloat[0]));
    }
    while (true)
    {
      this.c = new f(arrayOfh);
      return;
      arrayOfh[0] = ((h)Keyframe.ofFloat(0.0F, paramArrayOfFloat[0]));
      while (i1 < i2)
      {
        arrayOfh[i1] = ((h)Keyframe.ofFloat(i1 / (i2 - 1), paramArrayOfFloat[i1]));
        i1++;
      }
    }
  }

  public void setIntValues(int[] paramArrayOfInt)
  {
    int i1 = 1;
    this.b = Integer.TYPE;
    int i2 = paramArrayOfInt.length;
    i[] arrayOfi = new i[Math.max(i2, 2)];
    if (i2 == i1)
    {
      arrayOfi[0] = ((i)Keyframe.ofInt(0.0F));
      arrayOfi[i1] = ((i)Keyframe.ofInt(1.0F, paramArrayOfInt[0]));
    }
    while (true)
    {
      this.c = new g(arrayOfi);
      return;
      arrayOfi[0] = ((i)Keyframe.ofInt(0.0F, paramArrayOfInt[0]));
      while (i1 < i2)
      {
        arrayOfi[i1] = ((i)Keyframe.ofInt(i1 / (i2 - 1), paramArrayOfInt[i1]));
        i1++;
      }
    }
  }

  public void setKeyframes(Keyframe[] paramArrayOfKeyframe)
  {
    int i1 = 0;
    int i2 = paramArrayOfKeyframe.length;
    Keyframe[] arrayOfKeyframe = new Keyframe[Math.max(i2, 2)];
    this.b = paramArrayOfKeyframe[0].getType();
    while (true)
    {
      if (i1 >= i2)
      {
        this.c = new k(arrayOfKeyframe);
        return;
      }
      arrayOfKeyframe[i1] = paramArrayOfKeyframe[i1];
      i1++;
    }
  }

  public void setObjectValues(Object[] paramArrayOfObject)
  {
    int i1 = 1;
    this.b = paramArrayOfObject[0].getClass();
    int i2 = paramArrayOfObject.length;
    j[] arrayOfj = new j[Math.max(i2, 2)];
    if (i2 == i1)
    {
      arrayOfj[0] = ((j)Keyframe.ofObject(0.0F));
      arrayOfj[i1] = ((j)Keyframe.ofObject(1.0F, paramArrayOfObject[0]));
    }
    while (true)
    {
      this.c = new k(arrayOfj);
      return;
      arrayOfj[0] = ((j)Keyframe.ofObject(0.0F, paramArrayOfObject[0]));
      while (i1 < i2)
      {
        arrayOfj[i1] = ((j)Keyframe.ofObject(i1 / (i2 - 1), paramArrayOfObject[i1]));
        i1++;
      }
    }
  }

  public void setProperty(Property paramProperty)
  {
    this.mProperty = paramProperty;
  }

  public void setPropertyName(String paramString)
  {
    this.e = paramString;
  }

  public String toString()
  {
    return this.e + ": " + this.c.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder
 * JD-Core Version:    0.6.2
 */