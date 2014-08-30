package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Utils;

final class aI
  implements Animator.AnimatorListener
{
  aI(MainUIActivity paramMainUIActivity)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
    MainUIActivity.a(this.a, Boolean.valueOf(false));
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    MainUIActivity.r(this.a).setScaleX(1.0F);
    MainUIActivity.r(this.a).setScaleY(1.0F);
    MainUIActivity.s(this.a).setScaleX(1.0F);
    MainUIActivity.s(this.a).setScaleY(1.0F);
    MainUIActivity.r(this.a).setAlpha(1.0F);
    MainUIActivity.s(this.a).setAlpha(1.0F);
    MainUIActivity.j(this.a).setRotation(180.0F);
    MainUIActivity.a(this.a, Boolean.valueOf(false));
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    MainUIActivity.p(this.a).setScaleX(1.0F);
    MainUIActivity.p(this.a).setScaleY(1.0F);
    MainUIActivity.p(this.a).setAlpha(1.0F);
    MainUIActivity.r(this.a).setScaleX(0.5F);
    MainUIActivity.r(this.a).setScaleY(0.5F);
    MainUIActivity.s(this.a).setScaleX(0.5F);
    MainUIActivity.s(this.a).setScaleY(0.5F);
    MainUIActivity.r(this.a).setAlpha(0.5F);
    MainUIActivity.s(this.a).setAlpha(0.5F);
    MainUIActivity.j(this.a).setRotation(0.0F);
    MainUIActivity.r(this.a).setText(2131493288);
    MainUIActivity.s(this.a).setText(Utils.getSyncTime(this.a));
    MainUIActivity.a(this.a, Boolean.valueOf(true));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aI
 * JD-Core Version:    0.6.2
 */