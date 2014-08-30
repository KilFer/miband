package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.ErrorEvent;

final class f
  implements Thread.UncaughtExceptionHandler
{
  f(Context paramContext)
  {
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (!StatConfig.isEnableStatService())
      return;
    StatStore.getInstance(this.a).b(new ErrorEvent(this.a, StatService.a(this.a, false), 2, paramThrowable), null);
    StatService.a().debug("MTA has caught the following uncaught exception:");
    StatService.a().error(paramThrowable);
    if (StatService.b() != null)
    {
      StatService.a().debug("Call the original uncaught exception handler.");
      StatService.b().uncaughtException(paramThread, paramThrowable);
      return;
    }
    StatService.a().debug("Original uncaught exception handler not set.");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.f
 * JD-Core Version:    0.6.2
 */