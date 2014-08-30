package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class ConnectivityManagerCompat
{
  private static final b a = new a();

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 13)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      a = new c();
      return;
    }
  }

  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    return paramConnectivityManager.getNetworkInfo(((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getType());
  }

  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return a.a(paramConnectivityManager);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat
 * JD-Core Version:    0.6.2
 */