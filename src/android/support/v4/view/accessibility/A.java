package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

class A extends C
{
  public final Object a()
  {
    return AccessibilityRecord.obtain();
  }

  public final Object a(Object paramObject)
  {
    return AccessibilityRecord.obtain((AccessibilityRecord)paramObject);
  }

  public final void a(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setAddedCount(paramInt);
  }

  public final void a(Object paramObject, Parcelable paramParcelable)
  {
    ((AccessibilityRecord)paramObject).setParcelableData(paramParcelable);
  }

  public final void a(Object paramObject, View paramView)
  {
    ((AccessibilityRecord)paramObject).setSource(paramView);
  }

  public final void a(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setBeforeText(paramCharSequence);
  }

  public final void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setChecked(paramBoolean);
  }

  public final int b(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getAddedCount();
  }

  public final void b(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setCurrentItemIndex(paramInt);
  }

  public final void b(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setClassName(paramCharSequence);
  }

  public final void b(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setEnabled(paramBoolean);
  }

  public final CharSequence c(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getBeforeText();
  }

  public final void c(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setFromIndex(paramInt);
  }

  public final void c(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setContentDescription(paramCharSequence);
  }

  public final void c(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setFullScreen(paramBoolean);
  }

  public final CharSequence d(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getClassName();
  }

  public final void d(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setItemCount(paramInt);
  }

  public final void d(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setPassword(paramBoolean);
  }

  public final CharSequence e(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getContentDescription();
  }

  public final void e(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setRemovedCount(paramInt);
  }

  public final void e(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setScrollable(paramBoolean);
  }

  public final int f(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getCurrentItemIndex();
  }

  public final void f(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setScrollX(paramInt);
  }

  public final int g(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getFromIndex();
  }

  public final void g(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setScrollY(paramInt);
  }

  public final int h(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getItemCount();
  }

  public final void h(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setToIndex(paramInt);
  }

  public final Parcelable i(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getParcelableData();
  }

  public final int j(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getRemovedCount();
  }

  public final int k(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getScrollX();
  }

  public final int l(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getScrollY();
  }

  public final AccessibilityNodeInfoCompat m(Object paramObject)
  {
    return AccessibilityNodeInfoCompat.a(((AccessibilityRecord)paramObject).getSource());
  }

  public final List<CharSequence> n(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getText();
  }

  public final int o(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getToIndex();
  }

  public final int p(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getWindowId();
  }

  public final boolean q(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isChecked();
  }

  public final boolean r(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isEnabled();
  }

  public final boolean s(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isFullScreen();
  }

  public final boolean t(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isPassword();
  }

  public final boolean u(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isScrollable();
  }

  public final void v(Object paramObject)
  {
    ((AccessibilityRecord)paramObject).recycle();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.A
 * JD-Core Version:    0.6.2
 */