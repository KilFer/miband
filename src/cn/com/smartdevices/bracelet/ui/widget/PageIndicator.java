package cn.com.smartdevices.bracelet.ui.widget;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public abstract interface PageIndicator extends ViewPager.OnPageChangeListener
{
  public abstract int getCount();

  public abstract int getOffset();

  public abstract void notifyDataSetChanged();

  public abstract void setCurrentItem(int paramInt);

  public abstract void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener);

  public abstract void setViewPager(ViewPager paramViewPager);

  public abstract void setViewPager(ViewPager paramViewPager, int paramInt);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.PageIndicator
 * JD-Core Version:    0.6.2
 */