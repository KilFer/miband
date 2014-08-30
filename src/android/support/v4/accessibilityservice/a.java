package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class a extends d
{
  public final boolean a(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getCanRetrieveWindowContent();
  }

  public final String b(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getDescription();
  }

  public final String c(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getId();
  }

  public final ResolveInfo d(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getResolveInfo();
  }

  public final String e(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return paramAccessibilityServiceInfo.getSettingsActivityName();
  }

  public int f(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    if (paramAccessibilityServiceInfo.getCanRetrieveWindowContent())
      return 1;
    return 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.accessibilityservice.a
 * JD-Core Version:    0.6.2
 */