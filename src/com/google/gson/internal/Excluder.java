package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
  implements TypeAdapterFactory, Cloneable
{
  public static final Excluder DEFAULT = new Excluder();
  private static final double a = -1.0D;
  private double b = -1.0D;
  private int c = 136;
  private boolean d = true;
  private boolean e;
  private List<ExclusionStrategy> f = Collections.emptyList();
  private List<ExclusionStrategy> g = Collections.emptyList();

  private boolean a(Since paramSince)
  {
    return (paramSince == null) || (paramSince.value() <= this.b);
  }

  private boolean a(Since paramSince, Until paramUntil)
  {
    int i;
    if ((paramSince != null) && (paramSince.value() > this.b))
    {
      i = 0;
      if (i == 0)
        break label63;
      if ((paramUntil == null) || (paramUntil.value() > this.b))
        break label57;
    }
    label57: for (int j = 0; ; j = 1)
    {
      if (j == 0)
        break label63;
      return true;
      i = 1;
      break;
    }
    label63: return false;
  }

  private boolean a(Until paramUntil)
  {
    return (paramUntil == null) || (paramUntil.value() > this.b);
  }

  private static boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }

  private boolean b(Class<?> paramClass)
  {
    if (paramClass.isMemberClass())
    {
      if ((0x8 & paramClass.getModifiers()) != 0);
      for (int i = 1; i == 0; i = 0)
        return true;
    }
    return false;
  }

  private static boolean c(Class<?> paramClass)
  {
    return (0x8 & paramClass.getModifiers()) != 0;
  }

  protected final Excluder clone()
  {
    try
    {
      Excluder localExcluder = (Excluder)super.clone();
      return localExcluder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new AssertionError();
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    boolean bool1 = excludeClass(localClass, true);
    boolean bool2 = excludeClass(localClass, false);
    if ((!bool1) && (!bool2))
      return null;
    return new p(this, bool2, bool1, paramGson, paramTypeToken);
  }

  public final Excluder disableInnerClassSerialization()
  {
    Excluder localExcluder = clone();
    localExcluder.d = false;
    return localExcluder;
  }

  public final boolean excludeClass(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.b != -1.0D) && (!a((Since)paramClass.getAnnotation(Since.class), (Until)paramClass.getAnnotation(Until.class))))
      return true;
    if ((!this.d) && (b(paramClass)))
      return true;
    if (a(paramClass))
      return true;
    if (paramBoolean);
    for (List localList = this.f; ; localList = this.g)
    {
      Iterator localIterator = localList.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!((ExclusionStrategy)localIterator.next()).shouldSkipClass(paramClass));
      return true;
    }
    return false;
  }

  public final boolean excludeField(Field paramField, boolean paramBoolean)
  {
    if ((this.c & paramField.getModifiers()) != 0)
      return true;
    if ((this.b != -1.0D) && (!a((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class))))
      return true;
    if (paramField.isSynthetic())
      return true;
    if (this.e)
    {
      Expose localExpose = (Expose)paramField.getAnnotation(Expose.class);
      if (localExpose != null)
      {
        if (!paramBoolean)
          break label100;
        if (localExpose.serialize())
          break label110;
      }
      label100: 
      while (!localExpose.deserialize())
        return true;
    }
    label110: if ((!this.d) && (b(paramField.getType())))
      return true;
    if (a(paramField.getType()))
      return true;
    if (paramBoolean);
    for (List localList = this.f; !localList.isEmpty(); localList = this.g)
    {
      FieldAttributes localFieldAttributes = new FieldAttributes(paramField);
      Iterator localIterator = localList.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (!((ExclusionStrategy)localIterator.next()).shouldSkipField(localFieldAttributes));
      return true;
    }
    return false;
  }

  public final Excluder excludeFieldsWithoutExposeAnnotation()
  {
    Excluder localExcluder = clone();
    localExcluder.e = true;
    return localExcluder;
  }

  public final Excluder withExclusionStrategy(ExclusionStrategy paramExclusionStrategy, boolean paramBoolean1, boolean paramBoolean2)
  {
    Excluder localExcluder = clone();
    if (paramBoolean1)
    {
      localExcluder.f = new ArrayList(this.f);
      localExcluder.f.add(paramExclusionStrategy);
    }
    if (paramBoolean2)
    {
      localExcluder.g = new ArrayList(this.g);
      localExcluder.g.add(paramExclusionStrategy);
    }
    return localExcluder;
  }

  public final Excluder withModifiers(int[] paramArrayOfInt)
  {
    int i = 0;
    Excluder localExcluder = clone();
    localExcluder.c = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      localExcluder.c = (paramArrayOfInt[i] | localExcluder.c);
      i++;
    }
    return localExcluder;
  }

  public final Excluder withVersion(double paramDouble)
  {
    Excluder localExcluder = clone();
    localExcluder.b = paramDouble;
    return localExcluder;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.Excluder
 * JD-Core Version:    0.6.2
 */