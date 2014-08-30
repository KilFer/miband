package com.tencent.open;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.a.a;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class PKDialog extends d
  implements a.a
{
  private static final String a = PKDialog.class.getName();
  private static final int b = 185;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static WeakReference<Context> n;
  private static Toast p = null;
  private String h;
  private IUiListener i;
  private g j;
  private Handler k;
  private com.tencent.open.b.a l;
  private WebView m;
  private int o;

  public PKDialog(Context paramContext, String paramString1, String paramString2, IUiListener paramIUiListener, QQToken paramQQToken)
  {
    super(paramContext, 16973840);
    n = new WeakReference(paramContext);
    this.h = paramString2;
    this.j = new g(paramContext, paramString1, paramString2, paramQQToken.getAppId(), paramIUiListener);
    this.k = new h(this.j, paramContext.getMainLooper());
    this.o = Math.round(185.0F * paramContext.getResources().getDisplayMetrics().density);
    Log.e(a, "density=" + paramContext.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.o);
  }

  private static void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramString1, paramString2));
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(1073741824);
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.parse(paramString3));
    if ((n != null) && (n.get() != null))
      ((Context)n.get()).startActivity(localIntent);
  }

  private void c()
  {
    this.l = new com.tencent.open.b.a((Context)n.get());
    this.l.setBackgroundColor(1711276032);
    this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.m = new WebView((Context)n.get());
    this.m.setBackgroundColor(0);
    this.m.setBackgroundDrawable(null);
    if (Build.VERSION.SDK_INT >= 11);
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = Paint.class;
      Method localMethod = View.class.getMethod("setLayerType", arrayOfClass);
      WebView localWebView = this.m;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(1);
      arrayOfObject[1] = new Paint();
      localMethod.invoke(localWebView, arrayOfObject);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.o);
      localLayoutParams.addRule(13, -1);
      this.m.setLayoutParams(localLayoutParams);
      this.l.addView(this.m);
      this.l.a(this);
      setContentView(this.l);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private static void c(Context paramContext, String paramString)
  {
    int i1;
    String str;
    try
    {
      JSONObject localJSONObject = Util.parseJson(paramString);
      i1 = localJSONObject.getInt("type");
      str = localJSONObject.getString("msg");
      if (i1 == 0)
      {
        if (p == null)
          p = Toast.makeText(paramContext, str, 0);
        while (true)
        {
          p.show();
          return;
          p.setView(p.getView());
          p.setText(str);
          p.setDuration(0);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    if (i1 == 1)
    {
      if (p == null)
        p = Toast.makeText(paramContext, str, 1);
      while (true)
      {
        p.show();
        return;
        p.setView(p.getView());
        p.setText(str);
        p.setDuration(1);
      }
    }
  }

  private void d()
  {
    this.m.setVerticalScrollBarEnabled(false);
    this.m.setHorizontalScrollBarEnabled(false);
    this.m.setWebViewClient(new e(this, (byte)0));
    this.m.setWebChromeClient(this.mChromeClient);
    this.m.clearFormData();
    WebSettings localWebSettings = this.m.getSettings();
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setJavaScriptEnabled(true);
    if ((n != null) && (n.get() != null))
    {
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(((Context)n.get()).getApplicationContext().getDir("databases", 0).getPath());
    }
    localWebSettings.setDomStorageEnabled(true);
    this.jsBridge.a(new f(this, (byte)0), "sdk_js_if");
    this.m.clearView();
    this.m.loadUrl(this.h);
    this.m.getSettings().setSavePassword(false);
  }

  private static void d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null))
      return;
    try
    {
      JSONObject localJSONObject = Util.parseJson(paramString);
      localJSONObject.getInt("action");
      localJSONObject.getString("msg");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public void callJs(String paramString1, String paramString2)
  {
    String str = "javascript:" + paramString1 + "(" + paramString2 + ")";
    this.m.loadUrl(str);
  }

  public void onBackPressed()
  {
    super.onBackPressed();
  }

  protected void onConsoleMessage(String paramString)
  {
    Log.d("PKDialog", "--onConsoleMessage--");
    try
    {
      this.jsBridge.a(this.m, paramString);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(16);
    getWindow().setSoftInputMode(1);
    this.l = new com.tencent.open.b.a((Context)n.get());
    this.l.setBackgroundColor(1711276032);
    this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.m = new WebView((Context)n.get());
    this.m.setBackgroundColor(0);
    this.m.setBackgroundDrawable(null);
    if (Build.VERSION.SDK_INT >= 11);
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = Paint.class;
      Method localMethod = View.class.getMethod("setLayerType", arrayOfClass);
      WebView localWebView = this.m;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(1);
      arrayOfObject[1] = new Paint();
      localMethod.invoke(localWebView, arrayOfObject);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.o);
      localLayoutParams.addRule(13, -1);
      this.m.setLayoutParams(localLayoutParams);
      this.l.addView(this.m);
      this.l.a(this);
      setContentView(this.l);
      this.m.setVerticalScrollBarEnabled(false);
      this.m.setHorizontalScrollBarEnabled(false);
      this.m.setWebViewClient(new e(this, (byte)0));
      this.m.setWebChromeClient(this.mChromeClient);
      this.m.clearFormData();
      WebSettings localWebSettings = this.m.getSettings();
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setCacheMode(-1);
      localWebSettings.setNeedInitialFocus(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setSupportZoom(true);
      localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
      localWebSettings.setJavaScriptEnabled(true);
      if ((n != null) && (n.get() != null))
      {
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDatabasePath(((Context)n.get()).getApplicationContext().getDir("databases", 0).getPath());
      }
      localWebSettings.setDomStorageEnabled(true);
      this.jsBridge.a(new f(this, (byte)0), "sdk_js_if");
      this.m.clearView();
      this.m.loadUrl(this.h);
      this.m.getSettings().setSavePassword(false);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void onKeyboardHidden()
  {
    this.m.getLayoutParams().height = this.o;
    Log.e(a, "keyboard hide");
  }

  public void onKeyboardShown(int paramInt)
  {
    if ((n != null) && (n.get() != null))
      if ((paramInt >= this.o) || (2 != ((Context)n.get()).getResources().getConfiguration().orientation))
        break label67;
    label67: for (this.m.getLayoutParams().height = paramInt; ; this.m.getLayoutParams().height = this.o)
    {
      Log.e(a, "keyboard show");
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.PKDialog
 * JD-Core Version:    0.6.2
 */