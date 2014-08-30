package com.handmark.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public class ViewCompat
{
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }

  public static void setBackground(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public static void setLayerType(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11)
      paramView.setLayerType(paramInt, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.ViewCompat
 * JD-Core Version:    0.6.2
 */