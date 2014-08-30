package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class u
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((s.a(XiaomiUpdateAgent.b())) && (XiaomiUpdateAgent.f().l != 1))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + XiaomiUpdateAgent.c().packageName));
      localIntent.setClassName("com.xiaomi.market", "com.xiaomi.market.ui.AppDetailActivity");
      XiaomiUpdateAgent.b().startActivity(localIntent);
      return;
    }
    m.i(XiaomiUpdateAgent.b()).a(XiaomiUpdateAgent.c(), XiaomiUpdateAgent.f());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.u
 * JD-Core Version:    0.6.2
 */