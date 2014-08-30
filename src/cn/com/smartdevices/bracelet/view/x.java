package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

final class x
  implements ScrollDetectors.ScrollDetector
{
  public final boolean canScrollHorizontal(View paramView, int paramInt)
  {
    ViewPager localViewPager = (ViewPager)paramView;
    PagerAdapter localPagerAdapter = localViewPager.getAdapter();
    if ((localPagerAdapter == null) || (localPagerAdapter.getCount() == 0));
    int i;
    do
    {
      return false;
      i = localViewPager.getCurrentItem();
    }
    while (((paramInt >= 0) || (i >= -1 + localPagerAdapter.getCount())) && ((paramInt <= 0) || (i <= 0)));
    return true;
  }

  public final boolean canScrollVertical(View paramView, int paramInt)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.x
 * JD-Core Version:    0.6.2
 */