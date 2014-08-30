package com.google.gson;

public final class JsonNull extends JsonElement
{
  public static final JsonNull INSTANCE = new JsonNull();

  private static JsonNull c()
  {
    return INSTANCE;
  }

  public final boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject instanceof JsonNull));
  }

  public final int hashCode()
  {
    return JsonNull.class.hashCode();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonNull
 * JD-Core Version:    0.6.2
 */