package com.google.gson.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types
{
  static final Type[] a = new Type[0];

  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++)
      if (paramObject.equals(paramArrayOfObject[i]))
        return i;
    throw new NoSuchElementException();
  }

  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    if ((localGenericDeclaration instanceof Class))
      return (Class)localGenericDeclaration;
    return null;
  }

  private static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    Object localObject1 = paramClass1;
    Object localObject2 = paramType;
    if (paramClass2 == localObject1)
      paramClass2 = (Class<?>)localObject2;
    label159: 
    while (true)
    {
      return paramClass2;
      if (paramClass2.isInterface())
      {
        Class[] arrayOfClass = ((Class)localObject1).getInterfaces();
        int i = 0;
        int j = arrayOfClass.length;
        while (true)
        {
          if (i >= j)
            break label100;
          if (arrayOfClass[i] == paramClass2)
            return localObject1.getGenericInterfaces()[i];
          if (paramClass2.isAssignableFrom(arrayOfClass[i]))
          {
            Type localType2 = localObject1.getGenericInterfaces()[i];
            localObject1 = arrayOfClass[i];
            localObject2 = localType2;
            break;
          }
          i++;
        }
      }
      label100: if (!((Class)localObject1).isInterface())
        while (true)
        {
          if (localObject1 == Object.class)
            break label159;
          Class localClass = ((Class)localObject1).getSuperclass();
          if (localClass == paramClass2)
            return ((Class)localObject1).getGenericSuperclass();
          if (paramClass2.isAssignableFrom(localClass))
          {
            Type localType1 = ((Class)localObject1).getGenericSuperclass();
            localObject1 = localClass;
            localObject2 = localType1;
            break;
          }
          localObject1 = localClass;
        }
    }
  }

  private static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    Class localClass;
    if ((localGenericDeclaration instanceof Class))
    {
      localClass = (Class)localGenericDeclaration;
      if (localClass != null)
        break label33;
    }
    label33: Type localType;
    do
    {
      return paramTypeVariable;
      localClass = null;
      break;
      localType = a(paramType, paramClass, localClass);
    }
    while (!(localType instanceof ParameterizedType));
    TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
    for (int i = 0; i < arrayOfTypeVariable.length; i++)
      if (paramTypeVariable.equals(arrayOfTypeVariable[i]))
        return ((ParameterizedType)localType).getActualTypeArguments()[i];
    throw new NoSuchElementException();
  }

  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static GenericArrayType arrayOf(Type paramType)
  {
    return new a(paramType);
  }

  private static int b(Object paramObject)
  {
    if (paramObject != null)
      return paramObject.hashCode();
    return 0;
  }

  private static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    .Gson.Preconditions.checkArgument(paramClass2.isAssignableFrom(paramClass1));
    return resolve(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }

  private static void b(Type paramType)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive()));
    for (boolean bool = true; ; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      return;
    }
  }

  public static Type canonicalize(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray())
        paramType = new a(canonicalize(paramType.getComponentType()));
    }
    do
    {
      return paramType;
      if ((paramType instanceof ParameterizedType))
      {
        ParameterizedType localParameterizedType = (ParameterizedType)paramType;
        return new b(localParameterizedType.getOwnerType(), localParameterizedType.getRawType(), localParameterizedType.getActualTypeArguments());
      }
      if ((paramType instanceof GenericArrayType))
        return new a(((GenericArrayType)paramType).getGenericComponentType());
    }
    while (!(paramType instanceof WildcardType));
    WildcardType localWildcardType = (WildcardType)paramType;
    return new c(localWildcardType.getUpperBounds(), localWildcardType.getLowerBounds());
  }

  public static boolean equals(Type paramType1, Type paramType2)
  {
    Type localType1 = paramType2;
    Type localType2 = paramType1;
    while (true)
    {
      if (localType2 == localType1)
        return true;
      if ((localType2 instanceof Class))
        return localType2.equals(localType1);
      if ((localType2 instanceof ParameterizedType))
      {
        if (!(localType1 instanceof ParameterizedType))
          return false;
        ParameterizedType localParameterizedType1 = (ParameterizedType)localType2;
        ParameterizedType localParameterizedType2 = (ParameterizedType)localType1;
        Type localType3 = localParameterizedType1.getOwnerType();
        Type localType4 = localParameterizedType2.getOwnerType();
        if ((localType3 == localType4) || ((localType3 != null) && (localType3.equals(localType4))));
        for (int i = 1; (i != 0) && (localParameterizedType1.getRawType().equals(localParameterizedType2.getRawType())) && (Arrays.equals(localParameterizedType1.getActualTypeArguments(), localParameterizedType2.getActualTypeArguments())); i = 0)
          return true;
        return false;
      }
      if (!(localType2 instanceof GenericArrayType))
        break;
      if (!(localType1 instanceof GenericArrayType))
        return false;
      GenericArrayType localGenericArrayType1 = (GenericArrayType)localType2;
      GenericArrayType localGenericArrayType2 = (GenericArrayType)localType1;
      localType2 = localGenericArrayType1.getGenericComponentType();
      localType1 = localGenericArrayType2.getGenericComponentType();
    }
    if ((localType2 instanceof WildcardType))
    {
      if (!(localType1 instanceof WildcardType))
        return false;
      WildcardType localWildcardType1 = (WildcardType)localType2;
      WildcardType localWildcardType2 = (WildcardType)localType1;
      return (Arrays.equals(localWildcardType1.getUpperBounds(), localWildcardType2.getUpperBounds())) && (Arrays.equals(localWildcardType1.getLowerBounds(), localWildcardType2.getLowerBounds()));
    }
    if ((localType2 instanceof TypeVariable))
    {
      if (!(localType1 instanceof TypeVariable))
        return false;
      TypeVariable localTypeVariable1 = (TypeVariable)localType2;
      TypeVariable localTypeVariable2 = (TypeVariable)localType1;
      return (localTypeVariable1.getGenericDeclaration() == localTypeVariable2.getGenericDeclaration()) && (localTypeVariable1.getName().equals(localTypeVariable2.getName()));
    }
    return false;
  }

  public static Type getArrayComponentType(Type paramType)
  {
    if ((paramType instanceof GenericArrayType))
      return ((GenericArrayType)paramType).getGenericComponentType();
    return ((Class)paramType).getComponentType();
  }

  public static Type getCollectionElementType(Type paramType, Class<?> paramClass)
  {
    Type localType = b(paramType, paramClass, Collection.class);
    if ((localType instanceof WildcardType))
      localType = ((WildcardType)localType).getUpperBounds()[0];
    if ((localType instanceof ParameterizedType))
      return ((ParameterizedType)localType).getActualTypeArguments()[0];
    return Object.class;
  }

  public static Type[] getMapKeyAndValueTypes(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class)
      return new Type[] { String.class, String.class };
    Type localType = b(paramType, paramClass, Map.class);
    if ((localType instanceof ParameterizedType))
      return ((ParameterizedType)localType).getActualTypeArguments();
    return new Type[] { Object.class, Object.class };
  }

  public static Class<?> getRawType(Type paramType)
  {
    for (Type localType1 = paramType; ; localType1 = ((WildcardType)localType1).getUpperBounds()[0])
    {
      if ((localType1 instanceof Class))
        return (Class)localType1;
      if ((localType1 instanceof ParameterizedType))
      {
        Type localType2 = ((ParameterizedType)localType1).getRawType();
        .Gson.Preconditions.checkArgument(localType2 instanceof Class);
        return (Class)localType2;
      }
      if ((localType1 instanceof GenericArrayType))
        return Array.newInstance(getRawType(((GenericArrayType)localType1).getGenericComponentType()), 0).getClass();
      if ((localType1 instanceof TypeVariable))
        return Object.class;
      if (!(localType1 instanceof WildcardType))
        break;
    }
    if (localType1 == null);
    for (String str = "null"; ; str = localType1.getClass().getName())
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + localType1 + "> is of type " + str);
  }

  public static ParameterizedType newParameterizedTypeWithOwner(Type paramType1, Type paramType2, Type[] paramArrayOfType)
  {
    return new b(paramType1, paramType2, paramArrayOfType);
  }

  public static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    int i = 0;
    Object localObject = paramType2;
    TypeVariable localTypeVariable;
    Class localClass2;
    label44: int m;
    if ((localObject instanceof TypeVariable))
    {
      localTypeVariable = (TypeVariable)localObject;
      GenericDeclaration localGenericDeclaration = localTypeVariable.getGenericDeclaration();
      if ((localGenericDeclaration instanceof Class))
      {
        localClass2 = (Class)localGenericDeclaration;
        if (localClass2 == null)
          break label142;
        Type localType9 = a(paramType1, paramClass, localClass2);
        if (!(localType9 instanceof ParameterizedType))
          break label142;
        TypeVariable[] arrayOfTypeVariable = localClass2.getTypeParameters();
        m = 0;
        label76: if (m >= arrayOfTypeVariable.length)
          break label134;
        if (!localTypeVariable.equals(arrayOfTypeVariable[m]))
          break label128;
        localObject = ((ParameterizedType)localType9).getActualTypeArguments()[m];
        label112: if (localObject != localTypeVariable)
          break label147;
      }
    }
    label128: label134: label142: label147: label204: label250: Type[] arrayOfType2;
    label389: label455: Type localType1;
    do
    {
      do
      {
        Type[] arrayOfType1;
        Type localType2;
        do
        {
          do
          {
            Type localType4;
            int j;
            Type[] arrayOfType3;
            do
            {
              Type localType6;
              Type localType7;
              do
              {
                Class localClass1;
                Type localType8;
                do
                {
                  return localObject;
                  localClass2 = null;
                  break label44;
                  m++;
                  break label76;
                  throw new NoSuchElementException();
                  localObject = localTypeVariable;
                  break label112;
                  break;
                  if ((!(localObject instanceof Class)) || (!((Class)localObject).isArray()))
                    break label204;
                  localObject = (Class)localObject;
                  localClass1 = ((Class)localObject).getComponentType();
                  localType8 = resolve(paramType1, paramClass, localClass1);
                }
                while (localClass1 == localType8);
                return arrayOf(localType8);
                if (!(localObject instanceof GenericArrayType))
                  break label250;
                localObject = (GenericArrayType)localObject;
                localType6 = ((GenericArrayType)localObject).getGenericComponentType();
                localType7 = resolve(paramType1, paramClass, localType6);
              }
              while (localType6 == localType7);
              return arrayOf(localType7);
              if (!(localObject instanceof ParameterizedType))
                break label389;
              localObject = (ParameterizedType)localObject;
              Type localType3 = ((ParameterizedType)localObject).getOwnerType();
              localType4 = resolve(paramType1, paramClass, localType3);
              if (localType4 != localType3);
              for (j = 1; ; j = 0)
              {
                arrayOfType3 = ((ParameterizedType)localObject).getActualTypeArguments();
                int k = arrayOfType3.length;
                while (i < k)
                {
                  Type localType5 = resolve(paramType1, paramClass, arrayOfType3[i]);
                  if (localType5 != arrayOfType3[i])
                  {
                    if (j == 0)
                    {
                      arrayOfType3 = (Type[])arrayOfType3.clone();
                      j = 1;
                    }
                    arrayOfType3[i] = localType5;
                  }
                  i++;
                }
              }
            }
            while (j == 0);
            return newParameterizedTypeWithOwner(localType4, ((ParameterizedType)localObject).getRawType(), arrayOfType3);
          }
          while (!(localObject instanceof WildcardType));
          localObject = (WildcardType)localObject;
          arrayOfType1 = ((WildcardType)localObject).getLowerBounds();
          arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
          if (arrayOfType1.length != 1)
            break label455;
          localType2 = resolve(paramType1, paramClass, arrayOfType1[0]);
        }
        while (localType2 == arrayOfType1[0]);
        return supertypeOf(localType2);
      }
      while (arrayOfType2.length != 1);
      localType1 = resolve(paramType1, paramClass, arrayOfType2[0]);
    }
    while (localType1 == arrayOfType2[0]);
    return subtypeOf(localType1);
  }

  public static WildcardType subtypeOf(Type paramType)
  {
    return new c(new Type[] { paramType }, a);
  }

  public static WildcardType supertypeOf(Type paramType)
  {
    return new c(new Type[] { Object.class }, new Type[] { paramType });
  }

  public static String typeToString(Type paramType)
  {
    if ((paramType instanceof Class))
      return ((Class)paramType).getName();
    return paramType.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal..Gson.Types
 * JD-Core Version:    0.6.2
 */