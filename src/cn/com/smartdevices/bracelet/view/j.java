package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;

final class j
  implements Animator.AnimatorListener
{
  j(DynamicView paramDynamicView)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    DynamicView.d(this.a).setRotationY(0.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.j
 * JD-Core Version:    0.6.2
 */