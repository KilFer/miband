package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseChart<T extends Chart.Item>
  implements Chart.Item, Chart
{
  protected Context mContext;
  protected float mDensity;
  protected float mDensityScale;
  protected List<T> mItems;
  protected ChartDataLoader.LoadCallback mLoadCallback;
  protected float mPaddingBottom;
  protected float mPaddingLeft;
  protected float mPaddingRight;
  protected float mPaddingTop;
  protected BaseChart<? extends Chart.Item> mParent;
  protected RectF mRect;
  protected Renderer mRenderer;
  protected float mScroll;

  public BaseChart()
  {
    this.mDensity = ChartUtil.getDensity();
    this.mDensityScale = ChartUtil.getDensityScale();
    this.mItems = new ArrayList();
  }

  public BaseChart(Context paramContext)
  {
    this.mDensity = ChartUtil.getDensity(paramContext);
    this.mDensityScale = ChartUtil.getDensityScale(paramContext);
    this.mContext = paramContext;
    this.mItems = new ArrayList();
  }

  public void addItem(T paramT)
  {
    synchronized (this.mItems)
    {
      this.mItems.add(paramT);
      onItemsChanged(this.mItems);
      return;
    }
  }

  public void addItems(List<? extends T> paramList)
  {
    synchronized (this.mItems)
    {
      this.mItems.addAll(paramList);
      onItemsChanged(this.mItems);
      return;
    }
  }

  public void clearItems()
  {
    synchronized (this.mItems)
    {
      this.mItems.clear();
      onItemsChanged(this.mItems);
      return;
    }
  }

  protected void doScroll(float paramFloat)
  {
  }

  public void draw(Canvas paramCanvas)
  {
    draw(paramCanvas, 1.0F);
  }

  public void draw(Canvas paramCanvas, float paramFloat)
  {
    draw(paramCanvas, this.mRect, paramFloat);
  }

  protected void draw(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    draw(paramCanvas, this.mRect, paramFloat, paramBoolean);
  }

  protected abstract void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat);

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat, boolean paramBoolean)
  {
    draw(paramCanvas, paramRectF, paramFloat);
  }

  public void fillItems(List<? extends T> paramList)
  {
    synchronized (this.mItems)
    {
      this.mItems.clear();
      this.mItems.addAll(paramList);
      onItemsChanged(this.mItems);
      return;
    }
  }

  public Context getContext()
  {
    return this.mContext;
  }

  public List<T> getItems()
  {
    return this.mItems;
  }

  public float getPaddingBottom()
  {
    return this.mPaddingBottom;
  }

  public float getPaddingLeft()
  {
    return this.mPaddingLeft;
  }

  public float getPaddingRight()
  {
    return this.mPaddingRight;
  }

  public float getPaddingTop()
  {
    return this.mPaddingTop;
  }

  public BaseChart<? extends Chart.Item> getParent()
  {
    return this.mParent;
  }

  public RectF getRect()
  {
    return this.mRect;
  }

  public Renderer getRenderer()
  {
    return this.mRenderer;
  }

  public float getScroll()
  {
    return this.mScroll;
  }

  public void notifyChanged()
  {
  }

  protected void onItemsChanged(List<T> paramList)
  {
  }

  protected void onRectChanged(RectF paramRectF)
  {
  }

  public void scroll(float paramFloat)
  {
    this.mScroll = (paramFloat + this.mScroll);
    doScroll(paramFloat);
    notifyChanged();
  }

  public void scrollTo(float paramFloat)
  {
    float f = paramFloat - this.mScroll;
    this.mScroll = paramFloat;
    doScroll(f);
    notifyChanged();
  }

  public void setLoadCallback(ChartDataLoader.LoadCallback paramLoadCallback)
  {
    this.mLoadCallback = paramLoadCallback;
  }

  public void setPadding(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mPaddingLeft = paramFloat1;
    this.mPaddingTop = paramFloat2;
    this.mPaddingRight = paramFloat3;
    this.mPaddingBottom = paramFloat4;
    notifyChanged();
  }

  public void setParent(BaseChart<? extends Chart.Item> paramBaseChart)
  {
    this.mParent = paramBaseChart;
  }

  public void setRect(Rect paramRect)
  {
    this.mRect = new RectF(paramRect);
    onRectChanged(this.mRect);
    notifyChanged();
  }

  public void setRect(RectF paramRectF)
  {
    this.mRect = paramRectF;
    onRectChanged(this.mRect);
    notifyChanged();
  }

  public void setRenderer(Renderer paramRenderer)
  {
    this.mRenderer = paramRenderer;
  }

  public void sortItems()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BaseChart
 * JD-Core Version:    0.6.2
 */