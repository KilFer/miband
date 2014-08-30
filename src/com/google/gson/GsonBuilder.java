package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder
{
  private Excluder a = Excluder.DEFAULT;
  private LongSerializationPolicy b = LongSerializationPolicy.DEFAULT;
  private FieldNamingStrategy c = FieldNamingPolicy.IDENTITY;
  private final Map<Type, InstanceCreator<?>> d = new HashMap();
  private final List<TypeAdapterFactory> e = new ArrayList();
  private final List<TypeAdapterFactory> f = new ArrayList();
  private boolean g;
  private String h;
  private int i = 2;
  private int j = 2;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private boolean n;
  private boolean o;

  private static void a(String paramString, int paramInt1, int paramInt2, List<TypeAdapterFactory> paramList)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())));
    for (a locala = new a(paramString); ; locala = new a(paramInt1, paramInt2))
    {
      paramList.add(o.a(TypeToken.get(java.util.Date.class), locala));
      paramList.add(o.a(TypeToken.get(Timestamp.class), locala));
      paramList.add(o.a(TypeToken.get(java.sql.Date.class), locala));
      do
        return;
      while ((paramInt1 == 2) || (paramInt2 == 2));
    }
  }

  public final GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy)
  {
    this.a = this.a.withExclusionStrategy(paramExclusionStrategy, false, true);
    return this;
  }

  public final GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy)
  {
    this.a = this.a.withExclusionStrategy(paramExclusionStrategy, true, false);
    return this;
  }

  public final Gson create()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.e);
    Collections.reverse(localArrayList);
    localArrayList.addAll(this.f);
    String str = this.h;
    int i1 = this.i;
    int i2 = this.j;
    if ((str != null) && (!"".equals(str.trim())));
    for (a locala = new a(str); ; locala = new a(i1, i2))
    {
      localArrayList.add(o.a(TypeToken.get(java.util.Date.class), locala));
      localArrayList.add(o.a(TypeToken.get(Timestamp.class), locala));
      localArrayList.add(o.a(TypeToken.get(java.sql.Date.class), locala));
      do
        return new Gson(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, localArrayList);
      while ((i1 == 2) || (i2 == 2));
    }
  }

  public final GsonBuilder disableHtmlEscaping()
  {
    this.m = false;
    return this;
  }

  public final GsonBuilder disableInnerClassSerialization()
  {
    this.a = this.a.disableInnerClassSerialization();
    return this;
  }

  public final GsonBuilder enableComplexMapKeySerialization()
  {
    this.k = true;
    return this;
  }

  public final GsonBuilder excludeFieldsWithModifiers(int[] paramArrayOfInt)
  {
    this.a = this.a.withModifiers(paramArrayOfInt);
    return this;
  }

  public final GsonBuilder excludeFieldsWithoutExposeAnnotation()
  {
    this.a = this.a.excludeFieldsWithoutExposeAnnotation();
    return this;
  }

  public final GsonBuilder generateNonExecutableJson()
  {
    this.o = true;
    return this;
  }

  public final GsonBuilder registerTypeAdapter(Type paramType, Object paramObject)
  {
    if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof InstanceCreator)) || ((paramObject instanceof TypeAdapter)));
    for (boolean bool = true; ; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      if ((paramObject instanceof InstanceCreator))
        this.d.put(paramType, (InstanceCreator)paramObject);
      if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)))
      {
        TypeToken localTypeToken = TypeToken.get(paramType);
        this.e.add(o.b(localTypeToken, paramObject));
      }
      if ((paramObject instanceof TypeAdapter))
        this.e.add(TypeAdapters.newFactory(TypeToken.get(paramType), (TypeAdapter)paramObject));
      return this;
    }
  }

  public final GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory paramTypeAdapterFactory)
  {
    this.e.add(paramTypeAdapterFactory);
    return this;
  }

  public final GsonBuilder registerTypeHierarchyAdapter(Class<?> paramClass, Object paramObject)
  {
    if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof TypeAdapter)));
    for (boolean bool = true; ; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      if (((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof JsonSerializer)))
        this.f.add(0, o.a(paramClass, paramObject));
      if ((paramObject instanceof TypeAdapter))
        this.e.add(TypeAdapters.newTypeHierarchyFactory(paramClass, (TypeAdapter)paramObject));
      return this;
    }
  }

  public final GsonBuilder serializeNulls()
  {
    this.g = true;
    return this;
  }

  public final GsonBuilder serializeSpecialFloatingPointValues()
  {
    this.l = true;
    return this;
  }

  public final GsonBuilder setDateFormat(int paramInt)
  {
    this.i = paramInt;
    this.h = null;
    return this;
  }

  public final GsonBuilder setDateFormat(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.h = null;
    return this;
  }

  public final GsonBuilder setDateFormat(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public final GsonBuilder setExclusionStrategies(ExclusionStrategy[] paramArrayOfExclusionStrategy)
  {
    int i1 = paramArrayOfExclusionStrategy.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      ExclusionStrategy localExclusionStrategy = paramArrayOfExclusionStrategy[i2];
      this.a = this.a.withExclusionStrategy(localExclusionStrategy, true, true);
    }
    return this;
  }

  public final GsonBuilder setFieldNamingPolicy(FieldNamingPolicy paramFieldNamingPolicy)
  {
    this.c = paramFieldNamingPolicy;
    return this;
  }

  public final GsonBuilder setFieldNamingStrategy(FieldNamingStrategy paramFieldNamingStrategy)
  {
    this.c = paramFieldNamingStrategy;
    return this;
  }

  public final GsonBuilder setLongSerializationPolicy(LongSerializationPolicy paramLongSerializationPolicy)
  {
    this.b = paramLongSerializationPolicy;
    return this;
  }

  public final GsonBuilder setPrettyPrinting()
  {
    this.n = true;
    return this;
  }

  public final GsonBuilder setVersion(double paramDouble)
  {
    this.a = this.a.withVersion(paramDouble);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.GsonBuilder
 * JD-Core Version:    0.6.2
 */