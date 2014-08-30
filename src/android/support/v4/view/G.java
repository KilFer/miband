package android.support.v4.view;

import android.view.MenuItem;

final class G
{
  public static MenuItem a(MenuItem paramMenuItem, AccessibilityDelegateCompatJellyBean paramAccessibilityDelegateCompatJellyBean)
  {
    return paramMenuItem.setOnActionExpandListener(new H(paramAccessibilityDelegateCompatJellyBean));
  }

  public static boolean a(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }

  public static boolean b(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }

  public static boolean c(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.G
 * JD-Core Version:    0.6.2
 */