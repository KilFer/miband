package cn.com.smartdevices.bracelet.view;

import android.os.Handler;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import cn.com.smartdevices.bracelet.Debug;

final class u extends GestureDetector.SimpleOnGestureListener
{
  u(RulerScrollView paramRulerScrollView)
  {
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    this.a.fling((int)paramFloat1);
    Debug.i("RulerScrollView", "fling end, vX:" + paramFloat1);
    RulerScrollView.a().postDelayed(new v(this), 500L);
    return true;
  }

  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.u
 * JD-Core Version:    0.6.2
 */