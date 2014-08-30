package com.google.gson;

import java.lang.reflect.Type;

final class g
  implements JsonDeserializationContext
{
  g(Gson paramGson)
  {
  }

  public final <T> T deserialize(JsonElement paramJsonElement, Type paramType)
  {
    return this.a.fromJson(paramJsonElement, paramType);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.g
 * JD-Core Version:    0.6.2
 */