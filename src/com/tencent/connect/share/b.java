package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.AsynLoadImgBack;
import java.util.ArrayList;

final class b
  implements AsynLoadImgBack
{
  b(QQShare paramQQShare, Bundle paramBundle, String paramString1, String paramString2, IUiListener paramIUiListener, Activity paramActivity)
  {
  }

  public final void batchSaved(int paramInt, ArrayList<String> paramArrayList)
  {
  }

  public final void saved(int paramInt, String paramString)
  {
    if (paramInt == 0)
      this.a.putString("imageLocalUrl", paramString);
    do
      do
      {
        QQShare.a(this.f, this.e, this.a, this.d);
        return;
      }
      while ((!TextUtils.isEmpty(this.b)) || (!TextUtils.isEmpty(this.c)));
    while (this.d == null);
    this.d.onError(new UiError(-6, "获取分享图片失败!", null));
    c.a("shareToQQ", "获取分享图片失败!");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.b
 * JD-Core Version:    0.6.2
 */