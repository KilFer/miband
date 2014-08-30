package org.achartengine.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class Zoom extends AbstractTool
{
  public static final int ZOOM_AXIS_X = 1;
  public static final int ZOOM_AXIS_XY = 0;
  public static final int ZOOM_AXIS_Y = 2;
  private boolean a;
  private float b;
  private List<ZoomListener> c = new ArrayList();
  private boolean d = false;
  private boolean e = false;

  public Zoom(AbstractChart paramAbstractChart, boolean paramBoolean, float paramFloat)
  {
    super(paramAbstractChart);
    this.a = paramBoolean;
    setZoomRate(paramFloat);
  }

  private void a(ZoomEvent paramZoomEvent)
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((ZoomListener)localIterator.next()).zoomApplied(paramZoomEvent);
    }
    finally
    {
    }
  }

  public void addZoomListener(ZoomListener paramZoomListener)
  {
    try
    {
      this.c.add(paramZoomListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void apply(int paramInt)
  {
    int j;
    double[] arrayOfDouble2;
    double d1;
    double d2;
    double d3;
    double d4;
    boolean bool1;
    label181: boolean bool2;
    if ((this.mChart instanceof XYChart))
    {
      int i = this.mRenderer.getScalesCount();
      j = 0;
      if (j >= i)
        break label622;
      double[] arrayOfDouble1 = getRange(j);
      checkRange(arrayOfDouble1, j);
      arrayOfDouble2 = this.mRenderer.getZoomLimits();
      d1 = (arrayOfDouble1[0] + arrayOfDouble1[1]) / 2.0D;
      d2 = (arrayOfDouble1[2] + arrayOfDouble1[3]) / 2.0D;
      d3 = arrayOfDouble1[1] - arrayOfDouble1[0];
      d4 = arrayOfDouble1[3] - arrayOfDouble1[2];
      double d5 = d1 - d3 / 2.0D;
      double d6 = d1 + d3 / 2.0D;
      double d7 = d2 - d4 / 2.0D;
      double d8 = d2 + d4 / 2.0D;
      if (j == 0)
      {
        if ((arrayOfDouble2 != null) && ((d5 <= arrayOfDouble2[0]) || (d6 >= arrayOfDouble2[1])))
        {
          bool1 = true;
          this.d = bool1;
          if ((arrayOfDouble2 == null) || ((d7 > arrayOfDouble2[2]) && (d8 < arrayOfDouble2[3])))
            break label485;
          bool2 = true;
          label215: this.e = bool2;
        }
      }
      else
      {
        if (!this.a)
          break label491;
        if ((!this.mRenderer.isZoomXEnabled()) || ((paramInt != 1) && (paramInt != 0)) || ((this.d) && (this.b < 1.0F)))
          break label680;
      }
    }
    label658: label680: for (double d15 = d3 / this.b; ; d15 = d3)
    {
      double d9;
      double d10;
      if ((this.mRenderer.isZoomYEnabled()) && ((paramInt == 2) || (paramInt == 0)) && ((!this.e) || (this.b >= 1.0F)))
      {
        d9 = d4 / this.b;
        d10 = d15;
      }
      while (true)
      {
        label322: double d11;
        if (arrayOfDouble2 != null)
          d11 = Math.min(this.mRenderer.getZoomInLimitX(), arrayOfDouble2[1] - arrayOfDouble2[0]);
        for (double d12 = Math.min(this.mRenderer.getZoomInLimitY(), arrayOfDouble2[3] - arrayOfDouble2[2]); ; d12 = this.mRenderer.getZoomInLimitY())
        {
          double d13 = Math.max(d10, d11);
          double d14 = Math.max(d9, d12);
          if ((this.mRenderer.isZoomXEnabled()) && ((paramInt == 1) || (paramInt == 0)))
            setXRange(d1 - d13 / 2.0D, d1 + d13 / 2.0D, j);
          if ((this.mRenderer.isZoomYEnabled()) && ((paramInt == 2) || (paramInt == 0)))
            setYRange(d2 - d14 / 2.0D, d2 + d14 / 2.0D, j);
          j++;
          break;
          bool1 = false;
          break label181;
          label485: bool2 = false;
          break label215;
          label491: if ((this.mRenderer.isZoomXEnabled()) && (!this.d) && ((paramInt == 1) || (paramInt == 0)))
            d3 *= this.b;
          if ((!this.mRenderer.isZoomYEnabled()) || (this.e) || ((paramInt != 2) && (paramInt != 0)))
            break label658;
          d9 = d4 * this.b;
          d10 = d3;
          break label322;
          d11 = this.mRenderer.getZoomInLimitX();
        }
        DefaultRenderer localDefaultRenderer = ((RoundChart)this.mChart).getRenderer();
        if (this.a)
          localDefaultRenderer.setScale(localDefaultRenderer.getScale() * this.b);
        while (true)
        {
          label622: a(new ZoomEvent(this.a, this.b));
          return;
          localDefaultRenderer.setScale(localDefaultRenderer.getScale() / this.b);
        }
        d9 = d4;
        d10 = d3;
        continue;
        d9 = d4;
        d10 = d15;
      }
    }
  }

  public void notifyZoomResetListeners()
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        ((ZoomListener)localIterator.next()).zoomReset();
    }
    finally
    {
    }
  }

  public void removeZoomListener(ZoomListener paramZoomListener)
  {
    try
    {
      this.c.remove(paramZoomListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setZoomRate(float paramFloat)
  {
    this.b = paramFloat;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.tools.Zoom
 * JD-Core Version:    0.6.2
 */