package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URI;
import java.net.URISyntaxException;

final class x extends TypeAdapter<URI>
{
  private static URI a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
      paramJsonReader.nextNull();
    while (true)
    {
      return null;
      try
      {
        String str = paramJsonReader.nextString();
        if ("null".equals(str))
          continue;
        URI localURI = new URI(str);
        return localURI;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        throw new JsonIOException(localURISyntaxException);
      }
    }
  }

  private static void a(JsonWriter paramJsonWriter, URI paramURI)
  {
    if (paramURI == null);
    for (String str = null; ; str = paramURI.toASCIIString())
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.x
 * JD-Core Version:    0.6.2
 */