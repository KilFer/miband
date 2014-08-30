package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

final class h
  implements ObjectConstructor<T>
{
  h(ConstructorConstructor paramConstructorConstructor, InstanceCreator paramInstanceCreator, Type paramType)
  {
  }

  public final T construct()
  {
    return this.a.createInstance(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.h
 * JD-Core Version:    0.6.2
 */