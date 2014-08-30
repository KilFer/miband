package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.Debug;

public class RadioRuler extends View
{
  public static final int RULER_TYPE_AM = 1002;
  public static final int RULER_TYPE_FM = 1001;
  public static final int RULER_TYPE_NONE = 1000;
  private static final float k = 84.0F;
  private static final float l = 1.0F;
  private static final float m = 110.0F;
  private static final float n = 83.5F;
  private static final float o = 500.0F;
  private static final float p = 495.0F;
  private static final float q = 1600.0F;
  private static final float r = 10.0F;
  private Bitmap a = null;
  private Bitmap b = null;
  private Bitmap c = null;
  private Bitmap d = null;
  private final int e;
  private Paint f = null;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private final String j;
  private int s = 1000;
  private final int t;
  private float u = 0.0F;
  private Scroller v = null;
  private RadioRuler.ScrollListener w = null;

  public RadioRuler(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.v = new Scroller(paramContext);
    setFocusable(true);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(-1);
    this.f.setTextSize(15.0F);
    if (1000 == this.s)
      setRulerType(1001);
  }

  private float a()
  {
    if (this.s == 1002)
      return 1600.0F;
    return 110.0F;
  }

  private void a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      float f1 = this.u;
      if (this.s == 1002);
      for (float f2 = 1600.0F; f1 > f2; f2 = 110.0F)
        return;
    }
    if (paramFloat + this.g <= 0.0F)
    {
      this.g = (paramFloat + this.g);
      this.h = (this.g % 300.0F);
      if (this.h > 0.0F)
        this.h -= 300.0F;
      while (true)
      {
        invalidate();
        return;
        if (this.h < -300.0F)
          this.h = (300.0F + this.h);
      }
    }
    this.g = 0.0F;
    this.h = 0.0F;
    invalidate();
  }

  private void a(Canvas paramCanvas)
  {
    float f1 = 68.0F + this.g;
    int i1 = -1;
    while (true)
    {
      if (f1 > 800.0F)
        return;
      i1++;
      if (f1 >= 0.0F)
        break;
      f1 += 150.0F;
    }
    switch (this.s)
    {
    default:
    case 1002:
    }
    for (this.u = (84.0F + i1); ; this.u = (500.0F + 10.0F * i1))
    {
      paramCanvas.drawText(this.u, f1, 15.0F, this.f);
      f1 += 150.0F;
      break;
    }
  }

  private float b()
  {
    int i1 = Math.abs((int)RadioRuler.FloatUtility.divide(this.g, 15.0F));
    switch (this.s)
    {
    default:
      return 0.0F;
    case 1001:
      return RadioRuler.FloatUtility.add(2.7F, RadioRuler.FloatUtility.add(83.5F, RadioRuler.FloatUtility.mulitiply(i1, RadioRuler.FloatUtility.divide(1.0F, 10.0F))));
    case 1002:
    }
    return RadioRuler.FloatUtility.add(27.0F, RadioRuler.FloatUtility.add(495.0F, RadioRuler.FloatUtility.mulitiply(i1, RadioRuler.FloatUtility.divide(10.0F, 10.0F))));
  }

  private void b(float paramFloat)
  {
    this.v.startScroll((int)this.g, 0, (int)paramFloat, 0, 100);
    while (true)
    {
      if (!this.v.computeScrollOffset())
        return;
      this.g = this.v.getCurrX();
      invalidate();
    }
  }

  public void DrawRuler(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, null);
    Debug.i("Ruler", "startview position is " + this.h);
    Debug.i("Ruler", "scroll distance position is " + this.g);
    this.h = (this.g % 300.0F);
    if (this.h < -100.0F)
      paramCanvas.drawBitmap(this.a, 900.0F + this.h, 20.0F, null);
    paramCanvas.drawBitmap(this.a, this.h, 20.0F, null);
    paramCanvas.drawBitmap(this.a, 300.0F + this.h, 20.0F, null);
    paramCanvas.drawBitmap(this.a, 600.0F + this.h, 20.0F, null);
    a(paramCanvas);
    paramCanvas.drawBitmap(this.d, 395.0F, 20.0F, null);
    paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, null);
  }

  public void initalSrc(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4)
  {
    this.a = paramBitmap1;
    this.b = paramBitmap2;
    this.c = paramBitmap3;
    this.d = paramBitmap4;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    DrawRuler(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(800, 72);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.v != null) && (!this.v.isFinished()));
    label106: 
    do
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      default:
        return true;
      case 0:
        this.i = paramMotionEvent.getX();
        return true;
      case 2:
        float f2 = paramMotionEvent.getX() - this.i;
        this.i = paramMotionEvent.getX();
        float f4;
        if (f2 < 0.0F)
        {
          float f3 = this.u;
          if (this.s != 1002)
            break label190;
          f4 = 1600.0F;
          if (f3 > f4);
        }
        else
        {
          if (f2 + this.g > 0.0F)
            break label221;
          this.g = (f2 + this.g);
          this.h = (this.g % 300.0F);
          if (this.h <= 0.0F)
            break label197;
          this.h -= 300.0F;
          invalidate();
        }
        while (this.w != null)
        {
          this.w.onScroll();
          return true;
          f4 = 110.0F;
          break label106;
          if (this.h >= -300.0F)
            break label168;
          this.h = (300.0F + this.h);
          break label168;
          this.g = 0.0F;
          this.h = 0.0F;
          invalidate();
        }
      case 1:
      }
      b(-(this.g % 15.0F));
    }
    while (this.w == null);
    label168: label190: label197: label221: RadioRuler.ScrollListener localScrollListener = this.w;
    int i1 = Math.abs((int)RadioRuler.FloatUtility.divide(this.g, 15.0F));
    int i2 = this.s;
    float f1 = 0.0F;
    switch (i2)
    {
    default:
    case 1001:
    case 1002:
    }
    while (true)
    {
      localScrollListener.onScrollEnd(f1);
      return true;
      f1 = RadioRuler.FloatUtility.add(2.7F, RadioRuler.FloatUtility.add(83.5F, RadioRuler.FloatUtility.mulitiply(i1, RadioRuler.FloatUtility.divide(1.0F, 10.0F))));
      continue;
      f1 = RadioRuler.FloatUtility.add(27.0F, RadioRuler.FloatUtility.add(495.0F, RadioRuler.FloatUtility.mulitiply(i1, RadioRuler.FloatUtility.divide(10.0F, 10.0F))));
    }
  }

  public void setFreq(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1001:
      this.s = 1001;
      this.g = (15.0F * -((paramFloat - 83.5F) / 0.1F - 27.0F));
      return;
    case 1002:
    }
    this.s = 1002;
    this.g = (15.0F * -(paramFloat - 495.0F - 27.0F));
  }

  public void setRulerType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      this.s = 1001;
      return;
    case 1002:
    }
    this.s = 1002;
  }

  public void setScrollListener(RadioRuler.ScrollListener paramScrollListener)
  {
    this.w = paramScrollListener;
  }

  public void smoothScrollToFreq(float paramFloat)
  {
    int i1 = this.s;
    float f1 = 0.0F;
    switch (i1)
    {
    default:
    case 1001:
    case 1002:
    }
    while (true)
    {
      b(f1 - this.g);
      return;
      f1 = 15.0F * -((paramFloat - 83.5F) / 0.1F - 27.0F);
      continue;
      f1 = 15.0F * -(paramFloat - 495.0F - 27.0F);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.RadioRuler
 * JD-Core Version:    0.6.2
 */