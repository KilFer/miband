package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class H
  implements TypeAdapterFactory
{
  H(TypeToken paramTypeToken, TypeAdapter paramTypeAdapter)
  {
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    if (paramTypeToken.equals(this.a))
      return this.b;
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.H
 * JD-Core Version:    0.6.2
 */