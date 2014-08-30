package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import cn.com.smartdevices.bracelet.BraceletApp;

public class AppExitFragment extends DimPanelFragment
{
  protected int inflateLayout()
  {
    return 2130903068;
  }

  protected void onRightButtomClicked()
  {
    ((BraceletApp)getActivity().getApplication()).finishBLEService();
    System.exit(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.AppExitFragment
 * JD-Core Version:    0.6.2
 */