package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityEventCompat
{
  public static final int TYPES_ALL_MASK = -1;
  public static final int TYPE_ANNOUNCEMENT = 16384;
  public static final int TYPE_GESTURE_DETECTION_END = 524288;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
  public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
  public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
  public static final int TYPE_VIEW_HOVER_ENTER = 128;
  public static final int TYPE_VIEW_HOVER_EXIT = 256;
  public static final int TYPE_VIEW_SCROLLED = 4096;
  public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
  public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
  public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
  private static final c a = new c();

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new a();
      return;
    }
  }

  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    a.a(paramAccessibilityEvent, paramAccessibilityRecordCompat.getImpl());
  }

  public static AccessibilityRecordCompat asRecord(AccessibilityEvent paramAccessibilityEvent)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent);
  }

  public static AccessibilityRecordCompat getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return new AccessibilityRecordCompat(a.a(paramAccessibilityEvent, paramInt));
  }

  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return a.a(paramAccessibilityEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityEventCompat
 * JD-Core Version:    0.6.2
 */