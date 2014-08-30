package kankan.wheel.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

final class a extends GestureDetector.SimpleOnGestureListener
{
  a(WheelScroller paramWheelScroller)
  {
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    WheelScroller.a(this.a, 0);
    WheelScroller.a(this.a).fling(0, WheelScroller.b(this.a), 0, (int)-paramFloat2, 0, 0, -2147483647, 2147483647);
    WheelScroller.b(this.a, 0);
    return true;
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.a
 * JD-Core Version:    0.6.2
 */