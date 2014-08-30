package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver
{
  private static final String a = "android.support.content.wakelockid";
  private static final SparseArray<PowerManager.WakeLock> b = new SparseArray();
  private static int c = 1;

  public static boolean completeWakefulIntent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0)
      return false;
    synchronized (b)
    {
      PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)b.get(i);
      if (localWakeLock != null)
      {
        localWakeLock.release();
        b.remove(i);
        return true;
      }
      Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + i);
      return true;
    }
  }

  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (b)
    {
      int i = c;
      int j = 1 + c;
      c = j;
      if (j <= 0)
        c = 1;
      paramIntent.putExtra("android.support.content.wakelockid", i);
      ComponentName localComponentName = paramContext.startService(paramIntent);
      if (localComponentName == null)
        return null;
      PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:" + localComponentName.flattenToShortString());
      localWakeLock.setReferenceCounted(false);
      localWakeLock.acquire(60000L);
      b.put(i, localWakeLock);
      return localComponentName;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.6.2
 */