package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

final class F
{
  public static Object a()
  {
    return AccessibilityRecord.obtain();
  }

  public static Object a(Object paramObject)
  {
    return AccessibilityRecord.obtain((AccessibilityRecord)paramObject);
  }

  public static void a(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setAddedCount(paramInt);
  }

  public static void a(Object paramObject, Parcelable paramParcelable)
  {
    ((AccessibilityRecord)paramObject).setParcelableData(paramParcelable);
  }

  public static void a(Object paramObject, View paramView)
  {
    ((AccessibilityRecord)paramObject).setSource(paramView);
  }

  public static void a(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setBeforeText(paramCharSequence);
  }

  public static void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setChecked(paramBoolean);
  }

  public static int b(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getAddedCount();
  }

  public static void b(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setCurrentItemIndex(paramInt);
  }

  public static void b(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setClassName(paramCharSequence);
  }

  public static void b(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setEnabled(paramBoolean);
  }

  public static CharSequence c(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getBeforeText();
  }

  public static void c(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setFromIndex(paramInt);
  }

  public static void c(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityRecord)paramObject).setContentDescription(paramCharSequence);
  }

  public static void c(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setFullScreen(paramBoolean);
  }

  public static CharSequence d(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getClassName();
  }

  public static void d(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setItemCount(paramInt);
  }

  public static void d(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setPassword(paramBoolean);
  }

  public static CharSequence e(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getContentDescription();
  }

  public static void e(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setRemovedCount(paramInt);
  }

  public static void e(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityRecord)paramObject).setScrollable(paramBoolean);
  }

  public static int f(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getCurrentItemIndex();
  }

  public static void f(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setScrollX(paramInt);
  }

  public static int g(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getFromIndex();
  }

  public static void g(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setScrollY(paramInt);
  }

  public static int h(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getItemCount();
  }

  public static void h(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setToIndex(paramInt);
  }

  public static Parcelable i(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getParcelableData();
  }

  public static int j(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getRemovedCount();
  }

  public static int k(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getScrollX();
  }

  public static int l(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getScrollY();
  }

  public static Object m(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getSource();
  }

  public static List<CharSequence> n(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getText();
  }

  public static int o(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getToIndex();
  }

  public static int p(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getWindowId();
  }

  public static boolean q(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isChecked();
  }

  public static boolean r(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isEnabled();
  }

  public static boolean s(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isFullScreen();
  }

  public static boolean t(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isPassword();
  }

  public static boolean u(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).isScrollable();
  }

  public static void v(Object paramObject)
  {
    ((AccessibilityRecord)paramObject).recycle();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.F
 * JD-Core Version:    0.6.2
 */