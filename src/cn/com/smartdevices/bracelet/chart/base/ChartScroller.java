package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ChartScroller
{
  public static final int MIN_DELTA_FOR_SCROLLING = 1;
  private static final String a = "Chart.Scroller";
  private static final int b = 400;
  private ChartScroller.ScrollingListener c;
  private Context d;
  private GestureDetector e;
  private Scroller f;
  private int g;
  private float h;
  private int i;
  private float j;
  private boolean k;
  private boolean l;
  private Handler m;
  private GestureDetector.SimpleOnGestureListener n = new b(this);
  private final int o;
  private final int p;

  public ChartScroller(Context paramContext, ChartScroller.ScrollingListener paramScrollingListener)
  {
    this.d = paramContext;
    this.c = paramScrollingListener;
    this.e = new GestureDetector(paramContext, this.n);
    this.e.setIsLongpressEnabled(false);
    this.f = new Scroller(paramContext);
    this.m = new c(this);
  }

  private void a(int paramInt)
  {
    b();
    this.m.sendEmptyMessage(paramInt);
  }

  private void b()
  {
    this.m.removeMessages(0);
    this.m.removeMessages(1);
  }

  private void c()
  {
    this.c.onJustify();
    a(1);
  }

  private void d()
  {
    if (!this.k)
    {
      this.k = true;
      this.c.onStart();
    }
  }

  final void a()
  {
    if (this.k)
    {
      this.c.onFinish();
      this.k = false;
    }
  }

  public void forceFinishScrolling()
  {
    if (!this.f.isFinished())
      this.f.forceFinished(true);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
      bool = true;
    case 0:
    case 2:
    }
    label180: 
    while (true)
    {
      if ((!this.e.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
        c();
      return bool;
      this.h = paramMotionEvent.getX();
      this.j = paramMotionEvent.getY();
      this.f.forceFinished(true);
      b();
      bool = true;
      continue;
      int i1 = (int)(paramMotionEvent.getX() - this.h);
      int i2 = (int)(paramMotionEvent.getY() - this.j);
      if (i1 != 0)
      {
        d();
        bool = this.c.onScrollX(i1);
        this.h = paramMotionEvent.getX();
      }
      while (true)
      {
        if (i2 == 0)
          break label180;
        d();
        bool = this.c.onScrollY(i2);
        this.j = paramMotionEvent.getY();
        break;
        bool = true;
      }
    }
  }

  public void scrollX(int paramInt)
  {
    scrollX(paramInt, 0);
  }

  public void scrollX(int paramInt1, int paramInt2)
  {
    this.l = true;
    this.f.forceFinished(true);
    this.g = 0;
    Scroller localScroller = this.f;
    if (paramInt2 != 0);
    for (int i1 = paramInt2; ; i1 = 400)
    {
      localScroller.startScroll(0, 0, paramInt1, 0, i1);
      a(0);
      d();
      return;
    }
  }

  public void scrollY(int paramInt)
  {
    scrollY(paramInt, 0);
  }

  public void scrollY(int paramInt1, int paramInt2)
  {
    this.l = false;
    this.f.forceFinished(true);
    this.i = 0;
    Scroller localScroller = this.f;
    if (paramInt2 != 0);
    for (int i1 = paramInt2; ; i1 = 400)
    {
      localScroller.startScroll(0, 0, 0, paramInt1, i1);
      a(0);
      d();
      return;
    }
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.f.forceFinished(true);
    this.f = new Scroller(this.d, paramInterpolator);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.ChartScroller
 * JD-Core Version:    0.6.2
 */