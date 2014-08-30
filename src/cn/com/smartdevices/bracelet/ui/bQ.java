package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

final class bQ
  implements Runnable
{
  bQ(UnBindActivity paramUnBindActivity)
  {
  }

  public final void run()
  {
    Utils.hideProgressDialog(this.a);
    this.a.finish();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bQ
 * JD-Core Version:    0.6.2
 */