package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.reflect.TypeToken;

final class q
  implements TypeAdapterFactory
{
  private final TypeToken<?> a;
  private final boolean b;
  private final Class<?> c;
  private final JsonSerializer<?> d;
  private final JsonDeserializer<?> e;

  private q(Object paramObject, TypeToken<?> paramTypeToken, boolean paramBoolean, Class<?> paramClass)
  {
    JsonSerializer localJsonSerializer;
    JsonDeserializer localJsonDeserializer;
    if ((paramObject instanceof JsonSerializer))
    {
      localJsonSerializer = (JsonSerializer)paramObject;
      this.d = localJsonSerializer;
      if (!(paramObject instanceof JsonDeserializer))
        break label87;
      localJsonDeserializer = (JsonDeserializer)paramObject;
      label36: this.e = localJsonDeserializer;
      if ((this.d == null) && (this.e == null))
        break label93;
    }
    label87: label93: for (boolean bool = true; ; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      this.a = paramTypeToken;
      this.b = paramBoolean;
      this.c = paramClass;
      return;
      localJsonSerializer = null;
      break;
      localJsonDeserializer = null;
      break label36;
    }
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    boolean bool;
    if (this.a != null)
      if ((this.a.equals(paramTypeToken)) || ((this.b) && (this.a.getType() == paramTypeToken.getRawType())))
        bool = true;
    while (bool)
    {
      return new o(this.d, this.e, paramGson, paramTypeToken, this, (byte)0);
      bool = false;
      continue;
      bool = this.c.isAssignableFrom(paramTypeToken.getRawType());
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.q
 * JD-Core Version:    0.6.2
 */