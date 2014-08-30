package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class PersonInfoFinishedActivity extends Activity
{
  private static Handler a = new Handler();

  private void a()
  {
    WebView localWebView = (WebView)findViewById(2131165539);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebView.setLayerType(1, null);
    localWebView.loadUrl("file:///android_asset/set_finish.gif");
    a.postDelayed(new j(this, localWebView), 1000L);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903120);
    ((Button)findViewById(2131165541)).setOnClickListener(new i(this));
    WebView localWebView = (WebView)findViewById(2131165539);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebView.setLayerType(1, null);
    localWebView.loadUrl("file:///android_asset/set_finish.gif");
    a.postDelayed(new j(this, localWebView), 1000L);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideFinish");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideFinish");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.PersonInfoFinishedActivity
 * JD-Core Version:    0.6.2
 */