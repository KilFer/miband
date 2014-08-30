package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.ProgressBar;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;

final class aG
  implements Animator.AnimatorListener
{
  aG(MainUIActivity paramMainUIActivity)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    MainUIActivity.m(this.a).smoothSlideTo(1.0F, 0);
    MainUIActivity.q(this.a).setVisibility(8);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    MainUIActivity.p(this.a).setScaleX(1.0F);
    MainUIActivity.p(this.a).setScaleY(1.0F);
    MainUIActivity.p(this.a).setAlpha(1.0F);
    MainUIActivity.p(this.a).setVisibility(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aG
 * JD-Core Version:    0.6.2
 */