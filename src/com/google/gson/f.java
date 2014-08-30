package com.google.gson;

import java.lang.reflect.Field;

 enum f
{
  f()
  {
    super(str, 4, (byte)0);
  }

  public final String translateName(Field paramField)
  {
    return FieldNamingPolicy.a(paramField.getName(), "-").toLowerCase();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.f
 * JD-Core Version:    0.6.2
 */