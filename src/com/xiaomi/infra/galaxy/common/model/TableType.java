package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

public enum TableType
{
  private String value;

  static
  {
    APP = new TableType("APP", 1, "APP");
    TableType[] arrayOfTableType = new TableType[2];
    arrayOfTableType[0] = USER;
    arrayOfTableType[1] = APP;
  }

  private TableType(String paramString)
  {
    this.value = paramString;
  }

  public static TableType fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new GalaxyClientException(ReturnCode.TABLE_TYPE_IS_BLANK);
    if ("USER".equals(paramString))
      return USER;
    if ("APP".equals(paramString))
      return APP;
    throw new GalaxyClientException(ReturnCode.TABLE_TYPE_IS_INVALID, paramString);
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.TableType
 * JD-Core Version:    0.6.2
 */