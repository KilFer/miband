package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

public class PersonInfoSettingGenderFragment extends DimPanelFragment
{
  private PersonInfo a;
  private View b;
  private View c;
  private View d;
  private View e;
  private TextView f;
  private TextView g;
  private int h = 0;

  private void a()
  {
    int i = this.a.gender;
    if (i == 1)
    {
      this.b.setVisibility(0);
      this.c.setVisibility(4);
      this.g.setTextColor(getResources().getColor(2131230732));
      this.f.setTextColor(getResources().getColor(2131230736));
    }
    while (i != 0)
      return;
    this.b.setVisibility(4);
    this.c.setVisibility(0);
    this.f.setTextColor(getResources().getColor(2131230732));
    this.g.setTextColor(getResources().getColor(2131230736));
  }

  protected int inflateLayout()
  {
    return 2130903091;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165419:
    default:
    case 2131165418:
    case 2131165420:
    }
    while (true)
    {
      super.onClick(paramView);
      return;
      this.a.gender = 1;
      onRightButtomClicked();
      continue;
      this.a.gender = 0;
      onRightButtomClicked();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = localView.findViewById(2131165262);
    this.c = localView.findViewById(2131165263);
    this.d = localView.findViewById(2131165420);
    this.d.setOnClickListener(this);
    this.e = localView.findViewById(2131165418);
    this.e.setOnClickListener(this);
    this.f = ((TextView)localView.findViewById(2131165421));
    this.g = ((TextView)localView.findViewById(2131165419));
    this.h = this.a.gender;
    a();
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonInfoGender");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonInfoGender");
  }

  protected void onRightButtomClicked()
  {
    a();
    if (this.h == this.a.gender)
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
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoSettingGenderFragment
 * JD-Core Version:    0.6.2
 */