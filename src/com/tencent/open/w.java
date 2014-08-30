package com.tencent.open;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Interpolator;

final class w
  implements Runnable
{
  private boolean a = false;
  private float b = 0.0F;

  public w(TaskGuide paramTaskGuide, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public final void run()
  {
    int i = 1;
    SystemClock.currentThreadTimeMillis();
    this.b = ((float)(0.1D + this.b));
    float f = this.b;
    if (f > 1.0F)
      f = 1.0F;
    int j;
    int k;
    if (f >= 1.0F)
    {
      j = i;
      k = (int)(TaskGuide.r(this.c).getInterpolation(f) * TaskGuide.s(this.c));
      if (!this.a)
        break label168;
      TaskGuide.k(this.c).y = (k + TaskGuide.t(this.c));
      label99: Log.d("TAG", "mWinParams.y = " + TaskGuide.k(this.c).y + "deltaDistence = " + k);
      if (TaskGuide.a(this.c))
        break label191;
    }
    while (true)
    {
      if (i == 0)
        break label223;
      TaskGuide.v(this.c);
      return;
      j = 0;
      break;
      label168: TaskGuide.k(this.c).y = (TaskGuide.t(this.c) - k);
      break label99;
      label191: TaskGuide.u(this.c).updateViewLayout(TaskGuide.b(this.c), TaskGuide.k(this.c));
      i = j;
    }
    label223: TaskGuide.x(this.c).postDelayed(TaskGuide.w(this.c), 5L);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.w
 * JD-Core Version:    0.6.2
 */