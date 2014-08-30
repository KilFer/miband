package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  private static final t a = new t();
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new u();
      return;
    }
  }

  public AccessibilityNodeProviderCompat()
  {
    this.b = a.a(this);
  }

  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.b = paramObject;
  }

  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }

  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }

  public Object getProvider()
  {
    return this.b;
  }

  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
 * JD-Core Version:    0.6.2
 */