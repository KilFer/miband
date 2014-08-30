package cn.com.smartdevices.bracelet.chart.typeface;

public enum MIUITextStyle
  implements TypefaceManager.TextStyle
{
  private String a;
  private String b;

  static
  {
    LIGHT = new MIUITextStyle("LIGHT", 1, "miui-light", "fonts/MIUI/MIUI-Light.ttf");
    BOLD = new MIUITextStyle("BOLD", 2, "miui-bold", "fonts/MIUI/MIUI-Bold.ttf");
    MIUITextStyle[] arrayOfMIUITextStyle = new MIUITextStyle[3];
    arrayOfMIUITextStyle[0] = NORMAL;
    arrayOfMIUITextStyle[1] = LIGHT;
    arrayOfMIUITextStyle[2] = BOLD;
  }

  private MIUITextStyle(String arg3, String arg4)
  {
    Object localObject1;
    this.a = localObject1;
    Object localObject2;
    this.b = localObject2;
  }

  public final String getFontName()
  {
    return this.b;
  }

  public final String getName()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyle
 * JD-Core Version:    0.6.2
 */