package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;

final class w
  implements BackwardSupportUtil.SmoothScrollFactory.IScroll
{
  public final void doScroll(ListView paramListView)
  {
    paramListView.setSelection(0);
  }

  public final void doScroll(ListView paramListView, int paramInt)
  {
    paramListView.setSelection(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.w
 * JD-Core Version:    0.6.2
 */