package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class B
  implements E
{
  public MenuItem a(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    return paramMenuItem;
  }

  public final MenuItem a(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }

  public final View a(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }

  public final void a(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }

  public final MenuItem b(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return false;
  }

  public boolean c(MenuItem paramMenuItem)
  {
    return false;
  }

  public boolean d(MenuItem paramMenuItem)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.B
 * JD-Core Version:    0.6.2
 */