package cn.com.smartdevices.bracelet.chart.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncChartDataLoader extends ChartDataLoader
{
  private Executor a = Executors.newSingleThreadExecutor();
  private ArrayList<a> b = new ArrayList();

  public void cancel()
  {
    Iterator localIterator;
    if (!this.b.isEmpty())
      localIterator = this.b.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.b.clear();
        return;
      }
      a locala = (a)localIterator.next();
      if (!locala.isCancelled())
        locala.cancel(false);
    }
  }

  public boolean isCancelled()
  {
    Iterator localIterator;
    if (!this.b.isEmpty())
      localIterator = this.b.iterator();
    do
      if (!localIterator.hasNext())
        return false;
    while (!((a)localIterator.next()).isCancelled());
    return true;
  }

  public void loadItemData(int paramInt)
  {
    a locala = new a(this, (byte)0);
    Executor localExecutor = this.a;
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(paramInt);
    locala.executeOnExecutor(localExecutor, arrayOfInteger);
    this.b.add(locala);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader
 * JD-Core Version:    0.6.2
 */