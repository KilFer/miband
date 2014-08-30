package cn.com.smartdevices.bracelet.view;

import android.database.DataSetObserver;

final class G extends DataSetObserver
{
  private G(VerticalViewPager paramVerticalViewPager)
  {
  }

  public final void onChanged()
  {
    this.a.a();
  }

  public final void onInvalidated()
  {
    this.a.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.G
 * JD-Core Version:    0.6.2
 */