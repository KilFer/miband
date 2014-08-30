package com.tencent.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.File;

final class b
  implements Runnable
{
  b(AsynLoadImg paramAsynLoadImg)
  {
  }

  public final void run()
  {
    Log.v("AsynLoadImg", "saveFileRunnable:");
    String str1 = Util.encrypt(AsynLoadImg.b(this.a));
    String str2 = "share_qq_" + str1 + ".jpg";
    String str3 = AsynLoadImg.a() + str2;
    File localFile = new File(str3);
    Message localMessage = AsynLoadImg.c(this.a).obtainMessage();
    if (localFile.exists())
    {
      localMessage.arg1 = 0;
      localMessage.obj = str3;
      Log.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - AsynLoadImg.d(this.a)));
      AsynLoadImg.c(this.a).sendMessage(localMessage);
      return;
    }
    Bitmap localBitmap = AsynLoadImg.getbitmap(AsynLoadImg.b(this.a));
    boolean bool;
    if (localBitmap != null)
    {
      bool = this.a.saveFile(localBitmap, str2);
      label182: if (!bool)
        break label249;
      localMessage.arg1 = 0;
      localMessage.obj = str3;
    }
    while (true)
    {
      Log.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - AsynLoadImg.d(this.a)));
      break;
      Log.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
      bool = false;
      break label182;
      label249: localMessage.arg1 = 1;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.b
 * JD-Core Version:    0.6.2
 */