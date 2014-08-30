package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

public class PersonInfoSettingSignatureFragment extends DimPanelFragment
{
  private PersonInfo a;
  private EditText b;

  protected int inflateLayout()
  {
    return 2130903094;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((EditText)localView.findViewById(2131165424));
    this.b.setText(this.a.personSignature);
    this.b.setSelection(this.b.length());
    return localView;
  }

  protected void onRightButtomClicked()
  {
    String str = this.a.personSignature;
    if (TextUtils.isEmpty(this.b.getText().toString().trim()));
    for (this.a.personSignature = ""; !Utils.checkInputText(this.a.personSignature); this.a.personSignature = this.b.getText().toString().replaceAll("\\s+", ""))
    {
      Toast.makeText(getActivity(), 2131493087, 0).show();
      return;
    }
    if (this.a.personSignature.equals(str))
    {
      dismiss();
      return;
    }
    this.a.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.a);
    EventBus.getDefault().post(new EventPersonInfoUpdate());
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoSettingSignatureFragment
 * JD-Core Version:    0.6.2
 */