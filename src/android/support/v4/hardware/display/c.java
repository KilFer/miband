package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

final class c
{
  public static Display a(Object paramObject, int paramInt)
  {
    return ((DisplayManager)paramObject).getDisplay(paramInt);
  }

  public static Object a(Context paramContext)
  {
    return paramContext.getSystemService("display");
  }

  public static Display[] a(Object paramObject)
  {
    return ((DisplayManager)paramObject).getDisplays();
  }

  public static Display[] a(Object paramObject, String paramString)
  {
    return ((DisplayManager)paramObject).getDisplays(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.c
 * JD-Core Version:    0.6.2
 */