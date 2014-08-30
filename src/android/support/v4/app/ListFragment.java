package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment
{
  private static int O = 16711681;
  private static int P = 16711682;
  private static int Q = 16711683;
  ListView N;
  private final Handler R = new Handler();
  private final Runnable S = new H(this);
  private final AdapterView.OnItemClickListener T = new I(this);
  private ListAdapter U;
  private View V;
  private TextView W;
  private View X;
  private View Y;
  private CharSequence Z;
  private boolean aa;

  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    k();
    if (this.X == null)
      throw new IllegalStateException("Can't be used with a custom content view");
    if (this.aa == paramBoolean1)
      return;
    this.aa = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.X.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
        this.Y.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
      }
      while (true)
      {
        this.X.setVisibility(8);
        this.Y.setVisibility(0);
        return;
        this.X.clearAnimation();
        this.Y.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.X.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
      this.Y.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
    }
    while (true)
    {
      this.X.setVisibility(0);
      this.Y.setVisibility(8);
      return;
      this.X.clearAnimation();
      this.Y.clearAnimation();
    }
  }

  private void k()
  {
    if (this.N != null)
      return;
    View localView1 = getView();
    if (localView1 == null)
      throw new IllegalStateException("Content view not yet created");
    if ((localView1 instanceof ListView))
    {
      this.N = ((ListView)localView1);
      this.aa = true;
      this.N.setOnItemClickListener(this.T);
      if (this.U == null)
        break label256;
      ListAdapter localListAdapter = this.U;
      this.U = null;
      setListAdapter(localListAdapter);
    }
    while (true)
    {
      this.R.post(this.S);
      return;
      this.W = ((TextView)localView1.findViewById(16711681));
      if (this.W == null)
        this.V = localView1.findViewById(16908292);
      View localView2;
      while (true)
      {
        this.X = localView1.findViewById(16711682);
        this.Y = localView1.findViewById(16711683);
        localView2 = localView1.findViewById(16908298);
        if ((localView2 instanceof ListView))
          break label195;
        if (localView2 != null)
          break;
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        this.W.setVisibility(8);
      }
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
      label195: this.N = ((ListView)localView2);
      if (this.V != null)
      {
        this.N.setEmptyView(this.V);
        break;
      }
      if (this.Z == null)
        break;
      this.W.setText(this.Z);
      this.N.setEmptyView(this.W);
      break;
      label256: if (this.X != null)
        a(false, false);
    }
  }

  public ListAdapter getListAdapter()
  {
    return this.U;
  }

  public ListView getListView()
  {
    k();
    return this.N;
  }

  public long getSelectedItemId()
  {
    k();
    return this.N.getSelectedItemId();
  }

  public int getSelectedItemPosition()
  {
    k();
    return this.N.getSelectedItemPosition();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    FrameLayout localFrameLayout1 = new FrameLayout(localFragmentActivity);
    LinearLayout localLinearLayout = new LinearLayout(localFragmentActivity);
    localLinearLayout.setId(16711682);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setVisibility(8);
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(new ProgressBar(localFragmentActivity, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    localFrameLayout1.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    FrameLayout localFrameLayout2 = new FrameLayout(localFragmentActivity);
    localFrameLayout2.setId(16711683);
    TextView localTextView = new TextView(getActivity());
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    localFrameLayout2.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    ListView localListView = new ListView(getActivity());
    localListView.setId(16908298);
    localListView.setDrawSelectorOnTop(false);
    localFrameLayout2.addView(localListView, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.addView(localFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout1;
  }

  public void onDestroyView()
  {
    this.R.removeCallbacks(this.S);
    this.N = null;
    this.aa = false;
    this.Y = null;
    this.X = null;
    this.V = null;
    this.W = null;
    super.onDestroyView();
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    k();
  }

  public void setEmptyText(CharSequence paramCharSequence)
  {
    k();
    if (this.W == null)
      throw new IllegalStateException("Can't be used with a custom content view");
    this.W.setText(paramCharSequence);
    if (this.Z == null)
      this.N.setEmptyView(this.W);
    this.Z = paramCharSequence;
  }

  public void setListAdapter(ListAdapter paramListAdapter)
  {
    if (this.U != null);
    for (int i = 1; ; i = 0)
    {
      this.U = paramListAdapter;
      if (this.N != null)
      {
        this.N.setAdapter(paramListAdapter);
        if ((!this.aa) && (i == 0))
        {
          IBinder localIBinder = getView().getWindowToken();
          boolean bool = false;
          if (localIBinder != null)
            bool = true;
          a(true, bool);
        }
      }
      return;
    }
  }

  public void setListShown(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }

  public void setListShownNoAnimation(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }

  public void setSelection(int paramInt)
  {
    k();
    this.N.setSelection(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ListFragment
 * JD-Core Version:    0.6.2
 */