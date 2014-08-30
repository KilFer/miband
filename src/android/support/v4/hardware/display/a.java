package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

final class a extends DisplayManagerCompat
{
  private final Object a;

  public a(Context paramContext)
  {
    this.a = paramContext.getSystemService("display");
  }

  public final Display getDisplay(int paramInt)
  {
    return ((DisplayManager)this.a).getDisplay(paramInt);
  }

  public final Display[] getDisplays()
  {
    return ((DisplayManager)this.a).getDisplays();
  }

  public final Display[] getDisplays(String paramString)
  {
    return ((DisplayManager)this.a).getDisplays(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.a
 * JD-Core Version:    0.6.2
 */