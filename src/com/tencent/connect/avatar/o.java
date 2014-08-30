package com.tencent.connect.avatar;

import android.view.View;
import android.view.View.OnClickListener;

final class o
  implements View.OnClickListener
{
  o(ImageActivity paramImageActivity)
  {
  }

  public final void onClick(View paramView)
  {
    long l = System.currentTimeMillis() - ImageActivity.i(this.a);
    this.a.a("10656", l);
    this.a.setResult(0);
    ImageActivity.j(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.o
 * JD-Core Version:    0.6.2
 */