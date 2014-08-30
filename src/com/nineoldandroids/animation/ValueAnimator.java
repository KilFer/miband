package com.nineoldandroids.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator
{
  private static long F = 0L;
  public static final int INFINITE = -1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  private static final long h = 10L;
  private static int i = 0;
  private static int j = 1;
  private static int k = 0;
  private static int l = 1;
  private static int m = 2;
  private static ThreadLocal<H> n = new ThreadLocal();
  private static final ThreadLocal<ArrayList<ValueAnimator>> o = new C();
  private static final ThreadLocal<ArrayList<ValueAnimator>> p = new D();
  private static final ThreadLocal<ArrayList<ValueAnimator>> q = new E();
  private static final ThreadLocal<ArrayList<ValueAnimator>> r = new F();
  private static final ThreadLocal<ArrayList<ValueAnimator>> s = new G();
  private static final Interpolator t = new AccelerateDecelerateInterpolator();
  private static final TypeEvaluator u;
  private static final TypeEvaluator v;
  private long A;
  private boolean B = false;
  private boolean C = false;
  private long D = 300L;
  private long E = 0L;
  private int G = 0;
  private int H = 1;
  private Interpolator I = t;
  private ArrayList<ValueAnimator.AnimatorUpdateListener> J = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  PropertyValuesHolder[] f;
  HashMap<String, PropertyValuesHolder> g;
  private boolean w = false;
  private int x = 0;
  private float y = 0.0F;
  private boolean z = false;

  static
  {
    new IntEvaluator();
    new FloatEvaluator();
  }

  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null)
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    this.w = paramBoolean;
    this.x = 0;
    this.d = 0;
    this.C = true;
    this.z = false;
    ((ArrayList)p.get()).add(this);
    ArrayList localArrayList;
    int i1;
    if (this.E == 0L)
    {
      setCurrentPlayTime(getCurrentPlayTime());
      this.d = 0;
      this.B = true;
      if (this.a != null)
      {
        localArrayList = (ArrayList)this.a.clone();
        i1 = localArrayList.size();
      }
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        H localH = (H)n.get();
        if (localH == null)
        {
          localH = new H((byte)0);
          n.set(localH);
        }
        localH.sendEmptyMessage(0);
        return;
      }
      ((Animator.AnimatorListener)localArrayList.get(i2)).onAnimationStart(this);
    }
  }

  private boolean b(long paramLong)
  {
    if (!this.z)
    {
      this.z = true;
      this.A = paramLong;
    }
    long l1;
    do
    {
      return false;
      l1 = paramLong - this.A;
    }
    while (l1 <= this.E);
    this.b = (paramLong - (l1 - this.E));
    this.d = 1;
    return true;
  }

  public static void clearAllAnimations()
  {
    ((ArrayList)o.get()).clear();
    ((ArrayList)p.get()).clear();
    ((ArrayList)q.get()).clear();
  }

  public static int getCurrentAnimationsCount()
  {
    return ((ArrayList)o.get()).size();
  }

  public static long getFrameDelay()
  {
    return F;
  }

  private void h()
  {
    ((ArrayList)o.get()).remove(this);
    ((ArrayList)p.get()).remove(this);
    ((ArrayList)q.get()).remove(this);
    this.d = 0;
    ArrayList localArrayList;
    int i1;
    if ((this.B) && (this.a != null))
    {
      localArrayList = (ArrayList)this.a.clone();
      i1 = localArrayList.size();
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        this.B = false;
        this.C = false;
        return;
      }
      ((Animator.AnimatorListener)localArrayList.get(i2)).onAnimationEnd(this);
    }
  }

  private void i()
  {
    a();
    ((ArrayList)o.get()).add(this);
    ArrayList localArrayList;
    int i1;
    if ((this.E > 0L) && (this.a != null))
    {
      localArrayList = (ArrayList)this.a.clone();
      i1 = localArrayList.size();
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return;
      ((Animator.AnimatorListener)localArrayList.get(i2)).onAnimationStart(this);
    }
  }

  public static ValueAnimator ofFloat(float[] paramArrayOfFloat)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setFloatValues(paramArrayOfFloat);
    return localValueAnimator;
  }

  public static ValueAnimator ofInt(int[] paramArrayOfInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(paramArrayOfInt);
    return localValueAnimator;
  }

  public static ValueAnimator ofObject(TypeEvaluator paramTypeEvaluator, Object[] paramArrayOfObject)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(paramArrayOfObject);
    localValueAnimator.setEvaluator(paramTypeEvaluator);
    return localValueAnimator;
  }

  public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setValues(paramArrayOfPropertyValuesHolder);
    return localValueAnimator;
  }

  public static void setFrameDelay(long paramLong)
  {
    F = paramLong;
  }

  void a()
  {
    int i1;
    if (!this.e)
      i1 = this.f.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        this.e = true;
        return;
      }
      this.f[i2].a();
    }
  }

  void a(float paramFloat)
  {
    float f1 = this.I.getInterpolation(paramFloat);
    this.y = f1;
    int i1 = this.f.length;
    int i2 = 0;
    int i3;
    if (i2 >= i1)
      if (this.J != null)
        i3 = this.J.size();
    for (int i4 = 0; ; i4++)
    {
      if (i4 >= i3)
      {
        return;
        this.f[i2].a(f1);
        i2++;
        break;
      }
      ((ValueAnimator.AnimatorUpdateListener)this.J.get(i4)).onAnimationUpdate(this);
    }
  }

  boolean a(long paramLong)
  {
    boolean bool1 = false;
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c >= 0L)
        break label58;
      this.b = paramLong;
    }
    while (true)
      switch (this.d)
      {
      default:
        return false;
        label58: this.b = (paramLong - this.c);
        this.c = -1L;
      case 1:
      case 2:
      }
    float f1;
    int i2;
    label147: boolean bool2;
    label172: float f2;
    if (this.D > 0L)
    {
      f1 = (float)(paramLong - this.b) / (float)this.D;
      if (f1 < 1.0F)
        break label279;
      if ((this.x >= this.G) && (this.G != -1))
        break label266;
      if (this.a != null)
      {
        int i1 = this.a.size();
        i2 = 0;
        if (i2 < i1)
          break label236;
      }
      if (this.H == 2)
      {
        if (!this.w)
          break label260;
        bool2 = false;
        this.w = bool2;
      }
      this.x += (int)f1;
      f2 = f1 % 1.0F;
      this.b += this.D;
    }
    while (true)
    {
      if (this.w)
        f2 = 1.0F - f2;
      a(f2);
      return bool1;
      f1 = 1.0F;
      break;
      label236: ((Animator.AnimatorListener)this.a.get(i2)).onAnimationRepeat(this);
      i2++;
      break label147;
      label260: bool2 = true;
      break label172;
      label266: f2 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      label279: f2 = f1;
      bool1 = false;
    }
  }

  public void addUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.J == null)
      this.J = new ArrayList();
    this.J.add(paramAnimatorUpdateListener);
  }

  public void cancel()
  {
    Iterator localIterator;
    if ((this.d != 0) || (((ArrayList)p.get()).contains(this)) || (((ArrayList)q.get()).contains(this)))
      if ((this.B) && (this.a != null))
        localIterator = ((ArrayList)this.a.clone()).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        h();
        return;
      }
      ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
    }
  }

  public ValueAnimator clone()
  {
    ValueAnimator localValueAnimator = (ValueAnimator)super.clone();
    ArrayList localArrayList;
    int i4;
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    int i1;
    if (this.J != null)
    {
      localArrayList = this.J;
      localValueAnimator.J = new ArrayList();
      int i3 = localArrayList.size();
      i4 = 0;
      if (i4 < i3);
    }
    else
    {
      localValueAnimator.c = -1L;
      localValueAnimator.w = false;
      localValueAnimator.x = 0;
      localValueAnimator.e = false;
      localValueAnimator.d = 0;
      localValueAnimator.z = false;
      arrayOfPropertyValuesHolder = this.f;
      if (arrayOfPropertyValuesHolder != null)
      {
        i1 = arrayOfPropertyValuesHolder.length;
        localValueAnimator.f = new PropertyValuesHolder[i1];
        localValueAnimator.g = new HashMap(i1);
      }
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        return localValueAnimator;
        localValueAnimator.J.add((ValueAnimator.AnimatorUpdateListener)localArrayList.get(i4));
        i4++;
        break;
      }
      PropertyValuesHolder localPropertyValuesHolder = arrayOfPropertyValuesHolder[i2].clone();
      localValueAnimator.f[i2] = localPropertyValuesHolder;
      localValueAnimator.g.put(localPropertyValuesHolder.getPropertyName(), localPropertyValuesHolder);
    }
  }

  public void end()
  {
    if ((!((ArrayList)o.get()).contains(this)) && (!((ArrayList)p.get()).contains(this)))
    {
      this.z = false;
      i();
      if ((this.G <= 0) || ((0x1 & this.G) != 1))
        break label82;
      a(0.0F);
    }
    while (true)
    {
      h();
      return;
      if (this.e)
        break;
      a();
      break;
      label82: a(1.0F);
    }
  }

  public float getAnimatedFraction()
  {
    return this.y;
  }

  public Object getAnimatedValue()
  {
    if ((this.f != null) && (this.f.length > 0))
      return this.f[0].b();
    return null;
  }

  public Object getAnimatedValue(String paramString)
  {
    PropertyValuesHolder localPropertyValuesHolder = (PropertyValuesHolder)this.g.get(paramString);
    if (localPropertyValuesHolder != null)
      return localPropertyValuesHolder.b();
    return null;
  }

  public long getCurrentPlayTime()
  {
    if ((!this.e) || (this.d == 0))
      return 0L;
    return AnimationUtils.currentAnimationTimeMillis() - this.b;
  }

  public long getDuration()
  {
    return this.D;
  }

  public Interpolator getInterpolator()
  {
    return this.I;
  }

  public int getRepeatCount()
  {
    return this.G;
  }

  public int getRepeatMode()
  {
    return this.H;
  }

  public long getStartDelay()
  {
    return this.E;
  }

  public PropertyValuesHolder[] getValues()
  {
    return this.f;
  }

  public boolean isRunning()
  {
    int i1 = 1;
    if ((this.d != i1) && (!this.B))
      i1 = 0;
    return i1;
  }

  public boolean isStarted()
  {
    return this.C;
  }

  public void removeAllUpdateListeners()
  {
    if (this.J == null)
      return;
    this.J.clear();
    this.J = null;
  }

  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (this.J == null);
    do
    {
      return;
      this.J.remove(paramAnimatorUpdateListener);
    }
    while (this.J.size() != 0);
    this.J = null;
  }

  public void reverse()
  {
    if (this.w);
    for (boolean bool = false; ; bool = true)
    {
      this.w = bool;
      if (this.d != 1)
        break;
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = l1 - this.b;
      this.b = (l1 - (this.D - l2));
      return;
    }
    a(true);
  }

  public void setCurrentPlayTime(long paramLong)
  {
    a();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    a(l1);
  }

  public ValueAnimator setDuration(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.D = paramLong;
    return this;
  }

  public void setEvaluator(TypeEvaluator paramTypeEvaluator)
  {
    if ((paramTypeEvaluator != null) && (this.f != null) && (this.f.length > 0))
      this.f[0].setEvaluator(paramTypeEvaluator);
  }

  public void setFloatValues(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofFloat("", paramArrayOfFloat);
      setValues(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      return;
      this.f[0].setFloatValues(paramArrayOfFloat);
    }
  }

  public void setIntValues(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("", paramArrayOfInt);
      setValues(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      return;
      this.f[0].setIntValues(paramArrayOfInt);
    }
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null)
    {
      this.I = paramInterpolator;
      return;
    }
    this.I = new LinearInterpolator();
  }

  public void setObjectValues(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
      return;
    if ((this.f == null) || (this.f.length == 0))
    {
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofObject("", null, paramArrayOfObject);
      setValues(arrayOfPropertyValuesHolder);
    }
    while (true)
    {
      this.e = false;
      return;
      this.f[0].setObjectValues(paramArrayOfObject);
    }
  }

  public void setRepeatCount(int paramInt)
  {
    this.G = paramInt;
  }

  public void setRepeatMode(int paramInt)
  {
    this.H = paramInt;
  }

  public void setStartDelay(long paramLong)
  {
    this.E = paramLong;
  }

  public void setValues(PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    int i1 = paramArrayOfPropertyValuesHolder.length;
    this.f = paramArrayOfPropertyValuesHolder;
    this.g = new HashMap(i1);
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        this.e = false;
        return;
      }
      PropertyValuesHolder localPropertyValuesHolder = paramArrayOfPropertyValuesHolder[i2];
      this.g.put(localPropertyValuesHolder.getPropertyName(), localPropertyValuesHolder);
    }
  }

  public void start()
  {
    a(false);
  }

  public String toString()
  {
    String str = "ValueAnimator@" + Integer.toHexString(hashCode());
    if (this.f != null);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.f.length)
        return str;
      str = str + "\n    " + this.f[i1].toString();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator
 * JD-Core Version:    0.6.2
 */