package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Calendar;
import java.util.HashMap;

abstract class bM
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;

  private bM(StatisticFragment paramStatisticFragment)
  {
  }

  private static int a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i1 = localCalendar.get(11);
    return localCalendar.get(12) + i1 * 60;
  }

  protected static StatisticChartView.StatisticChartData a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    StatisticChartView.StatisticChartData localStatisticChartData = new StatisticChartView.StatisticChartData();
    if (paramInt4 > 0)
      localStatisticChartData.stepValue = (paramInt1 / paramInt4);
    if (paramInt5 > 0)
    {
      localStatisticChartData.sleepValue = (paramInt2 / paramInt5);
      localStatisticChartData.sleepDeepValue = (paramInt3 / paramInt5);
    }
    return localStatisticChartData;
  }

  private void a(DaySportData.Summary paramSummary)
  {
    this.a += paramSummary.getSteps();
    this.b += paramSummary.getStepDistance();
    this.c += paramSummary.getStepCalorie();
    this.d += paramSummary.getStepActiveTime();
    this.e += paramSummary.getStepWalkTime();
    this.f += paramSummary.getStepRunTime();
  }

  private void b(DaySportData.Summary paramSummary)
  {
    this.g += paramSummary.getSleep();
    this.h += paramSummary.getSleepDeepTime();
    this.i += paramSummary.getSleepShallowTime();
    int i1 = a(paramSummary.getSleepStartTime());
    int i2;
    int i3;
    if (i1 > 720)
    {
      i2 = i1 - 1440;
      this.j = (i2 + this.j);
      i3 = a(paramSummary.getSleepRiseTime());
      if (i3 < i1)
        break label135;
    }
    label135: for (int i4 = i3 - i1; ; i4 = i3 + (1440 - i1))
    {
      this.k = (i2 + i4 + this.k);
      this.l += paramSummary.getSleepWakeTime();
      return;
      i2 = i1;
      break;
    }
  }

  protected abstract StatisticChartView.StatisticChartData a(int paramInt);

  protected abstract ShareData a(SportDay paramSportDay, int paramInt);

  protected abstract String a(SportDay paramSportDay);

  protected final void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    StatisticFragment.a(this.o, null);
    StatisticFragment.a(this.o, 0);
  }

  protected final void a(int paramInt, ShareData paramShareData)
  {
    paramShareData.setType(2);
    int i1 = 2131493217;
    switch (paramInt)
    {
    default:
    case 1:
    case 16:
    case 256:
    }
    while (true)
    {
      paramShareData.content = (this.g / this.n);
      paramShareData.time = StatisticFragment.d(this.o).formatStringDay(this.o.getActivity());
      int i2 = this.h / this.n;
      int i3 = this.i / this.n;
      int i4 = this.j / this.n;
      if (i4 < 0)
        i4 += 1440;
      String str1 = ChartData.formatTime(i4);
      int i5 = this.k / this.n;
      if (i5 < 0)
        i5 += 1440;
      String str2 = ChartData.formatTime(i5);
      StatisticFragment localStatisticFragment = this.o;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = Integer.valueOf(i2 / 60);
      arrayOfObject[1] = Integer.valueOf(i2 % 60);
      arrayOfObject[2] = Integer.valueOf(i3 / 60);
      arrayOfObject[3] = Integer.valueOf(i3 % 60);
      arrayOfObject[4] = str1;
      arrayOfObject[5] = str2;
      paramShareData.description = localStatisticFragment.getString(i1, arrayOfObject);
      return;
      paramShareData.setType(2);
      continue;
      paramShareData.setType(3);
      i1 = 2131493218;
      continue;
      paramShareData.setType(4);
      i1 = 2131493218;
    }
  }

  protected final void a(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165360);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165361);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165362);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165365);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165368);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165369);
    if (this.n == 0)
      this.n = 1;
    localTextView1.setText(ChartData.formatTimeLength(this.o.getActivity(), this.g / this.n, 14));
    localTextView2.setText(ChartData.formatTimeLength(this.o.getActivity(), this.h / this.n, 14));
    localTextView3.setText(ChartData.formatTimeLength(this.o.getActivity(), this.i / this.n, 14));
    int i1 = this.j / this.n;
    if (i1 < 0)
      i1 += 1440;
    localTextView4.setText(ChartData.formatTime(i1));
    int i2 = this.k / this.n;
    if (i2 < 0)
      i2 += 1440;
    localTextView5.setText(ChartData.formatTime(i2));
    localTextView6.setText(ChartData.formatTimeLength(this.o.getActivity(), this.l / this.n, 14));
  }

  protected abstract String b(SportDay paramSportDay);

  protected void b(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165371);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165372);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165358);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165373);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165375);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165376);
    TextView localTextView7 = (TextView)paramView.findViewById(2131165377);
    TextView localTextView8 = (TextView)paramView.findViewById(2131165509);
    TextView localTextView9 = (TextView)paramView.findViewById(2131165510);
    TextView localTextView10 = (TextView)paramView.findViewById(2131165511);
    TextView localTextView11 = (TextView)paramView.findViewById(2131165512);
    TextView localTextView12 = (TextView)paramView.findViewById(2131165514);
    TextView localTextView13 = (TextView)paramView.findViewById(2131165515);
    TextView localTextView14 = (TextView)paramView.findViewById(2131165516);
    localTextView1.setText(String.valueOf(this.a));
    String[] arrayOfString1 = ChartData.formatDistance(this.o.getActivity(), this.b);
    localTextView2.setText(arrayOfString1[0]);
    localTextView3.setText(arrayOfString1[1]);
    localTextView4.setText(String.valueOf(this.c));
    localTextView5.setText(ChartData.formatTimeLength(this.o.getActivity(), this.d, 14));
    localTextView6.setText(ChartData.formatTimeLength(this.o.getActivity(), this.e, 14));
    localTextView7.setText(ChartData.formatTimeLength(this.o.getActivity(), this.f, 14));
    if (this.m == 0)
      this.m = 1;
    localTextView8.setText(String.valueOf(this.a / this.m));
    String[] arrayOfString2 = ChartData.formatDistance(this.o.getActivity(), this.b / this.m);
    localTextView9.setText(arrayOfString2[0]);
    localTextView10.setText(arrayOfString2[1]);
    localTextView11.setText(String.valueOf(this.c / this.m));
    localTextView12.setText(ChartData.formatTimeLength(this.o.getActivity(), this.d / this.m, 14));
    localTextView13.setText(ChartData.formatTimeLength(this.o.getActivity(), this.e / this.m, 14));
    localTextView14.setText(ChartData.formatTimeLength(this.o.getActivity(), this.f / this.m, 14));
  }

  protected abstract boolean b(int paramInt);

  protected abstract void c(int paramInt);

  protected final void c(SportDay paramSportDay)
  {
    DaySportData.Summary localSummary = (DaySportData.Summary)StatisticFragment.a(this.o).get(paramSportDay.getKey());
    int i1;
    int i2;
    int i3;
    int i4;
    if ((localSummary != null) && (!localSummary.isEmpty()))
    {
      if (localSummary.getSteps() > 0)
      {
        this.a += localSummary.getSteps();
        this.b += localSummary.getStepDistance();
        this.c += localSummary.getStepCalorie();
        this.d += localSummary.getStepActiveTime();
        this.e += localSummary.getStepWalkTime();
        this.f += localSummary.getStepRunTime();
        this.m = (1 + this.m);
      }
      if (localSummary.getSleep() > 0)
      {
        this.g += localSummary.getSleep();
        this.h += localSummary.getSleepDeepTime();
        this.i += localSummary.getSleepShallowTime();
        i1 = a(localSummary.getSleepStartTime());
        if (i1 <= 720)
          break label323;
        i2 = i1 - 1440;
        this.j = (i2 + this.j);
        i3 = a(localSummary.getSleepRiseTime());
        if (i3 < i1)
          break label329;
        i4 = i3 - i1;
        label252: this.k = (i2 + i4 + this.k);
        this.l += localSummary.getSleepWakeTime();
        this.n = (1 + this.n);
      }
      if (StatisticFragment.b(this.o) != null)
        break label342;
      StatisticFragment.a(this.o, paramSportDay);
      StatisticFragment.a(this.o, localSummary.getSteps());
    }
    label323: label329: label342: 
    while (StatisticFragment.c(this.o) >= localSummary.getSteps())
    {
      return;
      i2 = i1;
      break;
      i4 = i3 + (1440 - i1);
      break label252;
    }
    StatisticFragment.a(this.o, localSummary.getSteps());
    StatisticFragment.a(this.o, paramSportDay);
    Debug.i("Statistic.Main", "find a bigger steps: " + StatisticFragment.c(this.o));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bM
 * JD-Core Version:    0.6.2
 */