package com.tencent.connect.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.utils.AsynLoadImgBack;

final class e extends Handler
{
  e(Looper paramLooper, AsynLoadImgBack paramAsynLoadImgBack)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
      return;
    case 101:
      String str = (String)paramMessage.obj;
      this.a.saved(0, str);
      return;
    case 102:
    }
    int i = paramMessage.arg1;
    this.a.saved(i, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.e
 * JD-Core Version:    0.6.2
 */