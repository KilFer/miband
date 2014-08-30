package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;

public class BackwardSupportUtil$SmoothScrollFactory
{
  public static void scrollTo(ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new x().doScroll(paramListView, paramInt);
      return;
    }
    new w().doScroll(paramListView, paramInt);
  }

  public static void scrollToTop(ListView paramListView)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new x().doScroll(paramListView);
      return;
    }
    new w().doScroll(paramListView);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory
 * JD-Core Version:    0.6.2
 */