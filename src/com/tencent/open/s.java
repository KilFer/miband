package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

final class s
  implements Runnable
{
  s(TaskGuide paramTaskGuide)
  {
  }

  public final void run()
  {
    TaskGuide.a(this.a, TaskGuide.a(this.a, TaskGuide.f(this.a)));
    TaskGuide.a(this.a, TaskGuide.b(this.a, TaskGuide.g(this.a)));
    TaskGuide.h(this.a);
    WindowManager localWindowManager = (WindowManager)TaskGuide.i(this.a).getSystemService("window");
    if (((Activity)TaskGuide.j(this.a)).isFinishing())
      return;
    if (!TaskGuide.a(this.a))
      localWindowManager.addView(TaskGuide.b(this.a), TaskGuide.k(this.a));
    TaskGuide.a(this.a, true);
    TaskGuide.c(this.a, 2);
    TaskGuide.l(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.s
 * JD-Core Version:    0.6.2
 */