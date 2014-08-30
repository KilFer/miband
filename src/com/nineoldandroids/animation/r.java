package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class r extends FloatProperty<View>
{
  r(String paramString)
  {
    super(paramString);
  }

  private static Float a(View paramView)
  {
    return Float.valueOf(AnimatorProxy.wrap(paramView).getY());
  }

  private static void a(View paramView, float paramFloat)
  {
    AnimatorProxy.wrap(paramView).setY(paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.r
 * JD-Core Version:    0.6.2
 */