package cn.com.smartdevices.bracelet.chart.typeface;

public class MIUITextStyleExtractor extends TypefaceManager.TextStyleExtractor
{
  private static final MIUITextStyleExtractor a = new MIUITextStyleExtractor();

  public static TypefaceManager.TextStyleExtractor getInstance()
  {
    return a;
  }

  public TypefaceManager.TextStyle[] getTextStyles()
  {
    return MIUITextStyle.values();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyleExtractor
 * JD-Core Version:    0.6.2
 */