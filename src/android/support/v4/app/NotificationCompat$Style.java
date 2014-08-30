package android.support.v4.app;

import android.app.Notification;

public abstract class NotificationCompat$Style
{
  private NotificationCompat.Builder a;
  CharSequence d;
  CharSequence e;
  boolean f = false;

  public Notification build()
  {
    NotificationCompat.Builder localBuilder = this.a;
    Notification localNotification = null;
    if (localBuilder != null)
      localNotification = this.a.build();
    return localNotification;
  }

  public void setBuilder(NotificationCompat.Builder paramBuilder)
  {
    if (this.a != paramBuilder)
    {
      this.a = paramBuilder;
      if (this.a != null)
        this.a.setStyle(this);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Style
 * JD-Core Version:    0.6.2
 */