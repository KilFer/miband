package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URL;

final class w extends TypeAdapter<URL>
{
  private static URL a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
      paramJsonReader.nextNull();
    String str;
    do
    {
      return null;
      str = paramJsonReader.nextString();
    }
    while ("null".equals(str));
    return new URL(str);
  }

  private static void a(JsonWriter paramJsonWriter, URL paramURL)
  {
    if (paramURL == null);
    for (String str = null; ; str = paramURL.toExternalForm())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.w
 * JD-Core Version:    0.6.2
 */