package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator
{
  public static UnsafeAllocator create()
  {
    try
    {
      Class localClass = Class.forName("sun.misc.Unsafe");
      Field localField = localClass.getDeclaredField("theUnsafe");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      A localA = new A(localClass.getMethod("allocateInstance", new Class[] { Class.class }), localObject);
      return localA;
    }
    catch (Exception localException1)
    {
      try
      {
        Method localMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
        localMethod3.setAccessible(true);
        B localB = new B(localMethod3);
        return localB;
      }
      catch (Exception localException2)
      {
        try
        {
          Method localMethod1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
          localMethod1.setAccessible(true);
          int i = ((Integer)localMethod1.invoke(null, new Object[] { Object.class })).intValue();
          Class[] arrayOfClass = new Class[2];
          arrayOfClass[0] = Class.class;
          arrayOfClass[1] = Integer.TYPE;
          Method localMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrayOfClass);
          localMethod2.setAccessible(true);
          C localC = new C(localMethod2, i);
          return localC;
        }
        catch (Exception localException3)
        {
        }
      }
    }
    return new D();
  }

  public abstract <T> T newInstance(Class<T> paramClass);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator
 * JD-Core Version:    0.6.2
 */