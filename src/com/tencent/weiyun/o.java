package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class o
  implements IUiListener
{
  o(RecordManager paramRecordManager, IUiListener paramIUiListener)
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
        this.a.onComplete(Boolean.TRUE);
        return;
      }
      this.a.onComplete(Boolean.FALSE);
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
 * Qualified Name:     com.tencent.weiyun.o
 * JD-Core Version:    0.6.2
 */