package com.xiaomi.market.sdk;

import android.text.TextUtils;
import java.io.File;

public class q
{
  public String aU = "";
  public String aV = "";
  public String aW = "";
  public boolean aX = false;
  public String packageName = "";
  public String sourceDir = "";
  public int versionCode = 0;
  public String versionName = "";

  public static q h(String paramString)
  {
    q localq = new q();
    localq.packageName = paramString;
    return localq;
  }

  public String n()
  {
    if (TextUtils.isEmpty(this.sourceDir))
      return null;
    if (TextUtils.isEmpty(this.aW))
      return b.a(new File(this.sourceDir));
    return this.aW;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.q
 * JD-Core Version:    0.6.2
 */