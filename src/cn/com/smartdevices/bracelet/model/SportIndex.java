package cn.com.smartdevices.bracelet.model;

import org.json.JSONException;
import org.json.JSONObject;

public class SportIndex
{
  public int lenght = 0;
  public int startIndex = 0;
  public int stopIndex = 0;

  public SportIndex()
  {
  }

  public SportIndex(int paramInt1, int paramInt2)
  {
    this.startIndex = paramInt1;
    this.stopIndex = paramInt2;
  }

  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("startIndex", this.startIndex << 2);
      localJSONObject.put("stopIndex", this.stopIndex << 2);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public String toString()
  {
    return "index:" + this.startIndex + "->" + this.stopIndex;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SportIndex
 * JD-Core Version:    0.6.2
 */