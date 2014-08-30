package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompat
{
  private static aJ a = new aJ();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new aI();
      return;
    }
  }

  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(paramViewParent, paramView, paramAccessibilityEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat
 * JD-Core Version:    0.6.2
 */