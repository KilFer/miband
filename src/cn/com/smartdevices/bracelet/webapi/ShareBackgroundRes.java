package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareBackgroundRes extends BaseRes
{
  public Object parse(String paramString)
  {
    ShareBackgroundItem localShareBackgroundItem = new ShareBackgroundItem();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WebStatus localWebStatus = getWebStatus(localJSONObject1);
      if ((!localWebStatus.isAuthInvalid()) && (!localWebStatus.success()))
        return localWebStatus;
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      if (localJSONObject2 != null)
      {
        JSONObject localJSONObject3 = localJSONObject2.getJSONObject("list");
        if (localJSONObject3 != null)
        {
          localShareBackgroundItem.reachedBgUrl = localJSONObject3.getString("reach");
          localShareBackgroundItem.unReachedBgUrl = localJSONObject3.getString("unreach");
        }
      }
      return localShareBackgroundItem;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Debug.i(this.TAG, localJSONException.getMessage());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.ShareBackgroundRes
 * JD-Core Version:    0.6.2
 */