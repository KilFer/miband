package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FragmentActivity extends Activity
{
  private static final String e = "FragmentActivity";
  private static String f = "android:support:fragments";
  private static final int g = 11;
  private static int h = 1;
  private static int i = 2;
  final Handler a = new q(this);
  final v b = new v();
  boolean c;
  boolean d;
  private u j = new r(this);
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private HashMap<String, J> q;
  private J r;

  private static String a(View paramView)
  {
    char c1 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    switch (paramView.getVisibility())
    {
    default:
      localStringBuilder.append(c2);
    case 0:
    case 4:
    case 8:
    }
    while (true)
    {
      char c3;
      label108: char c4;
      label126: char c5;
      label143: char c6;
      label161: char c7;
      label179: char c8;
      label197: char c9;
      label215: label236: char c10;
      label253: int i1;
      Resources localResources;
      if (paramView.isFocusable())
      {
        c3 = c1;
        localStringBuilder.append(c3);
        if (!paramView.isEnabled())
          break label533;
        c4 = 'E';
        localStringBuilder.append(c4);
        if (!paramView.willNotDraw())
          break label539;
        c5 = c2;
        localStringBuilder.append(c5);
        if (!paramView.isHorizontalScrollBarEnabled())
          break label546;
        c6 = 'H';
        localStringBuilder.append(c6);
        if (!paramView.isVerticalScrollBarEnabled())
          break label552;
        c7 = 'V';
        localStringBuilder.append(c7);
        if (!paramView.isClickable())
          break label558;
        c8 = 'C';
        localStringBuilder.append(c8);
        if (!paramView.isLongClickable())
          break label564;
        c9 = 'L';
        localStringBuilder.append(c9);
        localStringBuilder.append(' ');
        if (!paramView.isFocused())
          break label570;
        localStringBuilder.append(c1);
        if (!paramView.isSelected())
          break label575;
        c10 = 'S';
        localStringBuilder.append(c10);
        if (paramView.isPressed())
          c2 = 'P';
        localStringBuilder.append(c2);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        i1 = paramView.getId();
        if (i1 != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(i1));
          localResources = paramView.getResources();
          if ((i1 != 0) && (localResources != null))
            switch (0xFF000000 & i1)
            {
            default:
            case 2130706432:
            case 16777216:
            }
        }
      }
      try
      {
        String str1 = localResources.getResourcePackageName(i1);
        while (true)
        {
          String str2 = localResources.getResourceTypeName(i1);
          String str3 = localResources.getResourceEntryName(i1);
          localStringBuilder.append(" ");
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(str2);
          localStringBuilder.append("/");
          localStringBuilder.append(str3);
          label485: localStringBuilder.append("}");
          return localStringBuilder.toString();
          localStringBuilder.append('V');
          break;
          localStringBuilder.append('I');
          break;
          localStringBuilder.append('G');
          break;
          c3 = c2;
          break label108;
          label533: c4 = c2;
          break label126;
          label539: c5 = 'D';
          break label143;
          label546: c6 = c2;
          break label161;
          label552: c7 = c2;
          break label179;
          label558: c8 = c2;
          break label197;
          label564: c9 = c2;
          break label215;
          label570: c1 = c2;
          break label236;
          label575: c10 = c2;
          break label253;
          str1 = "app";
          continue;
          str1 = "android";
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label485;
      }
    }
  }

  private void a()
  {
    if (this.p)
    {
      this.p = false;
      if (this.r != null)
      {
        if (this.d)
          break label41;
        this.r.b();
      }
    }
    while (true)
    {
      this.b.l();
      return;
      label41: this.r.c();
    }
  }

  private void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null)
      paramPrintWriter.println("null");
    while (true)
    {
      return;
      paramPrintWriter.println(a(paramView));
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i1 = localViewGroup.getChildCount();
        if (i1 > 0)
        {
          String str = paramString + "  ";
          for (int i2 = 0; i2 < i1; i2++)
            a(str, paramPrintWriter, localViewGroup.getChildAt(i2));
        }
      }
    }
  }

  final J a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.q == null)
      this.q = new HashMap();
    J localJ = (J)this.q.get(paramString);
    if (localJ == null)
    {
      if (paramBoolean2)
      {
        localJ = new J(paramString, this, paramBoolean1);
        this.q.put(paramString, localJ);
      }
      return localJ;
    }
    localJ.a(this);
    return localJ;
  }

  final void a(String paramString)
  {
    if (this.q != null)
    {
      J localJ = (J)this.q.get(paramString);
      if ((localJ != null) && (!localJ.g))
      {
        localJ.g();
        this.q.remove(paramString);
      }
    }
  }

  final void a(boolean paramBoolean)
  {
    if (!this.m)
    {
      this.m = true;
      this.d = paramBoolean;
      this.a.removeMessages(1);
      if (this.p)
      {
        this.p = false;
        if (this.r != null)
        {
          if (this.d)
            break label66;
          this.r.b();
        }
      }
    }
    while (true)
    {
      this.b.l();
      return;
      label66: this.r.c();
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.k);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.l);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.c);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.m);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.p);
    if (this.r != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.r)));
      paramPrintWriter.println(":");
      this.r.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.b.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }

  public Object getLastCustomNonConfigurationInstance()
  {
    t localt = (t)getLastNonConfigurationInstance();
    if (localt != null)
      return localt.b;
    return null;
  }

  public FragmentManager getSupportFragmentManager()
  {
    return this.b;
  }

  public LoaderManager getSupportLoaderManager()
  {
    if (this.r != null)
      return this.r;
    this.o = true;
    this.r = a(null, this.p, true);
    return this.r;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.e();
    int i1 = paramInt1 >> 16;
    if (i1 != 0)
    {
      int i2 = i1 - 1;
      if ((this.b.b == null) || (i2 < 0) || (i2 >= this.b.b.size()))
      {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      Fragment localFragment = (Fragment)this.b.b.get(i2);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttachFragment(Fragment paramFragment)
  {
  }

  public void onBackPressed()
  {
    if (!this.b.popBackStackImmediate())
      finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.b.a(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.b.a(this, this.j, null);
    if (getLayoutInflater().getFactory() == null)
      getLayoutInflater().setFactory(this);
    super.onCreate(paramBundle);
    t localt = (t)getLastNonConfigurationInstance();
    if (localt != null)
      this.q = localt.e;
    Parcelable localParcelable;
    v localv;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localv = this.b;
      if (localt == null)
        break label99;
    }
    label99: for (ArrayList localArrayList = localt.d; ; localArrayList = null)
    {
      localv.a(localParcelable, localArrayList);
      this.b.f();
      return;
    }
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.b.a(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT >= 11)
        return bool;
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString))
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, s.a);
    if (str1 == null)
      str1 = localTypedArray.getString(0);
    int i1 = localTypedArray.getResourceId(1, -1);
    String str2 = localTypedArray.getString(2);
    localTypedArray.recycle();
    Object localObject = null;
    if (i1 != -1)
      localObject = this.b.findFragmentById(i1);
    if ((localObject == null) && (str2 != null))
      localObject = this.b.findFragmentByTag(str2);
    if (localObject == null)
      localObject = this.b.findFragmentById(0);
    if (v.a)
      Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(i1) + " fname=" + str1 + " existing=" + localObject);
    int i2;
    if (localObject == null)
    {
      Fragment localFragment = Fragment.instantiate(this, str1);
      localFragment.o = true;
      if (i1 != 0)
      {
        i2 = i1;
        localFragment.w = i2;
        localFragment.x = 0;
        localFragment.y = str2;
        localFragment.p = true;
        localFragment.s = this.b;
        localFragment.onInflate(this, paramAttributeSet, localFragment.d);
        this.b.a(localFragment, true);
        localObject = localFragment;
      }
    }
    while (true)
    {
      if (((Fragment)localObject).I != null)
        break label443;
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      i2 = 0;
      break;
      if (((Fragment)localObject).p)
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i1) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + str1);
      ((Fragment)localObject).p = true;
      if (!((Fragment)localObject).C)
        ((Fragment)localObject).onInflate(this, paramAttributeSet, ((Fragment)localObject).d);
      this.b.b((Fragment)localObject);
    }
    label443: if (i1 != 0)
      ((Fragment)localObject).I.setId(i1);
    if (((Fragment)localObject).I.getTag() == null)
      ((Fragment)localObject).I.setTag(str2);
    return ((Fragment)localObject).I;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    a(false);
    this.b.n();
    if (this.r != null)
      this.r.g();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.b.o();
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    switch (paramInt)
    {
    default:
      return false;
    case 0:
      return this.b.a(paramMenuItem);
    case 6:
    }
    return this.b.b(paramMenuItem);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.e();
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    while (true)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.b.b(paramMenu);
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.l = false;
    if (this.a.hasMessages(2))
    {
      this.a.removeMessages(2);
      onResumeFragments();
    }
    this.b.j();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    this.a.removeMessages(2);
    onResumeFragments();
    this.b.b();
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.n)
      {
        this.n = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return super.onPreparePanel(paramInt, paramView, paramMenu) | this.b.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }

  protected void onResume()
  {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.l = true;
    this.b.b();
  }

  protected void onResumeFragments()
  {
    this.b.i();
  }

  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }

  public final Object onRetainNonConfigurationInstance()
  {
    int i1 = 0;
    if (this.c)
      a(true);
    Object localObject = onRetainCustomNonConfigurationInstance();
    ArrayList localArrayList = this.b.c();
    int i2;
    if (this.q != null)
    {
      J[] arrayOfJ = new J[this.q.size()];
      this.q.values().toArray(arrayOfJ);
      i2 = 0;
      if (i1 < arrayOfJ.length)
      {
        J localJ = arrayOfJ[i1];
        if (localJ.g)
          i2 = 1;
        while (true)
        {
          i1++;
          break;
          localJ.g();
          this.q.remove(localJ.d);
        }
      }
    }
    else
    {
      i2 = 0;
    }
    if ((localArrayList == null) && (i2 == 0) && (localObject == null))
      return null;
    t localt = new t();
    localt.b = localObject;
    localt.d = localArrayList;
    localt.e = this.q;
    return localt;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.b.d();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:fragments", localParcelable);
  }

  protected void onStart()
  {
    int i1 = 0;
    super.onStart();
    this.c = false;
    this.m = false;
    this.a.removeMessages(1);
    if (!this.k)
    {
      this.k = true;
      this.b.g();
    }
    this.b.e();
    this.b.b();
    if (!this.p)
    {
      this.p = true;
      if (this.r == null)
        break label155;
      this.r.a();
    }
    while (true)
    {
      this.o = true;
      this.b.h();
      if (this.q == null)
        break;
      J[] arrayOfJ = new J[this.q.size()];
      this.q.values().toArray(arrayOfJ);
      while (i1 < arrayOfJ.length)
      {
        J localJ = arrayOfJ[i1];
        localJ.d();
        localJ.f();
        i1++;
      }
      label155: if (!this.o)
      {
        this.r = a(null, this.p, false);
        if ((this.r != null) && (!this.r.f))
          this.r.a();
      }
    }
  }

  protected void onStop()
  {
    super.onStop();
    this.c = true;
    this.a.sendEmptyMessage(1);
    this.b.k();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0))
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, paramInt);
  }

  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
    {
      super.startActivityForResult(paramIntent, -1);
      return;
    }
    if ((0xFFFF0000 & paramInt) != 0)
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, (1 + paramFragment.f << 16) + (0xFFFF & paramInt));
  }

  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.n = true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.6.2
 */