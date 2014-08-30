package com.hm.cheneehealth.wxapi;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.activity.MainActivity;

final class b
  implements View.OnClickListener
{
  b(WXEntryActivity paramWXEntryActivity)
  {
  }

  public final void onClick(View paramView)
  {
    this.a.startActivity(new Intent(this.a, MainActivity.class));
    this.a.finish();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.hm.cheneehealth.wxapi.b
 * JD-Core Version:    0.6.2
 */