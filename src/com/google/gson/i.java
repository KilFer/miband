package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class i extends TypeAdapter<Number>
{
  i(Gson paramGson)
  {
  }

  private static Double a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return Double.valueOf(paramJsonReader.nextDouble());
  }

  private void a(JsonWriter paramJsonWriter, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    double d = paramNumber.doubleValue();
    Gson.a(this.a, d);
    paramJsonWriter.value(paramNumber);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.i
 * JD-Core Version:    0.6.2
 */