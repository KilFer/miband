package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.Iterator;
import java.util.List;

class b extends BarChart
{
  private b(DynamicDetailChartOld paramDynamicDetailChartOld)
  {
  }

  public void notifyChanged()
  {
    this.mNeedRealign = true;
    super.notifyChanged();
  }

  protected void realignItems(RectF paramRectF, List<? extends BarChart.BarItem> paramList)
  {
    if ((paramRectF == null) || (paramList == null) || (paramList.size() == 0))
      return;
    Iterator localIterator = paramList.iterator();
    if (!localIterator.hasNext())
    {
      this.mNeedRealign = false;
      return;
    }
    BarChart.BarItem localBarItem = (BarChart.BarItem)localIterator.next();
    RectF localRectF2;
    label79: float f3;
    float f4;
    label120: DynamicDetailChartOld.DynamicDetailBarItem localDynamicDetailBarItem;
    if (localBarItem.getRect() == null)
    {
      RectF localRectF1 = new RectF();
      localBarItem.setRect(localRectF1);
      localRectF2 = localRectF1;
      if ((!this.mNeedRealign) && (localBarItem.getRect() != null))
        break label354;
      float f1 = itemWidth(paramRectF, localBarItem);
      float f2 = itemHeight(paramRectF, localBarItem);
      f3 = f1;
      f4 = f2;
      localRectF2.top = (paramRectF.top + this.mItemPadding + this.mPaddingTop);
      localRectF2.bottom = (f4 + localRectF2.top);
      if (this.mMirrored)
        break label385;
      paramRectF.left += this.mPaddingLeft;
      localRectF2.right = (f3 + localRectF2.left);
      label186: if (!(this instanceof c))
      {
        localDynamicDetailBarItem = (DynamicDetailChartOld.DynamicDetailBarItem)localBarItem;
        localDynamicDetailBarItem.a = true;
        int i = DynamicDetailChartOld.b(this.a) / 60;
        int j = DynamicDetailChartOld.b(this.a) % 60;
        if (DynamicDetailChartOld.b(this.a) < 0)
        {
          i--;
          j += 60;
        }
        if (localDynamicDetailBarItem.index != i)
          break label415;
        localRectF2.bottom = (localRectF2.top + f4 * (j / 60.0F) - 1.0F);
        localDynamicDetailBarItem.a = false;
      }
    }
    while (true)
    {
      localRectF2.offset(itemOffsetX(paramRectF, localBarItem), itemOffsetY(paramRectF, localBarItem));
      localBarItem.needDraw = true;
      if ((localRectF2.bottom >= paramRectF.top) && (localRectF2.top <= paramRectF.bottom))
        break;
      localBarItem.needDraw = false;
      break;
      localRectF2 = localBarItem.getRect();
      break label79;
      label354: float f5 = localBarItem.getRect().width();
      float f6 = localBarItem.getRect().height();
      f3 = f5;
      f4 = f6;
      break label120;
      label385: paramRectF.right -= this.mPaddingRight;
      localRectF2.left = (localRectF2.right - f3);
      break label186;
      label415: if (localDynamicDetailBarItem.index == DynamicDetailChartOld.c(this.a) / 60)
      {
        localRectF2.top = (1.0F + f4 * (DynamicDetailChartOld.c(this.a) % 60.0F / 60.0F));
        localDynamicDetailBarItem.a = false;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.b
 * JD-Core Version:    0.6.2
 */