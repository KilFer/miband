package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat
{
  public static final int INVALID_ID = -2147483648;
  private static final String a = View.class.getName();
  private final Rect b = new Rect();
  private final Rect c = new Rect();
  private final Rect d = new Rect();
  private final int[] e = new int[2];
  private final AccessibilityManager f;
  private final View g;
  private o h;
  private int i = -2147483648;
  private int j = -2147483648;

  public ExploreByTouchHelper(View paramView)
  {
    if (paramView == null)
      throw new IllegalArgumentException("View may not be null");
    this.g = paramView;
    this.f = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
  }

  private AccessibilityEvent a(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent2;
    switch (paramInt1)
    {
    default:
      localAccessibilityEvent2 = AccessibilityEvent.obtain(paramInt2);
      localAccessibilityEvent2.setEnabled(true);
      localAccessibilityEvent2.setClassName(a);
      onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent2);
      if ((localAccessibilityEvent2.getText().isEmpty()) && (localAccessibilityEvent2.getContentDescription() == null))
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
      break;
    case -1:
      AccessibilityEvent localAccessibilityEvent1 = AccessibilityEvent.obtain(paramInt2);
      ViewCompat.onInitializeAccessibilityEvent(this.g, localAccessibilityEvent1);
      return localAccessibilityEvent1;
    }
    localAccessibilityEvent2.setPackageName(this.g.getContext().getPackageName());
    AccessibilityEventCompat.asRecord(localAccessibilityEvent2).setSource(this.g, paramInt1);
    return localAccessibilityEvent2;
  }

  private void a(int paramInt)
  {
    if (this.j == paramInt)
      return;
    int k = this.j;
    this.j = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(k, 256);
  }

  private boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool2;
    switch (paramInt1)
    {
    default:
      switch (paramInt2)
      {
      default:
        bool2 = onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
      case 64:
      case 128:
      }
      break;
    case -1:
    }
    boolean bool1;
    do
    {
      boolean bool3;
      do
      {
        return bool2;
        return ViewCompat.performAccessibilityAction(this.g, paramInt2, paramBundle);
        switch (paramInt2)
        {
        default:
          return false;
        case 64:
          if ((!this.f.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.f)))
            return false;
          bool3 = e(paramInt1);
          bool2 = false;
        case 128:
        }
      }
      while (bool3);
      this.i = paramInt1;
      this.g.invalidate();
      sendEventForVirtualView(paramInt1, 32768);
      return true;
      bool1 = e(paramInt1);
      bool2 = false;
    }
    while (!bool1);
    this.i = -2147483648;
    this.g.invalidate();
    sendEventForVirtualView(paramInt1, 65536);
    return true;
  }

  private boolean a(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.g, paramInt, paramBundle);
  }

  private boolean a(Rect paramRect)
  {
    if ((paramRect == null) || (paramRect.isEmpty()))
      return false;
    if (this.g.getWindowVisibility() != 0)
      return false;
    View localView;
    for (ViewParent localViewParent = this.g.getParent(); (localViewParent instanceof View); localViewParent = localView.getParent())
    {
      localView = (View)localViewParent;
      if ((ViewCompat.getAlpha(localView) <= 0.0F) || (localView.getVisibility() != 0))
        return false;
    }
    if (localViewParent == null)
      return false;
    if (!this.g.getLocalVisibleRect(this.d))
      return false;
    return paramRect.intersect(this.d);
  }

  private AccessibilityNodeInfoCompat b()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.g);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.g, localAccessibilityNodeInfoCompat);
    LinkedList localLinkedList = new LinkedList();
    getVisibleVirtualViews(localLinkedList);
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localAccessibilityNodeInfoCompat.addChild(this.g, localInteger.intValue());
    }
    return localAccessibilityNodeInfoCompat;
  }

  private AccessibilityEvent b(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.g, localAccessibilityEvent);
    return localAccessibilityEvent;
  }

  private AccessibilityEvent b(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName(a);
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null))
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    localAccessibilityEvent.setPackageName(this.g.getContext().getPackageName());
    AccessibilityEventCompat.asRecord(localAccessibilityEvent).setSource(this.g, paramInt1);
    return localAccessibilityEvent;
  }

  private boolean b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool3;
    switch (paramInt2)
    {
    default:
      bool3 = onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
      return bool3;
    case 64:
    case 128:
    }
    switch (paramInt2)
    {
    default:
      bool1 = false;
    case 64:
    case 128:
    }
    while (true)
    {
      return bool1;
      if ((!this.f.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.f)))
      {
        bool1 = false;
      }
      else
      {
        boolean bool4 = e(paramInt1);
        bool3 = false;
        if (bool4)
          break;
        this.i = paramInt1;
        this.g.invalidate();
        sendEventForVirtualView(paramInt1, 32768);
        continue;
        boolean bool2 = e(paramInt1);
        bool3 = false;
        if (!bool2)
          break;
        this.i = -2147483648;
        this.g.invalidate();
        sendEventForVirtualView(paramInt1, 65536);
      }
    }
  }

  private AccessibilityNodeInfoCompat c(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat2;
    switch (paramInt)
    {
    default:
      localAccessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain();
      localAccessibilityNodeInfoCompat2.setEnabled(true);
      localAccessibilityNodeInfoCompat2.setClassName(a);
      onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat2);
      if ((localAccessibilityNodeInfoCompat2.getText() == null) && (localAccessibilityNodeInfoCompat2.getContentDescription() == null))
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
      break;
    case -1:
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain(this.g);
      ViewCompat.onInitializeAccessibilityNodeInfo(this.g, localAccessibilityNodeInfoCompat1);
      LinkedList localLinkedList = new LinkedList();
      getVisibleVirtualViews(localLinkedList);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localAccessibilityNodeInfoCompat1.addChild(this.g, localInteger.intValue());
      }
      return localAccessibilityNodeInfoCompat1;
    }
    localAccessibilityNodeInfoCompat2.getBoundsInParent(this.c);
    if (this.c.isEmpty())
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    int k = localAccessibilityNodeInfoCompat2.getActions();
    if ((k & 0x40) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    if ((k & 0x80) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    localAccessibilityNodeInfoCompat2.setPackageName(this.g.getContext().getPackageName());
    localAccessibilityNodeInfoCompat2.setSource(this.g, paramInt);
    localAccessibilityNodeInfoCompat2.setParent(this.g);
    if (this.i == paramInt)
    {
      localAccessibilityNodeInfoCompat2.setAccessibilityFocused(true);
      localAccessibilityNodeInfoCompat2.addAction(128);
    }
    while (true)
    {
      if (a(this.c))
      {
        localAccessibilityNodeInfoCompat2.setVisibleToUser(true);
        localAccessibilityNodeInfoCompat2.setBoundsInParent(this.c);
      }
      this.g.getLocationOnScreen(this.e);
      int m = this.e[0];
      int n = this.e[1];
      this.b.set(this.c);
      this.b.offset(m, n);
      localAccessibilityNodeInfoCompat2.setBoundsInScreen(this.b);
      return localAccessibilityNodeInfoCompat2;
      localAccessibilityNodeInfoCompat2.setAccessibilityFocused(false);
      localAccessibilityNodeInfoCompat2.addAction(64);
    }
  }

  private boolean c(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default:
      return false;
    case 64:
      if ((!this.f.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.f)))
        return false;
      if (!e(paramInt1))
      {
        this.i = paramInt1;
        this.g.invalidate();
        sendEventForVirtualView(paramInt1, 32768);
        return true;
      }
      return false;
    case 128:
    }
    if (e(paramInt1))
    {
      this.i = -2147483648;
      this.g.invalidate();
      sendEventForVirtualView(paramInt1, 65536);
      return true;
    }
    return false;
  }

  private AccessibilityNodeInfoCompat d(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.setClassName(a);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() == null) && (localAccessibilityNodeInfoCompat.getContentDescription() == null))
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    localAccessibilityNodeInfoCompat.getBoundsInParent(this.c);
    if (this.c.isEmpty())
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    int k = localAccessibilityNodeInfoCompat.getActions();
    if ((k & 0x40) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    if ((k & 0x80) != 0)
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    localAccessibilityNodeInfoCompat.setPackageName(this.g.getContext().getPackageName());
    localAccessibilityNodeInfoCompat.setSource(this.g, paramInt);
    localAccessibilityNodeInfoCompat.setParent(this.g);
    if (this.i == paramInt)
    {
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(true);
      localAccessibilityNodeInfoCompat.addAction(128);
    }
    while (true)
    {
      if (a(this.c))
      {
        localAccessibilityNodeInfoCompat.setVisibleToUser(true);
        localAccessibilityNodeInfoCompat.setBoundsInParent(this.c);
      }
      this.g.getLocationOnScreen(this.e);
      int m = this.e[0];
      int n = this.e[1];
      this.b.set(this.c);
      this.b.offset(m, n);
      localAccessibilityNodeInfoCompat.setBoundsInScreen(this.b);
      return localAccessibilityNodeInfoCompat;
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(false);
      localAccessibilityNodeInfoCompat.addAction(64);
    }
  }

  private boolean e(int paramInt)
  {
    return this.i == paramInt;
  }

  private boolean f(int paramInt)
  {
    if ((!this.f.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.f)));
    while (e(paramInt))
      return false;
    this.i = paramInt;
    this.g.invalidate();
    sendEventForVirtualView(paramInt, 32768);
    return true;
  }

  private boolean g(int paramInt)
  {
    if (e(paramInt))
    {
      this.i = -2147483648;
      this.g.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    }
    return false;
  }

  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.f.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.f)))
      bool = false;
    int k;
    do
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      case 8:
      default:
        return false;
      case 7:
      case 9:
        k = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        a(k);
      case 10:
      }
    }
    while (k != -2147483648);
    return false;
    if (this.i != -2147483648)
    {
      a(-2147483648);
      return bool;
    }
    return false;
  }

  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.h == null)
      this.h = new o(this, (byte)0);
    return this.h;
  }

  public int getFocusedVirtualView()
  {
    return this.i;
  }

  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);

  protected abstract void getVisibleVirtualViews(List<Integer> paramList);

  public void invalidateRoot()
  {
    invalidateVirtualView(-1);
  }

  public void invalidateVirtualView(int paramInt)
  {
    sendEventForVirtualView(paramInt, 2048);
  }

  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);

  protected abstract void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent);

  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);

  public boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -2147483648) || (!this.f.isEnabled()));
    ViewParent localViewParent;
    do
    {
      return false;
      localViewParent = this.g.getParent();
    }
    while (localViewParent == null);
    AccessibilityEvent localAccessibilityEvent;
    switch (paramInt1)
    {
    default:
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      localAccessibilityEvent.setEnabled(true);
      localAccessibilityEvent.setClassName(a);
      onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
      if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null))
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
      break;
    case -1:
      localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      ViewCompat.onInitializeAccessibilityEvent(this.g, localAccessibilityEvent);
    }
    while (true)
    {
      return ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.g, localAccessibilityEvent);
      localAccessibilityEvent.setPackageName(this.g.getContext().getPackageName());
      AccessibilityEventCompat.asRecord(localAccessibilityEvent).setSource(this.g, paramInt1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ExploreByTouchHelper
 * JD-Core Version:    0.6.2
 */