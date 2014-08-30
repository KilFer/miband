package com.nirhart.parallaxscroll.views;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class ParallaxListView$ParallaxedListView extends ParallaxedView
{
  public ParallaxListView$ParallaxedListView(ParallaxListView paramParallaxListView, View paramView)
  {
    super(paramView);
  }

  protected void translatePreICS(View paramView, float paramFloat)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, paramFloat, paramFloat);
    localTranslateAnimation.setDuration(0L);
    localTranslateAnimation.setFillAfter(true);
    paramView.setAnimation(localTranslateAnimation);
    localTranslateAnimation.start();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nirhart.parallaxscroll.views.ParallaxListView.ParallaxedListView
 * JD-Core Version:    0.6.2
 */