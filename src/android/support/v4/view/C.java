package android.support.v4.view;

import android.view.MenuItem;

final class C extends B
{
  public final MenuItem a(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if (paramOnActionExpandListener == null)
      return G.a(paramMenuItem, null);
    return G.a(paramMenuItem, new AccessibilityDelegateCompatJellyBean(this, paramOnActionExpandListener));
  }

  public final boolean b(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }

  public final boolean c(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }

  public final boolean d(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.C
 * JD-Core Version:    0.6.2
 */