package com.edmodo.cropper.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.util.TypedValue;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.handle.Handle;

public class HandleUtil
{
  private static final int a = 24;

  private static boolean a()
  {
    return !CropOverlayView.showGuidelines();
  }

  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= paramFloat5) && (Math.abs(paramFloat2 - paramFloat4) <= paramFloat5);
  }

  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (paramFloat1 > paramFloat3) && (paramFloat1 < paramFloat4) && (Math.abs(paramFloat2 - paramFloat5) <= paramFloat6);
  }

  private static boolean b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= paramFloat6) && (paramFloat2 > paramFloat4) && (paramFloat2 < paramFloat5);
  }

  private static boolean c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (paramFloat1 > paramFloat3) && (paramFloat1 < paramFloat5) && (paramFloat2 > paramFloat4) && (paramFloat2 < paramFloat6);
  }

  public static Pair<Float, Float> getOffset(Handle paramHandle, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = 0.0F;
    if (paramHandle == null)
      return null;
    float f4;
    switch (b()[paramHandle.ordinal()])
    {
    default:
      f4 = 0.0F;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (true)
    {
      return new Pair(Float.valueOf(f4), Float.valueOf(f1));
      f4 = paramFloat3 - paramFloat1;
      f1 = paramFloat4 - paramFloat2;
      continue;
      f4 = paramFloat5 - paramFloat1;
      f1 = paramFloat4 - paramFloat2;
      continue;
      f4 = paramFloat3 - paramFloat1;
      f1 = paramFloat6 - paramFloat2;
      continue;
      f4 = paramFloat5 - paramFloat1;
      f1 = paramFloat6 - paramFloat2;
      continue;
      f4 = paramFloat3 - paramFloat1;
      f1 = 0.0F;
      continue;
      f1 = paramFloat4 - paramFloat2;
      f4 = 0.0F;
      continue;
      f4 = paramFloat5 - paramFloat1;
      f1 = 0.0F;
      continue;
      f1 = paramFloat6 - paramFloat2;
      f4 = 0.0F;
      continue;
      float f2 = (paramFloat5 + paramFloat3) / 2.0F;
      float f3 = (paramFloat4 + paramFloat6) / 2.0F;
      f4 = f2 - paramFloat1;
      f1 = f3 - paramFloat2;
    }
  }

  public static Handle getPressedHandle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    if (a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat7))
      return Handle.TOP_LEFT;
    if (a(paramFloat1, paramFloat2, paramFloat5, paramFloat4, paramFloat7))
      return Handle.TOP_RIGHT;
    if (a(paramFloat1, paramFloat2, paramFloat3, paramFloat6, paramFloat7))
      return Handle.BOTTOM_LEFT;
    if (a(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7))
      return Handle.BOTTOM_RIGHT;
    if ((c(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6)) && (a()))
      return Handle.CENTER;
    if (a(paramFloat1, paramFloat2, paramFloat3, paramFloat5, paramFloat4, paramFloat7))
      return Handle.TOP;
    if (a(paramFloat1, paramFloat2, paramFloat3, paramFloat5, paramFloat6, paramFloat7))
      return Handle.BOTTOM;
    if (b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat6, paramFloat7))
      return Handle.LEFT;
    if (b(paramFloat1, paramFloat2, paramFloat5, paramFloat4, paramFloat6, paramFloat7))
      return Handle.RIGHT;
    if ((c(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6)) && (!a()))
      return Handle.CENTER;
    return null;
  }

  public static float getTargetRadius(Context paramContext)
  {
    return TypedValue.applyDimension(1, 24.0F, paramContext.getResources().getDisplayMetrics());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.util.HandleUtil
 * JD-Core Version:    0.6.2
 */