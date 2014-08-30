package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.SportDay;

final class v
  implements ChartDataLoader.LoadCallback
{
  v(StatisticWeeklyFragment paramStatisticWeeklyFragment)
  {
  }

  public final boolean hasData(int paramInt)
  {
    SportDay localSportDay = this.a.mInitDay.addWeek(paramInt);
    Debug.i("Chart.StatisticWeekly", "Has Week : " + this.a.formatDate(localSportDay));
    if ((localSportDay.getWeekStartDay().before(this.a.mStartDay.getWeekStartDay())) || (localSportDay.getWeekStartDay().after(this.a.mStopDay.getWeekStartDay())))
    {
      Debug.w("Chart.StatisticWeekly", "False!!");
      return false;
    }
    return true;
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    int i = 0;
    SportDay localSportDay1 = this.a.mInitDay.addWeek(paramInt);
    Debug.i("Chart.StatisticWeekly", "Load Week : " + this.a.formatDate(localSportDay1));
    SportDay localSportDay2 = localSportDay1.getWeekStartDay();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    if (j >= 7)
    {
      StatisticChartViewOld.StatisticChartData localStatisticChartData = this.a.newStatisticChartData(n, m, i, k);
      localStatisticChartData.date = this.a.formatDateShort(localSportDay1);
      return localStatisticChartData;
    }
    SportDay localSportDay3 = localSportDay2.addDay(j);
    Debug.i("Chart.StatisticWeekly", "Load Day : " + localSportDay3);
    DaySportData.Summary localSummary = this.a.mDataManager.getSummary(localSportDay3);
    Debug.i("Chart.StatisticWeekly", "Summary : " + localSummary);
    int i8;
    int i2;
    int i3;
    int i4;
    if (localSummary != null)
    {
      if (localSummary.getSteps() > 0)
      {
        n += localSummary.getSteps();
        i++;
      }
      if (localSummary.getSleep() > 0)
      {
        int i7 = m + 100 * localSummary.getSleep() / 480;
        i8 = k + 1;
        i2 = i7;
        i3 = n;
        i4 = i;
      }
    }
    int i1;
    for (int i5 = i8; ; i5 = i1)
    {
      j++;
      int i6 = i5;
      i = i4;
      n = i3;
      m = i2;
      k = i6;
      break;
      i1 = k;
      i2 = m;
      i3 = n;
      i4 = i;
    }
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    SportDay localSportDay1 = this.a.mInitDay.addWeek(paramInt);
    Debug.i("Chart.StatisticWeekly", "To Week : " + this.a.formatDate(localSportDay1));
    this.a.mCurrentDay = localSportDay1;
    this.a.updateDateTitle(localSportDay1);
    this.a.cleanStatisticData();
    SportDay localSportDay2 = localSportDay1.getWeekStartDay();
    for (int i = 0; ; i++)
    {
      if (i >= 7)
      {
        this.a.updateStatisticInfo();
        return;
      }
      SportDay localSportDay3 = localSportDay2.addDay(i);
      Debug.i("Chart.StatisticWeekly", "Load Day : " + localSportDay3);
      this.a.totalStatisticData(localSportDay3);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.v
 * JD-Core Version:    0.6.2
 */