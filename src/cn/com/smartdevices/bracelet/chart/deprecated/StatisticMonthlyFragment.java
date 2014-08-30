package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.SportDay;

public class StatisticMonthlyFragment extends StatisticBaseFragment
{
  private static final String a = "Chart.StatisticMonthly";
  private String[] b;

  protected String formatDate(SportDay paramSportDay)
  {
    if ((paramSportDay.year == this.mToday.year) && (paramSportDay.mon == this.mToday.mon))
      return getString(2131492891);
    if ((paramSportDay.addMonth(1).year == this.mToday.year) && (paramSportDay.addMonth(1).mon == this.mToday.mon))
      return getString(2131492892);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramSportDay.year);
    arrayOfObject[1] = this.b[paramSportDay.mon];
    return getString(2131492901, arrayOfObject);
  }

  protected String formatDateShort(SportDay paramSportDay)
  {
    if ((paramSportDay.year == this.mToday.year) && (paramSportDay.mon == this.mToday.mon))
      return getString(2131492891);
    if ((paramSportDay.addMonth(1).year == this.mToday.year) && (paramSportDay.addMonth(1).mon == this.mToday.mon))
      return getString(2131492892);
    return paramSportDay.year + this.b[paramSportDay.mon];
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new u(this));
    this.mActiveStatisticChart.setDataLoader(localAsyncChartDataLoader);
    this.mActiveStatisticChart.loadData(0);
    this.mActiveStatisticChart.setScrollable(true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getResources().getStringArray(2131558402);
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
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticMonthlyFragment
 * JD-Core Version:    0.6.2
 */