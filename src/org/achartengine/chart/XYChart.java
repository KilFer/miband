package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;
import org.achartengine.util.MathHelper;

public abstract class XYChart extends AbstractChart
{
  private float a;
  private float b;
  private Point c;
  private Rect d;
  private final Map<Integer, double[]> e = new HashMap();
  private Map<Integer, List<ClickableArea>> f = new HashMap();
  protected XYMultipleSeriesDataset mDataset;
  protected XYMultipleSeriesRenderer mRenderer;

  protected XYChart()
  {
  }

  public XYChart(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer)
  {
    this.mDataset = paramXYMultipleSeriesDataset;
    this.mRenderer = paramXYMultipleSeriesRenderer;
  }

  private static int a(Paint.Align paramAlign)
  {
    int i = 4;
    if (paramAlign == Paint.Align.LEFT)
      i = -4;
    return i;
  }

  private static List<Double> a(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Double localDouble = (Double)localIterator.next();
      if (localDouble.isNaN())
        localArrayList.remove(localDouble);
    }
    return localArrayList;
  }

  private void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCanvas.scale(1.0F / this.a, this.a);
      paramCanvas.translate(this.b, -this.b);
      paramCanvas.rotate(-paramFloat, this.c.getX(), this.c.getY());
      return;
    }
    paramCanvas.rotate(paramFloat, this.c.getX(), this.c.getY());
    paramCanvas.translate(-this.b, this.b);
    paramCanvas.scale(this.a, 1.0F / this.a);
  }

  private static void a(Paint.Cap paramCap, Paint.Join paramJoin, float paramFloat, Paint.Style paramStyle, PathEffect paramPathEffect, Paint paramPaint)
  {
    paramPaint.setStrokeCap(paramCap);
    paramPaint.setStrokeJoin(paramJoin);
    paramPaint.setStrokeMiter(paramFloat);
    paramPaint.setPathEffect(paramPathEffect);
    paramPaint.setStyle(paramStyle);
  }

  protected abstract ClickableArea[] clickableAreasForPoints(List<Float> paramList, List<Double> paramList1, float paramFloat, int paramInt1, int paramInt2);

  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    paramPaint.setAntiAlias(this.mRenderer.isAntialiasing());
    int i = getLegendSize(this.mRenderer, paramInt4 / 5, this.mRenderer.getAxisTitleTextSize());
    int[] arrayOfInt = this.mRenderer.getMargins();
    int j = paramInt1 + arrayOfInt[1];
    int k = paramInt2 + arrayOfInt[0];
    int m = paramInt1 + paramInt3 - arrayOfInt[3];
    int n = this.mDataset.getSeriesCount();
    String[] arrayOfString = new String[n];
    for (int i1 = 0; i1 < n; i1++)
      arrayOfString[i1] = this.mDataset.getSeriesAt(i1).getTitle();
    int i2;
    int i3;
    XYMultipleSeriesRenderer.Orientation localOrientation;
    int i4;
    int i5;
    label367: int i6;
    int i7;
    label532: int i10;
    label549: double[] arrayOfDouble1;
    double[] arrayOfDouble2;
    double[] arrayOfDouble3;
    double[] arrayOfDouble4;
    double[] arrayOfDouble5;
    double[] arrayOfDouble6;
    int i14;
    int i15;
    label1148: XYSeries localXYSeries1;
    int i34;
    SimpleSeriesRenderer localSimpleSeriesRenderer;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    float f3;
    LinkedList localLinkedList;
    int i35;
    int i36;
    Rect localRect;
    if ((this.mRenderer.isFitLegend()) && (this.mRenderer.isShowLegend()))
    {
      i2 = drawLegend(paramCanvas, this.mRenderer, arrayOfString, j, m, paramInt2, paramInt3, paramInt4, i, paramPaint, true);
      i3 = paramInt2 + paramInt4 - arrayOfInt[2] - i2;
      if (this.d == null)
        this.d = new Rect();
      this.d.set(j, k, m, i3);
      drawBackground(this.mRenderer, paramCanvas, paramInt1, paramInt2, paramInt3, paramInt4, paramPaint, false, 0);
      if ((paramPaint.getTypeface() == null) || ((this.mRenderer.getTextTypeface() != null) && (paramPaint.getTypeface().equals(this.mRenderer.getTextTypeface()))) || (!paramPaint.getTypeface().toString().equals(this.mRenderer.getTextTypefaceName())) || (paramPaint.getTypeface().getStyle() != this.mRenderer.getTextTypefaceStyle()))
      {
        if (this.mRenderer.getTextTypeface() != null)
          paramPaint.setTypeface(this.mRenderer.getTextTypeface());
      }
      else
      {
        localOrientation = this.mRenderer.getOrientation();
        if (localOrientation != XYMultipleSeriesRenderer.Orientation.VERTICAL)
          break label3402;
        int i39 = m - i2;
        i4 = i3 + (i2 - 20);
        i5 = i39;
        i6 = localOrientation.getAngle();
        if (i6 != 90)
          break label532;
      }
      int i8;
      for (i7 = 1; ; i7 = 0)
      {
        this.a = (paramInt4 / paramInt3);
        this.b = (Math.abs(paramInt3 - paramInt4) / 2);
        if (this.a < 1.0F)
          this.b = (-this.b);
        this.c = new Point((paramInt1 + paramInt3) / 2, (paramInt2 + paramInt4) / 2);
        if (i7 != 0)
          a(paramCanvas, i6, false);
        i8 = -2147483647;
        for (int i9 = 0; i9 < n; i9++)
          i8 = Math.max(i8, this.mDataset.getSeriesAt(i9).getScaleNumber());
        paramPaint.setTypeface(Typeface.create(this.mRenderer.getTextTypefaceName(), this.mRenderer.getTextTypefaceStyle()));
        break;
      }
      i10 = i8 + 1;
      if (i10 < 0)
        return;
      arrayOfDouble1 = new double[i10];
      arrayOfDouble2 = new double[i10];
      arrayOfDouble3 = new double[i10];
      arrayOfDouble4 = new double[i10];
      boolean[] arrayOfBoolean1 = new boolean[i10];
      boolean[] arrayOfBoolean2 = new boolean[i10];
      boolean[] arrayOfBoolean3 = new boolean[i10];
      boolean[] arrayOfBoolean4 = new boolean[i10];
      for (int i11 = 0; i11 < i10; i11++)
      {
        arrayOfDouble1[i11] = this.mRenderer.getXAxisMin(i11);
        arrayOfDouble2[i11] = this.mRenderer.getXAxisMax(i11);
        arrayOfDouble3[i11] = this.mRenderer.getYAxisMin(i11);
        arrayOfDouble4[i11] = this.mRenderer.getYAxisMax(i11);
        arrayOfBoolean1[i11] = this.mRenderer.isMinXSet(i11);
        arrayOfBoolean2[i11] = this.mRenderer.isMaxXSet(i11);
        arrayOfBoolean3[i11] = this.mRenderer.isMinYSet(i11);
        arrayOfBoolean4[i11] = this.mRenderer.isMaxYSet(i11);
        if (this.e.get(Integer.valueOf(i11)) == null)
          this.e.put(Integer.valueOf(i11), new double[4]);
      }
      arrayOfDouble5 = new double[i10];
      arrayOfDouble6 = new double[i10];
      for (int i12 = 0; i12 < n; i12++)
      {
        XYSeries localXYSeries2 = this.mDataset.getSeriesAt(i12);
        int i38 = localXYSeries2.getScaleNumber();
        if (localXYSeries2.getItemCount() != 0)
        {
          if (arrayOfBoolean1[i38] == 0)
          {
            double d9 = localXYSeries2.getMinX();
            arrayOfDouble1[i38] = Math.min(arrayOfDouble1[i38], d9);
            ((double[])this.e.get(Integer.valueOf(i38)))[0] = arrayOfDouble1[i38];
          }
          if (arrayOfBoolean2[i38] == 0)
          {
            double d8 = localXYSeries2.getMaxX();
            arrayOfDouble2[i38] = Math.max(arrayOfDouble2[i38], d8);
            ((double[])this.e.get(Integer.valueOf(i38)))[1] = arrayOfDouble2[i38];
          }
          if (arrayOfBoolean3[i38] == 0)
          {
            double d7 = localXYSeries2.getMinY();
            arrayOfDouble3[i38] = Math.min(arrayOfDouble3[i38], (float)d7);
            ((double[])this.e.get(Integer.valueOf(i38)))[2] = arrayOfDouble3[i38];
          }
          if (arrayOfBoolean4[i38] == 0)
          {
            double d6 = localXYSeries2.getMaxY();
            arrayOfDouble4[i38] = Math.max(arrayOfDouble4[i38], (float)d6);
            ((double[])this.e.get(Integer.valueOf(i38)))[3] = arrayOfDouble4[i38];
          }
        }
      }
      for (int i13 = 0; i13 < i10; i13++)
      {
        if (arrayOfDouble2[i13] - arrayOfDouble1[i13] != 0.0D)
          arrayOfDouble5[i13] = ((i5 - j) / (arrayOfDouble2[i13] - arrayOfDouble1[i13]));
        if (arrayOfDouble4[i13] - arrayOfDouble3[i13] != 0.0D)
          arrayOfDouble6[i13] = ((float)((i4 - k) / (arrayOfDouble4[i13] - arrayOfDouble3[i13])));
      }
      i14 = 0;
      this.f = new HashMap();
      i15 = 0;
      if (i15 < n)
      {
        localXYSeries1 = this.mDataset.getSeriesAt(i15);
        i34 = localXYSeries1.getScaleNumber();
        if (localXYSeries1.getItemCount() != 0)
        {
          localSimpleSeriesRenderer = this.mRenderer.getSeriesRendererAt(i15);
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          f3 = Math.min(i4, (float)(i4 + arrayOfDouble6[i34] * arrayOfDouble3[i34]));
          localLinkedList = new LinkedList();
          this.f.put(Integer.valueOf(i15), localLinkedList);
          while (true)
          {
            double d4;
            try
            {
              SortedMap localSortedMap = localXYSeries1.getRange(arrayOfDouble1[i34], arrayOfDouble2[i34], localSimpleSeriesRenderer.isDisplayBoundingPoints());
              i35 = -1;
              Iterator localIterator = localSortedMap.entrySet().iterator();
              if (!localIterator.hasNext())
                break;
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              d4 = ((Double)localEntry.getKey()).doubleValue();
              double d5 = ((Double)localEntry.getValue()).doubleValue();
              if ((i35 < 0) && ((!isNullValue(d5)) || (isRenderNullValues())))
                i35 = localXYSeries1.getIndexForKey(d4);
              localArrayList2.add(localEntry.getKey());
              localArrayList2.add(localEntry.getValue());
              if (!isNullValue(d5))
              {
                localArrayList1.add(Float.valueOf((float)(j + arrayOfDouble5[i34] * (d4 - arrayOfDouble1[i34]))));
                localArrayList1.add(Float.valueOf((float)(i4 - arrayOfDouble6[i34] * (d5 - arrayOfDouble3[i34]))));
                continue;
              }
            }
            finally
            {
            }
            if (isRenderNullValues())
            {
              localArrayList1.add(Float.valueOf((float)(j + arrayOfDouble5[i34] * (d4 - arrayOfDouble1[i34]))));
              localArrayList1.add(Float.valueOf((float)(i4 - arrayOfDouble6[i34] * -arrayOfDouble3[i34])));
            }
            else
            {
              if (localArrayList1.size() > 0)
              {
                drawSeries(localXYSeries1, paramCanvas, paramPaint, localArrayList1, localSimpleSeriesRenderer, f3, i15, localOrientation, i35);
                localLinkedList.addAll(Arrays.asList(clickableAreasForPoints(localArrayList1, localArrayList2, f3, i15, i35)));
                localArrayList1.clear();
                localArrayList2.clear();
                i35 = -1;
              }
              localLinkedList.add(null);
            }
          }
          i36 = localXYSeries1.getAnnotationCount();
          if (i36 > 0)
          {
            paramPaint.setColor(this.mRenderer.getLabelsColor());
            localRect = new Rect();
          }
        }
      }
    }
    for (int i37 = 0; ; i37++)
      if (i37 < i36)
      {
        float f4 = (float)(j + arrayOfDouble5[i34] * (localXYSeries1.getAnnotationX(i37) - arrayOfDouble1[i34]));
        float f5 = (float)(i4 - arrayOfDouble6[i34] * (localXYSeries1.getAnnotationY(i37) - arrayOfDouble3[i34]));
        paramPaint.getTextBounds(localXYSeries1.getAnnotationAt(i37), 0, localXYSeries1.getAnnotationAt(i37).length(), localRect);
        if ((f4 < f4 + localRect.width()) && (f5 < paramCanvas.getHeight()))
          drawString(paramCanvas, localXYSeries1.getAnnotationAt(i37), f4, f5, paramPaint);
      }
      else
      {
        if (localArrayList1.size() > 0)
        {
          drawSeries(localXYSeries1, paramCanvas, paramPaint, localArrayList1, localSimpleSeriesRenderer, f3, i15, localOrientation, i35);
          localLinkedList.addAll(Arrays.asList(clickableAreasForPoints(localArrayList1, localArrayList2, f3, i15, i35)));
        }
        i14 = 1;
        i15++;
        break label1148;
        XYMultipleSeriesRenderer localXYMultipleSeriesRenderer1 = this.mRenderer;
        int i16 = paramInt4 - i4;
        int i17 = this.mRenderer.getMarginsColor();
        drawBackground(localXYMultipleSeriesRenderer1, paramCanvas, paramInt1, i4, paramInt3, i16, paramPaint, true, i17);
        drawBackground(this.mRenderer, paramCanvas, paramInt1, paramInt2, paramInt3, arrayOfInt[0], paramPaint, true, this.mRenderer.getMarginsColor());
        int i21;
        label2045: boolean bool2;
        if (localOrientation == XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
        {
          drawBackground(this.mRenderer, paramCanvas, paramInt1, paramInt2, j - paramInt1, paramInt4 - paramInt2, paramPaint, true, this.mRenderer.getMarginsColor());
          XYMultipleSeriesRenderer localXYMultipleSeriesRenderer5 = this.mRenderer;
          int i31 = arrayOfInt[3];
          int i32 = paramInt4 - paramInt2;
          int i33 = this.mRenderer.getMarginsColor();
          drawBackground(localXYMultipleSeriesRenderer5, paramCanvas, i5, paramInt2, i31, i32, paramPaint, true, i33);
          if ((!this.mRenderer.isShowLabels()) || (i14 == 0))
            break label2578;
          i21 = 1;
          boolean bool1 = this.mRenderer.isShowGridX();
          bool2 = this.mRenderer.isShowCustomTextGrid();
          if ((i21 == 0) && (!bool1))
            break label2975;
          List localList = a(getXLabels(arrayOfDouble1[0], arrayOfDouble2[0], this.mRenderer.getXLabels()));
          Map localMap = getYLabels(arrayOfDouble3, arrayOfDouble4, i10);
          if (i21 != 0)
          {
            paramPaint.setColor(this.mRenderer.getXLabelsColor());
            paramPaint.setTextSize(this.mRenderer.getLabelsTextSize());
            paramPaint.setTextAlign(this.mRenderer.getXLabelsAlign());
          }
          Double[] arrayOfDouble7 = this.mRenderer.getXTextLabelLocations();
          double d1 = arrayOfDouble5[0];
          double d2 = arrayOfDouble1[0];
          double d3 = arrayOfDouble2[0];
          drawXLabels(localList, arrayOfDouble7, paramCanvas, paramPaint, j, k, i4, d1, d2, d3);
          drawYLabels(localMap, paramCanvas, paramPaint, i10, j, i5, i4, arrayOfDouble6, arrayOfDouble3);
          if (i21 == 0)
            break label2734;
          paramPaint.setColor(this.mRenderer.getLabelsColor());
        }
        label2452: label2584: label2638: for (int i28 = 0; ; i28++)
        {
          if (i28 >= i10)
            break label2734;
          Paint.Align localAlign = this.mRenderer.getYAxisAlign(i28);
          Double[] arrayOfDouble8 = this.mRenderer.getYTextLabelLocations(i28);
          int i29 = arrayOfDouble8.length;
          int i30 = 0;
          label2278: if (i30 < i29)
          {
            Double localDouble = arrayOfDouble8[i30];
            float f2;
            String str;
            if ((arrayOfDouble3[i28] <= localDouble.doubleValue()) && (localDouble.doubleValue() <= arrayOfDouble4[i28]))
            {
              f2 = (float)(i4 - arrayOfDouble6[i28] * (localDouble.doubleValue() - arrayOfDouble3[i28]));
              str = this.mRenderer.getYTextLabel(localDouble, i28);
              paramPaint.setColor(this.mRenderer.getYLabelsColor(i28));
              paramPaint.setTextAlign(this.mRenderer.getYLabelsAlign(i28));
              if (localOrientation != XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
                break label2638;
              if (localAlign != Paint.Align.LEFT)
                break label2584;
              paramCanvas.drawLine(j + a(localAlign), f2, j, f2, paramPaint);
              drawText(paramCanvas, str, j, f2 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
              if (bool2)
              {
                paramPaint.setColor(this.mRenderer.getGridColor());
                paramCanvas.drawLine(j, f2, i5, f2, paramPaint);
              }
            }
            while (true)
            {
              i30++;
              break label2278;
              if (localOrientation != XYMultipleSeriesRenderer.Orientation.VERTICAL)
                break;
              XYMultipleSeriesRenderer localXYMultipleSeriesRenderer2 = this.mRenderer;
              int i18 = paramInt3 - i5;
              int i19 = paramInt4 - paramInt2;
              int i20 = this.mRenderer.getMarginsColor();
              drawBackground(localXYMultipleSeriesRenderer2, paramCanvas, i5, paramInt2, i18, i19, paramPaint, true, i20);
              drawBackground(this.mRenderer, paramCanvas, paramInt1, paramInt2, j - paramInt1, paramInt4 - paramInt2, paramPaint, true, this.mRenderer.getMarginsColor());
              break;
              i21 = 0;
              break label2045;
              paramCanvas.drawLine(i5, f2, i5 + a(localAlign), f2, paramPaint);
              drawText(paramCanvas, str, i5, f2 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
              break label2452;
              paramCanvas.drawLine(i5 - a(localAlign), f2, i5, f2, paramPaint);
              drawText(paramCanvas, str, i5 + 10, f2 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
              if (bool2)
              {
                paramPaint.setColor(this.mRenderer.getGridColor());
                paramCanvas.drawLine(i5, f2, j, f2, paramPaint);
              }
            }
          }
        }
        label2578: label2734: float f1;
        label2975: label3026: int i23;
        int i24;
        if (i21 != 0)
        {
          paramPaint.setColor(this.mRenderer.getLabelsColor());
          f1 = this.mRenderer.getAxisTitleTextSize();
          paramPaint.setTextSize(f1);
          paramPaint.setTextAlign(Paint.Align.CENTER);
          if (localOrientation == XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
          {
            drawText(paramCanvas, this.mRenderer.getXTitle(), paramInt1 + paramInt3 / 2, f1 + (i4 + 4.0F * this.mRenderer.getLabelsTextSize() / 3.0F + this.mRenderer.getXLabelsPadding()), paramPaint, 0.0F);
            int i27 = 0;
            if (i27 < i10)
            {
              if (this.mRenderer.getYAxisAlign(i27) == Paint.Align.LEFT)
                drawText(paramCanvas, this.mRenderer.getYTitle(i27), f1 + paramInt1, paramInt2 + paramInt4 / 2, paramPaint, -90.0F);
              while (true)
              {
                i27++;
                break;
                drawText(paramCanvas, this.mRenderer.getYTitle(i27), paramInt1 + paramInt3, paramInt2 + paramInt4 / 2, paramPaint, -90.0F);
              }
            }
            paramPaint.setTextSize(this.mRenderer.getChartTitleTextSize());
            drawText(paramCanvas, this.mRenderer.getChartTitle(), paramInt1 + paramInt3 / 2, paramInt2 + this.mRenderer.getChartTitleTextSize(), paramPaint, 0.0F);
          }
        }
        else
        {
          if (localOrientation != XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
            break label3231;
          XYMultipleSeriesRenderer localXYMultipleSeriesRenderer4 = this.mRenderer;
          int i26 = paramInt2 + (int)this.mRenderer.getXLabelsPadding();
          drawLegend(paramCanvas, localXYMultipleSeriesRenderer4, arrayOfString, j, i5, i26, paramInt3, paramInt4, i2, paramPaint, false);
          if (!this.mRenderer.isShowAxes())
            break label3358;
          paramPaint.setColor(this.mRenderer.getAxesColor());
          paramCanvas.drawLine(j, i4, i5, i4, paramPaint);
          i23 = 0;
          i24 = 0;
          label3072: if ((i23 >= i10) || (i24 != 0))
            break label3309;
          if (this.mRenderer.getYAxisAlign(i23) != Paint.Align.RIGHT)
            break label3303;
        }
        label3231: label3303: for (int i25 = 1; ; i25 = 0)
        {
          i23++;
          i24 = i25;
          break label3072;
          if (localOrientation != XYMultipleSeriesRenderer.Orientation.VERTICAL)
            break;
          drawText(paramCanvas, this.mRenderer.getXTitle(), paramInt1 + paramInt3 / 2, paramInt2 + paramInt4 - f1 + this.mRenderer.getXLabelsPadding(), paramPaint, -90.0F);
          drawText(paramCanvas, this.mRenderer.getYTitle(), i5 + 20, paramInt2 + paramInt4 / 2, paramPaint, 0.0F);
          paramPaint.setTextSize(this.mRenderer.getChartTitleTextSize());
          drawText(paramCanvas, this.mRenderer.getChartTitle(), f1 + paramInt1, k + paramInt4 / 2, paramPaint, 0.0F);
          break;
          if (localOrientation != XYMultipleSeriesRenderer.Orientation.VERTICAL)
            break label3026;
          a(paramCanvas, i6, true);
          XYMultipleSeriesRenderer localXYMultipleSeriesRenderer3 = this.mRenderer;
          int i22 = paramInt2 + (int)this.mRenderer.getXLabelsPadding();
          drawLegend(paramCanvas, localXYMultipleSeriesRenderer3, arrayOfString, j, i5, i22, paramInt3, paramInt4, i2, paramPaint, false);
          a(paramCanvas, i6, false);
          break label3026;
        }
        label3309: if (localOrientation == XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
        {
          paramCanvas.drawLine(j, k, j, i4, paramPaint);
          if (i24 != 0)
            paramCanvas.drawLine(i5, k, i5, i4, paramPaint);
        }
        label3358: 
        while (i7 != 0)
        {
          a(paramCanvas, i6, true);
          return;
          if (localOrientation == XYMultipleSeriesRenderer.Orientation.VERTICAL)
            paramCanvas.drawLine(i5, k, i5, i4, paramPaint);
        }
        break label549;
        label3402: i4 = i3;
        i5 = m;
        break label367;
        i2 = i;
        break;
      }
  }

  protected void drawChartValuesText(Canvas paramCanvas, XYSeries paramXYSeries, SimpleSeriesRenderer paramSimpleSeriesRenderer, Paint paramPaint, List<Float> paramList, int paramInt1, int paramInt2)
  {
    if (paramList.size() > 1)
    {
      float f1 = ((Float)paramList.get(0)).floatValue();
      float f2 = ((Float)paramList.get(1)).floatValue();
      int j = 0;
      if (j < paramList.size())
      {
        if (j == 2)
          if ((Math.abs(((Float)paramList.get(2)).floatValue() - ((Float)paramList.get(0)).floatValue()) > paramSimpleSeriesRenderer.getDisplayChartValuesDistance()) || (Math.abs(((Float)paramList.get(3)).floatValue() - ((Float)paramList.get(1)).floatValue()) > paramSimpleSeriesRenderer.getDisplayChartValuesDistance()))
          {
            drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), paramXYSeries.getY(paramInt2)), ((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue() - paramSimpleSeriesRenderer.getChartValuesSpacing(), paramPaint, 0.0F);
            drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), paramXYSeries.getY(paramInt2 + 1)), ((Float)paramList.get(2)).floatValue(), ((Float)paramList.get(3)).floatValue() - paramSimpleSeriesRenderer.getChartValuesSpacing(), paramPaint, 0.0F);
            f1 = ((Float)paramList.get(2)).floatValue();
          }
        for (f2 = ((Float)paramList.get(3)).floatValue(); ; f2 = ((Float)paramList.get(j + 1)).floatValue())
        {
          do
          {
            j += 2;
            break;
          }
          while ((j <= 2) || ((Math.abs(((Float)paramList.get(j)).floatValue() - f1) <= paramSimpleSeriesRenderer.getDisplayChartValuesDistance()) && (Math.abs(((Float)paramList.get(j + 1)).floatValue() - f2) <= paramSimpleSeriesRenderer.getDisplayChartValuesDistance())));
          drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), paramXYSeries.getY(paramInt2 + j / 2)), ((Float)paramList.get(j)).floatValue(), ((Float)paramList.get(j + 1)).floatValue() - paramSimpleSeriesRenderer.getChartValuesSpacing(), paramPaint, 0.0F);
          f1 = ((Float)paramList.get(j)).floatValue();
        }
      }
    }
    else
    {
      for (int i = 0; i < paramList.size(); i += 2)
        drawText(paramCanvas, getLabel(paramSimpleSeriesRenderer.getChartValuesFormat(), paramXYSeries.getY(paramInt2 + i / 2)), ((Float)paramList.get(i)).floatValue(), ((Float)paramList.get(i + 1)).floatValue() - paramSimpleSeriesRenderer.getChartValuesSpacing(), paramPaint, 0.0F);
    }
  }

  public abstract void drawSeries(Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, int paramInt2);

  protected void drawSeries(XYSeries paramXYSeries, Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, XYMultipleSeriesRenderer.Orientation paramOrientation, int paramInt2)
  {
    BasicStroke localBasicStroke = paramSimpleSeriesRenderer.getStroke();
    Paint.Cap localCap = paramPaint.getStrokeCap();
    Paint.Join localJoin = paramPaint.getStrokeJoin();
    float f1 = paramPaint.getStrokeMiter();
    PathEffect localPathEffect = paramPaint.getPathEffect();
    Paint.Style localStyle = paramPaint.getStyle();
    if (localBasicStroke != null)
    {
      float[] arrayOfFloat = localBasicStroke.getIntervals();
      DashPathEffect localDashPathEffect = null;
      if (arrayOfFloat != null)
        localDashPathEffect = new DashPathEffect(localBasicStroke.getIntervals(), localBasicStroke.getPhase());
      a(localBasicStroke.getCap(), localBasicStroke.getJoin(), localBasicStroke.getMiter(), Paint.Style.FILL_AND_STROKE, localDashPathEffect, paramPaint);
    }
    drawSeries(paramCanvas, paramPaint, paramList, paramSimpleSeriesRenderer, paramFloat, paramInt1, paramInt2);
    if (isRenderPoints(paramSimpleSeriesRenderer))
    {
      ScatterChart localScatterChart = getPointsChart();
      if (localScatterChart != null)
        localScatterChart.drawSeries(paramCanvas, paramPaint, paramList, paramSimpleSeriesRenderer, paramFloat, paramInt1, paramInt2);
    }
    paramPaint.setTextSize(paramSimpleSeriesRenderer.getChartValuesTextSize());
    if (paramOrientation == XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
      paramPaint.setTextAlign(Paint.Align.CENTER);
    while (true)
    {
      if (paramSimpleSeriesRenderer.isDisplayChartValues())
      {
        paramPaint.setTextAlign(paramSimpleSeriesRenderer.getChartValuesTextAlign());
        drawChartValuesText(paramCanvas, paramXYSeries, paramSimpleSeriesRenderer, paramPaint, paramList, paramInt1, paramInt2);
      }
      if (localBasicStroke != null)
        a(localCap, localJoin, f1, localStyle, localPathEffect, paramPaint);
      return;
      paramPaint.setTextAlign(Paint.Align.LEFT);
    }
  }

  protected void drawText(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint, float paramFloat3)
  {
    float f1 = paramFloat3 + -this.mRenderer.getOrientation().getAngle();
    if (f1 != 0.0F)
      paramCanvas.rotate(f1, paramFloat1, paramFloat2);
    drawString(paramCanvas, paramString, paramFloat1, paramFloat2, paramPaint);
    if (f1 != 0.0F)
      paramCanvas.rotate(-f1, paramFloat1, paramFloat2);
  }

  protected void drawXLabels(List<Double> paramList, Double[] paramArrayOfDouble, Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    int i = paramList.size();
    boolean bool1 = this.mRenderer.isShowLabels();
    boolean bool2 = this.mRenderer.isShowGridY();
    for (int j = 0; j < i; j++)
    {
      double d1 = ((Double)paramList.get(j)).doubleValue();
      float f1 = (float)(paramInt1 + paramDouble1 * (d1 - paramDouble2));
      if (bool1)
      {
        paramPaint.setColor(this.mRenderer.getXLabelsColor());
        paramCanvas.drawLine(f1, paramInt3, f1, paramInt3 + this.mRenderer.getLabelsTextSize() / 3.0F, paramPaint);
        drawText(paramCanvas, getLabel(this.mRenderer.getLabelFormat(), d1), f1, paramInt3 + 4.0F * this.mRenderer.getLabelsTextSize() / 3.0F + this.mRenderer.getXLabelsPadding(), paramPaint, this.mRenderer.getXLabelsAngle());
      }
      if (bool2)
      {
        paramPaint.setColor(this.mRenderer.getGridColor());
        paramCanvas.drawLine(f1, paramInt3, f1, paramInt2, paramPaint);
      }
    }
    drawXTextLabels(paramArrayOfDouble, paramCanvas, paramPaint, bool1, paramInt1, paramInt2, paramInt3, paramDouble1, paramDouble2, paramDouble3);
  }

  protected void drawXTextLabels(Double[] paramArrayOfDouble, Canvas paramCanvas, Paint paramPaint, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    boolean bool = this.mRenderer.isShowCustomTextGrid();
    if (paramBoolean)
    {
      paramPaint.setColor(this.mRenderer.getXLabelsColor());
      int i = paramArrayOfDouble.length;
      for (int j = 0; j < i; j++)
      {
        Double localDouble = paramArrayOfDouble[j];
        if ((paramDouble2 <= localDouble.doubleValue()) && (localDouble.doubleValue() <= paramDouble3))
        {
          float f1 = (float)(paramInt1 + paramDouble1 * (localDouble.doubleValue() - paramDouble2));
          paramPaint.setColor(this.mRenderer.getXLabelsColor());
          paramCanvas.drawLine(f1, paramInt3, f1, paramInt3 + this.mRenderer.getLabelsTextSize() / 3.0F, paramPaint);
          drawText(paramCanvas, this.mRenderer.getXTextLabel(localDouble), f1, paramInt3 + 4.0F * this.mRenderer.getLabelsTextSize() / 3.0F, paramPaint, this.mRenderer.getXLabelsAngle());
          if (bool)
          {
            paramPaint.setColor(this.mRenderer.getGridColor());
            paramCanvas.drawLine(f1, paramInt3, f1, paramInt2, paramPaint);
          }
        }
      }
    }
  }

  protected void drawYLabels(Map<Integer, List<Double>> paramMap, Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    XYMultipleSeriesRenderer.Orientation localOrientation = this.mRenderer.getOrientation();
    boolean bool1 = this.mRenderer.isShowGridX();
    boolean bool2 = this.mRenderer.isShowLabels();
    for (int i = 0; i < paramInt1; i++)
    {
      paramPaint.setTextAlign(this.mRenderer.getYLabelsAlign(i));
      List localList = (List)paramMap.get(Integer.valueOf(i));
      int j = localList.size();
      int k = 0;
      if (k < j)
      {
        double d1 = ((Double)localList.get(k)).doubleValue();
        Paint.Align localAlign = this.mRenderer.getYAxisAlign(i);
        int m;
        label133: float f1;
        if (this.mRenderer.getYTextLabel(Double.valueOf(d1), i) != null)
        {
          m = 1;
          f1 = (float)(paramInt4 - paramArrayOfDouble1[i] * (d1 - paramArrayOfDouble2[i]));
          if (localOrientation != XYMultipleSeriesRenderer.Orientation.HORIZONTAL)
            break label375;
          if ((bool2) && (m == 0))
          {
            paramPaint.setColor(this.mRenderer.getYLabelsColor(i));
            if (localAlign != Paint.Align.LEFT)
              break label304;
            paramCanvas.drawLine(paramInt2 + a(localAlign), f1, paramInt2, f1, paramPaint);
            drawText(paramCanvas, getLabel(this.mRenderer.getLabelFormat(), d1), paramInt2 - this.mRenderer.getYLabelsPadding(), f1 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
          }
          label261: if (bool1)
          {
            paramPaint.setColor(this.mRenderer.getGridColor());
            paramCanvas.drawLine(paramInt2, f1, paramInt3, f1, paramPaint);
          }
        }
        while (true)
        {
          k++;
          break;
          m = 0;
          break label133;
          label304: paramCanvas.drawLine(paramInt3, f1, paramInt3 + a(localAlign), f1, paramPaint);
          drawText(paramCanvas, getLabel(this.mRenderer.getLabelFormat(), d1), paramInt3 + this.mRenderer.getYLabelsPadding(), f1 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
          break label261;
          label375: if (localOrientation == XYMultipleSeriesRenderer.Orientation.VERTICAL)
          {
            if ((bool2) && (m == 0))
            {
              paramPaint.setColor(this.mRenderer.getYLabelsColor(i));
              paramCanvas.drawLine(paramInt3 - a(localAlign), f1, paramInt3, f1, paramPaint);
              drawText(paramCanvas, getLabel(this.mRenderer.getLabelFormat(), d1), paramInt3 + 10 + this.mRenderer.getYLabelsPadding(), f1 - this.mRenderer.getYLabelsVerticalPadding(), paramPaint, this.mRenderer.getYLabelsAngle());
            }
            if (bool1)
            {
              paramPaint.setColor(this.mRenderer.getGridColor());
              paramCanvas.drawLine(paramInt3, f1, paramInt2, f1, paramPaint);
            }
          }
        }
      }
    }
  }

  public double[] getCalcRange(int paramInt)
  {
    return (double[])this.e.get(Integer.valueOf(paramInt));
  }

  public abstract String getChartType();

  public XYMultipleSeriesDataset getDataset()
  {
    return this.mDataset;
  }

  public double getDefaultMinimum()
  {
    return 1.7976931348623157E+308D;
  }

  public ScatterChart getPointsChart()
  {
    return null;
  }

  public XYMultipleSeriesRenderer getRenderer()
  {
    return this.mRenderer;
  }

  protected Rect getScreenR()
  {
    return this.d;
  }

  public SeriesSelection getSeriesAndPointForScreenCoordinate(Point paramPoint)
  {
    if (this.f != null)
      for (int i = -1 + this.f.size(); i >= 0; i--)
      {
        int j = 0;
        if (this.f.get(Integer.valueOf(i)) != null)
        {
          Iterator localIterator = ((List)this.f.get(Integer.valueOf(i))).iterator();
          while (localIterator.hasNext())
          {
            ClickableArea localClickableArea = (ClickableArea)localIterator.next();
            if (localClickableArea != null)
            {
              RectF localRectF = localClickableArea.getRect();
              if ((localRectF != null) && (localRectF.contains(paramPoint.getX(), paramPoint.getY())))
                return new SeriesSelection(i, j, localClickableArea.getX(), localClickableArea.getY());
            }
            j++;
          }
        }
      }
    return super.getSeriesAndPointForScreenCoordinate(paramPoint);
  }

  protected List<Double> getXLabels(double paramDouble1, double paramDouble2, int paramInt)
  {
    return MathHelper.getLabels(paramDouble1, paramDouble2, paramInt);
  }

  protected Map<Integer, List<Double>> getYLabels(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramInt; i++)
      localHashMap.put(Integer.valueOf(i), a(MathHelper.getLabels(paramArrayOfDouble1[i], paramArrayOfDouble2[i], this.mRenderer.getYLabels())));
    return localHashMap;
  }

  protected boolean isRenderNullValues()
  {
    return false;
  }

  public boolean isRenderPoints(SimpleSeriesRenderer paramSimpleSeriesRenderer)
  {
    return false;
  }

  public void setCalcRange(double[] paramArrayOfDouble, int paramInt)
  {
    this.e.put(Integer.valueOf(paramInt), paramArrayOfDouble);
  }

  protected void setDatasetRenderer(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer)
  {
    this.mDataset = paramXYMultipleSeriesDataset;
    this.mRenderer = paramXYMultipleSeriesRenderer;
  }

  protected void setScreenR(Rect paramRect)
  {
    this.d = paramRect;
  }

  public double[] toRealPoint(float paramFloat1, float paramFloat2)
  {
    return toRealPoint(paramFloat1, paramFloat2, 0);
  }

  public double[] toRealPoint(float paramFloat1, float paramFloat2, int paramInt)
  {
    double d1 = this.mRenderer.getXAxisMin(paramInt);
    double d2 = this.mRenderer.getXAxisMax(paramInt);
    double d3 = this.mRenderer.getYAxisMin(paramInt);
    double d4 = this.mRenderer.getYAxisMax(paramInt);
    if (this.d != null)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = (d1 + (paramFloat1 - this.d.left) * (d2 - d1) / this.d.width());
      arrayOfDouble2[1] = (d3 + (this.d.top + this.d.height() - paramFloat2) * (d4 - d3) / this.d.height());
      return arrayOfDouble2;
    }
    double[] arrayOfDouble1 = new double[2];
    arrayOfDouble1[0] = paramFloat1;
    arrayOfDouble1[1] = paramFloat2;
    return arrayOfDouble1;
  }

  public double[] toScreenPoint(double[] paramArrayOfDouble)
  {
    return toScreenPoint(paramArrayOfDouble, 0);
  }

  public double[] toScreenPoint(double[] paramArrayOfDouble, int paramInt)
  {
    double d1 = this.mRenderer.getXAxisMin(paramInt);
    double d2 = this.mRenderer.getXAxisMax(paramInt);
    double d3 = this.mRenderer.getYAxisMin(paramInt);
    double d4 = this.mRenderer.getYAxisMax(paramInt);
    if ((!this.mRenderer.isMinXSet(paramInt)) || (!this.mRenderer.isMaxXSet(paramInt)) || (!this.mRenderer.isMinXSet(paramInt)) || (!this.mRenderer.isMaxYSet(paramInt)))
    {
      double[] arrayOfDouble1 = getCalcRange(paramInt);
      d1 = arrayOfDouble1[0];
      d2 = arrayOfDouble1[1];
      d3 = arrayOfDouble1[2];
      d4 = arrayOfDouble1[3];
    }
    if (this.d != null)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = ((paramArrayOfDouble[0] - d1) * this.d.width() / (d2 - d1) + this.d.left);
      arrayOfDouble2[1] = ((d4 - paramArrayOfDouble[1]) * this.d.height() / (d4 - d3) + this.d.top);
      paramArrayOfDouble = arrayOfDouble2;
    }
    return paramArrayOfDouble;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.XYChart
 * JD-Core Version:    0.6.2
 */