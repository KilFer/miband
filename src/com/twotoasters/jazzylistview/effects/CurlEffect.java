package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class CurlEffect
  implements JazzyEffect
{
  private static final int a = 90;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, 0.0F);
    ViewHelper.setPivotY(paramView, paramView.getHeight() / 2);
    ViewHelper.setRotationY(paramView, 90.0F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.rotationYBy(-90.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.CurlEffect
 * JD-Core Version:    0.6.2
 */