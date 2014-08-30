package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D>
{
  private static String b = "AsyncTaskLoader";
  private static boolean c;
  private volatile AsyncTaskLoader<D>.a d;
  private volatile AsyncTaskLoader<D>.a e;
  private long f;
  private long g = -10000L;
  private Handler h;

  public AsyncTaskLoader(Context paramContext)
  {
    super(paramContext);
  }

  final void a()
  {
    if ((this.e == null) && (this.d != null))
    {
      if (this.d.a)
      {
        this.d.a = false;
        this.h.removeCallbacks(this.d);
      }
      if ((this.f > 0L) && (SystemClock.uptimeMillis() < this.g + this.f))
      {
        this.d.a = true;
        this.h.postAtTime(this.d, this.g + this.f);
      }
    }
    else
    {
      return;
    }
    this.d.a(ModernAsyncTask.b, null);
  }

  final void a(AsyncTaskLoader<D>.a paramAsyncTaskLoader, D paramD)
  {
    onCanceled(paramD);
    if (this.e == paramAsyncTaskLoader)
    {
      rollbackContentChanged();
      this.g = SystemClock.uptimeMillis();
      this.e = null;
      a();
    }
  }

  final void b(AsyncTaskLoader<D>.a paramAsyncTaskLoader, D paramD)
  {
    if (this.d != paramAsyncTaskLoader)
    {
      a(paramAsyncTaskLoader, paramD);
      return;
    }
    if (isAbandoned())
    {
      onCanceled(paramD);
      return;
    }
    commitContentChanged();
    this.g = SystemClock.uptimeMillis();
    this.d = null;
    deliverResult(paramD);
  }

  public boolean cancelLoad()
  {
    if (this.d != null)
    {
      if (this.e != null)
      {
        if (this.d.a)
        {
          this.d.a = false;
          this.h.removeCallbacks(this.d);
        }
        this.d = null;
      }
    }
    else
      return false;
    if (this.d.a)
    {
      this.d.a = false;
      this.h.removeCallbacks(this.d);
      this.d = null;
      return false;
    }
    boolean bool = this.d.a(false);
    if (bool)
      this.e = this.d;
    this.d = null;
    return bool;
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.d != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.d.a);
    }
    if (this.e != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.e.a);
    }
    if (this.f != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      TimeUtils.formatDuration(this.f, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      TimeUtils.formatDuration(this.g, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }

  public abstract D loadInBackground();

  public void onCanceled(D paramD)
  {
  }

  protected void onForceLoad()
  {
    super.onForceLoad();
    cancelLoad();
    this.d = new a(this);
    a();
  }

  protected D onLoadInBackground()
  {
    return loadInBackground();
  }

  public void setUpdateThrottle(long paramLong)
  {
    this.f = paramLong;
    if (paramLong != 0L)
      this.h = new Handler();
  }

  public void waitForLoader()
  {
    a locala = this.d;
    if (locala != null);
    try
    {
      a.a(locala).await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader
 * JD-Core Version:    0.6.2
 */