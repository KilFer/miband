package kankan.wheel.widget.adapters;

import android.content.Context;

public class NumericWheelAdapter extends AbstractWheelTextAdapter
{
  public static final int DEFAULT_MAX_VALUE = 9;
  private static final int a;
  private int b;
  private int c;
  private String d;

  public NumericWheelAdapter(Context paramContext)
  {
    this(paramContext, 0, 9);
  }

  public NumericWheelAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, paramInt2, null);
  }

  public NumericWheelAdapter(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    super(paramContext);
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString;
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
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = paramInt + this.b;
      if (this.d != null)
      {
        String str = this.d;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i);
        return String.format(str, arrayOfObject);
      }
      return Integer.toString(i);
    }
    return null;
  }

  public int getItemsCount()
  {
    return 1 + (this.c - this.b);
  }

  public boolean isNeedLoop()
  {
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.adapters.NumericWheelAdapter
 * JD-Core Version:    0.6.2
 */