package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

final class aU
  implements Runnable
{
  aU(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void run()
  {
    Utils.hideProgressDialog(this.a.getActivity());
    PersonInfoFragment.e(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aU
 * JD-Core Version:    0.6.2
 */