package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;

public class BackwardSupportUtil$AnimationHelper
{
  public static void cancelAnimation(View paramView, Animation paramAnimation)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new b().cancelAnimation(paramView, paramAnimation);
      return;
    }
    new a().cancelAnimation(paramView, paramAnimation);
  }

  public static void overridePendingTransition(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramActivity.overridePendingTransition(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper
 * JD-Core Version:    0.6.2
 */