package com.google.gson.internal;

import java.lang.reflect.Method;

final class A extends UnsafeAllocator
{
  A(Method paramMethod, Object paramObject)
  {
  }

  public final <T> T newInstance(Class<T> paramClass)
  {
    return this.a.invoke(this.b, new Object[] { paramClass });
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.A
 * JD-Core Version:    0.6.2
 */