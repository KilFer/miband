package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class UserLocationData
{
  private static final String TAG = "UserLocationData";
  public String city = "";
  public String latitude = "";
  public String longitude = "";

  public static UserLocationData fromJsonStr(String paramString)
  {
    UserLocationData localUserLocationData = new UserLocationData();
    try
    {
      JSONObject localJSONObject = new JSONObject(Utils.URLDecodeStr(paramString));
      localUserLocationData.city = localJSONObject.optString("city");
      localUserLocationData.longitude = localJSONObject.optString("longitude");
      localUserLocationData.latitude = localJSONObject.optString("latitude");
      return localUserLocationData;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.toString();
    }
    return localUserLocationData;
  }

  public boolean isValid()
  {
    return (this.city != null) && (this.longitude.length() > 0) && (this.latitude.length() > 0);
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public void setLocation(String paramString1, String paramString2, String paramString3)
  {
    this.city = paramString1;
    this.longitude = paramString2;
    this.latitude = paramString3;
  }

  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("city", this.city);
      localJSONObject.put("longitude", this.longitude);
      localJSONObject.put("latitude", this.latitude);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.UserLocationData
 * JD-Core Version:    0.6.2
 */