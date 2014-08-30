package kankan.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWheelAdapter
  implements WheelViewAdapter
{
  private List<DataSetObserver> a;

  public View getEmptyItem(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  protected void notifyDataChangedEvent()
  {
    Iterator localIterator;
    if (this.a != null)
      localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((DataSetObserver)localIterator.next()).onChanged();
    }
  }

  protected void notifyDataInvalidatedEvent()
  {
    Iterator localIterator;
    if (this.a != null)
      localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((DataSetObserver)localIterator.next()).onInvalidated();
    }
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null)
      this.a = new LinkedList();
    this.a.add(paramDataSetObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null)
      this.a.remove(paramDataSetObserver);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.AbstractWheelAdapter
 * JD-Core Version:    0.6.2
 */