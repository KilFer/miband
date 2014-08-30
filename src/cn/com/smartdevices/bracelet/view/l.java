package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;

final class l
  implements Animator.AnimatorListener
{
  l(DynamicView paramDynamicView)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    DynamicView.f(this.a);
    DynamicView.g(this.a);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    DynamicView.e(this.a).setRotationY(-90.0F);
    DynamicView.e(this.a).setTranslationY(300.0F);
    DynamicView.e(this.a).setAlpha(0.0F);
    DynamicView.b(this.a).setAlpha(0.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.l
 * JD-Core Version:    0.6.2
 */