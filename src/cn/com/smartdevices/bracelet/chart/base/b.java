package cn.com.smartdevices.bracelet.chart.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

final class b extends GestureDetector.SimpleOnGestureListener
{
  b(ChartScroller paramChartScroller)
  {
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ChartScroller.a(this.a, 0);
    ChartScroller.b(this.a, 0);
    ChartScroller.a(this.a).fling(ChartScroller.b(this.a), ChartScroller.c(this.a), (int)-paramFloat1, (int)-paramFloat2, -5400, 5400, -5400, 5400);
    ChartScroller.c(this.a, 0);
    return true;
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.b
 * JD-Core Version:    0.6.2
 */