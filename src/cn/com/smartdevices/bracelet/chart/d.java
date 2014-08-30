package cn.com.smartdevices.bracelet.chart;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.Iterator;
import java.util.List;

final class d extends b
{
  private float a;
  private int b = 10;

  private d(DynamicDetailChart paramDynamicDetailChart)
  {
    super(paramDynamicDetailChart, (byte)0);
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
    return ChartUtil.itemLevelSize(this.mMaxItemValue, paramBarItem.value, this.a, this.b);
  }

  protected final float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return (paramRectF.width() - this.mPaddingLeft - this.mPaddingRight) / (1 + (DynamicDetailChart.b(this.c) - DynamicDetailChart.a(this.c))) * (paramBarItem.index - DynamicDetailChart.a(this.c)) + this.mPaddingLeft + ((a)DynamicDetailChart.f(this.c)).b();
  }

  protected final float itemOffsetY(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return 0.0F;
  }

  protected final float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return (paramRectF.width() - this.mPaddingLeft - this.mPaddingRight) / (1 + (DynamicDetailChart.b(this.c) - DynamicDetailChart.a(this.c))) - 2.0F * this.mItemPadding;
  }

  protected final void onItemsChanged(List<BarChart.BarItem> paramList)
  {
    super.onItemsChanged(paramList);
    this.mMaxItemValue = ChartUtil.updateMaxItemValue(paramList, 0, 1500);
    if (this.mRect != null)
    {
      float f = this.mRect.height() - this.mPaddingTop - this.mPaddingBottom;
      this.a = ChartUtil.updateLevelSize(this.mMaxItemValue, f, this.b);
    }
    DynamicDetailChart.a(this.c, 2147483647);
    DynamicDetailChart.b(this.c, 0);
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (paramList.size() == 0)
        {
          DynamicDetailChart.a(this.c, 0);
          DynamicDetailChart.b(this.c, 0);
        }
        DynamicDetailChart.c(this.c, 60 * DynamicDetailChart.a(this.c));
        DynamicDetailChart.d(this.c, 60 * DynamicDetailChart.b(this.c));
        this.c.justifyStartEndTimeIndex(8);
        return;
      }
      BarChart.BarItem localBarItem = (BarChart.BarItem)localIterator.next();
      Debug.i("Chart.DynamicDetailChart", "Step Item : " + localBarItem);
      if (localBarItem.index < DynamicDetailChart.a(this.c))
        DynamicDetailChart.a(this.c, localBarItem.index);
      if (localBarItem.index > DynamicDetailChart.b(this.c))
        DynamicDetailChart.b(this.c, localBarItem.index);
    }
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
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.d
 * JD-Core Version:    0.6.2
 */