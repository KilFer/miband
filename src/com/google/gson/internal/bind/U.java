package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class U<T extends Enum<T>> extends TypeAdapter<T>
{
  private final Map<String, T> a = new HashMap();
  private final Map<T, String> b = new HashMap();

  public U(Class<T> paramClass)
  {
    while (true)
    {
      String str1;
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int i = arrayOfEnum.length;
        int j = 0;
        if (j < i)
        {
          Enum localEnum = arrayOfEnum[j];
          str1 = localEnum.name();
          SerializedName localSerializedName = (SerializedName)paramClass.getField(str1).getAnnotation(SerializedName.class);
          if (localSerializedName == null)
            break label135;
          str2 = localSerializedName.value();
          this.a.put(str2, localEnum);
          this.b.put(localEnum, str2);
          j++;
          continue;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new AssertionError();
      }
      return;
      label135: String str2 = str1;
    }
  }

  private T a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    return (Enum)this.a.get(paramJsonReader.nextString());
  }

  private void a(JsonWriter paramJsonWriter, T paramT)
  {
    if (paramT == null);
    for (String str = null; ; str = (String)this.b.get(paramT))
    {
      paramJsonWriter.value(str);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.U
 * JD-Core Version:    0.6.2
 */