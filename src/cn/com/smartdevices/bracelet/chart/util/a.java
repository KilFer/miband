package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;

final class a
  implements Animator.AnimatorListener
{
  a(TextView paramTextView1, String paramString1, TextView paramTextView2, String paramString2)
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
    this.a.setText(this.b);
    this.a.setAlpha(0.9F);
    this.a.setScaleX(0.9F);
    this.a.setScaleY(0.9F);
    this.c.setText(this.d);
    this.c.setAlpha(0.5F);
    this.c.setScaleX(0.5F);
    this.c.setScaleY(0.5F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.a
 * JD-Core Version:    0.6.2
 */