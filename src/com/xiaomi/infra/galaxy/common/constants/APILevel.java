package com.xiaomi.infra.galaxy.common.constants;

public enum APILevel
{
  private String value;

  static
  {
    Developer = new APILevel("Developer", 1, "Developer");
    APILevel[] arrayOfAPILevel = new APILevel[2];
    arrayOfAPILevel[0] = User;
    arrayOfAPILevel[1] = Developer;
  }

  private APILevel(String paramString)
  {
    this.value = paramString;
  }

  public static APILevel fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("User".equals(paramString))
      return User;
    if ("Developer".equals(paramString))
      return Developer;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.constants.APILevel
 * JD-Core Version:    0.6.2
 */