package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

final class a extends JsonReaderInternalAccess
{
  public final void promoteNameToValue(JsonReader paramJsonReader)
  {
    if ((paramJsonReader instanceof JsonTreeReader))
    {
      ((JsonTreeReader)paramJsonReader).promoteNameToValue();
      return;
    }
    int i = JsonReader.a(paramJsonReader);
    if (i == 0)
      i = JsonReader.b(paramJsonReader);
    if (i == 13)
    {
      JsonReader.a(paramJsonReader, 9);
      return;
    }
    if (i == 12)
    {
      JsonReader.a(paramJsonReader, 8);
      return;
    }
    if (i == 14)
    {
      JsonReader.a(paramJsonReader, 10);
      return;
    }
    throw new IllegalStateException("Expected a name but was " + paramJsonReader.peek() + "  at line " + JsonReader.c(paramJsonReader) + " column " + JsonReader.d(paramJsonReader));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.stream.a
 * JD-Core Version:    0.6.2
 */