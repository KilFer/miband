package com.twotoasters.jazzylistview.effects;

import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.JazzyEffect;

public class TwirlEffect
  implements JazzyEffect
{
  private static final int a = 80;
  private static final int b = 70;
  private static final int c = 10;

  public void initView(View paramView, int paramInt1, int paramInt2)
  {
    ViewHelper.setPivotX(paramView, paramView.getWidth() / 2);
    ViewHelper.setPivotY(paramView, paramView.getWidth() / 2);
    ViewHelper.setRotationX(paramView, 80.0F);
    ViewHelper.setRotationY(paramView, paramInt2 * 70);
    ViewHelper.setRotation(paramView, 10.0F);
  }

  public void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator)
  {
    paramViewPropertyAnimator.rotationXBy(-80.0F).rotationYBy(paramInt2 * -70).rotationBy(-10.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.effects.TwirlEffect
 * JD-Core Version:    0.6.2
 */