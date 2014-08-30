package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

public abstract class JsonReaderInternalAccess
{
  public static JsonReaderInternalAccess INSTANCE;

  public abstract void promoteNameToValue(JsonReader paramJsonReader);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.JsonReaderInternalAccess
 * JD-Core Version:    0.6.2
 */