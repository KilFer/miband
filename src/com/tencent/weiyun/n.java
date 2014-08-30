package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class n
  implements IUiListener
{
  n(RecordManager paramRecordManager, IUiListener paramIUiListener)
  {
  }

  public final void onCancel()
  {
    this.a.onCancel();
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject1 = (JSONObject)paramObject;
    try
    {
      if (localJSONObject1.getInt("ret") == 0)
      {
        ArrayList localArrayList = new ArrayList();
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
        if (!localJSONObject2.isNull("keys"))
        {
          JSONArray localJSONArray = localJSONObject2.getJSONArray("keys");
          for (int i = 0; i < localJSONArray.length(); i++)
            localArrayList.add(Util.hexToString(localJSONArray.getJSONObject(i).getString("key")));
        }
        this.a.onComplete(localArrayList);
        return;
      }
      this.a.onError(new UiError(-4, localJSONObject1.toString(), null));
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
 * Qualified Name:     com.tencent.weiyun.n
 * JD-Core Version:    0.6.2
 */