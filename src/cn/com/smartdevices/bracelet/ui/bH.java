package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.graphics.RectF;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.StatisticChart.StatisticBarItem;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;

final class bH
  implements ChartDataLoader.LoadCallback
{
  bH(StatisticFragment paramStatisticFragment)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return StatisticFragment.o(this.a).b(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    return StatisticFragment.o(this.a).a(paramInt);
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
    if ((StatisticFragment.p(this.a) == null) || (!StatisticFragment.p(this.a).isAttached()))
      Debug.w("Statistic.Main", "Chart Already Detached From UI : onDataLoaded , " + StatisticFragment.p(this.a));
    Animator localAnimator;
    do
    {
      do
      {
        return;
        if (StatisticFragment.q(this.a))
        {
          AnimUtil.infoSwitch((ViewGroup)StatisticFragment.r(this.a), (ViewGroup)StatisticFragment.s(this.a));
          if (StatisticFragment.t(this.a))
          {
            StatisticFragment.a(this.a, StatisticFragment.a(this.a, StatisticFragment.p(this.a), StatisticFragment.u(this.a), (int)StatisticFragment.u(this.a).getBarItemWidth(), StatisticFragment.u(this.a).getWidth(), StatisticFragment.v(this.a), StatisticFragment.w(this.a), 450));
            StatisticFragment.A(this.a).start();
            return;
          }
          StatisticFragment.a(this.a, StatisticFragment.p(this.a).getBarItem(StatisticFragment.x(this.a), StatisticFragment.y(this.a)));
          if (StatisticFragment.z(this.a) != null)
          {
            StatisticFragment.d(this.a, (int)StatisticFragment.z(this.a).getRect().height());
            int i = StatisticFragment.z(this.a).value;
            int j = ((StatisticChart.StatisticBarItem)StatisticFragment.z(this.a)).value1;
            StatisticFragment.e(this.a, (int)(StatisticFragment.v(this.a) * (j / i)));
          }
          while (true)
          {
            Debug.i("Statistic.Main", "BarItem Height : " + StatisticFragment.v(this.a));
            StatisticFragment.a(this.a, StatisticFragment.b(this.a, StatisticFragment.p(this.a), StatisticFragment.u(this.a), StatisticFragment.p(this.a).getWidth(), (int)StatisticFragment.p(this.a).getBarItemWidth(), StatisticFragment.v(this.a), StatisticFragment.w(this.a), 450));
            break;
            StatisticFragment.d(this.a, 0);
            StatisticFragment.e(this.a, 0);
          }
        }
      }
      while (!StatisticFragment.B(this.a));
      StatisticFragment.a(this.a, false);
      AnimUtil.infoSwitch((ViewGroup)StatisticFragment.r(this.a), (ViewGroup)StatisticFragment.s(this.a));
      localAnimator = StatisticFragment.p(this.a).animRefresh();
    }
    while (localAnimator.isStarted());
    localAnimator.setDuration(500L);
    localAnimator.start();
  }

  public final void onToItem(int paramInt)
  {
    if ((StatisticFragment.p(this.a) == null) || (!StatisticFragment.p(this.a).isAttached()))
    {
      Debug.w("Statistic.Main", "Chart Already Detached From UI : onToItem , " + StatisticFragment.p(this.a));
      return;
    }
    StatisticFragment.o(this.a).c(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bH
 * JD-Core Version:    0.6.2
 */