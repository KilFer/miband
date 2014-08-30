package cn.com.smartdevices.bracelet.chart.data;

public abstract interface ChartDataLoader$LoadCallback
{
  public abstract boolean hasData(int paramInt);

  public abstract ChartDataLoader.ItemData loadData(int paramInt);

  public abstract void onDataLoaded(ChartDataLoader.ItemData paramItemData);

  public abstract void onToItem(int paramInt);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback
 * JD-Core Version:    0.6.2
 */