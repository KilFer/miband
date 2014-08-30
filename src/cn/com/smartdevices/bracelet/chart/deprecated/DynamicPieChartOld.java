package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class DynamicPieChartOld extends PieChart
{
  public static final int MODE_CALORIE = 2;
  public static final int MODE_GOAL = 3;
  public static final int MODE_NONE = 0;
  public static final int MODE_STEPS = 1;
  private static final String a = "Chart.DynamicPieChart";
  private static final float b = 8.3F;
  private boolean c;
  private int d = 1;
  private Bitmap e;
  private Bitmap f;
  private Bitmap g;
  private Paint h = new Paint(1);
  private Paint i = new Paint(1);
  private Matrix j;
  private Shader k;
  private float l;
  private RectF m;
  private float n;
  private Paint o;
  private RectF p;

  public DynamicPieChartOld(Context paramContext)
  {
    super(paramContext);
    this.h.setStrokeWidth(8.3F * this.mDensity);
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeCap(Paint.Cap.ROUND);
    this.i.setColor(Color.parseColor("#33ffffff"));
    this.i.setStrokeWidth(8.3F * this.mDensity);
    this.i.setStyle(Paint.Style.STROKE);
    this.j = new Matrix();
    this.n = (20.0F * this.mDensity);
    this.o = new Paint(1);
    this.o.setColor(Color.parseColor("#33ffffff"));
    this.o.setStrokeWidth(1.0F * this.mDensity);
    this.o.setStyle(Paint.Style.STROKE);
  }

  public void dismissLoading()
  {
    this.c = false;
  }

  protected void drawPie(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3 - this.o.getStrokeWidth() / 2.0F - this.n, this.o);
    paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3 - this.i.getStrokeWidth() / 2.0F - 2.0F * this.n, this.i);
    float f1 = paramFloat4 * paramFloat5;
    if (f1 > 1.0F)
      f1 = 1.0F;
    if (this.c)
    {
      int[] arrayOfInt = { 16777215, -1, 16777215 };
      if (f1 == 0.0F)
        f1 = 0.5F;
      this.k = new SweepGradient(paramFloat1, paramFloat2, arrayOfInt, new float[] { 0.0F, f1, 1.0F });
      this.j.setRotate(-90.0F + this.mRotate, paramFloat1, paramFloat2);
      this.k.setLocalMatrix(this.j);
      this.h.setShader(this.k);
      label184: if (f1 >= 1.0F)
        break label281;
      paramCanvas.drawArc(this.m, -90.0F + this.mRotate + this.l, f1 * (360.0F - 2.0F * this.l), false, this.h);
    }
    while (true)
      switch (this.d)
      {
      default:
        return;
        this.h.setShader(null);
        this.h.setColor(-1);
        break label184;
        label281: paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3 - this.i.getStrokeWidth() / 2.0F - 2.0F * this.n, this.h);
      case 1:
      case 2:
      case 3:
      }
    ChartUtil.erase(paramCanvas, this.p);
    ChartUtil.drawBitmapCenter(paramCanvas, this.p.centerX(), this.p.centerY(), this.mDensityScale, null, null);
    return;
    ChartUtil.erase(paramCanvas, this.p);
    ChartUtil.drawBitmapCenter(paramCanvas, this.p.centerX(), this.p.centerY(), this.mDensityScale, null, null);
    return;
    ChartUtil.erase(paramCanvas, this.p);
    ChartUtil.drawBitmapCenter(paramCanvas, this.p.centerX(), this.p.centerY(), this.mDensityScale, null, null);
  }

  protected void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    this.l = ((float)(360.0D * (this.h.getStrokeWidth() / 2.0F / (3.141592653589793D * (2.0F * (this.mRadius - 2.0F * this.n))))));
    this.m = new RectF(paramRectF);
    RectF localRectF1 = this.m;
    localRectF1.left += this.h.getStrokeWidth() / 2.0F + 2.0F * this.n;
    RectF localRectF2 = this.m;
    localRectF2.top += this.h.getStrokeWidth() / 2.0F + 2.0F * this.n;
    RectF localRectF3 = this.m;
    localRectF3.right -= this.h.getStrokeWidth() / 2.0F + 2.0F * this.n;
    RectF localRectF4 = this.m;
    localRectF4.bottom -= this.h.getStrokeWidth() / 2.0F + 2.0F * this.n;
    this.p = new RectF();
    this.p.left = (paramRectF.left + paramRectF.width() / 2.0F - 16.0F * this.mDensity);
    this.p.top = (paramRectF.top + 8.0F * this.mDensity);
    this.p.right = (this.p.left + 32.0F * this.mDensity);
    this.p.bottom = (this.p.top + 24.0F * this.mDensity);
  }

  public void showLoading()
  {
    this.c = true;
  }

  public void updateMode(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicPieChartOld
 * JD-Core Version:    0.6.2
 */