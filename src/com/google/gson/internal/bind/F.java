package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class F extends TypeAdapter<JsonElement>
{
  private JsonElement a(JsonReader paramJsonReader)
  {
    switch (N.a[paramJsonReader.peek().ordinal()])
    {
    default:
      throw new IllegalArgumentException();
    case 3:
      return new JsonPrimitive(paramJsonReader.nextString());
    case 1:
      return new JsonPrimitive(new LazilyParsedNumber(paramJsonReader.nextString()));
    case 2:
      return new JsonPrimitive(Boolean.valueOf(paramJsonReader.nextBoolean()));
    case 4:
      paramJsonReader.nextNull();
      return JsonNull.INSTANCE;
    case 5:
      JsonArray localJsonArray = new JsonArray();
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext())
        localJsonArray.add(a(paramJsonReader));
      paramJsonReader.endArray();
      return localJsonArray;
    case 6:
    }
    JsonObject localJsonObject = new JsonObject();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
      localJsonObject.add(paramJsonReader.nextName(), a(paramJsonReader));
    paramJsonReader.endObject();
    return localJsonObject;
  }

  private void a(JsonWriter paramJsonWriter, JsonElement paramJsonElement)
  {
    if ((paramJsonElement == null) || (paramJsonElement.isJsonNull()))
    {
      paramJsonWriter.nullValue();
      return;
    }
    if (paramJsonElement.isJsonPrimitive())
    {
      JsonPrimitive localJsonPrimitive = paramJsonElement.getAsJsonPrimitive();
      if (localJsonPrimitive.isNumber())
      {
        paramJsonWriter.value(localJsonPrimitive.getAsNumber());
        return;
      }
      if (localJsonPrimitive.isBoolean())
      {
        paramJsonWriter.value(localJsonPrimitive.getAsBoolean());
        return;
      }
      paramJsonWriter.value(localJsonPrimitive.getAsString());
      return;
    }
    if (paramJsonElement.isJsonArray())
    {
      paramJsonWriter.beginArray();
      Iterator localIterator2 = paramJsonElement.getAsJsonArray().iterator();
      while (localIterator2.hasNext())
        a(paramJsonWriter, (JsonElement)localIterator2.next());
      paramJsonWriter.endArray();
      return;
    }
    if (paramJsonElement.isJsonObject())
    {
      paramJsonWriter.beginObject();
      Iterator localIterator1 = paramJsonElement.getAsJsonObject().entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        paramJsonWriter.name((String)localEntry.getKey());
        a(paramJsonWriter, (JsonElement)localEntry.getValue());
      }
      paramJsonWriter.endObject();
      return;
    }
    throw new IllegalArgumentException("Couldn't write " + paramJsonElement.getClass());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.F
 * JD-Core Version:    0.6.2
 */