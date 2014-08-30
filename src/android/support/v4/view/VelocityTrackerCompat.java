package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class VelocityTrackerCompat
{
  private static Y a = new W();

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new X();
      return;
    }
  }

  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.a(paramVelocityTracker, paramInt);
  }

  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.b(paramVelocityTracker, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.VelocityTrackerCompat
 * JD-Core Version:    0.6.2
 */