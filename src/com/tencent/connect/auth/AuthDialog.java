package com.tencent.connect.auth;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDialog extends Dialog
{
  private static WeakReference<Context> a;
  private static WeakReference<View> l;
  private String b;
  private m c;
  private IUiListener d;
  private Handler e;
  private FrameLayout f;
  private LinearLayout g;
  private FrameLayout h;
  private ProgressBar i;
  private String j;
  private WebView k;
  private boolean m = false;

  public AuthDialog(Context paramContext, String paramString1, String paramString2, IUiListener paramIUiListener, QQToken paramQQToken)
  {
    super(paramContext, 16973840);
    a = new WeakReference(paramContext.getApplicationContext());
    this.b = paramString2;
    this.c = new m(this, paramString1, paramString2, paramQQToken.getAppId(), paramIUiListener);
    this.e = new n(this.c, paramContext.getMainLooper());
    this.d = paramIUiListener;
    this.j = paramString1;
  }

  private static void b(Context paramContext, String paramString)
  {
    try
    {
      JSONObject localJSONObject = Util.parseJson(paramString);
      int n = localJSONObject.getInt("type");
      String str = localJSONObject.getString("msg");
      Toast.makeText(paramContext.getApplicationContext(), str, n).show();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  private void c()
  {
    this.i = new ProgressBar((Context)a.get());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.i.setLayoutParams(localLayoutParams1);
    this.g = new LinearLayout((Context)a.get());
    boolean bool = this.j.equals("action_login");
    Object localObject = null;
    LinearLayout.LayoutParams localLayoutParams2;
    TextView localTextView;
    if (bool)
    {
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.gravity = 16;
      localLayoutParams2.leftMargin = 5;
      localTextView = new TextView((Context)a.get());
      if (!Locale.getDefault().getLanguage().equals("zh"))
        break label446;
      localTextView.setText("登录中...");
    }
    while (true)
    {
      localTextView.setTextColor(Color.rgb(255, 255, 255));
      localTextView.setTextSize(18.0F);
      localTextView.setLayoutParams(localLayoutParams2);
      localObject = localTextView;
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams3.gravity = 17;
      this.g.setLayoutParams(localLayoutParams3);
      this.g.addView(this.i);
      if (localObject != null)
        this.g.addView(localObject);
      this.h = new FrameLayout((Context)a.get());
      FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams4.leftMargin = 80;
      localLayoutParams4.rightMargin = 80;
      localLayoutParams4.topMargin = 40;
      localLayoutParams4.bottomMargin = 40;
      localLayoutParams4.gravity = 17;
      this.h.setLayoutParams(localLayoutParams4);
      this.h.setBackgroundResource(17301504);
      this.h.addView(this.g);
      FrameLayout.LayoutParams localLayoutParams5 = new FrameLayout.LayoutParams(-1, -1);
      this.k = new WebView((Context)a.get());
      this.k.setLayoutParams(localLayoutParams5);
      this.f = new FrameLayout((Context)a.get());
      localLayoutParams5.gravity = 17;
      this.f.setLayoutParams(localLayoutParams5);
      this.f.addView(this.k);
      this.f.addView(this.h);
      l = new WeakReference(this.h);
      setContentView(this.f);
      return;
      label446: localTextView.setText("Logging in...");
    }
  }

  private void d()
  {
    this.i = new ProgressBar((Context)a.get());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.i.setLayoutParams(localLayoutParams1);
    this.g = new LinearLayout((Context)a.get());
    boolean bool = this.j.equals("action_login");
    Object localObject = null;
    LinearLayout.LayoutParams localLayoutParams2;
    TextView localTextView;
    if (bool)
    {
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.gravity = 16;
      localLayoutParams2.leftMargin = 5;
      localTextView = new TextView((Context)a.get());
      if (!Locale.getDefault().getLanguage().equals("zh"))
        break label326;
      localTextView.setText("登录中...");
    }
    while (true)
    {
      localTextView.setTextColor(Color.rgb(255, 255, 255));
      localTextView.setTextSize(18.0F);
      localTextView.setLayoutParams(localLayoutParams2);
      localObject = localTextView;
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams3.gravity = 17;
      this.g.setLayoutParams(localLayoutParams3);
      this.g.addView(this.i);
      if (localObject != null)
        this.g.addView(localObject);
      this.h = new FrameLayout((Context)a.get());
      FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams4.leftMargin = 80;
      localLayoutParams4.rightMargin = 80;
      localLayoutParams4.topMargin = 40;
      localLayoutParams4.bottomMargin = 40;
      localLayoutParams4.gravity = 17;
      this.h.setLayoutParams(localLayoutParams4);
      this.h.setBackgroundResource(17301504);
      this.h.addView(this.g);
      return;
      label326: localTextView.setText("Logging in...");
    }
  }

  private void e()
  {
    this.k.setVerticalScrollBarEnabled(false);
    this.k.setHorizontalScrollBarEnabled(false);
    this.k.setWebViewClient(new l(this, (byte)0));
    this.k.setWebChromeClient(new WebChromeClient());
    this.k.clearFormData();
    WebSettings localWebSettings = this.k.getSettings();
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setJavaScriptEnabled(true);
    if ((a != null) && (a.get() != null))
    {
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(((Context)a.get()).getApplicationContext().getDir("databases", 0).getPath());
    }
    localWebSettings.setDomStorageEnabled(true);
    try
    {
      Method localMethod = WebView.class.getMethod("addJavascriptInterface", new Class[] { Object.class, String.class });
      WebView localWebView = this.k;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = new j(this, 0);
      arrayOfObject[1] = "sdk_js_if";
      localMethod.invoke(localWebView, arrayOfObject);
      this.k.loadUrl(this.b);
      this.k.setVisibility(4);
      this.k.getSettings().setSavePassword(false);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        localNoSuchMethodException.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        localIllegalArgumentException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        localInvocationTargetException.printStackTrace();
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("AuthDialog", localException.getMessage());
    }
  }

  private boolean f()
  {
    AuthMap localAuthMap = AuthMap.getInstance();
    String str1 = localAuthMap.makeKey();
    AuthMap.Auth localAuth = new AuthMap.Auth();
    localAuth.listener = this.d;
    localAuth.dialog = this;
    localAuth.key = str1;
    String str2 = localAuthMap.set(localAuth);
    String str3 = this.b.substring(0, this.b.indexOf("?"));
    Bundle localBundle = Util.parseUrl(this.b);
    localBundle.putString("token_key", str1);
    localBundle.putString("serial", str2);
    localBundle.putString("browser", "1");
    this.b = (str3 + "?" + Util.encodeUrl(localBundle));
    WeakReference localWeakReference = a;
    boolean bool = false;
    if (localWeakReference != null)
    {
      Object localObject = a.get();
      bool = false;
      if (localObject != null)
        bool = Util.openBrowser((Context)a.get(), this.b);
    }
    return bool;
  }

  public void callJs(String paramString1, String paramString2)
  {
    String str = "javascript:" + paramString1 + "(" + paramString2 + ");void(" + System.currentTimeMillis() + ");";
    this.k.loadUrl(str);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.i = new ProgressBar((Context)a.get());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    this.i.setLayoutParams(localLayoutParams1);
    this.g = new LinearLayout((Context)a.get());
    boolean bool = this.j.equals("action_login");
    Object localObject = null;
    LinearLayout.LayoutParams localLayoutParams2;
    TextView localTextView;
    if (bool)
    {
      localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.gravity = 16;
      localLayoutParams2.leftMargin = 5;
      localTextView = new TextView((Context)a.get());
      if (!Locale.getDefault().getLanguage().equals("zh"))
        break label727;
      localTextView.setText("登录中...");
    }
    while (true)
    {
      localTextView.setTextColor(Color.rgb(255, 255, 255));
      localTextView.setTextSize(18.0F);
      localTextView.setLayoutParams(localLayoutParams2);
      localObject = localTextView;
      FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams3.gravity = 17;
      this.g.setLayoutParams(localLayoutParams3);
      this.g.addView(this.i);
      if (localObject != null)
        this.g.addView(localObject);
      this.h = new FrameLayout((Context)a.get());
      FrameLayout.LayoutParams localLayoutParams4 = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams4.leftMargin = 80;
      localLayoutParams4.rightMargin = 80;
      localLayoutParams4.topMargin = 40;
      localLayoutParams4.bottomMargin = 40;
      localLayoutParams4.gravity = 17;
      this.h.setLayoutParams(localLayoutParams4);
      this.h.setBackgroundResource(17301504);
      this.h.addView(this.g);
      FrameLayout.LayoutParams localLayoutParams5 = new FrameLayout.LayoutParams(-1, -1);
      this.k = new WebView((Context)a.get());
      this.k.setLayoutParams(localLayoutParams5);
      this.f = new FrameLayout((Context)a.get());
      localLayoutParams5.gravity = 17;
      this.f.setLayoutParams(localLayoutParams5);
      this.f.addView(this.k);
      this.f.addView(this.h);
      l = new WeakReference(this.h);
      setContentView(this.f);
      this.k.setVerticalScrollBarEnabled(false);
      this.k.setHorizontalScrollBarEnabled(false);
      this.k.setWebViewClient(new l(this, (byte)0));
      this.k.setWebChromeClient(new WebChromeClient());
      this.k.clearFormData();
      WebSettings localWebSettings = this.k.getSettings();
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setCacheMode(-1);
      localWebSettings.setNeedInitialFocus(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setSupportZoom(true);
      localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
      localWebSettings.setJavaScriptEnabled(true);
      if ((a != null) && (a.get() != null))
      {
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDatabasePath(((Context)a.get()).getApplicationContext().getDir("databases", 0).getPath());
      }
      localWebSettings.setDomStorageEnabled(true);
      try
      {
        Method localMethod = WebView.class.getMethod("addJavascriptInterface", new Class[] { Object.class, String.class });
        WebView localWebView = this.k;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = new j(this, 0);
        arrayOfObject[1] = "sdk_js_if";
        localMethod.invoke(localWebView, arrayOfObject);
        this.k.loadUrl(this.b);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
        return;
        label727: localTextView.setText("Logging in...");
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        while (true)
          localNoSuchMethodException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        while (true)
          localIllegalAccessException.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        while (true)
          localInvocationTargetException.printStackTrace();
      }
      catch (Exception localException)
      {
        while (true)
          Log.e("AuthDialog", localException.getMessage());
      }
    }
  }

  protected void onStop()
  {
    if (!this.m)
      this.c.onCancel();
    super.onStop();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthDialog
 * JD-Core Version:    0.6.2
 */