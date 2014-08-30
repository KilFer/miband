package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final HashMap<String, Class<?>> N = new HashMap();
  private static int O = 0;
  private static int P = 1;
  private static int Q = 2;
  private static int R = 3;
  private static int S = 4;
  private static int T = 5;
  boolean A;
  boolean B;
  boolean C;
  boolean D;
  boolean E = true;
  boolean F;
  int G;
  ViewGroup H;
  View I;
  View J;
  boolean K;
  boolean L = true;
  J M;
  private boolean U;
  private boolean V;
  int a = 0;
  View b;
  int c;
  Bundle d;
  SparseArray<Parcelable> e;
  int f = -1;
  String g;
  Bundle h;
  Fragment i;
  int j = -1;
  int k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  int r;
  v s;
  FragmentActivity t;
  v u;
  Fragment v;
  int w;
  int x;
  String y;
  boolean z;

  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }

  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass = (Class)N.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        N.put(paramString, localClass);
      }
      Fragment localFragment = (Fragment)localClass.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(localFragment.getClass().getClassLoader());
        localFragment.h = paramBundle;
      }
      return localFragment;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", localIllegalAccessException);
    }
  }

  private void k()
  {
    this.u = new v();
    this.u.a(this.t, new o(this), this);
  }

  final Fragment a(String paramString)
  {
    if (paramString.equals(this.g))
      return this;
    if (this.u != null)
      return this.u.a(paramString);
    return null;
  }

  final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.u != null)
      this.u.e();
    return onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }

  final void a(int paramInt, Fragment paramFragment)
  {
    this.f = paramInt;
    if (paramFragment != null)
    {
      this.g = (paramFragment.g + ":" + this.f);
      return;
    }
    this.g = ("android:fragment:" + this.f);
  }

  final void a(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.u != null)
      this.u.a(paramConfiguration);
  }

  final void a(Bundle paramBundle)
  {
    if (this.e != null)
    {
      this.J.restoreHierarchyState(this.e);
      this.e = null;
    }
    this.F = false;
    onViewStateRestored(paramBundle);
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onViewStateRestored()");
  }

  final boolean a()
  {
    return this.r > 0;
  }

  final boolean a(Menu paramMenu)
  {
    boolean bool1 = this.z;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = this.D;
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.E;
        bool2 = false;
        if (bool4)
        {
          bool2 = true;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      if (this.u != null)
        bool2 |= this.u.a(paramMenu);
    }
    return bool2;
  }

  final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = this.z;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = this.D;
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = this.E;
        bool2 = false;
        if (bool4)
        {
          bool2 = true;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      if (this.u != null)
        bool2 |= this.u.a(paramMenu, paramMenuInflater);
    }
    return bool2;
  }

  final boolean a(MenuItem paramMenuItem)
  {
    if (!this.z)
    {
      if ((this.D) && (this.E) && (onOptionsItemSelected(paramMenuItem)));
      while ((this.u != null) && (this.u.a(paramMenuItem)))
        return true;
    }
    return false;
  }

  final void b()
  {
    this.f = -1;
    this.g = null;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = 0;
    this.s = null;
    this.t = null;
    this.w = 0;
    this.x = 0;
    this.y = null;
    this.z = false;
    this.A = false;
    this.C = false;
    this.M = null;
    this.U = false;
    this.V = false;
  }

  final void b(Bundle paramBundle)
  {
    if (this.u != null)
      this.u.e();
    this.F = false;
    onCreate(paramBundle);
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onCreate()");
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      if (localParcelable != null)
      {
        if (this.u == null)
          k();
        this.u.a(localParcelable, null);
        this.u.f();
      }
    }
  }

  final void b(Menu paramMenu)
  {
    if (!this.z)
    {
      if ((this.D) && (this.E))
        onOptionsMenuClosed(paramMenu);
      if (this.u != null)
        this.u.b(paramMenu);
    }
  }

  final boolean b(MenuItem paramMenuItem)
  {
    if (!this.z)
    {
      if (onContextItemSelected(paramMenuItem));
      while ((this.u != null) && (this.u.b(paramMenuItem)))
        return true;
    }
    return false;
  }

  final void c()
  {
    if (this.u != null)
    {
      this.u.e();
      this.u.b();
    }
    this.F = false;
    onStart();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onStart()");
    if (this.u != null)
      this.u.h();
    if (this.M != null)
      this.M.f();
  }

  final void c(Bundle paramBundle)
  {
    if (this.u != null)
      this.u.e();
    this.F = false;
    onActivityCreated(paramBundle);
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onActivityCreated()");
    if (this.u != null)
      this.u.g();
  }

  final void d()
  {
    if (this.u != null)
    {
      this.u.e();
      this.u.b();
    }
    this.F = false;
    onResume();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onResume()");
    if (this.u != null)
    {
      this.u.i();
      this.u.b();
    }
  }

  final void d(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    if (this.u != null)
    {
      Parcelable localParcelable = this.u.d();
      if (localParcelable != null)
        paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.w));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.x));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.y);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.g);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.r);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.l);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.m);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.p);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.z);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.A);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.E);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.D);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.B);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.C);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.L);
    if (this.s != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.s);
    }
    if (this.t != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mActivity=");
      paramPrintWriter.println(this.t);
    }
    if (this.v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.v);
    }
    if (this.h != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.h);
    }
    if (this.d != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.d);
    }
    if (this.e != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.e);
    }
    if (this.i != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.i);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.k);
    }
    if (this.G != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.G);
    }
    if (this.H != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.H);
    }
    if (this.I != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.I);
    }
    if (this.J != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.I);
    }
    if (this.b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.b);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.c);
    }
    if (this.M != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.M.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.u != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.u + ":");
      this.u.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  final void e()
  {
    onLowMemory();
    if (this.u != null)
      this.u.o();
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  final void f()
  {
    if (this.u != null)
      this.u.j();
    this.F = false;
    onPause();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onPause()");
  }

  final void g()
  {
    if (this.u != null)
      this.u.k();
    this.F = false;
    onStop();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onStop()");
  }

  public final FragmentActivity getActivity()
  {
    return this.t;
  }

  public final Bundle getArguments()
  {
    return this.h;
  }

  public final FragmentManager getChildFragmentManager()
  {
    if (this.u == null)
    {
      k();
      if (this.a < 5)
        break label31;
      this.u.i();
    }
    while (true)
    {
      return this.u;
      label31: if (this.a >= 4)
        this.u.h();
      else if (this.a >= 2)
        this.u.g();
      else if (this.a > 0)
        this.u.f();
    }
  }

  public final FragmentManager getFragmentManager()
  {
    return this.s;
  }

  public final int getId()
  {
    return this.w;
  }

  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    return this.t.getLayoutInflater();
  }

  public LoaderManager getLoaderManager()
  {
    if (this.M != null)
      return this.M;
    if (this.t == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.V = true;
    this.M = this.t.a(this.g, this.U, true);
    return this.M;
  }

  public final Fragment getParentFragment()
  {
    return this.v;
  }

  public final Resources getResources()
  {
    if (this.t == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    return this.t.getResources();
  }

  public final boolean getRetainInstance()
  {
    return this.B;
  }

  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }

  public final String getString(int paramInt, Object[] paramArrayOfObject)
  {
    return getResources().getString(paramInt, paramArrayOfObject);
  }

  public final String getTag()
  {
    return this.y;
  }

  public final Fragment getTargetFragment()
  {
    return this.i;
  }

  public final int getTargetRequestCode()
  {
    return this.k;
  }

  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }

  public boolean getUserVisibleHint()
  {
    return this.L;
  }

  public View getView()
  {
    return this.I;
  }

  final void h()
  {
    if (this.u != null)
      this.u.l();
    if (this.U)
    {
      this.U = false;
      if (!this.V)
      {
        this.V = true;
        this.M = this.t.a(this.g, this.U, false);
      }
      if (this.M != null)
      {
        if (this.t.d)
          break label83;
        this.M.b();
      }
    }
    return;
    label83: this.M.c();
  }

  public final boolean hasOptionsMenu()
  {
    return this.D;
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  final void i()
  {
    if (this.u != null)
      this.u.m();
    this.F = false;
    onDestroyView();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onDestroyView()");
    if (this.M != null)
      this.M.e();
  }

  public final boolean isAdded()
  {
    return (this.t != null) && (this.l);
  }

  public final boolean isDetached()
  {
    return this.A;
  }

  public final boolean isHidden()
  {
    return this.z;
  }

  public final boolean isInLayout()
  {
    return this.p;
  }

  public final boolean isMenuVisible()
  {
    return this.E;
  }

  public final boolean isRemoving()
  {
    return this.m;
  }

  public final boolean isResumed()
  {
    return this.n;
  }

  public final boolean isVisible()
  {
    return (isAdded()) && (!isHidden()) && (this.I != null) && (this.I.getWindowToken() != null) && (this.I.getVisibility() == 0);
  }

  final void j()
  {
    if (this.u != null)
      this.u.n();
    this.F = false;
    onDestroy();
    if (!this.F)
      throw new ae("Fragment " + this + " did not call through to super.onDestroy()");
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    this.F = true;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void onAttach(Activity paramActivity)
  {
    this.F = true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.F = true;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    this.F = true;
  }

  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }

  public void onDestroy()
  {
    this.F = true;
    if (!this.V)
    {
      this.V = true;
      this.M = this.t.a(this.g, this.U, false);
    }
    if (this.M != null)
      this.M.g();
  }

  public void onDestroyOptionsMenu()
  {
  }

  public void onDestroyView()
  {
    this.F = true;
  }

  public void onDetach()
  {
    this.F = true;
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
  }

  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.F = true;
  }

  public void onLowMemory()
  {
    this.F = true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }

  public void onOptionsMenuClosed(Menu paramMenu)
  {
  }

  public void onPause()
  {
    this.F = true;
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
  }

  public void onResume()
  {
    this.F = true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
  }

  public void onStart()
  {
    this.F = true;
    if (!this.U)
    {
      this.U = true;
      if (!this.V)
      {
        this.V = true;
        this.M = this.t.a(this.g, this.U, false);
      }
      if (this.M != null)
        this.M.a();
    }
  }

  public void onStop()
  {
    this.F = true;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
  }

  public void onViewStateRestored(Bundle paramBundle)
  {
    this.F = true;
  }

  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }

  public void setArguments(Bundle paramBundle)
  {
    if (this.f >= 0)
      throw new IllegalStateException("Fragment already active");
    this.h = paramBundle;
  }

  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.D != paramBoolean)
    {
      this.D = paramBoolean;
      if ((isAdded()) && (!isHidden()))
        this.t.supportInvalidateOptionsMenu();
    }
  }

  public void setInitialSavedState(Fragment.SavedState paramSavedState)
  {
    if (this.f >= 0)
      throw new IllegalStateException("Fragment already active");
    if ((paramSavedState != null) && (paramSavedState.a != null));
    for (Bundle localBundle = paramSavedState.a; ; localBundle = null)
    {
      this.d = localBundle;
      return;
    }
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.E != paramBoolean)
    {
      this.E = paramBoolean;
      if ((this.D) && (isAdded()) && (!isHidden()))
        this.t.supportInvalidateOptionsMenu();
    }
  }

  public void setRetainInstance(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.v != null))
      throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    this.B = paramBoolean;
  }

  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    this.i = paramFragment;
    this.k = paramInt;
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.L) && (paramBoolean) && (this.a < 4))
      this.s.a(this);
    this.L = paramBoolean;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.K = bool;
      return;
    }
  }

  public void startActivity(Intent paramIntent)
  {
    if (this.t == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.t.startActivityFromFragment(this, paramIntent, -1);
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.t == null)
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    this.t.startActivityFromFragment(this, paramIntent, paramInt);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    if (this.f >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.f);
    }
    if (this.w != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.w));
    }
    if (this.y != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.y);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.6.2
 */