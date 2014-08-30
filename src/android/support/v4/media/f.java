package android.support.v4.media;

import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

final class f
  implements ViewTreeObserver.OnWindowFocusChangeListener
{
  f(d paramd)
  {
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.d();
      return;
    }
    this.a.h();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.f
 * JD-Core Version:    0.6.2
 */