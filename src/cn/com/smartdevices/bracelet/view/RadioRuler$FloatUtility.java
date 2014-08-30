package cn.com.smartdevices.bracelet.view;

import java.math.BigDecimal;

public class RadioRuler$FloatUtility
{
  public static float add(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).add(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }

  public static float divide(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).divide(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }

  public static float mulitiply(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).multiply(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.RadioRuler.FloatUtility
 * JD-Core Version:    0.6.2
 */