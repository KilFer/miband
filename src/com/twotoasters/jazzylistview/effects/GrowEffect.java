package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class GrowEffect
  implements JazzyEffect
{
  private static final float a = 0.01F;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, paramView.getWidth() / 2);
    ViewHelper.setPivotY(paramView, paramView.getHeight() / 2);
    ViewHelper.setScaleX(paramView, 0.01F);
    ViewHelper.setScaleY(paramView, 0.01F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.GrowEffect
 * JD-Core Version:    0.6.2
 */