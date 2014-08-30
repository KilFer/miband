package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializer<T>
{
  public abstract T deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonDeserializer
 * JD-Core Version:    0.6.2
 */