package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip extends PagerTitleStrip
{
  private static final String f = "PagerTabStrip";
  private static final int g = 3;
  private static final int h = 6;
  private static final int i = 16;
  private static final int j = 32;
  private static final int k = 64;
  private static final int l = 1;
  private static final int m = 32;
  private float A;
  private float B;
  private int C;
  private int n = this.e;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private final Paint t = new Paint();
  private final Rect u = new Rect();
  private int v = 255;
  private boolean w = false;
  private boolean x = false;
  private int y;
  private boolean z;

  public PagerTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }

  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.t.setColor(this.n);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.o = ((int)(0.5F + 3.0F * f1));
    this.p = ((int)(0.5F + 6.0F * f1));
    this.q = ((int)(64.0F * f1));
    this.s = ((int)(0.5F + 16.0F * f1));
    this.y = ((int)(0.5F + 1.0F * f1));
    this.r = ((int)(0.5F + f1 * 32.0F));
    this.C = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.b.setFocusable(true);
    this.b.setOnClickListener(new N(this));
    this.d.setFocusable(true);
    this.d.setOnClickListener(new O(this));
    if (getBackground() == null)
      this.w = true;
  }

  final int a()
  {
    return Math.max(super.a(), this.r);
  }

  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.u;
    int i1 = getHeight();
    int i2 = this.c.getLeft() - this.s;
    int i3 = this.c.getRight() + this.s;
    int i4 = i1 - this.o;
    localRect.set(i2, i4, i3, i1);
    super.a(paramInt, paramFloat, paramBoolean);
    this.v = ((int)(255.0F * (2.0F * Math.abs(paramFloat - 0.5F))));
    localRect.union(this.c.getLeft() - this.s, i4, this.c.getRight() + this.s, i1);
    invalidate(localRect);
  }

  public boolean getDrawFullUnderline()
  {
    return this.w;
  }

  public int getTabIndicatorColor()
  {
    return this.n;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    int i2 = this.c.getLeft() - this.s;
    int i3 = this.c.getRight() + this.s;
    int i4 = i1 - this.o;
    this.t.setColor(this.v << 24 | 0xFFFFFF & this.n);
    paramCanvas.drawRect(i2, i4, i3, i1, this.t);
    if (this.w)
    {
      this.t.setColor(0xFF000000 | 0xFFFFFF & this.n);
      paramCanvas.drawRect(getPaddingLeft(), i1 - this.y, getWidth() - getPaddingRight(), i1, this.t);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (this.z))
      return false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i1)
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      return true;
      this.A = f1;
      this.B = f2;
      this.z = false;
      continue;
      if ((Math.abs(f1 - this.A) > this.C) || (Math.abs(f2 - this.B) > this.C))
      {
        this.z = true;
        continue;
        if (f1 < this.c.getLeft() - this.s)
          this.a.setCurrentItem(-1 + this.a.getCurrentItem());
        else if (f1 > this.c.getRight() + this.s)
          this.a.setCurrentItem(1 + this.a.getCurrentItem());
      }
    }
  }

  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.x)
      if ((0xFF000000 & paramInt) != 0)
        break label27;
    label27: for (boolean bool = true; ; bool = false)
    {
      this.w = bool;
      return;
    }
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.x)
      if (paramDrawable != null)
        break label24;
    label24: for (boolean bool = true; ; bool = false)
    {
      this.w = bool;
      return;
    }
  }

  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.x)
      if (paramInt != 0)
        break label24;
    label24: for (boolean bool = true; ; bool = false)
    {
      this.w = bool;
      return;
    }
  }

  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.w = paramBoolean;
    this.x = true;
    invalidate();
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 < this.p)
      paramInt4 = this.p;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setTabIndicatorColor(int paramInt)
  {
    this.n = paramInt;
    this.t.setColor(this.n);
    invalidate();
  }

  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(getContext().getResources().getColor(paramInt));
  }

  public void setTextSpacing(int paramInt)
  {
    if (paramInt < this.q)
      paramInt = this.q;
    super.setTextSpacing(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.6.2
 */