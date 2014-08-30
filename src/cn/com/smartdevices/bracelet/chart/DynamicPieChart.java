package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class DynamicPieChart extends PieChart
{
  private static final String a = "Chart.DynamicPieChart";
  private static final float b = 1.33F;
  private static final float c = 14.33F;
  private static final float d = 16.33F;
  private static final int e = 200;
  private boolean f;
  private int g;
  private Bitmap h;
  private Bitmap i;
  private Paint j;
  private Paint k;
  private float l;
  private Paint m;
  private RectF n;
  private float o;
  private float[] p;
  private Bitmap q;
  private Canvas r;
  private boolean s;
  private View t;

  public DynamicPieChart(Context paramContext)
  {
    super(paramContext);
    this.h = ((BitmapDrawable)paramContext.getResources().getDrawable(2130837604)).getBitmap();
    this.i = ((BitmapDrawable)paramContext.getResources().getDrawable(2130837603)).getBitmap();
    this.j = new Paint(1);
    this.k = new Paint(1);
    this.j.setColor(Color.parseColor("#e8edf3"));
    this.j.setStrokeWidth(1.33F * this.mDensity);
    this.j.setStyle(Paint.Style.STROKE);
    this.k.setColor(Color.parseColor("#33e8edf3"));
    this.k.setStrokeWidth(1.33F * this.mDensity);
    this.k.setStyle(Paint.Style.STROKE);
    this.o = (14.33F * this.mDensity);
    this.l = (16.33F * this.mDensity);
    this.m = new Paint(1);
    this.m.setColor(Color.parseColor("#33e8edf3"));
    this.m.setStrokeWidth(1.0F);
    this.m.setStyle(Paint.Style.STROKE);
  }

  public DynamicPieChart(Context paramContext, View paramView)
  {
    this(paramContext);
    this.t = paramView;
  }

  private void a(float paramFloat1, float paramFloat2, float paramFloat3, Canvas paramCanvas)
  {
    paramCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3 - this.m.getStrokeWidth() / 2.0F - this.l, this.m);
    if (this.g > 0)
      ChartUtil.erase(paramCanvas, this.n);
    a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, this.k, 200);
  }

  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, int paramInt)
  {
    float f1;
    float f2;
    if (this.p == null)
    {
      this.p = new float[800];
      f1 = paramFloat3 - this.m.getStrokeWidth() / 2.0F - 2.0F * this.l;
      f2 = paramFloat3 - this.m.getStrokeWidth() / 2.0F - 2.0F * this.l - this.o;
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 200)
      {
        paramCanvas.drawLines(this.p, 0, paramInt << 2, paramPaint);
        return;
      }
      float f3 = 0.03141593F * i1;
      float f4 = (float)(paramFloat1 + Math.sin(f3) * f1);
      float f5 = (float)(paramFloat2 - Math.cos(f3) * f1);
      float f6 = (float)(paramFloat1 + Math.sin(f3) * f2);
      float f7 = (float)(paramFloat2 - Math.cos(f3) * f2);
      this.p[(i1 << 2)] = f4;
      this.p[(1 + (i1 << 2))] = f5;
      this.p[(2 + (i1 << 2))] = f6;
      this.p[(3 + (i1 << 2))] = f7;
    }
  }

  public void dismissLoading()
  {
    this.f = false;
  }

  protected void drawPie(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    label72: float f1;
    if (this.q != null)
    {
      if (!this.s)
      {
        a(paramFloat1, paramFloat2, paramFloat3, this.r);
        this.s = true;
      }
      paramCanvas.drawBitmap(this.q, 0.0F, 0.0F, null);
      switch (this.g)
      {
      default:
        f1 = paramFloat4 * paramFloat5;
        if (f1 > 1.0F)
          f1 = 1.0F;
        if (this.f)
        {
          paramCanvas.save();
          paramCanvas.rotate(360.0F * this.mRotate, paramFloat1, paramFloat2);
          if (f1 < 0.3F)
            f1 = 0.3F;
          if (f1 > 0.6F)
            f1 = 0.6F;
          a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, this.j, (int)(f1 * 200.0F));
          paramCanvas.restore();
        }
        break;
      case 1:
      case 16:
      }
    }
    do
    {
      return;
      a(paramFloat1, paramFloat2, paramFloat3, paramCanvas);
      break;
      ChartUtil.drawBitmapCenter(paramCanvas, this.n.centerX(), this.n.centerY(), this.mDensityScale, this.h, null);
      break label72;
      ChartUtil.drawBitmapCenter(paramCanvas, this.n.centerX(), this.n.centerY(), this.mDensityScale, this.i, null);
      break label72;
      if ((f1 > 0.0F) || (f1 < 1.0F))
      {
        a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, this.j, (int)(f1 * 200.0F));
        return;
      }
    }
    while (f1 != 1.0F);
    a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, this.j, 200);
  }

  protected void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    this.n = new RectF();
    this.n.left = (paramRectF.centerX() - 15.5F * this.mDensity);
    this.n.top = (paramRectF.top + 2.0F * this.mDensity);
    this.n.right = (this.n.left + 31.0F * this.mDensity);
    this.n.bottom = (this.n.top + 31.0F * this.mDensity);
    this.s = false;
    if (this.r != null)
    {
      this.r.setBitmap(null);
      if (this.q != null)
      {
        this.q.recycle();
        this.q = null;
      }
    }
    this.r = new Canvas();
    this.r.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
    try
    {
      this.q = Bitmap.createBitmap((int)paramRectF.width(), (int)paramRectF.height(), Bitmap.Config.ARGB_8888);
      this.r.setBitmap(this.q);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      this.r = null;
      this.q = null;
      this.t.setLayerType(1, null);
    }
  }

  public void setMode(int paramInt)
  {
    this.g = paramInt;
  }

  public void showLoading()
  {
    this.f = true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicPieChart
 * JD-Core Version:    0.6.2
 */