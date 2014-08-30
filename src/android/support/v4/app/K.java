package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class K
  implements Loader.OnLoadCompleteListener<Object>
{
  final int a;
  LoaderManager.LoaderCallbacks<Object> b;
  Loader<Object> c;
  boolean d;
  boolean e;
  Object f;
  boolean g;
  boolean h;
  K i;
  private Bundle j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;

  public K(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    this.a = paramBundle;
    this.j = paramLoaderCallbacks;
    Object localObject;
    this.b = localObject;
  }

  final void a()
  {
    if ((this.k) && (this.l))
      this.g = true;
    do
    {
      do
        return;
      while (this.g);
      this.g = true;
      if (J.a)
        Log.v("LoaderManager", "  Starting: " + this);
      if ((this.c == null) && (this.b != null))
        this.c = this.b.onCreateLoader(this.a, this.j);
    }
    while (this.c == null);
    if ((this.c.getClass().isMemberClass()) && (!Modifier.isStatic(this.c.getClass().getModifiers())))
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.c);
    if (!this.n)
    {
      this.c.registerListener(this.a, this);
      this.n = true;
    }
    this.c.startLoading();
  }

  final void a(Loader<Object> paramLoader, Object paramObject)
  {
    String str2;
    if (this.b != null)
    {
      if (this.o.e == null)
        break label161;
      str2 = this.o.e.b.f;
      this.o.e.b.f = "onLoadFinished";
    }
    label161: for (String str1 = str2; ; str1 = null)
      try
      {
        if (J.a)
          Log.v("LoaderManager", "  onLoadFinished in " + paramLoader + ": " + paramLoader.dataToString(paramObject));
        this.b.onLoadFinished(paramLoader, paramObject);
        if (this.o.e != null)
          this.o.e.b.f = str1;
        this.e = true;
        return;
      }
      finally
      {
        if (this.o.e != null)
          this.o.e.b.f = str1;
      }
  }

  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    while (true)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.j);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(this.b);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.c);
      if (this.c != null)
        this.c.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      if ((this.d) || (this.e))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(this.d);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(this.e);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(this.f);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.g);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(this.h);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.m);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(this.l);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(this.n);
      if (this.i == null)
        break;
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(this.i);
      paramPrintWriter.println(":");
      this = this.i;
      paramString = paramString + "  ";
    }
  }

  final void b()
  {
    if (J.a)
      Log.v("LoaderManager", "  Retaining: " + this);
    this.k = true;
    this.l = this.g;
    this.g = false;
    this.b = null;
  }

  final void c()
  {
    if (this.k)
    {
      if (J.a)
        Log.v("LoaderManager", "  Finished Retaining: " + this);
      this.k = false;
      if ((this.g != this.l) && (!this.g))
        e();
    }
    if ((this.g) && (this.d) && (!this.h))
      a(this.c, this.f);
  }

  final void d()
  {
    if ((this.g) && (this.h))
    {
      this.h = false;
      if (this.d)
        a(this.c, this.f);
    }
  }

  final void e()
  {
    if (J.a)
      Log.v("LoaderManager", "  Stopping: " + this);
    this.g = false;
    if ((!this.k) && (this.c != null) && (this.n))
    {
      this.n = false;
      this.c.unregisterListener(this);
      this.c.stopLoading();
    }
  }

  final void f()
  {
    if (J.a)
      Log.v("LoaderManager", "  Destroying: " + this);
    this.m = true;
    boolean bool = this.e;
    this.e = false;
    String str1;
    if ((this.b != null) && (this.c != null) && (this.d) && (bool))
    {
      if (J.a)
        Log.v("LoaderManager", "  Reseting: " + this);
      if (this.o.e == null)
        break label268;
      String str2 = this.o.e.b.f;
      this.o.e.b.f = "onLoaderReset";
      str1 = str2;
    }
    while (true)
      label268: 
      try
      {
        this.b.onLoaderReset(this.c);
        if (this.o.e != null)
          this.o.e.b.f = str1;
        this.b = null;
        this.f = null;
        this.d = false;
        if (this.c != null)
        {
          if (this.n)
          {
            this.n = false;
            this.c.unregisterListener(this);
          }
          this.c.reset();
        }
        if (this.i != null)
          this = this.i;
      }
      finally
      {
        if (this.o.e != null)
          this.o.e.b.f = str1;
      }
  }

  public final void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
  {
    if (J.a)
      Log.v("LoaderManager", "onLoadComplete: " + this);
    if (this.m)
      if (J.a)
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
    do
    {
      do
      {
        return;
        if (this.o.b.get(this.a) == this)
          break;
      }
      while (!J.a);
      Log.v("LoaderManager", "  Ignoring load complete -- not active");
      return;
      K localK1 = this.i;
      if (localK1 != null)
      {
        if (J.a)
          Log.v("LoaderManager", "  Switching to pending loader: " + localK1);
        this.i = null;
        this.o.b.put(this.a, null);
        f();
        this.o.a(localK1);
        return;
      }
      if ((this.f != paramObject) || (!this.d))
      {
        this.f = paramObject;
        this.d = true;
        if (this.g)
          a(paramLoader, paramObject);
      }
      K localK2 = (K)this.o.c.get(this.a);
      if ((localK2 != null) && (localK2 != this))
      {
        localK2.e = false;
        localK2.f();
        this.o.c.remove(this.a);
      }
    }
    while ((this.o.e == null) || (this.o.hasRunningLoaders()));
    this.o.e.b.a();
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.c, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.K
 * JD-Core Version:    0.6.2
 */