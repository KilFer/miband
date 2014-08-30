package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.BitSet;

final class y extends TypeAdapter<BitSet>
{
  private static BitSet a(JsonReader paramJsonReader)
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    BitSet localBitSet = new BitSet();
    paramJsonReader.beginArray();
    JsonToken localJsonToken = paramJsonReader.peek();
    int i = 0;
    if (localJsonToken != JsonToken.END_ARRAY)
    {
      boolean bool;
      switch (N.a[localJsonToken.ordinal()])
      {
      default:
        throw new JsonSyntaxException("Invalid bitset value type: " + localJsonToken);
      case 1:
        if (paramJsonReader.nextInt() != 0)
          bool = true;
        break;
      case 2:
      case 3:
      }
      while (true)
      {
        if (bool)
          localBitSet.set(i);
        i++;
        localJsonToken = paramJsonReader.peek();
        break;
        bool = false;
        continue;
        bool = paramJsonReader.nextBoolean();
        continue;
        String str = paramJsonReader.nextString();
        try
        {
          int j = Integer.parseInt(str);
          if (j != 0)
            bool = true;
          else
            bool = false;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + str);
        }
      }
    }
    paramJsonReader.endArray();
    return localBitSet;
  }

  private static void a(JsonWriter paramJsonWriter, BitSet paramBitSet)
  {
    if (paramBitSet == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginArray();
    int i = 0;
    if (i < paramBitSet.length())
    {
      if (paramBitSet.get(i));
      for (int j = 1; ; j = 0)
      {
        paramJsonWriter.value(j);
        i++;
        break;
      }
    }
    paramJsonWriter.endArray();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.bind.y
 * JD-Core Version:    0.6.2
 */