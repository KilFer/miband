package com.handmark.pulltorefresh.library;

import android.webkit.WebView;

final class m
  implements PullToRefreshBase.OnRefreshListener<WebView>
{
  public final void onRefresh(PullToRefreshBase<WebView> paramPullToRefreshBase)
  {
    ((WebView)paramPullToRefreshBase.getRefreshableView()).reload();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.m
 * JD-Core Version:    0.6.2
 */