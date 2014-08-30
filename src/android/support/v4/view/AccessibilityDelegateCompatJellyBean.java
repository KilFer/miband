package android.support.v4.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class AccessibilityDelegateCompatJellyBean
{
  AccessibilityDelegateCompatJellyBean()
  {
  }

  AccessibilityDelegateCompatJellyBean(C paramC, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
  }

  public static Object a(AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean paramAccessibilityDelegateBridgeJellyBean)
  {
    return new h(paramAccessibilityDelegateBridgeJellyBean);
  }

  public static Object a(Object paramObject, View paramView)
  {
    return ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
  }

  public static boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return this.a.onMenuItemActionExpand(paramMenuItem);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return this.a.onMenuItemActionCollapse(paramMenuItem);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompatJellyBean
 * JD-Core Version:    0.6.2
 */