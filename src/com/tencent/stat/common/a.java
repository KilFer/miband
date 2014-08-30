package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.stat.StatConfig;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

class a
{
  String a;
  String b = "1.0.0";
  DisplayMetrics c;
  int d = Build.VERSION.SDK_INT;
  String e = Build.MODEL;
  String f = Build.MANUFACTURER;
  String g = Locale.getDefault().getLanguage();
  String h;
  String i;
  String j;
  String k;
  int l = 0;

  private a(Context paramContext)
  {
    this.c = StatCommonHelper.getDisplayMetrics(paramContext);
    this.a = StatCommonHelper.getCurAppVersion(paramContext);
    this.h = StatConfig.getInstallChannel(paramContext);
    this.i = StatCommonHelper.getSimOperator(paramContext);
    this.j = TimeZone.getDefault().getID();
    this.l = StatCommonHelper.hasRootAccess(paramContext);
    this.k = StatCommonHelper.getExternalStorageInfo(paramContext);
  }

  void a(JSONObject paramJSONObject)
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
 * Qualified Name:     com.tencent.stat.common.a
 * JD-Core Version:    0.6.2
 */