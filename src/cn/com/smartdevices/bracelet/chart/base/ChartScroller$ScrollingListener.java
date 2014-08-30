package cn.com.smartdevices.bracelet.chart.base;

public abstract interface ChartScroller$ScrollingListener
{
  public abstract void onFinish();

  public abstract void onJustify();

  public abstract boolean onScrollX(int paramInt);

  public abstract boolean onScrollY(int paramInt);

  public abstract void onStart();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener
 * JD-Core Version:    0.6.2
 */