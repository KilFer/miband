package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter<T> extends TypeAdapter<T>
{
  private final ObjectConstructor<T> a;
  private final Map<String, j> b;

  private ReflectiveTypeAdapterFactory$Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, j> paramMap)
  {
    this.a = paramObjectConstructor;
    this.b = paramMap;
  }

  public final T read(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    Object localObject = this.a.construct();
    try
    {
      paramJsonReader.beginObject();
      while (true)
      {
        if (!paramJsonReader.hasNext())
          break label111;
        String str = paramJsonReader.nextName();
        localj = (j)this.b.get(str);
        if ((localj != null) && (localj.c))
          break;
        paramJsonReader.skipValue();
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
      {
        j localj;
        throw new JsonSyntaxException(localIllegalStateException);
        localj.a(paramJsonReader, localObject);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    label111: paramJsonReader.endObject();
    return localObject;
  }

  public final void write(JsonWriter paramJsonWriter, T paramT)
  {
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginObject();
    try
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (localj.b)
        {
          paramJsonWriter.name(localj.a);
          localj.a(paramJsonWriter, paramT);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError();
    }
    paramJsonWriter.endObject();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
 * JD-Core Version:    0.6.2
 */