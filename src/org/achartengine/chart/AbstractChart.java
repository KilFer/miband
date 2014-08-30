package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;

public abstract class AbstractChart
  implements Serializable
{
  private static String a(String paramString, float paramFloat, Paint paramPaint)
  {
    int i = paramString.length();
    int j = 0;
    for (String str = paramString; (paramPaint.measureText(str) > paramFloat) && (j < i); str = paramString.substring(0, i - j) + "...")
      j++;
    if (j == i)
      str = "...";
    return str;
  }

  private static float[] a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    float f15;
    float f16;
    float f17;
    float f2;
    float f3;
    if (paramFloat2 > paramInt1)
    {
      f15 = (paramFloat4 - paramFloat2) / (paramFloat3 - paramFloat1);
      f16 = (paramInt1 - paramFloat2 + f15 * paramFloat1) / f15;
      f17 = paramInt1;
      if (f16 < 0.0F)
      {
        f2 = paramFloat2 - f15 * paramFloat1;
        f3 = 0.0F;
      }
    }
    float f9;
    float f10;
    float f4;
    label110: float f11;
    float f12;
    float f13;
    while (true)
      if (paramFloat4 > paramInt1)
      {
        f9 = (paramFloat4 - paramFloat2) / (paramFloat3 - paramFloat1);
        f10 = (paramInt1 - paramFloat2 + f9 * paramFloat1) / f9;
        f4 = paramInt1;
        if (f10 < 0.0F)
        {
          f4 = paramFloat2 - f9 * paramFloat1;
          return new float[] { f3, f2, f1, f4 };
          if (f16 > paramInt2)
          {
            f16 = paramInt2;
            f17 = paramFloat2 + f15 * f16 - f15 * paramFloat1;
          }
          f2 = f17;
          f3 = f16;
          continue;
          if (paramFloat2 < 0.0F)
          {
            f11 = (paramFloat4 - paramFloat2) / (paramFloat3 - paramFloat1);
            f12 = (-paramFloat2 + f11 * paramFloat1) / f11;
            if (f12 < 0.0F)
            {
              f2 = paramFloat2 - f11 * paramFloat1;
              f3 = 0.0F;
              continue;
            }
            if (f12 <= paramInt2)
              break label411;
            f13 = paramInt2;
          }
        }
      }
    for (float f14 = paramFloat2 + f11 * f13 - f11 * paramFloat1; ; f14 = 0.0F)
    {
      f2 = f14;
      f3 = f13;
      break;
      f2 = paramFloat2;
      f3 = paramFloat1;
      break;
      if (f10 > paramInt2)
      {
        f10 = paramInt2;
        f4 = paramFloat2 + f9 * f10 - f9 * paramFloat1;
      }
      f1 = f10;
      break label110;
      if (paramFloat4 < 0.0F)
      {
        float f5 = (paramFloat4 - paramFloat2) / (paramFloat3 - paramFloat1);
        float f6 = (-paramFloat2 + f5 * paramFloat1) / f5;
        if (f6 < 0.0F)
        {
          f4 = paramFloat2 - f5 * paramFloat1;
          f1 = 0.0F;
          break label110;
        }
        boolean bool = f6 < paramInt2;
        float f7 = 0.0F;
        if (bool)
        {
          f6 = paramInt2;
          f7 = paramFloat2 + f5 * f6 - f5 * paramFloat1;
        }
        float f8 = f7;
        f1 = f6;
        f4 = f8;
        break label110;
      }
      f4 = paramFloat4;
      f1 = paramFloat3;
      break label110;
      label411: f13 = f12;
    }
  }

  public abstract void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint);

  protected void drawBackground(DefaultRenderer paramDefaultRenderer, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint, boolean paramBoolean, int paramInt5)
  {
    if ((paramDefaultRenderer.isApplyBackgroundColor()) || (paramBoolean))
    {
      if (!paramBoolean)
        break label55;
      paramPaint.setColor(paramInt5);
    }
    while (true)
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramPaint);
      return;
      label55: paramPaint.setColor(paramDefaultRenderer.getBackgroundColor());
    }
  }

  protected void drawLabel(Canvas paramCanvas, String paramString, DefaultRenderer paramDefaultRenderer, List<RectF> paramList, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    int k;
    float f1;
    float f3;
    float f4;
    float f5;
    String str1;
    if ((paramDefaultRenderer.isShowLabels()) || (paramBoolean2))
    {
      paramPaint.setColor(paramInt5);
      double d1 = Math.toRadians(90.0F - (paramFloat3 + paramFloat4 / 2.0F));
      double d2 = Math.sin(d1);
      double d3 = Math.cos(d1);
      i = Math.round(paramInt1 + (float)(d2 * paramFloat1));
      j = Math.round(paramInt2 + (float)(d3 * paramFloat1));
      k = Math.round(paramInt1 + (float)(d2 * paramFloat2));
      int m = Math.round(paramInt2 + (float)(d3 * paramFloat2));
      f1 = paramDefaultRenderer.getLabelsTextSize();
      float f2 = Math.max(f1 / 2.0F, 10.0F);
      paramPaint.setTextAlign(Paint.Align.LEFT);
      if (i > k)
      {
        f2 = -f2;
        paramPaint.setTextAlign(Paint.Align.RIGHT);
      }
      f3 = f2;
      f4 = f3 + k;
      f5 = m;
      float f6 = paramInt4 - f4;
      if (i > k)
        f6 = f4 - paramInt3;
      int n = paramString.length();
      int i1 = 0;
      for (str1 = paramString; (paramPaint.measureText(str1) > f6) && (i1 < n); str1 = paramString.substring(0, n - i1) + "...")
        i1++;
      if (i1 != n)
        break label543;
    }
    label532: label543: for (String str2 = "..."; ; str2 = str1)
    {
      float f7 = paramPaint.measureText(str2);
      int i2 = 0;
      float f8 = f5;
      int i4;
      int i6;
      float f9;
      label322: float f10;
      if ((i2 == 0) && (paramBoolean1))
      {
        i4 = 0;
        int i5 = paramList.size();
        i6 = 0;
        f9 = f8;
        if ((i6 < i5) && (i4 == 0))
        {
          RectF localRectF = (RectF)paramList.get(i6);
          if (!localRectF.intersects(f4, f9, f4 + f7, f9 + f1))
            break label532;
          f10 = Math.max(f9, localRectF.bottom);
        }
      }
      for (int i7 = 1; ; i7 = i4)
      {
        i6++;
        i4 = i7;
        f9 = f10;
        break label322;
        if (i4 == 0);
        for (i2 = 1; ; i2 = 0)
        {
          f8 = f9;
          break;
        }
        if (paramBoolean1)
        {
          int i3 = (int)(f8 - f1 / 2.0F);
          paramCanvas.drawLine(i, j, k, i3, paramPaint);
          paramCanvas.drawLine(k, i3, f3 + k, i3, paramPaint);
        }
        while (true)
        {
          paramCanvas.drawText(str2, f4, f8, paramPaint);
          if (paramBoolean1)
            paramList.add(new RectF(f4, f8, f4 + f7, f8 + f1));
          return;
          paramPaint.setTextAlign(Paint.Align.CENTER);
        }
        f10 = f9;
      }
    }
  }

  protected int drawLegend(Canvas paramCanvas, DefaultRenderer paramDefaultRenderer, String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Paint paramPaint, boolean paramBoolean)
  {
    float f1 = 32.0F;
    int j;
    float f5;
    if (paramDefaultRenderer.isShowLegend())
    {
      float f2 = paramInt1;
      float f3 = 32.0F + (paramInt3 + paramInt5 - paramInt6);
      paramPaint.setTextAlign(Paint.Align.LEFT);
      paramPaint.setTextSize(paramDefaultRenderer.getLegendTextSize());
      int i = Math.min(paramArrayOfString.length, paramDefaultRenderer.getSeriesRendererCount());
      j = 0;
      if (j < i)
      {
        SimpleSeriesRenderer localSimpleSeriesRenderer = paramDefaultRenderer.getSeriesRendererAt(j);
        float f4 = getLegendShapeWidth(j);
        if (!localSimpleSeriesRenderer.isShowLegendItem())
          break label420;
        String str = paramArrayOfString[j];
        if (paramArrayOfString.length == paramDefaultRenderer.getSeriesRendererCount())
          paramPaint.setColor(localSimpleSeriesRenderer.getColor());
        float[] arrayOfFloat;
        float f6;
        while (true)
        {
          arrayOfFloat = new float[str.length()];
          paramPaint.getTextWidths(str, arrayOfFloat);
          f6 = 0.0F;
          int k = arrayOfFloat.length;
          for (int m = 0; m < k; m++)
            f6 += arrayOfFloat[m];
          paramPaint.setColor(-3355444);
        }
        float f7 = f6 + (10.0F + f4);
        float f8 = f2 + f7;
        if ((j <= 0) || (!getExceed(f8, paramDefaultRenderer, paramInt2, paramInt4)))
          break label413;
        f2 = paramInt1;
        f3 += paramDefaultRenderer.getLegendTextSize();
        float f10 = f1 + paramDefaultRenderer.getLegendTextSize();
        f8 = f2 + f7;
        f5 = f10;
        label251: if (getExceed(f8, paramDefaultRenderer, paramInt2, paramInt4))
        {
          float f9 = paramInt2 - f2 - f4 - 10.0F;
          if (isVertical(paramDefaultRenderer))
            f9 = paramInt4 - f2 - f4 - 10.0F;
          int n = paramPaint.breakText(str, true, f9, arrayOfFloat);
          str = str.substring(0, n) + "...";
        }
        if (!paramBoolean)
        {
          drawLegendShape(paramCanvas, localSimpleSeriesRenderer, f2, f3, j, paramPaint);
          drawString(paramCanvas, str, 5.0F + (f2 + f4), f3 + 5.0F, paramPaint);
        }
        f2 += f7;
      }
    }
    while (true)
    {
      j++;
      f1 = f5;
      break;
      return Math.round(f1 + paramDefaultRenderer.getLegendTextSize());
      label413: f5 = f1;
      break label251;
      label420: f5 = f1;
    }
  }

  public abstract void drawLegendShape(Canvas paramCanvas, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat1, float paramFloat2, int paramInt, Paint paramPaint);

  protected void drawPath(Canvas paramCanvas, List<Float> paramList, Paint paramPaint, boolean paramBoolean)
  {
    Path localPath = new Path();
    int i = paramCanvas.getHeight();
    int j = paramCanvas.getWidth();
    if (paramList.size() < 4)
      return;
    float[] arrayOfFloat1 = a(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue(), ((Float)paramList.get(2)).floatValue(), ((Float)paramList.get(3)).floatValue(), i, j);
    localPath.moveTo(arrayOfFloat1[0], arrayOfFloat1[1]);
    localPath.lineTo(arrayOfFloat1[2], arrayOfFloat1[3]);
    int k = paramList.size();
    for (int m = 4; m < k; m += 2)
      if (((((Float)paramList.get(m - 1)).floatValue() >= 0.0F) || (((Float)paramList.get(m + 1)).floatValue() >= 0.0F)) && ((((Float)paramList.get(m - 1)).floatValue() <= i) || (((Float)paramList.get(m + 1)).floatValue() <= i)))
      {
        float[] arrayOfFloat2 = a(((Float)paramList.get(m - 2)).floatValue(), ((Float)paramList.get(m - 1)).floatValue(), ((Float)paramList.get(m)).floatValue(), ((Float)paramList.get(m + 1)).floatValue(), i, j);
        if (!paramBoolean)
          localPath.moveTo(arrayOfFloat2[0], arrayOfFloat2[1]);
        localPath.lineTo(arrayOfFloat2[2], arrayOfFloat2[3]);
      }
    if (paramBoolean)
      localPath.lineTo(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue());
    paramCanvas.drawPath(localPath, paramPaint);
  }

  protected void drawPath(Canvas paramCanvas, float[] paramArrayOfFloat, Paint paramPaint, boolean paramBoolean)
  {
    Path localPath = new Path();
    int i = paramCanvas.getHeight();
    int j = paramCanvas.getWidth();
    if (paramArrayOfFloat.length < 4)
      return;
    float[] arrayOfFloat1 = a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3], i, j);
    localPath.moveTo(arrayOfFloat1[0], arrayOfFloat1[1]);
    localPath.lineTo(arrayOfFloat1[2], arrayOfFloat1[3]);
    int k = paramArrayOfFloat.length;
    for (int m = 4; m < k; m += 2)
      if (((paramArrayOfFloat[(m - 1)] >= 0.0F) || (paramArrayOfFloat[(m + 1)] >= 0.0F)) && ((paramArrayOfFloat[(m - 1)] <= i) || (paramArrayOfFloat[(m + 1)] <= i)))
      {
        float[] arrayOfFloat2 = a(paramArrayOfFloat[(m - 2)], paramArrayOfFloat[(m - 1)], paramArrayOfFloat[m], paramArrayOfFloat[(m + 1)], i, j);
        if (!paramBoolean)
          localPath.moveTo(arrayOfFloat2[0], arrayOfFloat2[1]);
        localPath.lineTo(arrayOfFloat2[2], arrayOfFloat2[3]);
      }
    if (paramBoolean)
      localPath.lineTo(paramArrayOfFloat[0], paramArrayOfFloat[1]);
    paramCanvas.drawPath(localPath, paramPaint);
  }

  protected void drawString(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split("\n");
      Rect localRect = new Rect();
      int i = 0;
      int j = 0;
      while (i < arrayOfString.length)
      {
        paramCanvas.drawText(arrayOfString[i], paramFloat1, paramFloat2 + j, paramPaint);
        paramPaint.getTextBounds(arrayOfString[i], 0, arrayOfString[i].length(), localRect);
        j = 5 + (j + localRect.height());
        i++;
      }
    }
  }

  protected boolean getExceed(float paramFloat, DefaultRenderer paramDefaultRenderer, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramFloat > paramInt1)
      bool = true;
    while (isVertical(paramDefaultRenderer))
      if (paramFloat > paramInt2)
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    return bool;
  }

  protected String getLabel(NumberFormat paramNumberFormat, double paramDouble)
  {
    if (paramNumberFormat != null)
      return paramNumberFormat.format(paramDouble);
    if (paramDouble == Math.round(paramDouble))
      return Math.round(paramDouble);
    return paramDouble;
  }

  public abstract int getLegendShapeWidth(int paramInt);

  protected int getLegendSize(DefaultRenderer paramDefaultRenderer, int paramInt, float paramFloat)
  {
    int i = paramDefaultRenderer.getLegendHeight();
    if ((paramDefaultRenderer.isShowLegend()) && (i == 0));
    while (true)
    {
      if ((!paramDefaultRenderer.isShowLegend()) && (paramDefaultRenderer.isShowLabels()))
        paramInt = (int)(paramFloat + 4.0F * paramDefaultRenderer.getLabelsTextSize() / 3.0F);
      return paramInt;
      paramInt = i;
    }
  }

  public SeriesSelection getSeriesAndPointForScreenCoordinate(Point paramPoint)
  {
    return null;
  }

  public boolean isNullValue(double paramDouble)
  {
    return (Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)) || (paramDouble == 1.7976931348623157E+308D);
  }

  public boolean isVertical(DefaultRenderer paramDefaultRenderer)
  {
    return ((paramDefaultRenderer instanceof XYMultipleSeriesRenderer)) && (((XYMultipleSeriesRenderer)paramDefaultRenderer).getOrientation() == XYMultipleSeriesRenderer.Orientation.VERTICAL);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.AbstractChart
 * JD-Core Version:    0.6.2
 */