package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetColorThemeTask;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

public class PersonInfoSetLightColorFragment extends DimPanelFragment
{
  private PersonInfo a;
  private String b;
  private View c;
  private View d;
  private View e;
  private View f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;

  private void a()
  {
    this.c.setVisibility(4);
    this.e.setVisibility(4);
    this.f.setVisibility(4);
    this.d.setVisibility(4);
    this.g.setTextColor(getResources().getColor(2131230736));
    this.j.setTextColor(getResources().getColor(2131230736));
    this.i.setTextColor(getResources().getColor(2131230736));
    this.h.setTextColor(getResources().getColor(2131230736));
    if (this.a.getMiliColor().equals("BLUE"))
    {
      this.g.setTextColor(getResources().getColor(2131230732));
      this.c.setVisibility(0);
    }
    do
    {
      return;
      if (this.a.getMiliColor().equals("ORANGE"))
      {
        this.j.setTextColor(getResources().getColor(2131230732));
        this.e.setVisibility(0);
        return;
      }
      if (this.a.getMiliColor().equals("GREEN"))
      {
        this.i.setTextColor(getResources().getColor(2131230732));
        this.f.setVisibility(0);
        return;
      }
    }
    while (!this.a.getMiliColor().equals("RED"));
    this.h.setTextColor(getResources().getColor(2131230732));
    this.d.setVisibility(0);
  }

  private void a(View paramView)
  {
    this.c = paramView.findViewById(2131165406);
    this.e = paramView.findViewById(2131165409);
    this.f = paramView.findViewById(2131165412);
    this.d = paramView.findViewById(2131165415);
    this.g = ((TextView)paramView.findViewById(2131165407));
    this.j = ((TextView)paramView.findViewById(2131165410));
    this.i = ((TextView)paramView.findViewById(2131165413));
    this.h = ((TextView)paramView.findViewById(2131165416));
    paramView.findViewById(2131165405).setOnClickListener(this);
    paramView.findViewById(2131165408).setOnClickListener(this);
    paramView.findViewById(2131165411).setOnClickListener(this);
    paramView.findViewById(2131165414).setOnClickListener(this);
  }

  protected int inflateLayout()
  {
    return 2130903089;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165405:
      this.a.setMiliColor("BLUE");
      onRightButtomClicked();
      return;
    case 2131165408:
      this.a.setMiliColor("ORANGE");
      onRightButtomClicked();
      return;
    case 2131165411:
      this.a.setMiliColor("GREEN");
      onRightButtomClicked();
      return;
    case 2131165414:
    }
    this.a.setMiliColor("RED");
    onRightButtomClicked();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = Keeper.readPersonInfo();
    this.b = this.a.getMiliColor();
    this.c = localView.findViewById(2131165406);
    this.e = localView.findViewById(2131165409);
    this.f = localView.findViewById(2131165412);
    this.d = localView.findViewById(2131165415);
    this.g = ((TextView)localView.findViewById(2131165407));
    this.j = ((TextView)localView.findViewById(2131165410));
    this.i = ((TextView)localView.findViewById(2131165413));
    this.h = ((TextView)localView.findViewById(2131165416));
    localView.findViewById(2131165405).setOnClickListener(this);
    localView.findViewById(2131165408).setOnClickListener(this);
    localView.findViewById(2131165411).setOnClickListener(this);
    localView.findViewById(2131165414).setOnClickListener(this);
    a();
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletLight");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletLight");
  }

  protected void onRightButtomClicked()
  {
    int k = 1542;
    if (this.a.getMiliColor().equals("BLUE"));
    while (true)
    {
      new BleSetColorThemeTask(null, k).work();
      a();
      if (!this.b.equals(this.a.getMiliColor()))
        break;
      dismiss();
      return;
      if (this.a.getMiliColor().equals("ORANGE"))
        k = 393728;
      else if (this.a.getMiliColor().equals("GREEN"))
        k = 263424;
      else if (this.a.getMiliColor().equals("RED"))
        k = 393474;
    }
    this.a.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.a);
    EventBus.getDefault().post(new EventSettingFragmentUpdate());
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoSetLightColorFragment
 * JD-Core Version:    0.6.2
 */