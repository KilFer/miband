package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class FlyEffect
  implements JazzyEffect
{
  private static final int a = 135;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, paramView.getWidth() / 2);
    ViewHelper.setPivotY(paramView, paramView.getHeight() / 2);
    ViewHelper.setRotationX(paramView, paramInt2 * -135);
    ViewHelper.setTranslationY(paramView, paramInt2 * (paramView.getHeight() << 1));
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.rotationXBy(paramInt2 * 135).translationYBy(paramInt2 * (-paramView.getHeight() << 1));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.FlyEffect
 * JD-Core Version:    0.6.2
 */