package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat
{
  private static b a = new a();

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new c();
      return;
    }
  }

  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    a.a(paramDrawable);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.6.2
 */