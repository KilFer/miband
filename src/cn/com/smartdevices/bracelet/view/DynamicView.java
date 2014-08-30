package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.ui.DynamicDetailActivity;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;

public class DynamicView extends FrameLayout
  implements ViewSwitcher.ViewFactory
{
  private static final String a = "Chart.DynamicView";
  private ImageView A = null;
  private int B;
  private Boolean C = Boolean.valueOf(false);
  private int D = 0;
  private PageIndicator E;
  private ValueAnimator F = null;
  private ValueAnimator G = null;
  private ValueAnimator H = null;
  private ValueAnimator I = null;
  private ValueAnimator J = null;
  private ValueAnimator K = null;
  private Context b;
  private DynamicView.FlowBgView c;
  private View d;
  private ViewGroup e;
  private View f;
  private View g;
  private View h;
  private DynamicPieChartView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private int u;
  private int v;
  private Animator w;
  private Animator x;
  private ImageView y = null;
  private ImageView z = null;

  public DynamicView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public DynamicView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    this.D = ((int)Utils.convertDpToPixel(106.0F, paramContext));
    inflate(paramContext, 2130903138, this);
    this.d = findViewById(2131165647);
    this.c = ((DynamicView.FlowBgView)findViewById(2131165639));
    this.e = ((ViewGroup)findViewById(2131165642));
    this.f = findViewById(2131165640);
    this.g = findViewById(2131165643);
    this.h = findViewById(2131165650);
    this.i = ((DynamicPieChartView)findViewById(2131165641));
    this.j = ((TextView)findViewById(2131165644));
    this.k = ((TextView)findViewById(2131165648));
    this.l = ((TextView)findViewById(2131165649));
    this.m = ((TextView)findViewById(2131165646));
    this.n = ((TextView)findViewById(2131165645));
    this.o = ((TextView)findViewById(2131165651));
    this.p = ((TextView)findViewById(2131165652));
    this.q = ((TextView)findViewById(2131165653));
    this.r = ((TextView)findViewById(2131165654));
    this.s = ((TextView)findViewById(2131165656));
    this.t = ((TextView)findViewById(2131165655));
    this.g.setOnClickListener(new a(this));
    this.h.setOnClickListener(new f(this));
    this.C = Keeper.readIsPlayEnterAnimation();
    if (this.C.booleanValue())
    {
      if (Keeper.readPlayEnterAnimationType() != 1)
        break label408;
      this.y = ((ImageView)findViewById(2131165657));
      this.y.setVisibility(0);
      this.z = ((ImageView)findViewById(2131165658));
      this.z.setVisibility(0);
    }
    label408: 
    while (Keeper.readPlayEnterAnimationType() != 2)
      return;
    this.A = ((ImageView)findViewById(2131165659));
    this.A.setVisibility(0);
  }

  private void a()
  {
    Intent localIntent = new Intent(this.b, DynamicDetailActivity.class);
    localIntent.putExtra("Mode", this.B);
    this.b.startActivity(localIntent);
  }

  private Animator b()
  {
    AnimUtil.AnimSetBuilder.setFirstAnim(this.c.animFlow(), 600L);
    AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animFadeIn(this), 600L);
    AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animNumSwitch(0, this.v, this.j), 0L, 600L);
    AnimUtil.AnimSetBuilder.addAnim(this.i.animRefresh(), 0L, 600L);
    return AnimUtil.AnimSetBuilder.build();
  }

  private Animator c()
  {
    AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch(0, this.v, this.j));
    AnimUtil.AnimSetBuilder.addAnim(this.i.animRefresh());
    return AnimUtil.AnimSetBuilder.build();
  }

  private void d()
  {
    this.F = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.F.setDuration(800L);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(3.0F);
    this.F.setInterpolator(localDecelerateInterpolator);
    this.F.addUpdateListener(new g(this));
    this.F.start();
  }

  private void e()
  {
    if ((this.G != null) && (this.G.isRunning()))
      return;
    this.G = ValueAnimator.ofFloat(new float[] { 1.0F, 1.03F, 1.07F, 1.1F, 1.1F, 1.07F, 1.03F, 1.0F, 0.95F, 0.9F, 0.95F, 1.0F, 1.05F, 1.0F });
    this.G.setDuration(1000L);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    this.G.setInterpolator(localDecelerateInterpolator);
    this.G.addListener(new h(this));
    this.G.addUpdateListener(new i(this));
    this.G.start();
  }

  private void f()
  {
    this.H = ValueAnimator.ofFloat(new float[] { 0.0F, 10.0F, 0.0F });
    this.H.setDuration(500L);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    this.H.setInterpolator(localDecelerateInterpolator);
    this.H.addListener(new j(this));
    this.H.addUpdateListener(new k(this));
    this.H.start();
  }

  private void g()
  {
    if (this.H != null)
      this.H.end();
    if (this.F != null)
      this.F.end();
    this.I = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.I.setDuration(800L);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.I.setInterpolator(localLinearInterpolator);
    this.I.addListener(new l(this));
    this.I.addUpdateListener(new m(this));
    this.I.start();
  }

  private void h()
  {
    if (this.I != null)
      this.I.end();
    if (this.H != null)
      this.H.end();
    if (this.F != null)
      this.F.end();
    this.J = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.J.setDuration(600L);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.J.setInterpolator(localLinearInterpolator);
    this.J.addListener(new b(this));
    this.J.addUpdateListener(new c(this));
    this.J.start();
  }

  private void i()
  {
    if (this.H != null)
      this.H.end();
    if (this.F != null)
      this.F.end();
    this.K = ValueAnimator.ofFloat(new float[] { 0.0F, 600.0F });
    this.K.setDuration(800L);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.K.setInterpolator(localLinearInterpolator);
    this.K.addListener(new d(this));
    this.K.addUpdateListener(new e(this));
    this.K.start();
  }

  public View getCenter()
  {
    return this.e;
  }

  public long getShowAnimDuration()
  {
    return AnimUtil.getAnimDuration((AnimatorSet)this.w);
  }

  public long getSwitchAnimDuration()
  {
    return AnimUtil.getAnimDuration((AnimatorSet)this.x);
  }

  public View makeView()
  {
    return inflate(getContext(), 2130903139, null);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    startShow(false);
    boolean bool2;
    if (this.C.booleanValue())
    {
      if (Keeper.readPlayEnterAnimationType() == 1)
      {
        if (this.I != null)
          this.I.end();
        if (this.H != null)
          this.H.end();
        if (this.F != null)
          this.F.end();
        this.J = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
        this.J.setDuration(600L);
        LinearInterpolator localLinearInterpolator2 = new LinearInterpolator();
        this.J.setInterpolator(localLinearInterpolator2);
        this.J.addListener(new b(this));
        this.J.addUpdateListener(new c(this));
        this.J.start();
      }
    }
    else
    {
      boolean bool1 = Utils.isBinded();
      bool2 = false;
      if (!bool1)
        break label297;
    }
    while (true)
    {
      setConnectingAlpha(Boolean.valueOf(bool2));
      return;
      if (Keeper.readPlayEnterAnimationType() != 2)
        break;
      if (this.H != null)
        this.H.end();
      if (this.F != null)
        this.F.end();
      this.K = ValueAnimator.ofFloat(new float[] { 0.0F, 600.0F });
      this.K.setDuration(800L);
      LinearInterpolator localLinearInterpolator1 = new LinearInterpolator();
      this.K.setInterpolator(localLinearInterpolator1);
      this.K.addListener(new d(this));
      this.K.addUpdateListener(new e(this));
      this.K.start();
      break;
      label297: bool2 = true;
    }
  }

  public void refresh()
  {
    refresh(false);
  }

  public void refresh(boolean paramBoolean)
  {
    if ((this.w != null) && (this.w.isStarted()))
      this.w.end();
    if ((this.x != null) && (this.x.isStarted()))
      this.x.end();
    if (!paramBoolean)
    {
      CharSequence localCharSequence = AnimUtil.formatNumStyle(this.v);
      this.j.setText(localCharSequence);
      this.i.refresh(false);
      return;
    }
    AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch(0, this.v, this.j));
    AnimUtil.AnimSetBuilder.addAnim(this.i.animRefresh());
    this.x = AnimUtil.AnimSetBuilder.build();
    this.x.start();
  }

  public void seekShowAnim(long paramLong)
  {
    if (this.w != null)
      AnimUtil.seekAnim(this, (AnimatorSet)this.w, paramLong);
  }

  public void seekSwitchAnim(long paramLong)
  {
    if (this.x != null)
      AnimUtil.seekAnim(this, (AnimatorSet)this.x, paramLong);
  }

  public void setConnectingAlpha(Boolean paramBoolean)
  {
    if (this.f == null);
    do
    {
      return;
      if (paramBoolean.booleanValue())
      {
        this.f.setAlpha(0.3F);
        return;
      }
      this.f.setAlpha(1.0F);
    }
    while ((this.G != null) && (this.G.isRunning()));
    this.G = ValueAnimator.ofFloat(new float[] { 1.0F, 1.03F, 1.07F, 1.1F, 1.1F, 1.07F, 1.03F, 1.0F, 0.95F, 0.9F, 0.95F, 1.0F, 1.05F, 1.0F });
    this.G.setDuration(1000L);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    this.G.setInterpolator(localDecelerateInterpolator);
    this.G.addListener(new h(this));
    this.G.addUpdateListener(new i(this));
    this.G.start();
  }

  public void setIndicator(PageIndicator paramPageIndicator)
  {
    this.E = paramPageIndicator;
  }

  public void setMode(int paramInt)
  {
    this.B = paramInt;
    if (this.B == 1)
    {
      this.g.setVisibility(0);
      this.h.setVisibility(8);
    }
    while (true)
    {
      this.i.setMode(this.B);
      return;
      if (this.B == 16)
      {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
      }
    }
  }

  public void setSleepDeepTime(int paramInt)
  {
    TextView localTextView = this.s;
    Context localContext = getContext();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ChartData.formatTimeLengthLong(getContext(), paramInt);
    localTextView.setText(localContext.getString(2131493133, arrayOfObject));
  }

  public void setSleepTime(int paramInt)
  {
    String[] arrayOfString = ChartData.formatTimeHourMinLong(paramInt);
    this.o.setText(arrayOfString[0]);
    this.p.setText(2131492928);
    this.q.setText(arrayOfString[1]);
    this.r.setText(2131492930);
  }

  public void setSleepTip(String paramString)
  {
    this.t.setText(paramString);
  }

  public void setSlideUpPostion(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      return;
    float f1 = 90.0F - paramFloat * 90.0F;
    this.i.setRotationX(f1);
    this.i.setAlpha(paramFloat);
    this.f.setTranslationY(-this.D * (1.0F - paramFloat));
    this.m.setAlpha(paramFloat);
    this.d.setAlpha(paramFloat);
    this.n.setAlpha(1.0F - paramFloat);
    this.t.setAlpha(paramFloat);
    this.s.setAlpha(paramFloat);
  }

  public void setStepCalorie(int paramInt)
  {
    this.l.setText(String.valueOf(paramInt) + getContext().getString(2131492926));
  }

  public void setStepCount(int paramInt)
  {
    this.v = paramInt;
    this.i.setValue(paramInt);
  }

  public void setStepDistance(String[] paramArrayOfString)
  {
    String str = paramArrayOfString[0] + paramArrayOfString[1];
    this.k.setText(str);
  }

  public void setStepGoal(int paramInt)
  {
    this.i.setMaxValue(paramInt);
  }

  public void setStepTip(String paramString)
  {
    this.m.setText(paramString);
  }

  public void startShow(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      refresh(false);
      return;
    }
    if ((this.w != null) && (this.w.isStarted()))
      this.w.end();
    AnimUtil.AnimSetBuilder.setFirstAnim(this.c.animFlow(), 600L);
    AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animFadeIn(this), 600L);
    AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animNumSwitch(0, this.v, this.j), 0L, 600L);
    AnimUtil.AnimSetBuilder.addAnim(this.i.animRefresh(), 0L, 600L);
    this.w = AnimUtil.AnimSetBuilder.build();
    this.w.start();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.DynamicView
 * JD-Core Version:    0.6.2
 */