package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

final class O
{
  public static Intent a(Activity paramActivity)
  {
    return paramActivity.getParentActivityIntent();
  }

  public static String a(ActivityInfo paramActivityInfo)
  {
    return paramActivityInfo.parentActivityName;
  }

  public static boolean a(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }

  public static void b(Activity paramActivity, Intent paramIntent)
  {
    paramActivity.navigateUpTo(paramIntent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.O
 * JD-Core Version:    0.6.2
 */