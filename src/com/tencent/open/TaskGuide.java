package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.IOException;
import java.io.InputStream;

public class TaskGuide extends BaseApi
{
  private static long H;
  private static int K;
  private static Drawable i;
  private static Drawable j;
  private static Drawable k;
  private static int l = 75;
  private static int m = 284;
  private static int n = 75;
  private static int o = 30;
  private static int p;
  private static int q;
  private static int r;
  private static int s;
  private static int t;
  private static int u;
  private static int v;
  private static int w;
  private static int x;
  private float A = 0.0F;
  private Interpolator B = new AccelerateInterpolator();
  private boolean C = false;
  private boolean D;
  private boolean E = false;
  private boolean F = false;
  private long G;
  private int I;
  private int J;
  private Runnable L = null;
  private Runnable M = null;
  IUiListener a;
  private WindowManager.LayoutParams b = null;
  private ViewGroup c = null;
  private WindowManager d;
  private Handler e = new Handler(Looper.getMainLooper());
  private E f;
  private z g = z.a;
  private z h = z.a;
  private int y;
  private int z;

  public TaskGuide(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramContext, paramQQAuth, paramQQToken);
    this.d = ((WindowManager)paramContext.getSystemService("window"));
    d();
  }

  public TaskGuide(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
    this.d = ((WindowManager)paramContext.getSystemService("window"));
    d();
  }

  private int a(int paramInt)
  {
    return (int)(paramInt * this.A);
  }

  private static Drawable a(String paramString, Context paramContext)
  {
    AssetManager localAssetManager = paramContext.getApplicationContext().getAssets();
    InputStream localInputStream;
    Object localObject;
    IOException localIOException2;
    try
    {
      localInputStream = localAssetManager.open(paramString);
      if (localInputStream == null)
        return null;
      if (paramString.endsWith(".9.png"))
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
        if (localBitmap != null)
        {
          byte[] arrayOfByte = localBitmap.getNinePatchChunk();
          NinePatch.isNinePatchChunk(arrayOfByte);
          NinePatchDrawable localNinePatchDrawable = new NinePatchDrawable(localBitmap, arrayOfByte, new Rect(), null);
          return localNinePatchDrawable;
        }
      }
    }
    catch (IOException localIOException1)
    {
      localObject = null;
      localIOException2 = localIOException1;
    }
    while (true)
    {
      localIOException2.printStackTrace();
      return localObject;
      return null;
      Drawable localDrawable = Drawable.createFromStream(localInputStream, paramString);
      localObject = localDrawable;
      try
      {
        localInputStream.close();
        return localObject;
      }
      catch (IOException localIOException3)
      {
      }
    }
  }

  private ViewGroup a(Context paramContext)
  {
    F localF = new F(this, paramContext);
    A[] arrayOfA = this.f.b;
    if (arrayOfA.length == 1)
    {
      D localD1 = new D(this, paramContext, arrayOfA[0]);
      localD1.setId(1);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(15);
      localF.addView(localD1, localLayoutParams1);
    }
    while (true)
    {
      if (i == null)
        i = a("background.9.png", this.mContext);
      localF.setBackgroundDrawable(i);
      return localF;
      D localD2 = new D(this, paramContext, arrayOfA[0]);
      localD2.setId(1);
      D localD3 = new D(this, paramContext, arrayOfA[1]);
      localD3.setId(2);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(14);
      localLayoutParams2.setMargins(0, a(6), 0, 0);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams3.addRule(14);
      localLayoutParams3.setMargins(0, a(4), 0, 0);
      localLayoutParams3.addRule(3, 1);
      localLayoutParams3.addRule(5, 1);
      localF.addView(localD2, localLayoutParams2);
      localF.addView(localD3, localLayoutParams3);
    }
  }

  private void a(int paramInt, z paramz)
  {
    if (paramInt == 0)
    {
      this.g = paramz;
      return;
    }
    if (paramInt == 1)
    {
      this.h = paramz;
      return;
    }
    this.g = paramz;
    this.h = paramz;
  }

  private void a(String paramString)
  {
    this.e.post(new r(this, paramString));
  }

  private void a(boolean paramBoolean)
  {
    SystemClock.currentThreadTimeMillis();
    if (paramBoolean)
      this.E = true;
    while (true)
    {
      this.I = this.b.height;
      this.J = this.b.y;
      WindowManager.LayoutParams localLayoutParams = this.b;
      localLayoutParams.flags = (0x10 | localLayoutParams.flags);
      this.d.updateViewLayout(this.c, this.b);
      return;
      this.F = true;
    }
  }

  private void b(int paramInt)
  {
    if (this.e != null)
      this.e.post(new t(this, paramInt));
  }

  private z c(int paramInt)
  {
    if (paramInt == 0)
      return this.g;
    if (paramInt == 1)
      return this.h;
    return z.a;
  }

  private void d()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.d.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.A = localDisplayMetrics.density;
  }

  private void d(int paramInt)
  {
    j();
    this.M = new G(this, (byte)0);
    this.e.postDelayed(this.M, paramInt);
  }

  private WindowManager.LayoutParams e()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 49;
    this.d.getDefaultDisplay().getWidth();
    this.d.getDefaultDisplay().getHeight();
    localLayoutParams.width = a(m);
    localLayoutParams.height = a(l);
    localLayoutParams.windowAnimations = 16973826;
    localLayoutParams.format = 1;
    localLayoutParams.flags = (0x208 | localLayoutParams.flags);
    localLayoutParams.type = 2;
    this.b = localLayoutParams;
    return localLayoutParams;
  }

  private void e(int paramInt)
  {
    Bundle localBundle = composeCGIParams();
    localBundle.putString("action", "get_gift");
    localBundle.putString("task_id", this.f.a);
    localBundle.putString("step_no", new Integer(paramInt).toString());
    localBundle.putString("appid", this.mToken.getAppId());
    u localu = new u(this, paramInt);
    HttpUtils.requestAsync(this.mToken, this.mContext, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", localBundle, "GET", localu);
    a(paramInt, z.c);
    a.a(this.mContext, this.mToken, "TaskApi", new String[] { "getGift" });
  }

  private void f()
  {
    if (this.b != null)
      this.b.y = (-this.b.height);
  }

  private Drawable g()
  {
    if (i == null)
      i = a("background.9.png", this.mContext);
    return i;
  }

  private Drawable h()
  {
    if (j == null)
      j = a("button_green.9.png", this.mContext);
    return j;
  }

  private Drawable i()
  {
    if (k == null)
      k = a("button_red.9.png", this.mContext);
    return k;
  }

  private void j()
  {
    this.e.removeCallbacks(this.M);
    if (!l())
      this.e.removeCallbacks(this.L);
  }

  private void k()
  {
    if (this.E)
      d(3000);
    while (true)
    {
      if (this.E)
      {
        WindowManager.LayoutParams localLayoutParams = this.b;
        localLayoutParams.flags = (0xFFFFFFEF & localLayoutParams.flags);
        this.d.updateViewLayout(this.c, this.b);
      }
      this.E = false;
      this.F = false;
      return;
      removeWindow();
    }
  }

  private boolean l()
  {
    return (this.E) || (this.F);
  }

  private void m()
  {
    if (!l())
    {
      this.e.removeCallbacks(this.M);
      this.e.removeCallbacks(this.L);
      this.L = new w(this, true);
      a(true);
      this.e.post(this.L);
    }
  }

  private void n()
  {
    if (!l())
    {
      this.e.removeCallbacks(this.M);
      this.e.removeCallbacks(this.L);
      this.L = new w(this, false);
      a(false);
      this.e.post(this.L);
    }
  }

  public void removeWindow()
  {
    if (this.C)
    {
      this.d.removeView(this.c);
      this.C = false;
    }
  }

  public void showTaskGuideWindow(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.mContext = paramActivity;
    this.a = paramIUiListener;
    if ((this.g == z.b) || (this.h == z.b) || (this.C))
      return;
    this.f = null;
    Bundle localBundle;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      localBundle.putAll(composeCGIParams());
    }
    while (true)
    {
      x localx = new x(this, (byte)0);
      localBundle.putString("action", "task_list");
      localBundle.putString("auth", "mobile");
      localBundle.putString("appid", this.mToken.getAppId());
      HttpUtils.requestAsync(this.mToken, this.mContext, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", localBundle, "GET", localx);
      a(2, z.b);
      return;
      localBundle = composeCGIParams();
    }
  }

  public void showWindow()
  {
    new Handler(Looper.getMainLooper()).post(new s(this));
    a.a(this.mContext, this.mToken, "TaskApi", new String[] { "showTaskWindow" });
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.TaskGuide
 * JD-Core Version:    0.6.2
 */