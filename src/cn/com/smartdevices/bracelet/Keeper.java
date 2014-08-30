package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Keeper
{
  private static final String a = "Keeper";
  private static final String b = "REF_MORING_ALARMS";
  private static SharedPreferences c = null;

  public static void KeepLastMonthReportDate(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("LastMonthReportDate", paramString);
    localEditor.commit();
  }

  public static void KeepLastWeekReportDate(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("LastWeekReportDate", paramString);
    localEditor.commit();
  }

  public static void clearPersonInfo()
  {
    keepPersonInfo(new PersonInfo());
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("person_info_mili_config", "");
    localEditor.putString("person_info_location", "");
    localEditor.putString("person_info_total_sport_data", "");
    localEditor.commit();
  }

  public static SharedPreferences getSharedPref()
  {
    return c;
  }

  public static void init(Context paramContext)
  {
    c = paramContext.getSharedPreferences("keeper", 0);
  }

  public static void keepAlarms(ArrayList<AlarmClockItem> paramArrayList)
  {
    SharedPreferences.Editor localEditor = c.edit();
    String str = Utils.getGson().toJson(paramArrayList);
    Debug.i("Keeper", "alarmStr =" + str);
    if ((str == null) || ("null".equals(str)))
      str = "";
    localEditor.putString("alarms", str);
    localEditor.commit();
  }

  public static void keepApkVersion(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("APKVersion", paramString);
    localEditor.commit();
  }

  public static void keepBraceletBtInfo(BraceletBtInfo paramBraceletBtInfo)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("bracelet_bt_name", paramBraceletBtInfo.name);
    if (paramBraceletBtInfo.address != null)
      localEditor.putString("bracelet_mac_address", paramBraceletBtInfo.address);
    localEditor.commit();
  }

  public static void keepBraceletStatisticTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("bracelet_statistic_time", paramLong);
    localEditor.commit();
  }

  public static void keepCheckUpdateApkDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("UPDATE_DATE_REF", Utils.getGson().toJson(localCalendar));
    localEditor.commit();
  }

  public static void keepConfigDynamicDataInfo(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("configDynamicDataInfo", paramString);
    localEditor.commit();
  }

  public static void keepContinueReachGoalRi(ReportInfo paramReportInfo)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("continue_reach_goal", paramReportInfo.date);
    localEditor.putString("continue_reach_report_date", paramReportInfo.reportDate);
    localEditor.commit();
  }

  public static void keepDebugFlag(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putBoolean("enable_debug_log", paramBoolean);
    localEditor.commit();
  }

  public static void keepDeviceId(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("device_id", paramString);
    localEditor.commit();
  }

  public static void keepDownloadApkId(long paramLong)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("DOWNLOAD_ID_REF", paramLong);
    localEditor.commit();
  }

  public static void keepFileDebugFlag(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putBoolean("enable_file_debug_log", paramBoolean);
    localEditor.commit();
  }

  public static void keepIsPlayEnterAnimation(Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putBoolean("isPlayEnterAnimation", paramBoolean.booleanValue());
    localEditor.commit();
  }

  public static void keepLatestDBLuaVersion(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("latestDBLuaVersion", paramString);
    localEditor.commit();
  }

  public static void keepLocaleStr()
  {
    Locale localLocale = Locale.getDefault();
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("Locale", localLocale.toString());
    localEditor.commit();
  }

  public static void keepLoginData(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("uid", paramLong);
    localEditor.putString("security", paramString);
    localEditor.commit();
  }

  public static void keepMorningAlarms(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("REF_MORING_ALARMS", paramString);
    localEditor.commit();
  }

  public static void keepNeedBind(int paramInt)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putInt("bind_state", paramInt);
    localEditor.commit();
  }

  public static void keepNetInfo(NetDataInfo paramNetDataInfo)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putInt("net_data_state", paramNetDataInfo.dataState);
    localEditor.putString("net_start_day", paramNetDataInfo.startDate);
    localEditor.putString("net_stop_day", paramNetDataInfo.stopDate);
    localEditor.commit();
  }

  public static void keepPersonInfo(PersonInfo paramPersonInfo)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("person_info_nickname", paramPersonInfo.nickname);
    localEditor.putString("person_info_avatar_url", paramPersonInfo.avatarUrl);
    localEditor.putString("person_info_avatar_path", paramPersonInfo.avatarPath);
    localEditor.putInt("person_info_age", paramPersonInfo.age);
    localEditor.putInt("person_info_gender", paramPersonInfo.gender);
    localEditor.putInt("person_info_height", paramPersonInfo.height);
    localEditor.putInt("person_info_weight", paramPersonInfo.weight);
    localEditor.putLong("person_info_uid", paramPersonInfo.uid);
    localEditor.putString("person_info_signature", paramPersonInfo.personSignature);
    localEditor.putString("person_info_sh", paramPersonInfo.sh);
    localEditor.putString("device_id", paramPersonInfo.deviceId);
    localEditor.putInt("person_info_need_sync_server", paramPersonInfo.getNeedSyncServer());
    if ((paramPersonInfo.miliConfig != null) && (paramPersonInfo.miliConfig.isValid()))
      localEditor.putString("person_info_mili_config", paramPersonInfo.miliConfig.toString());
    if ((paramPersonInfo.location != null) && (paramPersonInfo.location.isValid()))
      localEditor.putString("person_info_location", paramPersonInfo.location.toString());
    if ((paramPersonInfo.totalSportData != null) && (paramPersonInfo.totalSportData.isValid()))
      localEditor.putString("person_info_total_sport_data", paramPersonInfo.totalSportData.toString());
    localEditor.commit();
    keepAlarms(paramPersonInfo.alarmClockItems);
  }

  public static void keepPlayEnterAnimationType(int paramInt)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putInt("PlayEnterAnimationType", paramInt);
    localEditor.commit();
  }

  public static void keepPushAlias(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("push_alias", paramString);
    localEditor.commit();
  }

  public static void keepShareBgItem(ShareBackgroundItem paramShareBackgroundItem)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("reached_bg_url", paramShareBackgroundItem.reachedBgUrl);
    localEditor.putString("unreached_bg_url", paramShareBackgroundItem.unReachedBgUrl);
    localEditor.commit();
  }

  public static void keepSwitchOperator(SwitchOperator paramSwitchOperator)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putInt("switch_type", paramSwitchOperator.type);
    localEditor.putBoolean("enable_clear_data", paramSwitchOperator.enableClearData);
    localEditor.putBoolean("enable_write_realtime_steps", paramSwitchOperator.enableSteps);
    localEditor.putInt("realtime_steps", paramSwitchOperator.steps);
    localEditor.putLong("last_uid", paramSwitchOperator.lastUid);
    localEditor.putString("last_mac_address", paramSwitchOperator.lastMacAddress);
    localEditor.putString("switch_date", paramSwitchOperator.date);
    localEditor.commit();
  }

  public static void keepSyncBraceletTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("sync_bracelet_time", paramLong);
    localEditor.commit();
  }

  public static void keepSyncRealStepTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("sync_real_step_time", paramLong);
    localEditor.commit();
  }

  public static void keepSyncTime(long paramLong)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putLong("sync_time", paramLong);
    localEditor.commit();
  }

  public static void keepUUID(String paramString)
  {
    SharedPreferences.Editor localEditor = c.edit();
    localEditor.putString("push_uuid", paramString);
    localEditor.commit();
  }

  public static ArrayList<AlarmClockItem> readAlarms()
  {
    String str = c.getString("alarms", "");
    try
    {
      ArrayList localArrayList = PersonInfo.parseAlarmClockItems(str);
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static String readApkVersion()
  {
    return c.getString("APKVersion", "85:1.0.20140625.2");
  }

  public static BraceletBtInfo readBraceletBtInfo()
  {
    BraceletBtInfo localBraceletBtInfo = new BraceletBtInfo();
    localBraceletBtInfo.name = c.getString("bracelet_bt_name", "");
    localBraceletBtInfo.address = c.getString("bracelet_mac_address", "");
    return localBraceletBtInfo;
  }

  public static long readBraceletStatisticTime()
  {
    return c.getLong("bracelet_statistic_time", -1L);
  }

  public static String readConfigDynamicDataInfo()
  {
    return c.getString("configDynamicDataInfo", "{}");
  }

  public static ReportInfo readContinueReachGoalRi()
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.date = c.getString("continue_reach_goal", "");
    localReportInfo.reportDate = c.getString("continue_reach_report_date", "");
    return localReportInfo;
  }

  public static boolean readDebugFlag()
  {
    return c.getBoolean("enable_debug_log", false);
  }

  public static String readDeviceId()
  {
    return c.getString("device_id", "");
  }

  public static long readDownloadApkId()
  {
    return c.getLong("DOWNLOAD_ID_REF", -1L);
  }

  public static boolean readFileDebugFlag()
  {
    return c.getBoolean("enable_file_debug_log", true);
  }

  public static Boolean readIsPlayEnterAnimation()
  {
    return Boolean.valueOf(c.getBoolean("isPlayEnterAnimation", false));
  }

  public static Calendar readLastCheckUpdateDate()
  {
    String str = c.getString("UPDATE_DATE_REF", "");
    Debug.i("Keeper", "last calendar=" + str);
    return (Calendar)Utils.getGson().fromJson(str, Calendar.class);
  }

  public static String readLastMonthReportDate()
  {
    return c.getString("LastMonthReportDate", "");
  }

  public static String readLastWeekReportDate()
  {
    return c.getString("LastWeekReportDate", "");
  }

  public static String readLatestDBLuaVersion()
  {
    return c.getString("latestDBLuaVersion", "20140101");
  }

  public static String readLocaleStr()
  {
    return c.getString("Locale", "");
  }

  public static LoginData readLoginData()
  {
    LoginData localLoginData = new LoginData();
    localLoginData.uid = c.getLong("uid", -1L);
    localLoginData.security = c.getString("security", null);
    return localLoginData;
  }

  public static ArrayList<Calendar> readMorningAlarms()
  {
    String str = c.getString("REF_MORING_ALARMS", "");
    try
    {
      ArrayList localArrayList = (ArrayList)Utils.getGson().fromJson(str, new c().getType());
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static int readNeedBind()
  {
    return c.getInt("bind_state", 1);
  }

  public static NetDataInfo readNetInfo()
  {
    NetDataInfo localNetDataInfo = new NetDataInfo();
    localNetDataInfo.dataState = c.getInt("net_data_state", 0);
    localNetDataInfo.startDate = c.getString("net_start_day", null);
    localNetDataInfo.stopDate = c.getString("net_stop_day", null);
    return localNetDataInfo;
  }

  public static PersonInfo readPersonInfo()
  {
    PersonInfo localPersonInfo = new PersonInfo();
    localPersonInfo.nickname = c.getString("person_info_nickname", localPersonInfo.nickname);
    localPersonInfo.avatarUrl = c.getString("person_info_avatar_url", "");
    localPersonInfo.avatarPath = c.getString("person_info_avatar_path", "");
    localPersonInfo.age = c.getInt("person_info_age", localPersonInfo.age);
    localPersonInfo.gender = c.getInt("person_info_gender", localPersonInfo.gender);
    localPersonInfo.height = c.getInt("person_info_height", localPersonInfo.height);
    localPersonInfo.weight = c.getInt("person_info_weight", localPersonInfo.weight);
    localPersonInfo.uid = c.getLong("person_info_uid", localPersonInfo.uid);
    localPersonInfo.personSignature = c.getString("person_info_signature", "");
    localPersonInfo.sh = c.getString("person_info_sh", "");
    localPersonInfo.location = UserLocationData.fromJsonStr(c.getString("person_info_location", ""));
    localPersonInfo.totalSportData = UserTotalSportData.fromJsonStr(c.getString("person_info_total_sport_data", ""));
    localPersonInfo.deviceId = c.getString("device_id", "");
    localPersonInfo.setNeedSyncServer(c.getInt("person_info_need_sync_server", 0));
    localPersonInfo.miliConfig = MiliConfig.fromJsonStr(c.getString("person_info_mili_config", ""));
    localPersonInfo.alarmClockItems = readAlarms();
    return localPersonInfo;
  }

  public static int readPlayEnterAnimationType()
  {
    return c.getInt("PlayEnterAnimationType", 99);
  }

  public static String readPushAlias()
  {
    return c.getString("push_alias", null);
  }

  public static ShareBackgroundItem readShareBgItem()
  {
    ShareBackgroundItem localShareBackgroundItem = new ShareBackgroundItem();
    localShareBackgroundItem.reachedBgUrl = c.getString("reached_bg_url", "");
    localShareBackgroundItem.unReachedBgUrl = c.getString("unreached_bg_url", "");
    return localShareBackgroundItem;
  }

  public static SwitchOperator readSwitchOperator()
  {
    SwitchOperator localSwitchOperator = new SwitchOperator();
    localSwitchOperator.type = c.getInt("switch_type", 0);
    localSwitchOperator.enableClearData = c.getBoolean("enable_clear_data", false);
    localSwitchOperator.enableSteps = c.getBoolean("enable_write_realtime_steps", false);
    localSwitchOperator.steps = c.getInt("realtime_steps", 0);
    localSwitchOperator.lastUid = c.getLong("last_uid", -1L);
    localSwitchOperator.lastMacAddress = c.getString("last_mac_address", "");
    localSwitchOperator.date = c.getString("switch_date", "");
    return localSwitchOperator;
  }

  public static long readSyncBraceletTime()
  {
    return c.getLong("sync_bracelet_time", -1L);
  }

  public static long readSyncRealStepTime()
  {
    return c.getLong("sync_real_step_time", -1L);
  }

  public static long readSyncTime()
  {
    return c.getLong("sync_time", -1L);
  }

  public static String readUUID()
  {
    return c.getString("push_uuid", null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.Keeper
 * JD-Core Version:    0.6.2
 */