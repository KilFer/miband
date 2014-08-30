package com.xiaomi.infra.galaxy.common.model;

public enum AttributeAction
{
  private String value;

  static
  {
    DELETE = new AttributeAction("DELETE", 2, "DELETE");
    AttributeAction[] arrayOfAttributeAction = new AttributeAction[3];
    arrayOfAttributeAction[0] = ADD;
    arrayOfAttributeAction[1] = PUT;
    arrayOfAttributeAction[2] = DELETE;
  }

  private AttributeAction(String paramString)
  {
    this.value = paramString;
  }

  public static AttributeAction fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("ADD".equals(paramString))
      return ADD;
    if ("PUT".equals(paramString))
      return PUT;
    if ("DELETE".equals(paramString))
      return DELETE;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.AttributeAction
 * JD-Core Version:    0.6.2
 */