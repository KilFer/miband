package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

class l extends m
{
  public final Object a()
  {
    return AccessibilityNodeInfo.obtain();
  }

  public final Object a(View paramView)
  {
    return AccessibilityNodeInfo.obtain(paramView);
  }

  public final Object a(Object paramObject)
  {
    return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)paramObject);
  }

  public final List<Object> a(Object paramObject, String paramString)
  {
    return (List)((AccessibilityNodeInfo)paramObject).findAccessibilityNodeInfosByText(paramString);
  }

  public final void a(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addAction(paramInt);
  }

  public final void a(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInParent(paramRect);
  }

  public final void a(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView);
  }

  public final void a(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setClassName(paramCharSequence);
  }

  public final void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setCheckable(paramBoolean);
  }

  public final int b(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getActions();
  }

  public final Object b(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).getChild(paramInt);
  }

  public final void b(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInScreen(paramRect);
  }

  public final void b(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView);
  }

  public final void b(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setContentDescription(paramCharSequence);
  }

  public final void b(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setChecked(paramBoolean);
  }

  public final int c(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getChildCount();
  }

  public final void c(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInParent(paramRect);
  }

  public final void c(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView);
  }

  public final void c(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setPackageName(paramCharSequence);
  }

  public final void c(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setClickable(paramBoolean);
  }

  public final boolean c(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).performAction(paramInt);
  }

  public final CharSequence d(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getClassName();
  }

  public final void d(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInScreen(paramRect);
  }

  public final void d(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setText(paramCharSequence);
  }

  public final void d(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setEnabled(paramBoolean);
  }

  public final CharSequence e(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getContentDescription();
  }

  public final void e(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocusable(paramBoolean);
  }

  public final CharSequence f(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getPackageName();
  }

  public final void f(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocused(paramBoolean);
  }

  public final Object g(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getParent();
  }

  public final void g(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setLongClickable(paramBoolean);
  }

  public final CharSequence h(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getText();
  }

  public final void h(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setPassword(paramBoolean);
  }

  public final int i(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getWindowId();
  }

  public final void i(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setScrollable(paramBoolean);
  }

  public final void j(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setSelected(paramBoolean);
  }

  public final boolean j(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isCheckable();
  }

  public final boolean k(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isChecked();
  }

  public final boolean l(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isClickable();
  }

  public final boolean m(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isEnabled();
  }

  public final boolean n(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocusable();
  }

  public final boolean o(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocused();
  }

  public final boolean p(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isLongClickable();
  }

  public final boolean q(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isPassword();
  }

  public final boolean r(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isScrollable();
  }

  public final boolean s(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isSelected();
  }

  public final void t(Object paramObject)
  {
    ((AccessibilityNodeInfo)paramObject).recycle();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.l
 * JD-Core Version:    0.6.2
 */