package android.support.v4.app;

import android.app.Notification;

final class R
  implements Q
{
  public final Notification a(NotificationCompat.Builder paramBuilder)
  {
    Notification localNotification = paramBuilder.r;
    localNotification.setLatestEventInfo(paramBuilder.a, paramBuilder.b, paramBuilder.c, paramBuilder.d);
    if (paramBuilder.j > 0)
      localNotification.flags = (0x80 | localNotification.flags);
    return localNotification;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.R
 * JD-Core Version:    0.6.2
 */