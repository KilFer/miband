package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.xiaomi.hm.health.R.styleable;

public class RoundProgressBar extends View
{
  public static final int FILL = 1;
  public static final int STROKE;
  private Paint a = new Paint();
  private int b;
  private int c;
  private int d;
  private float e;
  private float f;
  private int g;
  private int h;
  private int i = 0;
  private int j = 0;
  private boolean k;
  private int l;
  private int m = -1;
  private Bitmap n = null;
  private ValueAnimator o = null;

  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundProgressBar);
    this.b = localTypedArray.getColor(0, -65536);
    this.c = localTypedArray.getColor(1, -16711936);
    this.d = localTypedArray.getColor(3, -16711936);
    this.e = localTypedArray.getDimension(4, 15.0F);
    this.f = localTypedArray.getDimension(2, 5.0F);
    this.g = localTypedArray.getInteger(5, 100);
    this.k = localTypedArray.getBoolean(6, true);
    this.l = localTypedArray.getInt(7, 0);
    this.m = localTypedArray.getResourceId(8, -1);
    if (this.m != -1)
      this.n = BitmapFactory.decodeResource(getResources(), this.m);
    localTypedArray.recycle();
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt <= 0);
    while (paramFloat1 >= paramFloat2)
      return;
    this.o = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    this.o.setDuration(paramInt * 20);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.o.setInterpolator(localLinearInterpolator);
    this.o.addListener(new s(this));
    this.o.addUpdateListener(new t(this));
    this.o.start();
  }

  public int getCricleColor()
  {
    return this.b;
  }

  public int getCricleProgressColor()
  {
    return this.c;
  }

  public int getMax()
  {
    try
    {
      int i1 = this.g;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getProgress()
  {
    try
    {
      int i1 = this.h;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public float getRoundWidth()
  {
    return this.f;
  }

  public int getTextColor()
  {
    return this.d;
  }

  public float getTextSize()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth() / 2;
    int i2 = (int)(i1 - this.f / 2.0F);
    this.a.setColor(this.b);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.f);
    this.a.setAntiAlias(true);
    paramCanvas.drawCircle(i1, i1, i2, this.a);
    this.a.setStrokeWidth(0.0F);
    this.a.setColor(this.d);
    this.a.setTextSize(this.e);
    this.a.setTypeface(Typeface.DEFAULT_BOLD);
    int i3 = (int)(100.0F * (this.h / this.g));
    float f1 = this.a.measureText(i3 + "%");
    if ((this.k) && (i3 != 0) && (this.l == 0))
      paramCanvas.drawText(i3 + "%", i1 - f1 / 2.0F, i1 + this.e / 2.0F, this.a);
    if (this.n != null)
    {
      int i4 = this.n.getWidth();
      int i5 = this.n.getHeight();
      paramCanvas.drawBitmap(this.n, i1 - i4 / 2, i1 - i5 / 2, null);
    }
    this.a.setStrokeWidth(this.f);
    this.a.setColor(this.c);
    RectF localRectF = new RectF(i1 - i2, i1 - i2, i1 + i2, i1 + i2);
    switch (this.l)
    {
    default:
    case 0:
    case 1:
    }
    do
    {
      return;
      this.a.setStyle(Paint.Style.STROKE);
      paramCanvas.drawArc(localRectF, -90.0F, 360.0F * (this.h / this.g), false, this.a);
      return;
      this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    while (this.h == 0);
    paramCanvas.drawArc(localRectF, -90.0F, 360.0F * (this.h / this.g), true, this.a);
  }

  public void setCricleColor(int paramInt)
  {
    this.b = paramInt;
  }

  public void setCricleProgressColor(int paramInt)
  {
    this.c = paramInt;
  }

  public void setMax(int paramInt)
  {
    if (paramInt < 0)
      try
      {
        throw new IllegalArgumentException("max not less than 0");
      }
      finally
      {
      }
    this.g = paramInt;
  }

  public void setProgress(int paramInt)
  {
    if (paramInt < 0)
      try
      {
        throw new IllegalArgumentException("progress not less than 0");
      }
      finally
      {
      }
    if (paramInt > this.g)
      this.h = this.g;
    if (paramInt <= this.g)
    {
      this.h = paramInt;
      postInvalidateOnAnimation();
    }
  }

  public void setRoundWidth(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void setTextColor(int paramInt)
  {
    this.d = paramInt;
  }

  public void setTextSize(float paramFloat)
  {
    this.e = paramFloat;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.RoundProgressBar
 * JD-Core Version:    0.6.2
 */