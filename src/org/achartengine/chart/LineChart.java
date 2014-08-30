package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine.Type;

public class LineChart extends XYChart
{
  public static final String TYPE = "Line";
  private static final int a = 30;
  private ScatterChart b;

  LineChart()
  {
  }

  public LineChart(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer)
  {
    super(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
    this.b = new ScatterChart(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
  }

  protected ClickableArea[] clickableAreasForPoints(List<Float> paramList, List<Double> paramList1, float paramFloat, int paramInt1, int paramInt2)
  {
    int i = paramList.size();
    ClickableArea[] arrayOfClickableArea = new ClickableArea[i / 2];
    for (int j = 0; j < i; j += 2)
    {
      int k = this.mRenderer.getSelectableBuffer();
      arrayOfClickableArea[(j / 2)] = new ClickableArea(new RectF(((Float)paramList.get(j)).floatValue() - k, ((Float)paramList.get(j + 1)).floatValue() - k, ((Float)paramList.get(j)).floatValue() + k, ((Float)paramList.get(j + 1)).floatValue() + k), ((Double)paramList1.get(j)).doubleValue(), ((Double)paramList1.get(j + 1)).doubleValue());
    }
    return arrayOfClickableArea;
  }

  public void drawLegendShape(Canvas paramCanvas, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat1, float paramFloat2, int paramInt, Paint paramPaint)
  {
    paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1 + 30.0F, paramFloat2, paramPaint);
    if (isRenderPoints(paramSimpleSeriesRenderer))
      this.b.drawLegendShape(paramCanvas, paramSimpleSeriesRenderer, paramFloat1 + 5.0F, paramFloat2, paramInt, paramPaint);
  }

  public void drawSeries(Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, int paramInt2)
  {
    XYSeriesRenderer localXYSeriesRenderer = (XYSeriesRenderer)paramSimpleSeriesRenderer;
    float f1 = paramPaint.getStrokeWidth();
    paramPaint.setStrokeWidth(localXYSeriesRenderer.getLineWidth());
    XYSeriesRenderer.FillOutsideLine[] arrayOfFillOutsideLine = localXYSeriesRenderer.getFillOutsideLine();
    int i = arrayOfFillOutsideLine.length;
    int j = 0;
    XYSeriesRenderer.FillOutsideLine localFillOutsideLine;
    ArrayList localArrayList1;
    float f2;
    ArrayList localArrayList2;
    if (j < i)
    {
      localFillOutsideLine = arrayOfFillOutsideLine[j];
      if (localFillOutsideLine.getType() != XYSeriesRenderer.FillOutsideLine.Type.NONE)
      {
        paramPaint.setColor(localFillOutsideLine.getColor());
        localArrayList1 = new ArrayList();
        int[] arrayOfInt = localFillOutsideLine.getFillRange();
        if (arrayOfInt == null)
          localArrayList1.addAll(paramList);
        while (true)
          switch (a.a[localFillOutsideLine.getType().ordinal()])
          {
          default:
            throw new RuntimeException("You have added a new type of filling but have not implemented.");
            localArrayList1.addAll(paramList.subList(arrayOfInt[0] << 1, arrayOfInt[1] << 1));
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
        f2 = paramFloat;
        if ((localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE) || (localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW))
        {
          localArrayList2 = new ArrayList();
          if (((localFillOutsideLine.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE) || (((Float)localArrayList1.get(1)).floatValue() >= f2)) && ((localFillOutsideLine.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW) || (((Float)localArrayList1.get(1)).floatValue() <= f2)))
            break label934;
          localArrayList2.add(localArrayList1.get(0));
          localArrayList2.add(localArrayList1.get(1));
        }
      }
    }
    label934: for (int k = 1; ; k = 0)
    {
      int m = 3;
      int n = k;
      label326: if (m < localArrayList1.size())
      {
        float f3 = ((Float)localArrayList1.get(m - 2)).floatValue();
        float f4 = ((Float)localArrayList1.get(m)).floatValue();
        float f6;
        int i3;
        int i4;
        if (((f3 < f2) && (f4 > f2)) || ((f3 > f2) && (f4 < f2)))
        {
          float f5 = ((Float)localArrayList1.get(m - 3)).floatValue();
          f6 = ((Float)localArrayList1.get(m - 1)).floatValue();
          localArrayList2.add(Float.valueOf(f5 + (f6 - f5) * (f2 - f3) / (f4 - f3)));
          localArrayList2.add(Float.valueOf(f2));
          if (((localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE) && (f4 > f2)) || ((localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW) && (f4 < f2)))
          {
            i3 = m + 2;
            i4 = 0;
          }
        }
        while (true)
        {
          int i5 = i3 + 2;
          n = i4;
          m = i5;
          break label326;
          f2 = paramFloat;
          break;
          f2 = paramFloat;
          break;
          f2 = paramCanvas.getHeight();
          break;
          f2 = 0.0F;
          break;
          localArrayList2.add(Float.valueOf(f6));
          localArrayList2.add(Float.valueOf(f4));
          i3 = m;
          i4 = 1;
          continue;
          if ((n != 0) || ((localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE) && (f4 < f2)) || ((localFillOutsideLine.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW) && (f4 > f2)))
          {
            localArrayList2.add(localArrayList1.get(m - 1));
            localArrayList2.add(Float.valueOf(f4));
          }
          i3 = m;
          i4 = n;
        }
      }
      localArrayList1.clear();
      localArrayList1.addAll(localArrayList2);
      int i1 = localArrayList1.size();
      localArrayList1.set(0, Float.valueOf(1.0F + ((Float)localArrayList1.get(0)).floatValue()));
      localArrayList1.add(localArrayList1.get(i1 - 2));
      localArrayList1.add(Float.valueOf(f2));
      localArrayList1.add(localArrayList1.get(0));
      localArrayList1.add(localArrayList1.get(i1 + 1));
      for (int i2 = 0; i2 < i1 + 4; i2 += 2)
        if (((Float)localArrayList1.get(i2 + 1)).floatValue() < 0.0F)
          localArrayList1.set(i2 + 1, Float.valueOf(0.0F));
      paramPaint.setStyle(Paint.Style.FILL);
      drawPath(paramCanvas, localArrayList1, paramPaint, true);
      j++;
      break;
      paramPaint.setColor(paramSimpleSeriesRenderer.getColor());
      paramPaint.setStyle(Paint.Style.STROKE);
      drawPath(paramCanvas, paramList, paramPaint, false);
      paramPaint.setStrokeWidth(f1);
      return;
    }
  }

  public String getChartType()
  {
    return "Line";
  }

  public int getLegendShapeWidth(int paramInt)
  {
    return 30;
  }

  public ScatterChart getPointsChart()
  {
    return this.b;
  }

  public boolean isRenderPoints(SimpleSeriesRenderer paramSimpleSeriesRenderer)
  {
    return ((XYSeriesRenderer)paramSimpleSeriesRenderer).getPointStyle() != PointStyle.POINT;
  }

  protected void setDatasetRenderer(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer)
  {
    super.setDatasetRenderer(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
    this.b = new ScatterChart(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.LineChart
 * JD-Core Version:    0.6.2
 */