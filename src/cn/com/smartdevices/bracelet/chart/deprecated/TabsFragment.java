package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;

public class TabsFragment extends Fragment
  implements View.OnClickListener
{
  private static final String a = "TabsFragment";
  protected TabsFragment.FragmentTabAdapter mAdapter;
  protected ArrayList<TabsFragment.FragmentTab> mFragmentTabs;
  protected ViewPager mPager;
  protected ViewGroup mTabHost;
  protected View[] mTabHostItems;

  private void a(int paramInt)
  {
    View[] arrayOfView = this.mTabHostItems;
    int i = arrayOfView.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        this.mTabHostItems[paramInt].setActivated(true);
        this.mPager.setCurrentItem(paramInt);
        return;
      }
      arrayOfView[j].setActivated(false);
    }
  }

  public void fillFragmentTabs(ArrayList<TabsFragment.FragmentTab> paramArrayList)
  {
  }

  protected int inflateLayout()
  {
    return 2130903113;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Debug.i("TabsFragment", "OnActivityCreated!!");
    this.mTabHost = ((ViewGroup)getView().findViewById(2131165518));
    this.mPager = ((ViewPager)getView().findViewById(2131165517));
    this.mTabHostItems = new View[this.mFragmentTabs.size()];
    int i = 0;
    if (i >= this.mFragmentTabs.size())
    {
      this.mAdapter = new TabsFragment.FragmentTabAdapter(this, getChildFragmentManager());
      this.mPager.setAdapter(this.mAdapter);
      a(0);
      return;
    }
    TextView localTextView;
    switch (i)
    {
    default:
      localTextView = null;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      this.mTabHostItems[i] = localTextView;
      localTextView.setOnClickListener(this);
      localTextView.setText(((TabsFragment.FragmentTab)this.mFragmentTabs.get(i)).a);
      i++;
      break;
      localTextView = (TextView)this.mTabHost.findViewById(2131165519);
      continue;
      localTextView = (TextView)this.mTabHost.findViewById(2131165520);
      continue;
      localTextView = (TextView)this.mTabHost.findViewById(2131165521);
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Debug.i("TabsFragment", "OnAttach!!");
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165519:
      a(0);
      return;
    case 2131165520:
      a(1);
      return;
    case 2131165521:
    }
    a(2);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Debug.i("TabsFragment", "OnCreate!!");
    this.mFragmentTabs = new ArrayList();
    fillFragmentTabs(this.mFragmentTabs);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Debug.i("TabsFragment", "OnCreateView!!");
    return paramLayoutInflater.inflate(inflateLayout(), paramViewGroup, false);
  }

  public void onDestroy()
  {
    super.onDestroy();
    Debug.i("TabsFragment", "OnDestroy!!");
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    Debug.i("TabsFragment", "OnDestroyView!!");
  }

  public void onDetach()
  {
    super.onDetach();
    Debug.i("TabsFragment", "OnDetach!!");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    int i = this.mPager.getCurrentItem();
    Debug.i("TabsFragment", "Save Current Item : " + i);
    paramBundle.putInt("CurrentTab", i);
  }

  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("CurrentTab", 0);
      Debug.i("TabsFragment", "Restore Last Item : " + i);
      if (i != this.mPager.getCurrentItem())
        a(i);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.TabsFragment
 * JD-Core Version:    0.6.2
 */