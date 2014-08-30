package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

final class H extends AccessibilityDelegateCompat
{
  private final Rect a = new Rect();

  H(SlidingPaneLayout paramSlidingPaneLayout)
  {
  }

  private void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
  {
    Rect localRect = this.a;
    paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
    paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
    paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
    paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
    paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
    paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
    paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
    paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
    paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
    paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
    paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
    paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
    paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
    paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
  }

  private boolean a(View paramView)
  {
    return this.b.d(paramView);
  }

  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
  }

  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
    super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
    Rect localRect = this.a;
    localAccessibilityNodeInfoCompat.getBoundsInParent(localRect);
    paramAccessibilityNodeInfoCompat.setBoundsInParent(localRect);
    localAccessibilityNodeInfoCompat.getBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat.setBoundsInScreen(localRect);
    paramAccessibilityNodeInfoCompat.setVisibleToUser(localAccessibilityNodeInfoCompat.isVisibleToUser());
    paramAccessibilityNodeInfoCompat.setPackageName(localAccessibilityNodeInfoCompat.getPackageName());
    paramAccessibilityNodeInfoCompat.setClassName(localAccessibilityNodeInfoCompat.getClassName());
    paramAccessibilityNodeInfoCompat.setContentDescription(localAccessibilityNodeInfoCompat.getContentDescription());
    paramAccessibilityNodeInfoCompat.setEnabled(localAccessibilityNodeInfoCompat.isEnabled());
    paramAccessibilityNodeInfoCompat.setClickable(localAccessibilityNodeInfoCompat.isClickable());
    paramAccessibilityNodeInfoCompat.setFocusable(localAccessibilityNodeInfoCompat.isFocusable());
    paramAccessibilityNodeInfoCompat.setFocused(localAccessibilityNodeInfoCompat.isFocused());
    paramAccessibilityNodeInfoCompat.setAccessibilityFocused(localAccessibilityNodeInfoCompat.isAccessibilityFocused());
    paramAccessibilityNodeInfoCompat.setSelected(localAccessibilityNodeInfoCompat.isSelected());
    paramAccessibilityNodeInfoCompat.setLongClickable(localAccessibilityNodeInfoCompat.isLongClickable());
    paramAccessibilityNodeInfoCompat.addAction(localAccessibilityNodeInfoCompat.getActions());
    paramAccessibilityNodeInfoCompat.setMovementGranularities(localAccessibilityNodeInfoCompat.getMovementGranularities());
    localAccessibilityNodeInfoCompat.recycle();
    paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
    paramAccessibilityNodeInfoCompat.setSource(paramView);
    ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
    if ((localViewParent instanceof View))
      paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
    int i = this.b.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = this.b.getChildAt(j);
      if ((!a(localView)) && (localView.getVisibility() == 0))
      {
        ViewCompat.setImportantForAccessibility(localView, 1);
        paramAccessibilityNodeInfoCompat.addChild(localView);
      }
    }
  }

  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (!a(paramView))
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.H
 * JD-Core Version:    0.6.2
 */