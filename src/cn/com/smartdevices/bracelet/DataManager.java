package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.analysis.DataAnalysis;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.db.BraceletDbHelper;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.DaySportData.SummaryEmpty;
import cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class DataManager
{
  public static final int DAY_SPORT_LEN = 1440;
  public static final ArrayList<SportData> INIT_INDEX_LIST;
  public static final ArrayList<IMiLiProfile.ActivityData> INIT_ORIGIN_LIST = new ArrayList();
  private static final String a = "DataManager";
  private static DataManager j;
  private static Context l;
  private BraceletDbHelper b = null;
  private ConcurrentHashMap<String, DaySportData> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, DaySportData.Summary> d = new ConcurrentHashMap();
  private SportDay e = new SportDay();
  private SportDay f = new SportDay();
  private SportDay g = new SportDay();
  private SportDay h = null;
  private SportDay i = null;
  private NetDataInfo k = null;
  private SportDay m = null;

  static
  {
    INIT_INDEX_LIST = new ArrayList();
    j = null;
    l = null;
    IMiLiProfile.ActivityData localActivityData = new IMiLiProfile.ActivityData((byte)0, (byte)0, (byte)126);
    for (int n = 0; ; n++)
    {
      if (n >= 1440)
        return;
      INIT_ORIGIN_LIST.add(localActivityData);
      SportData localSportData = new SportData(n, 126, 0, 0);
      INIT_INDEX_LIST.add(localSportData);
    }
  }

  private DataManager(Context paramContext)
  {
    l = paramContext;
    this.b = BraceletDbHelper.getInstance();
    initDays();
  }

  private static int a(String paramString1, String paramString2)
  {
    Calendar localCalendar = SportDay.toCalenday(paramString1);
    return 1 + (int)((SportDay.toCalenday(paramString2).getTime().getTime() - localCalendar.getTime().getTime()) / 86400000L);
  }

  private DaySportData a(SportDay paramSportDay)
  {
    byte[] arrayOfByte = this.b.readOriginData(paramSportDay.getKey());
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      return null;
    DaySportData localDaySportData = new DaySportData(paramSportDay);
    localDaySportData.fromBinaryData(paramSportDay, arrayOfByte);
    return localDaySportData;
  }

  private void a()
  {
    Debug.i("DataManager", "clear.................................");
    this.c.clear();
    this.e = getToday();
    this.f = getToday();
    this.g = getToday();
    initDays();
  }

  private static void a(DaySportData.SummaryEntity paramSummaryEntity, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("steps_info");
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject("sleep_info");
    paramSummaryEntity.setSteps(localJSONObject1.getInt("steps"));
    paramSummaryEntity.setStepDistance(localJSONObject1.getInt("distance"));
    paramSummaryEntity.setStepCalorie(localJSONObject1.getInt("calories"));
    paramSummaryEntity.setStepActiveTime(localJSONObject1.getInt("active_time"));
    paramSummaryEntity.setStepContinueTime(localJSONObject1.getInt("continus_active_time"));
    paramSummaryEntity.setStepWalkTime(localJSONObject1.optInt("walk_time"));
    paramSummaryEntity.setStepRunTime(localJSONObject1.optInt("run_time"));
    paramSummaryEntity.setSleep(localJSONObject2.getInt("sleep_minutes"));
    paramSummaryEntity.setSleepDeepTime(localJSONObject2.getInt("nrem_minutes"));
    paramSummaryEntity.setSleepShallowTime(localJSONObject2.getInt("rem_minutes"));
    try
    {
      long l4 = localJSONObject2.getLong("start_date");
      l1 = l4;
      paramSummaryEntity.setSleepStartTime(l1);
    }
    catch (Exception localException1)
    {
      try
      {
        long l3 = localJSONObject2.getLong("stop_date");
        l2 = l3;
        paramSummaryEntity.setSleepRiseTime(l2);
        paramSummaryEntity.setSleepWakeTime(localJSONObject2.getInt("awake_minutes"));
        JSONObject localJSONObject3 = paramJSONObject.optJSONObject("daysportgoal_info");
        if (localJSONObject3 != null)
          paramSummaryEntity.setDayStepGoal(localJSONObject3.getInt("goalStepsCount"));
        return;
        localException1 = localException1;
        localException1.printStackTrace();
        long l1 = java.sql.Date.parse(localJSONObject2.getString("start_date"));
      }
      catch (Exception localException2)
      {
        while (true)
        {
          localException2.printStackTrace();
          long l2 = java.sql.Date.parse(localJSONObject2.getString("stop_date"));
        }
      }
    }
  }

  private static void a(DaySportData.SummaryEntity paramSummaryEntity, JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject(StepsInfo.KEY_STEP_INFO);
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject(SleepInfo.KEY_SLEEP_INFO);
    paramSummaryEntity.setSteps(localJSONObject1.getInt(StepsInfo.KEY_STEPS));
    paramSummaryEntity.setStepDistance(localJSONObject1.getInt(StepsInfo.KEY_DISTANCE));
    paramSummaryEntity.setStepCalorie(localJSONObject1.getInt(StepsInfo.KEY_CALORIES));
    paramSummaryEntity.setStepContinueTime(localJSONObject1.getInt(StepsInfo.KEY_CONTINUS_ACTIVE_TIME));
    int n = localJSONObject1.getInt(StepsInfo.KEY_STEP_WALK_TIME);
    int i1 = localJSONObject1.getInt(StepsInfo.KEY_STEP_RUN_TIME);
    paramSummaryEntity.setStepWalkTime(n);
    paramSummaryEntity.setStepRunTime(i1);
    paramSummaryEntity.setStepActiveTime(i1 + n);
    int i2 = localJSONObject2.getInt(SleepInfo.KEY_DEEP_MINUTES);
    int i3 = localJSONObject2.getInt(SleepInfo.KEY_LIGHT_MINUTES);
    if (paramInt == 1)
    {
      paramSummaryEntity.setSleepDeepTime(i3);
      paramSummaryEntity.setSleepShallowTime(i2);
    }
    while (true)
    {
      paramSummaryEntity.setSleep(i2 + i3);
      paramSummaryEntity.setSleepWakeTime(localJSONObject2.getInt(SleepInfo.KEY_AWAKE_MINUTES));
      paramSummaryEntity.setSleepStartTime(1000L * localJSONObject2.getLong(SleepInfo.KEY_START_DATE));
      paramSummaryEntity.setSleepRiseTime(1000L * localJSONObject2.getLong(SleepInfo.KEY_END_DATE));
      paramSummaryEntity.setUserSleepStart(localJSONObject2.optInt(SleepInfo.KEY_USER_SLEEP_START, -2147483648));
      paramSummaryEntity.setUserSleepEnd(localJSONObject2.optInt(SleepInfo.KEY_USER_SLEEP_END, -2147483648));
      if (paramInt > 2)
        break;
      if (!paramJSONObject.isNull("daysportgoal_info"))
        paramSummaryEntity.setDayStepGoal(paramJSONObject.getInt("daysportgoal_info"));
      return;
      paramSummaryEntity.setSleepDeepTime(i2);
      paramSummaryEntity.setSleepShallowTime(i3);
    }
    paramSummaryEntity.setDayStepGoal(paramJSONObject.getInt("goal"));
  }

  private DaySportData b(SportDay paramSportDay)
  {
    return a(paramSportDay);
  }

  private void b()
  {
    Debug.i("DataManager", "clear.................................");
    this.c.clear();
    this.e = getToday();
    this.f = getToday();
    this.g = getToday();
  }

  private void c()
  {
    long l1 = System.currentTimeMillis();
    Debug.i("DataManager", "in loadNetData");
    if (!Utils.isNetworkConnected(l))
      return;
    WebAPI.syncFromServerNew(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, 3, new b(this));
    long l2 = System.currentTimeMillis();
    Debug.i("DataManager", "out loadNetData:" + (l2 - l1) + "ms");
  }

  public static DataManager getInstance()
  {
    return j;
  }

  public static void init(Context paramContext)
  {
    BraceletDbHelper.create(paramContext);
    if (j == null)
      j = new DataManager(paramContext);
  }

  public void add(DaySportData paramDaySportData)
  {
    Debug.i("DataManager", "add:" + paramDaySportData.getSportDay().formatString() + "," + paramDaySportData.data().size());
    this.c.put(paramDaySportData.getKey(), paramDaySportData);
    SportDay localSportDay = paramDaySportData.getSportDay();
    if (this.e.compare(localSportDay) == 1)
      this.e = localSportDay;
  }

  public void analysis()
  {
    try
    {
      Debug.f("DataManager", "in analysis");
      Iterator localIterator = this.c.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          Debug.f("DataManager", "out analysis");
          return;
        }
        DaySportData localDaySportData1 = (DaySportData)((Map.Entry)localIterator.next()).getValue();
        SportDay localSportDay1 = localDaySportData1.getSportDay();
        if ((localDaySportData1 != null) && (localDaySportData1.isNeedPostProcess()) && (localDaySportData1.isLocalNeedSync()))
        {
          SportDay localSportDay2 = localSportDay1.addDay(-1);
          DaySportData localDaySportData2 = get(localSportDay2);
          if (localDaySportData2 == null)
            localDaySportData2 = a(localSportDay2);
          DaySportData localDaySportData3 = get(localSportDay1.addDay(1));
          if (localDaySportData2 == null)
            localDaySportData2 = a(localSportDay2);
          DataAnalysis.dataPostProcess(l, localDaySportData2, localDaySportData1, localDaySportData3);
          getInstance().removeSummary(localSportDay1);
        }
      }
    }
    finally
    {
    }
  }

  public void clearAll()
  {
    this.c.clear();
    this.d.clear();
    this.b.dropAllDatas();
    this.k = new NetDataInfo();
  }

  public int daysOfAllData()
  {
    return this.b.getCount();
  }

  public DaySportData get(SportDay paramSportDay)
  {
    if (paramSportDay == null)
      return new DaySportData(getToday());
    return (DaySportData)this.c.get(paramSportDay.getKey());
  }

  public DaySportData get(String paramString)
  {
    return (DaySportData)this.c.get(paramString);
  }

  public ReportData getContinueReachGoalReportData()
  {
    Debug.i("DataManager", "in getContinueReachGoalReportData");
    Debug.i("DataManager", "startDay:" + this.e.formatString() + ",stopDay:" + this.f.formatString());
    SportDay localSportDay1 = this.e;
    SportDay localSportDay2 = this.f;
    ArrayList localArrayList = new ArrayList();
    SportDay localSportDay3 = localSportDay2;
    ReportData localReportData1 = null;
    if (localSportDay3.compare(localSportDay1) < 0)
    {
      if (localArrayList.size() == 0)
        return new ReportData();
    }
    else
    {
      DaySportData.Summary localSummary = getSummary(localSportDay3);
      if (localSummary.getDayStepGoal() <= localSummary.getSteps())
      {
        if (localReportData1 == null)
        {
          localReportData1 = new ReportData();
          localArrayList.add(localReportData1);
          localReportData1.type = "SHARE_TYPE_CONTIUE_REACH_GOAL";
          localReportData1.timeTo = localSportDay3.getKey();
        }
        localReportData1.timeFrom = localSportDay3.getKey();
        localReportData1.calories += localSummary.getStepCalorie();
        localReportData1.steps += localSummary.getSteps();
        localReportData1.distance += localSummary.getStepDistance();
      }
      while (true)
      {
        localSportDay3 = localSportDay3.addDay(-1);
        break;
        localReportData1 = null;
      }
    }
    Iterator localIterator = localArrayList.iterator();
    ReportData localReportData3;
    SportDay localSportDay4;
    int i2;
    int i1;
    for (int n = 0; ; n = i1)
      do
      {
        if (!localIterator.hasNext())
        {
          localReportData3 = (ReportData)localArrayList.get(0);
          localSportDay4 = SportDay.fromString(localReportData3.timeTo);
          i2 = a(localReportData3.timeFrom, localReportData3.timeTo);
          if ((localSportDay4.compare(new SportDay().addDay(-1)) >= 0) && (i2 >= 2))
            break;
          return new ReportData();
        }
        ReportData localReportData2 = (ReportData)localIterator.next();
        Debug.i("DataManager", localReportData2.timeFrom + "--->" + localReportData2.timeTo);
        i1 = a(localReportData2.timeFrom, localReportData2.timeTo);
      }
      while ((i1 < 2) || (i1 <= n));
    localReportData3.maxContinueDays = n;
    localReportData3.continueDays = i2;
    if (localSportDay4.compare(new SportDay()) == 0)
      localReportData3.todayComplete = 1;
    Debug.i("DataManager", "out getContinueReachGoalReportData");
    return localReportData3;
  }

  public SportDay getCurDay()
  {
    return this.g;
  }

  public ReportData getLastMonthReportData()
  {
    Debug.i("DataManager", "in getLastMonthReportData");
    ReportData localReportData = new ReportData();
    localReportData.type = "SHARE_TYPE_LAST_MONTH";
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(2, -1);
    localCalendar.set(5, 1);
    SportDay localSportDay1 = new SportDay(localCalendar);
    localCalendar.set(5, 1);
    localCalendar.add(2, 1);
    localCalendar.add(5, -1);
    SportDay localSportDay2 = new SportDay(localCalendar);
    if (localSportDay2.compare(this.e) < 0)
      return localReportData;
    localReportData.timeFrom = localSportDay1.getKey();
    localReportData.timeTo = localSportDay2.getKey();
    if (localSportDay1.compare(this.e) < 0)
      localSportDay1 = this.e;
    if (localSportDay2.compare(this.f) > 0)
      localSportDay2 = this.f;
    Debug.i("DataManager", "startDay:" + localSportDay1.formatString() + ",stopDay:" + localSportDay2.formatString());
    while (true)
    {
      if (localSportDay2.compare(localSportDay1) < 0)
      {
        Debug.i("DataManager", "out getLastMonthReportData");
        return localReportData;
      }
      DaySportData.Summary localSummary = getSummary(localSportDay2);
      if ((localSummary != null) && (localSummary.getSteps() > 0))
      {
        localReportData.distance += localSummary.getStepDistance();
        localReportData.calories += localSummary.getStepCalorie();
        localReportData.steps += localSummary.getSteps();
        if (localSummary.getSteps() > localReportData.maxDateStep)
        {
          localReportData.maxDateStep = localSummary.getSteps();
          localReportData.maxDateStr = localSportDay2.getKey();
        }
      }
      localSportDay2 = localSportDay2.addDay(-1);
    }
  }

  public ReportData getLastWeekReportData()
  {
    Debug.i("DataManager", "in getLastWeekReportData");
    ReportData localReportData = new ReportData();
    localReportData.type = "SHARE_TYPE_LAST_WEEK";
    Calendar localCalendar = Calendar.getInstance();
    int n = localCalendar.get(7);
    if (n == 1);
    SportDay localSportDay1;
    SportDay localSportDay2;
    for (int i1 = -6; ; i1 = 2 - n)
    {
      localCalendar.add(5, i1 - 7);
      localSportDay1 = new SportDay(localCalendar);
      localCalendar.add(5, 6);
      localSportDay2 = new SportDay(localCalendar);
      if (localSportDay2.compare(this.e) >= 0)
        break;
      return localReportData;
    }
    localReportData.timeFrom = localSportDay1.getKey();
    localReportData.timeTo = localSportDay2.getKey();
    if (localSportDay1.compare(this.e) < 0)
      localSportDay1 = this.e;
    if (localSportDay2.compare(this.f) > 0)
      localSportDay2 = this.f;
    Debug.i("DataManager", "startDay:" + localSportDay1.formatString() + ",stopDay:" + localSportDay2.formatString());
    while (true)
    {
      if (localSportDay2.compare(localSportDay1) < 0)
      {
        Debug.i("DataManager", "out getLastWeekReportData");
        return localReportData;
      }
      DaySportData.Summary localSummary = getSummary(localSportDay2);
      if ((localSummary != null) && (localSummary.getSteps() > 0))
      {
        localReportData.distance += localSummary.getStepDistance();
        localReportData.calories += localSummary.getStepCalorie();
        localReportData.steps += localSummary.getSteps();
        if (localSummary.getSteps() > localReportData.maxDateStep)
        {
          localReportData.maxDateStep = localSummary.getSteps();
          localReportData.maxDateStr = localSportDay2.getKey();
        }
      }
      localSportDay2 = localSportDay2.addDay(-1);
    }
  }

  public ArrayList<UploadData> getNeedSyncDatas()
  {
    return this.b.readNotSyncDatas();
  }

  public SportDay getStartDay()
  {
    return this.e;
  }

  public ReportData getStepRecord()
  {
    Debug.i("DataManager", "in getStepRecord");
    Debug.i("DataManager", "startDay:" + this.e.formatString() + ",stopDay:" + this.f.formatString());
    ReportData localReportData = new ReportData();
    localReportData.type = "SHARE_TYPE_NEW_RECORD";
    SportDay localSportDay1 = this.e;
    for (SportDay localSportDay2 = this.f.addDay(-1); ; localSportDay2 = localSportDay2.addDay(-1))
    {
      if (localSportDay2.compare(localSportDay1) < 0)
      {
        Debug.i("DataManager", "out getStepRecord:" + localReportData.steps);
        return localReportData;
      }
      DaySportData.Summary localSummary = getSummary(localSportDay2);
      if ((localSummary != null) && (localSummary.getSteps() > 0) && (localSummary.getSteps() > localReportData.steps))
      {
        localReportData.distance = localSummary.getStepDistance();
        localReportData.calories = localSummary.getStepCalorie();
        localReportData.steps = localSummary.getSteps();
        localReportData.maxDateStep = localSummary.getSteps();
        localReportData.maxDateStr = localSportDay2.getKey();
      }
    }
  }

  public SportDay getStopDay()
  {
    return getToday();
  }

  public DaySportData.Summary getSummary(SportDay paramSportDay)
  {
    Debug.i("DataManager", "Get Summary : " + paramSportDay);
    Object localObject = (DaySportData.Summary)this.d.get(paramSportDay.getKey());
    String str;
    if (localObject == null)
    {
      str = this.b.readSummary(paramSportDay.getKey());
      Debug.i("DataManager", "Read Summary : " + paramSportDay + " , " + str);
      if (TextUtils.isEmpty(str))
        break label691;
    }
    label691: for (localObject = new DaySportData.SummaryEntity(); ; localObject = new DaySportData.SummaryEmpty())
      while (true)
      {
        JSONObject localJSONObject1;
        JSONObject localJSONObject5;
        try
        {
          localJSONObject1 = new JSONObject(str);
          int n = localJSONObject1.optInt("v", 0);
          if (n > 0)
          {
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject(StepsInfo.KEY_STEP_INFO);
            JSONObject localJSONObject3 = localJSONObject1.getJSONObject(SleepInfo.KEY_SLEEP_INFO);
            ((DaySportData.SummaryEntity)localObject).setSteps(localJSONObject2.getInt(StepsInfo.KEY_STEPS));
            ((DaySportData.SummaryEntity)localObject).setStepDistance(localJSONObject2.getInt(StepsInfo.KEY_DISTANCE));
            ((DaySportData.SummaryEntity)localObject).setStepCalorie(localJSONObject2.getInt(StepsInfo.KEY_CALORIES));
            ((DaySportData.SummaryEntity)localObject).setStepContinueTime(localJSONObject2.getInt(StepsInfo.KEY_CONTINUS_ACTIVE_TIME));
            int i1 = localJSONObject2.getInt(StepsInfo.KEY_STEP_WALK_TIME);
            int i2 = localJSONObject2.getInt(StepsInfo.KEY_STEP_RUN_TIME);
            ((DaySportData.SummaryEntity)localObject).setStepWalkTime(i1);
            ((DaySportData.SummaryEntity)localObject).setStepRunTime(i2);
            ((DaySportData.SummaryEntity)localObject).setStepActiveTime(i2 + i1);
            int i3 = localJSONObject3.getInt(SleepInfo.KEY_DEEP_MINUTES);
            int i4 = localJSONObject3.getInt(SleepInfo.KEY_LIGHT_MINUTES);
            if (n == 1)
            {
              ((DaySportData.SummaryEntity)localObject).setSleepDeepTime(i4);
              ((DaySportData.SummaryEntity)localObject).setSleepShallowTime(i3);
              ((DaySportData.SummaryEntity)localObject).setSleep(i3 + i4);
              ((DaySportData.SummaryEntity)localObject).setSleepWakeTime(localJSONObject3.getInt(SleepInfo.KEY_AWAKE_MINUTES));
              ((DaySportData.SummaryEntity)localObject).setSleepStartTime(1000L * localJSONObject3.getLong(SleepInfo.KEY_START_DATE));
              ((DaySportData.SummaryEntity)localObject).setSleepRiseTime(1000L * localJSONObject3.getLong(SleepInfo.KEY_END_DATE));
              ((DaySportData.SummaryEntity)localObject).setUserSleepStart(localJSONObject3.optInt(SleepInfo.KEY_USER_SLEEP_START, -2147483648));
              ((DaySportData.SummaryEntity)localObject).setUserSleepEnd(localJSONObject3.optInt(SleepInfo.KEY_USER_SLEEP_END, -2147483648));
              if (n <= 2)
              {
                if (!localJSONObject1.isNull("daysportgoal_info"))
                  ((DaySportData.SummaryEntity)localObject).setDayStepGoal(localJSONObject1.getInt("daysportgoal_info"));
                this.d.put(paramSportDay.getKey(), localObject);
                return localObject;
              }
            }
            else
            {
              ((DaySportData.SummaryEntity)localObject).setSleepDeepTime(i3);
              ((DaySportData.SummaryEntity)localObject).setSleepShallowTime(i4);
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
          ((DaySportData.SummaryEntity)localObject).setDayStepGoal(localJSONObject1.getInt("goal"));
          continue;
          JSONObject localJSONObject4 = localJSONObject1.getJSONObject("steps_info");
          localJSONObject5 = localJSONObject1.getJSONObject("sleep_info");
          ((DaySportData.SummaryEntity)localObject).setSteps(localJSONObject4.getInt("steps"));
          ((DaySportData.SummaryEntity)localObject).setStepDistance(localJSONObject4.getInt("distance"));
          ((DaySportData.SummaryEntity)localObject).setStepCalorie(localJSONObject4.getInt("calories"));
          ((DaySportData.SummaryEntity)localObject).setStepActiveTime(localJSONObject4.getInt("active_time"));
          ((DaySportData.SummaryEntity)localObject).setStepContinueTime(localJSONObject4.getInt("continus_active_time"));
          ((DaySportData.SummaryEntity)localObject).setStepWalkTime(localJSONObject4.optInt("walk_time"));
          ((DaySportData.SummaryEntity)localObject).setStepRunTime(localJSONObject4.optInt("run_time"));
          ((DaySportData.SummaryEntity)localObject).setSleep(localJSONObject5.getInt("sleep_minutes"));
          ((DaySportData.SummaryEntity)localObject).setSleepDeepTime(localJSONObject5.getInt("nrem_minutes"));
          ((DaySportData.SummaryEntity)localObject).setSleepShallowTime(localJSONObject5.getInt("rem_minutes"));
        }
        try
        {
          long l5 = localJSONObject5.getLong("start_date");
          l1 = l5;
          ((DaySportData.SummaryEntity)localObject).setSleepStartTime(l1);
        }
        catch (Exception localException2)
        {
          try
          {
            long l1;
            long l4 = localJSONObject5.getLong("stop_date");
            l3 = l4;
            ((DaySportData.SummaryEntity)localObject).setSleepRiseTime(l3);
            ((DaySportData.SummaryEntity)localObject).setSleepWakeTime(localJSONObject5.getInt("awake_minutes"));
            JSONObject localJSONObject6 = localJSONObject1.optJSONObject("daysportgoal_info");
            if (localJSONObject6 != null)
            {
              ((DaySportData.SummaryEntity)localObject).setDayStepGoal(localJSONObject6.getInt("goalStepsCount"));
              continue;
              localException2 = localException2;
              localException2.printStackTrace();
              l1 = java.sql.Date.parse(localJSONObject5.getString("start_date"));
            }
          }
          catch (Exception localException3)
          {
            while (true)
            {
              localException3.printStackTrace();
              long l2 = java.sql.Date.parse(localJSONObject5.getString("stop_date"));
              long l3 = l2;
            }
          }
        }
      }
  }

  public DaySportData getSync(int paramInt1, int paramInt2, int paramInt3)
  {
    SportDay localSportDay = new SportDay(paramInt1, paramInt2, paramInt3);
    if ((!this.c.containsKey(localSportDay.getKey())) && (localSportDay.compare(getStopDay()) <= 0) && (localSportDay.compare(this.m) > 0))
    {
      Debug.i("DataManager", "getSync not contains :" + localSportDay.getKey());
      Debug.f("DataManager", "getSync not contains :" + localSportDay.getKey());
      load(localSportDay);
    }
    return get(localSportDay);
  }

  public SportDay getToday()
  {
    return new SportDay();
  }

  public UserTotalSportData getUserTotalSportData()
  {
    Debug.i("DataManager", "in getUserTotalSportData");
    Debug.i("DataManager", "startDay:" + this.e.formatString() + ",stopDay:" + this.f.formatString());
    UserTotalSportData localUserTotalSportData = new UserTotalSportData();
    SportDay localSportDay1 = this.e;
    SportDay localSportDay2 = this.f;
    if (localSportDay2.compare(localSportDay1) < 0)
      if (localUserTotalSportData.iTotalwearingdays == 0)
        break label210;
    label210: for (localUserTotalSportData.iAverageSteps = (localUserTotalSportData.iSteps / localUserTotalSportData.iTotalwearingdays); ; localUserTotalSportData.iAverageSteps = 0)
    {
      localUserTotalSportData.translate();
      Debug.i("DataManager", "UserTotalSportData:\n" + localUserTotalSportData.toString());
      Debug.i("DataManager", "out getUserTotalSportData");
      return localUserTotalSportData;
      DaySportData.Summary localSummary = getSummary(localSportDay2);
      if ((localSummary != null) && (localSummary.getSteps() > 0))
      {
        localUserTotalSportData.iDistance += localSummary.getStepDistance();
        localUserTotalSportData.iSteps += localSummary.getSteps();
        localUserTotalSportData.iTotalwearingdays = (1 + localUserTotalSportData.iTotalwearingdays);
      }
      localSportDay2 = localSportDay2.addDay(-1);
      break;
    }
  }

  public void initDays()
  {
    Debug.f("DataManager", "in initDays");
    this.m = new SportDay(2014, 1, 1);
    String[] arrayOfString = this.b.dateOfStartAndStop();
    if (arrayOfString != null)
    {
      this.e = SportDay.fromString(arrayOfString[0]);
      this.f = SportDay.fromString(arrayOfString[1]);
      this.g = getStopDay();
      if (this.e.compare(this.m) < 0)
        this.e = this.m;
      if (this.f.compare(this.g) > 0)
        this.f = this.g;
      Debug.i("DataManager", "localStartDay:" + this.e + "\nlocalStopDay:" + this.f + "\ncurDay:" + this.g);
    }
    this.k = Keeper.readNetInfo();
    if (this.k.hasData())
    {
      this.h = SportDay.fromString(this.k.startDate);
      this.i = SportDay.fromString(this.k.stopDate);
    }
    Debug.i("DataManager", "netStartDay:" + this.h + "\nnetStopDay:" + this.i + "\ncurDay:" + this.g);
    Debug.f("DataManager", "out initDays");
  }

  public void insertDatas(ArrayList<UploadData> paramArrayList, int paramInt)
  {
    Debug.i("DataManager", "insertDatas.......................................0");
    Iterator localIterator = paramArrayList.iterator();
    label223: 
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Debug.i("DataManager", "insertDatas.......................................1");
        this.b.insertDatas(paramArrayList, paramInt);
        Debug.i("DataManager", "insertDatas.......................................2");
        Debug.i("DataManager", "clear.................................");
        this.c.clear();
        this.e = getToday();
        this.f = getToday();
        this.g = getToday();
        initDays();
        return;
      }
      UploadData localUploadData = (UploadData)localIterator.next();
      SportDay localSportDay = SportDay.fromString(localUploadData.date);
      Debug.i("DataManager", "SD:" + localSportDay.getKey());
      if (this.c.containsKey(localSportDay.getKey()));
      for (DaySportData localDaySportData1 = (DaySportData)this.c.get(localSportDay.getKey()); ; localDaySportData1 = a(localSportDay))
      {
        if (localDaySportData1 == null)
          break label223;
        Debug.i("DataManager", "dayData not null.................");
        DaySportData localDaySportData2 = DaySportData.sFromBinaryData(localSportDay, localUploadData.data);
        localDaySportData2.merge(localDaySportData1);
        localUploadData.data = localDaySportData2.getBinaryData();
        break;
      }
    }
  }

  public boolean isStartDay()
  {
    return this.g.equals(this.e);
  }

  public boolean isStopDay()
  {
    return this.g.equals(getStopDay());
  }

  public int load(SportDay paramSportDay)
  {
    try
    {
      Debug.i("DataManager", "load:" + paramSportDay.formatString());
      SportDay localSportDay1 = paramSportDay.addDay(-1);
      SportDay localSportDay2 = paramSportDay.addDay(1);
      if (this.k.isUnknow())
      {
        long l1 = System.currentTimeMillis();
        Debug.i("DataManager", "in loadNetData");
        if (Utils.isNetworkConnected(l))
        {
          WebAPI.syncFromServerNew(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, 3, new b(this));
          long l2 = System.currentTimeMillis();
          Debug.i("DataManager", "out loadNetData:" + (l2 - l1) + "ms");
        }
      }
      if (!this.c.containsKey(paramSportDay.getKey()))
      {
        DaySportData localDaySportData6 = a(paramSportDay);
        if (localDaySportData6 != null)
          add(localDaySportData6);
      }
      int n;
      if (localSportDay1.compare(this.e) >= 0)
      {
        n = 1;
        if ((n != 0) && (!this.c.containsKey(localSportDay1.getKey())))
        {
          DaySportData localDaySportData5 = a(localSportDay1);
          if (localDaySportData5 != null)
            add(localDaySportData5);
        }
        if (localSportDay2.compare(getStopDay()) <= 0)
          break label375;
      }
      label375: for (int i1 = 0; ; i1 = 1)
      {
        if ((i1 != 0) && (!this.c.containsKey(localSportDay2.getKey())))
        {
          DaySportData localDaySportData4 = a(localSportDay2);
          if (localDaySportData4 != null)
            add(localDaySportData4);
        }
        Debug.i("DataManager", "today:" + paramSportDay.formatString() + ",yesterday:" + localSportDay1.formatString() + ",tomorrow:" + localSportDay2.formatString());
        DaySportData localDaySportData1 = get(paramSportDay);
        DaySportData localDaySportData2 = get(localSportDay1);
        DaySportData localDaySportData3 = get(localSportDay2);
        if ((localDaySportData1 != null) && (localDaySportData1.isNeedPostProcess()))
          DataAnalysis.dataPostProcess(l, localDaySportData2, localDaySportData1, localDaySportData3);
        return 0;
        n = 0;
        break;
      }
    }
    finally
    {
    }
  }

  public void load(int paramInt1, int paramInt2)
  {
    Debug.i("DataManager", "load:" + paramInt1 + "," + paramInt2);
    SportDay localSportDay;
    if (paramInt2 == 0)
      localSportDay = this.g;
    while (true)
    {
      if (localSportDay != null)
        load(localSportDay.addDay(paramInt1));
      return;
      if (paramInt2 == 1)
      {
        localSportDay = this.e;
      }
      else
      {
        localSportDay = null;
        if (paramInt2 == 2)
          localSportDay = getStopDay();
      }
    }
  }

  public void removeSummary(SportDay paramSportDay)
  {
    Debug.i("DataManager", "Remove Summary : " + paramSportDay);
    this.d.remove(paramSportDay.getKey());
  }

  public void saveToDb()
  {
    Debug.f("DataManager", "in saveToDb");
    Iterator localIterator = this.c.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Debug.f("DataManager", "out saveToDb");
        return;
      }
      DaySportData localDaySportData = (DaySportData)((Map.Entry)localIterator.next()).getValue();
      if (localDaySportData.isLocalNeedSync())
      {
        Debug.i("DataManager", "saveToDb:" + localDaySportData.getKey());
        Debug.f("DataManager", "saveToDb:" + localDaySportData.getKey());
        this.b.write(localDaySportData.getKey(), localDaySportData.getBinaryData(), localDaySportData.getSummary(), localDaySportData.getIndexS());
        localDaySportData.setLocalNeedSync(false);
      }
    }
  }

  public void saveToDb(DaySportData paramDaySportData)
  {
    this.b.write(paramDaySportData.getKey(), paramDaySportData.getBinaryData(), paramDaySportData.getSummary(), paramDaySportData.getIndexS());
  }

  public void setCurDay(int paramInt1, int paramInt2)
  {
    SportDay localSportDay = this.g;
    if (paramInt2 == 0)
      localSportDay = this.g;
    while (true)
    {
      this.g = localSportDay.addDay(paramInt1);
      return;
      if (paramInt2 == 1)
        localSportDay = this.e;
      else if (paramInt2 == 2)
        localSportDay = getStopDay();
    }
  }

  public void setCurDay(SportDay paramSportDay)
  {
    this.g = paramSportDay;
  }

  public void updateSyncState(ArrayList<UploadData> paramArrayList, int paramInt)
  {
    this.b.updateSyncState(paramArrayList, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.DataManager
 * JD-Core Version:    0.6.2
 */