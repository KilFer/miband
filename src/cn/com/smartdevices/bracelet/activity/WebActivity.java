package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class WebActivity extends Activity
  implements View.OnClickListener
{
  private static final String a = "WebActivity";
  private WebView b = null;
  private ProgressBar c;
  private int d = 1;
  private String e;
  private WebChromeClient f = new k(this);

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903082);
    this.b = ((WebView)findViewById(2131165218));
    this.b.getSettings().setJavaScriptEnabled(true);
    Intent localIntent = getIntent();
    this.d = localIntent.getIntExtra("web_type", 1);
    if (this.d == 0)
    {
      this.b.loadUrl("https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D");
      this.b.addJavascriptInterface(new WebActivity.LoginJsObject(this), "login");
    }
    while (true)
    {
      TextView localTextView = (TextView)findViewById(2131165230);
      localTextView.setOnClickListener(this);
      this.e = localIntent.getStringExtra("Label");
      if (!TextUtils.isEmpty(this.e))
        localTextView.setText(this.e);
      this.c = ((ProgressBar)findViewById(2131165393));
      this.b.setWebViewClient(new l(this));
      this.b.setWebChromeClient(this.f);
      return;
      if (this.d == 1)
      {
        this.b.loadUrl("https://hm.xiaomi.com/huami.health.login.json");
        this.b.addJavascriptInterface(new WebActivity.LoginJsObject(this), "login");
      }
      else if (this.d == 2)
      {
        String str = localIntent.getStringExtra("web_url");
        if (str.startsWith("file://"))
        {
          WebSettings localWebSettings = this.b.getSettings();
          localWebSettings.setUseWideViewPort(true);
          localWebSettings.setLoadWithOverviewMode(true);
        }
        this.b.loadUrl(str);
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    String str = "PageWeb";
    switch (this.d)
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      UmengAnalytics.endPage(str);
      UmengAnalytics.endSession(this);
      return;
      str = "PageWebRegister";
      continue;
      if (getString(2131493072).equals(this.e))
        str = "PageWebUserAgreement";
    }
  }

  protected void onResume()
  {
    super.onResume();
    String str = "PageWeb";
    switch (this.d)
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      UmengAnalytics.startPage(str);
      UmengAnalytics.startSession(this);
      return;
      str = "PageWebRegister";
      continue;
      if (getString(2131493072).equals(this.e))
        str = "PageWebUserAgreement";
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.WebActivity
 * JD-Core Version:    0.6.2
 */