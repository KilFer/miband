package com.google.gson;

import java.lang.reflect.Type;

final class h
  implements JsonSerializationContext
{
  h(Gson paramGson)
  {
  }

  public final JsonElement serialize(Object paramObject)
  {
    return this.a.toJsonTree(paramObject);
  }

  public final JsonElement serialize(Object paramObject, Type paramType)
  {
    return this.a.toJsonTree(paramObject, paramType);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.h
 * JD-Core Version:    0.6.2
 */