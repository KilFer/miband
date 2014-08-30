package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

public class RulerScrollView extends HorizontalScrollView
{
  private static final String a = "RulerScrollView";
  private static final float b = 2.6F;
  private static Handler q = new Handler();
  private GestureDetector c;
  private LayoutInflater d;
  private int e = 0;
  private int f = 100;
  private LinearLayout g;
  private int h;
  private float i;
  private int j;
  private float k;
  private View l;
  private int m = 130;
  private TextView n;
  private TextView o;
  private int p = 0;
  private GestureDetector.SimpleOnGestureListener r = new u(this);

  public RulerScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = new GestureDetector(paramContext, this.r);
    this.d = LayoutInflater.from(paramContext);
    this.d.inflate(2130903127, this);
    this.g = ((LinearLayout)findViewById(2131165579));
  }

  public RulerScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private float a(int paramInt1, int paramInt2)
  {
    float f1 = (float)(Math.abs((0.5D + paramInt1) * this.m - paramInt2 - this.j / 2.0F) / (2.0F * this.m));
    if (1.0F - f1 > 1.0E-006D)
      return f1;
    return 1.0F;
  }

  private void a(int paramInt)
  {
    this.k = Math.round(paramInt / this.i + this.e + this.j / 2.0F / this.i - 2.6F);
    this.n.setText((int)this.k);
  }

  private void b()
  {
    Debug.i("RulerScrollView", "adjust left from:" + this.p);
    this.p = ((int)(this.i * (2.6F + (this.k - this.e) - this.j / 2 / this.i)));
    Debug.i("RulerScrollView", "adjust left to:" + this.p);
    smoothScrollTo(getScrollLeft(), 0);
    smoothScrollTo(this.p, 0);
    invalidate();
  }

  private void b(int paramInt)
  {
    int i1 = (int)((paramInt + this.j / 2.0F) / this.m);
    View localView1 = this.g.getChildAt(i1);
    if (localView1 != null)
      localView1.findViewById(2131165578).setAlpha(0.1F);
    if (i1 > 0)
    {
      View localView3 = this.g.getChildAt(i1 - 1);
      float f2 = a(i1 - 1, paramInt);
      if (localView3 != null)
        localView3.findViewById(2131165578).setAlpha(f2);
    }
    if (i1 < -1 + this.g.getChildCount())
    {
      View localView2 = this.g.getChildAt(i1 + 1);
      float f1 = a(i1 + 1, paramInt);
      if (localView2 != null)
        localView2.findViewById(2131165578).setAlpha(f1);
    }
  }

  public void addView(View paramView)
  {
    this.g.addView(paramView);
  }

  public float getCurValue()
  {
    return this.k;
  }

  public int getScrollLeft()
  {
    return this.p;
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1);
    b(paramInt1);
    this.p = paramInt1;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    if ((!this.c.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
      b();
    return super.onTouchEvent(paramMotionEvent);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.h = this.g.getWidth();
    this.j = getWidth();
    this.i = (this.h / (this.f - this.e));
    View localView = this.g.getChildAt(0);
    if (localView != null)
      this.m = localView.getWidth();
    a(this.p);
    b(this.p);
    scrollTo(this.p, 0);
  }

  public void setIndicatorView(View paramView)
  {
    this.l = paramView;
    this.n = ((TextView)this.l.findViewById(2131165575));
    this.o = ((TextView)this.l.findViewById(2131165576));
  }

  public void setScroll(int paramInt)
  {
    this.p = paramInt;
    scrollTo(paramInt, 0);
  }

  public void setStartEnd(int paramInt1, int paramInt2, String paramString)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.o.setText(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.RulerScrollView
 * JD-Core Version:    0.6.2
 */