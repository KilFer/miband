package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.SportDay;

final class s
  implements ChartDataLoader.LoadCallback
{
  s(StatisticDailyFragment paramStatisticDailyFragment)
  {
  }

  public final boolean hasData(int paramInt)
  {
    SportDay localSportDay = this.a.mInitDay.addDay(paramInt);
    Debug.i("Chart.StatisticDaily", "Has Day : " + localSportDay);
    if ((localSportDay.before(this.a.mStartDay)) || (localSportDay.after(this.a.mStopDay)))
    {
      Debug.w("Chart.StatisticDaily", "False!!");
      return false;
    }
    return true;
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    SportDay localSportDay = this.a.mInitDay.addDay(paramInt);
    Debug.i("Chart.StatisticDaily", "Load Day : " + localSportDay);
    DaySportData.Summary localSummary = this.a.mDataManager.getSummary(localSportDay);
    Debug.i("Chart.StatisticDaily", "Summary : " + localSummary);
    StatisticChartViewOld.StatisticChartData localStatisticChartData = new StatisticChartViewOld.StatisticChartData();
    if (localSummary != null)
    {
      localStatisticChartData.stepValue = localSummary.getSteps();
      localStatisticChartData.sleepValue = (100 * localSummary.getSleep() / 480);
    }
    localStatisticChartData.date = this.a.formatDateShort(localSportDay);
    return localStatisticChartData;
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    SportDay localSportDay = this.a.mInitDay.addDay(paramInt);
    Debug.i("Chart.StatisticDaily", "To Day : " + localSportDay);
    this.a.mCurrentDay = localSportDay;
    this.a.updateDateTitle(this.a.mCurrentDay);
    this.a.cleanStatisticData();
    DaySportData.Summary localSummary = this.a.mDataManager.getSummary(localSportDay);
    if (localSummary != null)
    {
      this.a.totalStatisticDataStep(localSummary);
      this.a.totalStatisticDataSleep(localSummary);
    }
    this.a.updateStatisticInfo();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.s
 * JD-Core Version:    0.6.2
 */