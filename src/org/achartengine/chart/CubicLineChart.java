package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class CubicLineChart extends LineChart
{
  public static final String TYPE = "Cubic";
  private float a;
  private float b;
  private Point c = new Point();
  private Point d = new Point();
  private Point e = new Point();

  public CubicLineChart()
  {
    this.a = 0.33F;
    this.b = (1.0F - this.a);
  }

  public CubicLineChart(XYMultipleSeriesDataset paramXYMultipleSeriesDataset, XYMultipleSeriesRenderer paramXYMultipleSeriesRenderer, float paramFloat)
  {
    super(paramXYMultipleSeriesDataset, paramXYMultipleSeriesRenderer);
    this.a = paramFloat;
    this.b = (1.0F - this.a);
  }

  private static void a(List<Float> paramList, Point paramPoint, int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = ((Float)paramList.get(paramInt1)).floatValue();
    float f2 = ((Float)paramList.get(paramInt1 + 1)).floatValue();
    float f3 = ((Float)paramList.get(paramInt2)).floatValue();
    float f4 = ((Float)paramList.get(paramInt2 + 1)).floatValue();
    float f5 = f3 - f1;
    float f6 = f4 - f2;
    paramPoint.setX(f1 + f5 * paramFloat);
    paramPoint.setY(f2 + f6 * paramFloat);
  }

  protected void drawPath(Canvas paramCanvas, List<Float> paramList, Paint paramPaint, boolean paramBoolean)
  {
    Path localPath = new Path();
    localPath.moveTo(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue());
    int i = paramList.size();
    if (paramBoolean);
    for (int j = i - 4; ; j = i)
    {
      int k = 0;
      if (k < j)
      {
        int n;
        if (k + 2 < j)
        {
          n = k + 2;
          label84: if (k + 4 >= j)
            break label235;
        }
        label235: for (int i1 = k + 4; ; i1 = n)
        {
          a(paramList, this.c, k, n, this.b);
          this.d.setX(((Float)paramList.get(n)).floatValue());
          this.d.setY(((Float)paramList.get(n + 1)).floatValue());
          a(paramList, this.e, n, i1, this.a);
          localPath.cubicTo(this.c.getX(), this.c.getY(), this.d.getX(), this.d.getY(), this.e.getX(), this.e.getY());
          k += 2;
          break;
          n = k;
          break label84;
        }
      }
      if (paramBoolean)
      {
        for (int m = j; m < j + 4; m += 2)
          localPath.lineTo(((Float)paramList.get(m)).floatValue(), ((Float)paramList.get(m + 1)).floatValue());
        localPath.lineTo(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue());
      }
      paramCanvas.drawPath(localPath, paramPaint);
      return;
    }
  }

  public String getChartType()
  {
    return "Cubic";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.chart.CubicLineChart
 * JD-Core Version:    0.6.2
 */