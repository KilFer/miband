package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class GetLocationHelper
{
  private static final String a = "GetLocationHelper";
  private LocationManager b;
  private GetLocationHelper.ILocationGetter c;
  private double d = 0.0D;
  private double e = 0.0D;

  private static String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1.optString("status").equals("OK"))
      {
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("result");
        if (localJSONObject2 != null)
        {
          String str = localJSONObject2.getJSONObject("addressComponent").optString("city");
          return str;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }

  public void getSystemLocation(Context paramContext, GetLocationHelper.ILocationGetter paramILocationGetter)
  {
    this.c = paramILocationGetter;
    if (this.b == null)
      this.b = new LocationManager(paramContext);
    if (!this.b.getLocation(paramContext, new a(this)))
      this.c.onLocationGet("", this.e, this.d);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.GetLocationHelper
 * JD-Core Version:    0.6.2
 */