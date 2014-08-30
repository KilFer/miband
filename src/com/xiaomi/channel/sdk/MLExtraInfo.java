package com.xiaomi.channel.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MLExtraInfo
{
  public String action = "";
  public int availableVersion = 0;
  public String extraUri = "";

  public void parseFromJson(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.action = localJSONObject.optString("action");
      this.extraUri = localJSONObject.optString("extraUri");
      this.availableVersion = localJSONObject.optInt("availableVersion");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", this.action);
      localJSONObject.put("extraUri", this.extraUri);
      localJSONObject.put("availableVersion", this.availableVersion);
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.MLExtraInfo
 * JD-Core Version:    0.6.2
 */