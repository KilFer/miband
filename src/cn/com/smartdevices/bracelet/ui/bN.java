package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

final class bN extends bM
{
  private String[] g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;

  public bN(StatisticFragment paramStatisticFragment)
  {
    super(paramStatisticFragment, (byte)0);
    this.g = paramStatisticFragment.getResources().getStringArray(2131558400);
    this.h = paramStatisticFragment.getString(2131492887);
    this.i = paramStatisticFragment.getString(2131492888);
    this.j = paramStatisticFragment.getString(2131492895);
    this.k = paramStatisticFragment.getString(2131492896);
    this.l = paramStatisticFragment.getString(2131492897);
  }

  protected final StatisticChartView.StatisticChartData a(int paramInt)
  {
    SportDay localSportDay = StatisticFragment.e(this.m).addDay(paramInt);
    Debug.i("Statistic.Main", "Load Day : " + localSportDay);
    String str = localSportDay.getKey();
    DaySportData.Summary localSummary;
    if (!StatisticFragment.a(this.m).containsKey(str))
    {
      localSummary = StatisticFragment.f(this.m).getSummary(localSportDay);
      StatisticFragment.a(this.m).put(str, localSummary);
    }
    while (true)
    {
      StatisticChartView.StatisticChartData localStatisticChartData = new StatisticChartView.StatisticChartData();
      if (localSummary != null)
      {
        localStatisticChartData.stepValue = localSummary.getSteps();
        localStatisticChartData.sleepValue = localSummary.getSleep();
        localStatisticChartData.sleepDeepValue = localSummary.getSleepDeepTime();
      }
      localStatisticChartData.date = b(localSportDay);
      return localStatisticChartData;
      localSummary = (DaySportData.Summary)StatisticFragment.a(this.m).get(str);
    }
  }

  protected final ShareData a(SportDay paramSportDay, int paramInt)
  {
    ShareData localShareData = new ShareData();
    if (paramInt == 16)
    {
      a(StatisticFragment.k(this.m), localShareData);
      if (paramSportDay.equals(StatisticFragment.j(this.m)))
        localShareData.title = this.m.getString(2131493201);
    }
    while (paramInt != 1)
    {
      return localShareData;
      localShareData.title = this.m.getString(2131493203);
      return localShareData;
    }
    int n = this.c;
    int i1 = Keeper.readPersonInfo().getDaySportGoalSteps();
    String[] arrayOfString = ChartData.formatDistance(this.m.getActivity(), this.b);
    String str1 = arrayOfString[0] + arrayOfString[1];
    StatisticFragment localStatisticFragment = this.m;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str1;
    arrayOfObject[1] = Integer.valueOf(n);
    String str2 = localStatisticFragment.getString(2131493208, arrayOfObject);
    String str3;
    if (i1 > this.a)
    {
      localShareData.setType(1);
      if (paramSportDay.equals(StatisticFragment.j(this.m)));
      for (localShareData.title = this.m.getString(2131493206); ; localShareData.title = this.m.getString(2131493207))
      {
        str3 = str2 + this.m.getString(2131493009);
        localShareData.time = StatisticFragment.d(this.m).formatStringDay(this.m.getActivity());
        localShareData.content = this.a;
        localShareData.description = str3;
        localShareData.contentUnit = this.m.getString(2131492927);
        return localShareData;
      }
    }
    localShareData.setType(0);
    if (paramSportDay.equals(StatisticFragment.j(this.m)));
    for (localShareData.title = this.m.getString(2131493204); ; localShareData.title = this.m.getString(2131493205))
    {
      str3 = str2 + this.m.getString(2131493008);
      break;
    }
  }

  protected final String a(SportDay paramSportDay)
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (paramSportDay.equals(StatisticFragment.j(this.m)))
      return this.h;
    if (paramSportDay.offsetDay(StatisticFragment.j(this.m)) == -1)
      return this.i;
    if ((1 + paramSportDay.mon == 1) && (paramSportDay.day == 1))
    {
      localDate.setYear(paramSportDay.year);
      localDate.setMonth(paramSportDay.mon);
      localDate.setDate(paramSportDay.day);
      localSimpleDateFormat.applyPattern(this.k);
    }
    while (true)
    {
      return localSimpleDateFormat.format(localDate);
      localDate.setMonth(paramSportDay.mon);
      localDate.setDate(paramSportDay.day);
      localSimpleDateFormat.applyPattern(this.j);
    }
  }

  protected final String b(SportDay paramSportDay)
  {
    String str2;
    if (paramSportDay.equals(StatisticFragment.j(this.m)))
      str2 = this.h;
    while (true)
    {
      return str2;
      if (paramSportDay.offsetDay(StatisticFragment.j(this.m)) == -1)
      {
        if (paramSportDay.getWeek() == 0)
        {
          str2 = this.g[0];
          if ((1 + paramSportDay.mon == 1) && (paramSportDay.day == 1))
            return paramSportDay.year + "/" + str2;
        }
        else
        {
          return this.i;
        }
      }
      else
      {
        if (paramSportDay.getWeek() == 0);
        String str1;
        Object[] arrayOfObject;
        for (str2 = this.g[0]; (1 + paramSportDay.mon == 1) && (paramSportDay.day == 1); str2 = String.format(str1, arrayOfObject))
        {
          return paramSportDay.year + "/" + str2;
          str1 = this.l;
          arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(1 + paramSportDay.mon);
          arrayOfObject[1] = Integer.valueOf(paramSportDay.day);
        }
      }
    }
  }

  protected final void b(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165371);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165372);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165358);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165373);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165375);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165376);
    TextView localTextView7 = (TextView)paramView.findViewById(2131165377);
    localTextView1.setText(String.valueOf(this.a));
    String[] arrayOfString = ChartData.formatDistance(this.m.getActivity(), this.b);
    localTextView2.setText(arrayOfString[0]);
    localTextView3.setText(arrayOfString[1]);
    localTextView4.setText(String.valueOf(this.c));
    localTextView5.setText(ChartData.formatTimeLength(this.m.getActivity(), this.d, 14));
    localTextView6.setText(ChartData.formatTimeLength(this.m.getActivity(), this.e, 14));
    localTextView7.setText(ChartData.formatTimeLength(this.m.getActivity(), this.f, 14));
  }

  protected final boolean b(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < StatisticFragment.g(this.m).offsetDay(StatisticFragment.e(this.m))))
    {
      Debug.w("Statistic.Main", "Has data False : " + paramInt);
      return false;
    }
    return true;
  }

  protected final void c(int paramInt)
  {
    SportDay localSportDay = StatisticFragment.e(this.m).addDay(paramInt);
    Debug.i("Statistic.Main", "To Day : " + localSportDay);
    StatisticFragment.b(this.m, localSportDay);
    StatisticFragment.c(this.m, localSportDay);
    a();
    c(localSportDay);
    a((View)StatisticFragment.h(this.m).get(1));
    b((View)StatisticFragment.i(this.m).get(1));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bN
 * JD-Core Version:    0.6.2
 */