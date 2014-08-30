package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

final class e
{
  public static boolean a(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getCanRetrieveWindowContent();
  }

  public static String b(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getDescription();
  }

  public static String c(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getId();
  }

  public static ResolveInfo d(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getResolveInfo();
  }

  public static String e(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getSettingsActivityName();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.accessibilityservice.e
 * JD-Core Version:    0.6.2
 */