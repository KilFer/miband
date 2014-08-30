package com.xiaomi.channel.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeActivity extends Activity
{
  public static int RESULT_CANCEL = 0;
  public static int RESULT_FAIL = 0;
  public static int RESULT_SUCCESS = 0;
  private static final String a = "https://account.xiaomi.com/oauth2/authorize";
  private static final String b = "UTF-8";
  private WebView c;
  private WebSettings d;
  private String e;

  static
  {
    RESULT_FAIL = 1;
  }

  private static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
      try
      {
        Iterator localIterator = URLEncodedUtils.parse(new URI(paramString), "UTF-8").iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            return localBundle;
          NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
          if ((!TextUtils.isEmpty(localNameValuePair.getName())) && (!TextUtils.isEmpty(localNameValuePair.getValue())))
            localBundle.putString(localNameValuePair.getName(), localNameValuePair.getValue());
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        Log.e("openauth", localURISyntaxException.getMessage());
      }
    return localBundle;
  }

  private View a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    this.c = new WebView(this);
    localLinearLayout.addView(this.c, new ViewGroup.LayoutParams(-2, -2));
    return localLinearLayout;
  }

  private static String a(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return URLEncodedUtils.format(localArrayList, "UTF-8");
      String str1 = (String)localIterator.next();
      String str2 = paramBundle.getString(str1);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        localArrayList.add(new BasicNameValuePair(str1, str2));
    }
  }

  private void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(a(paramString));
    setResult(paramInt, localIntent);
    finish();
  }

  public void onBackPressed()
  {
    if (this.c.canGoBack())
    {
      this.c.goBack();
      return;
    }
    a(RESULT_CANCEL, null);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    this.c = new WebView(this);
    localLinearLayout.addView(this.c, new ViewGroup.LayoutParams(-2, -2));
    setContentView(localLinearLayout);
    this.d = this.c.getSettings();
    this.d.setJavaScriptEnabled(true);
    this.d.setSavePassword(false);
    this.d.setSaveFormData(false);
    Bundle localBundle = getIntent().getBundleExtra("url_param");
    this.e = ("https://account.xiaomi.com/oauth2/authorize?" + a(localBundle));
    this.c.loadUrl(this.e);
    a locala = new a(this);
    this.c.setWebViewClient(locala);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.AuthorizeActivity
 * JD-Core Version:    0.6.2
 */