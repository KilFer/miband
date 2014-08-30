package org.achartengine.tools;

public class ZoomEvent
{
  private boolean a;
  private float b;

  public ZoomEvent(boolean paramBoolean, float paramFloat)
  {
    this.a = paramBoolean;
    this.b = paramFloat;
  }

  public float getZoomRate()
  {
    return this.b;
  }

  public boolean isZoomIn()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     org.achartengine.tools.ZoomEvent
 * JD-Core Version:    0.6.2
 */