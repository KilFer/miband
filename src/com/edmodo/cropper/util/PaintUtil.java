package com.edmodo.cropper.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.TypedValue;

public class PaintUtil
{
  private static final int a = -1;
  private static final String b = "#AAFFFFFF";
  private static final String c = "#B0000000";
  private static final float d = 1.0F;
  private static final float e = 2.0F;
  private static final float f = 1.0F;

  public static float getCornerThickness()
  {
    return 2.0F;
  }

  public static float getLineThickness()
  {
    return 1.0F;
  }

  public static Paint newBackgroundPaint(Context paramContext)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#B0000000"));
    return localPaint;
  }

  public static Paint newBorderPaint(Context paramContext)
  {
    float f1 = TypedValue.applyDimension(1, 1.0F, paramContext.getResources().getDisplayMetrics());
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#AAFFFFFF"));
    localPaint.setStrokeWidth(f1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    return localPaint;
  }

  public static Paint newCornerPaint(Context paramContext)
  {
    float f1 = TypedValue.applyDimension(1, 2.0F, paramContext.getResources().getDisplayMetrics());
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    localPaint.setStrokeWidth(f1);
    localPaint.setStyle(Paint.Style.STROKE);
    return localPaint;
  }

  public static Paint newGuidelinePaint()
  {
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#AAFFFFFF"));
    localPaint.setStrokeWidth(1.0F);
    return localPaint;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.util.PaintUtil
 * JD-Core Version:    0.6.2
 */