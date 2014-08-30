package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;

public class CalibrationView extends View
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Paint i = new Paint();
  private Paint j = new Paint();
  private TextPaint k;

  public CalibrationView(Context paramContext)
  {
    super(paramContext);
    new TextPaint();
    this.i.setAntiAlias(true);
    this.i.setColor(-11746592);
    this.i.setStrokeWidth(3.0F);
    this.j.setAntiAlias(true);
    this.j.setColor(-3552823);
    this.i.setStrokeWidth(2.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    int m = paramCanvas.getWidth();
    int n = paramCanvas.getHeight();
    paramCanvas.drawLine(m * 2 / 3, n / 2, m, n / 2, this.i);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.CalibrationView
 * JD-Core Version:    0.6.2
 */