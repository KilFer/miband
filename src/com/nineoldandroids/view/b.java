package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class b extends ViewPropertyAnimator
{
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 4;
  private static final int o = 8;
  private static final int p = 16;
  private static final int q = 32;
  private static final int r = 64;
  private static final int s = 128;
  private static final int t = 256;
  private static final int u = 512;
  private static final int v = 511;
  private final WeakReference<View> a;
  private long b;
  private boolean c = false;
  private long d = 0L;
  private boolean e = false;
  private Interpolator f;
  private boolean g = false;
  private Animator.AnimatorListener h = null;
  private d i = new d(this, (byte)0);
  private ArrayList<a> j = new ArrayList();
  private Runnable w = new c(this);
  private HashMap<Animator, f> x = new HashMap();

  b(View paramView)
  {
    this.a = new WeakReference(paramView);
  }

  private float a(int paramInt)
  {
    View localView = (View)this.a.get();
    if (localView != null);
    switch (paramInt)
    {
    default:
      return 0.0F;
    case 1:
      return localView.getTranslationX();
    case 2:
      return localView.getTranslationY();
    case 16:
      return localView.getRotation();
    case 32:
      return localView.getRotationX();
    case 64:
      return localView.getRotationY();
    case 4:
      return localView.getScaleX();
    case 8:
      return localView.getScaleY();
    case 128:
      return localView.getX();
    case 256:
      return localView.getY();
    case 512:
    }
    return localView.getAlpha();
  }

  private void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.j.clone();
    this.j.clear();
    int i1 = localArrayList.size();
    int i2 = 0;
    int i3 = 0;
    while (true)
    {
      if (i2 >= i1)
      {
        this.x.put(localValueAnimator, new f(i3, localArrayList));
        localValueAnimator.addUpdateListener(this.i);
        localValueAnimator.addListener(this.i);
        if (this.e)
          localValueAnimator.setStartDelay(this.d);
        if (this.c)
          localValueAnimator.setDuration(this.b);
        if (this.g)
          localValueAnimator.setInterpolator(this.f);
        localValueAnimator.start();
        return;
      }
      i3 |= ((a)localArrayList.get(i2)).a;
      i2++;
    }
  }

  private void a(int paramInt, float paramFloat)
  {
    float f1 = a(paramInt);
    a(paramInt, f1, paramFloat - f1);
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Iterator localIterator;
    if (this.x.size() > 0)
    {
      localIterator = this.x.keySet().iterator();
      if (localIterator.hasNext())
        break label107;
      localAnimator = null;
      if (localAnimator != null)
        localAnimator.cancel();
    }
    a locala = new a(paramInt, paramFloat1, paramFloat2);
    this.j.add(locala);
    View localView = (View)this.a.get();
    if (localView != null)
    {
      localView.removeCallbacks(this.w);
      localView.post(this.w);
    }
    return;
    label107: Animator localAnimator = (Animator)localIterator.next();
    f localf = (f)this.x.get(localAnimator);
    int i2;
    if (((paramInt & localf.a) != 0) && (localf.b != null))
      i2 = localf.b.size();
    label239: label241: for (int i3 = 0; ; i3++)
    {
      if (i3 >= i2);
      for (int i1 = 0; ; i1 = 1)
      {
        if ((i1 == 0) || (localf.a != 0))
          break label239;
        break;
        if (((a)localf.b.get(i3)).a != paramInt)
          break label241;
        localf.b.remove(i3);
        localf.a &= (paramInt ^ 0xFFFFFFFF);
      }
      break;
    }
  }

  private void b(int paramInt, float paramFloat)
  {
    a(paramInt, a(paramInt), paramFloat);
  }

  private void c(int paramInt, float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null);
    switch (paramInt)
    {
    default:
      return;
    case 1:
      localView.setTranslationX(paramFloat);
      return;
    case 2:
      localView.setTranslationY(paramFloat);
      return;
    case 16:
      localView.setRotation(paramFloat);
      return;
    case 32:
      localView.setRotationX(paramFloat);
      return;
    case 64:
      localView.setRotationY(paramFloat);
      return;
    case 4:
      localView.setScaleX(paramFloat);
      return;
    case 8:
      localView.setScaleY(paramFloat);
      return;
    case 128:
      localView.setX(paramFloat);
      return;
    case 256:
      localView.setY(paramFloat);
      return;
    case 512:
    }
    localView.setAlpha(paramFloat);
  }

  public final ViewPropertyAnimator alpha(float paramFloat)
  {
    a(512, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator alphaBy(float paramFloat)
  {
    b(512, paramFloat);
    return this;
  }

  public final void cancel()
  {
    Iterator localIterator;
    if (this.x.size() > 0)
      localIterator = ((HashMap)this.x.clone()).keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.j.clear();
        View localView = (View)this.a.get();
        if (localView != null)
          localView.removeCallbacks(this.w);
        return;
      }
      ((Animator)localIterator.next()).cancel();
    }
  }

  public final long getDuration()
  {
    if (this.c)
      return this.b;
    return new ValueAnimator().getDuration();
  }

  public final long getStartDelay()
  {
    if (this.e)
      return this.d;
    return 0L;
  }

  public final ViewPropertyAnimator rotation(float paramFloat)
  {
    a(16, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationBy(float paramFloat)
  {
    b(16, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationX(float paramFloat)
  {
    a(32, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    b(32, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationY(float paramFloat)
  {
    a(64, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    b(64, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleX(float paramFloat)
  {
    a(4, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    b(4, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleY(float paramFloat)
  {
    a(8, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    b(8, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator setDuration(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.c = true;
    this.b = paramLong;
    return this;
  }

  public final ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.g = true;
    this.f = paramInterpolator;
    return this;
  }

  public final ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.h = paramAnimatorListener;
    return this;
  }

  public final ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.e = true;
    this.d = paramLong;
    return this;
  }

  public final void start()
  {
    a();
  }

  public final ViewPropertyAnimator translationX(float paramFloat)
  {
    a(1, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationXBy(float paramFloat)
  {
    b(1, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationY(float paramFloat)
  {
    a(2, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationYBy(float paramFloat)
  {
    b(2, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator x(float paramFloat)
  {
    a(128, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator xBy(float paramFloat)
  {
    b(128, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator y(float paramFloat)
  {
    a(256, paramFloat);
    return this;
  }

  public final ViewPropertyAnimator yBy(float paramFloat)
  {
    b(256, paramFloat);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.b
 * JD-Core Version:    0.6.2
 */