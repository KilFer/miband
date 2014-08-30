package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeTypeAdapter extends TypeAdapter<Time>
{
  public static final TypeAdapterFactory FACTORY = new l();
  private final DateFormat a = new SimpleDateFormat("hh:mm:ss a");

  public final Time read(JsonReader paramJsonReader)
  {
    try
    {
      Time localTime;
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        localTime = null;
      }
      while (true)
      {
        return localTime;
        try
        {
          localTime = new Time(this.a.parse(paramJsonReader.nextString()).getTime());
        }
        catch (ParseException localParseException)
        {
          throw new JsonSyntaxException(localParseException);
        }
      }
    }
    finally
    {
    }
  }

  public final void write(JsonWriter paramJsonWriter, Time paramTime)
  {
    Object localObject2;
    if (paramTime == null)
      localObject2 = null;
    try
    {
      while (true)
      {
        paramJsonWriter.value((String)localObject2);
        return;
        String str = this.a.format(paramTime);
        localObject2 = str;
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.TimeTypeAdapter
 * JD-Core Version:    0.6.2
 */