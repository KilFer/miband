package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

final class o extends n
{
  private float a;
  private int b = 10;

  private o(StatisticChart paramStatisticChart)
  {
    super(paramStatisticChart, (byte)0);
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
    return ChartUtil.itemLevelSize(this.mMaxItemValue, paramBarItem.value, this.a, this.b);
  }

  protected final void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    if (paramRectF != null)
    {
      float f = paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
      this.a = ChartUtil.updateLevelSize(this.mMaxItemValue, f, this.b);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.o
 * JD-Core Version:    0.6.2
 */