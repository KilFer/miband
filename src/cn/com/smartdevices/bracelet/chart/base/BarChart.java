package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BarChart extends BaseChart<BarChart.BarItem>
{
  protected float mItemPadding;
  protected int mMaxItemValue;
  protected boolean mMirrored;
  protected boolean mNeedRealign;
  protected BarChart.Axis mXAxis;
  protected BarChart.Axis mYAxis;

  public BarChart()
  {
  }

  public BarChart(Context paramContext)
  {
    super(paramContext);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    synchronized (this.mItems)
    {
      int i = this.mItems.size();
      int j = 0;
      if (j >= i)
      {
        if (this.mXAxis != null)
          this.mXAxis.draw(paramCanvas, paramFloat);
        if (this.mYAxis != null)
          this.mYAxis.draw(paramCanvas, paramFloat);
        return;
      }
      ((BarChart.BarItem)this.mItems.get(j)).draw(paramCanvas, paramFloat, this.mMirrored);
      j++;
    }
  }

  public int getMaxItemValue()
  {
    return this.mMaxItemValue;
  }

  protected float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
    return paramBarItem.value / this.mMaxItemValue * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom);
  }

  protected float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return paramRectF.width() / this.mItems.size() * this.mItems.indexOf(paramBarItem);
  }

  protected float itemOffsetY(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return 0.0F;
  }

  protected float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return paramRectF.width() / this.mItems.size() - 2.0F * this.mItemPadding;
  }

  public void notifyChanged()
  {
    synchronized (this.mItems)
    {
      realignItems(this.mRect, this.mItems);
      return;
    }
  }

  protected void onItemsChanged(List<BarChart.BarItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.mNeedRealign = true;
        return;
      }
      BarChart.BarItem localBarItem = (BarChart.BarItem)localIterator.next();
      localBarItem.mDensity = this.mDensity;
      localBarItem.mDensityScale = this.mDensityScale;
    }
  }

  protected void onRectChanged(RectF paramRectF)
  {
    if (this.mXAxis != null)
    {
      RectF localRectF1 = new RectF();
      localRectF1.left = paramRectF.left;
      localRectF1.top = (paramRectF.bottom - this.mXAxis.stroke);
      localRectF1.right = paramRectF.right;
      localRectF1.bottom = paramRectF.bottom;
      this.mXAxis.setRect(localRectF1);
    }
    if (this.mYAxis != null)
    {
      RectF localRectF2 = new RectF();
      localRectF2.left = paramRectF.left;
      localRectF2.top = paramRectF.top;
      localRectF2.right = (paramRectF.left + this.mYAxis.stroke);
      localRectF2.bottom = paramRectF.bottom;
      this.mYAxis.setRect(localRectF2);
    }
    this.mNeedRealign = true;
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
    RectF localRectF;
    label75: float f1;
    float f2;
    if (localBarItem.mRect == null)
    {
      localRectF = new RectF();
      localBarItem.mRect = localRectF;
      if ((!this.mNeedRealign) && (localBarItem.mRect != null))
        break label249;
      f1 = itemWidth(paramRectF, localBarItem);
      f2 = itemHeight(paramRectF, localBarItem);
      label108: paramRectF.left += this.mItemPadding;
      localRectF.right = (f1 + localRectF.left);
      if (this.mMirrored)
        break label272;
      paramRectF.bottom -= this.mPaddingBottom;
      localRectF.top = (localRectF.bottom - f2);
    }
    while (true)
    {
      localRectF.offset(itemOffsetX(paramRectF, localBarItem), itemOffsetY(paramRectF, localBarItem));
      localBarItem.needDraw = true;
      if ((localRectF.right >= paramRectF.left + this.mPaddingLeft) && (localRectF.left <= paramRectF.right - this.mPaddingRight))
        break;
      localBarItem.needDraw = false;
      break;
      localRectF = localBarItem.mRect;
      break label75;
      label249: f1 = localBarItem.mRect.width();
      f2 = localBarItem.mRect.height();
      break label108;
      label272: paramRectF.top += this.mPaddingTop;
      localRectF.bottom = (f2 + localRectF.top);
    }
  }

  public void setItemPadding(float paramFloat)
  {
    this.mItemPadding = paramFloat;
  }

  public void setMaxItemValue(int paramInt)
  {
    this.mMaxItemValue = paramInt;
  }

  public void setNeedRealign(boolean paramBoolean)
  {
    this.mNeedRealign = paramBoolean;
  }

  public void sortItems()
  {
    synchronized (this.mItems)
    {
      Collections.sort(this.mItems, new BarChart.BarItemComparator());
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BarChart
 * JD-Core Version:    0.6.2
 */