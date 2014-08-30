package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class ag
  implements af
{
  public final PendingIntent a(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramArrayOfIntent[(-1 + paramArrayOfIntent.length)]);
    localIntent.addFlags(268435456);
    return PendingIntent.getActivity(paramContext, paramInt1, localIntent, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ag
 * JD-Core Version:    0.6.2
 */