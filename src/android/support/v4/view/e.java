package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

final class e
  implements AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
{
  e(d paramd, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
  }

  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }

  public final Object getAccessibilityNodeProvider(View paramView)
  {
    AccessibilityNodeProviderCompat localAccessibilityNodeProviderCompat = this.a.getAccessibilityNodeProvider(paramView);
    if (localAccessibilityNodeProviderCompat != null)
      return localAccessibilityNodeProviderCompat.getProvider();
    return null;
  }

  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }

  public final void onInitializeAccessibilityNodeInfo(View paramView, Object paramObject)
  {
    this.a.onInitializeAccessibilityNodeInfo(paramView, new AccessibilityNodeInfoCompat(paramObject));
  }

  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }

  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }

  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return this.a.performAccessibilityAction(paramView, paramInt, paramBundle);
  }

  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    this.a.sendAccessibilityEvent(paramView, paramInt);
  }

  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.e
 * JD-Core Version:    0.6.2
 */