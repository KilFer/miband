package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

final class N
  implements View.OnClickListener
{
  N(PagerTabStrip paramPagerTabStrip)
  {
  }

  public final void onClick(View paramView)
  {
    this.a.a.setCurrentItem(-1 + this.a.a.getCurrentItem());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.N
 * JD-Core Version:    0.6.2
 */