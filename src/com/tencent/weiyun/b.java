package com.tencent.weiyun;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class b extends Handler
{
  b(a parama, Looper paramLooper, FileManager paramFileManager)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      a.a(this.b).onError(new UiError(paramMessage.what, (String)paramMessage.obj, null));
      return;
    case 0:
      JSONObject localJSONObject1 = (JSONObject)paramMessage.obj;
      try
      {
        int j = localJSONObject1.getInt("ret");
        if (j != 0)
        {
          a.a(this.b).onError(new UiError(j, localJSONObject1.toString(), null));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        a.a(this.b).onError(new UiError(-4, localJSONException.getMessage(), null));
        return;
      }
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      a.a(this.b, localJSONObject2.getString("dl_encrypt_url"));
      a.b(this.b, localJSONObject2.getString("dl_cookie_name"));
      a.c(this.b, localJSONObject2.getString("dl_cookie_value"));
      a.a(this.b, localJSONObject2.getInt("dl_svr_port"));
      a.d(this.b, localJSONObject2.getString("dl_svr_host"));
      if (localJSONObject2.has("dl_thumb_size"))
        a.e(this.b, localJSONObject2.getString("dl_thumb_size"));
      a.a(this.b).onDownloadStart();
      a.b(this.b);
      return;
    case 1:
      int i = Integer.parseInt((String)paramMessage.obj);
      a.a(this.b).onDownloadProgress(i);
      return;
    case 2:
    }
    a.a(this.b).onDownloadSuccess(a.c(this.b));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.b
 * JD-Core Version:    0.6.2
 */