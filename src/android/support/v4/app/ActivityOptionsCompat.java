package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new j(i.a(paramContext, paramInt1, paramInt2));
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new j(i.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    return new ActivityOptionsCompat();
  }

  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return new j(i.a(paramView, paramBitmap, paramInt1, paramInt2));
    return new ActivityOptionsCompat();
  }

  public Bundle toBundle()
  {
    return null;
  }

  public void update(ActivityOptionsCompat paramActivityOptionsCompat)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * JD-Core Version:    0.6.2
 */