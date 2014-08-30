package com.tencent.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class C extends BroadcastReceiver
{
  C(n paramn)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.getBooleanExtra("noConnectivity", false)) && (n.d(this.a) != null))
      n.d(this.a).sendEmptyMessage(256);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.C
 * JD-Core Version:    0.6.2
 */