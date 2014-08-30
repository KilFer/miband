package com.tencent.utils;

import android.os.Bundle;
import org.json.JSONObject;

final class d extends Thread
{
  d(OpenConfig paramOpenConfig, Bundle paramBundle)
  {
  }

  public final void run()
  {
    try
    {
      JSONObject localJSONObject = Util.parseJson(HttpUtils.openUrl2(OpenConfig.a(this.b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).response);
      OpenConfig.a(this.b, localJSONObject);
      OpenConfig.a(this.b, 0);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.d
 * JD-Core Version:    0.6.2
 */