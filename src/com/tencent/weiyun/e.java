package com.tencent.weiyun;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
  implements IUiListener
{
  private IGetFileListListener a;

  public e(FileManager paramFileManager, IGetFileListListener paramIGetFileListListener)
  {
    this.a = paramIGetFileListListener;
  }

  public final void onCancel()
  {
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject1 = (JSONObject)paramObject;
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      if (!localJSONObject2.isNull("content"))
      {
        JSONArray localJSONArray = localJSONObject2.getJSONArray("content");
        for (int i = 0; i < localJSONArray.length(); i++)
        {
          JSONObject localJSONObject3 = localJSONArray.getJSONObject(i);
          localArrayList.add(new WeiyunFile(localJSONObject3.getString("file_id"), localJSONObject3.getString("file_name"), localJSONObject3.getString("file_ctime"), localJSONObject3.getInt("file_size")));
        }
      }
      this.a.onComplete(localArrayList);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a.onError(new UiError(-4, "服务器返回数据格式有误!", localJSONObject1.toString()));
    }
  }

  public final void onError(UiError paramUiError)
  {
    this.a.onError(paramUiError);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.weiyun.e
 * JD-Core Version:    0.6.2
 */