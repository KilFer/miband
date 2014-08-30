package android.support.v4.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class I
  implements AdapterView.OnItemClickListener
{
  I(ListFragment paramListFragment)
  {
  }

  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onListItemClick((ListView)paramAdapterView, paramView, paramInt, paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.I
 * JD-Core Version:    0.6.2
 */