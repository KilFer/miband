package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes
{
  private final Field a;

  public FieldAttributes(Field paramField)
  {
    .Gson.Preconditions.checkNotNull(paramField);
    this.a = paramField;
  }

  private Object a(Object paramObject)
  {
    return this.a.get(paramObject);
  }

  private boolean a()
  {
    return this.a.isSynthetic();
  }

  public final <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.a.getAnnotation(paramClass);
  }

  public final Collection<Annotation> getAnnotations()
  {
    return Arrays.asList(this.a.getAnnotations());
  }

  public final Class<?> getDeclaredClass()
  {
    return this.a.getType();
  }

  public final Type getDeclaredType()
  {
    return this.a.getGenericType();
  }

  public final Class<?> getDeclaringClass()
  {
    return this.a.getDeclaringClass();
  }

  public final String getName()
  {
    return this.a.getName();
  }

  public final boolean hasModifier(int paramInt)
  {
    return (paramInt & this.a.getModifiers()) != 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.FieldAttributes
 * JD-Core Version:    0.6.2
 */