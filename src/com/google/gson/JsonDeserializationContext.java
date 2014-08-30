package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializationContext
{
  public abstract <T> T deserialize(JsonElement paramJsonElement, Type paramType);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonDeserializationContext
 * JD-Core Version:    0.6.2
 */