package android.support.v4.app;

import android.os.Build.VERSION;

public class NotificationCompat
{
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  private static final Q a = new R();

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new U();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new T();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new S();
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.6.2
 */