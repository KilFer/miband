package com.tencent.open;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TDialog extends d
{
  private static FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -1);
  private static WeakReference<Context> b;
  private static WeakReference<View> c;
  private static WeakReference<ProgressDialog> d;
  private static Toast o = null;
  private String e;
  private o f;
  private IUiListener g;
  private FrameLayout h;
  private WebView i;
  private FrameLayout j;
  private ProgressBar k;
  private Handler l;
  private boolean m = false;
  private QQToken n;

  public TDialog(Context paramContext, String paramString1, String paramString2, IUiListener paramIUiListener, QQToken paramQQToken)
  {
    super(paramContext, 16973840);
    b = new WeakReference(paramContext);
    this.e = paramString2;
    this.f = new o(paramContext, paramString1, paramString2, paramQQToken.getAppId(), paramIUiListener);
    this.l = new p(this.f, paramContext.getMainLooper());
  }

  private void c()
  {
    this.k = new ProgressBar((Context)b.get());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams1.gravity = 17;
    this.k.setLayoutParams(localLayoutParams1);
    new TextView((Context)b.get()).setText("test");
    this.j = new FrameLayout((Context)b.get());
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams2.bottomMargin = 40;
    localLayoutParams2.leftMargin = 80;
    localLayoutParams2.rightMargin = 80;
    localLayoutParams2.topMargin = 40;
    localLayoutParams2.gravity = 17;
    this.j.setLayoutParams(localLayoutParams2);
    this.j.setBackgroundResource(17301504);
    this.j.addView(this.k);
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -1);
    this.i = new WebView((Context)b.get());
    this.i.setLayoutParams(localLayoutParams3);
    this.h = new FrameLayout((Context)b.get());
    localLayoutParams3.gravity = 17;
    this.h.setLayoutParams(localLayoutParams3);
    this.h.addView(this.i);
    this.h.addView(this.j);
    c = new WeakReference(this.j);
    setContentView(this.h);
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
        if (o == null)
          o = Toast.makeText(paramContext, str, 0);
        while (true)
        {
          o.show();
          return;
          o.setView(o.getView());
          o.setText(str);
          o.setDuration(0);
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
      if (o == null)
        o = Toast.makeText(paramContext, str, 1);
      while (true)
      {
        o.show();
        return;
        o.setView(o.getView());
        o.setText(str);
        o.setDuration(1);
      }
    }
  }

  private void d()
  {
    this.i.setVerticalScrollBarEnabled(false);
    this.i.setHorizontalScrollBarEnabled(false);
    this.i.setWebViewClient(new m(this, (byte)0));
    this.i.setWebChromeClient(this.mChromeClient);
    this.i.clearFormData();
    WebSettings localWebSettings = this.i.getSettings();
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setJavaScriptEnabled(true);
    if ((b != null) && (b.get() != null))
    {
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(((Context)b.get()).getApplicationContext().getDir("databases", 0).getPath());
    }
    localWebSettings.setDomStorageEnabled(true);
    this.jsBridge.a(new n(this, (byte)0), "sdk_js_if");
    this.i.loadUrl(this.e);
    this.i.setLayoutParams(a);
    this.i.setVisibility(4);
    this.i.getSettings().setSavePassword(false);
  }

  private static void d(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null));
    int i1;
    do
    {
      do
      {
        return;
        String str;
        try
        {
          JSONObject localJSONObject = Util.parseJson(paramString);
          i1 = localJSONObject.getInt("action");
          str = localJSONObject.getString("msg");
          if (i1 != 1)
            break;
          if (d == null)
          {
            ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
            localProgressDialog.setMessage(str);
            d = new WeakReference(localProgressDialog);
            localProgressDialog.show();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return;
        }
        ((ProgressDialog)d.get()).setMessage(str);
      }
      while (((ProgressDialog)d.get()).isShowing());
      ((ProgressDialog)d.get()).show();
      return;
    }
    while ((i1 != 0) || (d == null) || (d.get() == null) || (!((ProgressDialog)d.get()).isShowing()));
    ((ProgressDialog)d.get()).dismiss();
    d = null;
  }

  protected void onConsoleMessage(String paramString)
  {
    Log.d("TDialog", "--onConsoleMessage--");
    try
    {
      this.jsBridge.a(this.i, paramString);
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
    this.k = new ProgressBar((Context)b.get());
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams1.gravity = 17;
    this.k.setLayoutParams(localLayoutParams1);
    new TextView((Context)b.get()).setText("test");
    this.j = new FrameLayout((Context)b.get());
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams2.bottomMargin = 40;
    localLayoutParams2.leftMargin = 80;
    localLayoutParams2.rightMargin = 80;
    localLayoutParams2.topMargin = 40;
    localLayoutParams2.gravity = 17;
    this.j.setLayoutParams(localLayoutParams2);
    this.j.setBackgroundResource(17301504);
    this.j.addView(this.k);
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -1);
    this.i = new WebView((Context)b.get());
    this.i.setLayoutParams(localLayoutParams3);
    this.h = new FrameLayout((Context)b.get());
    localLayoutParams3.gravity = 17;
    this.h.setLayoutParams(localLayoutParams3);
    this.h.addView(this.i);
    this.h.addView(this.j);
    c = new WeakReference(this.j);
    setContentView(this.h);
    this.i.setVerticalScrollBarEnabled(false);
    this.i.setHorizontalScrollBarEnabled(false);
    this.i.setWebViewClient(new m(this, (byte)0));
    this.i.setWebChromeClient(this.mChromeClient);
    this.i.clearFormData();
    WebSettings localWebSettings = this.i.getSettings();
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setJavaScriptEnabled(true);
    if ((b != null) && (b.get() != null))
    {
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDatabasePath(((Context)b.get()).getApplicationContext().getDir("databases", 0).getPath());
    }
    localWebSettings.setDomStorageEnabled(true);
    this.jsBridge.a(new n(this, (byte)0), "sdk_js_if");
    this.i.loadUrl(this.e);
    this.i.setLayoutParams(a);
    this.i.setVisibility(4);
    this.i.getSettings().setSavePassword(false);
  }

  protected void onStop()
  {
    this.f.onCancel();
    super.onStop();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.TDialog
 * JD-Core Version:    0.6.2
 */