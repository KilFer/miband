package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class c
{
  final ImageLoaderConfiguration a;
  private Executor b;
  private Executor c;
  private Executor d;
  private final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
  private final Map<String, ReentrantLock> f = new WeakHashMap();
  private final AtomicBoolean g = new AtomicBoolean(false);
  private final AtomicBoolean h = new AtomicBoolean(false);
  private final AtomicBoolean i = new AtomicBoolean(false);
  private final Object j = new Object();

  c(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    this.a = paramImageLoaderConfiguration;
    this.b = paramImageLoaderConfiguration.e;
    this.c = paramImageLoaderConfiguration.f;
    this.d = DefaultConfigurationFactory.createTaskDistributor();
  }

  private void h()
  {
    if ((!this.a.g) && (((ExecutorService)this.b).isShutdown()))
      this.b = i();
    if ((!this.a.h) && (((ExecutorService)this.c).isShutdown()))
      this.c = i();
  }

  private Executor i()
  {
    return DefaultConfigurationFactory.createExecutor(this.a.i, this.a.j, this.a.k);
  }

  String a(ImageAware paramImageAware)
  {
    return (String)this.e.get(Integer.valueOf(paramImageAware.getId()));
  }

  ReentrantLock a(String paramString)
  {
    ReentrantLock localReentrantLock = (ReentrantLock)this.f.get(paramString);
    if (localReentrantLock == null)
    {
      localReentrantLock = new ReentrantLock();
      this.f.put(paramString, localReentrantLock);
    }
    return localReentrantLock;
  }

  void a()
  {
    this.g.set(true);
  }

  void a(ImageAware paramImageAware, String paramString)
  {
    this.e.put(Integer.valueOf(paramImageAware.getId()), paramString);
  }

  void a(l paraml)
  {
    this.d.execute(new j(this, paraml));
  }

  void a(q paramq)
  {
    h();
    this.c.execute(paramq);
  }

  void a(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }

  void a(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }

  void b()
  {
    this.g.set(false);
    synchronized (this.j)
    {
      this.j.notifyAll();
      return;
    }
  }

  void b(ImageAware paramImageAware)
  {
    this.e.remove(Integer.valueOf(paramImageAware.getId()));
  }

  void b(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }

  void c()
  {
    if (!this.a.g)
      ((ExecutorService)this.b).shutdownNow();
    if (!this.a.h)
      ((ExecutorService)this.c).shutdownNow();
    this.e.clear();
    this.f.clear();
  }

  AtomicBoolean d()
  {
    return this.g;
  }

  Object e()
  {
    return this.j;
  }

  boolean f()
  {
    return this.h.get();
  }

  boolean g()
  {
    return this.i.get();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.c
 * JD-Core Version:    0.6.2
 */