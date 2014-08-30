package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class j extends TypeAdapter<Number>
{
  j(Gson paramGson)
  {
  }

  private static Float a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Float.valueOf((float)paramJsonReader.nextDouble());
  }

  private void a(JsonWriter paramJsonWriter, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    float f = paramNumber.floatValue();
    Gson.a(this.a, f);
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.j
 * JD-Core Version:    0.6.2
 */