package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayInputStream;

public class StringInputStream extends ByteArrayInputStream
{
  private final String string;

  public StringInputStream(String paramString)
  {
    super(paramString.getBytes("UTF-8"));
    this.string = paramString;
  }

  public String getString()
  {
    return this.string;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.StringInputStream
 * JD-Core Version:    0.6.2
 */