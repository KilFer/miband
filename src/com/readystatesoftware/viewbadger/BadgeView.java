package com.readystatesoftware.viewbadger;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;

public class BadgeView extends TextView
{
  public static final int POSITION_BOTTOM_LEFT = 3;
  public static final int POSITION_BOTTOM_RIGHT = 4;
  public static final int POSITION_CENTER = 5;
  public static final int POSITION_TOP_LEFT = 1;
  public static final int POSITION_TOP_RIGHT = 2;
  private static final int a = 5;
  private static final int b = 5;
  private static final int c = 8;
  private static final int d = 2;
  private static final int e = 0;
  private static final int f = -1;
  private static Animation g;
  private static Animation h;
  private Context i;
  private View j;
  private int k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private ShapeDrawable p;
  private int q;

  public BadgeView(Context paramContext)
  {
    this(paramContext, null, 16842884);
  }

  public BadgeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }

  public BadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, null, 0);
  }

  public BadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, View paramView, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    this.i = paramContext;
    this.j = paramView;
    this.q = paramInt2;
    this.k = 2;
    this.l = a(5);
    this.m = this.l;
    this.n = e;
    setTypeface(Typeface.DEFAULT_BOLD);
    int i1 = a(5);
    setPadding(i1, 0, i1, 0);
    setTextColor(-1);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    g = localAlphaAnimation1;
    localAlphaAnimation1.setInterpolator(new DecelerateInterpolator());
    g.setDuration(200L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    h = localAlphaAnimation2;
    localAlphaAnimation2.setInterpolator(new AccelerateInterpolator());
    h.setDuration(200L);
    this.o = false;
    if (this.j != null)
    {
      View localView1 = this.j;
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      ViewParent localViewParent = localView1.getParent();
      FrameLayout localFrameLayout = new FrameLayout(this.i);
      if ((localView1 instanceof TabWidget))
      {
        View localView2 = ((TabWidget)localView1).getChildTabViewAt(this.q);
        this.j = localView2;
        ((ViewGroup)localView2).addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        setVisibility(8);
        localFrameLayout.addView(this);
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      int i2 = localViewGroup.indexOfChild(localView1);
      localViewGroup.removeView(localView1);
      localViewGroup.addView(localFrameLayout, i2, localLayoutParams);
      localFrameLayout.addView(localView1);
      setVisibility(8);
      localFrameLayout.addView(this);
      localViewGroup.invalidate();
      return;
    }
    show();
  }

  public BadgeView(Context paramContext, View paramView)
  {
    this(paramContext, null, 16842884, paramView, 0);
  }

  public BadgeView(Context paramContext, TabWidget paramTabWidget, int paramInt)
  {
    this(paramContext, null, 16842884, paramTabWidget, paramInt);
  }

  private int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }

  private ShapeDrawable a()
  {
    int i1 = a(8);
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = i1;
    arrayOfFloat[1] = i1;
    arrayOfFloat[2] = i1;
    arrayOfFloat[3] = i1;
    arrayOfFloat[4] = i1;
    arrayOfFloat[5] = i1;
    arrayOfFloat[6] = i1;
    arrayOfFloat[7] = i1;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(arrayOfFloat, null, null));
    localShapeDrawable.getPaint().setColor(this.n);
    return localShapeDrawable;
  }

  private void a(Context paramContext, View paramView, int paramInt)
  {
    this.i = paramContext;
    this.j = paramView;
    this.q = paramInt;
    this.k = 2;
    this.l = a(5);
    this.m = this.l;
    this.n = e;
    setTypeface(Typeface.DEFAULT_BOLD);
    int i1 = a(5);
    setPadding(i1, 0, i1, 0);
    setTextColor(-1);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    g = localAlphaAnimation1;
    localAlphaAnimation1.setInterpolator(new DecelerateInterpolator());
    g.setDuration(200L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    h = localAlphaAnimation2;
    localAlphaAnimation2.setInterpolator(new AccelerateInterpolator());
    h.setDuration(200L);
    this.o = false;
    if (this.j != null)
    {
      View localView1 = this.j;
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      ViewParent localViewParent = localView1.getParent();
      FrameLayout localFrameLayout = new FrameLayout(this.i);
      if ((localView1 instanceof TabWidget))
      {
        View localView2 = ((TabWidget)localView1).getChildTabViewAt(this.q);
        this.j = localView2;
        ((ViewGroup)localView2).addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        setVisibility(8);
        localFrameLayout.addView(this);
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      int i2 = localViewGroup.indexOfChild(localView1);
      localViewGroup.removeView(localView1);
      localViewGroup.addView(localFrameLayout, i2, localLayoutParams);
      localFrameLayout.addView(localView1);
      setVisibility(8);
      localFrameLayout.addView(this);
      localViewGroup.invalidate();
      return;
    }
    show();
  }

  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    ViewParent localViewParent = paramView.getParent();
    FrameLayout localFrameLayout = new FrameLayout(this.i);
    if ((paramView instanceof TabWidget))
    {
      View localView = ((TabWidget)paramView).getChildTabViewAt(this.q);
      this.j = localView;
      ((ViewGroup)localView).addView(localFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      setVisibility(8);
      localFrameLayout.addView(this);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localViewGroup.addView(localFrameLayout, i1, localLayoutParams);
    localFrameLayout.addView(paramView);
    setVisibility(8);
    localFrameLayout.addView(this);
    localViewGroup.invalidate();
  }

  private void a(boolean paramBoolean, Animation paramAnimation)
  {
    if (getBackground() == null)
    {
      if (this.p == null)
        this.p = a();
      setBackgroundDrawable(this.p);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (this.k)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      setLayoutParams(localLayoutParams);
      if (paramBoolean)
        startAnimation(paramAnimation);
      setVisibility(0);
      this.o = true;
      return;
      localLayoutParams.gravity = 51;
      localLayoutParams.setMargins(this.l, this.m, 0, 0);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.setMargins(0, this.m, this.l, 0);
      continue;
      localLayoutParams.gravity = 83;
      localLayoutParams.setMargins(this.l, 0, 0, this.m);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.setMargins(0, 0, this.l, this.m);
      continue;
      localLayoutParams.gravity = 17;
      localLayoutParams.setMargins(0, 0, 0, 0);
    }
  }

  private void a(boolean paramBoolean, Animation paramAnimation1, Animation paramAnimation2)
  {
    boolean bool = true;
    if (this.o)
    {
      if ((paramBoolean) && (paramAnimation2 != null));
      while (true)
      {
        b(bool, paramAnimation2);
        return;
        bool = false;
      }
    }
    if ((paramBoolean) && (paramAnimation1 != null));
    while (true)
    {
      a(bool, paramAnimation1);
      return;
      bool = false;
    }
  }

  private void b()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (this.k)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.gravity = 51;
      localLayoutParams.setMargins(this.l, this.m, 0, 0);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.setMargins(0, this.m, this.l, 0);
      continue;
      localLayoutParams.gravity = 83;
      localLayoutParams.setMargins(this.l, 0, 0, this.m);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.setMargins(0, 0, this.l, this.m);
      continue;
      localLayoutParams.gravity = 17;
      localLayoutParams.setMargins(0, 0, 0, 0);
    }
  }

  private void b(boolean paramBoolean, Animation paramAnimation)
  {
    setVisibility(8);
    if (paramBoolean)
      startAnimation(paramAnimation);
    this.o = false;
  }

  public int decrement(int paramInt)
  {
    return increment(-paramInt);
  }

  public int getBadgeBackgroundColor()
  {
    return this.n;
  }

  public int getBadgePosition()
  {
    return this.k;
  }

  public int getHorizontalBadgeMargin()
  {
    return this.l;
  }

  public View getTarget()
  {
    return this.j;
  }

  public int getVerticalBadgeMargin()
  {
    return this.m;
  }

  public void hide()
  {
    b(false, null);
  }

  public void hide(Animation paramAnimation)
  {
    b(true, paramAnimation);
  }

  public void hide(boolean paramBoolean)
  {
    b(paramBoolean, h);
  }

  public int increment(int paramInt)
  {
    CharSequence localCharSequence = getText();
    if (localCharSequence != null);
    while (true)
    {
      try
      {
        int i3 = Integer.parseInt(localCharSequence.toString());
        i1 = i3;
        int i2 = i1 + paramInt;
        setText(String.valueOf(i2));
        return i2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      int i1 = 0;
    }
  }

  public boolean isShown()
  {
    return this.o;
  }

  public void setBadgeBackgroundColor(int paramInt)
  {
    this.n = paramInt;
    this.p = a();
  }

  public void setBadgeMargin(int paramInt)
  {
    this.l = paramInt;
    this.m = paramInt;
  }

  public void setBadgeMargin(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
  }

  public void setBadgePosition(int paramInt)
  {
    this.k = paramInt;
  }

  public void show()
  {
    a(false, null);
  }

  public void show(Animation paramAnimation)
  {
    a(true, paramAnimation);
  }

  public void show(boolean paramBoolean)
  {
    a(paramBoolean, g);
  }

  public void toggle()
  {
    a(false, null, null);
  }

  public void toggle(Animation paramAnimation1, Animation paramAnimation2)
  {
    a(true, paramAnimation1, paramAnimation2);
  }

  public void toggle(boolean paramBoolean)
  {
    a(paramBoolean, g, h);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.readystatesoftware.viewbadger.BadgeView
 * JD-Core Version:    0.6.2
 */