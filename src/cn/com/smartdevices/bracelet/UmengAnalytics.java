package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.util.Log;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

public class UmengAnalytics
{
  public static final String EVENT_DYNAMIC = "EventDynamic";
  public static final String EVENT_DYNAMIC_DETAIL = "EventDynamicDetail";
  public static final String EVENT_MODE_SLEEP = "EventModeSleep";
  public static final String EVENT_MODE_STEP = "EventModeStep";
  public static final String EVENT_SHARE = "EventShare";
  public static final String EVENT_SHARE_TO_MICHAT = "EventShareToMiChat";
  public static final String EVENT_SHARE_TO_QQ = "EventShareToQQ";
  public static final String EVENT_SHARE_TO_QQ_ZONE = "EventShareToQQZone";
  public static final String EVENT_SHARE_TO_WECHAT = "EventShareToWeChat";
  public static final String EVENT_SHARE_TO_WECHAT_FRIENDS = "EventShareToWeChatFriends";
  public static final String EVENT_SHARE_TO_WEIBO = "EventShareToWeibo";
  public static final String EVENT_SHARE_TYPE_CONTINUE_DAYS = "EventShareContinueDays";
  public static final String EVENT_SHARE_TYPE_DYNAMIC = "EventShareDynamic";
  public static final String EVENT_SHARE_TYPE_MONTHLY_SLEEP = "EventShareMonthlySleep";
  public static final String EVENT_SHARE_TYPE_MONTHLY_STEP = "EventShareMonthlySteps";
  public static final String EVENT_SHARE_TYPE_NEW_RECORD = "EventShareNewRecord";
  public static final String EVENT_SHARE_TYPE_SLEEP = "EventShareSleep";
  public static final String EVENT_SHARE_TYPE_STEP_GOAL_FAILED = "EventShareStepGoalFailed";
  public static final String EVENT_SHARE_TYPE_STEP_GOAL_SUCCESS = "EventShareStepGoalSuccess";
  public static final String EVENT_SHARE_TYPE_WEEKLY_SLEEP = "EventShareWeeklySleep";
  public static final String EVENT_SHARE_TYPE_WEEKLY_STEP = "EventShareWeeklySteps";
  public static final String EVENT_SLIDE_PANEL = "EventSlidePanel";
  public static final String EVENT_SLIDE_PANEL_DOWN_CONNECT = "EventSlidePanelDownConnect";
  public static final String EVENT_SLIDE_PANEL_DOWN_SYNC = "EventSlidePanelDownSync";
  public static final String EVENT_SLIDE_PANEL_LIST_ITEM_CLICK = "EventSlidePanelListItemClick";
  public static final String EVENT_SLIDE_PANEL_UP = "EventSlidePanelUp";
  public static final String EVENT_STATISTIC = "EventStatistic";
  public static final String EVENT_STATISTIC_LEVEL_DAILY = "EventStatisticLevelDaily";
  public static final String EVENT_STATISTIC_LEVEL_MONTHLY = "EventStatisticLevelMonthly";
  public static final String EVENT_STATISTIC_LEVEL_WEEKLY = "EventStatisticLevelWeekly";
  public static final String PAGE_ABOUT = "PageAbout";
  public static final String PAGE_ALARM = "PageAlarm";
  public static final String PAGE_ALARM_NEW = "PageAlarmNew";
  public static final String PAGE_ALARM_NEW_REPEAT = "PageAlarmNewRepeat";
  public static final String PAGE_ALARM_NEW_REPEAT_CUSTOM = "PageAlarmNewRepeatCustom";
  public static final String PAGE_BIND_WECHAT = "PageBindWeChat";
  public static final String PAGE_BRACELET = "PageBracelet";
  public static final String PAGE_BRACELET_CONNECT_FAILED = "PageBraceletConnectFailed";
  public static final String PAGE_BRACELET_GOAL = "PageBraceletGoal";
  public static final String PAGE_BRACELET_HAND = "PageBraceletHand";
  public static final String PAGE_BRACELET_LIGHT = "PageBraceletLight";
  public static final String PAGE_BRACELET_NOT_FOUND = "PageBraceletNotFound";
  public static final String PAGE_BRACELET_NOT_FOUND_HELP = "PageBraceletNotFoundHelp";
  public static final String PAGE_BRACELET_UNBIND = "PageBraceletUnbind";
  public static final String PAGE_DYNAMIC = "PageDynamic";
  public static final String PAGE_DYNAMIC_DETAIL = "PageDynamicDetail";
  public static final String PAGE_DYNAMIC_DETAIL_MODIFY_SLEEP_END = "PageDynamicDetailModifySleepEnd";
  public static final String PAGE_DYNAMIC_DETAIL_MODIFY_SLEEP_START = "PageDynamicDetailModifySleepStart";
  public static final String PAGE_FEEDBACK = "PageFeedback";
  public static final String PAGE_INSTRUCTION = "PageInstruction";
  public static final String PAGE_LOGIN = "PageLogin";
  public static final String PAGE_MAIN_MENU = "PageMainMenu";
  public static final String PAGE_PERSON_GUIDE_AGE = "PagePersonGuideAge";
  public static final String PAGE_PERSON_GUIDE_FINISH = "PagePersonGuideFinish";
  public static final String PAGE_PERSON_GUIDE_GENDER = "PagePersonGuideGender";
  public static final String PAGE_PERSON_GUIDE_GOAL = "PagePersonGuideGoal";
  public static final String PAGE_PERSON_GUIDE_HEIGHT = "PagePersonGuideHeight";
  public static final String PAGE_PERSON_GUIDE_WEIGHT = "PagePersonGuideWeight";
  public static final String PAGE_PERSON_INFO = "PagePersonInfo";
  public static final String PAGE_PERSON_INFO_AGE = "PagePersonInfoAge";
  public static final String PAGE_PERSON_INFO_AVATAR_CROP = "PagePersonInfoAvatarCrop";
  public static final String PAGE_PERSON_INFO_AVATAR_SELECTION = "PagePersonInfoAvatarSelection";
  public static final String PAGE_PERSON_INFO_GENDER = "PagePersonInfoGender";
  public static final String PAGE_PERSON_INFO_HEIGHT = "PagePersonInfoHeight";
  public static final String PAGE_PERSON_INFO_WEIGHT = "PagePersonInfoWeight";
  public static final String PAGE_SEARCH_MULTI_BRACELET = "PageSearchMultiBracelet";
  public static final String PAGE_SEARCH_SINGLE_BRACELET = "PageSearchSingleBracelet";
  public static final String PAGE_SHARE = "PageShare";
  public static final String PAGE_STATISTIC = "PageStatistic";
  public static final String PAGE_SYSTEM_LOW = "PageSystemLow";
  public static final String PAGE_SYSTEM_NOT_SUPPORT = "PageSystemNotSupport";
  public static final String PAGE_UNLOCK_HELP = "PageUnlockHelp";
  public static final String PAGE_UNLOCK_INVAILD_HELP = "PageUnlockInvaildHelp";
  public static final String PAGE_WEB_REGISTER = "PageWebRegister";
  public static final String PAGE_WEB_USER_AGREEMENT = "PageWebUserAgreement";
  private static final String a = "UmengAnalyticsTracker";
  private static boolean b = true;

  public static void config(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b = paramBoolean1;
    MobclickAgent.setDebugMode(paramBoolean2);
    MobclickAgent.openActivityDurationTrack(paramBoolean3);
  }

  public static void endEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "End Event : " + paramString1 + " , " + paramString2);
    if (paramString2 == null)
    {
      MobclickAgent.onEventEnd(paramContext, paramString1);
      return;
    }
    MobclickAgent.onEventEnd(paramContext, paramString1, paramString2);
  }

  public static void endPage(String paramString)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "End Page : " + paramString);
    MobclickAgent.onPageEnd(paramString);
  }

  public static void endSession(Context paramContext)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "End Session : " + paramContext);
    MobclickAgent.onPause(paramContext);
  }

  public static void event(Context paramContext, String paramString)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "Event : " + paramString);
    MobclickAgent.onEvent(paramContext, paramString);
  }

  public static void event(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "Event : " + paramString + ", Properties : " + paramHashMap);
    MobclickAgent.onEvent(paramContext, paramString, paramHashMap);
  }

  public static void startEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "Start Event : " + paramString1 + " , " + paramString2);
    if (paramString2 == null)
    {
      MobclickAgent.onEventBegin(paramContext, paramString1);
      return;
    }
    MobclickAgent.onEventBegin(paramContext, paramString1, paramString2);
  }

  public static void startPage(String paramString)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "Start Page : " + paramString);
    MobclickAgent.onPageStart(paramString);
  }

  public static void startSession(Context paramContext)
  {
    if (!b)
      return;
    Log.v("UmengAnalyticsTracker", "Start Session : " + paramContext);
    MobclickAgent.onResume(paramContext);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.UmengAnalytics
 * JD-Core Version:    0.6.2
 */