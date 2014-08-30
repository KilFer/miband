package com.sina.weibo.sdk.auth.sso;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.sina.sso.RemoteSSO;
import com.sina.sso.RemoteSSO.Stub;
import com.sina.weibo.sdk.auth.WeiboAuth;

class SsoHandler$1
  implements ServiceConnection
{
  SsoHandler$1(SsoHandler paramSsoHandler)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    RemoteSSO localRemoteSSO = RemoteSSO.Stub.asInterface(paramIBinder);
    try
    {
      String str1 = localRemoteSSO.getPackageName();
      String str2 = localRemoteSSO.getActivityName();
      if (!SsoHandler.access$2(this.this$0, str1, str2))
        SsoHandler.access$0(this.this$0).anthorize(SsoHandler.access$1(this.this$0));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    SsoHandler.access$0(this.this$0).anthorize(SsoHandler.access$1(this.this$0));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.sso.SsoHandler.1
 * JD-Core Version:    0.6.2
 */