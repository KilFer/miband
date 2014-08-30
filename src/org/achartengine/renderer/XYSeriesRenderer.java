package org.achartengine.renderer;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.PointStyle;

public class XYSeriesRenderer extends SimpleSeriesRenderer
{
  private boolean a = false;
  private List<XYSeriesRenderer.FillOutsideLine> b = new ArrayList();
  private PointStyle c = PointStyle.POINT;
  private float d = 1.0F;
  private float e = 1.0F;

  public void addFillOutsideLine(XYSeriesRenderer.FillOutsideLine paramFillOutsideLine)
  {
    this.b.add(paramFillOutsideLine);
  }

  public XYSeriesRenderer.FillOutsideLine[] getFillOutsideLine()
  {
    return (XYSeriesRenderer.FillOutsideLine[])this.b.toArray(new XYSeriesRenderer.FillOutsideLine[0]);
  }

  public float getLineWidth()
  {
    return this.e;
  }

  public float getPointStrokeWidth()
  {
    return this.d;
  }

  public PointStyle getPointStyle()
  {
    return this.c;
  }

  public boolean isFillBelowLine()
  {
    return this.b.size() > 0;
  }

  public boolean isFillPoints()
  {
    return this.a;
  }

  public void setFillBelowLine(boolean paramBoolean)
  {
    this.b.clear();
    if (paramBoolean)
    {
      this.b.add(new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL));
      return;
    }
    this.b.add(new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.NONE));
  }

  public void setFillBelowLineColor(int paramInt)
  {
    if (this.b.size() > 0)
      ((XYSeriesRenderer.FillOutsideLine)this.b.get(0)).setColor(paramInt);
  }

  public void setFillPoints(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void setLineWidth(float paramFloat)
  {
    this.e = paramFloat;
  }

  public void setPointStrokeWidth(float paramFloat)
  {
    this.d = paramFloat;
  }

  public void setPointStyle(PointStyle paramPointStyle)
  {
    this.c = paramPointStyle;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.renderer.XYSeriesRenderer
 * JD-Core Version:    0.6.2
 */