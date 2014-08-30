package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;

public class MiliConfig
{
  public static final String BLUE = "BLUE";
  public static final String GREEN = "GREEN";
  public static final String LEFT_HAND = "LEFT_HAND";
  public static final String ORANGE = "ORANGE";
  public static final String RED = "RED";
  public static final String RIGHT_HAND = "RIGHT_HAND";
  private static final String TAG = "MiliConfig";
  public int goalStepsCount = -1;
  public int inComingCallNotifyTime = 10;
  public String lightColor = "BLUE";
  public String wearHand = "LEFT_HAND";

  public static MiliConfig fromJsonStr(String paramString)
  {
    MiliConfig localMiliConfig = (MiliConfig)Utils.getGson().fromJson(paramString, MiliConfig.class);
    if (localMiliConfig == null)
      localMiliConfig = new MiliConfig();
    return localMiliConfig;
  }

  public boolean isValid()
  {
    if ((this.lightColor != null) && (!this.lightColor.equals("")) && (this.wearHand != null) && (!this.wearHand.equals("")) && (this.goalStepsCount > 0) && ((this.inComingCallNotifyTime == -1) || (this.inComingCallNotifyTime >= 0)));
    for (boolean bool = true; ; bool = false)
    {
      Debug.i("MiliConfig", "isValid=" + bool + ", " + this);
      return bool;
    }
  }

  public String toString()
  {
    String str = Utils.getGson().toJson(this);
    if (str == null)
      return null;
    return str.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.MiliConfig
 * JD-Core Version:    0.6.2
 */