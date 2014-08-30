package com.tencent.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class a extends Handler
{
  a(AsynLoadImg paramAsynLoadImg, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    Log.v("AsynLoadImg", "handleMessage:" + paramMessage.arg1);
    if (paramMessage.arg1 == 0)
    {
      AsynLoadImg.a(this.a).saved(paramMessage.arg1, (String)paramMessage.obj);
      return;
    }
    AsynLoadImg.a(this.a).saved(paramMessage.arg1, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.a
 * JD-Core Version:    0.6.2
 */