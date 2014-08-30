package cn.com.smartdevices.bracelet.chart.deprecated;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class i
  implements View.OnTouchListener
{
  i(DynamicDetailFragmentOld paramDynamicDetailFragmentOld)
  {
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return DynamicDetailFragmentOld.d(this.a).onTouchEvent(paramMotionEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.i
 * JD-Core Version:    0.6.2
 */