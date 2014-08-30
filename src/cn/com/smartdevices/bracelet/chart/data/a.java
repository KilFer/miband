package cn.com.smartdevices.bracelet.chart.data;

import android.os.AsyncTask;
import android.util.SparseArray;
import java.util.ArrayList;

final class a extends AsyncTask<Integer, Void, ChartDataLoader.ItemData>
{
  private a(AsyncChartDataLoader paramAsyncChartDataLoader)
  {
  }

  private ChartDataLoader.ItemData a(Integer[] paramArrayOfInteger)
  {
    ChartDataLoader.ItemData localItemData = this.a.mCallback.loadData(paramArrayOfInteger[0].intValue());
    localItemData.index = paramArrayOfInteger[0].intValue();
    this.a.mItemsData.put(paramArrayOfInteger[0].intValue(), localItemData);
    return localItemData;
  }

  private void a(ChartDataLoader.ItemData paramItemData)
  {
    this.a.mCallback.onDataLoaded(paramItemData);
    AsyncChartDataLoader.a(this.a).remove(this);
  }

  protected final void onCancelled()
  {
    AsyncChartDataLoader.a(this.a).remove(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.data.a
 * JD-Core Version:    0.6.2
 */