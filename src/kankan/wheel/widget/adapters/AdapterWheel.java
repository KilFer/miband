package kankan.wheel.widget.adapters;

import android.content.Context;
import kankan.wheel.widget.WheelAdapter;

public class AdapterWheel extends AbstractWheelTextAdapter
{
  private WheelAdapter a;

  public AdapterWheel(Context paramContext, WheelAdapter paramWheelAdapter)
  {
    super(paramContext);
    this.a = paramWheelAdapter;
  }

  public WheelAdapter getAdapter()
  {
    return this.a;
  }

  public int getBASE_BUNDLE()
  {
    return 0;
  }

  public int getInitLoopBase()
  {
    return 0;
  }

  protected CharSequence getItemText(int paramInt)
  {
    return this.a.getItem(paramInt);
  }

  public int getItemsCount()
  {
    return this.a.getItemsCount();
  }

  public boolean isNeedLoop()
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.AdapterWheel
 * JD-Core Version:    0.6.2
 */