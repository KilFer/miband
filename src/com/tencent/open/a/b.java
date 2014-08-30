package com.tencent.open.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.utils.OpenConfig;
import java.util.ArrayList;
import java.util.Random;

public class b
{
  private static b a = null;
  private long b = 0L;
  private int c = 3;
  private boolean d = false;
  private Random e = new Random();
  private d f;
  private ArrayList<a> g = new ArrayList();
  private ArrayList<a> h = new ArrayList();

  public static b a()
  {
    if (a == null)
      a = new b();
    return a;
  }

  private static String a(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
      {
        Log.e("cgi_report_debug", "ReportManager getAPN failed:ConnectivityManager == null");
        return "no_net";
      }
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
      {
        Log.e("cgi_report_debug", "ReportManager getAPN failed:NetworkInfo == null");
        return "no_net";
      }
      if (localNetworkInfo.getTypeName().toUpperCase().equals("WIFI"))
      {
        Log.i("cgi_report_debug", "ReportManager getAPN type = wifi");
        return "wifi";
      }
      String str1 = localNetworkInfo.getExtraInfo();
      if (str1 == null)
      {
        Log.e("cgi_report_debug", "ReportManager getAPN failed:extraInfo == null");
        return "mobile_unknow";
      }
      String str2 = str1.toLowerCase();
      Log.i("cgi_report_debug", "ReportManager getAPN type = " + str2);
      return str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "unknow";
  }

  private void a(Context paramContext, String paramString)
  {
    Log.i("cgi_report_debug", "ReportManager doUpload start");
    this.d = true;
    this.g = this.f.c();
    this.f.b();
    this.h = this.f.d();
    this.f.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramString);
    localBundle.putString("releaseversion", "QQConnect_SDK_Android_1_7");
    localBundle.putString("device", Build.DEVICE);
    localBundle.putString("qua", "V1_AND_OpenSDK_2.1_1077_RDM_B");
    localBundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,deviceinfo");
    for (int i = 0; i < this.g.size(); i++)
    {
      localBundle.putString(i + "_1", ((a)this.g.get(i)).a());
      localBundle.putString(i + "_2", ((a)this.g.get(i)).b());
      localBundle.putString(i + "_3", ((a)this.g.get(i)).c());
      localBundle.putString(i + "_4", ((a)this.g.get(i)).d());
      localBundle.putString(i + "_5", ((a)this.g.get(i)).e());
      localBundle.putString(i + "_6", ((a)this.g.get(i)).f());
      localBundle.putString(i + "_7", ((a)this.g.get(i)).g());
      localBundle.putString(i + "_8", ((a)this.g.get(i)).h());
      String str2 = c.b(paramContext) + ((a)this.g.get(i)).i();
      localBundle.putString(i + "_9", str2);
    }
    for (int j = this.g.size(); j < this.h.size() + this.g.size(); j++)
    {
      int k = j - this.g.size();
      localBundle.putString(j + "_1", ((a)this.h.get(k)).a());
      localBundle.putString(j + "_2", ((a)this.h.get(k)).b());
      localBundle.putString(j + "_3", ((a)this.h.get(k)).c());
      localBundle.putString(j + "_4", ((a)this.h.get(k)).d());
      localBundle.putString(j + "_5", ((a)this.h.get(k)).e());
      localBundle.putString(j + "_6", ((a)this.h.get(k)).f());
      localBundle.putString(j + "_7", ((a)this.h.get(k)).g());
      localBundle.putString(j + "_8", ((a)this.h.get(k)).h());
      String str1 = c.b(paramContext) + ((a)this.h.get(k)).i();
      localBundle.putString(j + "_9", str1);
    }
    new e(this, "http://wspeed.qq.com/w.cgi", paramContext, localBundle).start();
  }

  private void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    new e(this, paramString, paramContext, paramBundle).start();
  }

  private boolean a(Context paramContext, int paramInt)
  {
    int i = b(paramContext, paramInt);
    if (this.e.nextInt(100) < i)
    {
      Log.i("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    Log.i("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }

  private static int b(Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      int j = OpenConfig.getInstance(paramContext, null).getInt("Common_CGIReportFrequencySuccess");
      Log.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + j);
      if (j == 0)
        j = 10;
      Log.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + j);
      return j;
    }
    int i = OpenConfig.getInstance(paramContext, null).getInt("Common_CGIReportFrequencyFailed");
    Log.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + i);
    if (i == 0)
      i = 100;
    Log.d("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + i);
    return i;
  }

  private void b(Context paramContext, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2)
  {
    long l = SystemClock.elapsedRealtime() - paramLong1;
    Log.i("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + l + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
    int i = 100 / b(paramContext, paramInt);
    int j;
    if (i <= 0)
      j = 1;
    while (true)
    {
      String str = a(paramContext);
      this.f.a(str, j, paramString1, paramInt, l, paramLong2, paramLong3, paramString2);
      return;
      if (i > 100)
        j = 100;
      else
        j = i;
    }
  }

  private boolean b(Context paramContext)
  {
    long l1 = OpenConfig.getInstance(paramContext, null).getLong("Common_CGIReportTimeinterval");
    Log.d("OpenConfig_test", "config 5:Common_CGIReportTimeinterval     config_value:" + l1);
    if (l1 == 0L)
      l1 = 1200L;
    Log.d("OpenConfig_test", "config 5:Common_CGIReportTimeinterval     result_value:" + l1);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.b == 0L) || (l1 + this.b <= l2))
    {
      this.b = l2;
      Log.i("cgi_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    Log.i("cgi_report_debug", "ReportManager availableForTime = false");
    return false;
  }

  private boolean c(Context paramContext)
  {
    int i = OpenConfig.getInstance(paramContext, null).getInt("Common_CGIReportMaxcount");
    Log.d("OpenConfig_test", "config 6:Common_CGIReportMaxcount     config_value:" + i);
    if (i == 0)
      i = 20;
    Log.d("OpenConfig_test", "config 6:Common_CGIReportMaxcount     result_value:" + i);
    if (this.f.e() >= i)
    {
      Log.i("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    Log.i("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }

  public void a(Context paramContext, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2)
  {
    a(paramContext, paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramString2, "", null);
  }

  public void a(Context paramContext, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (paramString4 == null)
      paramString4 = "1000067";
    if (this.f == null)
      this.f = new d(paramContext);
    int i = b(paramContext, paramInt);
    int j;
    long l1;
    int k;
    int m;
    if (this.e.nextInt(100) < i)
    {
      Log.i("cgi_report_debug", "ReportManager availableForFrequency = ture");
      j = 1;
      if (j == 1)
      {
        l1 = SystemClock.elapsedRealtime() - paramLong1;
        Log.i("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + l1 + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
        k = 100 / b(paramContext, paramInt);
        if (k > 0)
          break label228;
        m = 1;
      }
    }
    while (true)
    {
      label162: String str = a(paramContext);
      this.f.a(str, m, paramString1, paramInt, l1, paramLong2, paramLong3, paramString3);
      if (this.d == true);
      while (true)
      {
        return;
        Log.i("cgi_report_debug", "ReportManager availableForFrequency = false");
        j = 0;
        break;
        label228: if (k <= 100)
          break label520;
        m = 100;
        break label162;
        long l2 = OpenConfig.getInstance(paramContext, null).getLong("Common_CGIReportTimeinterval");
        Log.d("OpenConfig_test", "config 5:Common_CGIReportTimeinterval     config_value:" + l2);
        if (l2 == 0L)
          l2 = 1200L;
        Log.d("OpenConfig_test", "config 5:Common_CGIReportTimeinterval     result_value:" + l2);
        long l3 = System.currentTimeMillis() / 1000L;
        if ((this.b == 0L) || (l2 + this.b <= l3))
        {
          this.b = l3;
          Log.i("cgi_report_debug", "ReportManager availableForTime = ture");
        }
        for (int n = 1; n == 1; n = 0)
        {
          a(paramContext, paramString4);
          return;
          Log.i("cgi_report_debug", "ReportManager availableForTime = false");
        }
        int i1 = OpenConfig.getInstance(paramContext, null).getInt("Common_CGIReportMaxcount");
        Log.d("OpenConfig_test", "config 6:Common_CGIReportMaxcount     config_value:" + i1);
        if (i1 == 0)
          i1 = 20;
        Log.d("OpenConfig_test", "config 6:Common_CGIReportMaxcount     result_value:" + i1);
        if (this.f.e() >= i1)
          Log.i("cgi_report_debug", "ReportManager availableForCount = ture");
        for (int i2 = 1; i2 == 1; i2 = 0)
        {
          a(paramContext, paramString4);
          return;
          Log.i("cgi_report_debug", "ReportManager availableForCount = false");
        }
      }
      label520: m = k;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.a.b
 * JD-Core Version:    0.6.2
 */