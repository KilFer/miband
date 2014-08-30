package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class a
  implements b
{
  public final boolean a(ConnectivityManager paramConnectivityManager)
  {
    NetworkInfo localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return true;
    switch (localNetworkInfo.getType())
    {
    case 0:
    default:
      return true;
    case 1:
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.a
 * JD-Core Version:    0.6.2
 */