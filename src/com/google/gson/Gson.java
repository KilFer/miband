package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Gson
{
  private static boolean c = false;
  private static final String d = ")]}'\n";
  final JsonDeserializationContext a = new g(this);
  final JsonSerializationContext b = new h(this);
  private final ThreadLocal<Map<TypeToken<?>, l<?>>> e = new ThreadLocal();
  private final Map<TypeToken<?>, TypeAdapter<?>> f = Collections.synchronizedMap(new HashMap());
  private final List<TypeAdapterFactory> g;
  private final ConstructorConstructor h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final boolean l;

  public Gson()
  {
    this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
  }

  Gson(Excluder paramExcluder, FieldNamingStrategy paramFieldNamingStrategy, Map<Type, InstanceCreator<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, LongSerializationPolicy paramLongSerializationPolicy, List<TypeAdapterFactory> paramList)
  {
    this.h = new ConstructorConstructor(paramMap);
    this.i = paramBoolean1;
    this.k = paramBoolean3;
    this.j = paramBoolean4;
    this.l = paramBoolean5;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
    localArrayList.add(ObjectTypeAdapter.FACTORY);
    localArrayList.add(paramExcluder);
    localArrayList.addAll(paramList);
    localArrayList.add(TypeAdapters.STRING_FACTORY);
    localArrayList.add(TypeAdapters.INTEGER_FACTORY);
    localArrayList.add(TypeAdapters.BOOLEAN_FACTORY);
    localArrayList.add(TypeAdapters.BYTE_FACTORY);
    localArrayList.add(TypeAdapters.SHORT_FACTORY);
    Class localClass1 = Long.TYPE;
    Object localObject1;
    Object localObject2;
    label244: Class localClass3;
    if (paramLongSerializationPolicy == LongSerializationPolicy.DEFAULT)
    {
      localObject1 = TypeAdapters.LONG;
      localArrayList.add(TypeAdapters.newFactory(localClass1, Long.class, (TypeAdapter)localObject1));
      Class localClass2 = Double.TYPE;
      if (!paramBoolean6)
        break label607;
      localObject2 = TypeAdapters.DOUBLE;
      localArrayList.add(TypeAdapters.newFactory(localClass2, Double.class, (TypeAdapter)localObject2));
      localClass3 = Float.TYPE;
      if (!paramBoolean6)
        break label620;
    }
    label607: label620: for (Object localObject3 = TypeAdapters.FLOAT; ; localObject3 = new j(this))
    {
      localArrayList.add(TypeAdapters.newFactory(localClass3, Float.class, (TypeAdapter)localObject3));
      localArrayList.add(TypeAdapters.NUMBER_FACTORY);
      localArrayList.add(TypeAdapters.CHARACTER_FACTORY);
      localArrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
      localArrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
      localArrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
      localArrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
      localArrayList.add(TypeAdapters.URL_FACTORY);
      localArrayList.add(TypeAdapters.URI_FACTORY);
      localArrayList.add(TypeAdapters.UUID_FACTORY);
      localArrayList.add(TypeAdapters.LOCALE_FACTORY);
      localArrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
      localArrayList.add(TypeAdapters.BIT_SET_FACTORY);
      localArrayList.add(DateTypeAdapter.FACTORY);
      localArrayList.add(TypeAdapters.CALENDAR_FACTORY);
      localArrayList.add(TimeTypeAdapter.FACTORY);
      localArrayList.add(SqlDateTypeAdapter.FACTORY);
      localArrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
      localArrayList.add(ArrayTypeAdapter.FACTORY);
      localArrayList.add(TypeAdapters.ENUM_FACTORY);
      localArrayList.add(TypeAdapters.CLASS_FACTORY);
      localArrayList.add(new CollectionTypeAdapterFactory(this.h));
      localArrayList.add(new MapTypeAdapterFactory(this.h, paramBoolean2));
      localArrayList.add(new ReflectiveTypeAdapterFactory(this.h, paramFieldNamingStrategy, paramExcluder));
      this.g = Collections.unmodifiableList(localArrayList);
      return;
      localObject1 = new k(this);
      break;
      localObject2 = new i(this);
      break label244;
    }
  }

  private TypeAdapter<Number> a(LongSerializationPolicy paramLongSerializationPolicy)
  {
    if (paramLongSerializationPolicy == LongSerializationPolicy.DEFAULT)
      return TypeAdapters.LONG;
    return new k(this);
  }

  private TypeAdapter<Number> a(boolean paramBoolean)
  {
    if (paramBoolean)
      return TypeAdapters.DOUBLE;
    return new i(this);
  }

  private JsonWriter a(Writer paramWriter)
  {
    if (this.k)
      paramWriter.write(")]}'\n");
    JsonWriter localJsonWriter = new JsonWriter(paramWriter);
    if (this.l)
      localJsonWriter.setIndent("  ");
    localJsonWriter.setSerializeNulls(this.i);
    return localJsonWriter;
  }

  private static void a(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
  }

  private static void a(Object paramObject, JsonReader paramJsonReader)
  {
    if (paramObject != null)
      try
      {
        if (paramJsonReader.peek() != JsonToken.END_DOCUMENT)
          throw new JsonIOException("JSON document was not fully consumed.");
      }
      catch (MalformedJsonException localMalformedJsonException)
      {
        throw new JsonSyntaxException(localMalformedJsonException);
      }
      catch (IOException localIOException)
      {
        throw new JsonIOException(localIOException);
      }
  }

  private TypeAdapter<Number> b(boolean paramBoolean)
  {
    if (paramBoolean)
      return TypeAdapters.FLOAT;
    return new j(this);
  }

  public final <T> T fromJson(JsonElement paramJsonElement, Class<T> paramClass)
  {
    Object localObject = fromJson(paramJsonElement, paramClass);
    return Primitives.wrap(paramClass).cast(localObject);
  }

  public final <T> T fromJson(JsonElement paramJsonElement, Type paramType)
  {
    if (paramJsonElement == null)
      return null;
    return fromJson(new JsonTreeReader(paramJsonElement), paramType);
  }

  // ERROR //
  public final <T> T fromJson(JsonReader paramJsonReader, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 380	com/google/gson/stream/JsonReader:isLenient	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iload_3
    //   10: invokevirtual 383	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   13: aload_1
    //   14: invokevirtual 330	com/google/gson/stream/JsonReader:peek	()Lcom/google/gson/stream/JsonToken;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 389	com/google/gson/reflect/TypeToken:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    //   25: invokevirtual 393	com/google/gson/Gson:getAdapter	(Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;
    //   28: aload_1
    //   29: invokevirtual 399	com/google/gson/TypeAdapter:read	(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    //   32: astore 10
    //   34: aload_1
    //   35: iload 4
    //   37: invokevirtual 383	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   40: aload 10
    //   42: areturn
    //   43: astore 8
    //   45: iload_3
    //   46: ifeq +11 -> 57
    //   49: aload_1
    //   50: iload 4
    //   52: invokevirtual 383	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   55: aconst_null
    //   56: areturn
    //   57: new 343	com/google/gson/JsonSyntaxException
    //   60: dup
    //   61: aload 8
    //   63: invokespecial 346	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore 6
    //   69: aload_1
    //   70: iload 4
    //   72: invokevirtual 383	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   75: aload 6
    //   77: athrow
    //   78: astore 7
    //   80: new 343	com/google/gson/JsonSyntaxException
    //   83: dup
    //   84: aload 7
    //   86: invokespecial 346	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore 5
    //   92: new 343	com/google/gson/JsonSyntaxException
    //   95: dup
    //   96: aload 5
    //   98: invokespecial 346	com/google/gson/JsonSyntaxException:<init>	(Ljava/lang/Throwable;)V
    //   101: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	18	43	java/io/EOFException
    //   20	34	43	java/io/EOFException
    //   13	18	67	finally
    //   20	34	67	finally
    //   57	67	67	finally
    //   80	90	67	finally
    //   92	102	67	finally
    //   13	18	78	java/lang/IllegalStateException
    //   20	34	78	java/lang/IllegalStateException
    //   13	18	90	java/io/IOException
    //   20	34	90	java/io/IOException
  }

  public final <T> T fromJson(Reader paramReader, Class<T> paramClass)
  {
    JsonReader localJsonReader = new JsonReader(paramReader);
    Object localObject = fromJson(localJsonReader, paramClass);
    a(localObject, localJsonReader);
    return Primitives.wrap(paramClass).cast(localObject);
  }

  public final <T> T fromJson(Reader paramReader, Type paramType)
  {
    JsonReader localJsonReader = new JsonReader(paramReader);
    Object localObject = fromJson(localJsonReader, paramType);
    a(localObject, localJsonReader);
    return localObject;
  }

  public final <T> T fromJson(String paramString, Class<T> paramClass)
  {
    Object localObject = fromJson(paramString, paramClass);
    return Primitives.wrap(paramClass).cast(localObject);
  }

  public final <T> T fromJson(String paramString, Type paramType)
  {
    if (paramString == null)
      return null;
    return fromJson(new StringReader(paramString), paramType);
  }

  public final <T> TypeAdapter<T> getAdapter(TypeToken<T> paramTypeToken)
  {
    Object localObject1 = (TypeAdapter)this.f.get(paramTypeToken);
    if (localObject1 != null)
      return localObject1;
    Map localMap = (Map)this.e.get();
    Object localObject2;
    if (localMap == null)
    {
      HashMap localHashMap = new HashMap();
      this.e.set(localHashMap);
      localObject2 = localHashMap;
    }
    for (int m = 1; ; m = 0)
    {
      while (true)
      {
        localObject1 = (l)((Map)localObject2).get(paramTypeToken);
        if (localObject1 != null)
          break;
        try
        {
          l locall = new l();
          ((Map)localObject2).put(paramTypeToken, locall);
          Iterator localIterator = this.g.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = ((TypeAdapterFactory)localIterator.next()).create(this, paramTypeToken);
            if (localObject1 != null)
            {
              locall.a((TypeAdapter)localObject1);
              this.f.put(paramTypeToken, localObject1);
              return localObject1;
            }
          }
          throw new IllegalArgumentException("GSON cannot handle " + paramTypeToken);
        }
        finally
        {
          ((Map)localObject2).remove(paramTypeToken);
          if (m != 0)
            this.e.remove();
        }
      }
      localObject2 = localMap;
    }
  }

  public final <T> TypeAdapter<T> getAdapter(Class<T> paramClass)
  {
    return getAdapter(TypeToken.get(paramClass));
  }

  public final <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory paramTypeAdapterFactory, TypeToken<T> paramTypeToken)
  {
    Iterator localIterator = this.g.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      TypeAdapterFactory localTypeAdapterFactory = (TypeAdapterFactory)localIterator.next();
      if (m == 0)
      {
        if (localTypeAdapterFactory == paramTypeAdapterFactory)
          m = 1;
      }
      else
      {
        TypeAdapter localTypeAdapter = localTypeAdapterFactory.create(this, paramTypeToken);
        if (localTypeAdapter != null)
          return localTypeAdapter;
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize " + paramTypeToken);
  }

  public final String toJson(JsonElement paramJsonElement)
  {
    StringWriter localStringWriter = new StringWriter();
    toJson(paramJsonElement, localStringWriter);
    return localStringWriter.toString();
  }

  public final String toJson(Object paramObject)
  {
    if (paramObject == null)
      return toJson(JsonNull.INSTANCE);
    return toJson(paramObject, paramObject.getClass());
  }

  public final String toJson(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    toJson(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }

  public final void toJson(JsonElement paramJsonElement, JsonWriter paramJsonWriter)
  {
    boolean bool1 = paramJsonWriter.isLenient();
    paramJsonWriter.setLenient(true);
    boolean bool2 = paramJsonWriter.isHtmlSafe();
    paramJsonWriter.setHtmlSafe(this.j);
    boolean bool3 = paramJsonWriter.getSerializeNulls();
    paramJsonWriter.setSerializeNulls(this.i);
    try
    {
      Streams.write(paramJsonElement, paramJsonWriter);
      return;
    }
    catch (IOException localIOException)
    {
      throw new JsonIOException(localIOException);
    }
    finally
    {
      paramJsonWriter.setLenient(bool1);
      paramJsonWriter.setHtmlSafe(bool2);
      paramJsonWriter.setSerializeNulls(bool3);
    }
  }

  public final void toJson(JsonElement paramJsonElement, Appendable paramAppendable)
  {
    try
    {
      toJson(paramJsonElement, a(Streams.writerForAppendable(paramAppendable)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  public final void toJson(Object paramObject, Appendable paramAppendable)
  {
    if (paramObject != null)
    {
      toJson(paramObject, paramObject.getClass(), paramAppendable);
      return;
    }
    toJson(JsonNull.INSTANCE, paramAppendable);
  }

  public final void toJson(Object paramObject, Type paramType, JsonWriter paramJsonWriter)
  {
    TypeAdapter localTypeAdapter = getAdapter(TypeToken.get(paramType));
    boolean bool1 = paramJsonWriter.isLenient();
    paramJsonWriter.setLenient(true);
    boolean bool2 = paramJsonWriter.isHtmlSafe();
    paramJsonWriter.setHtmlSafe(this.j);
    boolean bool3 = paramJsonWriter.getSerializeNulls();
    paramJsonWriter.setSerializeNulls(this.i);
    try
    {
      localTypeAdapter.write(paramJsonWriter, paramObject);
      return;
    }
    catch (IOException localIOException)
    {
      throw new JsonIOException(localIOException);
    }
    finally
    {
      paramJsonWriter.setLenient(bool1);
      paramJsonWriter.setHtmlSafe(bool2);
      paramJsonWriter.setSerializeNulls(bool3);
    }
  }

  public final void toJson(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      toJson(paramObject, paramType, a(Streams.writerForAppendable(paramAppendable)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new JsonIOException(localIOException);
    }
  }

  public final JsonElement toJsonTree(Object paramObject)
  {
    if (paramObject == null)
      return JsonNull.INSTANCE;
    return toJsonTree(paramObject, paramObject.getClass());
  }

  public final JsonElement toJsonTree(Object paramObject, Type paramType)
  {
    JsonTreeWriter localJsonTreeWriter = new JsonTreeWriter();
    toJson(paramObject, paramType, localJsonTreeWriter);
    return localJsonTreeWriter.get();
  }

  public final String toString()
  {
    return "{serializeNulls:" + this.i + "factories:" + this.g + ",instanceCreators:" + this.h + "}";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.Gson
 * JD-Core Version:    0.6.2
 */