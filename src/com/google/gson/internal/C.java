package com.google.gson.internal;

import java.lang.reflect.Method;

final class C extends UnsafeAllocator
{
  C(Method paramMethod, int paramInt)
  {
  }

  public final <T> T newInstance(Class<T> paramClass)
  {
    Method localMethod = this.a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramClass;
    arrayOfObject[1] = Integer.valueOf(this.b);
    return localMethod.invoke(null, arrayOfObject);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.C
 * JD-Core Version:    0.6.2
 */