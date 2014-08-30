package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class TiltEffect
  implements JazzyEffect
{
  private static final float a = 0.7F;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, paramView.getWidth() / 2);
    ViewHelper.setPivotY(paramView, paramView.getHeight() / 2);
    ViewHelper.setScaleX(paramView, 0.7F);
    ViewHelper.setScaleY(paramView, 0.7F);
    ViewHelper.setTranslationY(paramView, paramInt2 * (paramView.getHeight() / 2));
    ViewHelper.setAlpha(paramView, 127.0F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.translationYBy(paramInt2 * (-paramView.getHeight() / 2)).scaleX(1.0F).scaleY(1.0F).alpha(255.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.TiltEffect
 * JD-Core Version:    0.6.2
 */