package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement
{
  private static final Class<?>[] a = arrayOfClass;
  private Object b;

  static
  {
    Class[] arrayOfClass = new Class[16];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Long.TYPE;
    arrayOfClass[2] = Short.TYPE;
    arrayOfClass[3] = Float.TYPE;
    arrayOfClass[4] = Double.TYPE;
    arrayOfClass[5] = Byte.TYPE;
    arrayOfClass[6] = Boolean.TYPE;
    arrayOfClass[7] = Character.TYPE;
    arrayOfClass[8] = Integer.class;
    arrayOfClass[9] = Long.class;
    arrayOfClass[10] = Short.class;
    arrayOfClass[11] = Float.class;
    arrayOfClass[12] = Double.class;
    arrayOfClass[13] = Byte.class;
    arrayOfClass[14] = Boolean.class;
    arrayOfClass[15] = Character.class;
  }

  public JsonPrimitive(Boolean paramBoolean)
  {
    a(paramBoolean);
  }

  public JsonPrimitive(Character paramCharacter)
  {
    a(paramCharacter);
  }

  public JsonPrimitive(Number paramNumber)
  {
    a(paramNumber);
  }

  JsonPrimitive(Object paramObject)
  {
    a(paramObject);
  }

  public JsonPrimitive(String paramString)
  {
    a(paramString);
  }

  private void a(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.b = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    int k;
    if (!(paramObject instanceof Number))
    {
      if (!(paramObject instanceof String))
        break label58;
      k = 1;
    }
    while (true)
    {
      boolean bool = false;
      if (k != 0)
        bool = true;
      .Gson.Preconditions.checkArgument(bool);
      this.b = paramObject;
      return;
      label58: Class localClass = paramObject.getClass();
      Class[] arrayOfClass = a;
      int i = arrayOfClass.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label107;
        if (arrayOfClass[j].isAssignableFrom(localClass))
        {
          k = 1;
          break;
        }
      }
      label107: k = 0;
    }
  }

  private static boolean a(JsonPrimitive paramJsonPrimitive)
  {
    if ((paramJsonPrimitive.b instanceof Number))
    {
      Number localNumber = (Number)paramJsonPrimitive.b;
      return ((localNumber instanceof BigInteger)) || ((localNumber instanceof Long)) || ((localNumber instanceof Integer)) || ((localNumber instanceof Short)) || ((localNumber instanceof Byte));
    }
    return false;
  }

  private static boolean b(Object paramObject)
  {
    if ((paramObject instanceof String))
      return true;
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = a;
    int i = arrayOfClass.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label47;
      if (arrayOfClass[j].isAssignableFrom(localClass))
        break;
    }
    label47: return false;
  }

  private JsonPrimitive c()
  {
    return this;
  }

  final Boolean b()
  {
    return (Boolean)this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    JsonPrimitive localJsonPrimitive;
    double d1;
    double d2;
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass()))
            return false;
          localJsonPrimitive = (JsonPrimitive)paramObject;
          if (this.b != null)
            break;
        }
        while (localJsonPrimitive.b == null);
        return false;
        if ((!a(this)) || (!a(localJsonPrimitive)))
          break;
      }
      while (getAsNumber().longValue() == localJsonPrimitive.getAsNumber().longValue());
      return false;
      if ((!(this.b instanceof Number)) || (!(localJsonPrimitive.b instanceof Number)))
        break;
      d1 = getAsNumber().doubleValue();
      d2 = localJsonPrimitive.getAsNumber().doubleValue();
    }
    while ((d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2))));
    return false;
    return this.b.equals(localJsonPrimitive.b);
  }

  public final BigDecimal getAsBigDecimal()
  {
    if ((this.b instanceof BigDecimal))
      return (BigDecimal)this.b;
    return new BigDecimal(this.b.toString());
  }

  public final BigInteger getAsBigInteger()
  {
    if ((this.b instanceof BigInteger))
      return (BigInteger)this.b;
    return new BigInteger(this.b.toString());
  }

  public final boolean getAsBoolean()
  {
    if (isBoolean())
      return ((Boolean)this.b).booleanValue();
    return Boolean.parseBoolean(getAsString());
  }

  public final byte getAsByte()
  {
    if (isNumber())
      return getAsNumber().byteValue();
    return Byte.parseByte(getAsString());
  }

  public final char getAsCharacter()
  {
    return getAsString().charAt(0);
  }

  public final double getAsDouble()
  {
    if (isNumber())
      return getAsNumber().doubleValue();
    return Double.parseDouble(getAsString());
  }

  public final float getAsFloat()
  {
    if (isNumber())
      return getAsNumber().floatValue();
    return Float.parseFloat(getAsString());
  }

  public final int getAsInt()
  {
    if (isNumber())
      return getAsNumber().intValue();
    return Integer.parseInt(getAsString());
  }

  public final long getAsLong()
  {
    if (isNumber())
      return getAsNumber().longValue();
    return Long.parseLong(getAsString());
  }

  public final Number getAsNumber()
  {
    if ((this.b instanceof String))
      return new LazilyParsedNumber((String)this.b);
    return (Number)this.b;
  }

  public final short getAsShort()
  {
    if (isNumber())
      return getAsNumber().shortValue();
    return Short.parseShort(getAsString());
  }

  public final String getAsString()
  {
    if (isNumber())
      return getAsNumber().toString();
    if (isBoolean())
      return ((Boolean)this.b).toString();
    return (String)this.b;
  }

  public final int hashCode()
  {
    if (this.b == null)
      return 31;
    if (a(this))
    {
      long l2 = getAsNumber().longValue();
      return (int)(l2 ^ l2 >>> 32);
    }
    if ((this.b instanceof Number))
    {
      long l1 = Double.doubleToLongBits(getAsNumber().doubleValue());
      return (int)(l1 ^ l1 >>> 32);
    }
    return this.b.hashCode();
  }

  public final boolean isBoolean()
  {
    return this.b instanceof Boolean;
  }

  public final boolean isNumber()
  {
    return this.b instanceof Number;
  }

  public final boolean isString()
  {
    return this.b instanceof String;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonPrimitive
 * JD-Core Version:    0.6.2
 */