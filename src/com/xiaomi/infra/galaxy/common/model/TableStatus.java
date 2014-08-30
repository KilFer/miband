package com.xiaomi.infra.galaxy.common.model;

public enum TableStatus
{
  private String value;

  static
  {
    DISABLED = new TableStatus("DISABLED", 3, "DISABLED");
    ENABLED = new TableStatus("ENABLED", 4, "ENABLED");
    TableStatus[] arrayOfTableStatus = new TableStatus[5];
    arrayOfTableStatus[0] = CREATING;
    arrayOfTableStatus[1] = DISABLING;
    arrayOfTableStatus[2] = ENABLING;
    arrayOfTableStatus[3] = DISABLED;
    arrayOfTableStatus[4] = ENABLED;
  }

  private TableStatus(String paramString)
  {
    this.value = paramString;
  }

  public static TableStatus fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("CREATING".equals(paramString))
      return CREATING;
    if ("DISABLING".equals(paramString))
      return DISABLING;
    if ("ENABLING".equals(paramString))
      return ENABLING;
    if ("DISABLED".equals(paramString))
      return DISABLED;
    if ("ENABLED".equals(paramString))
      return ENABLED;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.TableStatus
 * JD-Core Version:    0.6.2
 */