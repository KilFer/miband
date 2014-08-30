package kankan.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract interface WheelViewAdapter
{
  public abstract int getBASE_BUNDLE();

  public abstract View getEmptyItem(View paramView, ViewGroup paramViewGroup);

  public abstract int getInitLoopBase();

  public abstract View getItem(int paramInt, View paramView, ViewGroup paramViewGroup);

  public abstract int getItemsCount();

  public abstract boolean isNeedLoop();

  public abstract void registerDataSetObserver(DataSetObserver paramDataSetObserver);

  public abstract void unregisterDataSetObserver(DataSetObserver paramDataSetObserver);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.WheelViewAdapter
 * JD-Core Version:    0.6.2
 */