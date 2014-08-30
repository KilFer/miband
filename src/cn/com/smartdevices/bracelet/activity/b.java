package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.widget.Button;
import android.widget.TextView;

final class b
  implements Runnable
{
  b(LoginActivity paramLoginActivity)
  {
  }

  public final void run()
  {
    LoginActivity.a(this.a).setEnabled(true);
    LoginActivity.b(this.a).setEnabled(true);
    LoginActivity.c(this.a).setEnabled(true);
    LoginActivity.a(this.a, ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
    LoginActivity.d(this.a).setDuration(450L);
    LoginActivity.d(this.a).addUpdateListener(new c(this));
    LoginActivity.d(this.a).start();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.b
 * JD-Core Version:    0.6.2
 */