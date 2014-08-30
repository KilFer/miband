package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.eventbus.EventSwitchViewMode;
import cn.com.smartdevices.bracelet.eventbus.EventUpdateTitle;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.text.DecimalFormat;
import java.util.Calendar;

public class StatisticBaseFragment extends Fragment
{
  private static final String a = "Chart.StatisticBaseFragment";
  private int b;
  protected StatisticChartViewOld mActiveStatisticChart;
  protected SportDay mCurrentDay;
  protected DataManager mDataManager;
  protected int mDayCountSleep;
  protected int mDayCountStep;
  protected SportDay mInitDay;
  protected int mSleepAchievement;
  protected int mSleepDeepTime;
  protected int mSleepRiseTime;
  protected int mSleepShallowTime;
  protected int mSleepStartTime;
  protected int mSleepTime;
  protected SportDay mStartDay;
  protected TextView mStatSleepAchievement;
  protected TextView mStatSleepDeepHour;
  protected TextView mStatSleepDeepMin;
  protected TextView mStatSleepHour;
  protected TextView mStatSleepMin;
  protected TextView mStatSleepRiseTime;
  protected TextView mStatSleepShallowHour;
  protected TextView mStatSleepShallowMin;
  protected TextView mStatSleepStartTime;
  protected TextView mStatStepAchievement;
  protected TextView mStatStepActiveHour;
  protected TextView mStatStepActiveMin;
  protected TextView mStatStepCalorie;
  protected TextView mStatStepContinueHour;
  protected TextView mStatStepContinueMin;
  protected TextView mStatStepCount;
  protected TextView mStatStepDistance;
  protected TextView mStatStepDistanceUnit;
  protected int mStepAchievement;
  protected int mStepActiveTime;
  protected int mStepCalorie;
  protected int mStepContinueTime;
  protected int mStepCount;
  protected int mStepDistance;
  protected SportDay mStopDay;
  protected SportDay mToday;

  private void a(View paramView)
  {
    this.mActiveStatisticChart = ((StatisticChartViewOld)paramView.findViewById(2131165471));
    this.mStatStepCount = ((TextView)paramView.findViewById(2131165473));
    this.mStatStepDistance = ((TextView)paramView.findViewById(2131165476));
    this.mStatStepDistanceUnit = ((TextView)paramView.findViewById(2131165475));
    this.mStatStepCalorie = ((TextView)paramView.findViewById(2131165479));
    this.mStatStepAchievement = ((TextView)paramView.findViewById(2131165487));
    this.mStatStepActiveHour = ((TextView)paramView.findViewById(2131165481));
    this.mStatStepActiveMin = ((TextView)paramView.findViewById(2131165482));
    this.mStatStepContinueHour = ((TextView)paramView.findViewById(2131165484));
    this.mStatStepContinueMin = ((TextView)paramView.findViewById(2131165485));
    this.mStatSleepHour = ((TextView)paramView.findViewById(2131165489));
    this.mStatSleepMin = ((TextView)paramView.findViewById(2131165490));
    this.mStatSleepDeepHour = ((TextView)paramView.findViewById(2131165492));
    this.mStatSleepDeepMin = ((TextView)paramView.findViewById(2131165493));
    this.mStatSleepShallowHour = ((TextView)paramView.findViewById(2131165495));
    this.mStatSleepShallowMin = ((TextView)paramView.findViewById(2131165496));
    this.mStatSleepAchievement = ((TextView)paramView.findViewById(2131165502));
    this.mStatSleepStartTime = ((TextView)paramView.findViewById(2131165498));
    this.mStatSleepRiseTime = ((TextView)paramView.findViewById(2131165500));
  }

  private static void a(TextView paramTextView1, TextView paramTextView2, int paramInt)
  {
    String[] arrayOfString = ChartData.formatTimeLengthHourMin(paramInt);
    if (!arrayOfString[0].equals("0"))
    {
      paramTextView1.setText(arrayOfString[0]);
      ((View)paramTextView1.getParent()).setVisibility(0);
    }
    while (true)
    {
      paramTextView2.setText(arrayOfString[1]);
      return;
      ((View)paramTextView1.getParent()).setVisibility(8);
    }
  }

  private static String[] a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    if (paramInt < 100);
    for (String str = String.valueOf(paramInt); ; str = String.valueOf(paramInt))
    {
      arrayOfString[0] = str;
      return arrayOfString;
    }
  }

  private static String[] a(Context paramContext, int paramInt)
  {
    String[] arrayOfString = new String[2];
    float f = paramInt;
    if (paramInt >= 1000)
    {
      arrayOfString[0] = String.valueOf(Math.round(100.0F * (f / 1000.0F)) / 100.0F);
      arrayOfString[1] = paramContext.getString(2131492924);
      return arrayOfString;
    }
    arrayOfString[0] = String.valueOf(paramInt);
    arrayOfString[1] = paramContext.getString(2131492925);
    return arrayOfString;
  }

  protected void cleanStatisticData()
  {
    this.mStepCount = 0;
    this.mStepDistance = 0;
    this.mStepCalorie = 0;
    this.mStepAchievement = 0;
    this.mStepActiveTime = 0;
    this.mStepContinueTime = 0;
    this.mSleepTime = 0;
    this.mSleepDeepTime = 0;
    this.mSleepShallowTime = 0;
    this.mSleepAchievement = 0;
    this.mSleepStartTime = 0;
    this.mSleepRiseTime = 0;
    this.mDayCountStep = 0;
    this.mDayCountSleep = 0;
  }

  protected String formatDate(SportDay paramSportDay)
  {
    return null;
  }

  protected String formatDateShort(SportDay paramSportDay)
  {
    return null;
  }

  protected int millisToMins(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    return localCalendar.get(12) + i * 60;
  }

  protected StatisticChartViewOld.StatisticChartData newStatisticChartData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StatisticChartViewOld.StatisticChartData localStatisticChartData = new StatisticChartViewOld.StatisticChartData();
    if (paramInt3 > 0)
      localStatisticChartData.stepValue = (paramInt1 / paramInt3);
    if (paramInt4 > 0)
      localStatisticChartData.sleepValue = (paramInt2 / paramInt4);
    return localStatisticChartData;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mActiveStatisticChart.setStepGoal(this.b);
    updateStatisticInfo();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventBus.getDefault().register(this);
    this.mDataManager = DataManager.getInstance();
    this.mToday = this.mDataManager.getToday();
    this.mInitDay = this.mDataManager.getCurDay();
    this.mCurrentDay = this.mInitDay;
    this.mStartDay = this.mDataManager.getStartDay();
    this.mStopDay = this.mDataManager.getStopDay();
    Debug.i("Chart.StatisticBaseFragment", "Today : " + this.mToday + " , StartDay : " + this.mStartDay + " , StopDay : " + this.mStopDay + " , CurrentDay : " + this.mCurrentDay);
    this.b = Keeper.readPersonInfo().getDaySportGoalSteps();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903109, paramViewGroup, false);
    this.mActiveStatisticChart = ((StatisticChartViewOld)localView.findViewById(2131165471));
    this.mStatStepCount = ((TextView)localView.findViewById(2131165473));
    this.mStatStepDistance = ((TextView)localView.findViewById(2131165476));
    this.mStatStepDistanceUnit = ((TextView)localView.findViewById(2131165475));
    this.mStatStepCalorie = ((TextView)localView.findViewById(2131165479));
    this.mStatStepAchievement = ((TextView)localView.findViewById(2131165487));
    this.mStatStepActiveHour = ((TextView)localView.findViewById(2131165481));
    this.mStatStepActiveMin = ((TextView)localView.findViewById(2131165482));
    this.mStatStepContinueHour = ((TextView)localView.findViewById(2131165484));
    this.mStatStepContinueMin = ((TextView)localView.findViewById(2131165485));
    this.mStatSleepHour = ((TextView)localView.findViewById(2131165489));
    this.mStatSleepMin = ((TextView)localView.findViewById(2131165490));
    this.mStatSleepDeepHour = ((TextView)localView.findViewById(2131165492));
    this.mStatSleepDeepMin = ((TextView)localView.findViewById(2131165493));
    this.mStatSleepShallowHour = ((TextView)localView.findViewById(2131165495));
    this.mStatSleepShallowMin = ((TextView)localView.findViewById(2131165496));
    this.mStatSleepAchievement = ((TextView)localView.findViewById(2131165502));
    this.mStatSleepStartTime = ((TextView)localView.findViewById(2131165498));
    this.mStatSleepRiseTime = ((TextView)localView.findViewById(2131165500));
    return localView;
  }

  public void onDestroy()
  {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  public void onEvent(EventSwitchViewMode paramEventSwitchViewMode)
  {
    updateStatisticInfo();
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      updateDateTitle(this.mCurrentDay);
      updateStatisticInfo();
    }
  }

  protected void totalStatisticData(SportDay paramSportDay)
  {
    DaySportData.Summary localSummary = this.mDataManager.getSummary(paramSportDay);
    Debug.i("Chart.StatisticBaseFragment", "Summary : " + localSummary);
    if (localSummary != null)
    {
      if (localSummary.getSteps() > 0)
      {
        totalStatisticDataStep(localSummary);
        this.mDayCountStep = (1 + this.mDayCountStep);
      }
      if (localSummary.getSleep() > 0)
      {
        totalStatisticDataSleep(localSummary);
        this.mDayCountSleep = (1 + this.mDayCountSleep);
      }
    }
  }

  protected void totalStatisticDataSleep(DaySportData.Summary paramSummary)
  {
    this.mSleepTime += paramSummary.getSleep();
    this.mSleepDeepTime += paramSummary.getSleepDeepTime();
    this.mSleepShallowTime += paramSummary.getSleepShallowTime();
    this.mSleepAchievement += 100 * paramSummary.getSleep() / 480;
    this.mSleepStartTime += millisToMins(paramSummary.getSleepStartTime());
    this.mSleepRiseTime += millisToMins(paramSummary.getSleepRiseTime());
  }

  protected void totalStatisticDataStep(DaySportData.Summary paramSummary)
  {
    this.mStepCount += paramSummary.getSteps();
    this.mStepDistance += paramSummary.getStepDistance();
    this.mStepCalorie += paramSummary.getStepCalorie();
    this.mStepAchievement += 100 * paramSummary.getSteps() / this.b;
    this.mStepActiveTime += paramSummary.getStepActiveTime();
    this.mStepContinueTime += paramSummary.getStepContinueTime();
  }

  protected void updateDateTitle(SportDay paramSportDay)
  {
    if ((getUserVisibleHint()) && (paramSportDay != null))
    {
      String str = formatDate(paramSportDay);
      Debug.i("Chart.StatisticBaseFragment", "UpdateTitle : " + str);
      EventBus.getDefault().post(new EventUpdateTitle(str));
    }
  }

  protected void updateSleepAchievement(int paramInt)
  {
    this.mStatSleepAchievement.setText(String.valueOf(paramInt));
  }

  protected void updateSleepDeepTime(int paramInt)
  {
    a(this.mStatSleepDeepHour, this.mStatSleepDeepMin, paramInt);
  }

  protected void updateSleepRiseTime(int paramInt)
  {
    this.mStatSleepRiseTime.setText(ChartData.formatTime(paramInt));
  }

  protected void updateSleepShallow(int paramInt)
  {
    a(this.mStatSleepShallowHour, this.mStatSleepShallowMin, paramInt);
  }

  protected void updateSleepStartTime(int paramInt)
  {
    this.mStatSleepStartTime.setText(ChartData.formatTime(paramInt));
  }

  protected void updateSleepTime(int paramInt)
  {
    a(this.mStatSleepHour, this.mStatSleepMin, paramInt);
  }

  protected void updateStatisticInfo()
  {
    if (getView() == null)
      return;
    int i;
    int j;
    label46: int k;
    label65: int m;
    label85: int n;
    label114: int i1;
    label155: int i2;
    if ((0x100 & StatisticHostFragment.sMode) > 0)
    {
      i = 1;
      if (this.mDayCountStep == 0)
        this.mDayCountStep = 1;
      if (i == 0)
        break label233;
      j = this.mStepCount / this.mDayCountStep;
      updateStepCount(j);
      if (i == 0)
        break label241;
      k = this.mStepDistance / this.mDayCountStep;
      updateStepDistance(k);
      if (i == 0)
        break label249;
      m = this.mStepCalorie / this.mDayCountStep;
      updateStepCalorie(m);
      updateStepAchievement(this.mStepAchievement);
      if (i == 0)
        break label258;
      n = this.mStepActiveTime / this.mDayCountStep;
      updateStepActiveTime(n);
      updateStepContinueTime(this.mStepContinueTime);
      if (this.mDayCountSleep == 0)
        this.mDayCountSleep = 1;
      if (i == 0)
        break label267;
      i1 = this.mSleepTime / this.mDayCountSleep;
      updateSleepTime(i1);
      if (i == 0)
        break label276;
      i2 = this.mSleepDeepTime / this.mDayCountSleep;
      label176: updateSleepDeepTime(i2);
      if (i == 0)
        break label285;
    }
    label258: label267: label276: label285: for (int i3 = this.mSleepShallowTime / this.mDayCountSleep; ; i3 = this.mSleepShallowTime)
    {
      updateSleepShallow(i3);
      updateSleepAchievement(this.mSleepAchievement);
      updateSleepStartTime(this.mSleepStartTime);
      updateSleepRiseTime(this.mSleepRiseTime);
      return;
      i = 0;
      break;
      label233: j = this.mStepCount;
      break label46;
      label241: k = this.mStepDistance;
      break label65;
      label249: m = this.mStepCalorie;
      break label85;
      n = this.mStepActiveTime;
      break label114;
      i1 = this.mSleepTime;
      break label155;
      i2 = this.mSleepDeepTime;
      break label176;
    }
  }

  protected void updateStepAchievement(int paramInt)
  {
    this.mStatStepAchievement.setText(String.valueOf(paramInt));
  }

  protected void updateStepActiveTime(int paramInt)
  {
    a(this.mStatStepActiveHour, this.mStatStepActiveMin, paramInt);
  }

  protected void updateStepCalorie(int paramInt)
  {
    this.mStatStepCalorie.setText(new DecimalFormat(",###").format(paramInt));
  }

  protected void updateStepContinueTime(int paramInt)
  {
    a(this.mStatStepContinueHour, this.mStatStepContinueMin, paramInt);
  }

  protected void updateStepCount(int paramInt)
  {
    this.mStatStepCount.setText(new DecimalFormat(",###").format(paramInt));
  }

  protected void updateStepDistance(int paramInt)
  {
    Activity localActivity = getActivity();
    String[] arrayOfString = new String[2];
    float f = paramInt;
    if (paramInt >= 1000)
    {
      arrayOfString[0] = String.valueOf(Math.round(100.0F * (f / 1000.0F)) / 100.0F);
      arrayOfString[1] = localActivity.getString(2131492924);
    }
    while (true)
    {
      this.mStatStepDistance.setText(arrayOfString[0]);
      this.mStatStepDistanceUnit.setText(arrayOfString[1]);
      return;
      arrayOfString[0] = String.valueOf(paramInt);
      arrayOfString[1] = localActivity.getString(2131492925);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticBaseFragment
 * JD-Core Version:    0.6.2
 */