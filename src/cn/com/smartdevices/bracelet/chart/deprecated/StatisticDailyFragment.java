package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatisticDailyFragment extends StatisticBaseFragment
{
  private static final String a = "Chart.StatisticDaily";
  private String[] b;
  private String[] c;

  protected String formatDate(SportDay paramSportDay)
  {
    if (paramSportDay.equals(this.mToday))
      return getString(2131493082);
    if (paramSportDay.addDay(1).equals(this.mToday))
      return getString(2131492888);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(getString(2131492895));
    Date localDate = new Date();
    localDate.setMonth(paramSportDay.mon);
    localDate.setDate(paramSportDay.day);
    String str = localSimpleDateFormat.format(localDate);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = this.b[paramSportDay.getWeek()];
    return getString(2131492898, arrayOfObject);
  }

  protected String formatDateShort(SportDay paramSportDay)
  {
    if (paramSportDay.equals(this.mToday))
      return getString(2131493082);
    if (paramSportDay.addDay(1).equals(this.mToday))
      return getString(2131492888);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(1 + paramSportDay.mon);
    arrayOfObject[1] = Integer.valueOf(paramSportDay.day);
    arrayOfObject[2] = this.c[paramSportDay.getWeek()];
    return getString(2131492899, arrayOfObject);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new s(this));
    this.mActiveStatisticChart.setDataLoader(localAsyncChartDataLoader);
    this.mActiveStatisticChart.loadData(0);
    this.mActiveStatisticChart.setScrollable(true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getResources().getStringArray(2131558400);
    this.c = getResources().getStringArray(2131558401);
  }

  protected void updateSleepAchievement(int paramInt)
  {
    if ((0x1 & StatisticHostFragment.sMode) > 0)
    {
      getView().findViewById(2131165501).setVisibility(8);
      return;
    }
    getView().findViewById(2131165501).setVisibility(0);
    super.updateSleepAchievement(paramInt);
  }

  protected void updateSleepRiseTime(int paramInt)
  {
    if ((0x1 & StatisticHostFragment.sMode) > 0)
    {
      getView().findViewById(2131165499).setVisibility(8);
      return;
    }
    getView().findViewById(2131165499).setVisibility(0);
    super.updateSleepRiseTime(paramInt);
  }

  protected void updateSleepStartTime(int paramInt)
  {
    if ((0x1 & StatisticHostFragment.sMode) > 0)
    {
      getView().findViewById(2131165497).setVisibility(8);
      return;
    }
    getView().findViewById(2131165497).setVisibility(0);
    super.updateSleepStartTime(paramInt);
  }

  protected void updateStepAchievement(int paramInt)
  {
    if ((0x1 & StatisticHostFragment.sMode) > 0)
    {
      getView().findViewById(2131165486).setVisibility(8);
      return;
    }
    getView().findViewById(2131165486).setVisibility(0);
    super.updateStepAchievement(paramInt);
  }

  protected void updateStepActiveTime(int paramInt)
  {
    super.updateStepActiveTime(paramInt);
  }

  protected void updateStepContinueTime(int paramInt)
  {
    if ((0x1 & StatisticHostFragment.sMode) > 0)
    {
      getView().findViewById(2131165483).setVisibility(8);
      return;
    }
    getView().findViewById(2131165483).setVisibility(0);
    super.updateStepContinueTime(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticDailyFragment
 * JD-Core Version:    0.6.2
 */