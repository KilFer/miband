package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.View;
import java.util.List;

public class AccessibilityRecordCompat
{
  private static final C a = new C();
  private final Object b;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new D();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new B();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new A();
      return;
    }
  }

  public AccessibilityRecordCompat(Object paramObject)
  {
    this.b = paramObject;
  }

  public static AccessibilityRecordCompat obtain()
  {
    return new AccessibilityRecordCompat(a.a());
  }

  public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    return new AccessibilityRecordCompat(a.a(paramAccessibilityRecordCompat.b));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AccessibilityRecordCompat localAccessibilityRecordCompat;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localAccessibilityRecordCompat = (AccessibilityRecordCompat)paramObject;
        if (this.b != null)
          break;
      }
      while (localAccessibilityRecordCompat.b == null);
      return false;
    }
    while (this.b.equals(localAccessibilityRecordCompat.b));
    return false;
  }

  public int getAddedCount()
  {
    return a.b(this.b);
  }

  public CharSequence getBeforeText()
  {
    return a.c(this.b);
  }

  public CharSequence getClassName()
  {
    return a.d(this.b);
  }

  public CharSequence getContentDescription()
  {
    return a.e(this.b);
  }

  public int getCurrentItemIndex()
  {
    return a.f(this.b);
  }

  public int getFromIndex()
  {
    return a.g(this.b);
  }

  public Object getImpl()
  {
    return this.b;
  }

  public int getItemCount()
  {
    return a.h(this.b);
  }

  public int getMaxScrollX()
  {
    return a.w(this.b);
  }

  public int getMaxScrollY()
  {
    return a.x(this.b);
  }

  public Parcelable getParcelableData()
  {
    return a.i(this.b);
  }

  public int getRemovedCount()
  {
    return a.j(this.b);
  }

  public int getScrollX()
  {
    return a.k(this.b);
  }

  public int getScrollY()
  {
    return a.l(this.b);
  }

  public AccessibilityNodeInfoCompat getSource()
  {
    return a.m(this.b);
  }

  public List<CharSequence> getText()
  {
    return a.n(this.b);
  }

  public int getToIndex()
  {
    return a.o(this.b);
  }

  public int getWindowId()
  {
    return a.p(this.b);
  }

  public int hashCode()
  {
    if (this.b == null)
      return 0;
    return this.b.hashCode();
  }

  public boolean isChecked()
  {
    return a.q(this.b);
  }

  public boolean isEnabled()
  {
    return a.r(this.b);
  }

  public boolean isFullScreen()
  {
    return a.s(this.b);
  }

  public boolean isPassword()
  {
    return a.t(this.b);
  }

  public boolean isScrollable()
  {
    return a.u(this.b);
  }

  public void recycle()
  {
    a.v(this.b);
  }

  public void setAddedCount(int paramInt)
  {
    a.a(this.b, paramInt);
  }

  public void setBeforeText(CharSequence paramCharSequence)
  {
    a.a(this.b, paramCharSequence);
  }

  public void setChecked(boolean paramBoolean)
  {
    a.a(this.b, paramBoolean);
  }

  public void setClassName(CharSequence paramCharSequence)
  {
    a.b(this.b, paramCharSequence);
  }

  public void setContentDescription(CharSequence paramCharSequence)
  {
    a.c(this.b, paramCharSequence);
  }

  public void setCurrentItemIndex(int paramInt)
  {
    a.b(this.b, paramInt);
  }

  public void setEnabled(boolean paramBoolean)
  {
    a.b(this.b, paramBoolean);
  }

  public void setFromIndex(int paramInt)
  {
    a.c(this.b, paramInt);
  }

  public void setFullScreen(boolean paramBoolean)
  {
    a.c(this.b, paramBoolean);
  }

  public void setItemCount(int paramInt)
  {
    a.d(this.b, paramInt);
  }

  public void setMaxScrollX(int paramInt)
  {
    a.i(this.b, paramInt);
  }

  public void setMaxScrollY(int paramInt)
  {
    a.j(this.b, paramInt);
  }

  public void setParcelableData(Parcelable paramParcelable)
  {
    a.a(this.b, paramParcelable);
  }

  public void setPassword(boolean paramBoolean)
  {
    a.d(this.b, paramBoolean);
  }

  public void setRemovedCount(int paramInt)
  {
    a.e(this.b, paramInt);
  }

  public void setScrollX(int paramInt)
  {
    a.f(this.b, paramInt);
  }

  public void setScrollY(int paramInt)
  {
    a.g(this.b, paramInt);
  }

  public void setScrollable(boolean paramBoolean)
  {
    a.e(this.b, paramBoolean);
  }

  public void setSource(View paramView)
  {
    a.a(this.b, paramView);
  }

  public void setSource(View paramView, int paramInt)
  {
    a.a(this.b, paramView, paramInt);
  }

  public void setToIndex(int paramInt)
  {
    a.h(this.b, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityRecordCompat
 * JD-Core Version:    0.6.2
 */