package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;

final class x
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public final void doScroll(ListView paramListView)
  {
    if (paramListView.getFirstVisiblePosition() > 10)
      paramListView.setSelection(10);
    paramListView.smoothScrollToPosition(0);
  }

  public final void doScroll(ListView paramListView, int paramInt)
  {
    int i = paramListView.getFirstVisiblePosition();
    if ((i > paramInt) && (i - paramInt > 10))
      paramListView.setSelection(paramInt + 10);
    while (true)
    {
      paramListView.smoothScrollToPosition(paramInt);
      return;
      if ((i < paramInt) && (paramInt - i > 10))
        paramListView.setSelection(paramInt - 10);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.x
 * JD-Core Version:    0.6.2
 */