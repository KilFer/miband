package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.Iterator;
import java.util.List;

final class d extends b
{
  private float a;
  private int b;
  private int c = 10;

  private d(DynamicDetailChartOld paramDynamicDetailChartOld)
  {
    super(paramDynamicDetailChartOld, (byte)0);
  }

  private float a(int paramInt)
  {
    if (paramInt <= 0)
      return 0.0F;
    return this.a * (paramInt * (this.c + (1 + (this.c - paramInt))) / 2.0F);
  }

  private void a()
  {
    this.mMaxItemValue = 1500;
    synchronized (this.mItems)
    {
      Iterator localIterator = this.mItems.iterator();
      BarChart.BarItem localBarItem;
      do
      {
        if (!localIterator.hasNext())
          return;
        localBarItem = (BarChart.BarItem)localIterator.next();
      }
      while ((((DynamicDetailChartOld.DynamicDetailBarItem)localBarItem).index < 0) || (localBarItem.value <= this.mMaxItemValue));
      this.mMaxItemValue = localBarItem.value;
    }
  }

  private void b()
  {
    if (this.mRect != null)
    {
      this.b = (this.mMaxItemValue / this.c);
      this.a = ((this.mRect.width() - this.mPaddingLeft - this.mPaddingRight) * (this.b * this.c / this.mMaxItemValue) / ((1 + this.c) * this.c / 2.0F));
    }
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    a locala = (a)DynamicDetailChartOld.d(this.d);
    return paramBarItem.scope / 24.0F * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - DynamicDetailChartOld.a(this.d) - locala.getPaddingBottom()) - 2.0F * this.mItemPadding;
  }

  protected final float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return 0.0F;
  }

  protected final float itemOffsetY(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    a locala = (a)DynamicDetailChartOld.d(this.d);
    return paramBarItem.index / 24.0F * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - DynamicDetailChartOld.a(this.d) - locala.getPaddingBottom()) + locala.b();
  }

  protected final float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.width() - this.mPaddingLeft - this.mPaddingRight;
    int i = (-1 + (paramBarItem.value + this.b)) / this.b;
    float f = (1 + (-1 + paramBarItem.value) % this.b) / this.b;
    return a(i - 1) + f * (a(i) - a(i - 1));
  }

  protected final void onItemsChanged(List<BarChart.BarItem> paramList)
  {
    super.onItemsChanged(paramList);
    this.mMaxItemValue = 1500;
    synchronized (this.mItems)
    {
      Iterator localIterator = this.mItems.iterator();
      BarChart.BarItem localBarItem;
      do
      {
        if (!localIterator.hasNext())
        {
          b();
          return;
        }
        localBarItem = (BarChart.BarItem)localIterator.next();
      }
      while ((((DynamicDetailChartOld.DynamicDetailBarItem)localBarItem).index < 0) || (localBarItem.value <= this.mMaxItemValue));
      this.mMaxItemValue = localBarItem.value;
    }
  }

  protected final void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.d
 * JD-Core Version:    0.6.2
 */