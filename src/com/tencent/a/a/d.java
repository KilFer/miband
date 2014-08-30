package com.tencent.a.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Environment;
import com.tencent.a.b.b.a;
import com.tencent.a.b.c;
import java.io.File;

public class d
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  protected static final h b = new h(localFile, 24, 262144, 8192, "OpenSDK.Client.File.Tracer", 10000L, 10, ".app.log", 604800000L);
  protected static final h c = new h(localFile, 24, 262144, 8192, "OpenSDK.File.Tracer", 10000L, 10, ".OpenSDK.log", 604800000L);
  private volatile boolean a = false;
  protected a d;
  private volatile boolean e = true;
  private volatile boolean f = true;

  static
  {
    File localFile = c();
  }

  public static File c()
  {
    String str = b.a.a + File.separator + com.tencent.a.b.a.b();
    com.tencent.a.b.d locald = c.b();
    int i = 0;
    if (locald != null)
    {
      boolean bool = locald.c() < 8388608L;
      i = 0;
      if (bool)
        i = 1;
    }
    if (i != 0)
      return new File(Environment.getExternalStorageDirectory(), str);
    return new File(com.tencent.a.b.a.c(), str);
  }

  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (d())
    {
      if (!e())
        break label40;
      if (this.d != null)
        break label22;
    }
    label22: label40: 
    while (!f())
    {
      return;
      this.d.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable);
    }
    f.a.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable);
  }

  public void b()
  {
    if (this.d != null)
    {
      this.d.a();
      this.d.b();
    }
  }

  public final boolean d()
  {
    return false;
  }

  public final boolean e()
  {
    return this.e;
  }

  public final boolean f()
  {
    return this.f;
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("debug.file.tracelevel".equals(paramString))
    {
      int i = paramSharedPreferences.getInt("debug.file.tracelevel", 63);
      a(8, "WnsTracer", "File Trace Level Changed = " + i, null);
      this.d.a(i);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.a.a.d
 * JD-Core Version:    0.6.2
 */