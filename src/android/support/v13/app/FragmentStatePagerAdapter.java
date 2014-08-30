package android.support.v13.app;

import android.app.Fragment;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{
  private static final String a = "FragmentStatePagerAdapter";
  private static final boolean b;
  private final FragmentManager c;
  private FragmentTransaction d = null;
  private ArrayList<Fragment.SavedState> e = new ArrayList();
  private ArrayList<Fragment> f = new ArrayList();
  private Fragment g = null;

  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.c = paramFragmentManager;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.d == null)
      this.d = this.c.beginTransaction();
    while (this.e.size() <= paramInt)
      this.e.add(null);
    this.e.set(paramInt, this.c.saveFragmentInstanceState(localFragment));
    this.f.set(paramInt, null);
    this.d.remove(localFragment);
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

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.f.size() > paramInt)
    {
      Fragment localFragment2 = (Fragment)this.f.get(paramInt);
      if (localFragment2 != null)
        return localFragment2;
    }
    if (this.d == null)
      this.d = this.c.beginTransaction();
    Fragment localFragment1 = getItem(paramInt);
    if (this.e.size() > paramInt)
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)this.e.get(paramInt);
      if (localSavedState != null)
        localFragment1.setInitialSavedState(localSavedState);
    }
    while (this.f.size() <= paramInt)
      this.f.add(null);
    FragmentCompat.setMenuVisibility(localFragment1, false);
    FragmentCompat.setUserVisibleHint(localFragment1, false);
    this.f.set(paramInt, localFragment1);
    this.d.add(paramViewGroup.getId(), localFragment1);
    return localFragment1;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      Parcelable[] arrayOfParcelable = localBundle.getParcelableArray("states");
      this.e.clear();
      this.f.clear();
      if (arrayOfParcelable != null)
        for (int j = 0; j < arrayOfParcelable.length; j++)
          this.e.add((Fragment.SavedState)arrayOfParcelable[j]);
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith("f"))
        {
          int i = Integer.parseInt(str.substring(1));
          Fragment localFragment = this.c.getFragment(localBundle, str);
          if (localFragment != null)
          {
            while (this.f.size() <= i)
              this.f.add(null);
            FragmentCompat.setMenuVisibility(localFragment, false);
            this.f.set(i, localFragment);
          }
          else
          {
            Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }

  public Parcelable saveState()
  {
    int i = this.e.size();
    Bundle localBundle1 = null;
    if (i > 0)
    {
      localBundle1 = new Bundle();
      Fragment.SavedState[] arrayOfSavedState = new Fragment.SavedState[this.e.size()];
      this.e.toArray(arrayOfSavedState);
      localBundle1.putParcelableArray("states", arrayOfSavedState);
    }
    int j = 0;
    Bundle localBundle2 = localBundle1;
    while (j < this.f.size())
    {
      Fragment localFragment = (Fragment)this.f.get(j);
      if (localFragment != null)
      {
        if (localBundle2 == null)
          localBundle2 = new Bundle();
        String str = "f" + j;
        this.c.putFragment(localBundle2, str, localFragment);
      }
      j++;
    }
    return localBundle2;
  }

  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.g)
    {
      if (this.g != null)
      {
        FragmentCompat.setMenuVisibility(this.g, false);
        FragmentCompat.setUserVisibleHint(this.g, false);
      }
      if (localFragment != null)
      {
        FragmentCompat.setMenuVisibility(localFragment, true);
        FragmentCompat.setUserVisibleHint(localFragment, true);
      }
      this.g = localFragment;
    }
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v13.app.FragmentStatePagerAdapter
 * JD-Core Version:    0.6.2
 */