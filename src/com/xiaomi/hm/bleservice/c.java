package com.xiaomi.hm.bleservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class c extends BroadcastReceiver
{
  c(BLEService paramBLEService)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    BLEService.access$1(this.a).post(new d(this, paramContext, paramIntent));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.c
 * JD-Core Version:    0.6.2
 */