package cn.com.smartdevices.bracelet.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.com.smartdevices.bracelet.Utils;

final class d extends ClickableSpan
{
  d(LoginActivity paramLoginActivity)
  {
  }

  public final void onClick(View paramView)
  {
    Utils.gotoWeb("file:///android_asset/useragreement.html", this.a.getString(2131493072), this.a);
  }

  public final void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-1);
    paramTextPaint.setUnderlineText(true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.d
 * JD-Core Version:    0.6.2
 */