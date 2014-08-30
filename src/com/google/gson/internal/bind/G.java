package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class G
  implements TypeAdapterFactory
{
  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if ((!Enum.class.isAssignableFrom(localClass)) || (localClass == Enum.class))
      return null;
    if (!localClass.isEnum())
      localClass = localClass.getSuperclass();
    return new U(localClass);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.G
 * JD-Core Version:    0.6.2
 */