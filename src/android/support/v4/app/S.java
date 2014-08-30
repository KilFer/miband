package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

final class S
  implements Q
{
  public final Notification a(NotificationCompat.Builder paramBuilder)
  {
    Context localContext = paramBuilder.a;
    Notification localNotification = paramBuilder.r;
    CharSequence localCharSequence1 = paramBuilder.b;
    CharSequence localCharSequence2 = paramBuilder.c;
    CharSequence localCharSequence3 = paramBuilder.h;
    RemoteViews localRemoteViews = paramBuilder.f;
    int i = paramBuilder.i;
    PendingIntent localPendingIntent1 = paramBuilder.d;
    PendingIntent localPendingIntent2 = paramBuilder.e;
    Bitmap localBitmap = paramBuilder.g;
    Notification.Builder localBuilder1 = new Notification.Builder(localContext).setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, localRemoteViews).setSound(localNotification.sound, localNotification.audioStreamType).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
    boolean bool1;
    boolean bool2;
    label169: boolean bool3;
    label191: Notification.Builder localBuilder4;
    if ((0x2 & localNotification.flags) != 0)
    {
      bool1 = true;
      Notification.Builder localBuilder2 = localBuilder1.setOngoing(bool1);
      if ((0x8 & localNotification.flags) == 0)
        break label277;
      bool2 = true;
      Notification.Builder localBuilder3 = localBuilder2.setOnlyAlertOnce(bool2);
      if ((0x10 & localNotification.flags) == 0)
        break label283;
      bool3 = true;
      localBuilder4 = localBuilder3.setAutoCancel(bool3).setDefaults(localNotification.defaults).setContentTitle(localCharSequence1).setContentText(localCharSequence2).setContentInfo(localCharSequence3).setContentIntent(localPendingIntent1).setDeleteIntent(localNotification.deleteIntent);
      if ((0x80 & localNotification.flags) == 0)
        break label289;
    }
    label277: label283: label289: for (boolean bool4 = true; ; bool4 = false)
    {
      return localBuilder4.setFullScreenIntent(localPendingIntent2, bool4).setLargeIcon(localBitmap).setNumber(i).getNotification();
      bool1 = false;
      break;
      bool2 = false;
      break label169;
      bool3 = false;
      break label191;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.S
 * JD-Core Version:    0.6.2
 */