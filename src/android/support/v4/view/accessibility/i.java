package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.ArrayList;
import java.util.List;

class i
{
  i()
  {
  }

  i(u paramu, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
  }

  public static Object a(d paramd)
  {
    return new j(paramd);
  }

  public static List<AccessibilityServiceInfo> a(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.getInstalledAccessibilityServiceList();
  }

  public static List<AccessibilityServiceInfo> a(AccessibilityManager paramAccessibilityManager, int paramInt)
  {
    return paramAccessibilityManager.getEnabledAccessibilityServiceList(paramInt);
  }

  public static boolean a(AccessibilityManager paramAccessibilityManager, Object paramObject)
  {
    return paramAccessibilityManager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)paramObject);
  }

  public static boolean b(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.isTouchExplorationEnabled();
  }

  public static boolean b(AccessibilityManager paramAccessibilityManager, Object paramObject)
  {
    return paramAccessibilityManager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)paramObject);
  }

  public Object a(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = this.a.createAccessibilityNodeInfo(paramInt);
    if (localAccessibilityNodeInfoCompat == null)
      return null;
    return localAccessibilityNodeInfoCompat.getInfo();
  }

  public List<Object> a(String paramString, int paramInt)
  {
    List localList = this.a.findAccessibilityNodeInfosByText(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    int i = localList.size();
    for (int j = 0; j < i; j++)
      localArrayList.add(((AccessibilityNodeInfoCompat)localList.get(j)).getInfo());
    return localArrayList;
  }

  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.a.performAction(paramInt1, paramInt2, paramBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.i
 * JD-Core Version:    0.6.2
 */