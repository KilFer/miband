package com.tencent.open;

import android.os.Bundle;
import android.util.Log;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialApiIml$a
  implements IUiListener
{
  private c a;

  public SocialApiIml$a(SocialApiIml paramSocialApiIml, c paramc)
  {
    this.a = paramc;
  }

  public void onCancel()
  {
    SocialApiIml.a(this.b);
    b.a(this.a.c.getString("image_date"));
    SocialApiIml.a(this.b, SocialApiIml.b(this.b), null, this.a.b, this.a.c, this.a.d, this.a.e);
  }

  public void onComplete(Object paramObject)
  {
    Log.d("TAG", "CheckListener--onComplete--response = " + paramObject.toString());
    int i = 0;
    JSONObject localJSONObject;
    if (paramObject != null)
      localJSONObject = (JSONObject)paramObject;
    try
    {
      boolean bool = localJSONObject.getBoolean("check_result");
      i = bool;
      SocialApiIml.a(this.b);
      if (i != 0)
      {
        Log.d("TAG", "CheckListener---delayStartParam.agentIntent = " + this.a.a + " delayStartParam.action = " + this.a.b);
        SocialApiIml.a(this.b, SocialApiIml.b(this.b), this.a.a, this.a.b, this.a.c, this.a.d, this.a.e);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        i = 0;
      }
      b.a(this.a.c.getString("image_date"));
      SocialApiIml.a(this.b, SocialApiIml.b(this.b), null, this.a.b, this.a.c, this.a.d, this.a.e);
    }
  }

  public void onError(UiError paramUiError)
  {
    SocialApiIml.a(this.b);
    b.a(this.a.c.getString("image_date"));
    SocialApiIml.a(this.b, SocialApiIml.b(this.b), null, this.a.b, this.a.c, this.a.d, this.a.e);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.SocialApiIml.a
 * JD-Core Version:    0.6.2
 */