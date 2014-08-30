package cn.com.smartdevices.bracelet.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareSportData
{
  public String date = "";
  public HashMap<Integer, Integer> hourActivityData = new HashMap();
  public int stepCalorie = 0;
  public int stepCount = 0;
  public int stepDistance = 0;

  public void fromString(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    this.date = localJSONObject1.getString("date");
    this.stepCalorie = localJSONObject1.getInt("stepCalorie");
    this.stepCount = localJSONObject1.getInt("stepCount");
    this.stepDistance = localJSONObject1.getInt("stepDistance");
    JSONArray localJSONArray = localJSONObject1.getJSONArray("activities");
    for (int i = 0; ; i++)
    {
      if (i >= localJSONArray.length())
        return;
      JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
      this.hourActivityData.put(Integer.valueOf(localJSONObject2.getInt("hour")), Integer.valueOf(localJSONObject2.getInt("activity")));
    }
  }

  public String toString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("date", this.date);
      localJSONObject1.put("stepCount", this.stepCount);
      localJSONObject1.put("stepDistance", this.stepDistance);
      localJSONObject1.put("stepCalorie", this.stepCalorie);
      JSONArray localJSONArray = new JSONArray();
      this.hourActivityData.entrySet();
      Iterator localIterator = this.hourActivityData.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          localJSONObject1.put("activities", localJSONArray);
          label102: return localJSONObject1.toString();
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("hour", ((Integer)localEntry.getKey()).intValue());
        localJSONObject2.put("activity", ((Integer)localEntry.getValue()).intValue());
        localJSONArray.put(localJSONObject2);
      }
    }
    catch (JSONException localJSONException)
    {
      break label102;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareSportData
 * JD-Core Version:    0.6.2
 */