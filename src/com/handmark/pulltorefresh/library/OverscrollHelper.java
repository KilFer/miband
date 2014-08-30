package com.handmark.pulltorefresh.library;

import android.util.Log;
import android.view.View;

public final class OverscrollHelper
{
  private static String a = "OverscrollHelper";
  private static float b = 1.0F;

  static boolean a(View paramView)
  {
    return paramView.getOverScrollMode() != 2;
  }

  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    PullToRefreshBase.Mode localMode;
    switch (a()[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      i = paramPullToRefreshBase.getScrollY();
      j = paramInt3;
      k = paramInt4;
      if ((paramPullToRefreshBase.isPullToRefreshOverScrollEnabled()) && (!paramPullToRefreshBase.isRefreshing()))
      {
        localMode = paramPullToRefreshBase.getMode();
        if ((!localMode.b()) || (paramBoolean) || (j == 0))
          break label313;
        m = k + j;
        Log.d("OverscrollHelper", "OverScroll. DeltaX: " + paramInt1 + ", ScrollX: " + paramInt2 + ", DeltaY: " + paramInt3 + ", ScrollY: " + paramInt4 + ", NewY: " + m + ", ScrollRange: " + paramInt5 + ", CurrentScroll: " + i);
        if (m >= 0 - paramInt6)
          break label228;
        if (localMode.showHeaderLoadingLayout())
        {
          if (i == 0)
            paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
          paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (m + i)));
        }
      }
      break;
    case 2:
    }
    label228: 
    while ((!paramBoolean) || (PullToRefreshBase.State.OVERSCROLLING != paramPullToRefreshBase.getState()))
    {
      int m;
      do
      {
        do
        {
          return;
          i = paramPullToRefreshBase.getScrollX();
          j = paramInt1;
          k = paramInt2;
          break;
          if (m <= paramInt5 + paramInt6)
            break label279;
        }
        while (!localMode.showFooterLoadingLayout());
        if (i == 0)
          paramPullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
        paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (m + i - paramInt5)));
        return;
      }
      while ((Math.abs(m) > paramInt6) && (Math.abs(m - paramInt5) > paramInt6));
      paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
      return;
    }
    label279: label313: paramPullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
  }

  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    overScrollBy(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }

  public static void overScrollBy(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    overScrollBy(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.OverscrollHelper
 * JD-Core Version:    0.6.2
 */