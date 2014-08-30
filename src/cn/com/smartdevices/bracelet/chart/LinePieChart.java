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
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.PieChart;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class LinePieChart extends PieChart
{
  private static final String a = "LinePieChart";
  private static final float b = 1.33F;
  private static final float c = 16.33F;
  private int d = 0;
  private final Paint e;
  private SweepGradient f;
  private boolean g;
  private int h;
  private Bitmap i;
  private Paint j;
  private Paint k;
  private float l;
  private Paint m;
  private Paint n;
  private RectF o;
  private Bitmap p;
  private Canvas q;
  private boolean r;

  public LinePieChart(Context paramContext)
  {
    super(paramContext);
    this.i = ((BitmapDrawable)paramContext.getResources().getDrawable(2130837618)).getBitmap();
    this.j = new Paint(1);
    this.k = new Paint(1);
    this.j.setColor(Color.parseColor("#e8edf3"));
    this.j.setStrokeWidth(1.33F * this.mDensity);
    this.j.setStyle(Paint.Style.STROKE);
    this.k.setColor(Color.parseColor("#33e8edf3"));
    this.k.setStrokeWidth(1.33F * this.mDensity);
    this.k.setStyle(Paint.Style.STROKE);
    this.l = (16.33F * this.mDensity);
    this.m = new Paint(1);
    this.m.setColor(Color.parseColor("#33e8edf3"));
    this.m.setStrokeWidth(4.0F);
    this.m.setStyle(Paint.Style.STROKE);
    this.n = new Paint(1);
    this.n.setColor(Color.parseColor("#ffffffff"));
    this.n.setStrokeWidth(4.0F);
    this.n.setStyle(Paint.Style.STROKE);
    this.e = new Paint(1);
    this.e.setStrokeWidth(4.0F);
    this.e.setStyle(Paint.Style.STROKE);
  }

  public void dismissLoading()
  {
    Debug.i("LinePieChart", "dismissLoading.");
    this.g = false;
    this.r = false;
  }

  protected void drawPie(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    RectF localRectF;
    switch (this.h)
    {
    default:
      float f1 = paramFloat3 - this.m.getStrokeWidth() / 2.0F - this.l;
      localRectF = new RectF(paramFloat1 - f1, paramFloat2 - f1, paramFloat1 + f1, f1 + paramFloat2);
      if (!this.r)
      {
        if (this.g)
        {
          this.f = new SweepGradient(paramFloat1, paramFloat2, new int[] { 1157627903, -1 }, null);
          this.e.setShader(this.f);
        }
        this.r = true;
      }
      if ((this.h == 1) || (this.h == 0))
        paramCanvas.drawArc(localRectF, 270 + this.d / 2, 360 - this.d, false, this.m);
      if (this.g)
      {
        paramCanvas.rotate(360.0F * this.mRotate, paramFloat1, paramFloat2);
        paramCanvas.drawArc(localRectF, 270.0F, 360.0F, false, this.e);
      }
      break;
    case 1:
    case 2:
    case 0:
    }
    while (this.h != 1)
    {
      return;
      paramFloat4 = 1.0F - paramFloat4;
      ChartUtil.drawBitmapCenter(paramCanvas, this.o.centerX(), this.o.centerY(), this.mDensityScale, this.i, null);
      this.d = 18;
      break;
      this.d = 0;
      break;
      this.d = 0;
      break;
    }
    paramCanvas.drawArc(localRectF, 270 + this.d / 2, paramFloat4 * (360 - this.d), false, this.n);
  }

  protected void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    this.o = new RectF();
    this.o.left = (paramRectF.centerX() - 15.5F * this.mDensity);
    this.o.top = (paramRectF.top + 2.0F * this.mDensity);
    this.o.right = (this.o.left + 31.0F * this.mDensity);
    this.o.bottom = (this.o.top + 31.0F * this.mDensity);
    this.p = Bitmap.createBitmap((int)paramRectF.width(), (int)paramRectF.height(), Bitmap.Config.ARGB_8888);
    this.r = false;
    if (this.q == null)
    {
      this.q = new Canvas();
      this.q.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
    }
    this.q.setBitmap(this.p);
  }

  public void setMode(int paramInt)
  {
    this.h = paramInt;
    this.r = false;
  }

  public void showLoading()
  {
    this.g = true;
    this.r = false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.LinePieChart
 * JD-Core Version:    0.6.2
 */