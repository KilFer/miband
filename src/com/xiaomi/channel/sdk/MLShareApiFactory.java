package com.xiaomi.channel.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;

public class MLShareApiFactory
{
  public static final String KEY_EXTRA_SHARE_BUNDLE = "extra_share_bundle";
  private Context a;
  private String b;
  private String c;
  private String d;
  private Drawable e;
  private String f;
  public String mVipId;

  public MLShareApiFactory(Context paramContext)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context could not be null!");
    a(paramContext);
  }

  public MLShareApiFactory(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context could not be null!");
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("appId could not be empty!");
    this.b = paramString1;
    this.mVipId = paramString2;
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo(this.d, 0);
      this.c = localPackageInfo.applicationInfo.loadLabel(this.a.getPackageManager()).toString();
      this.e = localPackageInfo.applicationInfo.loadIcon(this.a.getPackageManager());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public boolean sendReq(IShareReq paramIShareReq, boolean paramBoolean)
  {
    if (paramIShareReq != null)
    {
      Intent localIntent1 = new Intent();
      Bundle localBundle = paramIShareReq.toBundle();
      String str;
      if (localBundle != null)
      {
        if (!TextUtils.isEmpty(this.b))
          localBundle.putString("app_id", this.b);
        localBundle.putString("app_name", this.c);
        if (paramBoolean)
        {
          localBundle.putString("app_package_name", this.d);
          MLExtraInfo localMLExtraInfo = paramIShareReq.getJumpBackInfo();
          if (localMLExtraInfo != null)
            localBundle.putString("app_jump_back_info", localMLExtraInfo.toJson());
        }
        if (this.e != null)
          localBundle.putParcelable("app_icon_bmp", ShareUtils.drawableToBitmap(this.e));
        if (!TextUtils.isEmpty(this.mVipId))
          break label273;
        str = "800720";
        localBundle.putString("vip_id", str);
        if (!TextUtils.isEmpty(this.f))
          localBundle.putString("app_ios_local_uri", this.f);
      }
      List localList = ((ActivityManager)this.a.getSystemService("activity")).getRunningAppProcesses();
      label273: label311: for (int i = 0; ; i++)
      {
        int j = localList.size();
        int k = 0;
        if (i >= j);
        while (true)
        {
          localIntent1.putExtra("share_bundle", localBundle);
          localIntent1.setAction("com.xiaomi.channel.share");
          if (k != 0)
            break label317;
          Intent localIntent2 = this.a.getPackageManager().getLaunchIntentForPackage("com.xiaomi.channel");
          this.a.startActivity(localIntent2);
          new Handler(Looper.getMainLooper()).postDelayed(new g(this, localIntent1), 1000L);
          return true;
          str = this.mVipId;
          break;
          if (!((ActivityManager.RunningAppProcessInfo)localList.get(i)).processName.equals("com.xiaomi.channel"))
            break label311;
          k = 1;
        }
      }
      label317: this.a.sendBroadcast(localIntent1);
      return true;
    }
    return false;
  }

  public void setIosLocalUri(String paramString)
  {
    this.f = paramString;
  }

  public void setPackageNameAndAppName(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.d = paramString1;
      if (!TextUtils.isEmpty(paramString2))
        this.c = paramString2;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.MLShareApiFactory
 * JD-Core Version:    0.6.2
 */