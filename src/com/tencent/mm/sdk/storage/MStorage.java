package com.tencent.mm.sdk.storage;

import android.os.Looper;

public abstract class MStorage
{
  private final MStorageEvent<MStorage.IOnStorageChange, String> a = new C(this);
  private final MStorageEvent<MStorage.IOnStorageLoaded, String> b = new D(this);

  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.a.add(paramIOnStorageChange, Looper.getMainLooper());
  }

  public void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.b.add(paramIOnStorageLoaded, Looper.getMainLooper());
  }

  public void doNotify()
  {
    this.a.event("*");
    this.a.doNotify();
  }

  public void doNotify(String paramString)
  {
    this.a.event(paramString);
    this.a.doNotify();
  }

  public void lock()
  {
    this.a.lock();
  }

  public void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.a.remove(paramIOnStorageChange);
  }

  public void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.b.remove(paramIOnStorageLoaded);
  }

  public void unlock()
  {
    this.a.unlock();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorage
 * JD-Core Version:    0.6.2
 */