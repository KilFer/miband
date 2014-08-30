package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter
{
  private static final String a = "FragmentPagerAdapter";
  private static final boolean b;
  private final FragmentManager c;
  private FragmentTransaction d = null;
  private Fragment e = null;

  public FragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    this.c = paramFragmentManager;
  }

  private static String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.d == null)
      this.d = this.c.beginTransaction();
    this.d.detach((Fragment)paramObject);
  }

  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.d != null)
    {
      this.d.commitAllowingStateLoss();
      this.d = null;
      this.c.executePendingTransactions();
    }
  }

  public abstract Fragment getItem(int paramInt);

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.d == null)
      this.d = this.c.beginTransaction();
    long l = getItemId(paramInt);
    String str = a(paramViewGroup.getId(), l);
    Fragment localFragment = this.c.findFragmentByTag(str);
    if (localFragment != null)
      this.d.attach(localFragment);
    while (true)
    {
      if (localFragment != this.e)
      {
        localFragment.setMenuVisibility(false);
        localFragment.setUserVisibleHint(false);
      }
      return localFragment;
      localFragment = getItem(paramInt);
      this.d.add(paramViewGroup.getId(), localFragment, a(paramViewGroup.getId(), l));
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public Parcelable saveState()
  {
    return null;
  }

  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.e)
    {
      if (this.e != null)
      {
        this.e.setMenuVisibility(false);
        this.e.setUserVisibleHint(false);
      }
      if (localFragment != null)
      {
        localFragment.setMenuVisibility(true);
        localFragment.setUserVisibleHint(true);
      }
      this.e = localFragment;
    }
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentPagerAdapter
 * JD-Core Version:    0.6.2
 */