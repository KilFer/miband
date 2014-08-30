package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

final class aI extends aJ
{
  public final boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return ViewParentCompatICS.requestSendAccessibilityEvent(paramViewParent, paramView, paramAccessibilityEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.aI
 * JD-Core Version:    0.6.2
 */