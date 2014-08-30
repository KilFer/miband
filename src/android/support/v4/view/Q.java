package android.support.v4.view;

import android.database.DataSetObserver;

final class Q extends DataSetObserver
  implements ViewPager.OnPageChangeListener, aE
{
  private int a;

  private Q(PagerTitleStrip paramPagerTitleStrip)
  {
  }

  public final void a(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    this.b.a(paramPagerAdapter1, paramPagerAdapter2);
  }

  public final void onChanged()
  {
    this.b.a(this.b.a.getCurrentItem(), this.b.a.getAdapter());
    boolean bool = PagerTitleStrip.a(this.b) < 0.0F;
    float f = 0.0F;
    if (!bool)
      f = PagerTitleStrip.a(this.b);
    this.b.a(this.b.a.getCurrentItem(), f, true);
  }

  public final void onPageScrollStateChanged(int paramInt)
  {
    this.a = paramInt;
  }

  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat > 0.5F)
      paramInt1++;
    this.b.a(paramInt1, paramFloat, false);
  }

  public final void onPageSelected(int paramInt)
  {
    if (this.a == 0)
    {
      this.b.a(this.b.a.getCurrentItem(), this.b.a.getAdapter());
      boolean bool = PagerTitleStrip.a(this.b) < 0.0F;
      float f = 0.0F;
      if (!bool)
        f = PagerTitleStrip.a(this.b);
      this.b.a(this.b.a.getCurrentItem(), f, true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.Q
 * JD-Core Version:    0.6.2
 */