package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;

public class DynamicShareChart extends BarChart
{
  private int a;

  public DynamicShareChart(Context paramContext)
  {
    super(paramContext);
    this.mXAxis = new j(this);
    this.mXAxis.stroke = ((int)(9.0F * this.mDensity));
    this.mMaxItemValue = 10000;
    this.mItemPadding = ((int)(2.0F * this.mDensity));
    setPadding(0.0F, 0.0F, 0.0F, this.mXAxis.stroke);
    this.a = ((int)(7.0F * this.mDensity));
  }

  public int getTotalHours()
  {
    return 18;
  }

  protected float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
    return this.a + paramBarItem.value / this.mMaxItemValue * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - this.a);
  }

  protected float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    j localj = (j)this.mXAxis;
    return localj.a * (((DynamicShareChart.DynamicShareBarItem)paramBarItem).index - localj.offset);
  }

  protected float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return paramRectF.width() / 18.0F - 2.0F * this.mItemPadding;
  }

  public void setOffsetHour(int paramInt)
  {
    ((j)this.mXAxis).offset = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicShareChart
 * JD-Core Version:    0.6.2
 */