package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject extends JsonElement
{
  private final LinkedTreeMap<String, JsonElement> a = new LinkedTreeMap();

  private static JsonElement a(Object paramObject)
  {
    if (paramObject == null)
      return JsonNull.INSTANCE;
    return new JsonPrimitive(paramObject);
  }

  private JsonObject c()
  {
    JsonObject localJsonObject = new JsonObject();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJsonObject.add((String)localEntry.getKey(), ((JsonElement)localEntry.getValue()).a());
    }
    return localJsonObject;
  }

  public final void add(String paramString, JsonElement paramJsonElement)
  {
    if (paramJsonElement == null)
      paramJsonElement = JsonNull.INSTANCE;
    this.a.put(paramString, paramJsonElement);
  }

  public final void addProperty(String paramString, Boolean paramBoolean)
  {
    add(paramString, a(paramBoolean));
  }

  public final void addProperty(String paramString, Character paramCharacter)
  {
    add(paramString, a(paramCharacter));
  }

  public final void addProperty(String paramString, Number paramNumber)
  {
    add(paramString, a(paramNumber));
  }

  public final void addProperty(String paramString1, String paramString2)
  {
    add(paramString1, a(paramString2));
  }

  public final Set<Map.Entry<String, JsonElement>> entrySet()
  {
    return this.a.entrySet();
  }

  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonObject)) && (((JsonObject)paramObject).a.equals(this.a)));
  }

  public final JsonElement get(String paramString)
  {
    return (JsonElement)this.a.get(paramString);
  }

  public final JsonArray getAsJsonArray(String paramString)
  {
    return (JsonArray)this.a.get(paramString);
  }

  public final JsonObject getAsJsonObject(String paramString)
  {
    return (JsonObject)this.a.get(paramString);
  }

  public final JsonPrimitive getAsJsonPrimitive(String paramString)
  {
    return (JsonPrimitive)this.a.get(paramString);
  }

  public final boolean has(String paramString)
  {
    return this.a.containsKey(paramString);
  }

  public final int hashCode()
  {
    return this.a.hashCode();
  }

  public final JsonElement remove(String paramString)
  {
    return (JsonElement)this.a.remove(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonObject
 * JD-Core Version:    0.6.2
 */