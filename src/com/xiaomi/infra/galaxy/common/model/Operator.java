package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.util.StringUtils;

public enum Operator
{
  private String value;

  static
  {
    Operator[] arrayOfOperator = new Operator[2];
    arrayOfOperator[0] = AND;
    arrayOfOperator[1] = OR;
  }

  private Operator(String paramString)
  {
    this.value = paramString;
  }

  public static Operator fromValue(String paramString)
  {
    if (StringUtils.isBlank(paramString))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("AND".equals(paramString))
      return AND;
    if ("OR".equals(paramString))
      return OR;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Operator
 * JD-Core Version:    0.6.2
 */