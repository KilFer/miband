package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class p extends IntProperty<View>
{
  p(String paramString)
  {
    super(paramString);
  }

  private static Integer a(View paramView)
  {
    return Integer.valueOf(AnimatorProxy.wrap(paramView).getScrollY());
  }

  private static void a(View paramView, int paramInt)
  {
    AnimatorProxy.wrap(paramView).setScrollY(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.p
 * JD-Core Version:    0.6.2
 */