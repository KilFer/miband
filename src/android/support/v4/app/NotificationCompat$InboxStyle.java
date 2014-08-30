package android.support.v4.app;

import java.util.ArrayList;

public class NotificationCompat$InboxStyle extends NotificationCompat.Style
{
  ArrayList<CharSequence> a = new ArrayList();

  public NotificationCompat$InboxStyle()
  {
  }

  public NotificationCompat$InboxStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }

  public InboxStyle addLine(CharSequence paramCharSequence)
  {
    this.a.add(paramCharSequence);
    return this;
  }

  public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }

  public InboxStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    this.f = true;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.InboxStyle
 * JD-Core Version:    0.6.2
 */