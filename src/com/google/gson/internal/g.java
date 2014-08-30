package com.google.gson.internal;

import java.lang.reflect.Type;

final class g
  implements ObjectConstructor<T>
{
  private final UnsafeAllocator a = UnsafeAllocator.create();

  g(ConstructorConstructor paramConstructorConstructor, Class paramClass, Type paramType)
  {
  }

  public final T construct()
  {
    try
    {
      Object localObject = this.a.newInstance(this.b);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + this.c + ". Register an InstanceCreator with Gson for this type may fix this problem.", localException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.g
 * JD-Core Version:    0.6.2
 */