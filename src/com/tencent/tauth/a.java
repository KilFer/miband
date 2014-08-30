package com.tencent.tauth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.a.a.c;

final class a extends Handler
{
  a(LocationApi paramLocationApi, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 102:
    default:
    case 103:
    case 104:
    case 101:
    }
    while (true)
    {
      super.handleMessage(paramMessage);
      return;
      c.b("openSDK_LOG", "location: verify sosocode success.");
      LocationApi.b(this.a).requestLocationUpdate(LocationApi.a(this.a), this.a);
      LocationApi.c(this.a).sendEmptyMessageDelayed(101, 10000L);
      continue;
      c.b("openSDK_LOG", "location: verify sosocode failed.");
      LocationApi.a(this.a, -14, "定位失败，验证定位码错误！");
      continue;
      c.b("openSDK_LOG", "location: get location timeout.");
      LocationApi.a(this.a, -13, "定位超时，请稍后再试或检查网络状况！");
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.a
 * JD-Core Version:    0.6.2
 */