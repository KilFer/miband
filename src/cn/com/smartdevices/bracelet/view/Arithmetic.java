package cn.com.smartdevices.bracelet.view;

import java.math.BigDecimal;

public class Arithmetic
{
  public static float add(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).add(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }

  public static float div(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    return new BigDecimal(Float.toString(paramFloat1)).divide(new BigDecimal(Float.toString(paramFloat2)), paramInt, 4).floatValue();
  }

  public static float mul(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).multiply(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }

  public static float round(float paramFloat, int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    return new BigDecimal(Float.toString(paramFloat)).divide(new BigDecimal("1"), paramInt, 4).floatValue();
  }

  public static float sub(float paramFloat1, float paramFloat2)
  {
    return new BigDecimal(Float.toString(paramFloat1)).subtract(new BigDecimal(Float.toString(paramFloat2))).floatValue();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.Arithmetic
 * JD-Core Version:    0.6.2
 */