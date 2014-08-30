package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.List;

final class c extends b
{
  private c(DynamicDetailChart paramDynamicDetailChart)
  {
    super(paramDynamicDetailChart, (byte)0);
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    float f;
    if (paramBarItem.value == 3)
      f = 196.60001F * this.mDensity;
    int i;
    do
    {
      return f;
      if ((paramBarItem.value == 2) || (paramBarItem.value == 1))
        break;
      i = paramBarItem.value;
      f = 0.0F;
    }
    while (i != 4);
    return 160.0F * this.mDensity;
  }

  protected final float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if ((paramBarItem.index > DynamicDetailChart.e(this.a)) || (paramBarItem.index < DynamicDetailChart.d(this.a)) || (DynamicDetailChart.d(this.a) == DynamicDetailChart.e(this.a)))
      return 0.0F;
    return (paramRectF.width() - this.mPaddingLeft - this.mPaddingRight) / (1 + (DynamicDetailChart.e(this.a) - DynamicDetailChart.d(this.a))) * (paramBarItem.index - DynamicDetailChart.d(this.a)) + this.mPaddingLeft + ((a)DynamicDetailChart.f(this.a)).b();
  }

  protected final float itemOffsetY(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return 0.0F;
  }

  protected final float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    float f;
    if ((paramBarItem.index > DynamicDetailChart.e(this.a)) || (paramBarItem.index < DynamicDetailChart.d(this.a)) || (DynamicDetailChart.d(this.a) == DynamicDetailChart.e(this.a)))
      f = 0.0F;
    do
    {
      return f;
      f = (paramRectF.width() - this.mPaddingLeft - this.mPaddingRight) / (1 + (DynamicDetailChart.e(this.a) - DynamicDetailChart.d(this.a))) * paramBarItem.scope - 2.0F * this.mItemPadding;
    }
    while (f >= 1.0F * this.mDensity);
    return 1.0F * this.mDensity;
  }

  protected final void onItemsChanged(List<BarChart.BarItem> paramList)
  {
    if (DynamicDetailChart.d(this.a) == DynamicDetailChart.e(this.a))
      return;
    super.onItemsChanged(paramList);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.c
 * JD-Core Version:    0.6.2
 */