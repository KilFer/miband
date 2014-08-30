package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

final class U
  implements Q
{
  public final Notification a(NotificationCompat.Builder paramBuilder)
  {
    X localX = new X(paramBuilder.a, paramBuilder.r, paramBuilder.b, paramBuilder.c, paramBuilder.h, paramBuilder.f, paramBuilder.i, paramBuilder.d, paramBuilder.e, paramBuilder.g, paramBuilder.n, paramBuilder.o, paramBuilder.p, paramBuilder.k, paramBuilder.j, paramBuilder.m);
    Iterator localIterator = paramBuilder.q.iterator();
    while (localIterator.hasNext())
    {
      NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
      localX.a(localAction.icon, localAction.title, localAction.actionIntent);
    }
    if (paramBuilder.l != null)
    {
      if (!(paramBuilder.l instanceof NotificationCompat.BigTextStyle))
        break label177;
      NotificationCompat.BigTextStyle localBigTextStyle = (NotificationCompat.BigTextStyle)paramBuilder.l;
      localX.a(localBigTextStyle.d, localBigTextStyle.f, localBigTextStyle.e, localBigTextStyle.a);
    }
    while (true)
    {
      return localX.a();
      label177: if ((paramBuilder.l instanceof NotificationCompat.InboxStyle))
      {
        NotificationCompat.InboxStyle localInboxStyle = (NotificationCompat.InboxStyle)paramBuilder.l;
        localX.a(localInboxStyle.d, localInboxStyle.f, localInboxStyle.e, localInboxStyle.a);
      }
      else if ((paramBuilder.l instanceof NotificationCompat.BigPictureStyle))
      {
        NotificationCompat.BigPictureStyle localBigPictureStyle = (NotificationCompat.BigPictureStyle)paramBuilder.l;
        localX.a(localBigPictureStyle.d, localBigPictureStyle.f, localBigPictureStyle.e, localBigPictureStyle.a, localBigPictureStyle.b, localBigPictureStyle.c);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.U
 * JD-Core Version:    0.6.2
 */