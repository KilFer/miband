package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class a<T, V> extends Property<T, V>
{
  private static final String a = "get";
  private static final String b = "is";
  private static final String c = "set";
  private Method d;
  private Method e;
  private Field f;

  public a(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    super(paramClass1, paramString);
    char c1 = Character.toUpperCase(paramString.charAt(0));
    String str1 = paramString.substring(1);
    String str2 = c1 + str1;
    String str3 = "get" + str2;
    try
    {
      this.e = paramClass.getMethod(str3, null);
      localClass2 = this.e.getReturnType();
      if (!a(paramClass1, localClass2))
        throw new NoSuchPropertyException("Underlying type (" + localClass2 + ") does not match Property type (" + paramClass1 + ")");
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass2;
      try
      {
        this.e = paramClass.getDeclaredMethod(str3, null);
        this.e.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        while (true)
        {
          String str4 = "is" + str2;
          try
          {
            this.e = paramClass.getMethod(str4, null);
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            try
            {
              this.e = paramClass.getDeclaredMethod(str4, null);
              this.e.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              try
              {
                this.f = paramClass.getField(paramString);
                Class localClass1 = this.f.getType();
                if (a(paramClass1, localClass1))
                  break label355;
                throw new NoSuchPropertyException("Underlying type (" + localClass1 + ") does not match Property type (" + paramClass1 + ")");
              }
              catch (NoSuchFieldException localNoSuchFieldException)
              {
                throw new NoSuchPropertyException("No accessor method or field found for property with name " + paramString);
              }
            }
          }
        }
      }
      String str5 = "set" + str2;
      try
      {
        this.d = paramClass.getDeclaredMethod(str5, new Class[] { localClass2 });
        this.d.setAccessible(true);
        label355: return;
      }
      catch (NoSuchMethodException localNoSuchMethodException5)
      {
      }
    }
  }

  private static boolean a(Class<V> paramClass, Class paramClass1)
  {
    if (paramClass1 != paramClass)
      return (paramClass1.isPrimitive()) && (((paramClass1 == Float.TYPE) && (paramClass == Float.class)) || ((paramClass1 == Integer.TYPE) && (paramClass == Integer.class)) || ((paramClass1 == Boolean.TYPE) && (paramClass == Boolean.class)) || ((paramClass1 == Long.TYPE) && (paramClass == Long.class)) || ((paramClass1 == Double.TYPE) && (paramClass == Double.class)) || ((paramClass1 == Short.TYPE) && (paramClass == Short.class)) || ((paramClass1 == Byte.TYPE) && (paramClass == Byte.class)) || ((paramClass1 == Character.TYPE) && (paramClass == Character.class)));
    return true;
  }

  public final V get(T paramT)
  {
    if (this.e != null)
      try
      {
        Object localObject2 = this.e.invoke(paramT, null);
        return localObject2;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
    if (this.f != null)
      try
      {
        Object localObject1 = this.f.get(paramT);
        return localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        throw new AssertionError();
      }
    throw new AssertionError();
  }

  public final boolean isReadOnly()
  {
    return (this.d == null) && (this.f == null);
  }

  public final void set(T paramT, V paramV)
  {
    if (this.d != null)
      try
      {
        this.d.invoke(paramT, new Object[] { paramV });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException.getCause());
      }
    if (this.f != null)
      try
      {
        this.f.set(paramT, paramV);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        throw new AssertionError();
      }
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.util.a
 * JD-Core Version:    0.6.2
 */