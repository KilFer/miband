package org.achartengine.chart;

public enum PointStyle
{
  private String a;

  static
  {
    CIRCLE = new PointStyle("CIRCLE", 1, "circle");
    TRIANGLE = new PointStyle("TRIANGLE", 2, "triangle");
    SQUARE = new PointStyle("SQUARE", 3, "square");
    DIAMOND = new PointStyle("DIAMOND", 4, "diamond");
    POINT = new PointStyle("POINT", 5, "point");
    PointStyle[] arrayOfPointStyle = new PointStyle[6];
    arrayOfPointStyle[0] = X;
    arrayOfPointStyle[1] = CIRCLE;
    arrayOfPointStyle[2] = TRIANGLE;
    arrayOfPointStyle[3] = SQUARE;
    arrayOfPointStyle[4] = DIAMOND;
    arrayOfPointStyle[5] = POINT;
  }

  private PointStyle(String paramString)
  {
    this.a = paramString;
  }

  public static int getIndexForName(String paramString)
  {
    int i = -1;
    PointStyle[] arrayOfPointStyle = values();
    int j = arrayOfPointStyle.length;
    for (int k = 0; (k < j) && (i < 0); k++)
      if (arrayOfPointStyle[k].a.equals(paramString))
        i = k;
    return Math.max(0, i);
  }

  public static PointStyle getPointStyleForName(String paramString)
  {
    PointStyle[] arrayOfPointStyle = values();
    int i = arrayOfPointStyle.length;
    PointStyle localPointStyle = null;
    for (int j = 0; (j < i) && (localPointStyle == null); j++)
      if (arrayOfPointStyle[j].a.equals(paramString))
        localPointStyle = arrayOfPointStyle[j];
    return localPointStyle;
  }

  public final String getName()
  {
    return this.a;
  }

  public final String toString()
  {
    return getName();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.PointStyle
 * JD-Core Version:    0.6.2
 */