package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StageSteps;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartLoadCallback;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

final class P
  implements DynamicDetailChartView.DynamicDetailChartLoadCallback
{
  P(DynamicDetailFragment paramDynamicDetailFragment)
  {
  }

  public final boolean hasData(int paramInt)
  {
    SportDay localSportDay = DynamicDetailFragment.b(this.a).addDay(paramInt);
    Debug.i("Dynamic.Detail", "Has Day : " + localSportDay);
    if ((localSportDay.before(DynamicDetailFragment.d(this.a))) || (localSportDay.after(DynamicDetailFragment.e(this.a))))
    {
      Debug.w("Dynamic.Detail", "False!!");
      return false;
    }
    return true;
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    SportDay localSportDay = DynamicDetailFragment.b(this.a).addDay(paramInt);
    Debug.i("Dynamic.Detail", "Load Data : " + localSportDay);
    DynamicDetailFragment.a(this.a).load(localSportDay);
    DaySportData localDaySportData = DynamicDetailFragment.a(this.a).get(localSportDay);
    DynamicDetailChartView.DynamicDetailChartData localDynamicDetailChartData;
    String str;
    if (localDaySportData != null)
    {
      localDynamicDetailChartData = DynamicDetailFragment.a(this.a, localDaySportData);
      if (!localSportDay.equals(DynamicDetailFragment.c(this.a)))
        break label139;
      str = "今天";
    }
    while (true)
    {
      localDynamicDetailChartData.date = str;
      localDynamicDetailChartData.prevDate = DynamicDetailFragment.f(this.a, DynamicDetailFragment.b(this.a).addDay(paramInt - 1));
      return localDynamicDetailChartData;
      localDynamicDetailChartData = new DynamicDetailChartView.DynamicDetailChartData();
      break;
      label139: if (localSportDay.addDay(1).equals(DynamicDetailFragment.c(this.a)))
        str = "昨天";
      else
        str = DynamicDetailFragment.f(this.a, DynamicDetailFragment.b(this.a).addDay(paramInt));
    }
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
    int i = 0;
    if ((DynamicDetailFragment.g(this.a) == null) || (!DynamicDetailFragment.g(this.a).isAttached()))
    {
      Debug.w("Dynamic.Detail", "Chart Already Detached From UI : onDataLoaded , " + DynamicDetailFragment.g(this.a));
      return;
    }
    int j;
    int k;
    if (("DynamicView".equals(DynamicDetailFragment.k(this.a))) && (DynamicDetailFragment.h(this.a) == 1))
    {
      StageSteps localStageSteps = new StageSteps();
      localStageSteps.steps = DynamicDetailFragment.l(this.a);
      localStageSteps.count = DynamicDetailFragment.m(this.a);
      localStageSteps.distance = DynamicDetailFragment.n(this.a);
      DynamicDetailFragment.o(this.a).setVisibility(0);
      DynamicDetailFragment.a(this.a, localStageSteps, DynamicDetailFragment.o(this.a));
      DynamicDetailFragment localDynamicDetailFragment1 = this.a;
      DynamicDetailFragment localDynamicDetailFragment2 = this.a;
      Object[] arrayOfObject1 = new Object[1];
      DynamicDetailFragment localDynamicDetailFragment3 = this.a;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = ChartData.formatTime(DynamicDetailFragment.p(this.a));
      arrayOfObject2[1] = ChartData.formatTime(DynamicDetailFragment.q(this.a));
      arrayOfObject1[0] = localDynamicDetailFragment3.getString(2131492893, arrayOfObject2);
      DynamicDetailFragment.a(localDynamicDetailFragment1, localDynamicDetailFragment2.getString(2131493136, arrayOfObject1));
      j = DynamicDetailFragment.p(this.a) / 60;
      k = 1 + (DynamicDetailFragment.q(this.a) / 60 - j);
    }
    while (true)
    {
      if (i >= k)
      {
        if (DynamicDetailFragment.r(this.a) == null)
          break;
        DynamicDetailFragment.r(this.a).start();
        return;
      }
      DynamicDetailFragment.g(this.a).setStepItemSelection(j + i);
      i++;
    }
  }

  public final void onToItem(int paramInt)
  {
    if ((DynamicDetailFragment.g(this.a) == null) || (!DynamicDetailFragment.g(this.a).isAttached()))
    {
      Debug.w("Dynamic.Detail", "Chart Already Detached From UI : onToItem , " + DynamicDetailFragment.g(this.a));
      return;
    }
    SportDay localSportDay = DynamicDetailFragment.b(this.a).addDay(paramInt);
    Debug.i("Dynamic.Detail", "On To : " + localSportDay);
    DaySportData localDaySportData = DynamicDetailFragment.a(this.a).get(localSportDay);
    StepsInfo localStepsInfo = null;
    SleepInfo localSleepInfo1 = null;
    if (localDaySportData != null)
    {
      localSleepInfo1 = localDaySportData.getSleepInfo();
      localStepsInfo = localDaySportData.getStepsInfo();
    }
    label159: int i;
    if (DynamicDetailFragment.h(this.a) == 1)
    {
      if (localStepsInfo == null)
        localStepsInfo = new StepsInfo();
      DynamicDetailFragment.a(this.a, localStepsInfo, DynamicDetailFragment.s(this.a));
      if (localDaySportData != null)
      {
        SleepInfo localSleepInfo2 = localDaySportData.getSleepInfo();
        if (localSleepInfo2 == null)
          break label580;
        if (localSleepInfo2.getSleepCount() != 0)
          break label586;
      }
      i = 1;
    }
    while (true)
    {
      Calendar localCalendar3 = Calendar.getInstance();
      if ((DynamicDetailFragment.h(this.a) != 16) || (i == 0) || (!DynamicDetailFragment.b(this.a).equals(DynamicDetailFragment.e(this.a))) || (localCalendar3.get(11) >= 5))
        break;
      DynamicDetailFragment.b(this.a, DynamicDetailFragment.b(this.a).addDay(-1));
      DynamicDetailFragment.g(this.a).clearData();
      DynamicDetailFragment.g(this.a).loadDynamicData(0, new int[] { -1 });
      return;
      if (DynamicDetailFragment.h(this.a) != 16)
        break label159;
      label343: Calendar localCalendar1;
      Calendar localCalendar2;
      if (localSleepInfo1 != null)
        if (!localSleepInfo1.getHasSleep())
        {
          DynamicDetailFragment.t(this.a).setVisibility(0);
          if (localSleepInfo1.getSleepCount() == 0)
          {
            DynamicDetailFragment.t(this.a).setText(2131493278);
            if (localSleepInfo1 == null)
              localSleepInfo1 = new SleepInfo();
            localCalendar1 = Calendar.getInstance();
            localCalendar1.setTime(localSleepInfo1.getStartOnBedDate());
            localCalendar2 = Calendar.getInstance();
            localCalendar2.setTime(localSleepInfo1.getStopOnBedDate());
            if (!localSportDay.addDay(-1).equals(localCalendar1))
              break label542;
            DynamicDetailFragment.a(this.a, DynamicDetailFragment.a(this.a, localCalendar1));
            label416: if (!localSportDay.addDay(-1).equals(localCalendar2))
              break label561;
            DynamicDetailFragment.b(this.a, DynamicDetailFragment.a(this.a, localCalendar2));
          }
        }
      while (true)
      {
        DynamicDetailFragment.g(this.a).setStartEndTimeIndex(DynamicDetailFragment.u(this.a), DynamicDetailFragment.v(this.a));
        DynamicDetailFragment.a(this.a, localSleepInfo1, localSleepInfo1.getStartDateMin(), localSleepInfo1.getStopDateMin(), DynamicDetailFragment.w(this.a));
        break;
        DynamicDetailFragment.t(this.a).setText("");
        break label343;
        DynamicDetailFragment.t(this.a).setVisibility(4);
        break label343;
        DynamicDetailFragment.t(this.a).setVisibility(4);
        break label343;
        label542: DynamicDetailFragment.a(this.a, DynamicDetailFragment.b(this.a, localCalendar1));
        break label416;
        label561: DynamicDetailFragment.b(this.a, DynamicDetailFragment.b(this.a, localCalendar2));
      }
      label580: i = 1;
      continue;
      label586: i = 0;
    }
  }

  public final void onTouchItem(int paramInt1, BarChart.BarItem paramBarItem, int paramInt2, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    label70: DaySportData localDaySportData;
    if (DynamicDetailFragment.h(this.a) == 16)
    {
      localObject = DynamicDetailFragment.x(this.a);
      DynamicDetailFragment.a(this.a, paramBarItem, paramInt2, DynamicDetailFragment.x(this.a));
      if (DynamicDetailFragment.y(this.a) != null)
      {
        if (DynamicDetailFragment.y(this.a).isRunning())
          DynamicDetailFragment.y(this.a).end();
      }
      else if (!DynamicDetailFragment.z(this.a))
      {
        ((View)localObject).setVisibility(0);
        DynamicDetailFragment.a(this.a, true);
        DynamicDetailFragment.a(this.a, DynamicDetailFragment.a(this.a, paramFloat1, paramFloat2, (View)localObject));
        DynamicDetailFragment.A(this.a).start();
      }
    }
    else if (DynamicDetailFragment.h(this.a) == 1)
    {
      localDaySportData = DynamicDetailFragment.a(this.a).get(DynamicDetailFragment.b(this.a));
      if (localDaySportData == null)
        break label316;
    }
    label316: for (StepsInfo localStepsInfo = localDaySportData.getStepsInfo(); ; localStepsInfo = null)
    {
      if (localStepsInfo == null)
        localStepsInfo = new StepsInfo();
      Iterator localIterator = localStepsInfo.getStageSteps().iterator();
      StageSteps localStageSteps;
      do
      {
        if (!localIterator.hasNext())
        {
          localObject = null;
          break;
        }
        localStageSteps = (StageSteps)localIterator.next();
      }
      while (localStageSteps.time != paramInt1);
      View localView = DynamicDetailFragment.o(this.a);
      DynamicDetailFragment localDynamicDetailFragment1 = this.a;
      DynamicDetailFragment localDynamicDetailFragment2 = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ChartData.formatTime(paramInt1 * 60);
      DynamicDetailFragment.a(localDynamicDetailFragment1, localDynamicDetailFragment2.getString(2131493136, arrayOfObject));
      DynamicDetailFragment.a(this.a, localStageSteps, DynamicDetailFragment.o(this.a));
      localObject = localView;
      break;
      DynamicDetailFragment.y(this.a).cancel();
      break label70;
    }
  }

  public final void onTouchNothing(float paramFloat1, float paramFloat2)
  {
    View localView;
    if (DynamicDetailFragment.h(this.a) == 16)
      localView = DynamicDetailFragment.x(this.a);
    while (true)
    {
      if ((DynamicDetailFragment.y(this.a) == null) && (DynamicDetailFragment.z(this.a)))
      {
        DynamicDetailFragment.b(this.a, DynamicDetailFragment.a(this.a, localView));
        DynamicDetailFragment.y(this.a).start();
      }
      return;
      int i = DynamicDetailFragment.h(this.a);
      localView = null;
      if (i == 1)
        localView = DynamicDetailFragment.o(this.a);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.P
 * JD-Core Version:    0.6.2
 */