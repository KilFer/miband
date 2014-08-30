package com.handmark.pulltorefresh.library;

import android.view.View;

public abstract interface PullToRefreshBase$OnPullEventListener<V extends View>
{
  public abstract void onPullEvent(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener
 * JD-Core Version:    0.6.2
 */