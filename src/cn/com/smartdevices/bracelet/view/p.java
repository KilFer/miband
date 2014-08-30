package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

final class p
  implements View.OnClickListener
{
  p(PagerSlidingTabStrip paramPagerSlidingTabStrip, int paramInt)
  {
  }

  public final void onClick(View paramView)
  {
    PagerSlidingTabStrip.b(this.a).setCurrentItem(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.p
 * JD-Core Version:    0.6.2
 */