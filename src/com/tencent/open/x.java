package com.tencent.open;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class x extends C
{
  private x(TaskGuide paramTaskGuide)
  {
    super(paramTaskGuide, (byte)0);
  }

  protected final void a(Exception paramException)
  {
    if (paramException != null)
      paramException.printStackTrace();
    JSONObject localJSONObject;
    if (paramException == null)
      localJSONObject = new JSONObject();
    while (true)
    {
      try
      {
        localJSONObject.put("result", "暂无任务");
        this.a.a.onComplete(localJSONObject);
        TaskGuide.x(this.a).post(new y(this));
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      this.a.a.onError(new UiError(100, "error ", "获取任务失败"));
    }
  }

  public final void onComplete(JSONObject paramJSONObject)
  {
    try
    {
      TaskGuide.a(this.a, E.a(paramJSONObject));
      if (TaskGuide.y(this.a) != null)
      {
        E localE = TaskGuide.y(this.a);
        if ((!TextUtils.isEmpty(localE.a)) && (localE.b != null) && (localE.b.length > 0))
        {
          i = 1;
          if (i == 0)
            break label139;
          this.a.showWindow();
          TaskGuide.a(this.a, 2, z.d);
          localJSONObject = new JSONObject();
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        while (true)
        {
          JSONObject localJSONObject;
          localJSONObject.put("result", "获取成功");
          this.a.a.onComplete(localJSONObject);
          return;
          localJSONException1 = localJSONException1;
          localJSONException1.printStackTrace();
        }
        int i = 0;
      }
      catch (JSONException localJSONException2)
      {
        while (true)
          localJSONException2.printStackTrace();
      }
      label139: a(null);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.x
 * JD-Core Version:    0.6.2
 */