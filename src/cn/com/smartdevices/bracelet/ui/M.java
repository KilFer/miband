package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class M
  implements GestureDetector.OnGestureListener
{
  M(DynamicDetailFragment paramDynamicDetailFragment)
  {
  }

  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (paramFloat1 > 1000.0F))
      DynamicFragment.mHandler.sendEmptyMessage(4119);
    while (true)
    {
      return true;
      if ((Math.abs(paramFloat1) <= Math.abs(paramFloat2)) || (paramFloat1 >= -1000.0F))
        break;
      DynamicFragment.mHandler.sendEmptyMessage(4120);
    }
    return false;
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
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.M
 * JD-Core Version:    0.6.2
 */