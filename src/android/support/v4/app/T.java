package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

final class T
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
    int j = paramBuilder.n;
    int k = paramBuilder.o;
    boolean bool1 = paramBuilder.p;
    Notification.Builder localBuilder1 = new Notification.Builder(localContext).setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, localRemoteViews).setSound(localNotification.sound, localNotification.audioStreamType).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
    boolean bool2;
    boolean bool3;
    label187: boolean bool4;
    label209: Notification.Builder localBuilder4;
    if ((0x2 & localNotification.flags) != 0)
    {
      bool2 = true;
      Notification.Builder localBuilder2 = localBuilder1.setOngoing(bool2);
      if ((0x8 & localNotification.flags) == 0)
        break label304;
      bool3 = true;
      Notification.Builder localBuilder3 = localBuilder2.setOnlyAlertOnce(bool3);
      if ((0x10 & localNotification.flags) == 0)
        break label310;
      bool4 = true;
      localBuilder4 = localBuilder3.setAutoCancel(bool4).setDefaults(localNotification.defaults).setContentTitle(localCharSequence1).setContentText(localCharSequence2).setContentInfo(localCharSequence3).setContentIntent(localPendingIntent1).setDeleteIntent(localNotification.deleteIntent);
      if ((0x80 & localNotification.flags) == 0)
        break label316;
    }
    label304: label310: label316: for (boolean bool5 = true; ; bool5 = false)
    {
      return localBuilder4.setFullScreenIntent(localPendingIntent2, bool5).setLargeIcon(localBitmap).setNumber(i).setProgress(j, k, bool1).getNotification();
      bool2 = false;
      break;
      bool3 = false;
      break label187;
      bool4 = false;
      break label209;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.T
 * JD-Core Version:    0.6.2
 */