package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
  private final ArrayList<e> a = new ArrayList();
  private FrameLayout b;
  private Context c;
  private FragmentManager d;
  private int e;
  private TabHost.OnTabChangeListener f;
  private e g;
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
      localObject2 = (e)this.a.get(i);
      if (!e.b((e)localObject2).equals(paramString))
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
        if ((this.g != null) && (e.a(this.g) != null))
          paramFragmentTransaction.detach(e.a(this.g));
        if (localObject1 != null)
        {
          if (e.a(localObject1) != null)
            break label187;
          e.a(localObject1, Fragment.instantiate(this.c, e.c(localObject1).getName(), e.d(localObject1)));
          paramFragmentTransaction.add(this.e, e.a(localObject1), e.b(localObject1));
        }
      }
      while (true)
      {
        this.g = localObject1;
        return paramFragmentTransaction;
        label187: paramFragmentTransaction.attach(e.a(localObject1));
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
    paramTabSpec.setContent(new h(this.c));
    String str = paramTabSpec.getTag();
    e locale = new e(str, paramClass, paramBundle);
    if (this.h)
    {
      e.a(locale, this.d.findFragmentByTag(str));
      if ((e.a(locale) != null) && (!e.a(locale).isDetached()))
      {
        FragmentTransaction localFragmentTransaction = this.d.beginTransaction();
        localFragmentTransaction.detach(e.a(locale));
        localFragmentTransaction.commit();
      }
    }
    this.a.add(locale);
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
      e locale = (e)this.a.get(i);
      e.a(locale, this.d.findFragmentByTag(e.b(locale)));
      if ((e.a(locale) != null) && (!e.a(locale).isDetached()))
      {
        if (!e.b(locale).equals(str))
          break label98;
        this.g = locale;
      }
      while (true)
      {
        i++;
        break;
        label98: if (localFragmentTransaction1 == null)
          localFragmentTransaction1 = this.d.beginTransaction();
        localFragmentTransaction1.detach(e.a(locale));
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
 * Qualified Name:     android.support.v13.app.FragmentTabHost
 * JD-Core Version:    0.6.2
 */