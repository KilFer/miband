package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class b extends ImageView
{
  private Matrix a = new Matrix();
  public boolean b = false;
  private Matrix c = new Matrix();
  private int d = 0;
  private float e = 1.0F;
  private float f = 1.0F;
  private Bitmap g;
  private boolean h = false;
  private float i;
  private float j;
  private String k;
  private PointF l = new PointF();
  private PointF m = new PointF();
  private float n = 1.0F;
  private float o = 0.0F;
  private Rect p = new Rect();

  public b(Context paramContext)
  {
    super(paramContext);
    getDrawingRect(this.p);
  }

  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getDrawingRect(this.p);
  }

  private static float a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2)
      return 0.0F;
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }

  private static void a()
  {
  }

  private void a(PointF paramPointF)
  {
    float f1 = 1.0F;
    if (this.g == null)
      return;
    float[] arrayOfFloat = new float[9];
    this.a.getValues(arrayOfFloat);
    float f2 = arrayOfFloat[2];
    float f3 = arrayOfFloat[5];
    float f4 = arrayOfFloat[0];
    float f5 = this.g.getWidth();
    float f6 = this.g.getHeight();
    float f7 = f5 * f4;
    float f8 = f6 * f4;
    float f9 = this.p.left - f2;
    if (f9 <= f1)
      f9 = f1;
    float f10 = f2 + f7 - this.p.right;
    if (f10 <= f1)
      f10 = f1;
    float f11 = f10 + f9;
    float f12 = f9 * this.p.width() / f11 + this.p.left;
    float f13 = this.p.top - f3;
    float f14 = f3 + f8 - this.p.bottom;
    if (f13 <= f1)
      f13 = f1;
    if (f14 <= f1);
    while (true)
    {
      float f15 = f13 + f1;
      paramPointF.set(f12, f13 * this.p.height() / f15 + this.p.top);
      return;
      f1 = f14;
    }
  }

  private void b()
  {
    if (this.g == null);
    while (true)
    {
      return;
      float f1 = this.p.width();
      float f2 = this.p.height();
      float[] arrayOfFloat = new float[9];
      this.a.getValues(arrayOfFloat);
      float f3 = arrayOfFloat[2];
      float f4 = arrayOfFloat[5];
      float f5 = arrayOfFloat[0];
      Object localObject;
      if (f5 > this.e)
      {
        this.o = (this.e / f5);
        this.a.postScale(this.o, this.o, this.m.x, this.m.y);
        setImageMatrix(this.a);
        localObject = new ScaleAnimation(1.0F / this.o, 1.0F, 1.0F / this.o, 1.0F, this.m.x, this.m.y);
      }
      while (localObject != null)
      {
        this.h = true;
        ((Animation)localObject).setDuration(300L);
        startAnimation((Animation)localObject);
        new Thread(new j(this)).start();
        return;
        if (f5 < this.f)
        {
          this.o = (this.f / f5);
          this.a.postScale(this.o, this.o, this.m.x, this.m.y);
          localObject = new ScaleAnimation(1.0F, this.o, 1.0F, this.o, this.m.x, this.m.y);
        }
        else
        {
          float f6 = f5 * this.g.getWidth();
          float f7 = f5 * this.g.getHeight();
          float f8 = this.p.left - f3;
          float f9 = this.p.top - f4;
          boolean bool = f8 < 0.0F;
          int i1 = 0;
          if (bool)
          {
            f3 = this.p.left;
            i1 = 1;
          }
          if (f9 < 0.0F)
          {
            f4 = this.p.top;
            i1 = 1;
          }
          float f10 = f6 - f8;
          float f11 = f7 - f9;
          if (f10 < f1)
          {
            float f15 = f6 - f1;
            f3 = this.p.left - f15;
            i1 = 1;
          }
          if (f11 < f2)
          {
            float f14 = f7 - f2;
            f4 = this.p.top - f14;
            i1 = 1;
          }
          if (i1 != 0)
          {
            float f12 = arrayOfFloat[2] - f3;
            float f13 = arrayOfFloat[5] - f4;
            arrayOfFloat[2] = f3;
            arrayOfFloat[5] = f4;
            this.a.setValues(arrayOfFloat);
            setImageMatrix(this.a);
            localObject = new TranslateAnimation(f12, 0.0F, f13, 0.0F);
          }
          else
          {
            setImageMatrix(this.a);
            localObject = null;
          }
        }
      }
    }
  }

  private void c()
  {
    if (this.g == null)
      return;
    float[] arrayOfFloat = new float[9];
    this.a.getValues(arrayOfFloat);
    float f1 = Math.max(this.p.width() / this.g.getWidth(), this.p.height() / this.g.getHeight());
    this.i = (this.p.left - (f1 * this.g.getWidth() - this.p.width()) / 2.0F);
    this.j = (this.p.top - (f1 * this.g.getHeight() - this.p.height()) / 2.0F);
    arrayOfFloat[2] = this.i;
    arrayOfFloat[5] = this.j;
    arrayOfFloat[4] = f1;
    arrayOfFloat[0] = f1;
    this.a.setValues(arrayOfFloat);
    this.e = Math.min(2048.0F / this.g.getWidth(), 2048.0F / this.g.getHeight());
    this.f = f1;
    if (this.e < this.f)
      this.e = this.f;
    setImageMatrix(this.a);
  }

  public void a(Rect paramRect)
  {
    this.p = paramRect;
    if ((this.g != null) && (this.g != null))
    {
      float[] arrayOfFloat = new float[9];
      this.a.getValues(arrayOfFloat);
      float f1 = Math.max(this.p.width() / this.g.getWidth(), this.p.height() / this.g.getHeight());
      this.i = (this.p.left - (f1 * this.g.getWidth() - this.p.width()) / 2.0F);
      this.j = (this.p.top - (f1 * this.g.getHeight() - this.p.height()) / 2.0F);
      arrayOfFloat[2] = this.i;
      arrayOfFloat[5] = this.j;
      arrayOfFloat[4] = f1;
      arrayOfFloat[0] = f1;
      this.a.setValues(arrayOfFloat);
      this.e = Math.min(2048.0F / this.g.getWidth(), 2048.0F / this.g.getHeight());
      this.f = f1;
      if (this.e < this.f)
        this.e = this.f;
      setImageMatrix(this.a);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    if (this.h)
      return true;
    PointF localPointF;
    float f16;
    float f17;
    float f18;
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
      do
      {
        while (true)
        {
          this.b = true;
          return true;
          this.a.set(getImageMatrix());
          this.c.set(this.a);
          this.l.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.d = 1;
        }
        this.n = a(paramMotionEvent);
      }
      while (this.n <= 10.0F);
      this.c.set(this.a);
      localPointF = this.m;
      if (this.g != null)
      {
        float[] arrayOfFloat = new float[9];
        this.a.getValues(arrayOfFloat);
        float f6 = arrayOfFloat[2];
        float f7 = arrayOfFloat[5];
        float f8 = arrayOfFloat[0];
        float f9 = this.g.getWidth();
        float f10 = this.g.getHeight();
        float f11 = f9 * f8;
        float f12 = f10 * f8;
        float f13 = this.p.left - f6;
        if (f13 <= f1)
          f13 = f1;
        float f14 = f6 + f11 - this.p.right;
        if (f14 <= f1)
          f14 = f1;
        float f15 = f14 + f13;
        f16 = f13 * this.p.width() / f15 + this.p.left;
        f17 = this.p.top - f7;
        f18 = f7 + f12 - this.p.bottom;
        if (f17 <= f1)
          f17 = f1;
        if (f18 > f1)
          break label553;
      }
      break;
    case 1:
    case 6:
    case 2:
    }
    while (true)
    {
      float f19 = f17 + f1;
      localPointF.set(f16, f17 * this.p.height() / f19 + this.p.top);
      this.d = 2;
      break;
      b();
      this.d = 0;
      break;
      if (this.d == 1)
      {
        this.a.set(this.c);
        float f4 = paramMotionEvent.getX() - this.l.x;
        float f5 = paramMotionEvent.getY() - this.l.y;
        this.a.postTranslate(f4, f5);
      }
      while (true)
      {
        setImageMatrix(this.a);
        break;
        if (this.d != 2)
          break;
        this.a.set(this.a);
        float f2 = a(paramMotionEvent);
        if (f2 > 10.0F)
        {
          this.a.set(this.c);
          float f3 = f2 / this.n;
          this.a.postScale(f3, f3, this.m.x, this.m.y);
        }
      }
      label553: f1 = f18;
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.g = paramBitmap;
    if (paramBitmap != null)
      this.g = paramBitmap;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.b
 * JD-Core Version:    0.6.2
 */