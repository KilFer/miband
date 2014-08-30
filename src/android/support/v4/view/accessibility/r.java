package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

final class r
{
  public static Object a(View paramView, int paramInt)
  {
    return AccessibilityNodeInfo.obtain(paramView, paramInt);
  }

  public static void a(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setMovementGranularities(paramInt);
  }

  public static void a(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView, paramInt);
  }

  public static void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }

  public static boolean a(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }

  public static boolean a(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return ((AccessibilityNodeInfo)paramObject).performAction(paramInt, paramBundle);
  }

  public static int b(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getMovementGranularities();
  }

  public static Object b(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).findFocus(paramInt);
  }

  public static void b(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView, paramInt);
  }

  public static void b(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }

  public static Object c(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).focusSearch(paramInt);
  }

  public static void c(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView, paramInt);
  }

  public static boolean c(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.r
 * JD-Core Version:    0.6.2
 */