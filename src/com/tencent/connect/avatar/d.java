package com.tencent.connect.avatar;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  d(ImageActivity paramImageActivity)
  {
  }

  public final void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ImageActivity.a(this.a, ImageActivity.a(this.a).a());
    ImageActivity.c(this.a).a(ImageActivity.b(this.a));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.d
 * JD-Core Version:    0.6.2
 */