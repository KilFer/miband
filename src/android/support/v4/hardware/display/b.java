package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

final class b extends DisplayManagerCompat
{
  private final WindowManager a;

  public b(Context paramContext)
  {
    this.a = ((WindowManager)paramContext.getSystemService("window"));
  }

  public final Display getDisplay(int paramInt)
  {
    Display localDisplay = this.a.getDefaultDisplay();
    if (localDisplay.getDisplayId() == paramInt)
      return localDisplay;
    return null;
  }

  public final Display[] getDisplays()
  {
    Display[] arrayOfDisplay = new Display[1];
    arrayOfDisplay[0] = this.a.getDefaultDisplay();
    return arrayOfDisplay;
  }

  public final Display[] getDisplays(String paramString)
  {
    if (paramString == null)
      return getDisplays();
    return new Display[0];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.b
 * JD-Core Version:    0.6.2
 */