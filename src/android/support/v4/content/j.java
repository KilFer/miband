package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class j<Data>
{
  final ModernAsyncTask a;
  final Data[] b;

  j()
  {
  }

  j(ModernAsyncTask paramModernAsyncTask, Data[] paramArrayOfData)
  {
    this.a = paramModernAsyncTask;
    this.b = paramArrayOfData;
  }

  public static Intent a(ComponentName paramComponentName)
  {
    return Intent.makeMainActivity(paramComponentName);
  }

  public static Intent b(ComponentName paramComponentName)
  {
    return Intent.makeRestartActivityTask(paramComponentName);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.j
 * JD-Core Version:    0.6.2
 */