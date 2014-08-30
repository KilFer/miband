package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;

final class A extends TypeAdapter<UUID>
{
  private static UUID a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return UUID.fromString(paramJsonReader.nextString());
  }

  private static void a(JsonWriter paramJsonWriter, UUID paramUUID)
  {
    if (paramUUID == null);
    for (String str = null; ; str = paramUUID.toString())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.A
 * JD-Core Version:    0.6.2
 */