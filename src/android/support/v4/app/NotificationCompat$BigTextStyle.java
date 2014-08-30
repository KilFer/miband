package android.support.v4.app;

public class NotificationCompat$BigTextStyle extends NotificationCompat.Style
{
  CharSequence a;

  public NotificationCompat$BigTextStyle()
  {
  }

  public NotificationCompat$BigTextStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }

  public BigTextStyle bigText(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    return this;
  }

  public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }

  public BigTextStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    this.f = true;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.BigTextStyle
 * JD-Core Version:    0.6.2
 */