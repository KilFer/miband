package com.google.gson;

public abstract interface ExclusionStrategy
{
  public abstract boolean shouldSkipClass(Class<?> paramClass);

  public abstract boolean shouldSkipField(FieldAttributes paramFieldAttributes);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.ExclusionStrategy
 * JD-Core Version:    0.6.2
 */