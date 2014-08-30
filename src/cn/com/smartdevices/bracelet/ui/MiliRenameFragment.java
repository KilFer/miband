package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import cn.com.smartdevices.bracelet.BleTask.BleSetDeviceNameTask;

public class MiliRenameFragment extends DimPanelFragment
{
  private static final String a = "MiliRenameFragment";
  private EditText b;
  private String c;

  protected int inflateLayout()
  {
    return 2130903087;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getArguments().getString("REF_MILI_NAME");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((EditText)localView.findViewById(2131165401));
    if (this.c != null)
    {
      this.b.setText(this.c);
      this.b.setSelection(0, this.c.length());
    }
    return localView;
  }

  protected void onRightButtomClicked()
  {
    this.mRightButton.setEnabled(false);
    if (TextUtils.isEmpty(this.b.getText().toString().trim()));
    for (this.c = getResources().getString(2131492987); ; this.c = this.b.getText().toString().replaceAll("\\s+", ""))
    {
      new BleSetDeviceNameTask(new aJ(this), this.c).work();
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.MiliRenameFragment
 * JD-Core Version:    0.6.2
 */