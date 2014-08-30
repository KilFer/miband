package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class HelixEffect
  implements JazzyEffect
{
  private static final int a = 180;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setRotationY(paramView, 180.0F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.rotationYBy(paramInt2 * 180);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.HelixEffect
 * JD-Core Version:    0.6.2
 */