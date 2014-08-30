package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor a;
  private final FieldNamingStrategy b;
  private final Excluder c;

  public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder)
  {
    this.a = paramConstructorConstructor;
    this.b = paramFieldNamingStrategy;
    this.c = paramExcluder;
  }

  private j a(Gson paramGson, Field paramField, String paramString, TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new i(this, paramString, paramBoolean1, paramBoolean2, paramGson, paramTypeToken, paramField, Primitives.isPrimitive(paramTypeToken.getRawType()));
  }

  private String a(Field paramField)
  {
    SerializedName localSerializedName = (SerializedName)paramField.getAnnotation(SerializedName.class);
    if (localSerializedName == null)
      return this.b.translateName(paramField);
    return localSerializedName.value();
  }

  private Map<String, j> a(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
      return localLinkedHashMap;
    Type localType1 = paramTypeToken.getType();
    while (paramClass != Object.class)
    {
      for (Field localField : paramClass.getDeclaredFields())
      {
        boolean bool1 = excludeField(localField, true);
        boolean bool2 = excludeField(localField, false);
        if ((bool1) || (bool2))
        {
          localField.setAccessible(true);
          Type localType4 = paramTypeToken.getType();
          Type localType5 = localField.getGenericType();
          Type localType6 = .Gson.Types.resolve(localType4, paramClass, localType5);
          SerializedName localSerializedName = (SerializedName)localField.getAnnotation(SerializedName.class);
          if (localSerializedName == null);
          for (String str = this.b.translateName(localField); ; str = localSerializedName.value())
          {
            TypeToken localTypeToken = TypeToken.get(localType6);
            i locali = new i(this, str, bool1, bool2, paramGson, localTypeToken, localField, Primitives.isPrimitive(localTypeToken.getRawType()));
            j localj = (j)localLinkedHashMap.put(locali.a, locali);
            if (localj == null)
              break;
            throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + localj.a);
          }
        }
      }
      Type localType2 = paramTypeToken.getType();
      Type localType3 = paramClass.getGenericSuperclass();
      paramTypeToken = TypeToken.get(.Gson.Types.resolve(localType2, paramClass, localType3));
      paramClass = paramTypeToken.getRawType();
    }
    return localLinkedHashMap;
  }

  public final <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    if (!Object.class.isAssignableFrom(localClass))
      return null;
    return new ReflectiveTypeAdapterFactory.Adapter(this.a.get(paramTypeToken), a(paramGson, paramTypeToken, localClass), (byte)0);
  }

  public final boolean excludeField(Field paramField, boolean paramBoolean)
  {
    return (!this.c.excludeClass(paramField.getType(), paramBoolean)) && (!this.c.excludeField(paramField, paramBoolean));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
 * JD-Core Version:    0.6.2
 */