package cn.com.smartdevices.bracelet.chart.data;

import android.util.SparseArray;

public class ChartDataLoader
{
  protected ChartDataLoader.LoadCallback mCallback;
  protected boolean mIsCancelled;
  protected SparseArray<ChartDataLoader.ItemData> mItemsData = new SparseArray();

  public void cancel()
  {
    this.mIsCancelled = true;
  }

  public void clearData()
  {
    this.mItemsData.clear();
  }

  public ChartDataLoader.ItemData getItemData(int paramInt)
  {
    return (ChartDataLoader.ItemData)this.mItemsData.get(paramInt);
  }

  public ChartDataLoader.LoadCallback getLoadCallback()
  {
    return this.mCallback;
  }

  public boolean hasItemData(int paramInt)
  {
    return this.mCallback.hasData(paramInt);
  }

  public boolean isCancelled()
  {
    return this.mIsCancelled;
  }

  public void loadItemData(int paramInt)
  {
    this.mIsCancelled = false;
    ChartDataLoader.ItemData localItemData = this.mCallback.loadData(paramInt);
    localItemData.index = paramInt;
    this.mItemsData.put(paramInt, localItemData);
    if (!this.mIsCancelled)
      this.mCallback.onDataLoaded(localItemData);
  }

  public void onToItem(int paramInt)
  {
    this.mCallback.onToItem(paramInt);
  }

  public void putItemData(int paramInt, ChartDataLoader.ItemData paramItemData)
  {
    this.mItemsData.put(paramInt, paramItemData);
  }

  public void setLoadCallback(ChartDataLoader.LoadCallback paramLoadCallback)
  {
    this.mCallback = paramLoadCallback;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.data.ChartDataLoader
 * JD-Core Version:    0.6.2
 */