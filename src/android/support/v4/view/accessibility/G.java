package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

final class G
{
  public static int a(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getMaxScrollX();
  }

  public static void a(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setMaxScrollX(paramInt);
  }

  public static int b(Object paramObject)
  {
    return ((AccessibilityRecord)paramObject).getMaxScrollY();
  }

  public static void b(Object paramObject, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setMaxScrollY(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.G
 * JD-Core Version:    0.6.2
 */