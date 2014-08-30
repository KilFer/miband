package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class o<T> extends TypeAdapter<T>
{
  private final JsonSerializer<T> a;
  private final JsonDeserializer<T> b;
  private final Gson c;
  private final TypeToken<T> d;
  private final TypeAdapterFactory e;
  private TypeAdapter<T> f;

  private o(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory)
  {
    this.a = paramJsonSerializer;
    this.b = paramJsonDeserializer;
    this.c = paramGson;
    this.d = paramTypeToken;
    this.e = paramTypeAdapterFactory;
  }

  private TypeAdapter<T> a()
  {
    TypeAdapter localTypeAdapter1 = this.f;
    if (localTypeAdapter1 != null)
      return localTypeAdapter1;
    TypeAdapter localTypeAdapter2 = this.c.getDelegateAdapter(this.e, this.d);
    this.f = localTypeAdapter2;
    return localTypeAdapter2;
  }

  public static TypeAdapterFactory a(TypeToken<?> paramTypeToken, Object paramObject)
  {
    return new q(paramObject, paramTypeToken, false, null, (byte)0);
  }

  public static TypeAdapterFactory a(Class<?> paramClass, Object paramObject)
  {
    return new q(paramObject, null, false, paramClass, (byte)0);
  }

  public static TypeAdapterFactory b(TypeToken<?> paramTypeToken, Object paramObject)
  {
    if (paramTypeToken.getType() == paramTypeToken.getRawType());
    for (boolean bool = true; ; bool = false)
      return new q(paramObject, paramTypeToken, bool, null, (byte)0);
  }

  public final T read(JsonReader paramJsonReader)
  {
    if (this.b == null)
      return a().read(paramJsonReader);
    JsonElement localJsonElement = Streams.parse(paramJsonReader);
    if (localJsonElement.isJsonNull())
      return null;
    return this.b.deserialize(localJsonElement, this.d.getType(), this.c.a);
  }

  public final void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (this.a == null)
    {
      a().write(paramJsonWriter, paramT);
      return;
    }
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    Streams.write(this.a.serialize(paramT, this.d.getType(), this.c.b), paramJsonWriter);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.o
 * JD-Core Version:    0.6.2
 */