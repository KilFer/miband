package cn.com.smartdevices.bracelet.model;

import android.util.Base64;
import cn.com.smartdevices.bracelet.Debug;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadData
{
  private static final String TAG = "UploadData";
  public byte[] data = null;
  public String date = "";
  public String indexs = "";
  public String summary = "";

  private void fromJSONObject(JSONObject paramJSONObject)
  {
    Debug.i("UploadData", "fromJSONObject:" + paramJSONObject.toString());
    try
    {
      String str = paramJSONObject.getString("data");
      this.date = paramJSONObject.getString("date");
      this.data = Base64.decode(str, 2);
      this.summary = paramJSONObject.getString("summary");
      Debug.i("UploadData", "fromJSONObject date:\n" + this.date);
      Debug.i("UploadData", "fromJSONObject summary:\n" + this.summary);
      Debug.i("UploadData", "fromJSONObject data:\n" + str);
      return;
    }
    catch (JSONException localJSONException)
    {
      Debug.i("UploadData", "fromJSONObject:" + localJSONException.getMessage());
    }
  }

  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str = Base64.encodeToString(this.data, 2);
      localJSONObject.put("date", this.date);
      localJSONObject.put("data", str);
      localJSONObject.put("summary", this.summary);
      localJSONObject.put("indexs", this.indexs);
      Debug.i("UploadData", "toJSONObject date:\n" + this.date);
      Debug.i("UploadData", "toJSONObject summary:\n" + this.summary);
      Debug.i("UploadData", "toJSONObject data:\n" + str);
      Debug.i("UploadData", "toJSONObject indexs:\n" + this.indexs);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Debug.i("UploadData", "toJSONObject:" + localJSONException.getMessage());
    }
    return localJSONObject;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.UploadData
 * JD-Core Version:    0.6.2
 */