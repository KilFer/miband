package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor a;

  public CollectionTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor)
  {
    this.a = paramConstructorConstructor;
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Type localType1 = paramTypeToken.getType();
    Class localClass = paramTypeToken.getRawType();
    if (!Collection.class.isAssignableFrom(localClass))
      return null;
    Type localType2 = .Gson.Types.getCollectionElementType(localType1, localClass);
    return new b(paramGson, localType2, paramGson.getAdapter(TypeToken.get(localType2)), this.a.get(paramTypeToken));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.CollectionTypeAdapterFactory
 * JD-Core Version:    0.6.2
 */