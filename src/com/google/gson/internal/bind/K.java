package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class K extends TypeAdapter<Boolean>
{
  private static Boolean a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    if (paramJsonReader.peek() == JsonToken.STRING)
      return Boolean.valueOf(Boolean.parseBoolean(paramJsonReader.nextString()));
    return Boolean.valueOf(paramJsonReader.nextBoolean());
  }

  private static void a(JsonWriter paramJsonWriter, Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.value(paramBoolean.booleanValue());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.K
 * JD-Core Version:    0.6.2
 */