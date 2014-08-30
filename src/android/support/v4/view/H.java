package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class H
  implements MenuItem.OnActionExpandListener
{
  private AccessibilityDelegateCompatJellyBean a;

  public H(AccessibilityDelegateCompatJellyBean paramAccessibilityDelegateCompatJellyBean)
  {
    this.a = paramAccessibilityDelegateCompatJellyBean;
  }

  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.a.b(paramMenuItem);
  }

  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.a.a(paramMenuItem);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.H
 * JD-Core Version:    0.6.2
 */