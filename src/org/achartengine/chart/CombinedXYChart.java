package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;

public class CombinedXYChart extends XYChart
{
  private XYChart[] a;
  private Class<?>[] b = { TimeChart.class, LineChart.class, CubicLineChart.class, BarChart.class, BubbleChart.class, ScatterChart.class, RangeBarChart.class, RangeStackedBarChart.class };

  public CombinedXYChart(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer, String[] paramArrayOfString)
  {
    super(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
    int i = paramArrayOfString.length;
    this.a = new XYChart[i];
    int j = 0;
    while (true)
    {
      if (j < i);
      try
      {
        XYChart[] arrayOfXYChart = this.a;
        String str = paramArrayOfString[j];
        localObject1 = null;
        int m = this.b.length;
        n = 0;
        if ((n < m) && (localObject1 == null))
        {
          localObject2 = (XYChart)this.b[n].newInstance();
          if (str.equals(((XYChart)localObject2).getChartType()))
            break label371;
        }
        else
        {
          arrayOfXYChart[j] = localObject1;
          if (this.a[j] == null)
            throw new IllegalArgumentException("Unknown chart type " + paramArrayOfString[j]);
          XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
          localXYMultipleSeriesDataset.addSeries(paramXYMultipleSeriesDataset.getSeriesAt(j));
          XYMultipleSeriesRenderer localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
          localXYMultipleSeriesRenderer.setBarSpacing(paramXYMultipleSeriesRenderer.getBarSpacing());
          localXYMultipleSeriesRenderer.setPointSize(paramXYMultipleSeriesRenderer.getPointSize());
          int k = paramXYMultipleSeriesDataset.getSeriesAt(j).getScaleNumber();
          if (paramXYMultipleSeriesRenderer.isMinXSet(k))
            localXYMultipleSeriesRenderer.setXAxisMin(paramXYMultipleSeriesRenderer.getXAxisMin(k));
          if (paramXYMultipleSeriesRenderer.isMaxXSet(k))
            localXYMultipleSeriesRenderer.setXAxisMax(paramXYMultipleSeriesRenderer.getXAxisMax(k));
          if (paramXYMultipleSeriesRenderer.isMinYSet(k))
            localXYMultipleSeriesRenderer.setYAxisMin(paramXYMultipleSeriesRenderer.getYAxisMin(k));
          if (paramXYMultipleSeriesRenderer.isMaxYSet(k))
            localXYMultipleSeriesRenderer.setYAxisMax(paramXYMultipleSeriesRenderer.getYAxisMax(k));
          localXYMultipleSeriesRenderer.addSeriesRenderer(paramXYMultipleSeriesRenderer.getSeriesRendererAt(j));
          this.a[j].setDatasetRenderer(localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer);
          j++;
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          int n;
          continue;
          Object localObject2 = localObject1;
          label371: n++;
          Object localObject1 = localObject2;
        }
      }
    }
  }

  private XYChart a(String paramString)
  {
    Object localObject1 = null;
    int i = this.b.length;
    int j = 0;
    Object localObject2;
    if ((j < i) && (localObject1 == null))
    {
      localObject2 = (XYChart)this.b[j].newInstance();
      if (!paramString.equals(((XYChart)localObject2).getChartType()))
        break label59;
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      return localObject1;
      label59: localObject2 = localObject1;
    }
  }

  protected ClickableArea[] clickableAreasForPoints(List<Float> paramList, List<Double> paramList1, float paramFloat, int paramInt1, int paramInt2)
  {
    return this.a[paramInt1].clickableAreasForPoints(paramList, paramList1, paramFloat, 0, paramInt2);
  }

  public void drawLegendShape(Canvas paramCanvas, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat1, float paramFloat2, int paramInt, Paint paramPaint)
  {
    this.a[paramInt].drawLegendShape(paramCanvas, paramSimpleSeriesRenderer, paramFloat1, paramFloat2, 0, paramPaint);
  }

  public void drawSeries(Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, int paramInt2)
  {
    this.a[paramInt1].setScreenR(getScreenR());
    this.a[paramInt1].setCalcRange(getCalcRange(this.mDataset.getSeriesAt(paramInt1).getScaleNumber()), 0);
    this.a[paramInt1].drawSeries(paramCanvas, paramPaint, paramList, paramSimpleSeriesRenderer, paramFloat, 0, paramInt2);
  }

  protected void drawSeries(XYSeries paramXYSeries, Canvas paramCanvas, Paint paramPaint, List<Float> paramList, SimpleSeriesRenderer paramSimpleSeriesRenderer, float paramFloat, int paramInt1, XYMultipleSeriesRenderer.Orientation paramOrientation, int paramInt2)
  {
    this.a[paramInt1].setScreenR(getScreenR());
    this.a[paramInt1].setCalcRange(getCalcRange(this.mDataset.getSeriesAt(paramInt1).getScaleNumber()), 0);
    this.a[paramInt1].drawSeries(paramXYSeries, paramCanvas, paramPaint, paramList, paramSimpleSeriesRenderer, paramFloat, 0, paramOrientation, paramInt2);
  }

  public String getChartType()
  {
    return "Combined";
  }

  public int getLegendShapeWidth(int paramInt)
  {
    return this.a[paramInt].getLegendShapeWidth(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.CombinedXYChart
 * JD-Core Version:    0.6.2
 */