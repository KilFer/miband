package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

final class k
  implements ObjectConstructor<T>
{
  k(ConstructorConstructor paramConstructorConstructor, Type paramType)
  {
  }

  public final T construct()
  {
    if ((this.a instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)this.a).getActualTypeArguments()[0];
      if ((localType instanceof Class))
        return EnumSet.noneOf((Class)localType);
      throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
    }
    throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.k
 * JD-Core Version:    0.6.2
 */