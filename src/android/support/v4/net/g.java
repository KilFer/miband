package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class g
{
  public static boolean a(ConnectivityManager paramConnectivityManager)
  {
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return true;
    switch (localNetworkInfo.getType())
    {
    case 0:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 8:
    default:
      return true;
    case 1:
    case 7:
    case 9:
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.g
 * JD-Core Version:    0.6.2
 */