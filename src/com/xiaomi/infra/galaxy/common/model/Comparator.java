package com.xiaomi.infra.galaxy.common.model;

public enum Comparator
{
  private String value;

  static
  {
    GT = new Comparator("GT", 2, "GT");
    GE = new Comparator("GE", 3, "GE");
    LT = new Comparator("LT", 4, "LT");
    LE = new Comparator("LE", 5, "LE");
    Comparator[] arrayOfComparator = new Comparator[6];
    arrayOfComparator[0] = EQ;
    arrayOfComparator[1] = NE;
    arrayOfComparator[2] = GT;
    arrayOfComparator[3] = GE;
    arrayOfComparator[4] = LT;
    arrayOfComparator[5] = LE;
  }

  private Comparator(String paramString)
  {
    this.value = paramString;
  }

  public static Comparator fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("EQ".equals(paramString))
      return EQ;
    if ("NE".equals(paramString))
      return NE;
    if ("GT".equals(paramString))
      return GT;
    if ("GE".equals(paramString))
      return GE;
    if ("LT".equals(paramString))
      return LT;
    if ("LE".equals(paramString))
      return LE;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.Comparator
 * JD-Core Version:    0.6.2
 */