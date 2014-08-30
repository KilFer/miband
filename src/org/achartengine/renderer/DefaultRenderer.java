package org.achartengine.renderer;

import android.graphics.Typeface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DefaultRenderer
  implements Serializable
{
  public static final int BACKGROUND_COLOR = -16777216;
  public static final int NO_COLOR = 0;
  public static final int TEXT_COLOR = -3355444;
  private static final Typeface c = Typeface.create(Typeface.SERIF, 0);
  private boolean A = false;
  private float B = 1.5F;
  private boolean C = false;
  private float D = this.x;
  private boolean E = false;
  private int F = 15;
  private boolean G;
  private boolean H;
  private float I = 0.0F;
  private String a = "";
  private float b = 15.0F;
  private String d = c.toString();
  private int e = 0;
  private Typeface f;
  private int g;
  private boolean h;
  private boolean i = true;
  private int j = -3355444;
  private boolean k = true;
  private int l = -3355444;
  private float m = 10.0F;
  private boolean n = true;
  private float o = 12.0F;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private List<SimpleSeriesRenderer> t = new ArrayList();
  private boolean u = true;
  private int v = 0;
  private int[] w = { 20, 30, 10, 20 };
  private float x = 1.0F;
  private boolean y = true;
  private boolean z = true;

  public void addSeriesRenderer(int paramInt, SimpleSeriesRenderer paramSimpleSeriesRenderer)
  {
    this.t.add(paramInt, paramSimpleSeriesRenderer);
  }

  public void addSeriesRenderer(SimpleSeriesRenderer paramSimpleSeriesRenderer)
  {
    this.t.add(paramSimpleSeriesRenderer);
  }

  public int getAxesColor()
  {
    return this.j;
  }

  public int getBackgroundColor()
  {
    return this.g;
  }

  public String getChartTitle()
  {
    return this.a;
  }

  public float getChartTitleTextSize()
  {
    return this.b;
  }

  public int getLabelsColor()
  {
    return this.l;
  }

  public float getLabelsTextSize()
  {
    return this.m;
  }

  public int getLegendHeight()
  {
    return this.v;
  }

  public float getLegendTextSize()
  {
    return this.o;
  }

  public int[] getMargins()
  {
    return this.w;
  }

  public float getOriginalScale()
  {
    return this.D;
  }

  public float getScale()
  {
    return this.x;
  }

  public int getSelectableBuffer()
  {
    return this.F;
  }

  public SimpleSeriesRenderer getSeriesRendererAt(int paramInt)
  {
    return (SimpleSeriesRenderer)this.t.get(paramInt);
  }

  public int getSeriesRendererCount()
  {
    return this.t.size();
  }

  public SimpleSeriesRenderer[] getSeriesRenderers()
  {
    return (SimpleSeriesRenderer[])this.t.toArray(new SimpleSeriesRenderer[0]);
  }

  public float getStartAngle()
  {
    return this.I;
  }

  public Typeface getTextTypeface()
  {
    return this.f;
  }

  public String getTextTypefaceName()
  {
    return this.d;
  }

  public int getTextTypefaceStyle()
  {
    return this.e;
  }

  public float getZoomRate()
  {
    return this.B;
  }

  public boolean isAntialiasing()
  {
    return this.u;
  }

  public boolean isApplyBackgroundColor()
  {
    return this.h;
  }

  public boolean isClickEnabled()
  {
    return this.E;
  }

  public boolean isDisplayValues()
  {
    return this.G;
  }

  public boolean isExternalZoomEnabled()
  {
    return this.C;
  }

  public boolean isFitLegend()
  {
    return this.p;
  }

  public boolean isInScroll()
  {
    return this.H;
  }

  public boolean isPanEnabled()
  {
    return this.y;
  }

  public boolean isShowAxes()
  {
    return this.i;
  }

  public boolean isShowCustomTextGrid()
  {
    return this.s;
  }

  public boolean isShowGridX()
  {
    return this.q;
  }

  public boolean isShowGridY()
  {
    return this.r;
  }

  public boolean isShowLabels()
  {
    return this.k;
  }

  public boolean isShowLegend()
  {
    return this.n;
  }

  public boolean isZoomButtonsVisible()
  {
    return this.A;
  }

  public boolean isZoomEnabled()
  {
    return this.z;
  }

  public void removeAllRenderers()
  {
    this.t.clear();
  }

  public void removeSeriesRenderer(SimpleSeriesRenderer paramSimpleSeriesRenderer)
  {
    this.t.remove(paramSimpleSeriesRenderer);
  }

  public void setAntialiasing(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public void setApplyBackgroundColor(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void setAxesColor(int paramInt)
  {
    this.j = paramInt;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.g = paramInt;
  }

  public void setChartTitle(String paramString)
  {
    this.a = paramString;
  }

  public void setChartTitleTextSize(float paramFloat)
  {
    this.b = paramFloat;
  }

  public void setClickEnabled(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }

  public void setDisplayValues(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void setExternalZoomEnabled(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }

  public void setFitLegend(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setInScroll(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }

  public void setLabelsColor(int paramInt)
  {
    this.l = paramInt;
  }

  public void setLabelsTextSize(float paramFloat)
  {
    this.m = paramFloat;
  }

  public void setLegendHeight(int paramInt)
  {
    this.v = paramInt;
  }

  public void setLegendTextSize(float paramFloat)
  {
    this.o = paramFloat;
  }

  public void setMargins(int[] paramArrayOfInt)
  {
    this.w = paramArrayOfInt;
  }

  public void setPanEnabled(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public void setScale(float paramFloat)
  {
    this.x = paramFloat;
  }

  public void setSelectableBuffer(int paramInt)
  {
    this.F = paramInt;
  }

  public void setShowAxes(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setShowCustomTextGrid(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void setShowGrid(boolean paramBoolean)
  {
    setShowGridX(paramBoolean);
    setShowGridY(paramBoolean);
  }

  public void setShowGridX(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public void setShowGridY(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void setShowLabels(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setShowLegend(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void setStartAngle(float paramFloat)
  {
    this.I = paramFloat;
  }

  public void setTextTypeface(Typeface paramTypeface)
  {
    this.f = paramTypeface;
  }

  public void setTextTypeface(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
  }

  public void setZoomButtonsVisible(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  public void setZoomEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public void setZoomRate(float paramFloat)
  {
    this.B = paramFloat;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.renderer.DefaultRenderer
 * JD-Core Version:    0.6.2
 */