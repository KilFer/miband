package cn.com.smartdevices.bracelet.chart.typeface;

public abstract class TypefaceManager$TextStyleExtractor
{
  public TypefaceManager.TextStyle getTextStyle(String paramString)
  {
    TypefaceManager.TextStyle[] arrayOfTextStyle = getTextStyles();
    int i = arrayOfTextStyle.length;
    for (int j = 0; ; j++)
    {
      TypefaceManager.TextStyle localTextStyle;
      if (j >= i)
        localTextStyle = null;
      do
      {
        return localTextStyle;
        localTextStyle = arrayOfTextStyle[j];
      }
      while (localTextStyle.getName().equals(paramString));
    }
  }

  public abstract TypefaceManager.TextStyle[] getTextStyles();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager.TextStyleExtractor
 * JD-Core Version:    0.6.2
 */