package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class D extends TypeAdapter<Calendar>
{
  private static final String a = "year";
  private static final String b = "month";
  private static final String c = "dayOfMonth";
  private static final String d = "hourOfDay";
  private static final String e = "minute";
  private static final String f = "second";

  private static Calendar a(JsonReader paramJsonReader)
  {
    int i = 0;
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    paramJsonReader.beginObject();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (paramJsonReader.peek() != JsonToken.END_OBJECT)
    {
      String str = paramJsonReader.nextName();
      int i2 = paramJsonReader.nextInt();
      if ("year".equals(str))
        i1 = i2;
      else if ("month".equals(str))
        n = i2;
      else if ("dayOfMonth".equals(str))
        m = i2;
      else if ("hourOfDay".equals(str))
        k = i2;
      else if ("minute".equals(str))
        j = i2;
      else if ("second".equals(str))
        i = i2;
    }
    paramJsonReader.endObject();
    return new GregorianCalendar(i1, n, m, k, j, i);
  }

  private static void a(JsonWriter paramJsonWriter, Calendar paramCalendar)
  {
    if (paramCalendar == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginObject();
    paramJsonWriter.name("year");
    paramJsonWriter.value(paramCalendar.get(1));
    paramJsonWriter.name("month");
    paramJsonWriter.value(paramCalendar.get(2));
    paramJsonWriter.name("dayOfMonth");
    paramJsonWriter.value(paramCalendar.get(5));
    paramJsonWriter.name("hourOfDay");
    paramJsonWriter.value(paramCalendar.get(11));
    paramJsonWriter.name("minute");
    paramJsonWriter.value(paramCalendar.get(12));
    paramJsonWriter.name("second");
    paramJsonWriter.value(paramCalendar.get(13));
    paramJsonWriter.endObject();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.D
 * JD-Core Version:    0.6.2
 */