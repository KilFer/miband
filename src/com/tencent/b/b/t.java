package com.tencent.b.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class t
{
  private static t b;
  private Context a;

  public static t a()
  {
    if (b == null)
      b = new t();
    return b;
  }

  public static Context b()
  {
    return a().a;
  }

  public static boolean c()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)a().a.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1)
          return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static boolean d()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)a().a.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isAvailable();
        return bool;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public final void a(Context paramContext)
  {
    if (this.a == null)
      this.a = paramContext.getApplicationContext();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.t
 * JD-Core Version:    0.6.2
 */