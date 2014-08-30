package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;

final class R
  implements Animator.AnimatorListener
{
  private boolean a;

  R(DynamicDetailFragment paramDynamicDetailFragment, View paramView)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
    Debug.i("Dynamic.Detail", "Dismiss Anim Canceled!!");
    this.a = true;
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a)
    {
      Debug.i("Dynamic.Detail", "Dismiss Anim Ended!!");
      this.c.setVisibility(4);
      DynamicDetailFragment.a(this.b, false);
      if ((this.b.getActivity() != null) && (DynamicDetailFragment.h(this.b) == 1))
        DynamicDetailFragment.c(this.b, 2131493138);
    }
    DynamicDetailFragment.b(this.b, null);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.R
 * JD-Core Version:    0.6.2
 */