package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator
{
  boolean b = false;
  private ArrayList<Animator> c = new ArrayList();
  private HashMap<Animator, e> d = new HashMap();
  private ArrayList<e> e = new ArrayList();
  private ArrayList<e> f = new ArrayList();
  private boolean g = true;
  private b h = null;
  private boolean i = false;
  private long j = 0L;
  private ValueAnimator k = null;
  private long l = -1L;

  private void a()
  {
    if (this.g)
    {
      this.f.clear();
      ArrayList localArrayList1 = new ArrayList();
      int i3 = this.e.size();
      int i4 = 0;
      ArrayList localArrayList2;
      if (i4 >= i3)
        localArrayList2 = new ArrayList();
      int i6;
      while (true)
      {
        if (localArrayList1.size() <= 0)
        {
          this.g = false;
          if (this.f.size() == this.e.size())
            break label298;
          throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
          e locale4 = (e)this.e.get(i4);
          if ((locale4.b == null) || (locale4.b.size() == 0))
            localArrayList1.add(locale4);
          i4++;
          break;
        }
        int i5 = localArrayList1.size();
        i6 = 0;
        if (i6 < i5)
          break label176;
        localArrayList1.clear();
        localArrayList1.addAll(localArrayList2);
        localArrayList2.clear();
      }
      label176: e locale2 = (e)localArrayList1.get(i6);
      this.f.add(locale2);
      int i7;
      if (locale2.e != null)
        i7 = locale2.e.size();
      for (int i8 = 0; ; i8++)
      {
        if (i8 >= i7)
        {
          i6++;
          break;
        }
        e locale3 = (e)locale2.e.get(i8);
        locale3.d.remove(locale2);
        if (locale3.d.size() == 0)
          localArrayList2.add(locale3);
      }
    }
    int m = this.e.size();
    int n = 0;
    if (n >= m)
      label298: return;
    e locale1 = (e)this.e.get(n);
    int i1;
    if ((locale1.b != null) && (locale1.b.size() > 0))
      i1 = locale1.b.size();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        locale1.f = false;
        n++;
        break;
      }
      c localc = (c)locale1.b.get(i2);
      if (locale1.d == null)
        locale1.d = new ArrayList();
      if (!locale1.d.contains(localc.a))
        locale1.d.add(localc.a);
    }
  }

  public final void cancel()
  {
    this.b = true;
    ArrayList localArrayList2;
    Iterator localIterator3;
    if (isStarted())
    {
      if (this.a == null)
        break label181;
      localArrayList2 = (ArrayList)this.a.clone();
      localIterator3 = localArrayList2.iterator();
      if (localIterator3.hasNext())
        break label99;
    }
    label181: for (ArrayList localArrayList1 = localArrayList2; ; localArrayList1 = null)
    {
      label75: Iterator localIterator2;
      if ((this.k != null) && (this.k.isRunning()))
      {
        this.k.cancel();
        if (localArrayList1 != null)
          localIterator2 = localArrayList1.iterator();
      }
      while (true)
      {
        if (!localIterator2.hasNext())
        {
          this.i = false;
          return;
          label99: ((Animator.AnimatorListener)localIterator3.next()).onAnimationCancel(this);
          break;
          if (this.f.size() <= 0)
            break label75;
          Iterator localIterator1 = this.f.iterator();
          while (localIterator1.hasNext())
            ((e)localIterator1.next()).a.cancel();
          break label75;
        }
        ((Animator.AnimatorListener)localIterator2.next()).onAnimationEnd(this);
      }
    }
  }

  public final AnimatorSet clone()
  {
    AnimatorSet localAnimatorSet = (AnimatorSet)super.clone();
    localAnimatorSet.g = true;
    localAnimatorSet.b = false;
    localAnimatorSet.i = false;
    localAnimatorSet.c = new ArrayList();
    localAnimatorSet.d = new HashMap();
    localAnimatorSet.e = new ArrayList();
    localAnimatorSet.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.e.iterator();
    Iterator localIterator4;
    if (!localIterator1.hasNext())
      localIterator4 = this.e.iterator();
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        return localAnimatorSet;
        e locale1 = (e)localIterator1.next();
        e locale2 = locale1.a();
        localHashMap.put(locale1, locale2);
        localAnimatorSet.e.add(locale2);
        localAnimatorSet.d.put(locale2.a, locale2);
        locale2.b = null;
        locale2.c = null;
        locale2.e = null;
        locale2.d = null;
        ArrayList localArrayList1 = locale2.a.getListeners();
        if (localArrayList1 == null)
          break;
        Iterator localIterator2 = localArrayList1.iterator();
        ArrayList localArrayList2 = null;
        while (true)
        {
          if (!localIterator2.hasNext())
          {
            if (localArrayList2 == null)
              break;
            Iterator localIterator3 = localArrayList2.iterator();
            while (localIterator3.hasNext())
              localArrayList1.remove((Animator.AnimatorListener)localIterator3.next());
            break;
          }
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator2.next();
          if ((localAnimatorListener instanceof b))
          {
            if (localArrayList2 == null)
              localArrayList2 = new ArrayList();
            localArrayList2.add(localAnimatorListener);
          }
        }
      }
      e locale3 = (e)localIterator4.next();
      e locale4 = (e)localHashMap.get(locale3);
      if (locale3.b != null)
      {
        Iterator localIterator5 = locale3.b.iterator();
        while (localIterator5.hasNext())
        {
          c localc = (c)localIterator5.next();
          locale4.a(new c((e)localHashMap.get(localc.a), localc.b));
        }
      }
    }
  }

  public final void end()
  {
    this.b = true;
    Iterator localIterator3;
    Iterator localIterator2;
    label82: Iterator localIterator1;
    if (isStarted())
    {
      if (this.f.size() != this.e.size())
      {
        a();
        localIterator3 = this.f.iterator();
        if (localIterator3.hasNext())
          break label127;
      }
      if (this.k != null)
        this.k.cancel();
      if (this.f.size() > 0)
      {
        localIterator2 = this.f.iterator();
        if (localIterator2.hasNext())
          break label173;
      }
      if (this.a != null)
        localIterator1 = ((ArrayList)this.a.clone()).iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        this.i = false;
        return;
        label127: e locale = (e)localIterator3.next();
        if (this.h == null)
          this.h = new b(this, this);
        locale.a.addListener(this.h);
        break;
        label173: ((e)localIterator2.next()).a.end();
        break label82;
      }
      ((Animator.AnimatorListener)localIterator1.next()).onAnimationEnd(this);
    }
  }

  public final ArrayList<Animator> getChildAnimations()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      localArrayList.add(((e)localIterator.next()).a);
    }
  }

  public final long getDuration()
  {
    return this.l;
  }

  public final long getStartDelay()
  {
    return this.j;
  }

  public final boolean isRunning()
  {
    Iterator localIterator = this.e.iterator();
    do
      if (!localIterator.hasNext())
        return false;
    while (!((e)localIterator.next()).a.isRunning());
    return true;
  }

  public final boolean isStarted()
  {
    return this.i;
  }

  public final AnimatorSet.Builder play(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      this.g = true;
      return new AnimatorSet.Builder(this, paramAnimator);
    }
    return null;
  }

  public final void playSequentially(List<Animator> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.g = true;
      if (paramList.size() != 1)
        break label44;
      play((Animator)paramList.get(0));
    }
    while (true)
    {
      return;
      label44: for (int m = 0; m < -1 + paramList.size(); m++)
        play((Animator)paramList.get(m)).before((Animator)paramList.get(m + 1));
    }
  }

  public final void playSequentially(Animator[] paramArrayOfAnimator)
  {
    int n;
    if (paramArrayOfAnimator != null)
    {
      this.g = true;
      int m = paramArrayOfAnimator.length;
      n = 0;
      if (m == 1)
        play(paramArrayOfAnimator[0]);
    }
    else
    {
      return;
    }
    while (n < -1 + paramArrayOfAnimator.length)
    {
      play(paramArrayOfAnimator[n]).before(paramArrayOfAnimator[(n + 1)]);
      n++;
    }
  }

  public final void playTogether(Collection<Animator> paramCollection)
  {
    Iterator localIterator;
    AnimatorSet.Builder localBuilder;
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.g = true;
      localIterator = paramCollection.iterator();
      localBuilder = null;
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Animator localAnimator = (Animator)localIterator.next();
      if (localBuilder == null)
        localBuilder = play(localAnimator);
      else
        localBuilder.with(localAnimator);
    }
  }

  public final void playTogether(Animator[] paramArrayOfAnimator)
  {
    int m = 1;
    AnimatorSet.Builder localBuilder;
    if (paramArrayOfAnimator != null)
    {
      this.g = m;
      localBuilder = play(paramArrayOfAnimator[0]);
    }
    while (true)
    {
      if (m >= paramArrayOfAnimator.length)
        return;
      localBuilder.with(paramArrayOfAnimator[m]);
      m++;
    }
  }

  public final AnimatorSet setDuration(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.l = paramLong;
        return this;
      }
      ((e)localIterator.next()).a.setDuration(paramLong);
    }
  }

  public final void setInterpolator(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((e)localIterator.next()).a.setInterpolator(paramInterpolator);
    }
  }

  public final void setStartDelay(long paramLong)
  {
    this.j = paramLong;
  }

  public final void setTarget(Object paramObject)
  {
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Animator localAnimator = ((e)localIterator.next()).a;
      if ((localAnimator instanceof AnimatorSet))
        ((AnimatorSet)localAnimator).setTarget(paramObject);
      else if ((localAnimator instanceof ObjectAnimator))
        ((ObjectAnimator)localAnimator).setTarget(paramObject);
    }
  }

  public final void setupEndValues()
  {
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((e)localIterator.next()).a.setupEndValues();
    }
  }

  public final void setupStartValues()
  {
    Iterator localIterator = this.e.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((e)localIterator.next()).a.setupStartValues();
    }
  }

  public final void start()
  {
    int m = 0;
    this.b = false;
    this.i = true;
    a();
    int n = this.f.size();
    int i1 = 0;
    ArrayList localArrayList1;
    int i2;
    label43: Iterator localIterator1;
    label65: label75: ArrayList localArrayList3;
    int i7;
    label104: ArrayList localArrayList2;
    int i5;
    if (i1 >= n)
    {
      localArrayList1 = new ArrayList();
      i2 = 0;
      if (i2 < n)
        break label275;
      if (this.j > 0L)
        break label476;
      localIterator1 = localArrayList1.iterator();
      if (localIterator1.hasNext())
        break label440;
      if (this.a != null)
      {
        localArrayList3 = (ArrayList)this.a.clone();
        int i6 = localArrayList3.size();
        i7 = 0;
        if (i7 < i6)
          break label533;
      }
      if ((this.e.size() == 0) && (this.j == 0L))
      {
        this.i = false;
        if (this.a != null)
        {
          localArrayList2 = (ArrayList)this.a.clone();
          i5 = localArrayList2.size();
        }
      }
    }
    while (true)
    {
      if (m >= i5)
      {
        return;
        e locale3 = (e)this.f.get(i1);
        ArrayList localArrayList4 = locale3.a.getListeners();
        Iterator localIterator2;
        if ((localArrayList4 != null) && (localArrayList4.size() > 0))
          localIterator2 = new ArrayList(localArrayList4).iterator();
        while (true)
        {
          if (!localIterator2.hasNext())
          {
            i1++;
            break;
          }
          Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator2.next();
          if (((localAnimatorListener instanceof d)) || ((localAnimatorListener instanceof b)))
            locale3.a.removeListener(localAnimatorListener);
        }
        label275: e locale1 = (e)this.f.get(i2);
        if (this.h == null)
          this.h = new b(this, this);
        if ((locale1.b == null) || (locale1.b.size() == 0))
        {
          localArrayList1.add(locale1);
          locale1.a.addListener(this.h);
          i2++;
          break label43;
        }
        int i3 = locale1.b.size();
        for (int i4 = 0; ; i4++)
        {
          if (i4 >= i3)
          {
            locale1.c = ((ArrayList)locale1.b.clone());
            break;
          }
          c localc = (c)locale1.b.get(i4);
          localc.a.a.addListener(new d(this, locale1, localc.b));
        }
        label440: e locale2 = (e)localIterator1.next();
        locale2.a.start();
        this.c.add(locale2.a);
        break label65;
        label476: this.k = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.k.setDuration(this.j);
        this.k.addListener(new a(this, localArrayList1));
        this.k.start();
        break label75;
        label533: ((Animator.AnimatorListener)localArrayList3.get(i7)).onAnimationStart(this);
        i7++;
        break label104;
      }
      ((Animator.AnimatorListener)localArrayList2.get(m)).onAnimationEnd(this);
      m++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet
 * JD-Core Version:    0.6.2
 */