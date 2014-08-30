package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import cn.com.smartdevices.bracelet.DataManager;

final class aQ
  implements Runnable
{
  aQ(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void run()
  {
    PersonInfoFragment.a(this.a).totalSportData = DataManager.getInstance().getUserTotalSportData();
    if (this.a.getActivity() == null)
      return;
    this.a.getActivity().runOnUiThread(new aR(this));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aQ
 * JD-Core Version:    0.6.2
 */