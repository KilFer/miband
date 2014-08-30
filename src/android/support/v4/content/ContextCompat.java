package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class ContextCompat
{
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }

  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16)
    {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
      return true;
    }
    if (i >= 11)
    {
      paramContext.startActivities(paramArrayOfIntent);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.6.2
 */