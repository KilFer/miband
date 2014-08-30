package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;

public class PersonInfo
{
  private static final int INCOMING_CALL_DISABLE_BIT = 256;
  public static final int SYNC_AVATAR_NEEDED = 1;
  public static final int SYNC_OK = 0;
  public static final int SYNC_PERSON_NEEDED = 2;
  private static final String TAG = "PersonInfo";
  public int age = -1;
  public ArrayList<AlarmClockItem> alarmClockItems = new ArrayList();
  public String avatarPath = "";
  public String avatarUrl = "";
  public String birthday = "";
  public String createTime = "";
  public String deviceId = "";
  public int gender = -1;
  public int gid = -1;
  public int height = -1;
  public String lastLoginTime = "";
  public UserLocationData location = new UserLocationData();
  public MiliConfig miliConfig = new MiliConfig();
  private int needSyncServer = 0;
  public String nickname = "";
  public String personSignature = "";
  public String pinyin = "#";
  public String sh = "";
  public String source = "";
  public int state = 0;
  public UserTotalSportData totalSportData = new UserTotalSportData();
  public long uid = -1L;
  public int weight = -1;

  public static ArrayList<AlarmClockItem> parseAlarmClockItems(String paramString)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)Utils.getGson().fromJson(paramString, new PersonInfo.1().getType());
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public void clearNeedSyncServer()
  {
    this.needSyncServer = 0;
  }

  public void disableInComingCallTime()
  {
    this.miliConfig.inComingCallNotifyTime = (0x100 | getInComingCallTime());
    Debug.i("PersonInfo", "disable incoming = " + this.miliConfig.inComingCallNotifyTime);
  }

  public void enableInComingCallTime()
  {
    this.miliConfig.inComingCallNotifyTime = (0xFF & getInComingCallTime());
    Debug.i("PersonInfo", "enable incoming = " + this.miliConfig.inComingCallNotifyTime);
  }

  public ArrayList<AlarmClockItem> getAlarmClockItems()
  {
    if (this.alarmClockItems == null)
      this.alarmClockItems = new ArrayList();
    ArrayList localArrayList;
    int i;
    int j;
    if (this.alarmClockItems.size() < 3)
    {
      localArrayList = Keeper.readMorningAlarms();
      i = 0;
      j = this.alarmClockItems.size();
      if (j >= 3)
      {
        Keeper.keepPersonInfo(this);
        Debug.i("PersonInfo", "add new alarm size=" + this.alarmClockItems.size());
      }
    }
    else
    {
      return this.alarmClockItems;
    }
    AlarmClockItem localAlarmClockItem = new AlarmClockItem();
    if ((localArrayList != null) && (localArrayList.size() > i))
      localAlarmClockItem.setCalendar((Calendar)localArrayList.get(i));
    for (int k = i + 1; ; k = i)
    {
      this.alarmClockItems.add(localAlarmClockItem);
      j++;
      i = k;
      break;
    }
  }

  public int getDaySportGoalSteps()
  {
    return this.miliConfig.goalStepsCount;
  }

  public int getInComingCallTime()
  {
    return 0xFF & this.miliConfig.inComingCallNotifyTime;
  }

  public String getMiliColor()
  {
    return this.miliConfig.lightColor;
  }

  public String getMiliWearHand()
  {
    return this.miliConfig.wearHand;
  }

  public int getNeedSyncServer()
  {
    return this.needSyncServer;
  }

  public boolean isInComingCallEnabled()
  {
    if ((0x100 & this.miliConfig.inComingCallNotifyTime) == 0);
    for (boolean bool = true; ; bool = false)
    {
      Debug.i("PersonInfo", "isInComingCallEnabled = " + bool);
      return bool;
    }
  }

  public boolean isValid()
  {
    return (this.uid != -1L) && (this.gender != -1) && (this.height != -1) && (this.weight != -1) && (this.age != -1) && (getDaySportGoalSteps() > 0);
  }

  public void setDaySportGoals(int paramInt)
  {
    this.miliConfig.goalStepsCount = paramInt;
  }

  public void setInComingCallTime(int paramInt)
  {
    if (isInComingCallEnabled());
    for (this.miliConfig.inComingCallNotifyTime = paramInt; ; this.miliConfig.inComingCallNotifyTime = (paramInt | 0x100 & this.miliConfig.inComingCallNotifyTime))
    {
      Debug.i("PersonInfo", "set incoming = " + this.miliConfig.inComingCallNotifyTime);
      return;
    }
  }

  public void setMiliColor(String paramString)
  {
    this.miliConfig.lightColor = paramString;
  }

  public void setMiliConfig(MiliConfig paramMiliConfig)
  {
    this.miliConfig = paramMiliConfig;
  }

  public void setMiliWearHand(String paramString)
  {
    this.miliConfig.wearHand = paramString;
  }

  public void setNeedSyncServer(int paramInt)
  {
    this.needSyncServer = (paramInt | this.needSyncServer);
  }

  public String toString()
  {
    return Utils.getGson().toJson(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.PersonInfo
 * JD-Core Version:    0.6.2
 */