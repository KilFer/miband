package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

final class i
  implements b.a
{
  i(SocialApiIml paramSocialApiIml, Bundle paramBundle, Activity paramActivity, IUiListener paramIUiListener)
  {
  }

  public final void a(String paramString)
  {
    this.a.remove("image_date");
    if (!TextUtils.isEmpty(paramString))
      this.a.putString("image_date", paramString);
    SocialApiIml.a(this.d, this.b, this.a, this.c);
  }

  public final void b(String paramString)
  {
    this.a.remove("image_date");
    UiError localUiError = new UiError(-5, "图片读取失败，请检查该图片是否有效", "图片读取失败，请检查该图片是否有效");
    this.c.onError(localUiError);
    SocialApiIml.a(this.d);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.i
 * JD-Core Version:    0.6.2
 */