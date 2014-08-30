package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewCompat
{
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  public static final int LAYER_TYPE_HARDWARE = 2;
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  private static final long a = 10L;
  private static ah b = new ah();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 17)
    {
      b = new ag();
      return;
    }
    if (i >= 16)
    {
      b = new af();
      return;
    }
    if (i >= 14)
    {
      b = new ae();
      return;
    }
    if (i >= 11)
    {
      b = new ad();
      return;
    }
    if (i >= 9)
    {
      b = new ac();
      return;
    }
  }

  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return b.b(paramView, paramInt);
  }

  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return b.c(paramView, paramInt);
  }

  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    return b.h(paramView);
  }

  public static float getAlpha(View paramView)
  {
    return b.c(paramView);
  }

  public static int getImportantForAccessibility(View paramView)
  {
    return b.g(paramView);
  }

  public static int getLabelFor(View paramView)
  {
    return b.j(paramView);
  }

  public static int getLayerType(View paramView)
  {
    return b.d(paramView);
  }

  public static int getLayoutDirection(View paramView)
  {
    return b.k(paramView);
  }

  public static int getOverScrollMode(View paramView)
  {
    return b.b(paramView);
  }

  public static ViewParent getParentForAccessibility(View paramView)
  {
    return b.i(paramView);
  }

  public static boolean hasTransientState(View paramView)
  {
    return b.e(paramView);
  }

  public static boolean isOpaque(View paramView)
  {
    return b.a(paramView);
  }

  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.b(paramView, paramAccessibilityEvent);
  }

  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    b.a(paramView, paramAccessibilityNodeInfoCompat);
  }

  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    b.a(paramView, paramAccessibilityEvent);
  }

  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return b.a(paramView, paramInt, paramBundle);
  }

  public static void postInvalidateOnAnimation(View paramView)
  {
    b.f(paramView);
  }

  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    b.a(paramView, paramRunnable);
  }

  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    b.a(paramView, paramRunnable, paramLong);
  }

  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    b.a(paramView, paramAccessibilityDelegateCompat);
  }

  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    b.a(paramView, paramBoolean);
  }

  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    b.d(paramView, paramInt);
  }

  public static void setLabelFor(View paramView, int paramInt)
  {
    b.e(paramView, paramInt);
  }

  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    b.a(paramView, paramPaint);
  }

  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    b.a(paramView, paramInt, paramPaint);
  }

  public static void setLayoutDirection(View paramView, int paramInt)
  {
    b.f(paramView, paramInt);
  }

  public static void setOverScrollMode(View paramView, int paramInt)
  {
    b.a(paramView, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.6.2
 */