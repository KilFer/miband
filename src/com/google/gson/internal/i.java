package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

final class i
  implements ObjectConstructor<T>
{
  i(ConstructorConstructor paramConstructorConstructor, Constructor paramConstructor)
  {
  }

  public final T construct()
  {
    try
    {
      Object localObject = this.a.newInstance(null);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.i
 * JD-Core Version:    0.6.2
 */