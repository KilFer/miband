package cn.com.smartdevices.bracelet.view;

import android.view.animation.Interpolator;

final class z
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    float f = paramFloat - 1.0F;
    return 1.0F + f * (f * (f * (f * f)));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.z
 * JD-Core Version:    0.6.2
 */