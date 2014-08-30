package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class aD extends AccessibilityDelegateCompat
{
  aD(ViewPager paramViewPager)
  {
  }

  private boolean b()
  {
    return (ViewPager.a(this.a) != null) && (ViewPager.a(this.a).getCount() > 1);
  }

  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    AccessibilityRecordCompat localAccessibilityRecordCompat = AccessibilityRecordCompat.obtain();
    localAccessibilityRecordCompat.setScrollable(b());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.a(this.a) != null))
    {
      localAccessibilityRecordCompat.setItemCount(ViewPager.a(this.a).getCount());
      localAccessibilityRecordCompat.setFromIndex(ViewPager.b(this.a));
      localAccessibilityRecordCompat.setToIndex(ViewPager.b(this.a));
    }
  }

  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
    paramAccessibilityNodeInfoCompat.setScrollable(b());
    if (this.a.canScrollHorizontally(1))
      paramAccessibilityNodeInfoCompat.addAction(4096);
    if (this.a.canScrollHorizontally(-1))
      paramAccessibilityNodeInfoCompat.addAction(8192);
  }

  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      return true;
    switch (paramInt)
    {
    default:
      return false;
    case 4096:
      if (this.a.canScrollHorizontally(1))
      {
        this.a.setCurrentItem(1 + ViewPager.b(this.a));
        return true;
      }
      return false;
    case 8192:
    }
    if (this.a.canScrollHorizontally(-1))
    {
      this.a.setCurrentItem(-1 + ViewPager.b(this.a));
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.aD
 * JD-Core Version:    0.6.2
 */