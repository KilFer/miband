package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.AsynLoadImgBack;
import java.util.ArrayList;

final class d
  implements AsynLoadImgBack
{
  d(QzoneShare paramQzoneShare, Bundle paramBundle, Activity paramActivity, IUiListener paramIUiListener)
  {
  }

  public final void batchSaved(int paramInt, ArrayList<String> paramArrayList)
  {
    if (paramInt == 0)
      this.a.putStringArrayList("imageUrl", paramArrayList);
    QzoneShare.a(this.d, this.b, this.a, this.c);
  }

  public final void saved(int paramInt, String paramString)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.d
 * JD-Core Version:    0.6.2
 */