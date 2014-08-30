package kankan.wheel.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

final class b extends Handler
{
  b(WheelScroller paramWheelScroller)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    WheelScroller.a(this.a).computeScrollOffset();
    int i = WheelScroller.a(this.a).getCurrY();
    int j = WheelScroller.b(this.a) - i;
    WheelScroller.a(this.a, i);
    if (j != 0)
      WheelScroller.c(this.a).onScroll(j);
    if (Math.abs(i - WheelScroller.a(this.a).getFinalY()) <= 0)
    {
      WheelScroller.a(this.a).getFinalY();
      WheelScroller.a(this.a).forceFinished(true);
    }
    if (!WheelScroller.a(this.a).isFinished())
    {
      WheelScroller.d(this.a).sendEmptyMessage(paramMessage.what);
      return;
    }
    if (paramMessage.what == 0)
    {
      WheelScroller.e(this.a);
      return;
    }
    this.a.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.b
 * JD-Core Version:    0.6.2
 */