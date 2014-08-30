package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class z
{
  z(u paramu, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
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
 * Qualified Name:     android.support.v4.view.accessibility.z
 * JD-Core Version:    0.6.2
 */