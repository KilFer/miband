package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import de.greenrobot.daobracelet.LuaListDao;
import java.util.Locale;
import org.keplerproject.luajava.LuaState;

public class LuaEvent
{
  private static LuaEvent __instance = null;
  private ConfigDynamicDataInfo cInfo = null;
  private Context context = null;
  private LuaEventMsgs lEventMsgs = null;

  public LuaEvent(Context paramContext)
  {
    this.context = paramContext;
  }

  public static LuaEvent getInstance(Context paramContext)
  {
    if (__instance == null)
    {
      LuaEvent localLuaEvent = new LuaEvent(paramContext);
      localLuaEvent.context = paramContext;
      localLuaEvent.cInfo = ConfigDynamicDataInfo.getInstance();
      localLuaEvent.cInfo.setLuaAction(paramContext);
      localLuaEvent.lEventMsgs = LuaEventMsgs.getInstance(paramContext);
      __instance = localLuaEvent;
    }
    __instance.setLocale(Locale.getDefault().toString());
    return __instance;
  }

  public ConfigDynamicDataInfo getConfigDynamicDataInfo()
  {
    return this.cInfo;
  }

  public LuaEventMsgs getLuaEventMsg()
  {
    return this.lEventMsgs;
  }

  public void resetLuaState()
  {
    LuaManager.getInstance().resetLuaState();
  }

  public void setContinueReport(ReportData paramReportData)
  {
    this.cInfo.setShowContinue(Boolean.valueOf(true));
    this.cInfo.setContinueReport(paramReportData);
    this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
    this.cInfo.setShowContinue(Boolean.valueOf(false));
  }

  public void setDefaultMsgs()
  {
    setDefaultMsgs(Boolean.valueOf(false));
  }

  public void setDefaultMsgs(Boolean paramBoolean)
  {
    this.cInfo.setIsBind(Boolean.valueOf(Utils.isBinded()));
    boolean bool2;
    if (Utils.isSupportUnlockScreenByBracelet(this.context))
    {
      boolean bool1 = Utils.isUseUnlockByBracelet(this.context);
      bool2 = false;
      if (bool1)
      {
        Boolean localBoolean = Boolean.valueOf(bool2);
        this.cInfo.setShowUnlockInfo(localBoolean);
      }
    }
    while (true)
    {
      this.cInfo.save();
      this.cInfo.setForceRefresh(paramBoolean);
      this.lEventMsgs.luaEventDefaultMsg(this.cInfo);
      return;
      bool2 = true;
      break;
      this.cInfo.setShowUnlockInfo(Boolean.valueOf(false));
    }
  }

  public void setGoal()
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    LuaListDao localLuaListDao = DaoManager.getInstance().getLuaListDao();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "dayComplete");
    localLuaState.pushJavaObject(localLuaListDao);
    localLuaState.pushJavaObject(this.cInfo);
    localLuaManager.callLua(2, 0);
  }

  public void setLocale(String paramString)
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setLocale");
    localLuaState.pushString(paramString);
    localLuaManager.callLua(1, 0);
  }

  public void setMonthReport(ReportData paramReportData)
  {
    this.cInfo.setShowMonthReport(Boolean.valueOf(true));
    this.cInfo.setMonthReport(paramReportData);
    this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
    this.cInfo.setShowMonthReport(Boolean.valueOf(false));
  }

  public void setRecord(ReportData paramReportData)
  {
    this.cInfo.setNewRecordReport(paramReportData);
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    LuaListDao localLuaListDao = DaoManager.getInstance().getLuaListDao();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "newRecord");
    localLuaState.pushJavaObject(localLuaListDao);
    localLuaState.pushJavaObject(this.cInfo);
    localLuaManager.callLua(2, 0);
  }

  public void setSleep(SleepInfo paramSleepInfo)
  {
    this.cInfo.setSleepInfo(paramSleepInfo);
    this.cInfo.setSleepAverageDeepTime(90);
    this.cInfo.setSleepPercent(80);
    this.cInfo.setShowSleep(Boolean.valueOf(true));
    this.lEventMsgs.luaEventSleepMsg(this.cInfo);
    this.cInfo.setShowSleep(Boolean.valueOf(false));
  }

  public void setStep(ActiveItem paramActiveItem)
  {
    if (paramActiveItem.mode != 0);
    this.cInfo.setActiveItem(paramActiveItem);
    this.cInfo.setShowActivity(Boolean.valueOf(true));
    this.lEventMsgs.luaEventActivityMsg(this.cInfo);
    this.cInfo.setShowActivity(Boolean.valueOf(false));
  }

  public void setWeekReport(ReportData paramReportData)
  {
    this.cInfo.setShowWeekReport(Boolean.valueOf(true));
    this.cInfo.setWeekReport(paramReportData);
    this.lEventMsgs.luaEventAchievementMsg(this.cInfo);
    this.cInfo.setShowWeekReport(Boolean.valueOf(false));
  }

  public void testAction()
  {
    LuaManager localLuaManager = LuaManager.getInstance();
    LuaState localLuaState = localLuaManager.getLuaState();
    LuaAction localLuaAction = LuaAction.getInstance(this.context);
    LuaListDao localLuaListDao = DaoManager.getInstance().getLuaListDao();
    localLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "doAction2");
    localLuaState.pushJavaObject(this.context);
    localLuaState.pushJavaObject(localLuaAction);
    localLuaState.pushJavaObject(localLuaListDao);
    localLuaManager.callLua(3, 0);
  }

  public void testConfig()
  {
  }

  public void testLuaImp(int paramInt)
  {
    this.lEventMsgs.testLuaImp(paramInt, this.cInfo);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.LuaEvent
 * JD-Core Version:    0.6.2
 */