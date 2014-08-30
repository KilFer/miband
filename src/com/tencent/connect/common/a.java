package com.tencent.connect.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

final class a extends Handler
{
  a(BaseApi.TempRequestListener paramTempRequestListener, Looper paramLooper, BaseApi paramBaseApi)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      BaseApi.TempRequestListener.a(this.b).onComplete((JSONObject)paramMessage.obj);
      return;
    }
    BaseApi.TempRequestListener.a(this.b).onError(new UiError(paramMessage.what, (String)paramMessage.obj, null));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.a
 * JD-Core Version:    0.6.2
 */