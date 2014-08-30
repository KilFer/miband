package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import cn.com.smartdevices.bracelet.view.DynamicView;
import java.util.ArrayList;

final class X extends FragmentPagerAdapter
{
  private ArrayList<DynamicFragment.DynamicViewFragment> a = new ArrayList(2);

  public X(DynamicFragment paramDynamicFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("Mode", 16);
    Fragment localFragment1 = Fragment.instantiate(paramDynamicFragment.getActivity(), DynamicFragment.DynamicViewFragment.class.getName(), localBundle1);
    this.a.add((DynamicFragment.DynamicViewFragment)localFragment1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("Mode", 1);
    Fragment localFragment2 = Fragment.instantiate(paramDynamicFragment.getActivity(), DynamicFragment.DynamicViewFragment.class.getName(), localBundle2);
    this.a.add((DynamicFragment.DynamicViewFragment)localFragment2);
  }

  private DynamicFragment.DynamicViewFragment a(int paramInt)
  {
    return (DynamicFragment.DynamicViewFragment)this.a.get(paramInt);
  }

  private DynamicView b(int paramInt)
  {
    return a(paramInt).getDynamicView();
  }

  private DynamicView d()
  {
    return b(0);
  }

  public final DynamicView a()
  {
    return b(1);
  }

  public final DynamicFragment.DynamicViewFragment b()
  {
    return a(0);
  }

  public final DynamicFragment.DynamicViewFragment c()
  {
    return a(1);
  }

  public final int getCount()
  {
    return 2;
  }

  public final Fragment getItem(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.X
 * JD-Core Version:    0.6.2
 */