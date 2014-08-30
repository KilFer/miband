package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXImageObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.tauth.Tencent;
import com.xiaomi.channel.sdk.MLImgObj;
import com.xiaomi.channel.sdk.MLShareApiFactory;
import com.xiaomi.channel.sdk.MLShareMessage;
import com.xiaomi.channel.sdk.MLShareReq;
import com.xiaomi.channel.sdk.VersionManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShareActivity extends Activity
  implements View.OnClickListener, IWXAPIEventHandler
{
  private static final String A = "share_qq_zone";
  public static final int MODE_SHARE_DYNAMIC = 0;
  public static final int MODE_SHARE_IMAGE = 1;
  public static final String PACKAGE_WEIXIN = "com.tencent.mm";
  private static final String w = "share_weixin";
  private static final String x = "share_pengyouquan";
  private static final String y = "share_weibo";
  private static final String z = "share_qq";
  private HashMap<String, ResolveInfo> B = new HashMap();
  private final String C;
  private final String D;
  private final String E;
  private final String F;
  private final String G;
  private final String H;
  private ShareData I = null;
  private TextView J;
  private Bitmap K = null;
  private String L = null;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView a = null;
  private View b = null;
  private TextView c = null;
  private ImageView d = null;
  private TextView e = null;
  private TextView f = null;
  private TextView g = null;
  private TextView h = null;
  private Button i = null;
  private Button j = null;
  private Button k = null;
  private Button l = null;
  private Button m = null;
  private Button n = null;
  private View o = null;
  private TextView p = null;
  private Tencent q = null;
  private IWXAPI r = null;
  private MLShareApiFactory s = null;
  private String t = "";
  private String u = "";
  private String v = "";

  private void a()
  {
    PersonInfo localPersonInfo = Keeper.readPersonInfo();
    Debug.i("WPJ", localPersonInfo.toString());
    this.d = ((ImageView)findViewById(2131165291));
    Utils.updateAvatarUI(localPersonInfo, this.d);
    this.e = ((TextView)findViewById(2131165292));
    this.e.setText(localPersonInfo.nickname);
    this.f = ((TextView)findViewById(2131165284));
    this.O = ((TextView)findViewById(2131165285));
    this.N = ((TextView)findViewById(2131165286));
    this.M = ((TextView)findViewById(2131165287));
    this.g = ((TextView)findViewById(2131165288));
    this.h = ((TextView)findViewById(2131165293));
    this.o = findViewById(2131165281);
    this.p = ((TextView)findViewById(2131165282));
    this.c = ((TextView)findViewById(2131165289));
    this.J = ((TextView)findViewById(2131165290));
  }

  private void a(ResolveInfo paramResolveInfo, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setComponent(new ComponentName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name));
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.SUBJECT", this.t);
      localIntent.putExtra("android.intent.extra.TEXT", paramString2);
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString1)));
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void a(ShareData paramShareData)
  {
    Debug.i("share", paramShareData.toString());
    this.c.setText(paramShareData.time);
    this.g.setText(paramShareData.contentUnit);
    this.o.setBackgroundColor(paramShareData.color);
    this.p.setText(paramShareData.title);
    this.h.setText(paramShareData.description);
    this.J.setText(paramShareData.time_tips);
    if (paramShareData.isSleepType())
      try
      {
        int i4 = Integer.valueOf(paramShareData.content).intValue();
        i1 = i4;
        int i2 = i1 % 60;
        int i3 = i1 / 60;
        this.f.setText(i3);
        this.N.setText(i2);
        this.O.setVisibility(0);
        this.N.setVisibility(0);
        this.M.setVisibility(0);
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          int i1 = 0;
        }
      }
    this.f.setText(paramShareData.content);
  }

  private void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("req_type", 5);
    localBundle.putString("title", this.t);
    localBundle.putString("summary", this.u);
    localBundle.putString("targetUrl", "http://www.baidu.com");
    localBundle.putString("appName", getString(2131492870));
    localBundle.putString("imageLocalUrl", paramString);
    null.shareToQQ(this, localBundle, new bE(this));
  }

  private void a(String paramString1, String paramString2)
  {
    ResolveInfo localResolveInfo;
    String str;
    if (this.B.containsKey(paramString1))
    {
      localResolveInfo = (ResolveInfo)this.B.get(paramString1);
      str = f();
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setComponent(new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.SUBJECT", this.t);
      localIntent.putExtra("android.intent.extra.TEXT", paramString2);
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      return;
      Toast.makeText(this, 2131493269, 0).show();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private boolean a(String paramString, boolean paramBoolean)
  {
    if (!this.r.isWXAppInstalled())
    {
      Toast.makeText(this, 2131493269, 0).show();
      return false;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.setImagePath(paramString);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 4;
    this.K = BitmapFactory.decodeFile(paramString, localOptions);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = localWXImageObject;
    localWXMediaMessage.title = this.t;
    localWXMediaMessage.description = this.u;
    if (this.K != null)
      localWXMediaMessage.setThumbImage(this.K);
    SendMessageToWX.Req localReq = new SendMessageToWX.Req();
    localReq.transaction = String.valueOf(System.currentTimeMillis());
    localReq.message = localWXMediaMessage;
    int i1 = 0;
    if (paramBoolean)
      i1 = 1;
    localReq.scene = i1;
    return this.r.sendReq(localReq);
  }

  private void b()
  {
    this.a = ((TextView)findViewById(2131165294));
    this.a.setOnClickListener(this);
    this.b = findViewById(2131165280);
    this.j = ((Button)findViewById(2131165296));
    this.j.setOnClickListener(this);
    this.l = ((Button)findViewById(2131165300));
    this.l.setOnClickListener(this);
    this.k = ((Button)findViewById(2131165299));
    this.k.setOnClickListener(this);
    this.m = ((Button)findViewById(2131165298));
    this.m.setOnClickListener(this);
    this.i = ((Button)findViewById(2131165295));
    this.i.setOnClickListener(this);
    this.n = ((Button)findViewById(2131165297));
    this.n.setOnClickListener(this);
  }

  private void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.t);
    localBundle.putString("summary", this.u);
    localBundle.putString("appName", getString(2131492870));
    localBundle.putString("targetUrl", "http://www.baidu.com");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localBundle.putStringArrayList("imageUrl", localArrayList);
    null.shareToQzone(this, localBundle, new bF(this));
  }

  private void c()
  {
    if (!this.r.isWXAppInstalled())
    {
      Drawable localDrawable5 = getResources().getDrawable(2130837663);
      this.j.setBackground(localDrawable5);
      Drawable localDrawable6 = getResources().getDrawable(2130837672);
      this.i.setBackground(localDrawable6);
    }
    if (!this.B.containsKey("share_qq"))
    {
      Drawable localDrawable4 = getResources().getDrawable(2130837665);
      this.l.setBackground(localDrawable4);
    }
    if (!this.B.containsKey("share_qq_zone"))
    {
      Drawable localDrawable3 = getResources().getDrawable(2130837667);
      this.k.setBackground(localDrawable3);
    }
    if (!this.B.containsKey("share_weibo"))
    {
      Drawable localDrawable2 = getResources().getDrawable(2130837670);
      this.m.setBackground(localDrawable2);
    }
    if (!VersionManager.isMiliaoVersionAvailable(this))
    {
      Drawable localDrawable1 = getResources().getDrawable(2130837661);
      this.n.setBackground(localDrawable1);
      this.n.setVisibility(8);
    }
  }

  private List<ResolveInfo> d()
  {
    Intent localIntent = new Intent("android.intent.action.SEND", null);
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setType("image/*");
    return getPackageManager().queryIntentActivities(localIntent, 0);
  }

  private void e()
  {
    Intent localIntent = new Intent("android.intent.action.SEND", null);
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setType("image/*");
    Iterator localIterator = getPackageManager().queryIntentActivities(localIntent, 0).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      String str1 = localResolveInfo.activityInfo.applicationInfo.packageName;
      String str2 = localResolveInfo.activityInfo.name;
      if (str1.equalsIgnoreCase("com.sina.weibo"))
        this.B.put("share_weibo", localResolveInfo);
      else if (str1.equalsIgnoreCase("com.tencent.mm"))
      {
        if (str2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareToTimeLineUI"))
          this.B.put("share_pengyouquan", localResolveInfo);
        else if (str2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareImgUI"))
          this.B.put("share_weixin", localResolveInfo);
      }
      else if (str1.equalsIgnoreCase("com.qzone"))
        this.B.put("share_qq_zone", localResolveInfo);
      else if ((str1.equalsIgnoreCase("com.tencent.mobileqq")) && (str2.equalsIgnoreCase("com.tencent.mobileqq.activity.JumpActivity")))
        this.B.put("share_qq", localResolveInfo);
    }
  }

  private String f()
  {
    Bitmap localBitmap = h();
    g();
    this.L = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
    Utils.saveBitmapToFile(this.L, localBitmap);
    return this.L;
  }

  private void g()
  {
    if (this.L != null)
    {
      File localFile1 = new File(this.L);
      if (localFile1.exists())
        localFile1.delete();
    }
    this.L = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp.jpg");
    File localFile2 = new File(this.L);
    if (localFile2.exists())
      localFile2.delete();
  }

  private Bitmap h()
  {
    this.b.buildDrawingCache();
    return this.b.getDrawingCache();
  }

  private void i()
  {
    int i1 = VersionManager.checkMiliaoVersion(this);
    if (i1 == -90001)
    {
      Toast.makeText(this, 2131493269, 0).show();
      return;
    }
    if (i1 == -90002)
    {
      Toast.makeText(this, 2131493319, 0).show();
      return;
    }
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    new FragmentShareToMiliaoSelect().show(localFragmentTransaction, null);
  }

  public void onClick(View paramView)
  {
    String str = "";
    switch (paramView.getId())
    {
    default:
    case 2131165294:
    case 2131165296:
    case 2131165300:
    case 2131165299:
    case 2131165298:
    case 2131165295:
      while (true)
      {
        if (!TextUtils.isEmpty(str))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("shareTo", str);
          UmengAnalytics.event(this, "EventShare", localHashMap);
        }
        return;
        finish();
        continue;
        a(f(), true);
        str = "EventShareToWeChatFriends";
        continue;
        a("share_qq", this.u);
        str = "EventShareToQQ";
        continue;
        a("share_qq_zone", this.u);
        str = "EventShareToQQZone";
        continue;
        a("share_weibo", this.v + this.u);
        str = "EventShareToWeibo";
        continue;
        a(f(), false);
        str = "EventShareToWeChat";
      }
    case 2131165297:
    }
    int i1 = VersionManager.checkMiliaoVersion(this);
    if (i1 == -90001)
      Toast.makeText(this, 2131493269, 0).show();
    while (true)
    {
      str = "EventShareToMiChat";
      break;
      if (i1 == -90002)
      {
        Toast.makeText(this, 2131493319, 0).show();
      }
      else
      {
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        new FragmentShareToMiliaoSelect().show(localFragmentTransaction, null);
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903054);
    this.r = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111");
    this.r.registerApp("wx28e2610e92fbe111");
    this.r.handleIntent(getIntent(), this);
    this.s = new MLShareApiFactory(this);
    this.I = ((ShareData)getIntent().getParcelableExtra("share_data"));
    if (this.I == null)
    {
      this.I = new ShareData();
      this.I.type = getIntent().getIntExtra("type", 7);
      this.I.title = getIntent().getStringExtra("title");
      this.I.content = getIntent().getStringExtra("content");
      this.I.contentUnit = getIntent().getStringExtra("unit");
      this.I.time = getIntent().getStringExtra("time");
      this.I.description = getIntent().getStringExtra("description");
      this.I.time_tips = getIntent().getStringExtra("time_tips");
    }
    Intent localIntent = new Intent("android.intent.action.SEND", null);
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setType("image/*");
    Iterator localIterator = getPackageManager().queryIntentActivities(localIntent, 0).iterator();
    ShareData localShareData;
    if (!localIterator.hasNext())
    {
      this.a = ((TextView)findViewById(2131165294));
      this.a.setOnClickListener(this);
      this.b = findViewById(2131165280);
      this.j = ((Button)findViewById(2131165296));
      this.j.setOnClickListener(this);
      this.l = ((Button)findViewById(2131165300));
      this.l.setOnClickListener(this);
      this.k = ((Button)findViewById(2131165299));
      this.k.setOnClickListener(this);
      this.m = ((Button)findViewById(2131165298));
      this.m.setOnClickListener(this);
      this.i = ((Button)findViewById(2131165295));
      this.i.setOnClickListener(this);
      this.n = ((Button)findViewById(2131165297));
      this.n.setOnClickListener(this);
      if (!this.r.isWXAppInstalled())
      {
        Drawable localDrawable5 = getResources().getDrawable(2130837663);
        this.j.setBackground(localDrawable5);
        Drawable localDrawable6 = getResources().getDrawable(2130837672);
        this.i.setBackground(localDrawable6);
      }
      if (!this.B.containsKey("share_qq"))
      {
        Drawable localDrawable4 = getResources().getDrawable(2130837665);
        this.l.setBackground(localDrawable4);
      }
      if (!this.B.containsKey("share_qq_zone"))
      {
        Drawable localDrawable3 = getResources().getDrawable(2130837667);
        this.k.setBackground(localDrawable3);
      }
      if (!this.B.containsKey("share_weibo"))
      {
        Drawable localDrawable2 = getResources().getDrawable(2130837670);
        this.m.setBackground(localDrawable2);
      }
      if (!VersionManager.isMiliaoVersionAvailable(this))
      {
        Drawable localDrawable1 = getResources().getDrawable(2130837661);
        this.n.setBackground(localDrawable1);
        this.n.setVisibility(8);
      }
      PersonInfo localPersonInfo = Keeper.readPersonInfo();
      Debug.i("WPJ", localPersonInfo.toString());
      this.d = ((ImageView)findViewById(2131165291));
      Utils.updateAvatarUI(localPersonInfo, this.d);
      this.e = ((TextView)findViewById(2131165292));
      this.e.setText(localPersonInfo.nickname);
      this.f = ((TextView)findViewById(2131165284));
      this.O = ((TextView)findViewById(2131165285));
      this.N = ((TextView)findViewById(2131165286));
      this.M = ((TextView)findViewById(2131165287));
      this.g = ((TextView)findViewById(2131165288));
      this.h = ((TextView)findViewById(2131165293));
      this.o = findViewById(2131165281);
      this.p = ((TextView)findViewById(2131165282));
      this.c = ((TextView)findViewById(2131165289));
      this.J = ((TextView)findViewById(2131165290));
      localShareData = this.I;
      Debug.i("share", localShareData.toString());
      this.c.setText(localShareData.time);
      this.g.setText(localShareData.contentUnit);
      this.o.setBackgroundColor(localShareData.color);
      this.p.setText(localShareData.title);
      this.h.setText(localShareData.description);
      this.J.setText(localShareData.time_tips);
      if (!localShareData.isSleepType())
        break label1296;
    }
    while (true)
    {
      try
      {
        int i4 = Integer.valueOf(localShareData.content).intValue();
        i1 = i4;
        int i2 = i1 % 60;
        int i3 = i1 / 60;
        this.f.setText(i3);
        this.N.setText(i2);
        this.O.setVisibility(0);
        this.N.setVisibility(0);
        this.M.setVisibility(0);
        this.t = getText(2131493006).toString();
        if ((this.I.type != 2) && (this.I.type != 3) && (this.I.type != 4))
          break label1311;
        this.u = getText(2131493311).toString();
        this.v = getText(2131493313).toString();
        return;
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        String str1 = localResolveInfo.activityInfo.applicationInfo.packageName;
        String str2 = localResolveInfo.activityInfo.name;
        if (str1.equalsIgnoreCase("com.sina.weibo"))
        {
          this.B.put("share_weibo", localResolveInfo);
          break;
        }
        if (str1.equalsIgnoreCase("com.tencent.mm"))
        {
          if (str2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareToTimeLineUI"))
          {
            this.B.put("share_pengyouquan", localResolveInfo);
            break;
          }
          if (!str2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareImgUI"))
            break;
          this.B.put("share_weixin", localResolveInfo);
          break;
        }
        if (str1.equalsIgnoreCase("com.qzone"))
        {
          this.B.put("share_qq_zone", localResolveInfo);
          break;
        }
        if ((!str1.equalsIgnoreCase("com.tencent.mobileqq")) || (!str2.equalsIgnoreCase("com.tencent.mobileqq.activity.JumpActivity")))
          break;
        this.B.put("share_qq", localResolveInfo);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        int i1 = 0;
        continue;
      }
      label1296: this.f.setText(localShareData.content);
      continue;
      label1311: this.u = getText(2131493312).toString();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.K != null)
    {
      if (!this.K.isRecycled())
        this.K.recycle();
      this.K = null;
    }
    g();
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageShare");
    UmengAnalytics.endSession(this);
  }

  public void onReq(BaseReq paramBaseReq)
  {
  }

  public void onResp(BaseResp paramBaseResp)
  {
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageShare");
    UmengAnalytics.startSession(this);
    String str = "";
    switch (this.I.type)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 7:
    case 3:
    case 6:
    case 4:
    case 9:
    case 5:
    case 8:
    }
    while (true)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", str);
      UmengAnalytics.event(this, "EventShare", localHashMap);
      return;
      str = "EventShareStepGoalSuccess";
      continue;
      str = "EventShareStepGoalFailed";
      continue;
      str = "EventShareSleep";
      continue;
      str = "EventShareWeeklySteps";
      continue;
      str = "EventShareWeeklySleep";
      continue;
      str = "EventShareMonthlySteps";
      continue;
      str = "EventShareMonthlySleep";
      continue;
      str = "EventShareDynamic";
      continue;
      str = "EventShareNewRecord";
      continue;
      str = "EventShareContinueDays";
    }
  }

  public boolean shareToMiliao(int paramInt)
  {
    Bitmap localBitmap = h();
    String str1 = getPackageName();
    String str2 = getApplicationInfo().loadLabel(getPackageManager()).toString();
    this.s.setPackageNameAndAppName(str1, str2);
    MLShareMessage localMLShareMessage = new MLShareMessage();
    localMLShareMessage.imgObj = new MLImgObj(localBitmap);
    localMLShareMessage.imgObj.mImgSize = 2097152L;
    MLShareReq localMLShareReq = new MLShareReq(100101, localMLShareMessage, paramInt);
    return this.s.sendReq(localMLShareReq, false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.ShareActivity
 * JD-Core Version:    0.6.2
 */