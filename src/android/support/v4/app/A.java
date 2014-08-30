package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class A
  implements Animation.AnimationListener
{
  A(v paramv, Fragment paramFragment)
  {
  }

  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.b != null)
    {
      this.a.b = null;
      this.b.a(this.a, this.a.c, 0, 0, false);
    }
  }

  public final void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public final void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.A
 * JD-Core Version:    0.6.2
 */