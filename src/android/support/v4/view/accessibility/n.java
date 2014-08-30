package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class n extends l
{
  public final Object a(View paramView, int paramInt)
  {
    return AccessibilityNodeInfo.obtain(paramView, paramInt);
  }

  public final void a(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView, paramInt);
  }

  public final boolean a(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return ((AccessibilityNodeInfo)paramObject).performAction(paramInt, paramBundle);
  }

  public final void b(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView, paramInt);
  }

  public final void c(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView, paramInt);
  }

  public final Object d(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).findFocus(paramInt);
  }

  public final Object e(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).focusSearch(paramInt);
  }

  public final void f(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setMovementGranularities(paramInt);
  }

  public final void k(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }

  public final void l(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }

  public final int u(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getMovementGranularities();
  }

  public final boolean v(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }

  public final boolean w(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.n
 * JD-Core Version:    0.6.2
 */