package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

final class F
{
  public static MenuItem a(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }

  public static View a(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }

  public static void a(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }

  public static MenuItem b(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.F
 * JD-Core Version:    0.6.2
 */