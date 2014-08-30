package android.support.v4.view;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

class aK
{
  public boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramView == null)
      return false;
    ((AccessibilityManager)paramView.getContext().getSystemService("accessibility")).sendAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.aK
 * JD-Core Version:    0.6.2
 */