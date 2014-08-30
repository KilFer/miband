package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import cn.com.smartdevices.bracelet.view.DynamicView;

public class DynamicFragment$DynamicViewFragment extends Fragment
{
  private DynamicView a;
  private ChartData.DynamicData b;
  private int c;
  private PageIndicator d = null;

  private void a(DynamicView paramDynamicView)
  {
    if (this.c == 1)
    {
      paramDynamicView.setStepGoal(Keeper.readPersonInfo().getDaySportGoalSteps());
      paramDynamicView.setStepCount(this.b.getStepCount());
      paramDynamicView.setStepDistance(ChartData.formatDistance(getActivity(), this.b.getStepDistance()));
      paramDynamicView.setStepCalorie(this.b.getStepCalorie());
      paramDynamicView.setStepTip(this.b.getStepTip());
    }
    while (true)
    {
      Debug.i("Dynamic.Main", "BindData : " + this.b + " , Mode : " + this.c);
      return;
      if (this.c == 16)
      {
        paramDynamicView.setSleepTime(this.b.getSleepTime());
        paramDynamicView.setSleepDeepTime(this.b.getSleepDeepTime());
        paramDynamicView.setSleepTip(this.b.getSleepTip());
      }
    }
  }

  public DynamicView getDynamicView()
  {
    return this.a;
  }

  public void notifyDataSetChanged(boolean paramBoolean)
  {
    if (this.a != null)
    {
      DynamicView localDynamicView = this.a;
      a(localDynamicView);
      this.a.refresh(paramBoolean);
    }
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a.refresh(true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.c = localBundle.getInt("Mode");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    DynamicView localDynamicView1 = new DynamicView(getActivity());
    this.a = ((DynamicView)localDynamicView1);
    this.a.setMode(this.c);
    this.b = ChartData.getDynamicData();
    DynamicView localDynamicView2 = this.a;
    a(localDynamicView2);
    this.a.refresh();
    this.a.setIndicator(this.d);
    return localDynamicView1;
  }

  public void onResume()
  {
    super.onResume();
    if (!Utils.isBinded())
      this.a.setBackgroundColor(-12827569);
  }

  public void setConnectingAlpha(Boolean paramBoolean)
  {
    if (this.a != null)
      this.a.setConnectingAlpha(paramBoolean);
  }

  public void setIndicator(PageIndicator paramPageIndicator)
  {
    this.d = paramPageIndicator;
    if (this.a != null)
      this.a.setIndicator(paramPageIndicator);
  }

  public void setSlideUpPosition(float paramFloat)
  {
    if (this.a != null)
      this.a.setSlideUpPostion(paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicFragment.DynamicViewFragment
 * JD-Core Version:    0.6.2
 */