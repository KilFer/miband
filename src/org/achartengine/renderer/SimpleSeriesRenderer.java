package org.achartengine.renderer;

import android.graphics.Paint.Align;
import java.io.Serializable;
import java.text.NumberFormat;

public class SimpleSeriesRenderer
  implements Serializable
{
  private int a = -16776961;
  private boolean b;
  private int c = 100;
  private float d = 10.0F;
  private Paint.Align e = Paint.Align.CENTER;
  private float f = 5.0F;
  private BasicStroke g;
  private boolean h = false;
  private double i;
  private int j;
  private double k;
  private int l;
  private boolean m = true;
  private NumberFormat n;
  private boolean o;
  private boolean p = true;

  public NumberFormat getChartValuesFormat()
  {
    return this.n;
  }

  public float getChartValuesSpacing()
  {
    return this.f;
  }

  public Paint.Align getChartValuesTextAlign()
  {
    return this.e;
  }

  public float getChartValuesTextSize()
  {
    return this.d;
  }

  public int getColor()
  {
    return this.a;
  }

  public int getDisplayChartValuesDistance()
  {
    return this.c;
  }

  public int getGradientStartColor()
  {
    return this.j;
  }

  public double getGradientStartValue()
  {
    return this.i;
  }

  public int getGradientStopColor()
  {
    return this.l;
  }

  public double getGradientStopValue()
  {
    return this.k;
  }

  public BasicStroke getStroke()
  {
    return this.g;
  }

  public boolean isDisplayBoundingPoints()
  {
    return this.p;
  }

  public boolean isDisplayChartValues()
  {
    return this.b;
  }

  public boolean isGradientEnabled()
  {
    return this.h;
  }

  public boolean isHighlighted()
  {
    return this.o;
  }

  public boolean isShowLegendItem()
  {
    return this.m;
  }

  public void setChartValuesFormat(NumberFormat paramNumberFormat)
  {
    this.n = paramNumberFormat;
  }

  public void setChartValuesSpacing(float paramFloat)
  {
    this.f = paramFloat;
  }

  public void setChartValuesTextAlign(Paint.Align paramAlign)
  {
    this.e = paramAlign;
  }

  public void setChartValuesTextSize(float paramFloat)
  {
    this.d = paramFloat;
  }

  public void setColor(int paramInt)
  {
    this.a = paramInt;
  }

  public void setDisplayBoundingPoints(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setDisplayChartValues(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void setDisplayChartValuesDistance(int paramInt)
  {
    this.c = paramInt;
  }

  public void setGradientEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void setGradientStart(double paramDouble, int paramInt)
  {
    this.i = paramDouble;
    this.j = paramInt;
  }

  public void setGradientStop(double paramDouble, int paramInt)
  {
    this.k = paramDouble;
    this.l = paramInt;
  }

  public void setHighlighted(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public void setShowLegendItem(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void setStroke(BasicStroke paramBasicStroke)
  {
    this.g = paramBasicStroke;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.renderer.SimpleSeriesRenderer
 * JD-Core Version:    0.6.2
 */