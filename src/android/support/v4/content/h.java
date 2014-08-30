package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class h extends f
{
  public final Intent a(ComponentName paramComponentName)
  {
    return Intent.makeMainActivity(paramComponentName);
  }

  public final Intent b(ComponentName paramComponentName)
  {
    return Intent.makeRestartActivityTask(paramComponentName);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.h
 * JD-Core Version:    0.6.2
 */