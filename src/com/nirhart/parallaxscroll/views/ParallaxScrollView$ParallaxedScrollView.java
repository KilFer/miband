package com.nirhart.parallaxscroll.views;

import android.view.View;

public class ParallaxScrollView$ParallaxedScrollView extends ParallaxedView
{
  public ParallaxScrollView$ParallaxedScrollView(ParallaxScrollView paramParallaxScrollView, View paramView)
  {
    super(paramView);
  }

  protected void translatePreICS(View paramView, float paramFloat)
  {
    paramView.offsetTopAndBottom((int)paramFloat - this.lastOffset);
    this.lastOffset = ((int)paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nirhart.parallaxscroll.views.ParallaxScrollView.ParallaxedScrollView
 * JD-Core Version:    0.6.2
 */