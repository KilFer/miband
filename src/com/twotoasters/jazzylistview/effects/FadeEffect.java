package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class FadeEffect
  implements JazzyEffect
{
  private static final int a = 5;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setAlpha(paramView, 0.0F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.setDuration(3000L);
    paramViewPropertyAnimator.alpha(255.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.FadeEffect
 * JD-Core Version:    0.6.2
 */