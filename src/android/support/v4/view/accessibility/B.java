package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

class B extends A
{
  public final void i(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setMaxScrollX(paramInt);
  }

  public final void j(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setMaxScrollY(paramInt);
  }

  public final int w(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getMaxScrollX();
  }

  public final int x(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getMaxScrollY();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.B
 * JD-Core Version:    0.6.2
 */