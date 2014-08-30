package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat
{
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  public static final int SHOW_AS_ACTION_NEVER = 0;
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String a = "MenuItemCompat";
  private static E b = new A();

  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      b = new C();
      return;
    }
    if (i >= 11)
    {
      b = new B();
      return;
    }
  }

  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).collapseActionView();
    return b.c(paramMenuItem);
  }

  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).expandActionView();
    return b.b(paramMenuItem);
  }

  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).getSupportActionProvider();
    Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
    return null;
  }

  public static View getActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).getActionView();
    return b.a(paramMenuItem);
  }

  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).isActionViewExpanded();
    return b.d(paramMenuItem);
  }

  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramInt);
    return b.b(paramMenuItem, paramInt);
  }

  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setActionView(paramView);
    return b.a(paramMenuItem, paramView);
  }

  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
      return ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener);
    return b.a(paramMenuItem, paramOnActionExpandListener);
  }

  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    b.a(paramMenuItem, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat
 * JD-Core Version:    0.6.2
 */