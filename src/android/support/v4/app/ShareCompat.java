package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public class ShareCompat
{
  public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  private static Y a = new Y();

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new ab();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new aa();
      return;
    }
  }

  public static void configureMenuItem(Menu paramMenu, int paramInt, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    MenuItem localMenuItem = paramMenu.findItem(paramInt);
    if (localMenuItem == null)
      throw new IllegalArgumentException("Could not find menu item with id " + paramInt + " in the supplied menu");
    configureMenuItem(localMenuItem, paramIntentBuilder);
  }

  public static void configureMenuItem(MenuItem paramMenuItem, ShareCompat.IntentBuilder paramIntentBuilder)
  {
    a.a(paramMenuItem, paramIntentBuilder);
  }

  public static ComponentName getCallingActivity(Activity paramActivity)
  {
    ComponentName localComponentName = paramActivity.getCallingActivity();
    if (localComponentName == null)
      localComponentName = (ComponentName)paramActivity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
    return localComponentName;
  }

  public static String getCallingPackage(Activity paramActivity)
  {
    String str = paramActivity.getCallingPackage();
    if (str == null)
      str = paramActivity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
    return str;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat
 * JD-Core Version:    0.6.2
 */