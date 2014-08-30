package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import com.google.gson.Gson;
import java.util.ArrayList;

public class ConfigDynamicDataInfo
{
  public static ConfigDynamicDataInfo __instance = null;
  private ActiveItem activeItem = null;
  private ArrayList<ActiveItem> activeItems = null;
  private String apkVersion = null;
  private int battery = 30;
  private int continueDay = 0;
  private ReportData continueReport = null;
  private Boolean dirty = Boolean.valueOf(false);
  private Boolean forceRefresh = Boolean.valueOf(false);
  private Boolean isBind = Boolean.valueOf(true);
  private LuaAction luaAction = null;
  private ReportData monthReport = null;
  private int monthStep = 0;
  private ReportData newRecordReport = null;
  private Boolean newUser = Boolean.valueOf(true);
  private Boolean noData = Boolean.valueOf(true);
  private int percentMonth = 50;
  private int percentWeek = 50;
  private int recordContinue = 0;
  private String recordDate = "2014-06-12";
  private int recordStep = 0;
  private Boolean showActivity = Boolean.valueOf(false);
  private Boolean showBattery = Boolean.valueOf(false);
  private Boolean showContinue = Boolean.valueOf(false);
  private Boolean showDayComplete = Boolean.valueOf(false);
  private Boolean showMonthReport = Boolean.valueOf(false);
  private Boolean showNewRecord = Boolean.valueOf(false);
  private Boolean showNoFound = Boolean.valueOf(false);
  private Boolean showSleep = Boolean.valueOf(false);
  private Boolean showUnlockInfo = Boolean.valueOf(true);
  private Boolean showWeekReport = Boolean.valueOf(false);
  private int sleepAverageDeepTime = 0;
  SleepInfo sleepInfo = null;
  private int sleepPercent = 0;
  private Boolean supportUnlock = Boolean.valueOf(true);
  private int totalSteps = 0;
  private ReportData weekReport = null;
  private int weekStep = 0;

  public static ConfigDynamicDataInfo getInstance()
  {
    ConfigDynamicDataInfo localConfigDynamicDataInfo1;
    String str;
    if (__instance == null)
    {
      localConfigDynamicDataInfo1 = new ConfigDynamicDataInfo();
      str = Keeper.readConfigDynamicDataInfo();
    }
    try
    {
      a locala = (a)new Gson().fromJson(str, a.class);
      if (locala.a != null)
        localConfigDynamicDataInfo1.newUser = locala.a;
      if (locala.b != null)
        localConfigDynamicDataInfo1.supportUnlock = locala.b;
      if (locala.c != null)
        localConfigDynamicDataInfo1.showUnlockInfo = locala.c;
      localConfigDynamicDataInfo1.apkVersion = Keeper.readApkVersion();
      localConfigDynamicDataInfo2 = localConfigDynamicDataInfo1;
      __instance = localConfigDynamicDataInfo2;
      return __instance;
    }
    catch (Exception localException)
    {
      while (true)
      {
        ConfigDynamicDataInfo localConfigDynamicDataInfo2 = new ConfigDynamicDataInfo();
        Debug.e("chenee", localException.getMessage());
      }
    }
  }

  public void genConfigDynamicDataInfo()
  {
  }

  public ActiveItem getActiveItem()
  {
    return this.activeItem;
  }

  public ArrayList<ActiveItem> getActiveItems()
  {
    return this.activeItems;
  }

  public String getApkVersion()
  {
    return this.apkVersion;
  }

  public int getBattery()
  {
    return this.battery;
  }

  public int getContinueDay()
  {
    return this.continueDay;
  }

  public ReportData getContinueReport()
  {
    return this.continueReport;
  }

  public Boolean getDirty()
  {
    return this.dirty;
  }

  public Boolean getForceRefresh()
  {
    return this.forceRefresh;
  }

  public Boolean getIsBind()
  {
    return this.isBind;
  }

  public LuaAction getLuaAction()
  {
    return this.luaAction;
  }

  public ReportData getMonthReport()
  {
    return this.monthReport;
  }

  public int getMonthStep()
  {
    return this.monthStep;
  }

  public ReportData getNewRecordReport()
  {
    return this.newRecordReport;
  }

  public Boolean getNewUser()
  {
    if (this.forceRefresh.booleanValue())
      return this.forceRefresh;
    return this.newUser;
  }

  public Boolean getNoData()
  {
    return this.noData;
  }

  public int getPercentMonth()
  {
    return this.percentMonth;
  }

  public int getPercentWeek()
  {
    return this.percentWeek;
  }

  public int getRecordContinue()
  {
    return this.recordContinue;
  }

  public String getRecordDate()
  {
    return this.recordDate;
  }

  public int getRecordStep()
  {
    return this.recordStep;
  }

  public Boolean getShowActivity()
  {
    return this.showActivity;
  }

  public Boolean getShowBattery()
  {
    return this.showBattery;
  }

  public Boolean getShowContinue()
  {
    return this.showContinue;
  }

  public Boolean getShowDayComplete()
  {
    return this.showDayComplete;
  }

  public Boolean getShowMonthReport()
  {
    return this.showMonthReport;
  }

  public Boolean getShowNewRecord()
  {
    return this.showNewRecord;
  }

  public Boolean getShowNoFound()
  {
    return this.showNoFound;
  }

  public Boolean getShowSleep()
  {
    return this.showSleep;
  }

  public Boolean getShowUnlockInfo()
  {
    return this.showUnlockInfo;
  }

  public Boolean getShowWeekReport()
  {
    return this.showWeekReport;
  }

  public int getSleepAverageDeepTime()
  {
    return this.sleepAverageDeepTime;
  }

  public SleepInfo getSleepInfo()
  {
    return this.sleepInfo;
  }

  public int getSleepPercent()
  {
    return this.sleepPercent;
  }

  public Boolean getSupportUnlock()
  {
    return this.supportUnlock;
  }

  public int getTotalSteps()
  {
    return this.totalSteps;
  }

  public ReportData getWeekReport()
  {
    return this.weekReport;
  }

  public int getWeekStep()
  {
    return this.weekStep;
  }

  public void save()
  {
    Gson localGson = new Gson();
    a locala = new a(this);
    locala.a = this.newUser;
    locala.b = this.showUnlockInfo;
    locala.c = this.showUnlockInfo;
    Keeper.keepConfigDynamicDataInfo(localGson.toJson(locala, a.class));
  }

  public void setActiveItem(ActiveItem paramActiveItem)
  {
    this.activeItem = paramActiveItem;
  }

  public void setActiveItems(ArrayList<ActiveItem> paramArrayList)
  {
    this.activeItems = paramArrayList;
  }

  public void setApkVersion(String paramString)
  {
    this.apkVersion = paramString;
  }

  public void setBattery(int paramInt)
  {
    this.battery = paramInt;
  }

  public void setContinueDay(int paramInt)
  {
    this.continueDay = paramInt;
  }

  public void setContinueReport(ReportData paramReportData)
  {
    this.continueReport = paramReportData;
  }

  public void setDirty(Boolean paramBoolean)
  {
    this.dirty = paramBoolean;
  }

  public void setForceRefresh(Boolean paramBoolean)
  {
    this.forceRefresh = paramBoolean;
  }

  public void setIsBind(Boolean paramBoolean)
  {
    this.isBind = paramBoolean;
  }

  public void setLuaAction(Context paramContext)
  {
    this.luaAction = LuaAction.getInstance(paramContext);
  }

  public void setMonthReport(ReportData paramReportData)
  {
    this.monthReport = paramReportData;
  }

  public void setMonthStep(int paramInt)
  {
    this.monthStep = paramInt;
  }

  public void setNewRecordReport(ReportData paramReportData)
  {
    this.newRecordReport = paramReportData;
  }

  public void setNewUser(Boolean paramBoolean)
  {
    this.newUser = paramBoolean;
  }

  public void setNoData(Boolean paramBoolean)
  {
    this.noData = paramBoolean;
  }

  public void setPercentMonth(int paramInt)
  {
    this.percentMonth = paramInt;
  }

  public void setPercentWeek(int paramInt)
  {
    this.percentWeek = paramInt;
  }

  public void setRecordContinue(int paramInt)
  {
    this.recordContinue = paramInt;
  }

  public void setRecordDate(String paramString)
  {
    this.recordDate = paramString;
  }

  public void setRecordStep(int paramInt)
  {
    this.recordStep = paramInt;
  }

  public void setShowActivity(Boolean paramBoolean)
  {
    this.showActivity = paramBoolean;
  }

  public void setShowBattery(Boolean paramBoolean)
  {
    this.showBattery = paramBoolean;
  }

  public void setShowContinue(Boolean paramBoolean)
  {
    this.showContinue = paramBoolean;
  }

  public void setShowDayComplete(Boolean paramBoolean)
  {
    this.showDayComplete = paramBoolean;
  }

  public void setShowMonthReport(Boolean paramBoolean)
  {
    this.showMonthReport = paramBoolean;
  }

  public void setShowNewRecord(Boolean paramBoolean)
  {
    this.showNewRecord = paramBoolean;
  }

  public void setShowNoFound(Boolean paramBoolean)
  {
    this.showNoFound = paramBoolean;
  }

  public void setShowSleep(Boolean paramBoolean)
  {
    this.showSleep = paramBoolean;
  }

  public void setShowUnlockInfo(Boolean paramBoolean)
  {
    this.showUnlockInfo = paramBoolean;
  }

  public void setShowWeekReport(Boolean paramBoolean)
  {
    this.showWeekReport = paramBoolean;
  }

  public void setSleepAverageDeepTime(int paramInt)
  {
    this.sleepAverageDeepTime = paramInt;
  }

  public void setSleepInfo(SleepInfo paramSleepInfo)
  {
    this.sleepInfo = paramSleepInfo;
  }

  public void setSleepPercent(int paramInt)
  {
    this.sleepPercent = paramInt;
  }

  public void setSupportUnlock(Boolean paramBoolean)
  {
    this.supportUnlock = paramBoolean;
  }

  public void setTotalSteps(int paramInt)
  {
    this.totalSteps = paramInt;
  }

  public void setWeekReport(ReportData paramReportData)
  {
    this.weekReport = paramReportData;
  }

  public void setWeekStep(int paramInt)
  {
    this.weekStep = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.ConfigDynamicDataInfo
 * JD-Core Version:    0.6.2
 */