package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class p extends TypeAdapter<T>
{
  private TypeAdapter<T> a;

  p(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, TypeToken paramTypeToken)
  {
  }

  private TypeAdapter<T> a()
  {
    TypeAdapter localTypeAdapter1 = this.a;
    if (localTypeAdapter1 != null)
      return localTypeAdapter1;
    TypeAdapter localTypeAdapter2 = this.d.getDelegateAdapter(this.f, this.e);
    this.a = localTypeAdapter2;
    return localTypeAdapter2;
  }

  public final T read(JsonReader paramJsonReader)
  {
    if (this.b)
    {
      paramJsonReader.skipValue();
      return null;
    }
    return a().read(paramJsonReader);
  }

  public final void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (this.c)
    {
      paramJsonWriter.nullValue();
      return;
    }
    a().write(paramJsonWriter, paramT);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.p
 * JD-Core Version:    0.6.2
 */