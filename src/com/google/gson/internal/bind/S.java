package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class S extends TypeAdapter<Number>
{
  private static Number a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    try
    {
      Long localLong = Long.valueOf(paramJsonReader.nextLong());
      return localLong;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new JsonSyntaxException(localNumberFormatException);
    }
  }

  private static void a(JsonWriter paramJsonWriter, Number paramNumber)
  {
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.S
 * JD-Core Version:    0.6.2
 */