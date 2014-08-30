package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetWearLocationTask;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

public class PersonInfoWearHandFragment extends DimPanelFragment
{
  private PersonInfo a;
  private View b;
  private View c;
  private View d;
  private View e;
  private TextView f;
  private TextView g;
  private String h;

  private void a()
  {
    if (this.a.getMiliWearHand().equals("LEFT_HAND"))
    {
      this.b.setVisibility(0);
      this.c.setVisibility(4);
      this.g.setTextColor(getResources().getColor(2131230732));
      this.f.setTextColor(getResources().getColor(2131230736));
    }
    while (!this.a.getMiliWearHand().equals("RIGHT_HAND"))
      return;
    this.b.setVisibility(4);
    this.c.setVisibility(0);
    this.f.setTextColor(getResources().getColor(2131230732));
    this.g.setTextColor(getResources().getColor(2131230736));
  }

  protected int inflateLayout()
  {
    return 2130903096;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165427:
    case 2131165428:
    default:
      return;
    case 2131165426:
      this.a.setMiliWearHand("LEFT_HAND");
      onRightButtomClicked();
      return;
    case 2131165429:
    }
    this.a.setMiliWearHand("RIGHT_HAND");
    onRightButtomClicked();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = localView.findViewById(2131165427);
    this.c = localView.findViewById(2131165430);
    this.d = localView.findViewById(2131165429);
    this.d.setOnClickListener(this);
    this.e = localView.findViewById(2131165426);
    this.e.setOnClickListener(this);
    this.f = ((TextView)localView.findViewById(2131165431));
    this.g = ((TextView)localView.findViewById(2131165428));
    this.h = this.a.getMiliWearHand();
    a();
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletHand");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletHand");
  }

  protected void onRightButtomClicked()
  {
    a();
    boolean bool1 = this.a.getMiliWearHand().equals("LEFT_HAND");
    byte b1 = 0;
    if (bool1);
    while (true)
    {
      new BleSetWearLocationTask(null, b1).work();
      if (!this.h.equals(this.a.getMiliWearHand()))
        break;
      dismiss();
      return;
      boolean bool2 = this.a.getMiliWearHand().equals("RIGHT_HAND");
      b1 = 0;
      if (bool2)
        b1 = 1;
    }
    this.a.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.a);
    EventBus.getDefault().post(new EventSettingFragmentUpdate());
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoWearHandFragment
 * JD-Core Version:    0.6.2
 */