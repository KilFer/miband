package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

public class BitmapRenderer extends Renderer
{
  private Bitmap a;
  private Shader b;

  public BitmapRenderer(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.paint = new Paint();
    this.b = new BitmapShader(this.a, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    this.paint.setShader(this.b);
  }

  public int getHeight()
  {
    return this.a.getHeight();
  }

  public int getWidth()
  {
    return this.a.getWidth();
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    this.paint.setShader(localBitmapShader);
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(paramFloat1, paramFloat2);
    this.b.setLocalMatrix(localMatrix);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BitmapRenderer
 * JD-Core Version:    0.6.2
 */