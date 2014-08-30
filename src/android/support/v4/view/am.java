package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

final class am
{
  public static void a(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }

  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }

  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }

  public static void a(View paramView, boolean paramBoolean)
  {
    paramView.setHasTransientState(paramBoolean);
  }

  public static boolean a(View paramView)
  {
    return paramView.hasTransientState();
  }

  public static boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }

  public static void b(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }

  public static int c(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }

  public static Object d(View paramView)
  {
    return paramView.getAccessibilityNodeProvider();
  }

  public static ViewParent e(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.am
 * JD-Core Version:    0.6.2
 */