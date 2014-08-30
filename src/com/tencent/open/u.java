package com.tencent.open;

import android.os.Handler;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class u extends C
{
  int a = -1;

  public u(TaskGuide paramTaskGuide, int paramInt)
  {
    super(paramTaskGuide, (byte)0);
    this.a = paramInt;
  }

  protected final void a(Exception paramException)
  {
    if (paramException != null)
      paramException.printStackTrace();
    this.b.a.onError(new UiError(101, "error ", "金券领取时出现异常"));
    if (TaskGuide.x(this.b) != null)
      TaskGuide.x(this.b).post(new v(this, paramException));
  }

  public final void onComplete(JSONObject paramJSONObject)
  {
    String str = null;
    while (true)
    {
      JSONObject localJSONObject2;
      try
      {
        int i = paramJSONObject.getInt("code");
        str = paramJSONObject.getString("message");
        if (i == 0)
        {
          TaskGuide.a(this.b, this.a, z.e);
          JSONObject localJSONObject1 = new JSONObject();
          try
          {
            localJSONObject1.put("result", "金券领取成功");
            this.b.a.onComplete(localJSONObject1);
            TaskGuide.c(this.b, this.a);
            TaskGuide.e(this.b, 2000);
            return;
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
            continue;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        TaskGuide.a(this.b, this.a, z.d);
        TaskGuide.a(this.b, str);
        localJSONException1.printStackTrace();
        continue;
        TaskGuide.a(this.b, this.a, z.d);
        TaskGuide.a(this.b, str);
        localJSONObject2 = new JSONObject();
      }
      try
      {
        localJSONObject2.put("result", "金券领取失败");
        this.b.a.onComplete(localJSONObject2);
      }
      catch (JSONException localJSONException3)
      {
        while (true)
          localJSONException3.printStackTrace();
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.u
 * JD-Core Version:    0.6.2
 */