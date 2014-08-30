package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class BarChart extends XYChart
{
  public static final String TYPE = "Bar";
  private static final int a = 12;
  protected BarChart.Type mType = BarChart.Type.DEFAULT;

  BarChart()
  {
  }

  BarChart(BarChart.Type paramType)
  {
    this.mType = paramType;
  }

  public BarChart(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer, BarChart.Type paramType)
  {
    super(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
    this.mType = paramType;
  }

  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Color.argb(Math.round(paramFloat * Color.alpha(paramInt1) + (1.0F - paramFloat) * Color.alpha(paramInt2)), Math.round(paramFloat * Color.red(paramInt1) + (1.0F - paramFloat) * Color.red(paramInt2)), Math.round(paramFloat * Color.green(paramInt1) + (1.0F - paramFloat) * Color.green(paramInt2)), Math.round(paramFloat * Color.blue(paramInt1) + (1.0F - paramFloat) * Color.blue(paramInt2)));
  }

  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, Paint paramPaint)
  {
    SimpleSeriesRenderer localSimpleSeriesRenderer = this.mRenderer.getSeriesRendererAt(paramInt2);
    if (localSimpleSeriesRenderer.isGradientEnabled())
    {
      double[] arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = 0.0D;
      arrayOfDouble1[1] = localSimpleSeriesRenderer.getGradientStopValue();
      float f1 = (float)toScreenPoint(arrayOfDouble1, paramInt1)[1];
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = 0.0D;
      arrayOfDouble2[1] = localSimpleSeriesRenderer.getGradientStartValue();
      float f2 = (float)toScreenPoint(arrayOfDouble2, paramInt1)[1];
      float f3 = Math.max(f1, Math.min(paramFloat2, paramFloat4));
      float f4 = Math.min(f2, Math.max(paramFloat2, paramFloat4));
      int i = localSimpleSeriesRenderer.getGradientStopColor();
      int j = localSimpleSeriesRenderer.getGradientStartColor();
      int k;
      if (paramFloat2 < f1)
      {
        paramPaint.setColor(i);
        paramCanvas.drawRect(Math.round(paramFloat1), Math.round(paramFloat2), Math.round(paramFloat3), Math.round(f3), paramPaint);
        k = i;
        if (paramFloat4 <= f2)
          break label296;
        paramPaint.setColor(j);
        paramCanvas.drawRect(Math.round(paramFloat1), Math.round(f4), Math.round(paramFloat3), Math.round(paramFloat4), paramPaint);
      }
      label296: for (int m = j; ; m = a(j, i, (f4 - f1) / (f2 - f1)))
      {
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { m, k });
        localGradientDrawable.setBounds(Math.round(paramFloat1), Math.round(f3), Math.round(paramFloat3), Math.round(f4));
        localGradientDrawable.draw(paramCanvas);
        return;
        k = a(i, j, (f2 - f3) / (f2 - f1));
        break;
      }
    }
    if (Math.abs(paramFloat2 - paramFloat4) < 1.0F)
      if (paramFloat2 >= paramFloat4)
        break label372;
    label372: for (paramFloat4 = paramFloat2 + 1.0F; ; paramFloat4 = paramFloat2 - 1.0F)
    {
      paramCanvas.drawRect(Math.round(paramFloat1), Math.round(paramFloat2), Math.round(paramFloat3), Math.round(paramFloat4), paramPaint);
      return;
    }
  }

  protected ClickableArea[] clickableAreasForPoints(List<Float> paramList, List<Double> paramList1, float paramFloat, int paramInt1, int paramInt2)
  {
    int i = this.mDataset.getSeriesCount();
    int j = paramList.size();
    ClickableArea[] arrayOfClickableArea = new ClickableArea[j / 2];
    float f1 = getHalfDiffX(paramList, j, i);
    int k = 0;
    if (k < j)
    {
      float f2 = ((Float)paramList.get(k)).floatValue();
      float f3 = ((Float)paramList.get(k + 1)).floatValue();
      if (this.mType == BarChart.Type.STACKED)
        arrayOfClickableArea[(k / 2)] = new ClickableArea(new RectF(f2 - f1, Math.min(f3, paramFloat), f2 + f1, Math.max(f3, paramFloat)), ((Double)paramList1.get(k)).doubleValue(), ((Double)paramList1.get(k + 1)).doubleValue());
      while (true)
      {
        k += 2;
        break;
        float f4 = f2 - f1 * i + f1 * (paramInt1 << 1);
        arrayOfClickableArea[(k / 2)] = new ClickableArea(new RectF(f4, Math.min(f3, paramFloat), f4 + 2.0F * f1, Math.max(f3, paramFloat)), ((Double)paramList1.get(k)).doubleValue(), ((Double)paramList1.get(k + 1)).doubleValue());
      }
    }
    return arrayOfClickableArea;
  }

  protected void drawBar(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, int paramInt2, Paint paramPaint)
  {
    int i = this.mDataset.getSeriesAt(paramInt2).getScaleNumber();
    if (this.mType == BarChart.Type.STACKED)
    {
      a(paramCanvas, paramFloat1 - paramFloat5, paramFloat4, paramFloat3 + paramFloat5, paramFloat2, i, paramInt2, paramPaint);
      return;
    }
    float f = paramFloat1 - paramFloat5 * paramInt1 + paramFloat5 * (paramInt2 << 1);
    a(paramCanvas, f, paramFloat4, f + 2.0F * paramFloat5, paramFloat2, i, paramInt2, paramPaint);
  }

  protected void drawChartValuesText(Canvas paramCanvas, XYSeries paramXYSeries, SimpleSeriesRenderer paramSimpleSeriesRenderer, Paint paramPaint, List<Float> paramList, int paramInt1, int paramInt2)
  {
    int i = this.mDataset.getSeriesCount();
    int j = paramList.size();
    float f1 = getHalfDiffX(paramList, j, i);
    int k = 0;
    if (k < j)
    {
      double d = paramXYSeries.getY(paramInt2 + k / 2);
      float f2;
      if (!isNullValue(d))
      {
        f2 = ((Float)paramList.get(k)).floatValue();
        if (this.mType == BarChart.Type.DEFAULT)
          f2 += f1 * (paramInt1 << 1) - f1 * (i - 1.5F);
        if (d < 0.0D)
          break label167;
        drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), d), f2, ((Float)paramList.get(k + 1)).floatValue() - paramSimpleSeriesRenderer.getChartValuesSpacing(), paramPaint, 0.0F);
      }
      while (true)
      {
        k += 2;
        break;
        label167: drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), d), f2, ((Float)paramList.get(k + 1)).floatValue() + paramSimpleSeriesRenderer.getChartValuesTextSize() + paramSimpleSeriesRenderer.getChartValuesSpacing() - 3.0F, paramPaint, 0.0F);
      }
    }
  }

  public void drawLegendShape(Canvas paramCanvas, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat1, float paramFloat2, int paramInt, Paint paramPaint)
  {
    paramCanvas.drawRect(paramFloat1, paramFloat2 - 6.0F, paramFloat1 + 12.0F, paramFloat2 + 6.0F, paramPaint);
  }

  public void drawSeries(Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, int paramInt2)
  {
    int i = this.mDataset.getSeriesCount();
    int j = paramList.size();
    paramPaint.setColor(paramSimpleSeriesRenderer.getColor());
    paramPaint.setStyle(Paint.Style.FILL);
    float f1 = getHalfDiffX(paramList, j, i);
    for (int k = 0; k < j; k += 2)
    {
      float f2 = ((Float)paramList.get(k)).floatValue();
      drawBar(paramCanvas, f2, paramFloat, f2, ((Float)paramList.get(k + 1)).floatValue(), f1, i, paramInt1, paramPaint);
    }
    paramPaint.setColor(paramSimpleSeriesRenderer.getColor());
  }

  public String getChartType()
  {
    return "Bar";
  }

  protected float getCoeficient()
  {
    return 1.0F;
  }

  public double getDefaultMinimum()
  {
    return 0.0D;
  }

  protected float getHalfDiffX(List<Float> paramList, int paramInt1, int paramInt2)
  {
    float f1 = this.mRenderer.getBarWidth();
    if (f1 > 0.0F)
      return f1 / 2.0F;
    if (paramInt1 > 2);
    for (int i = paramInt1 - 2; ; i = paramInt1)
    {
      float f2 = (((Float)paramList.get(paramInt1 - 2)).floatValue() - ((Float)paramList.get(0)).floatValue()) / i;
      if (f2 == 0.0F)
        f2 = 10.0F;
      if (this.mType != BarChart.Type.STACKED)
        f2 /= paramInt2;
      return (float)(f2 / (getCoeficient() * (1.0D + this.mRenderer.getBarSpacing())));
    }
  }

  public int getLegendShapeWidth(int paramInt)
  {
    return 12;
  }

  protected boolean isRenderNullValues()
  {
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.BarChart
 * JD-Core Version:    0.6.2
 */