package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class L
  implements TypeAdapterFactory
{
  L(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter)
  {
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if ((localClass == this.a) || (localClass == this.b))
      return this.c;
    return null;
  }

  public final String toString()
  {
    return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.L
 * JD-Core Version:    0.6.2
 */