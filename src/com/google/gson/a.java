package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

final class a
  implements JsonDeserializer<java.util.Date>, JsonSerializer<java.util.Date>
{
  private final DateFormat a;
  private final DateFormat b;
  private final DateFormat c;

  a()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }

  private a(int paramInt)
  {
    this(DateFormat.getDateInstance(paramInt, Locale.US), DateFormat.getDateInstance(paramInt));
  }

  public a(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }

  a(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }

  private a(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    this.a = paramDateFormat1;
    this.b = paramDateFormat2;
    this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  private JsonElement a(java.util.Date paramDate)
  {
    synchronized (this.b)
    {
      JsonPrimitive localJsonPrimitive = new JsonPrimitive(this.a.format(paramDate));
      return localJsonPrimitive;
    }
  }

  private java.util.Date a(JsonElement paramJsonElement)
  {
    synchronized (this.b)
    {
      try
      {
        java.util.Date localDate3 = this.b.parse(paramJsonElement.getAsString());
        return localDate3;
      }
      catch (ParseException localParseException1)
      {
      }
    }
    try
    {
      java.util.Date localDate2 = this.a.parse(paramJsonElement.getAsString());
      return localDate2;
      localObject = finally;
      throw localObject;
    }
    catch (ParseException localParseException2)
    {
      try
      {
        java.util.Date localDate1 = this.c.parse(paramJsonElement.getAsString());
        return localDate1;
      }
      catch (ParseException localParseException3)
      {
        throw new JsonSyntaxException(paramJsonElement.getAsString(), localParseException3);
      }
    }
  }

  private java.util.Date a(JsonElement paramJsonElement, Type paramType)
  {
    if (!(paramJsonElement instanceof JsonPrimitive))
      throw new JsonParseException("The date should be a string value");
    java.util.Date localDate = a(paramJsonElement);
    if (paramType == java.util.Date.class)
      return localDate;
    if (paramType == Timestamp.class)
      return new Timestamp(localDate.getTime());
    if (paramType == java.sql.Date.class)
      return new java.sql.Date(localDate.getTime());
    throw new IllegalArgumentException(getClass() + " cannot deserialize to " + paramType);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.class.getSimpleName());
    localStringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.a
 * JD-Core Version:    0.6.2
 */