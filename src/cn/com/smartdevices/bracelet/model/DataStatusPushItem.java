package cn.com.smartdevices.bracelet.model;

import java.util.Date;
import org.json.JSONArray;

public class DataStatusPushItem extends BasePushItem
{
  public JSONArray dates = new JSONArray();
  public long timeStamp = 0L;
  public String uuid = "";

  public DataStatusPushItem()
  {
    super(1);
  }

  public String getContent()
  {
    return this.uuid + ":" + this.dates.toString() + "\n[" + new Date(this.timeStamp).toString() + "]";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.DataStatusPushItem
 * JD-Core Version:    0.6.2
 */