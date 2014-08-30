package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Paint;

public class ColorRenderer extends Renderer
{
  public ColorRenderer(int paramInt)
  {
    this.paint = new Paint(1);
    this.paint.setColor(paramInt);
  }

  public void setColor(int paramInt)
  {
    this.paint.setColor(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.ColorRenderer
 * JD-Core Version:    0.6.2
 */