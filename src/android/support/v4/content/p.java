package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class p extends u<Params, Result>
{
  p(ModernAsyncTask paramModernAsyncTask)
  {
    super((byte)0);
  }

  public final Result call()
  {
    ModernAsyncTask.a(this.b).set(true);
    Process.setThreadPriority(10);
    return ModernAsyncTask.a(this.b, this.b.a(this.a));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.p
 * JD-Core Version:    0.6.2
 */