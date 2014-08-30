package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class WaveRightEffect
  implements JazzyEffect
{
  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setTranslationX(paramView, paramView.getWidth());
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.translationX(0.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.WaveRightEffect
 * JD-Core Version:    0.6.2
 */