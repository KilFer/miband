package com.tencent.connect.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.utils.AsynLoadImgBack;
import java.util.ArrayList;

final class g extends Handler
{
  g(Looper paramLooper, AsynLoadImgBack paramAsynLoadImgBack)
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
    }
    ArrayList localArrayList = paramMessage.getData().getStringArrayList("images");
    this.a.batchSaved(0, localArrayList);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.g
 * JD-Core Version:    0.6.2
 */