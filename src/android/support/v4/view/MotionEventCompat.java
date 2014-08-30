package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class MotionEventCompat
{
  public static final int ACTION_HOVER_ENTER = 9;
  public static final int ACTION_HOVER_EXIT = 10;
  public static final int ACTION_HOVER_MOVE = 7;
  public static final int ACTION_MASK = 255;
  public static final int ACTION_POINTER_DOWN = 5;
  public static final int ACTION_POINTER_INDEX_MASK = 65280;
  public static final int ACTION_POINTER_INDEX_SHIFT = 8;
  public static final int ACTION_POINTER_UP = 6;
  public static final int ACTION_SCROLL = 8;
  private static L a = new J();

  static
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      a = new K();
      return;
    }
  }

  public static int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.a(paramMotionEvent, paramInt);
  }

  public static int getActionIndex(MotionEvent paramMotionEvent)
  {
    return 0xFF & paramMotionEvent.getAction() >> 8;
  }

  public static int getActionMasked(MotionEvent paramMotionEvent)
  {
    return 0xFF & paramMotionEvent.getAction();
  }

  public static int getPointerCount(MotionEvent paramMotionEvent)
  {
    return a.a(paramMotionEvent);
  }

  public static int getPointerId(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.b(paramMotionEvent, paramInt);
  }

  public static float getX(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.c(paramMotionEvent, paramInt);
  }

  public static float getY(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.d(paramMotionEvent, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MotionEventCompat
 * JD-Core Version:    0.6.2
 */