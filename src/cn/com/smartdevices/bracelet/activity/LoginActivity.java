package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity;
import cn.com.smartdevices.bracelet.webapi.ClientConstant;
import com.xiaomi.account.openauth.AuthorizeActivity;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class LoginActivity extends Activity
  implements View.OnClickListener
{
  private static final String e = "LoginActivity";
  private static final int f = 21308;
  private static final boolean g = false;
  private static final int h = 256;
  private static String l = "/user/profile";
  private static String m = "/user/phone";
  private static int n = 10001;
  private ValueAnimator A;
  private View B;
  private TextView C;
  private Handler D;
  Long a = ClientConstant.CLIENT_ID;
  String b;
  String c;
  String d;
  private Button i = null;
  private Button j = null;
  private LoginActivity k;
  private String o = "https://hm.xiaomi.com/huami.health.loginview.do";
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private LoginInfo x;
  private String y = "";
  private View z;

  private void a(boolean paramBoolean)
  {
    finish();
    Utils.hideProgressDialog(this);
    Intent localIntent = new Intent();
    if ((paramBoolean) && (Keeper.readPersonInfo().isValid()))
    {
      BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
      if ((localBraceletBtInfo != null) && (BluetoothAdapter.checkBluetoothAddress(localBraceletBtInfo.address)))
        localIntent.setClass(this.k, MainUIActivity.class);
      while (true)
      {
        startActivity(localIntent);
        return;
        localIntent.setClass(this.k, SearchSingleBraceletActivity.class);
      }
    }
    PersonInfo localPersonInfo;
    if (this.x != null)
    {
      localPersonInfo = Keeper.readPersonInfo();
      if ((this.x.miliaoIcon_320 == null) || (this.x.miliaoIcon_320.length() <= 0))
        break label147;
    }
    label147: for (localPersonInfo.avatarUrl = this.x.miliaoIcon_320; ; localPersonInfo.avatarUrl = this.x.miliaoIcon)
    {
      Keeper.keepPersonInfo(localPersonInfo);
      localIntent.setClass(this.k, PersonInfoSetGenderActivity.class);
      break;
    }
  }

  private void c()
  {
    WebView localWebView = (WebView)findViewById(2131165237);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebView.setLayerType(1, null);
    localWebView.setBackgroundColor(0);
    localWebView.loadUrl("file:///android_asset/startup.gif");
    new Handler().postDelayed(new b(this), 4800L);
    this.C.setEnabled(false);
    this.i.setEnabled(false);
    this.j.setEnabled(false);
  }

  private void d()
  {
    this.z = findViewById(2131165236);
    this.B = findViewById(2131165238);
    this.i = ((Button)findViewById(2131165241));
    this.i.setOnClickListener(this);
    this.j = ((Button)findViewById(2131165242));
    this.j.setOnClickListener(this);
    this.C = ((TextView)findViewById(2131165240));
    String str = getString(2131493072);
    this.C.setText(Html.fromHtml(getResources().getString(2131493118)));
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new d(this), 0, str.length(), 33);
    this.C.setHighlightColor(0);
    this.C.append(localSpannableString);
    this.C.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void e()
  {
    Debug.i("LoginActivity", "getTokenByXiaomiSDK");
    this.D.sendEmptyMessageDelayed(256, 300L);
    clearCache();
    Bundle localBundle = new Bundle();
    XiaomiOAuthorize.startGetAccessToken(this, this.a.longValue(), this.o, localBundle, n);
    Debug.i("LoginActivity", "End of getTokenByXiaomiSDK");
  }

  private void f()
  {
    new e(this).execute(new Void[0]);
  }

  private void g()
  {
    Toast.makeText(this, 2131492876, 0).show();
    Utils.hideProgressDialog(this);
  }

  private void h()
  {
    Utils.showProgressDialog(this, 2131492874);
  }

  private void i()
  {
    Utils.hideProgressDialog(this);
  }

  private void j()
  {
    new g(this).execute(new Void[0]);
  }

  private void k()
  {
    Debug.i("LoginActivity", "personSH = " + this.y);
    if ((this.y == null) || (this.y.equals("")))
      this.y = Utils.getPhoneNum(this);
    if ((this.y != null) && (!this.y.equals("")))
    {
      this.y = Utils.encodeTel(this.y);
      Debug.i("LoginActivity", "encode personSH = " + this.y);
      PersonInfo localPersonInfo = Keeper.readPersonInfo();
      HashMap localHashMap = new HashMap();
      try
      {
        localHashMap.put("person_sh", URLEncoder.encode(this.y, "utf-8"));
        Utils.updateProfile(localPersonInfo, localHashMap, new h(this));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        l();
        return;
      }
    }
    l();
  }

  private void l()
  {
    finish();
    Intent localIntent = new Intent();
    localIntent.setClass(this.k, SearchSingleBraceletActivity.class);
    startActivity(localIntent);
    Utils.hideProgressDialog(this);
  }

  public void clearCache()
  {
    this.q = "";
    this.r = "";
    this.b = "";
    this.c = "";
    this.s = "";
    this.t = "";
    this.d = "";
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Debug.i("LoginActivity", "onActivityResult requestCode =" + paramInt1 + ", data =" + paramIntent + "resultcode=" + paramInt2);
    if (paramIntent == null)
      return;
    Bundle localBundle = paramIntent.getExtras();
    if (n == paramInt1)
    {
      if (AuthorizeActivity.RESULT_SUCCESS == paramInt2)
      {
        Utils.showProgressDialog(this, 2131492874);
        this.d = localBundle.getString("access_token");
        this.s = localBundle.getString("expires_in");
        this.t = localBundle.getString("scope");
        this.q = localBundle.getString("state");
        this.r = localBundle.getString("token_type");
        this.b = localBundle.getString("mac_key");
        this.c = localBundle.getString("mac_algorithm");
        if (this.x == null)
          this.x = new LoginInfo();
        this.x.accessToken = this.d;
        this.x.macToken = this.b;
        this.x.expiresIn = this.s;
        Debug.i("LoginActivity", "accessToken=" + this.d + ",expiresIn=" + this.s + ",scope=" + this.t + ",state=" + this.q + ",tokenType=" + this.r + ",macKey=" + this.b + ",macAlogorithm=" + this.c);
        new e(this).execute(new Void[0]);
        return;
      }
      if (AuthorizeActivity.RESULT_FAIL == paramInt2)
      {
        localBundle.getString("error");
        localBundle.getString("error_description");
      }
    }
    do
    {
      Utils.hideProgressDialog(this);
      Toast.makeText(this.k, 2131492876, 1).show();
      return;
      Debug.i("LoginActivity", "result cancel=" + AuthorizeActivity.RESULT_CANCEL);
      Utils.hideProgressDialog(this);
      return;
      if (1 != paramInt1)
        break;
    }
    while (paramInt2 != 3);
    a(localBundle.getBoolean("miliao_has_binded"));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165241:
      if (!Utils.isNetworkConnected(this))
      {
        Toast.makeText(this, 2131492902, 1).show();
        return;
      }
      Debug.i("LoginActivity", "getTokenByXiaomiSDK");
      this.D.sendEmptyMessageDelayed(256, 300L);
      clearCache();
      Bundle localBundle = new Bundle();
      XiaomiOAuthorize.startGetAccessToken(this, this.a.longValue(), this.o, localBundle, n);
      Debug.i("LoginActivity", "End of getTokenByXiaomiSDK");
      return;
    case 2131165242:
    }
    if (!Utils.isNetworkConnected(this))
    {
      Toast.makeText(this, 2131492902, 1).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("web_type", 0);
    localIntent.setClass(this, WebActivity.class);
    startActivityForResult(localIntent, 1);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    this.k = this;
    this.D = new a(this);
    this.z = findViewById(2131165236);
    this.B = findViewById(2131165238);
    this.i = ((Button)findViewById(2131165241));
    this.i.setOnClickListener(this);
    this.j = ((Button)findViewById(2131165242));
    this.j.setOnClickListener(this);
    this.C = ((TextView)findViewById(2131165240));
    String str = getString(2131493072);
    this.C.setText(Html.fromHtml(getResources().getString(2131493118)));
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new d(this), 0, str.length(), 33);
    this.C.setHighlightColor(0);
    this.C.append(localSpannableString);
    this.C.setMovementMethod(LinkMovementMethod.getInstance());
    WebView localWebView = (WebView)findViewById(2131165237);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebView.setLayerType(1, null);
    localWebView.setBackgroundColor(0);
    localWebView.loadUrl("file:///android_asset/startup.gif");
    new Handler().postDelayed(new b(this), 4800L);
    this.C.setEnabled(false);
    this.i.setEnabled(false);
    this.j.setEnabled(false);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Debug.i("LoginActivity", "onDestroy");
  }

  protected void onPause()
  {
    super.onPause();
    Debug.i("LoginActivity", "onPause");
    this.D.removeMessages(256);
    UmengAnalytics.endPage("PageLogin");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageLogin");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.LoginActivity
 * JD-Core Version:    0.6.2
 */