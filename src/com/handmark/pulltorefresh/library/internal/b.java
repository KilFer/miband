package com.handmark.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.view.View;

final class b
{
  public static void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackground(paramDrawable);
  }

  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.b
 * JD-Core Version:    0.6.2
 */