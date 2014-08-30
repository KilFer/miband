package com.xiaomi.channel.sdk;

import android.content.Context;
import android.content.Intent;

final class g
  implements Runnable
{
  g(MLShareApiFactory paramMLShareApiFactory, Intent paramIntent)
  {
  }

  public final void run()
  {
    MLShareApiFactory.a(this.a).sendBroadcast(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.g
 * JD-Core Version:    0.6.2
 */