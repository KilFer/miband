package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class TabsFragment$FragmentTabAdapter extends FragmentPagerAdapter
{
  public TabsFragment$FragmentTabAdapter(TabsFragment paramTabsFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }

  public int getCount()
  {
    return this.a.mFragmentTabs.size();
  }

  public Fragment getItem(int paramInt)
  {
    TabsFragment.FragmentTab localFragmentTab = (TabsFragment.FragmentTab)this.a.mFragmentTabs.get(paramInt);
    return Fragment.instantiate(this.a.getActivity(), localFragmentTab.b.getName(), localFragmentTab.c);
  }

  public CharSequence getPageTitle(int paramInt)
  {
    return ((TabsFragment.FragmentTab)this.a.mFragmentTabs.get(paramInt)).a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.TabsFragment.FragmentTabAdapter
 * JD-Core Version:    0.6.2
 */