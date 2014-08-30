package cn.com.smartdevices.bracelet.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class o
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  o(PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
  }

  public final void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16)
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    while (true)
    {
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.b(this.a).getCurrentItem());
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.c(this.a), 0);
      return;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.o
 * JD-Core Version:    0.6.2
 */