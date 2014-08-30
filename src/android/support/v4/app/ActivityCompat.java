package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

public class ActivityCompat extends ContextCompat
{
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }

  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramActivity.invalidateOptionsMenu();
      return true;
    }
    return false;
  }

  public static void startActivity(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivity(paramIntent, paramBundle);
      return;
    }
    paramActivity.startActivity(paramIntent);
  }

  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * JD-Core Version:    0.6.2
 */