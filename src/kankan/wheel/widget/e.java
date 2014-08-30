package kankan.wheel.widget;

import cn.com.smartdevices.bracelet.Debug;

final class e
  implements OnWheelChangedListener
{
  e(WheelView paramWheelView)
  {
  }

  public final void onChanged(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    Debug.i("WheelView", "newValue=" + paramInt2);
    this.a.invalidateWheel(true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.e
 * JD-Core Version:    0.6.2
 */