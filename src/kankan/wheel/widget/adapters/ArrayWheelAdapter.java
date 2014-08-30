package kankan.wheel.widget.adapters;

import android.content.Context;

public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter
{
  private T[] a;

  public ArrayWheelAdapter(Context paramContext, T[] paramArrayOfT)
  {
    super(paramContext);
    this.a = paramArrayOfT;
  }

  public int getBASE_BUNDLE()
  {
    return 0;
  }

  public int getInitLoopBase()
  {
    return 0;
  }

  public CharSequence getItemText(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.length))
    {
      Object localObject = this.a[paramInt];
      if ((localObject instanceof CharSequence))
        return (CharSequence)localObject;
      return localObject.toString();
    }
    return null;
  }

  public int getItemsCount()
  {
    return this.a.length;
  }

  public boolean isNeedLoop()
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.ArrayWheelAdapter
 * JD-Core Version:    0.6.2
 */