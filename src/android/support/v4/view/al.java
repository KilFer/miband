package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class al
{
  public static void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }

  public static void a(View paramView, Object paramObject)
  {
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramObject);
  }

  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }

  public static void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }

  public static void b(View paramView, Object paramObject)
  {
    paramView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)paramObject);
  }

  public static boolean b(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.al
 * JD-Core Version:    0.6.2
 */