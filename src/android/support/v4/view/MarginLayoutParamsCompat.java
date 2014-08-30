package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public class MarginLayoutParamsCompat
{
  private static w a = new x();

  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new y();
      return;
    }
  }

  public static int getLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.d(paramMarginLayoutParams);
  }

  public static int getMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.b(paramMarginLayoutParams);
  }

  public static int getMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.a(paramMarginLayoutParams);
  }

  public static boolean isMarginRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    return a.c(paramMarginLayoutParams);
  }

  public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    a.d(paramMarginLayoutParams, paramInt);
  }

  public static void setLayoutDirection(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    a.c(paramMarginLayoutParams, paramInt);
  }

  public static void setMarginEnd(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    a.b(paramMarginLayoutParams, paramInt);
  }

  public static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    a.a(paramMarginLayoutParams, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.MarginLayoutParamsCompat
 * JD-Core Version:    0.6.2
 */