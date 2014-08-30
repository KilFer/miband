package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

final class b
{
  private String a;
  private String b;
  private DisplayMetrics c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private int l;

  private b(Context paramContext)
  {
    this.b = "1.0.0";
    this.d = Build.VERSION.SDK_INT;
    this.e = Build.MODEL;
    this.f = Build.MANUFACTURER;
    this.g = Locale.getDefault().getLanguage();
    this.l = 0;
    this.c = StatCommonHelper.getDisplayMetrics(paramContext);
    this.a = StatCommonHelper.getCurAppVersion(paramContext);
    this.h = StatConfig.getInstallChannel(paramContext);
    this.i = StatCommonHelper.getSimOperator(paramContext);
    this.j = TimeZone.getDefault().getID();
    this.l = StatCommonHelper.hasRootAccess(paramContext);
    this.k = StatCommonHelper.getExternalStorageInfo(paramContext);
  }

  final void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("sr", this.c.widthPixels + "*" + this.c.heightPixels);
    StatCommonHelper.jsonPut(paramJSONObject, "av", this.a);
    StatCommonHelper.jsonPut(paramJSONObject, "ch", this.h);
    StatCommonHelper.jsonPut(paramJSONObject, "mf", this.f);
    StatCommonHelper.jsonPut(paramJSONObject, "sv", this.b);
    StatCommonHelper.jsonPut(paramJSONObject, "ov", Integer.toString(this.d));
    paramJSONObject.put("os", 1);
    StatCommonHelper.jsonPut(paramJSONObject, "op", this.i);
    StatCommonHelper.jsonPut(paramJSONObject, "lg", this.g);
    StatCommonHelper.jsonPut(paramJSONObject, "md", this.e);
    StatCommonHelper.jsonPut(paramJSONObject, "tz", this.j);
    if (this.l != 0)
      paramJSONObject.put("jb", this.l);
    StatCommonHelper.jsonPut(paramJSONObject, "sd", this.k);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.b
 * JD-Core Version:    0.6.2
 */