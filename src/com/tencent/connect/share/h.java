package com.tencent.connect.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.utils.Util;
import java.util.ArrayList;

final class h
  implements Runnable
{
  h(ArrayList paramArrayList, Handler paramHandler)
  {
  }

  public final void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      String str1 = (String)this.a.get(i);
      Bitmap localBitmap;
      String str2;
      String str4;
      if ((!Util.isValidUrl(str1)) && (Util.fileExists(str1)))
      {
        localBitmap = a.a(str1, 10000);
        if (localBitmap != null)
        {
          str2 = Environment.getExternalStorageDirectory() + "/tmp/";
          String str3 = Util.encrypt(str1);
          str4 = "share2qzone_temp" + str3 + ".jpg";
          if (a.a(str1, 640, 10000))
            break label155;
          Log.d("AsynScaleCompressImage", "not out of bound,not compress!");
        }
      }
      while (true)
      {
        if (str1 != null)
          this.a.set(i, str1);
        i++;
        break;
        label155: Log.d("AsynScaleCompressImage", "out of bound, compress!");
        str1 = a.a(localBitmap, str2, str4);
      }
    }
    Message localMessage = this.b.obtainMessage(101);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("images", this.a);
    localMessage.setData(localBundle);
    this.b.sendMessage(localMessage);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.h
 * JD-Core Version:    0.6.2
 */