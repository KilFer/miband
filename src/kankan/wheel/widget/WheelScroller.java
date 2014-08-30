package kankan.wheel.widget;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class WheelScroller
{
  public static final int MIN_DELTA_FOR_SCROLLING = 1;
  private static final int a = 400;
  private WheelScroller.ScrollingListener b;
  private Context c;
  private GestureDetector d = new GestureDetector(paramContext, this.i);
  private Scroller e;
  private int f;
  private float g;
  private boolean h;
  private GestureDetector.SimpleOnGestureListener i = new a(this);
  private final int j;
  private final int k;
  private Handler l = new b(this);

  public WheelScroller(Context paramContext, WheelScroller.ScrollingListener paramScrollingListener)
  {
    this.d.setIsLongpressEnabled(false);
    this.e = new Scroller(paramContext);
    this.b = paramScrollingListener;
    this.c = paramContext;
  }

  private void a(int paramInt)
  {
    b();
    this.l.sendEmptyMessage(paramInt);
  }

  private void b()
  {
    this.l.removeMessages(0);
    this.l.removeMessages(1);
  }

  private void c()
  {
    this.b.onJustify();
    a(1);
  }

  private void d()
  {
    if (!this.h)
    {
      this.h = true;
      this.b.onStarted();
    }
  }

  final void a()
  {
    if (this.h)
    {
      this.b.onFinished();
      this.h = false;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      if ((!this.d.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
        c();
      return true;
      this.g = paramMotionEvent.getY();
      this.e.forceFinished(true);
      b();
      continue;
      int m = (int)(paramMotionEvent.getY() - this.g);
      if (m != 0)
      {
        d();
        this.b.onScroll(m);
        this.g = paramMotionEvent.getY();
      }
    }
  }

  public void scroll(int paramInt1, int paramInt2)
  {
    this.e.forceFinished(true);
    this.f = 0;
    Scroller localScroller = this.e;
    if (paramInt2 != 0);
    for (int m = paramInt2; ; m = 400)
    {
      localScroller.startScroll(0, 0, 0, paramInt1, m);
      a(0);
      d();
      return;
    }
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.e.forceFinished(true);
    this.e = new Scroller(this.c, paramInterpolator);
  }

  public void stopScrolling()
  {
    this.e.forceFinished(true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.WheelScroller
 * JD-Core Version:    0.6.2
 */