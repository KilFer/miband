package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;

final class q
  implements ViewPager.OnPageChangeListener
{
  private q(PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
  }

  public final void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
      PagerSlidingTabStrip.a(this.a, PagerSlidingTabStrip.b(this.a).getCurrentItem(), 0);
    if (this.a.delegatePageListener != null)
      this.a.delegatePageListener.onPageScrollStateChanged(paramInt);
  }

  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    PagerSlidingTabStrip.a(this.a, paramInt1);
    PagerSlidingTabStrip.a(this.a, paramFloat);
    PagerSlidingTabStrip.a(this.a, paramInt1, (int)(paramFloat * PagerSlidingTabStrip.a(this.a).getChildAt(paramInt1).getWidth()));
    this.a.invalidate();
    if (this.a.delegatePageListener != null)
      this.a.delegatePageListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }

  public final void onPageSelected(int paramInt)
  {
    if (this.a.delegatePageListener != null)
      this.a.delegatePageListener.onPageSelected(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.q
 * JD-Core Version:    0.6.2
 */