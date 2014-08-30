package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<G> a = new ArrayList();
  private FrameLayout b;
  private Context c;
  private FragmentManager d;
  private int e;
  private TabHost.OnTabChangeListener f;
  private G g;
  private boolean h;

  public FragmentTabHost(Context paramContext)
  {
    super(paramContext, null);
    a(paramContext, null);
  }

  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  private FragmentTransaction a(String paramString, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < this.a.size())
    {
      localObject2 = (G)this.a.get(i);
      if (!G.b((G)localObject2).equals(paramString))
        break label199;
    }
    while (true)
    {
      i++;
      localObject1 = localObject2;
      break;
      if (localObject1 == null)
        throw new IllegalStateException("No tab known for tag " + paramString);
      if (this.g != localObject1)
      {
        if (paramFragmentTransaction == null)
          paramFragmentTransaction = this.d.beginTransaction();
        if ((this.g != null) && (G.a(this.g) != null))
          paramFragmentTransaction.detach(G.a(this.g));
        if (localObject1 != null)
        {
          if (G.a(localObject1) != null)
            break label187;
          G.a(localObject1, Fragment.instantiate(this.c, G.c(localObject1).getName(), G.d(localObject1)));
          paramFragmentTransaction.add(this.e, G.a(localObject1), G.b(localObject1));
        }
      }
      while (true)
      {
        this.g = localObject1;
        return paramFragmentTransaction;
        label187: paramFragmentTransaction.attach(G.a(localObject1));
      }
      label199: localObject2 = localObject1;
    }
  }

  private void a()
  {
    if (this.b == null)
    {
      this.b = ((FrameLayout)findViewById(this.e));
      if (this.b == null)
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.e);
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.e = localTypedArray.getResourceId(0, 0);
    localTypedArray.recycle();
    super.setOnTabChangedListener(this);
    if (findViewById(16908307) == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      TabWidget localTabWidget = new TabWidget(paramContext);
      localTabWidget.setId(16908307);
      localTabWidget.setOrientation(0);
      localLinearLayout.addView(localTabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0F));
      FrameLayout localFrameLayout1 = new FrameLayout(paramContext);
      localFrameLayout1.setId(16908305);
      localLinearLayout.addView(localFrameLayout1, new LinearLayout.LayoutParams(0, 0, 0.0F));
      FrameLayout localFrameLayout2 = new FrameLayout(paramContext);
      this.b = localFrameLayout2;
      this.b.setId(this.e);
      localLinearLayout.addView(localFrameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0F));
    }
  }

  public void addTab(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle)
  {
    paramTabSpec.setContent(new E(this.c));
    String str = paramTabSpec.getTag();
    G localG = new G(str, paramClass, paramBundle);
    if (this.h)
    {
      G.a(localG, this.d.findFragmentByTag(str));
      if ((G.a(localG) != null) && (!G.a(localG).isDetached()))
      {
        FragmentTransaction localFragmentTransaction = this.d.beginTransaction();
        localFragmentTransaction.detach(G.a(localG));
        localFragmentTransaction.commit();
      }
    }
    this.a.add(localG);
    addTab(paramTabSpec);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    FragmentTransaction localFragmentTransaction1 = null;
    int i = 0;
    if (i < this.a.size())
    {
      G localG = (G)this.a.get(i);
      G.a(localG, this.d.findFragmentByTag(G.b(localG)));
      if ((G.a(localG) != null) && (!G.a(localG).isDetached()))
      {
        if (!G.b(localG).equals(str))
          break label98;
        this.g = localG;
      }
      while (true)
      {
        i++;
        break;
        label98: if (localFragmentTransaction1 == null)
          localFragmentTransaction1 = this.d.beginTransaction();
        localFragmentTransaction1.detach(G.a(localG));
      }
    }
    this.h = true;
    FragmentTransaction localFragmentTransaction2 = a(str, localFragmentTransaction1);
    if (localFragmentTransaction2 != null)
    {
      localFragmentTransaction2.commit();
      this.d.executePendingTransactions();
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.h = false;
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    FragmentTabHost.SavedState localSavedState = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    setCurrentTabByTag(localSavedState.a);
  }

  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.a = getCurrentTabTag();
    return localSavedState;
  }

  public void onTabChanged(String paramString)
  {
    if (this.h)
    {
      FragmentTransaction localFragmentTransaction = a(paramString, null);
      if (localFragmentTransaction != null)
        localFragmentTransaction.commit();
    }
    if (this.f != null)
      this.f.onTabChanged(paramString);
  }

  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.f = paramOnTabChangeListener;
  }

  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }

  public void setup(Context paramContext, FragmentManager paramFragmentManager)
  {
    super.setup();
    this.c = paramContext;
    this.d = paramFragmentManager;
    a();
  }

  public void setup(Context paramContext, FragmentManager paramFragmentManager, int paramInt)
  {
    super.setup();
    this.c = paramContext;
    this.d = paramFragmentManager;
    this.e = paramInt;
    a();
    this.b.setId(paramInt);
    if (getId() == -1)
      setId(16908306);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.6.2
 */