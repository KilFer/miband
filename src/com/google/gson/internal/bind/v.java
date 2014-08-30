package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class v extends TypeAdapter<StringBuffer>
{
  private static StringBuffer a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return new StringBuffer(paramJsonReader.nextString());
  }

  private static void a(JsonWriter paramJsonWriter, StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null);
    for (String str = null; ; str = paramStringBuffer.toString())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.v
 * JD-Core Version:    0.6.2
 */