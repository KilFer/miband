package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;

public class DynamicListFragment extends Fragment
{
  private static final String a = "Dynamic.List";
  private ArrayList<DynamicListFragment.DynamicItem> b;
  private ListView c;
  private Y d;

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b = new ArrayList();
    DynamicListFragment.DynamicItem localDynamicItem1 = new DynamicListFragment.DynamicItem();
    localDynamicItem1.title = "欢迎使用小米手环";
    localDynamicItem1.summary = "点击查看如何玩转小米手环";
    localDynamicItem1.uri = Uri.parse("file:///android_asset/help.html");
    this.b.add(localDynamicItem1);
    DynamicListFragment.DynamicItem localDynamicItem2 = new DynamicListFragment.DynamicItem();
    localDynamicItem2.title = "戴上小米手环出去走一走吧！";
    localDynamicItem2.summary = "让小米手环实时记录你的运动信息，做你的健康助手";
    this.b.add(localDynamicItem2);
    this.d = new Y(this, (byte)0);
    this.c.setAdapter(this.d);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903078, paramViewGroup, false);
    this.c = ((ListView)localView1);
    View localView2 = new View(getActivity());
    localView2.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(390.0F * ChartUtil.getDensity(getActivity()))));
    localView2.setTag("MarginView");
    this.c.addHeaderView(localView2, null, false);
    return localView1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicListFragment
 * JD-Core Version:    0.6.2
 */