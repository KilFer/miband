package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class ConstructorConstructor
{
  private final Map<Type, InstanceCreator<?>> a;

  public ConstructorConstructor(Map<Type, InstanceCreator<?>> paramMap)
  {
    this.a = paramMap;
  }

  private <T> ObjectConstructor<T> a(Class<? super T> paramClass)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible())
        localConstructor.setAccessible(true);
      i locali = new i(this, localConstructor);
      return locali;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  private <T> ObjectConstructor<T> a(Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass))
        return new j(this);
      if (EnumSet.class.isAssignableFrom(paramClass))
        return new k(this, paramType);
      if (Set.class.isAssignableFrom(paramClass))
        return new l(this);
      if (Queue.class.isAssignableFrom(paramClass))
        return new m(this);
      return new n(this);
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (SortedMap.class.isAssignableFrom(paramClass))
        return new o(this);
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType())))
        return new e(this);
      return new f(this);
    }
    return null;
  }

  private <T> ObjectConstructor<T> b(Type paramType, Class<? super T> paramClass)
  {
    return new g(this, paramClass, paramType);
  }

  public final <T> ObjectConstructor<T> get(TypeToken<T> paramTypeToken)
  {
    Type localType = paramTypeToken.getType();
    Class localClass = paramTypeToken.getRawType();
    InstanceCreator localInstanceCreator1 = (InstanceCreator)this.a.get(localType);
    Object localObject;
    if (localInstanceCreator1 != null)
      localObject = new d(this, localInstanceCreator1, localType);
    while (true)
    {
      return localObject;
      InstanceCreator localInstanceCreator2 = (InstanceCreator)this.a.get(localClass);
      if (localInstanceCreator2 != null)
        return new h(this, localInstanceCreator2, localType);
      localObject = a(localClass);
      if (localObject == null)
      {
        if (Collection.class.isAssignableFrom(localClass))
          if (SortedSet.class.isAssignableFrom(localClass))
            localObject = new j(this);
        while (localObject == null)
        {
          return new g(this, localClass, localType);
          if (EnumSet.class.isAssignableFrom(localClass))
          {
            localObject = new k(this, localType);
          }
          else if (Set.class.isAssignableFrom(localClass))
          {
            localObject = new l(this);
          }
          else if (Queue.class.isAssignableFrom(localClass))
          {
            localObject = new m(this);
          }
          else
          {
            localObject = new n(this);
            continue;
            if (Map.class.isAssignableFrom(localClass))
            {
              if (SortedMap.class.isAssignableFrom(localClass))
                localObject = new o(this);
              else if (((localType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)localType).getActualTypeArguments()[0]).getRawType())))
                localObject = new e(this);
              else
                localObject = new f(this);
            }
            else
              localObject = null;
          }
        }
      }
    }
  }

  public final String toString()
  {
    return this.a.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor
 * JD-Core Version:    0.6.2
 */