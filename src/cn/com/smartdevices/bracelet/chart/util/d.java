package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

final class d extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ((View)((ObjectAnimator)paramAnimator).getTarget()).setRotationY(0.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.d
 * JD-Core Version:    0.6.2
 */