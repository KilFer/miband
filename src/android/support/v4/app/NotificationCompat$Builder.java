package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  Context a;
  CharSequence b;
  CharSequence c;
  PendingIntent d;
  PendingIntent e;
  RemoteViews f;
  Bitmap g;
  CharSequence h;
  int i;
  int j;
  boolean k;
  NotificationCompat.Style l;
  CharSequence m;
  int n;
  int o;
  boolean p;
  ArrayList<NotificationCompat.Action> q = new ArrayList();
  Notification r = new Notification();

  public NotificationCompat$Builder(Context paramContext)
  {
    this.a = paramContext;
    this.r.when = System.currentTimeMillis();
    this.r.audioStreamType = -1;
    this.j = 0;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Notification localNotification2 = this.r;
      localNotification2.flags = (paramInt | localNotification2.flags);
      return;
    }
    Notification localNotification1 = this.r;
    localNotification1.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.q.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }

  public Notification build()
  {
    return NotificationCompat.a().a(this);
  }

  public Notification getNotification()
  {
    return NotificationCompat.a().a(this);
  }

  public Builder setAutoCancel(boolean paramBoolean)
  {
    a(16, paramBoolean);
    return this;
  }

  public Builder setContent(RemoteViews paramRemoteViews)
  {
    this.r.contentView = paramRemoteViews;
    return this;
  }

  public Builder setContentInfo(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    return this;
  }

  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.d = paramPendingIntent;
    return this;
  }

  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    return this;
  }

  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }

  public Builder setDefaults(int paramInt)
  {
    this.r.defaults = paramInt;
    if ((paramInt & 0x4) != 0)
    {
      Notification localNotification = this.r;
      localNotification.flags = (0x1 | localNotification.flags);
    }
    return this;
  }

  public Builder setDeleteIntent(PendingIntent paramPendingIntent)
  {
    this.r.deleteIntent = paramPendingIntent;
    return this;
  }

  public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    this.e = paramPendingIntent;
    a(128, paramBoolean);
    return this;
  }

  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
    return this;
  }

  public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 1;
    this.r.ledARGB = paramInt1;
    this.r.ledOnMS = paramInt2;
    this.r.ledOffMS = paramInt3;
    int i2;
    Notification localNotification;
    int i3;
    if ((this.r.ledOnMS != 0) && (this.r.ledOffMS != 0))
    {
      i2 = i1;
      localNotification = this.r;
      i3 = 0xFFFFFFFE & this.r.flags;
      if (i2 == 0)
        break label92;
    }
    while (true)
    {
      localNotification.flags = (i3 | i1);
      return this;
      i2 = 0;
      break;
      label92: i1 = 0;
    }
  }

  public Builder setNumber(int paramInt)
  {
    this.i = paramInt;
    return this;
  }

  public Builder setOngoing(boolean paramBoolean)
  {
    a(2, paramBoolean);
    return this;
  }

  public Builder setOnlyAlertOnce(boolean paramBoolean)
  {
    a(8, paramBoolean);
    return this;
  }

  public Builder setPriority(int paramInt)
  {
    this.j = paramInt;
    return this;
  }

  public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramBoolean;
    return this;
  }

  public Builder setSmallIcon(int paramInt)
  {
    this.r.icon = paramInt;
    return this;
  }

  public Builder setSmallIcon(int paramInt1, int paramInt2)
  {
    this.r.icon = paramInt1;
    this.r.iconLevel = paramInt2;
    return this;
  }

  public Builder setSound(Uri paramUri)
  {
    this.r.sound = paramUri;
    this.r.audioStreamType = -1;
    return this;
  }

  public Builder setSound(Uri paramUri, int paramInt)
  {
    this.r.sound = paramUri;
    this.r.audioStreamType = paramInt;
    return this;
  }

  public Builder setStyle(NotificationCompat.Style paramStyle)
  {
    if (this.l != paramStyle)
    {
      this.l = paramStyle;
      if (this.l != null)
        this.l.setBuilder(this);
    }
    return this;
  }

  public Builder setSubText(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    return this;
  }

  public Builder setTicker(CharSequence paramCharSequence)
  {
    this.r.tickerText = paramCharSequence;
    return this;
  }

  public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
  {
    this.r.tickerText = paramCharSequence;
    this.f = paramRemoteViews;
    return this;
  }

  public Builder setUsesChronometer(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  public Builder setVibrate(long[] paramArrayOfLong)
  {
    this.r.vibrate = paramArrayOfLong;
    return this;
  }

  public Builder setWhen(long paramLong)
  {
    this.r.when = paramLong;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * JD-Core Version:    0.6.2
 */