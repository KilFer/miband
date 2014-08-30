package com.tencent.a.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class a extends g
  implements Handler.Callback
{
  private h a;
  private FileWriter b;
  private File c;
  private char[] d;
  private volatile e e;
  private volatile e f;
  private volatile e g;
  private volatile e h;
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;

  public a(int paramInt, boolean paramBoolean, b paramb, h paramh)
  {
    super(paramInt, paramBoolean, paramb);
    a(paramh);
    this.e = new e();
    this.f = new e();
    this.g = this.e;
    this.h = this.f;
    this.d = new char[paramh.f()];
    paramh.b();
    h();
    this.j = new HandlerThread(paramh.c(), paramh.i());
    if (this.j != null)
      this.j.start();
    if ((this.j.isAlive()) && (this.j.getLooper() != null))
      this.k = new Handler(this.j.getLooper(), this);
    f();
  }

  public a(h paramh)
  {
    this(63, true, b.a, paramh);
  }

  private void f()
  {
    if (this.k != null)
      this.k.sendEmptyMessageDelayed(1024, c().g());
  }

  // ERROR //
  private void g()
  {
    // Byte code:
    //   0: invokestatic 117	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: aload_0
    //   4: getfield 72	com/tencent/a/a/a:j	Landroid/os/HandlerThread;
    //   7: if_acmpeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 32	com/tencent/a/a/a:i	Z
    //   15: ifne -5 -> 10
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 32	com/tencent/a/a/a:i	Z
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 46	com/tencent/a/a/a:g	Lcom/tencent/a/a/e;
    //   29: aload_0
    //   30: getfield 42	com/tencent/a/a/a:e	Lcom/tencent/a/a/e;
    //   33: if_acmpne +49 -> 82
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 44	com/tencent/a/a/a:f	Lcom/tencent/a/a/e;
    //   41: putfield 46	com/tencent/a/a/a:g	Lcom/tencent/a/a/e;
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 42	com/tencent/a/a/a:e	Lcom/tencent/a/a/e;
    //   49: putfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   58: aload_0
    //   59: invokespecial 60	com/tencent/a/a/a:h	()Ljava/io/Writer;
    //   62: aload_0
    //   63: getfield 55	com/tencent/a/a/a:d	[C
    //   66: invokevirtual 120	com/tencent/a/a/e:a	(Ljava/io/Writer;[C)V
    //   69: aload_0
    //   70: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   73: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 32	com/tencent/a/a/a:i	Z
    //   81: return
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 42	com/tencent/a/a/a:e	Lcom/tencent/a/a/e;
    //   87: putfield 46	com/tencent/a/a/a:g	Lcom/tencent/a/a/e;
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 44	com/tencent/a/a/a:f	Lcom/tencent/a/a/e;
    //   95: putfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   98: goto -46 -> 52
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   111: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   114: goto -38 -> 76
    //   117: astore_2
    //   118: aload_0
    //   119: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   122: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   125: aload_2
    //   126: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	52	101	finally
    //   52	54	101	finally
    //   82	98	101	finally
    //   54	69	106	java/io/IOException
    //   54	69	117	finally
  }

  private Writer h()
  {
    File localFile = c().a();
    if ((localFile != null) && (!localFile.equals(this.c)))
    {
      this.c = localFile;
      i();
    }
    try
    {
      this.b = new FileWriter(this.c, true);
      return this.b;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private void i()
  {
    try
    {
      if (this.b != null)
      {
        this.b.flush();
        this.b.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void j()
  {
    try
    {
      if (this.g == this.e)
        this.g = this.f;
      for (this.h = this.e; ; this.h = this.f)
      {
        return;
        this.g = this.e;
      }
    }
    finally
    {
    }
  }

  public void a()
  {
    if (this.k.hasMessages(1024))
      this.k.removeMessages(1024);
  }

  protected void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(e().a(paramInt, paramThread, paramLong, paramString1, paramString2, paramThrowable));
  }

  public void a(h paramh)
  {
    this.a = paramh;
  }

  protected void a(String paramString)
  {
    this.g.a(paramString);
    if (this.g.a() >= c().f())
      a();
  }

  public void b()
  {
    i();
    this.j.quit();
  }

  public h c()
  {
    return this.a;
  }

  // ERROR //
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 188	android/os/Message:what	I
    //   4: tableswitch	default:+20 -> 24, 1024:+22->26
    //   25: ireturn
    //   26: invokestatic 117	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: aload_0
    //   30: getfield 72	com/tencent/a/a/a:j	Landroid/os/HandlerThread;
    //   33: if_acmpne +46 -> 79
    //   36: aload_0
    //   37: getfield 32	com/tencent/a/a/a:i	Z
    //   40: ifne +39 -> 79
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 32	com/tencent/a/a/a:i	Z
    //   48: aload_0
    //   49: invokespecial 190	com/tencent/a/a/a:j	()V
    //   52: aload_0
    //   53: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   56: aload_0
    //   57: invokespecial 60	com/tencent/a/a/a:h	()Ljava/io/Writer;
    //   60: aload_0
    //   61: getfield 55	com/tencent/a/a/a:d	[C
    //   64: invokevirtual 120	com/tencent/a/a/e:a	(Ljava/io/Writer;[C)V
    //   67: aload_0
    //   68: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   71: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 32	com/tencent/a/a/a:i	Z
    //   79: aload_0
    //   80: invokespecial 92	com/tencent/a/a/a:f	()V
    //   83: iconst_1
    //   84: ireturn
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   90: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   93: goto -19 -> 74
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 48	com/tencent/a/a/a:h	Lcom/tencent/a/a/e;
    //   101: invokevirtual 121	com/tencent/a/a/e:b	()V
    //   104: aload_2
    //   105: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   52	67	85	java/io/IOException
    //   52	67	96	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a
 * JD-Core Version:    0.6.2
 */