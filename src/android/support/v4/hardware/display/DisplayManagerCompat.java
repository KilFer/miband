package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap<Context, DisplayManagerCompat> a = new WeakHashMap();

  public static DisplayManagerCompat getInstance(Context paramContext)
  {
    synchronized (a)
    {
      Object localObject2 = (DisplayManagerCompat)a.get(paramContext);
      if (localObject2 == null)
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject2 = new a(paramContext);
          a.put(paramContext, localObject2);
        }
      }
      else
        return localObject2;
      localObject2 = new b(paramContext);
    }
  }

  public abstract Display getDisplay(int paramInt);

  public abstract Display[] getDisplays();

  public abstract Display[] getDisplays(String paramString);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat
 * JD-Core Version:    0.6.2
 */