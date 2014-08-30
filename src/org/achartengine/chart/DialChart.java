package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.DialRenderer.Type;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class DialChart extends RoundChart
{
  private static final int a = 10;
  private DialRenderer b;

  public DialChart(CategorySeries paramCategorySeries, DialRenderer paramDialRenderer)
  {
    super(paramCategorySeries, paramDialRenderer);
    this.b = paramDialRenderer;
  }

  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    double d1 = paramDouble3 - paramDouble2;
    double d2 = paramDouble5 - paramDouble4;
    return Math.toRadians(paramDouble2 + d1 * (paramDouble1 - paramDouble4) / d2);
  }

  private void a(Canvas paramCanvas, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt1, int paramInt2, double paramDouble5, double paramDouble6, double paramDouble7, Paint paramPaint, boolean paramBoolean)
  {
    for (double d1 = paramDouble1; d1 <= paramDouble2; d1 += paramDouble7)
    {
      double d2 = a(d1, paramDouble3, paramDouble4, paramDouble1, paramDouble2);
      double d3 = Math.sin(d2);
      double d4 = Math.cos(d2);
      int i = Math.round(paramInt1 + (float)(paramDouble6 * d3));
      int j = Math.round(paramInt2 + (float)(paramDouble6 * d4));
      int k = Math.round(paramInt1 + (float)(d3 * paramDouble5));
      int m = Math.round(paramInt2 + (float)(d4 * paramDouble5));
      paramCanvas.drawLine(i, j, k, m, paramPaint);
      if (paramBoolean)
      {
        paramPaint.setTextAlign(Paint.Align.LEFT);
        if (i <= k)
          paramPaint.setTextAlign(Paint.Align.RIGHT);
        String str = d1;
        if (Math.round(d1) == ()d1)
          str = ()d1;
        paramCanvas.drawText(str, i, j, paramPaint);
      }
    }
  }

  private void a(Canvas paramCanvas, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, boolean paramBoolean, Paint paramPaint)
  {
    double d = Math.toRadians(90.0D);
    int i = (int)(10.0D * Math.sin(paramDouble1 - d));
    int j = (int)(10.0D * Math.cos(paramDouble1 - d));
    int k = (int)(paramDouble2 * Math.sin(paramDouble1));
    int m = (int)(paramDouble2 * Math.cos(paramDouble1));
    int n = paramInt1 + k;
    int i1 = paramInt2 + m;
    float[] arrayOfFloat1;
    if (paramBoolean)
    {
      int i2 = paramInt1 + (int)(0.85D * paramDouble2 * Math.sin(paramDouble1));
      int i3 = paramInt2 + (int)(0.85D * paramDouble2 * Math.cos(paramDouble1));
      float[] arrayOfFloat2 = new float[6];
      arrayOfFloat2[0] = (i2 - i);
      arrayOfFloat2[1] = (i3 - j);
      arrayOfFloat2[2] = n;
      arrayOfFloat2[3] = i1;
      arrayOfFloat2[4] = (i2 + i);
      arrayOfFloat2[5] = (j + i3);
      float f = paramPaint.getStrokeWidth();
      paramPaint.setStrokeWidth(5.0F);
      paramCanvas.drawLine(paramInt1, paramInt2, n, i1, paramPaint);
      paramPaint.setStrokeWidth(f);
      arrayOfFloat1 = arrayOfFloat2;
    }
    while (true)
    {
      drawPath(paramCanvas, arrayOfFloat1, paramPaint, true);
      return;
      arrayOfFloat1 = new float[6];
      arrayOfFloat1[0] = (paramInt1 - i);
      arrayOfFloat1[1] = (paramInt2 - j);
      arrayOfFloat1[2] = n;
      arrayOfFloat1[3] = i1;
      arrayOfFloat1[4] = (i + paramInt1);
      arrayOfFloat1[5] = (j + paramInt2);
    }
  }

  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    paramPaint.setAntiAlias(this.b.isAntialiasing());
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setTextSize(this.b.getLabelsTextSize());
    int i = getLegendSize(this.b, paramInt4 / 5, 0.0F);
    int j = paramInt1 + paramInt3;
    int k = this.mDataset.getItemCount();
    String[] arrayOfString = new String[k];
    for (int m = 0; m < k; m++)
      arrayOfString[m] = this.mDataset.getCategory(m);
    if (this.b.isFitLegend());
    for (int n = drawLegend(paramCanvas, this.b, arrayOfString, paramInt1, j, paramInt2, paramInt3, paramInt4, i, paramPaint, true); ; n = i)
    {
      int i1 = paramInt2 + paramInt4 - n;
      drawBackground(this.b, paramCanvas, paramInt1, paramInt2, paramInt3, paramInt4, paramPaint, false, 0);
      int i2 = (int)(0.35D * Math.min(Math.abs(j - paramInt1), Math.abs(i1 - paramInt2)) * this.b.getScale());
      if (this.mCenterX == 2147483647)
        this.mCenterX = ((paramInt1 + j) / 2);
      if (this.mCenterY == 2147483647)
        this.mCenterY = ((i1 + paramInt2) / 2);
      float f1 = 0.9F * i2;
      float f2 = 1.1F * i2;
      double d1 = this.b.getMinValue();
      double d2 = this.b.getMaxValue();
      double d3 = this.b.getAngleMin();
      double d4 = this.b.getAngleMax();
      if ((!this.b.isMinValueSet()) || (!this.b.isMaxValueSet()))
      {
        int i3 = this.b.getSeriesRendererCount();
        int i4 = 0;
        double d5 = d2;
        double d6 = d1;
        while (i4 < i3)
        {
          double d12 = this.mDataset.getValue(i4);
          if (!this.b.isMinValueSet())
            d6 = Math.min(d6, d12);
          if (!this.b.isMaxValueSet())
            d5 = Math.max(d5, d12);
          i4++;
        }
        d2 = d5;
        d1 = d6;
      }
      if (d1 == d2)
      {
        d1 *= 0.5D;
        d2 *= 1.5D;
      }
      paramPaint.setColor(this.b.getLabelsColor());
      double d7 = this.b.getMinorTicksSpacing();
      double d8 = this.b.getMajorTicksSpacing();
      if (d7 == 1.7976931348623157E+308D)
        d7 = (d2 - d1) / 30.0D;
      if (d8 == 1.7976931348623157E+308D)
        d8 = (d2 - d1) / 10.0D;
      a(paramCanvas, d1, d2, d3, d4, this.mCenterX, this.mCenterY, f2, i2, d7, paramPaint, false);
      a(paramCanvas, d1, d2, d3, d4, this.mCenterX, this.mCenterY, f2, f1, d8, paramPaint, true);
      int i5 = this.b.getSeriesRendererCount();
      int i6 = 0;
      if (i6 < i5)
      {
        double d9 = a(this.mDataset.getValue(i6), d3, d4, d1, d2);
        paramPaint.setColor(this.b.getSeriesRendererAt(i6).getColor());
        int i7;
        label631: int i8;
        int i9;
        int i10;
        int i11;
        int i14;
        int i15;
        float[] arrayOfFloat;
        if (this.b.getVisualTypeForIndex(i6) == DialRenderer.Type.ARROW)
        {
          i7 = 1;
          i8 = this.mCenterX;
          i9 = this.mCenterY;
          double d10 = f1;
          double d11 = Math.toRadians(90.0D);
          i10 = (int)(10.0D * Math.sin(d9 - d11));
          i11 = (int)(10.0D * Math.cos(d9 - d11));
          int i12 = (int)(d10 * Math.sin(d9));
          int i13 = (int)(d10 * Math.cos(d9));
          i14 = i12 + i8;
          i15 = i13 + i9;
          if (i7 == 0)
            break label884;
          int i16 = i8 + (int)(0.85D * d10 * Math.sin(d9));
          int i17 = i9 + (int)(d10 * 0.85D * Math.cos(d9));
          arrayOfFloat = new float[6];
          arrayOfFloat[0] = (i16 - i10);
          arrayOfFloat[1] = (i17 - i11);
          arrayOfFloat[2] = i14;
          arrayOfFloat[3] = i15;
          arrayOfFloat[4] = (i16 + i10);
          arrayOfFloat[5] = (i17 + i11);
          float f3 = paramPaint.getStrokeWidth();
          paramPaint.setStrokeWidth(5.0F);
          paramCanvas.drawLine(i8, i9, i14, i15, paramPaint);
          paramPaint.setStrokeWidth(f3);
        }
        while (true)
        {
          drawPath(paramCanvas, arrayOfFloat, paramPaint, true);
          i6++;
          break;
          i7 = 0;
          break label631;
          label884: arrayOfFloat = new float[6];
          arrayOfFloat[0] = (i8 - i10);
          arrayOfFloat[1] = (i9 - i11);
          arrayOfFloat[2] = i14;
          arrayOfFloat[3] = i15;
          arrayOfFloat[4] = (i8 + i10);
          arrayOfFloat[5] = (i9 + i11);
        }
      }
      drawLegend(paramCanvas, this.b, arrayOfString, paramInt1, j, paramInt2, paramInt3, paramInt4, n, paramPaint, false);
      drawTitle(paramCanvas, paramInt1, paramInt2, paramInt3, paramPaint);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.DialChart
 * JD-Core Version:    0.6.2
 */