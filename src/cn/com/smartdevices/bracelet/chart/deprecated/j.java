package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Calendar;

final class j
  implements ChartDataLoader.LoadCallback
{
  j(DynamicDetailFragmentOld paramDynamicDetailFragmentOld)
  {
  }

  private static int a(Calendar paramCalendar)
  {
    return -(60 * (-1 + (24 - paramCalendar.get(11))) + (60 - paramCalendar.get(12)));
  }

  private static int b(Calendar paramCalendar)
  {
    return 60 * paramCalendar.get(11) + paramCalendar.get(12);
  }

  public final boolean hasData(int paramInt)
  {
    SportDay localSportDay = DynamicDetailFragmentOld.a(this.a).addDay(paramInt);
    Debug.i("DDDD", "Has Day : " + localSportDay);
    if ((localSportDay.before(DynamicDetailFragmentOld.b(this.a))) || (localSportDay.after(DynamicDetailFragmentOld.c(this.a))))
    {
      Debug.w("DDDD", "False!!");
      return false;
    }
    return true;
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    SportDay localSportDay = DynamicDetailFragmentOld.a(this.a).addDay(paramInt);
    Debug.i("DDDD", "Load Data : " + localSportDay);
    DynamicDetailFragmentOld.e(this.a).load(localSportDay);
    DaySportData localDaySportData = DynamicDetailFragmentOld.e(this.a).get(localSportDay);
    DynamicDetailChartViewOld.DynamicDetailChartData localDynamicDetailChartData;
    String str;
    if (localDaySportData != null)
    {
      localDynamicDetailChartData = DynamicDetailFragmentOld.a(this.a, localDaySportData);
      if (!localSportDay.equals(DynamicDetailFragmentOld.f(this.a)))
        break label139;
      str = "今天";
    }
    while (true)
    {
      localDynamicDetailChartData.date = str;
      localDynamicDetailChartData.prevDate = DynamicDetailFragmentOld.b(this.a, DynamicDetailFragmentOld.a(this.a).addDay(paramInt - 1));
      return localDynamicDetailChartData;
      localDynamicDetailChartData = new DynamicDetailChartViewOld.DynamicDetailChartData();
      break;
      label139: if (localSportDay.addDay(1).equals(DynamicDetailFragmentOld.f(this.a)))
        str = "昨天";
      else
        str = DynamicDetailFragmentOld.b(this.a, DynamicDetailFragmentOld.a(this.a).addDay(paramInt));
    }
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    SportDay localSportDay = DynamicDetailFragmentOld.a(this.a).addDay(paramInt);
    Debug.i("DDDD", "On To : " + localSportDay);
    DaySportData localDaySportData = DynamicDetailFragmentOld.e(this.a).get(localSportDay);
    SleepInfo localSleepInfo;
    StepsInfo localStepsInfo;
    if (localDaySportData != null)
    {
      localSleepInfo = localDaySportData.getSleepInfo();
      localStepsInfo = localDaySportData.getStepsInfo();
    }
    while (true)
    {
      if (localSleepInfo == null)
        localSleepInfo = new SleepInfo();
      if (localStepsInfo == null)
        localStepsInfo = new StepsInfo();
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTime(localSleepInfo.getStartDate());
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(localSleepInfo.getStopDate());
      DynamicDetailFragmentOld.g(this.a).setOffset(0);
      int j;
      int k;
      label205: String str1;
      String[] arrayOfString;
      if (!localCalendar1.equals(localCalendar2))
      {
        int i = localCalendar1.get(11);
        if (localSportDay.addDay(-1).equals(localCalendar1))
        {
          DynamicDetailFragmentOld.g(this.a).setOffset(-(24 - i));
          j = a(localCalendar1);
          if (!localSportDay.addDay(-1).equals(localCalendar2))
            break label398;
          k = a(localCalendar2);
          DynamicDetailFragmentOld.g(this.a).setSleepStartTime(j, this.a.formatTime(localCalendar1.get(11), localCalendar1.get(12)), " 休养生息");
          DynamicDetailFragmentOld.g(this.a).setSleepRiseTime(k, this.a.formatTime(localCalendar2.get(11), localCalendar2.get(12)), " 新的一天");
        }
      }
      else
      {
        str1 = new String();
        arrayOfString = this.a.formatTimeHourMin(localStepsInfo.getActMinutes());
        if (arrayOfString[0] == null)
          break label408;
      }
      label398: label408: for (String str2 = str1 + arrayOfString[0] + "小时"; ; str2 = str1)
      {
        String str3 = str2 + arrayOfString[1] + "分钟";
        DynamicDetailFragmentOld.g(this.a).setStepTime("总活动时间", str3);
        DynamicDetailFragmentOld.g(this.a).notifyChanged();
        return;
        j = b(localCalendar1);
        break;
        k = b(localCalendar2);
        break label205;
      }
      localStepsInfo = null;
      localSleepInfo = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.j
 * JD-Core Version:    0.6.2
 */