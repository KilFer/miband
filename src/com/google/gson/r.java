package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

final class r extends TypeAdapter<T>
{
  r(TypeAdapter paramTypeAdapter)
  {
  }

  public final T read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return this.a.read(paramJsonReader);
  }

  public final void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    this.a.write(paramJsonWriter, paramT);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.r
 * JD-Core Version:    0.6.2
 */