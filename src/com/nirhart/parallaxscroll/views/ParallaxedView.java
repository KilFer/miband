package com.nirhart.parallaxscroll.views;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class ParallaxedView
{
  public static boolean isAPI11;
  protected int lastOffset = 0;
  protected WeakReference<View> view;

  static
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (boolean bool = true; ; bool = false)
    {
      isAPI11 = bool;
      return;
    }
  }

  public ParallaxedView(View paramView)
  {
    this.view = new WeakReference(paramView);
  }

  public boolean is(View paramView)
  {
    return (paramView != null) && (this.view != null) && (this.view.get() != null) && (((View)this.view.get()).equals(paramView));
  }

  public void setOffset(float paramFloat)
  {
    View localView = (View)this.view.get();
    if (localView != null)
    {
      if (isAPI11)
        localView.setTranslationY(paramFloat);
    }
    else
      return;
    translatePreICS(localView, paramFloat);
  }

  public void setView(View paramView)
  {
    this.view = new WeakReference(paramView);
  }

  protected abstract void translatePreICS(View paramView, float paramFloat);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nirhart.parallaxscroll.views.ParallaxedView
 * JD-Core Version:    0.6.2
 */