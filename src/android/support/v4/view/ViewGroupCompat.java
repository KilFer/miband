package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ViewGroupCompat
{
  private static au a = new au();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      a = new at();
      return;
    }
    if (i >= 11)
    {
      a = new as();
      return;
    }
  }

  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a.a(paramViewGroup, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat
 * JD-Core Version:    0.6.2
 */