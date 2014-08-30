package com.google.gson.internal;

import java.lang.reflect.Method;

final class B extends UnsafeAllocator
{
  B(Method paramMethod)
  {
  }

  public final <T> T newInstance(Class<T> paramClass)
  {
    return this.a.invoke(null, new Object[] { paramClass, Object.class });
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.B
 * JD-Core Version:    0.6.2
 */