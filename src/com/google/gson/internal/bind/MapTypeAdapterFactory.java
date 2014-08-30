package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public final class MapTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor a;
  private final boolean b;

  public MapTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, boolean paramBoolean)
  {
    this.a = paramConstructorConstructor;
    this.b = paramBoolean;
  }

  private static TypeAdapter<?> a(Gson paramGson, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class))
      return TypeAdapters.BOOLEAN_AS_STRING;
    return paramGson.getAdapter(TypeToken.get(paramType));
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Type localType1 = paramTypeToken.getType();
    if (!Map.class.isAssignableFrom(paramTypeToken.getRawType()))
      return null;
    Type[] arrayOfType = .Gson.Types.getMapKeyAndValueTypes(localType1, .Gson.Types.getRawType(localType1));
    Type localType2 = arrayOfType[0];
    if ((localType2 == Boolean.TYPE) || (localType2 == Boolean.class));
    for (TypeAdapter localTypeAdapter1 = TypeAdapters.BOOLEAN_AS_STRING; ; localTypeAdapter1 = paramGson.getAdapter(TypeToken.get(localType2)))
    {
      TypeAdapter localTypeAdapter2 = paramGson.getAdapter(TypeToken.get(arrayOfType[1]));
      ObjectConstructor localObjectConstructor = this.a.get(paramTypeToken);
      return new f(this, paramGson, arrayOfType[0], localTypeAdapter1, arrayOfType[1], localTypeAdapter2, localObjectConstructor);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.MapTypeAdapterFactory
 * JD-Core Version:    0.6.2
 */