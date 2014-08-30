package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class b extends Handler
{
  b(AuthAgent paramAuthAgent)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    c.b("openSDK_LOG", "OpenUi, handleMessage msg.what = " + paramMessage.what);
    if (paramMessage.what == 0)
      try
      {
        int j = Integer.parseInt(((JSONObject)paramMessage.obj).getString("ret"));
        i = j;
        if (i == 0)
        {
          AuthAgent.g(this.a).onComplete((JSONObject)paramMessage.obj);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          AuthAgent.e(this.a);
          int i = 0;
        }
        AuthAgent.e(this.a);
        return;
      }
    AuthAgent.g(this.a).onError(new UiError(paramMessage.what, (String)paramMessage.obj, null));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.b
 * JD-Core Version:    0.6.2
 */