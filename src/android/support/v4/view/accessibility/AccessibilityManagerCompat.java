package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public class AccessibilityManagerCompat
{
  private static final h a = new h();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new e();
      return;
    }
  }

  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat)
  {
    return a.a(paramAccessibilityManager, paramAccessibilityStateChangeListenerCompat);
  }

  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt)
  {
    return a.a(paramAccessibilityManager, paramInt);
  }

  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager)
  {
    return a.a(paramAccessibilityManager);
  }

  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager)
  {
    return a.b(paramAccessibilityManager);
  }

  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat)
  {
    return a.b(paramAccessibilityManager, paramAccessibilityStateChangeListenerCompat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityManagerCompat
 * JD-Core Version:    0.6.2
 */