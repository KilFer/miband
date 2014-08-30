package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class k extends TypeAdapter<Number>
{
  k(Gson paramGson)
  {
  }

  private static Number a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Long.valueOf(paramJsonReader.nextLong());
  }

  private static void a(JsonWriter paramJsonWriter, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.value(paramNumber.toString());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.k
 * JD-Core Version:    0.6.2
 */