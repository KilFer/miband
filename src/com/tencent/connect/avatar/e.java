package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.ByteArrayOutputStream;

final class e extends BaseApi
{
  public e(ImageActivity paramImageActivity, Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
  }

  public final void a(Bitmap paramBitmap, IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 40, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramBitmap.recycle();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    localBundle.putByteArray("picture", arrayOfByte);
    HttpUtils.requestAsync(this.mToken, this.mContext, "user/set_user_face", localBundle, "POST", localTempRequestListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.avatar.e
 * JD-Core Version:    0.6.2
 */