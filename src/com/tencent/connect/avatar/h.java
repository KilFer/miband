package com.tencent.connect.avatar;

import android.os.Handler;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class h
  implements IUiListener
{
  h(ImageActivity paramImageActivity)
  {
  }

  private void a()
  {
    if (ImageActivity.m(this.a) < 2)
      ImageActivity.n(this.a);
  }

  public final void onCancel()
  {
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    int i = -1;
    try
    {
      i = localJSONObject.getInt("ret");
      if (i == 0)
      {
        String str = localJSONObject.getString("nickname");
        ImageActivity.l(this.a).post(new i(this, str));
        this.a.a("10659", 0L);
      }
      while (true)
      {
        if (i != 0)
          a();
        return;
        this.a.a("10661", 0L);
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public final void onError(UiError paramUiError)
  {
    a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.h
 * JD-Core Version:    0.6.2
 */