package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

final class l
  implements IUiListener
{
  l(RecordManager paramRecordManager, IUiListener paramIUiListener)
  {
  }

  public final void onCancel()
  {
    this.a.onCancel();
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    try
    {
      if (localJSONObject.getInt("ret") == 0)
      {
        String str = localJSONObject.getJSONObject("data").getString("value");
        this.a.onComplete(Util.hexToString(str));
        return;
      }
      this.a.onError(new UiError(-4, localJSONObject.toString(), null));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a.onError(new UiError(-4, localJSONException.getMessage(), null));
    }
  }

  public final void onError(UiError paramUiError)
  {
    this.a.onError(paramUiError);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.l
 * JD-Core Version:    0.6.2
 */