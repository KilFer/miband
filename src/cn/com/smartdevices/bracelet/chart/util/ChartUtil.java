package cn.com.smartdevices.bracelet.chart.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.Iterator;
import java.util.List;

public class ChartUtil
{
  private static float a = -1.0F;
  private static float b = -1.0F;

  public static int colorToColor(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = Color.alpha(paramInt1);
    int j = Color.red(paramInt1);
    int k = Color.green(paramInt1);
    int m = Color.blue(paramInt1);
    int n = Color.alpha(paramInt2);
    int i1 = Color.red(paramInt2);
    int i2 = Color.green(paramInt2);
    int i3 = Color.blue(paramInt2);
    return Color.argb((int)(paramFloat * n + i * (1.0F - paramFloat)), (int)(paramFloat * i1 + j * (1.0F - paramFloat)), (int)(paramFloat * i2 + k * (1.0F - paramFloat)), (int)(paramFloat * i3 + m * (1.0F - paramFloat)));
  }

  public static Canvas createFilterCanvas(Bitmap paramBitmap)
  {
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
    return localCanvas;
  }

  public static void drawBitmapCenter(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, Bitmap paramBitmap, Paint paramPaint)
  {
    drawBitmapCenter(paramCanvas, paramFloat1, paramFloat2, paramFloat3, true, true, paramBitmap, paramPaint);
  }

  public static void drawBitmapCenter(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, Bitmap paramBitmap, Paint paramPaint)
  {
    if (paramBoolean1)
      paramFloat1 -= paramFloat3 * paramBitmap.getWidth() / 2.0F;
    if (paramBoolean2)
      paramFloat2 -= paramFloat3 * paramBitmap.getHeight() / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(paramFloat3, paramFloat3);
    localMatrix.postTranslate(paramFloat1, paramFloat2);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
  }

  public static void drawTextCenter(Canvas paramCanvas, RectF paramRectF, String paramString, Paint paramPaint)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    paramCanvas.drawText(paramString, paramRectF.left + (paramRectF.width() - localRect.width()) / 2.0F, paramRectF.top + (paramRectF.height() + localRect.height()) / 2.0F, paramPaint);
  }

  public static void drawTextCenter(Canvas paramCanvas, RectF paramRectF, String paramString1, String paramString2, Paint paramPaint1, Paint paramPaint2)
  {
    Rect localRect1 = new Rect();
    paramPaint1.getTextBounds(paramString1, 0, paramString1.length(), localRect1);
    float f1 = paramRectF.left + (paramRectF.width() - localRect1.width()) / 2.0F;
    float f2 = paramRectF.top + (paramRectF.height() + localRect1.height()) / 2.0F;
    paramCanvas.drawText(paramString1, f1, f2, paramPaint1);
    Rect localRect2 = new Rect();
    paramPaint2.getTextBounds(paramString1, 0, paramString1.length(), localRect2);
    paramCanvas.drawText(paramString2, 6.0F + (f1 + localRect1.width()), f2 - localRect1.height() + localRect2.height(), paramPaint2);
  }

  public static void erase(Canvas paramCanvas, RectF paramRectF)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(0);
    localPaint.setDither(true);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    paramCanvas.drawRect(paramRectF, localPaint);
  }

  public static float getDensity()
  {
    if (a < 0.0F)
      a = 1.0F;
    return a;
  }

  public static float getDensity(Context paramContext)
  {
    if (a < 0.0F)
      a = paramContext.getResources().getDisplayMetrics().density;
    return a;
  }

  public static float getDensityScale()
  {
    if (b < 0.0F)
      b = 1.0F;
    return b;
  }

  public static float getDensityScale(Context paramContext)
  {
    if (b < 0.0F)
      b = paramContext.getResources().getDisplayMetrics().density / 3.0F;
    return b;
  }

  public static float itemLevelSize(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    int i = paramInt1 / paramInt3;
    int j = (-1 + (paramInt2 + i)) / i;
    float f = (1 + (paramInt2 - 1) % i) / i;
    return levelSize(j - 1, paramFloat, paramInt3) + f * (levelSize(j, paramFloat, paramInt3) - levelSize(j - 1, paramFloat, paramInt3));
  }

  public static float levelSize(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramInt1 <= 0)
      return 0.0F;
    return paramFloat * (paramInt1 * (paramInt2 + (1 + (paramInt2 - paramInt1))) / 2.0F);
  }

  public static float updateLevelSize(int paramInt1, float paramFloat, int paramInt2)
  {
    return paramFloat * (paramInt2 * (paramInt1 / paramInt2) / paramInt1) / (paramInt2 * (paramInt2 + 1) / 2.0F);
  }

  public static int updateMaxItemValue(List<BarChart.BarItem> paramList, int paramInt1, int paramInt2)
  {
    try
    {
      Iterator localIterator = paramList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return paramInt2;
        BarChart.BarItem localBarItem = (BarChart.BarItem)localIterator.next();
        if ((localBarItem.index >= paramInt1) && (localBarItem.value > paramInt2))
          paramInt2 = localBarItem.value;
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.ChartUtil
 * JD-Core Version:    0.6.2
 */