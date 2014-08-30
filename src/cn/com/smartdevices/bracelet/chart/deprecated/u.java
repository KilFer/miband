package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.SportDay;

final class u
  implements ChartDataLoader.LoadCallback
{
  u(StatisticMonthlyFragment paramStatisticMonthlyFragment)
  {
  }

  public final boolean hasData(int paramInt)
  {
    SportDay localSportDay = this.a.mInitDay.addMonth(paramInt);
    Debug.i("Chart.StatisticMonthly", "Has Month : " + this.a.formatDate(localSportDay));
    if ((localSportDay.getMonthStartDay().before(this.a.mStartDay.getMonthStartDay())) || (localSportDay.getMonthStartDay().after(this.a.mStopDay.getMonthStartDay())))
    {
      Debug.w("Chart.StatisticMonthly", "False!!");
      return false;
    }
    return true;
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    int i = 0;
    SportDay localSportDay1 = this.a.mInitDay.addMonth(paramInt);
    Debug.i("Chart.StatisticMonthly", "Load Month : " + this.a.formatDate(localSportDay1));
    SportDay localSportDay2 = localSportDay1.getMonthStartDay();
    SportDay localSportDay3 = localSportDay1.getMonthEndDay();
    Debug.i("Chart.StatisticMonthly", localSportDay2 + "~" + localSportDay3);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (true)
    {
      if (i >= localSportDay3.day)
      {
        StatisticChartViewOld.StatisticChartData localStatisticChartData = this.a.newStatisticChartData(n, m, k, j);
        localStatisticChartData.date = this.a.formatDateShort(localSportDay1);
        return localStatisticChartData;
      }
      SportDay localSportDay4 = localSportDay2.addDay(i);
      Debug.i("Chart.StatisticMonthly", "Load Day : " + localSportDay4);
      DaySportData.Summary localSummary = this.a.mDataManager.getSummary(localSportDay4);
      Debug.i("Chart.StatisticMonthly", "Summary : " + localSummary);
      if (localSummary != null)
      {
        if (localSummary.getSteps() > 0)
        {
          n += localSummary.getSteps();
          k++;
        }
        if (localSummary.getSleep() > 0)
        {
          m += 100 * localSummary.getSleep() / 480;
          j++;
        }
      }
      i++;
    }
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    SportDay localSportDay1 = this.a.mInitDay.addMonth(paramInt);
    Debug.i("Chart.StatisticMonthly", "To Month : " + this.a.formatDate(localSportDay1));
    this.a.mCurrentDay = localSportDay1;
    this.a.updateDateTitle(this.a.mCurrentDay);
    this.a.cleanStatisticData();
    SportDay localSportDay2 = localSportDay1.getMonthStartDay();
    SportDay localSportDay3 = localSportDay1.getMonthEndDay();
    Debug.i("Chart.StatisticMonthly", localSportDay2 + "~" + localSportDay3);
    for (int i = 0; ; i++)
    {
      if (i >= localSportDay3.day)
      {
        this.a.updateStatisticInfo();
        return;
      }
      SportDay localSportDay4 = localSportDay2.addDay(i);
      Debug.i("Chart.StatisticMonthly", "Load Day : " + localSportDay4);
      this.a.totalStatisticData(localSportDay4);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.u
 * JD-Core Version:    0.6.2
 */