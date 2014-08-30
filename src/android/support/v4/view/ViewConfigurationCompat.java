package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat
{
  private static aq a = new ao();

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new ap();
      return;
    }
  }

  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.6.2
 */