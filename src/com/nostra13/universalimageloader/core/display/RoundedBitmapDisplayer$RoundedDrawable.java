package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class RoundedBitmapDisplayer$RoundedDrawable extends Drawable
{
  protected final BitmapShader bitmapShader;
  protected final float cornerRadius;
  protected final RectF mBitmapRect;
  protected final RectF mRect = new RectF();
  protected final int margin;
  protected final Paint paint;

  public RoundedBitmapDisplayer$RoundedDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.cornerRadius = paramInt1;
    this.margin = paramInt2;
    this.bitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapRect = new RectF(paramInt2, paramInt2, paramBitmap.getWidth() - paramInt2, paramBitmap.getHeight() - paramInt2);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setShader(this.bitmapShader);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRoundRect(this.mRect, this.cornerRadius, this.cornerRadius, this.paint);
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mRect.set(this.margin, this.margin, paramRect.width() - this.margin, paramRect.height() - this.margin);
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
    this.bitmapShader.setLocalMatrix(localMatrix);
  }

  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer.RoundedDrawable
 * JD-Core Version:    0.6.2
 */