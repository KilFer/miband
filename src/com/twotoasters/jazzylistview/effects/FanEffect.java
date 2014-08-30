package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class FanEffect
  implements JazzyEffect
{
  private static final int a = 70;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, 0.0F);
    ViewHelper.setPivotY(paramView, 0.0F);
    ViewHelper.setRotation(paramView, paramInt2 * 70);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.rotationBy(paramInt2 * -70);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.FanEffect
 * JD-Core Version:    0.6.2
 */