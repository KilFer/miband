package com.twotoasters.jazzylistview;

import android.view.View;
import com.nineoldandroids.view.ViewPropertyAnimator;

public abstract interface JazzyEffect
{
  public abstract void initView(View paramView, int paramInt1, int paramInt2);

  public abstract void setupAnimation(View paramView, int paramInt1, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.JazzyEffect
 * JD-Core Version:    0.6.2
 */