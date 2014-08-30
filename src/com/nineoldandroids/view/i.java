package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class i extends ViewPropertyAnimator
{
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 4;
  private static final int p = 8;
  private static final int q = 16;
  private static final int r = 32;
  private static final int s = 64;
  private static final int t = 128;
  private static final int u = 256;
  private static final int v = 512;
  private static final int w = 511;
  private final AnimatorProxy a;
  private final WeakReference<View> b;
  private long c;
  private boolean d = false;
  private long e = 0L;
  private boolean f = false;
  private Interpolator g;
  private boolean h = false;
  private Animator.AnimatorListener i = null;
  private k j = new k(this, (byte)0);
  private ArrayList<l> k = new ArrayList();
  private Runnable x = new j(this);
  private HashMap<Animator, m> y = new HashMap();

  i(View paramView)
  {
    this.b = new WeakReference(paramView);
    this.a = AnimatorProxy.wrap(paramView);
  }

  private float a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0.0F;
    case 1:
      return this.a.getTranslationX();
    case 2:
      return this.a.getTranslationY();
    case 16:
      return this.a.getRotation();
    case 32:
      return this.a.getRotationX();
    case 64:
      return this.a.getRotationY();
    case 4:
      return this.a.getScaleX();
    case 8:
      return this.a.getScaleY();
    case 128:
      return this.a.getX();
    case 256:
      return this.a.getY();
    case 512:
    }
    return this.a.getAlpha();
  }

  private void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.k.clone();
    this.k.clear();
    int i1 = localArrayList.size();
    int i2 = 0;
    int i3 = 0;
    while (true)
    {
      if (i2 >= i1)
      {
        this.y.put(localValueAnimator, new m(i3, localArrayList));
        localValueAnimator.addUpdateListener(this.j);
        localValueAnimator.addListener(this.j);
        if (this.f)
          localValueAnimator.setStartDelay(this.e);
        if (this.d)
          localValueAnimator.setDuration(this.c);
        if (this.h)
          localValueAnimator.setInterpolator(this.g);
        localValueAnimator.start();
        return;
      }
      i3 |= ((l)localArrayList.get(i2)).a;
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
    if (this.y.size() > 0)
    {
      localIterator = this.y.keySet().iterator();
      if (localIterator.hasNext())
        break label107;
      localAnimator = null;
      if (localAnimator != null)
        localAnimator.cancel();
    }
    l locall = new l(paramInt, paramFloat1, paramFloat2);
    this.k.add(locall);
    View localView = (View)this.b.get();
    if (localView != null)
    {
      localView.removeCallbacks(this.x);
      localView.post(this.x);
    }
    return;
    label107: Animator localAnimator = (Animator)localIterator.next();
    m localm = (m)this.y.get(localAnimator);
    int i2;
    if (((paramInt & localm.a) != 0) && (localm.b != null))
      i2 = localm.b.size();
    label239: label241: for (int i3 = 0; ; i3++)
    {
      if (i3 >= i2);
      for (int i1 = 0; ; i1 = 1)
      {
        if ((i1 == 0) || (localm.a != 0))
          break label239;
        break;
        if (((l)localm.b.get(i3)).a != paramInt)
          break label241;
        localm.b.remove(i3);
        localm.a &= (paramInt ^ 0xFFFFFFFF);
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
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.a.setTranslationX(paramFloat);
      return;
    case 2:
      this.a.setTranslationY(paramFloat);
      return;
    case 16:
      this.a.setRotation(paramFloat);
      return;
    case 32:
      this.a.setRotationX(paramFloat);
      return;
    case 64:
      this.a.setRotationY(paramFloat);
      return;
    case 4:
      this.a.setScaleX(paramFloat);
      return;
    case 8:
      this.a.setScaleY(paramFloat);
      return;
    case 128:
      this.a.setX(paramFloat);
      return;
    case 256:
      this.a.setY(paramFloat);
      return;
    case 512:
    }
    this.a.setAlpha(paramFloat);
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
    if (this.y.size() > 0)
      localIterator = ((HashMap)this.y.clone()).keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.k.clear();
        View localView = (View)this.b.get();
        if (localView != null)
          localView.removeCallbacks(this.x);
        return;
      }
      ((Animator)localIterator.next()).cancel();
    }
  }

  public final long getDuration()
  {
    if (this.d)
      return this.c;
    return new ValueAnimator().getDuration();
  }

  public final long getStartDelay()
  {
    if (this.f)
      return this.e;
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
    this.d = true;
    this.c = paramLong;
    return this;
  }

  public final ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.h = true;
    this.g = paramInterpolator;
    return this;
  }

  public final ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.i = paramAnimatorListener;
    return this;
  }

  public final ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.f = true;
    this.e = paramLong;
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
 * Qualified Name:     com.nineoldandroids.view.i
 * JD-Core Version:    0.6.2
 */