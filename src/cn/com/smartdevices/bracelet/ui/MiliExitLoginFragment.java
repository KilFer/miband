package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Utils;

public class MiliExitLoginFragment extends DimPanelFragment
{
  private int a = 0;

  protected int inflateLayout()
  {
    this.a = getArguments().getInt("exit_login_type");
    if (this.a == 0)
      return 2130903085;
    return 2130903086;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    TextView localTextView;
    String str1;
    String str2;
    String str3;
    if (this.a == 0)
    {
      localTextView = (TextView)localView.findViewById(2131165400);
      str1 = getString(2131493293);
      str2 = getString(2131493294);
      str3 = getString(2131493295);
      if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
        break label99;
    }
    label99: for (String str4 = str1 + str2 + str3; ; str4 = str1 + str3)
    {
      localTextView.setText(str4);
      return localView;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.MiliExitLoginFragment
 * JD-Core Version:    0.6.2
 */