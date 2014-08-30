package cn.com.smartdevices.bracelet.ui;

import android.util.SparseArray;
import android.view.View;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

final class bO extends bM
{
  private final String g;
  private final String h;
  private String i;
  private String j;
  private String k;
  private String l;

  public bO(StatisticFragment paramStatisticFragment)
  {
    super(paramStatisticFragment, (byte)0);
    this.i = paramStatisticFragment.getString(2131492891);
    this.j = paramStatisticFragment.getString(2131492892);
    this.k = paramStatisticFragment.getString(2131492900);
    this.l = paramStatisticFragment.getString(2131492901);
    this.g = paramStatisticFragment.getString(2131492897);
    this.h = paramStatisticFragment.getString(2131492894);
  }

  protected final StatisticChartView.StatisticChartData a(int paramInt)
  {
    SportDay localSportDay1 = StatisticFragment.e(this.m).addMonth(paramInt);
    Debug.i("Statistic.Main", "Load Month : " + a(localSportDay1));
    SportDay localSportDay2 = localSportDay1.getMonthStartDay();
    SportDay localSportDay3 = localSportDay1.getMonthEndDay();
    Debug.i("Statistic.Main", localSportDay2 + "~" + localSportDay3);
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    if (n >= localSportDay3.day)
    {
      StatisticChartView.StatisticChartData localStatisticChartData = a(i5, i4, i3, i2, i1);
      localStatisticChartData.date = a(localSportDay1);
      return localStatisticChartData;
    }
    SportDay localSportDay4 = localSportDay2.addDay(n);
    Debug.i("Statistic.Main", "Load Day : " + localSportDay4);
    String str = localSportDay4.getKey();
    DaySportData.Summary localSummary;
    if (!StatisticFragment.a(this.m).containsKey(str))
    {
      localSummary = StatisticFragment.f(this.m).getSummary(localSportDay4);
      StatisticFragment.a(this.m).put(str, localSummary);
    }
    while (true)
    {
      if (localSummary != null)
      {
        if (localSummary.getSteps() > 0)
        {
          i5 += localSummary.getSteps();
          i2++;
        }
        if (localSummary.getSleep() > 0)
        {
          i4 += localSummary.getSleep();
          i3 += localSummary.getSleepDeepTime();
          i1++;
        }
      }
      n++;
      break;
      localSummary = (DaySportData.Summary)StatisticFragment.a(this.m).get(str);
    }
  }

  protected final ShareData a(SportDay paramSportDay, int paramInt)
  {
    ShareData localShareData = new ShareData();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    Date localDate = new Date();
    String str1;
    label100: SportDay localSportDay1;
    SportDay localSportDay2;
    if (paramSportDay.offsetMonth(StatisticFragment.j(this.m)) == 0)
    {
      str1 = this.i;
      if (paramInt != 16)
        break label316;
      a(StatisticFragment.k(this.m), localShareData);
      localShareData.title = (str1 + ", " + this.m.getString(2131493202));
      localSportDay1 = paramSportDay.getMonthStartDay();
      localSportDay2 = localSportDay1.addMonth(1).addDay(-1);
      if (paramSportDay.offsetMonth(StatisticFragment.j(this.m)) == 0)
        localSportDay2 = StatisticFragment.j(this.m);
      if (!localSportDay1.before(StatisticFragment.g(this.m)))
        break label459;
      localSportDay1 = StatisticFragment.g(this.m);
    }
    while (true)
    {
      String str4 = this.g;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(1 + localSportDay1.mon);
      arrayOfObject1[1] = Integer.valueOf(localSportDay1.day);
      String str5 = String.format(str4, arrayOfObject1);
      String str6 = this.g;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(1 + localSportDay2.mon);
      arrayOfObject2[1] = Integer.valueOf(localSportDay2.day);
      String str7 = String.format(str6, arrayOfObject2);
      localShareData.time = String.format(this.h, new Object[] { str5, str7 });
      return localShareData;
      localSimpleDateFormat.applyPattern(this.k);
      localDate.setMonth(paramSportDay.mon);
      str1 = localSimpleDateFormat.format(localDate);
      break;
      label316: if (paramInt != 1)
        break label100;
      localShareData.setType(6);
      String str2 = StatisticFragment.b(this.m).formatStringDay(this.m.getActivity());
      String str3 = Utils.getMonthShareTips(this.m.getActivity(), this.a, this.b, this.c, str2, StatisticFragment.c(this.m));
      localShareData.title = (str1 + ", " + this.m.getString(2131493242));
      localShareData.content = this.a;
      localShareData.description = str3;
      localShareData.contentUnit = this.m.getString(2131492927);
      break label100;
      label459: if (localSportDay2.after(StatisticFragment.n(this.m)))
        localSportDay2 = StatisticFragment.n(this.m);
    }
  }

  protected final String a(SportDay paramSportDay)
  {
    if (paramSportDay.offsetMonth(StatisticFragment.j(this.m)) == 0)
      return this.i;
    if (paramSportDay.offsetMonth(StatisticFragment.j(this.m)) == -1)
      return this.j;
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (1 + paramSportDay.mon == 1)
    {
      localDate.setYear(paramSportDay.year);
      localDate.setMonth(paramSportDay.mon);
      localSimpleDateFormat.applyPattern(this.l);
      return localSimpleDateFormat.format(localDate);
    }
    localDate.setMonth(paramSportDay.mon);
    localSimpleDateFormat.applyPattern(this.k);
    return localSimpleDateFormat.format(localDate);
  }

  protected final String b(SportDay paramSportDay)
  {
    return a(paramSportDay);
  }

  protected final boolean b(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < StatisticFragment.g(this.m).offsetMonth(StatisticFragment.e(this.m))))
    {
      Debug.w("Statistic.Main", "Has data False : " + paramInt);
      return false;
    }
    return true;
  }

  protected final void c(int paramInt)
  {
    SportDay localSportDay1 = StatisticFragment.e(this.m).addMonth(paramInt);
    SportDay localSportDay2 = localSportDay1.getMonthStartDay();
    SportDay localSportDay3 = localSportDay1.getMonthEndDay();
    Debug.i("Statistic.Main", localSportDay2 + "~" + localSportDay3);
    Debug.i("Statistic.Main", "To Month : " + a(localSportDay1));
    StatisticFragment.b(this.m, paramInt);
    if (StatisticFragment.l(this.m) == 2147483647)
      StatisticFragment.c(this.m, paramInt);
    if (StatisticFragment.l(this.m) == paramInt)
    {
      StatisticFragment.b(this.m, StatisticFragment.m(this.m));
      StatisticFragment.c(this.m, localSportDay1);
      a();
    }
    for (int n = 0; ; n++)
    {
      if (n >= localSportDay3.day)
      {
        a((View)StatisticFragment.h(this.m).get(256));
        b((View)StatisticFragment.i(this.m).get(256));
        return;
        StatisticFragment.b(this.m, localSportDay2);
        if (!StatisticFragment.d(this.m).before(StatisticFragment.g(this.m)))
          break;
        StatisticFragment.b(this.m, StatisticFragment.g(this.m));
        break;
      }
      SportDay localSportDay4 = localSportDay2.addDay(n);
      Debug.i("Statistic.Main", "Load Day : " + localSportDay4);
      c(localSportDay4);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bO
 * JD-Core Version:    0.6.2
 */