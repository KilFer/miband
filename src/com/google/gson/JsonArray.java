package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement
  implements Iterable<JsonElement>
{
  private final List<JsonElement> a = new ArrayList();

  private JsonArray c()
  {
    JsonArray localJsonArray = new JsonArray();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      localJsonArray.add(((JsonElement)localIterator.next()).a());
    return localJsonArray;
  }

  public final void add(JsonElement paramJsonElement)
  {
    if (paramJsonElement == null)
      paramJsonElement = JsonNull.INSTANCE;
    this.a.add(paramJsonElement);
  }

  public final void addAll(JsonArray paramJsonArray)
  {
    this.a.addAll(paramJsonArray.a);
  }

  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof JsonArray)) && (((JsonArray)paramObject).a.equals(this.a)));
  }

  public final JsonElement get(int paramInt)
  {
    return (JsonElement)this.a.get(paramInt);
  }

  public final BigDecimal getAsBigDecimal()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsBigDecimal();
    throw new IllegalStateException();
  }

  public final BigInteger getAsBigInteger()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsBigInteger();
    throw new IllegalStateException();
  }

  public final boolean getAsBoolean()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsBoolean();
    throw new IllegalStateException();
  }

  public final byte getAsByte()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsByte();
    throw new IllegalStateException();
  }

  public final char getAsCharacter()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsCharacter();
    throw new IllegalStateException();
  }

  public final double getAsDouble()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsDouble();
    throw new IllegalStateException();
  }

  public final float getAsFloat()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsFloat();
    throw new IllegalStateException();
  }

  public final int getAsInt()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsInt();
    throw new IllegalStateException();
  }

  public final long getAsLong()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsLong();
    throw new IllegalStateException();
  }

  public final Number getAsNumber()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsNumber();
    throw new IllegalStateException();
  }

  public final short getAsShort()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsShort();
    throw new IllegalStateException();
  }

  public final String getAsString()
  {
    if (this.a.size() == 1)
      return ((JsonElement)this.a.get(0)).getAsString();
    throw new IllegalStateException();
  }

  public final int hashCode()
  {
    return this.a.hashCode();
  }

  public final Iterator<JsonElement> iterator()
  {
    return this.a.iterator();
  }

  public final int size()
  {
    return this.a.size();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.JsonArray
 * JD-Core Version:    0.6.2
 */