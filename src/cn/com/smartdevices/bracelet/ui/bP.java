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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

final class bP extends bM
{
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;

  public bP(StatisticFragment paramStatisticFragment)
  {
    super(paramStatisticFragment, (byte)0);
    this.g = paramStatisticFragment.getString(2131492889);
    this.h = paramStatisticFragment.getString(2131492890);
    this.i = paramStatisticFragment.getString(2131492893);
    this.j = paramStatisticFragment.getString(2131492894);
    this.k = paramStatisticFragment.getString(2131492895);
    this.l = paramStatisticFragment.getString(2131492896);
    this.m = paramStatisticFragment.getString(2131492897);
  }

  protected final StatisticChartView.StatisticChartData a(int paramInt)
  {
    SportDay localSportDay1 = StatisticFragment.e(this.n).addWeek(paramInt);
    Debug.i("Statistic.Main", "Load Week : " + a(localSportDay1));
    SportDay localSportDay2 = localSportDay1.getWeekStartDay();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    if (i1 >= 7)
    {
      StatisticChartView.StatisticChartData localStatisticChartData = a(i6, i5, i4, i3, i2);
      localStatisticChartData.date = b(localSportDay1);
      return localStatisticChartData;
    }
    SportDay localSportDay3 = localSportDay2.addDay(i1);
    Debug.i("Statistic.Main", "Load Day : " + localSportDay3);
    String str = localSportDay3.getKey();
    DaySportData.Summary localSummary1;
    label180: int i13;
    int i14;
    label217: int i8;
    int i7;
    int i11;
    int i10;
    if (!StatisticFragment.a(this.n).containsKey(str))
    {
      DaySportData.Summary localSummary2 = StatisticFragment.f(this.n).getSummary(localSportDay3);
      StatisticFragment.a(this.n).put(str, localSummary2);
      localSummary1 = localSummary2;
      if (localSummary1 == null)
        break label361;
      if (localSummary1.getSteps() <= 0)
        break label350;
      int i19 = i6 + localSummary1.getSteps();
      i13 = i3 + 1;
      i14 = i19;
      if (localSummary1.getSleep() <= 0)
        break label327;
      int i15 = i5 + localSummary1.getSleep();
      int i16 = i4 + localSummary1.getSleepDeepTime();
      int i17 = i2 + 1;
      i8 = i15;
      int i18 = i13;
      i7 = i17;
      i11 = i16;
      i10 = i14;
      i3 = i18;
    }
    while (true)
    {
      i1++;
      i5 = i8;
      i2 = i7;
      int i12 = i11;
      i6 = i10;
      i4 = i12;
      break;
      localSummary1 = (DaySportData.Summary)StatisticFragment.a(this.n).get(str);
      break label180;
      label327: i11 = i4;
      i10 = i14;
      i3 = i13;
      i7 = i2;
      i8 = i5;
      continue;
      label350: i13 = i3;
      i14 = i6;
      break label217;
      label361: i7 = i2;
      i8 = i5;
      int i9 = i4;
      i10 = i6;
      i11 = i9;
    }
  }

  protected final ShareData a(SportDay paramSportDay, int paramInt)
  {
    ShareData localShareData = new ShareData();
    SportDay localSportDay1;
    SportDay localSportDay2;
    if (paramInt == 16)
    {
      a(StatisticFragment.k(this.n), localShareData);
      String str7 = this.n.getString(2131493189);
      if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == 0)
        str7 = this.g + ", ";
      localShareData.title = (str7 + this.n.getString(2131493202));
      localSportDay1 = paramSportDay.getWeekStartDay();
      localSportDay2 = localSportDay1.addDay(6);
      if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == 0)
        localSportDay2 = StatisticFragment.j(this.n);
      if (!localSportDay1.before(StatisticFragment.g(this.n)))
        break label474;
      localSportDay1 = StatisticFragment.g(this.n);
    }
    while (true)
    {
      String str3 = this.m;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(1 + localSportDay1.mon);
      arrayOfObject1[1] = Integer.valueOf(localSportDay1.day);
      String str4 = String.format(str3, arrayOfObject1);
      String str5 = this.m;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(1 + localSportDay2.mon);
      arrayOfObject2[1] = Integer.valueOf(localSportDay2.day);
      String str6 = String.format(str5, arrayOfObject2);
      localShareData.time = String.format(this.j, new Object[] { str4, str6 });
      return localShareData;
      if (paramInt != 1)
        break;
      localShareData.setType(7);
      String str1 = this.n.getString(2131493243);
      if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == 0)
        str1 = this.g + ", ";
      localShareData.title = (str1 + this.n.getString(2131493242));
      localShareData.content = this.a;
      String str2 = this.n.getResources().getStringArray(2131558400)[StatisticFragment.b(this.n).getWeek()];
      localShareData.description = Utils.getWeekShareTips(this.n.getActivity(), this.b, this.c, str2, StatisticFragment.c(this.n));
      localShareData.contentUnit = this.n.getString(2131492927);
      break;
      label474: if (localSportDay2.after(StatisticFragment.n(this.n)))
        localSportDay2 = StatisticFragment.n(this.n);
    }
  }

  protected final String a(SportDay paramSportDay)
  {
    if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == 0)
      return this.g;
    if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == -1)
      return this.h;
    SportDay localSportDay1 = paramSportDay.getWeekStartDay();
    SportDay localSportDay2 = localSportDay1.addDay(6);
    Date localDate;
    SimpleDateFormat localSimpleDateFormat1;
    SimpleDateFormat localSimpleDateFormat2;
    String str1;
    if (localSportDay1.before(StatisticFragment.g(this.n)))
    {
      localSportDay1 = StatisticFragment.g(this.n);
      localDate = new Date();
      localSimpleDateFormat1 = new SimpleDateFormat(this.k);
      localSimpleDateFormat2 = new SimpleDateFormat(this.l);
      if ((1 + localSportDay1.mon != 1) || (localSportDay1.calendar.get(3) != 1))
        break label279;
      localDate.setYear(-1900 + localSportDay1.year);
      localDate.setMonth(localSportDay1.mon);
      localDate.setDate(localSportDay1.day);
      str1 = localSimpleDateFormat2.format(localDate);
      label170: if ((1 + localSportDay2.mon != 1) || (localSportDay2.calendar.get(3) != 1))
        break label309;
      localDate.setYear(-1900 + localSportDay2.year);
      localDate.setMonth(localSportDay2.mon);
      localDate.setDate(localSportDay2.day);
    }
    for (String str2 = localSimpleDateFormat2.format(localDate); ; str2 = localSimpleDateFormat1.format(localDate))
    {
      return String.format(this.i, new Object[] { str1, str2 });
      if (!localSportDay2.after(StatisticFragment.n(this.n)))
        break;
      localSportDay2 = StatisticFragment.n(this.n);
      break;
      label279: localDate.setMonth(localSportDay1.mon);
      localDate.setDate(localSportDay1.day);
      str1 = localSimpleDateFormat1.format(localDate);
      break label170;
      label309: localDate.setMonth(localSportDay2.mon);
      localDate.setDate(localSportDay2.day);
    }
  }

  protected final String b(SportDay paramSportDay)
  {
    if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == 0)
      return this.g;
    if (paramSportDay.offsetWeek(StatisticFragment.j(this.n)) == -1)
      return this.h;
    SportDay localSportDay1 = paramSportDay.getWeekStartDay();
    SportDay localSportDay2 = localSportDay1.addDay(6);
    if (localSportDay1.before(StatisticFragment.g(this.n)))
      localSportDay1 = StatisticFragment.g(this.n);
    while (true)
    {
      String str1 = this.m;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(1 + localSportDay1.mon);
      arrayOfObject1[1] = Integer.valueOf(localSportDay1.day);
      String str2 = String.format(str1, arrayOfObject1);
      String str3 = this.m;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(1 + localSportDay2.mon);
      arrayOfObject2[1] = Integer.valueOf(localSportDay2.day);
      String str4 = String.format(str3, arrayOfObject2);
      return String.format(this.j, new Object[] { str2, str4 });
      if (localSportDay2.after(StatisticFragment.n(this.n)))
        localSportDay2 = StatisticFragment.n(this.n);
    }
  }

  protected final boolean b(int paramInt)
  {
    if ((paramInt > 0) || (paramInt < StatisticFragment.g(this.n).offsetWeek(StatisticFragment.e(this.n))))
    {
      Debug.w("Statistic.Main", "Has data False : " + paramInt);
      return false;
    }
    return true;
  }

  protected final void c(int paramInt)
  {
    SportDay localSportDay1 = StatisticFragment.e(this.n).addWeek(paramInt);
    SportDay localSportDay2 = localSportDay1.getWeekStartDay();
    Debug.i("Statistic.Main", "To Week : " + a(localSportDay1));
    StatisticFragment.b(this.n, paramInt);
    if (StatisticFragment.l(this.n) == 2147483647)
      StatisticFragment.c(this.n, paramInt);
    if (StatisticFragment.l(this.n) == paramInt)
    {
      StatisticFragment.b(this.n, StatisticFragment.m(this.n));
      StatisticFragment.c(this.n, localSportDay1);
      a();
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 7)
      {
        a((View)StatisticFragment.h(this.n).get(16));
        b((View)StatisticFragment.i(this.n).get(16));
        return;
        StatisticFragment.b(this.n, localSportDay2);
        if (!StatisticFragment.d(this.n).before(StatisticFragment.g(this.n)))
          break;
        StatisticFragment.b(this.n, StatisticFragment.g(this.n));
        break;
      }
      SportDay localSportDay3 = localSportDay2.addDay(i1);
      Debug.i("Statistic.Main", "Load Day : " + localSportDay3);
      c(localSportDay3);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bP
 * JD-Core Version:    0.6.2
 */