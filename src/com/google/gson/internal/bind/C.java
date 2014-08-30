package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

final class C extends TypeAdapter<Timestamp>
{
  C(B paramB, TypeAdapter paramTypeAdapter)
  {
  }

  private Timestamp a(JsonReader paramJsonReader)
  {
    Date localDate = (Date)this.a.read(paramJsonReader);
    if (localDate != null)
      return new Timestamp(localDate.getTime());
    return null;
  }

  private void a(JsonWriter paramJsonWriter, Timestamp paramTimestamp)
  {
    this.a.write(paramJsonWriter, paramTimestamp);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.C
 * JD-Core Version:    0.6.2
 */