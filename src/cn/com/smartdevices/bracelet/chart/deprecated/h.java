package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import cn.com.smartdevices.bracelet.model.SportDay;

final class h
  implements GestureDetector.OnGestureListener
{
  h(DynamicDetailFragmentOld paramDynamicDetailFragmentOld)
  {
  }

  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (paramFloat1 > 1000.0F))
      if (DynamicDetailFragmentOld.a(this.a).after(DynamicDetailFragmentOld.b(this.a)))
      {
        DynamicDetailFragmentOld.a(this.a, DynamicDetailFragmentOld.a(this.a).addDay(-1));
        DynamicDetailFragmentOld.sRefreshHander.sendEmptyMessage(0);
      }
    while (true)
    {
      boolean bool2 = true;
      boolean bool3;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          bool1 = Math.abs(paramFloat1) < Math.abs(paramFloat2);
          bool2 = false;
        }
        while (!bool1);
        bool3 = paramFloat1 < -1000.0F;
        bool2 = false;
      }
      while (!bool3);
      if (DynamicDetailFragmentOld.a(this.a).before(DynamicDetailFragmentOld.c(this.a)))
      {
        DynamicDetailFragmentOld.a(this.a, DynamicDetailFragmentOld.a(this.a).addDay(1));
        DynamicDetailFragmentOld.sRefreshHander.sendEmptyMessage(0);
      }
    }
  }

  public final void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public final void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.h
 * JD-Core Version:    0.6.2
 */