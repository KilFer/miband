package com.xiaomi.market.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class t extends AsyncTask
{
  private static w a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      Log.e("MarketUpdateAgent", "update info json obj null");
      return null;
    }
    w localw = new w();
    try
    {
      localw.a = paramJSONObject.getString("host");
      localw.b = paramJSONObject.getInt("fitness");
      localw.c = paramJSONObject.getString("updateLog");
      localw.d = paramJSONObject.getInt("versionCode");
      localw.e = paramJSONObject.getString("versionName");
      localw.f = paramJSONObject.getString("apk");
      localw.g = paramJSONObject.getString("apkHash");
      localw.h = paramJSONObject.getLong("apkSize");
      localw.l = paramJSONObject.optInt("source", 0);
      if (XiaomiUpdateAgent.d())
      {
        localw.i = paramJSONObject.getString("diffFile");
        localw.j = paramJSONObject.getString("diffFileHash");
        localw.k = paramJSONObject.getLong("diffFileSize");
      }
      return localw;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MarketUpdateAgent", "get update info failed : " + localJSONException.toString());
      Log.e("MarketUpdateAgent", "original content : " + paramJSONObject.toString());
    }
    return null;
  }

  private static void a(Integer paramInteger)
  {
    if (!XiaomiUpdateAgent.g())
    {
      UpdateResponse localUpdateResponse = new UpdateResponse();
      if (paramInteger.intValue() == 0)
      {
        localUpdateResponse.updateLog = XiaomiUpdateAgent.f().c;
        localUpdateResponse.versionCode = XiaomiUpdateAgent.f().d;
        localUpdateResponse.versionName = XiaomiUpdateAgent.f().e;
        localUpdateResponse.path = c.c(XiaomiUpdateAgent.f().a, XiaomiUpdateAgent.f().f);
      }
      if (XiaomiUpdateAgent.h() != null)
        XiaomiUpdateAgent.h().onUpdateReturned(paramInteger.intValue(), localUpdateResponse);
      return;
    }
    switch (paramInteger.intValue())
    {
    default:
      return;
    case 0:
    }
    new v((byte)0).execute(new Void[0]);
  }

  private Integer b()
  {
    if (!s.b(XiaomiUpdateAgent.b()))
      return Integer.valueOf(3);
    if ((!s.c(XiaomiUpdateAgent.b())) && (XiaomiUpdateAgent.e()))
      return Integer.valueOf(2);
    a.a(XiaomiUpdateAgent.b());
    XiaomiUpdateAgent.a(XiaomiUpdateAgent.a(XiaomiUpdateAgent.b()));
    if (XiaomiUpdateAgent.c() == null)
      return Integer.valueOf(5);
    c localc = new c(j.V);
    localc.getClass();
    h localh = new h(localc);
    localh.d("info", c());
    localh.d("packageName", XiaomiUpdateAgent.c().packageName);
    localh.d("versionCode", XiaomiUpdateAgent.c().versionCode);
    localh.d("apkHash", XiaomiUpdateAgent.c().aW);
    localh.d("signature", XiaomiUpdateAgent.c().aV);
    localh.d("clientId", a.n);
    localh.d("sdk", String.valueOf(a.j));
    localh.d("os", a.k);
    localh.d("la", a.o);
    localh.d("co", a.p);
    localh.d("xiaomiSDKVersion", "0");
    if (g.I == localc.h())
    {
      JSONObject localJSONObject = localc.e();
      if (s.a)
        Log.d("MarketUpdateAgent", localJSONObject.toString());
      XiaomiUpdateAgent.a(a(localJSONObject));
      if (XiaomiUpdateAgent.f() != null)
      {
        Log.i("MarketUpdateAgent", XiaomiUpdateAgent.f().toString());
        if (XiaomiUpdateAgent.f().b == 0);
        for (int i = 0; ; i = 1)
          return Integer.valueOf(i);
      }
    }
    return Integer.valueOf(4);
  }

  private static String c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("screenSize", a.a + "*" + a.b);
      localJSONObject.put("resolution", a.c);
      localJSONObject.put("density", a.d);
      localJSONObject.put("touchScreen", a.e);
      localJSONObject.put("glEsVersion", a.f);
      localJSONObject.put("feature", a.g);
      localJSONObject.put("library", a.h);
      localJSONObject.put("glExtension", a.i);
      localJSONObject.put("sdk", a.j);
      localJSONObject.put("version", a.k);
      localJSONObject.put("release", a.l);
      localJSONObject.put("imei", a.m);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  private static void d()
  {
    if (((XiaomiUpdateAgent.b() instanceof Activity)) && (((Activity)XiaomiUpdateAgent.b()).isFinishing()))
    {
      Log.e("MarketUpdateAgent", "activity not running!");
      return;
    }
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(XiaomiUpdateAgent.b());
    Context localContext1 = XiaomiUpdateAgent.b();
    int i = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_title");
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = XiaomiUpdateAgent.c().aU;
    AlertDialog.Builder localBuilder2 = localBuilder1.setTitle(localContext1.getString(i, arrayOfObject1));
    Context localContext3;
    int k;
    Object[] arrayOfObject3;
    if (TextUtils.isEmpty(XiaomiUpdateAgent.f().i))
    {
      localContext3 = XiaomiUpdateAgent.b();
      k = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_message");
      arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = XiaomiUpdateAgent.f().e;
      arrayOfObject3[1] = s.a(XiaomiUpdateAgent.f().h, XiaomiUpdateAgent.b());
    }
    Context localContext2;
    int j;
    Object[] arrayOfObject2;
    for (String str = localContext3.getString(k, arrayOfObject3); ; str = localContext2.getString(j, arrayOfObject2))
    {
      localBuilder2.setMessage(str).setNegativeButton(17039360, null).setPositiveButton(17039370, new u()).show();
      return;
      localContext2 = XiaomiUpdateAgent.b();
      j = s.a(XiaomiUpdateAgent.b().getPackageName(), "string", "xiaomi_update_dialog_message_diff");
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = XiaomiUpdateAgent.f().e;
      arrayOfObject2[1] = s.a(XiaomiUpdateAgent.f().k, XiaomiUpdateAgent.b());
    }
  }

  protected final void onPreExecute()
  {
    Log.d("MarketUpdateAgent", "start to check update");
    if (!XiaomiUpdateAgent.d())
      XiaomiUpdateAgent.a(Patcher.o());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.t
 * JD-Core Version:    0.6.2
 */