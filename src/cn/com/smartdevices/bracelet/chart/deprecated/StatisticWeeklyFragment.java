package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;

public class StatisticWeeklyFragment extends StatisticBaseFragment
{
  private static final String a = "Chart.StatisticWeekly";

  protected String formatDate(SportDay paramSportDay)
  {
    if (paramSportDay.getWeekStartDay().equals(this.mToday.getWeekStartDay()))
      return "本周";
    if (paramSportDay.addWeek(1).getWeekStartDay().equals(this.mToday.getWeekStartDay()))
      return "上周";
    SportDay localSportDay1 = paramSportDay.getWeekStartDay();
    SportDay localSportDay2 = localSportDay1.addDay(6);
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(1 + localSportDay1.mon);
    arrayOfObject1[1] = Integer.valueOf(localSportDay1.day);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(getString(2131492895, arrayOfObject1))).append(" - ");
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(1 + localSportDay2.mon);
    arrayOfObject2[1] = Integer.valueOf(localSportDay2.day);
    return getString(2131492895, arrayOfObject2);
  }

  protected String formatDateShort(SportDay paramSportDay)
  {
    if (paramSportDay.getWeekStartDay().equals(this.mToday.getWeekStartDay()))
      return "本周";
    if (paramSportDay.addWeek(1).getWeekStartDay().equals(this.mToday.getWeekStartDay()))
      return "上周";
    SportDay localSportDay1 = paramSportDay.getWeekStartDay();
    SportDay localSportDay2 = localSportDay1.addDay(6);
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(1 + localSportDay1.mon);
    arrayOfObject1[1] = Integer.valueOf(localSportDay1.day);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(getString(2131492897, arrayOfObject1))).append("-");
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(1 + localSportDay2.mon);
    arrayOfObject2[1] = Integer.valueOf(localSportDay2.day);
    return getString(2131492897, arrayOfObject2);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new v(this));
    this.mActiveStatisticChart.setDataLoader(localAsyncChartDataLoader);
    this.mActiveStatisticChart.loadData(0);
    this.mActiveStatisticChart.setScrollable(true);
  }

  protected void updateSleepAchievement(int paramInt)
  {
    getView().findViewById(2131165501).setVisibility(8);
  }

  protected void updateSleepRiseTime(int paramInt)
  {
    getView().findViewById(2131165499).setVisibility(8);
  }

  protected void updateSleepStartTime(int paramInt)
  {
    getView().findViewById(2131165497).setVisibility(8);
  }

  protected void updateStepAchievement(int paramInt)
  {
    View localView = getView().findViewById(2131165486);
    if (localView != null)
      ((ViewGroup)localView.getParent()).removeView(localView);
  }

  protected void updateStepContinueTime(int paramInt)
  {
    getView().findViewById(2131165483).setVisibility(8);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticWeeklyFragment
 * JD-Core Version:    0.6.2
 */