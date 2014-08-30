package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

final class l<T> extends TypeAdapter<T>
{
  private TypeAdapter<T> a;

  public final void a(TypeAdapter<T> paramTypeAdapter)
  {
    if (this.a != null)
      throw new AssertionError();
    this.a = paramTypeAdapter;
  }

  public final T read(JsonReader paramJsonReader)
  {
    if (this.a == null)
      throw new IllegalStateException();
    return this.a.read(paramJsonReader);
  }

  public final void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (this.a == null)
      throw new IllegalStateException();
    this.a.write(paramJsonWriter, paramT);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.l
 * JD-Core Version:    0.6.2
 */