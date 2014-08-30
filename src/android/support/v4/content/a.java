package android.support.v4.content;

import java.util.concurrent.CountDownLatch;

final class a extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  boolean a;
  private D c;
  private CountDownLatch d = new CountDownLatch(1);

  a(AsyncTaskLoader paramAsyncTaskLoader)
  {
  }

  private D c()
  {
    this.c = this.e.onLoadInBackground();
    return this.c;
  }

  protected final void a()
  {
    try
    {
      this.e.a(this, this.c);
      return;
    }
    finally
    {
      this.d.countDown();
    }
  }

  protected final void a(D paramD)
  {
    try
    {
      this.e.b(this, paramD);
      return;
    }
    finally
    {
      this.d.countDown();
    }
  }

  public final void run()
  {
    this.a = false;
    this.e.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.a
 * JD-Core Version:    0.6.2
 */