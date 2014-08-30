package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class SlideInEffect
  implements JazzyEffect
{
  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setTranslationY(paramView, paramInt2 * (paramView.getHeight() / 2));
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.translationYBy(paramInt2 * (-paramView.getHeight() / 2));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.SlideInEffect
 * JD-Core Version:    0.6.2
 */