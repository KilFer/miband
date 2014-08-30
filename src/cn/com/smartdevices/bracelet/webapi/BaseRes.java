package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseRes
{
  protected String TAG = "BaseRes";

  public WebStatus getWebStatus(String paramString)
  {
    Debug.i(this.TAG, "getWebStatus:" + paramString);
    WebStatus localWebStatus = new WebStatus();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localWebStatus.code = localJSONObject.getInt("code");
      localWebStatus.message = localJSONObject.getString("message");
      return localWebStatus;
    }
    catch (JSONException localJSONException)
    {
      localWebStatus.code = 2;
      Debug.i(this.TAG, localJSONException.getMessage());
    }
    return localWebStatus;
  }

  public WebStatus getWebStatus(JSONObject paramJSONObject)
  {
    WebStatus localWebStatus = new WebStatus();
    try
    {
      localWebStatus.code = paramJSONObject.getInt("code");
      localWebStatus.message = paramJSONObject.getString("message");
      return localWebStatus;
    }
    catch (JSONException localJSONException)
    {
      localWebStatus.code = 2;
      Debug.i(this.TAG, localJSONException.getMessage());
    }
    return localWebStatus;
  }

  public abstract Object parse(String paramString);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.BaseRes
 * JD-Core Version:    0.6.2
 */