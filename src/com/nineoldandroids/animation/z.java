package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class z extends FloatProperty<View>
{
  z(String paramString)
  {
    super(paramString);
  }

  private static Float a(View paramView)
  {
    return Float.valueOf(AnimatorProxy.wrap(paramView).getScaleX());
  }

  private static void a(View paramView, float paramFloat)
  {
    AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.z
 * JD-Core Version:    0.6.2
 */