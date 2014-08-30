package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class J extends LoaderManager
{
  static boolean a = false;
  private static String h = "LoaderManager";
  final SparseArrayCompat<K> b = new SparseArrayCompat();
  final SparseArrayCompat<K> c = new SparseArrayCompat();
  final String d;
  FragmentActivity e;
  boolean f;
  boolean g;
  private boolean i;
  private boolean j;

  J(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.d = paramString;
    this.e = paramFragmentActivity;
    this.f = paramBoolean;
  }

  private K a(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    K localK = new K(this, paramInt, paramBundle, paramLoaderCallbacks);
    localK.c = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localK;
  }

  private K b(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.j = true;
      K localK = a(paramInt, paramBundle, paramLoaderCallbacks);
      a(localK);
      return localK;
    }
    finally
    {
      this.j = false;
    }
  }

  final void a()
  {
    if (a)
      Log.v("LoaderManager", "Starting in " + this);
    if (this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.f = true;
      for (int k = -1 + this.b.size(); k >= 0; k--)
        ((K)this.b.valueAt(k)).a();
    }
  }

  final void a(FragmentActivity paramFragmentActivity)
  {
    this.e = paramFragmentActivity;
  }

  final void a(K paramK)
  {
    this.b.put(paramK.a, paramK);
    if (this.f)
      paramK.a();
  }

  final void b()
  {
    if (a)
      Log.v("LoaderManager", "Stopping in " + this);
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    for (int k = -1 + this.b.size(); k >= 0; k--)
      ((K)this.b.valueAt(k)).e();
    this.f = false;
  }

  final void c()
  {
    if (a)
      Log.v("LoaderManager", "Retaining in " + this);
    if (!this.f)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.g = true;
      this.f = false;
      for (int k = -1 + this.b.size(); k >= 0; k--)
        ((K)this.b.valueAt(k)).b();
    }
  }

  final void d()
  {
    if (this.g)
    {
      if (a)
        Log.v("LoaderManager", "Finished Retaining in " + this);
      this.g = false;
      for (int k = -1 + this.b.size(); k >= 0; k--)
        ((K)this.b.valueAt(k)).c();
    }
  }

  public final void destroyLoader(int paramInt)
  {
    if (this.j)
      throw new IllegalStateException("Called while creating a loader");
    if (a)
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    int k = this.b.indexOfKey(paramInt);
    if (k >= 0)
    {
      K localK2 = (K)this.b.valueAt(k);
      this.b.removeAt(k);
      localK2.f();
    }
    int m = this.c.indexOfKey(paramInt);
    if (m >= 0)
    {
      K localK1 = (K)this.c.valueAt(m);
      this.c.removeAt(m);
      localK1.f();
    }
    if ((this.e != null) && (!hasRunningLoaders()))
      this.e.b.a();
  }

  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int k = 0;
    if (this.b.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      String str2 = paramString + "    ";
      for (int m = 0; m < this.b.size(); m++)
      {
        K localK2 = (K)this.b.valueAt(m);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.keyAt(m));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localK2.toString());
        localK2.a(str2, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    if (this.c.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      String str1 = paramString + "    ";
      while (k < this.c.size())
      {
        K localK1 = (K)this.c.valueAt(k);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.keyAt(k));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localK1.toString());
        localK1.a(str1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        k++;
      }
    }
  }

  final void e()
  {
    for (int k = -1 + this.b.size(); k >= 0; k--)
      ((K)this.b.valueAt(k)).h = true;
  }

  final void f()
  {
    for (int k = -1 + this.b.size(); k >= 0; k--)
      ((K)this.b.valueAt(k)).d();
  }

  final void g()
  {
    if (!this.g)
    {
      if (a)
        Log.v("LoaderManager", "Destroying Active in " + this);
      for (int m = -1 + this.b.size(); m >= 0; m--)
        ((K)this.b.valueAt(m)).f();
      this.b.clear();
    }
    if (a)
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    for (int k = -1 + this.c.size(); k >= 0; k--)
      ((K)this.c.valueAt(k)).f();
    this.c.clear();
  }

  public final <D> Loader<D> getLoader(int paramInt)
  {
    if (this.j)
      throw new IllegalStateException("Called while creating a loader");
    K localK = (K)this.b.get(paramInt);
    if (localK != null)
    {
      if (localK.i != null)
        return localK.i.c;
      return localK.c;
    }
    return null;
  }

  public final boolean hasRunningLoaders()
  {
    int k = this.b.size();
    int m = 0;
    boolean bool1 = false;
    if (m < k)
    {
      K localK = (K)this.b.valueAt(m);
      if ((localK.g) && (!localK.e));
      for (boolean bool2 = true; ; bool2 = false)
      {
        bool1 |= bool2;
        m++;
        break;
      }
    }
    return bool1;
  }

  public final <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.j)
      throw new IllegalStateException("Called while creating a loader");
    K localK = (K)this.b.get(paramInt);
    if (a)
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    if (localK == null)
    {
      localK = b(paramInt, paramBundle, paramLoaderCallbacks);
      if (a)
        Log.v("LoaderManager", "  Created new loader " + localK);
    }
    while (true)
    {
      if ((localK.d) && (this.f))
        localK.a(localK.c, localK.f);
      return localK.c;
      if (a)
        Log.v("LoaderManager", "  Re-using existing loader " + localK);
      localK.b = paramLoaderCallbacks;
    }
  }

  public final <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.j)
      throw new IllegalStateException("Called while creating a loader");
    K localK1 = (K)this.b.get(paramInt);
    if (a)
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    if (localK1 != null)
    {
      K localK2 = (K)this.c.get(paramInt);
      if (localK2 == null)
        break label298;
      if (!localK1.d)
        break label167;
      if (a)
        Log.v("LoaderManager", "  Removing last inactive loader: " + localK1);
      localK2.e = false;
      localK2.f();
    }
    while (true)
    {
      localK1.c.abandon();
      this.c.put(paramInt, localK1);
      while (true)
      {
        return b(paramInt, paramBundle, paramLoaderCallbacks).c;
        label167: if (localK1.g)
          break;
        if (a)
          Log.v("LoaderManager", "  Current loader is stopped; replacing");
        this.b.put(paramInt, null);
        localK1.f();
      }
      if (localK1.i != null)
      {
        if (a)
          Log.v("LoaderManager", "  Removing pending loader: " + localK1.i);
        localK1.i.f();
        localK1.i = null;
      }
      if (a)
        Log.v("LoaderManager", "  Enqueuing as new pending loader");
      localK1.i = a(paramInt, paramBundle, paramLoaderCallbacks);
      return localK1.i.c;
      label298: if (a)
        Log.v("LoaderManager", "  Making last loader inactive: " + localK1);
    }
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.e, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.J
 * JD-Core Version:    0.6.2
 */