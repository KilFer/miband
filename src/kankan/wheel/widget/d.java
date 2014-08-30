package kankan.wheel.widget;

import android.database.DataSetObserver;

final class d extends DataSetObserver
{
  d(WheelView paramWheelView)
  {
  }

  public final void onChanged()
  {
    this.a.invalidateWheel(false);
  }

  public final void onInvalidated()
  {
    this.a.invalidateWheel(true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.d
 * JD-Core Version:    0.6.2
 */