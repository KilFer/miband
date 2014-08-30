package com.twotoasters.jazzylistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.effects.CardsEffect;
import com.twotoasters.jazzylistview.effects.CurlEffect;
import com.twotoasters.jazzylistview.effects.FadeEffect;
import com.twotoasters.jazzylistview.effects.FanEffect;
import com.twotoasters.jazzylistview.effects.FlipEffect;
import com.twotoasters.jazzylistview.effects.FlyEffect;
import com.twotoasters.jazzylistview.effects.GrowEffect;
import com.twotoasters.jazzylistview.effects.HelixEffect;
import com.twotoasters.jazzylistview.effects.ReverseFlyEffect;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.effects.StandardEffect;
import com.twotoasters.jazzylistview.effects.TiltEffect;
import com.twotoasters.jazzylistview.effects.TwirlEffect;
import com.twotoasters.jazzylistview.effects.WaveEffect;
import com.twotoasters.jazzylistview.effects.WaveRightEffect;
import com.twotoasters.jazzylistview.effects.ZipperEffect;
import com.xiaomi.hm.health.R.styleable;
import java.util.HashSet;

public class JazzyHelper
  implements AbsListView.OnScrollListener
{
  public static final int CARDS = 2;
  public static final int CURL = 3;
  public static final int DURATION = 600;
  public static final int FADE = 12;
  public static final int FAN = 9;
  public static final int FLIP = 5;
  public static final int FLY = 6;
  public static final int GROW = 1;
  public static final int HELIX = 8;
  public static final int MAX_VELOCITY_OFF = 0;
  public static final int OPAQUE = 255;
  public static final int REVERSE_FLY = 7;
  public static final int SLIDE_IN = 14;
  public static final int STANDARD = 0;
  public static final int TILT = 10;
  public static final int TRANSPARENT = 0;
  public static final int TWIRL = 13;
  public static final int WAVE = 4;
  public static final int WAVERIGHT = 15;
  public static final int ZIPPER = 11;
  private JazzyEffect a = null;
  private boolean b = false;
  private int c = -1;
  private int d = -1;
  private int e = 0;
  private long f = 0L;
  private double g = 0.0D;
  private int h = 0;
  private AbsListView.OnScrollListener i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private final HashSet<Integer> n = new HashSet();

  public JazzyHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.JazzyListView);
    int i1 = localTypedArray.getInteger(0, 0);
    int i2 = localTypedArray.getInteger(4, 0);
    this.j = localTypedArray.getBoolean(1, false);
    this.k = localTypedArray.getBoolean(4, false);
    this.m = localTypedArray.getBoolean(3, false);
    localTypedArray.recycle();
    setTransitionEffect(i1);
    setMaxAnimationVelocity(i2);
  }

  private double a()
  {
    return this.g;
  }

  private void a(int paramInt)
  {
    long l1;
    long l2;
    double d1;
    if ((this.h > 0) && (this.e != paramInt))
    {
      l1 = System.currentTimeMillis();
      l2 = l1 - this.f;
      if (l2 >= 1L)
        break label120;
      d1 = 1000.0D * (1.0D / l2);
      if (d1 >= 0.8999999761581421D * this.g)
        break label82;
      this.g = (0.8999999761581421D * this.g);
    }
    while (true)
    {
      this.e = paramInt;
      this.f = l1;
      return;
      label82: if (d1 > 1.100000023841858D * this.g)
      {
        this.g = (1.100000023841858D * this.g);
      }
      else
      {
        this.g = d1;
        continue;
        label120: this.g = (1000.0D * (1.0D / l2));
      }
    }
  }

  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((!this.b) || ((this.j) && (this.n.contains(Integer.valueOf(paramInt1)))));
    while (((this.k) && (!this.l)) || ((this.h > 0) && (this.h < this.g)))
      return;
    ViewGroup localViewGroup;
    int i1;
    if (this.m)
    {
      localViewGroup = (ViewGroup)paramView;
      i1 = 0;
      if (i1 < localViewGroup.getChildCount());
    }
    while (true)
    {
      this.n.add(Integer.valueOf(paramInt1));
      return;
      b(localViewGroup.getChildAt(i1), paramInt1, paramInt2);
      i1++;
      break;
      b(paramView, paramInt1, paramInt2);
    }
  }

  private void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.i != null)
      this.i.onScrollStateChanged(paramAbsListView, paramInt);
  }

  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.i != null)
      this.i.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  private void b(View paramView, int paramInt1, int paramInt2)
  {
    ViewPropertyAnimator localViewPropertyAnimator = ViewPropertyAnimator.animate(paramView).setDuration(600L).setInterpolator(new AccelerateDecelerateInterpolator());
    if (paramInt2 > 0);
    for (int i1 = 1; ; i1 = -1)
    {
      this.a.initView(paramView, paramInt1, i1);
      this.a.setupAnimation(paramView, paramInt1, i1, localViewPropertyAnimator);
      localViewPropertyAnimator.start();
      return;
    }
  }

  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    int i2;
    long l2;
    double d1;
    label111: int i4;
    label125: int i5;
    if ((this.c != -1) && (this.d != -1))
    {
      i1 = 1;
      i2 = -1 + (paramInt1 + paramInt2);
      if ((!this.b) || (i1 == 0))
        break label292;
      if ((this.h > 0) && (this.e != paramInt1))
      {
        long l1 = System.currentTimeMillis();
        l2 = l1 - this.f;
        if (l2 >= 1L)
          break label228;
        d1 = 1000.0D * (1.0D / l2);
        if (d1 >= 0.8999999761581421D * this.g)
          break label190;
        this.g = (0.8999999761581421D * this.g);
        this.e = paramInt1;
        this.f = l1;
      }
      i4 = 0;
      if (paramInt1 + i4 < this.c)
        break label244;
      i5 = 0;
      label139: if (i2 - i5 > this.d)
        break label265;
    }
    while (true)
    {
      this.c = paramInt1;
      this.d = i2;
      if (this.i != null)
        this.i.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      i1 = 0;
      break;
      label190: if (d1 > 1.100000023841858D * this.g)
      {
        this.g = (1.100000023841858D * this.g);
        break label111;
      }
      this.g = d1;
      break label111;
      label228: this.g = (1000.0D * (1.0D / l2));
      break label111;
      label244: a(paramAbsListView.getChildAt(i4), paramInt1 + i4, -1);
      i4++;
      break label125;
      label265: a(paramAbsListView.getChildAt(i2 - paramInt1 - i5), i2 - i5, 1);
      i5++;
      break label139;
      label292: if (i1 == 0)
        for (int i3 = paramInt1; i3 < paramInt2; i3++)
          this.n.add(Integer.valueOf(i3));
    }
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      if (this.i != null)
        this.i.onScrollStateChanged(paramAbsListView, paramInt);
      return;
      this.b = false;
      this.l = false;
      continue;
      this.l = true;
      continue;
      this.b = true;
      this.l = false;
    }
  }

  public void setMaxAnimationVelocity(int paramInt)
  {
    this.h = paramInt;
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.i = paramOnScrollListener;
  }

  public void setShouldOnlyAnimateFling(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setShouldOnlyAnimateNewItems(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setSimulateGridWithList(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void setTransitionEffect(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      setTransitionEffect(new StandardEffect());
      return;
    case 1:
      setTransitionEffect(new GrowEffect());
      return;
    case 2:
      setTransitionEffect(new CardsEffect());
      return;
    case 3:
      setTransitionEffect(new CurlEffect());
      return;
    case 4:
      setTransitionEffect(new WaveEffect());
      return;
    case 5:
      setTransitionEffect(new FlipEffect());
      return;
    case 6:
      setTransitionEffect(new FlyEffect());
      return;
    case 7:
      setTransitionEffect(new ReverseFlyEffect());
      return;
    case 8:
      setTransitionEffect(new HelixEffect());
      return;
    case 9:
      setTransitionEffect(new FanEffect());
      return;
    case 10:
      setTransitionEffect(new TiltEffect());
      return;
    case 11:
      setTransitionEffect(new ZipperEffect());
      return;
    case 12:
      setTransitionEffect(new FadeEffect());
      return;
    case 13:
      setTransitionEffect(new TwirlEffect());
      return;
    case 14:
      setTransitionEffect(new SlideInEffect());
      return;
    case 15:
    }
    setTransitionEffect(new WaveRightEffect());
  }

  public void setTransitionEffect(JazzyEffect paramJazzyEffect)
  {
    this.a = paramJazzyEffect;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.twotoasters.jazzylistview.JazzyHelper
 * JD-Core Version:    0.6.2
 */