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

final class i
{
  private ImageLoaderConfiguration a;
  private Executor b;
  private Executor c;
  private Executor d;
  private final Map<Integer, String> e;
  private final Map<String, ReentrantLock> f;
  private final AtomicBoolean g;
  private final AtomicBoolean h;
  private final AtomicBoolean i;
  private final Object j;

  i(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    this.e = Collections.synchronizedMap(new HashMap());
    this.f = new WeakHashMap();
    this.g = new AtomicBoolean(false);
    this.h = new AtomicBoolean(false);
    this.i = new AtomicBoolean(false);
    this.j = new Object();
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

  final String a(ImageAware paramImageAware)
  {
    return (String)this.e.get(Integer.valueOf(paramImageAware.getId()));
  }

  final ReentrantLock a(String paramString)
  {
    ReentrantLock localReentrantLock = (ReentrantLock)this.f.get(paramString);
    if (localReentrantLock == null)
    {
      localReentrantLock = new ReentrantLock();
      this.f.put(paramString, localReentrantLock);
    }
    return localReentrantLock;
  }

  final void a()
  {
    this.g.set(true);
  }

  final void a(ImageAware paramImageAware, String paramString)
  {
    this.e.put(Integer.valueOf(paramImageAware.getId()), paramString);
  }

  final void a(l paraml)
  {
    this.d.execute(new j(this, paraml));
  }

  final void a(q paramq)
  {
    h();
    this.c.execute(paramq);
  }

  final void a(Runnable paramRunnable)
  {
    this.d.execute(paramRunnable);
  }

  final void a(boolean paramBoolean)
  {
    this.h.set(paramBoolean);
  }

  final void b()
  {
    this.g.set(false);
    synchronized (this.j)
    {
      this.j.notifyAll();
      return;
    }
  }

  final void b(ImageAware paramImageAware)
  {
    this.e.remove(Integer.valueOf(paramImageAware.getId()));
  }

  final void b(boolean paramBoolean)
  {
    this.i.set(paramBoolean);
  }

  final void c()
  {
    if (!this.a.g)
      ((ExecutorService)this.b).shutdownNow();
    if (!this.a.h)
      ((ExecutorService)this.c).shutdownNow();
    this.e.clear();
    this.f.clear();
  }

  final AtomicBoolean d()
  {
    return this.g;
  }

  final Object e()
  {
    return this.j;
  }

  final boolean f()
  {
    return this.h.get();
  }

  final boolean g()
  {
    return this.i.get();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.i
 * JD-Core Version:    0.6.2
 */