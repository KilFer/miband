package com.tencent.open;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

final class F extends RelativeLayout
{
  private int a = 0;

  public F(TaskGuide paramTaskGuide, Context paramContext)
  {
    super(paramContext);
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    Log.d("XXXX", "onInterceptTouchEvent-- action = " + paramMotionEvent.getAction() + "currentY = " + i);
    TaskGuide.e(this.b, 3000);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.a = i;
      return false;
    }
    while (this.a - i <= 2 * ViewConfiguration.getTouchSlop());
    TaskGuide.q(this.b);
    return true;
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    int i = (int)paramMotionEvent.getY();
    Log.d("XXXX", " onTouchEvent-----startY = " + this.a + "currentY = " + i);
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return false;
      this.a = i;
      continue;
      if (this.a - i > 2 * ViewConfiguration.getTouchSlop())
        TaskGuide.q(this.b);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.F
 * JD-Core Version:    0.6.2
 */