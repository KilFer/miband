package android.support.v4.app;

import android.graphics.Bitmap;

public class NotificationCompat$BigPictureStyle extends NotificationCompat.Style
{
  Bitmap a;
  Bitmap b;
  boolean c;

  public NotificationCompat$BigPictureStyle()
  {
  }

  public NotificationCompat$BigPictureStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }

  public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
    this.c = true;
    return this;
  }

  public BigPictureStyle bigPicture(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    return this;
  }

  public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }

  public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    this.f = true;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.BigPictureStyle
 * JD-Core Version:    0.6.2
 */