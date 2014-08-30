package com.tencent.weiyun;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.UiError;
import com.tencent.utils.DataConvert;
import org.json.JSONObject;

final class g extends Handler
{
  g(f paramf, Looper paramLooper, FileManager paramFileManager)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      f.a(this.b).onError(new UiError(paramMessage.what, (String)paramMessage.obj, null));
      return;
    case 0:
      JSONObject localJSONObject1 = (JSONObject)paramMessage.obj;
      try
      {
        int j = localJSONObject1.getInt("ret");
        if (j != 0)
        {
          f.a(this.b).onError(new UiError(j, localJSONObject1.toString(), null));
          return;
        }
      }
      catch (Exception localException)
      {
        f.a(this.b).onError(new UiError(-4, localException.getMessage(), null));
        return;
      }
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      String str = localJSONObject2.getString("csum");
      f.a(this.b, DataConvert.string2bytes(str));
      f.a(this.b, localJSONObject2.getString("host"));
      f.a(this.b).onUploadStart();
      f.b(this.b);
      return;
    case 1:
      int i = Integer.parseInt((String)paramMessage.obj);
      f.a(this.b).onUploadProgress(i);
      return;
    case 2:
    }
    f.a(this.b).onUploadSuccess();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.g
 * JD-Core Version:    0.6.2
 */