package com.xiaomi.account.openauth.utils;

import android.util.Log;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class a
  implements HostnameVerifier
{
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    Log.v("openauth", "WARNING: Hostname is not matched for cert.");
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.utils.a
 * JD-Core Version:    0.6.2
 */