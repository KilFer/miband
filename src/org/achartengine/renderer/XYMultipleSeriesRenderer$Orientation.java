package org.achartengine.renderer;

public enum XYMultipleSeriesRenderer$Orientation
{
  private int a = 0;

  static
  {
    Orientation[] arrayOfOrientation = new Orientation[2];
    arrayOfOrientation[0] = HORIZONTAL;
    arrayOfOrientation[1] = VERTICAL;
  }

  private XYMultipleSeriesRenderer$Orientation(int paramInt)
  {
    this.a = paramInt;
  }

  public final int getAngle()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation
 * JD-Core Version:    0.6.2
 */