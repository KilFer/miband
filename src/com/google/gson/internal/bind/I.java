package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class I
  implements TypeAdapterFactory
{
  I(Class paramClass, TypeAdapter paramTypeAdapter)
  {
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.getRawType() == this.a)
      return this.b;
    return null;
  }

  public final String toString()
  {
    return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.I
 * JD-Core Version:    0.6.2
 */