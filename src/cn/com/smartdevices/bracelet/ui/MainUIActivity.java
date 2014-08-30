package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.DataChart;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.lua.LuaListAdapter;
import cn.com.smartdevices.bracelet.lua.LuaListAdapterFake;
import cn.com.smartdevices.bracelet.lua.MyListView;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.upgrade.UpgradeService;
import cn.com.smartdevices.bracelet.upgrade.UpgradeUtil;
import cn.com.smartdevices.bracelet.upgrade.WebServiceClient;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.event.EventBus;
import java.util.Locale;

public class MainUIActivity extends BaseSCActivity
  implements View.OnClickListener
{
  public static final int MSG_NEW_PUSH_MESSAGE = 518;
  public static final int MSG_NEW_PUSH_NEW_USERINFO = 519;
  public static final int REQ_SHARE = 32769;
  private static final String b = "MainUIActivity";
  private static final boolean c = false;
  private static final int d = 2;
  private static final int e = 0;
  private static final int h = 30000;
  private static final int i = 272;
  private static final int j = 273;
  private static final int k = 274;
  private MyListView A = null;
  private View B = null;
  private LuaEvent C = null;
  private BaseSCActivity.ConnStatus D = new BaseSCActivity.ConnStatus();
  private Boolean E = Boolean.valueOf(false);
  private final float F;
  private final float G;
  private int H = 300;
  private int I = 1150;
  private int J = 100;
  private int K = 200;
  private int L = 400;
  private int M = 100;
  private int N = 378;
  private int O = 33;
  private int P = 66;
  private int Q = 133;
  private boolean R = false;
  private boolean S = false;
  private boolean T = false;
  private View U = null;
  private boolean V = false;
  private boolean W = false;
  private Boolean X = Boolean.valueOf(false);
  private Boolean Y = Boolean.valueOf(false);
  private ValueAnimator Z = null;
  DynamicFragment a = null;
  private float aa = 1.0F;
  private SlidingUpPanelLayout.PanelSlideListener ab = new at(this);
  private boolean ac = false;
  private boolean ad = false;
  private ValueAnimator ae = null;
  private boolean f;
  private BroadcastReceiver g;
  private View l;
  private View m;
  public Handler mHandler;
  private TextView n;
  private SlidingUpPanelLayout o;
  private LuaListAdapter p = null;
  private TextView q = null;
  private ImageView r = null;
  private ProgressBar s = null;
  private View t = null;
  private int u = -1;
  private TextView v = null;
  private TextView w = null;
  private String x;
  private View y = null;
  private View z = null;

  private void a()
  {
    findViewById(2131165584).getViewTreeObserver().addOnPreDrawListener(new aB(this));
  }

  private void a(String paramString1, String paramString2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getApplicationContext());
    localBuilder.setTitle(2131492931);
    localBuilder.setMessage(paramString1);
    localBuilder.setNegativeButton(17039360, new aE(this));
    localBuilder.setPositiveButton(17039370, new aF(this, paramString2));
    AlertDialog localAlertDialog = localBuilder.create();
    localAlertDialog.getWindow().setType(2003);
    localAlertDialog.show();
  }

  private void a(boolean paramBoolean)
  {
    DaoManager.getInstance().getLuaListDao().deleteAll();
    DaoManager.getInstance().getLuaZipFileDao().deleteAll();
    startAnalysisThreadForLuaEvent(true);
    this.C.setDefaultMsgs(Boolean.valueOf(true));
    c(true);
  }

  private void b()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    this.a = ((DynamicFragment)Fragment.instantiate(this, DynamicFragment.class.getName()));
    localFragmentTransaction.add(2131165614, this.a, "DynamicFragment");
    localFragmentTransaction.commit();
    localFragmentManager.executePendingTransactions();
    this.C = LuaEvent.getInstance(this);
    this.o = ((SlidingUpPanelLayout)findViewById(2131165608));
    this.y = findViewById(2131165609);
    this.z = findViewById(2131165584);
    this.t = findViewById(2131165610);
    this.q = ((TextView)findViewById(2131165616));
    this.r = ((ImageView)findViewById(2131165524));
    this.s = ((ProgressBar)findViewById(2131165611));
    this.s.setIndeterminate(true);
    this.v = ((TextView)findViewById(2131165612));
    this.w = ((TextView)findViewById(2131165613));
    this.o.setOverlayed(true);
    this.o.setEnableDragViewTouchEvents(true);
    this.B = findViewById(2131165617);
    this.p = new LuaListAdapter(this, null);
    this.A = ((MyListView)findViewById(2131165615));
    this.A.setAdapter(this.p);
    this.A.setParentPanelLayout(this.o);
    this.o.setListAdapter(this.p);
    this.o.setPanelSlideListener(this.ab);
    LuaListAdapterFake localLuaListAdapterFake = new LuaListAdapterFake(this);
    localLuaListAdapterFake.add("我是第一条", "我是副标题1");
    localLuaListAdapterFake.add("我是第2条", "我是副标题2");
    localLuaListAdapterFake.add("我是第3条", "我是副标题3");
    ((ListView)findViewById(2131165618)).setAdapter(localLuaListAdapterFake);
    localLuaListAdapterFake.notifyDataSetChanged();
    if (Keeper.readIsPlayEnterAnimation().booleanValue())
    {
      this.z.setTranslationY(800.0F);
      Handler localHandler = new Handler();
      localHandler.postDelayed(new ax(this, localHandler), 1000L);
    }
    while (true)
    {
      this.l = findViewById(2131165383);
      this.l.setOnClickListener(this);
      this.m = findViewById(2131165385);
      this.m.setOnClickListener(this);
      this.n = ((TextView)findViewById(2131165384));
      this.U = findViewById(2131165608);
      return;
      this.y.setBackgroundColor(-1);
      this.t.setX(this.H);
      this.t.setY(this.I);
      this.t.setVisibility(0);
      if (this.a != null)
        this.a.setVPHight();
      a();
    }
  }

  private void b(boolean paramBoolean)
  {
    this.R = true;
  }

  private void c()
  {
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      String str = localPackageInfo.versionName;
      int i1 = localPackageInfo.versionCode;
      Keeper.keepApkVersion(i1 + ":" + str);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
  }

  private void c(boolean paramBoolean)
  {
    this.p.refreshList();
    int i1 = this.p.getNewItemCount();
    Debug.i("MainUIActivity", "refreshListAndDetectBlank forceRefresh= " + paramBoolean);
    if ((!paramBoolean) && (i1 > 0) && (Utils.isBinded()))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      setTipMsg(getString(2131493290, arrayOfObject), 2);
      Debug.i("MainUIActivity", "refreshListAndDetectBlank settips: " + i1);
    }
    if (this.p.getListSize() == 0)
    {
      this.B.setVisibility(0);
      return;
    }
    this.B.setVisibility(8);
  }

  private void d()
  {
    this.mHandler = new aC(this);
  }

  private void e()
  {
    this.g = new aD(this);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    localIntentFilter.addAction("ACTION_BATTERY_LOW");
    registerReceiver(this.g, localIntentFilter);
    EventBus.getDefault().register(this);
  }

  private boolean f()
  {
    Debug.i("MainUIActivity", "setLocale : " + Locale.getDefault().toString());
    this.C.setLocale(Locale.getDefault().toString());
    DaoManager.getInstance().getLuaListDao().deleteAll();
    DaoManager.getInstance().getLuaZipFileDao().deleteAll();
    startAnalysisThreadForLuaEvent(true);
    this.C.setDefaultMsgs(Boolean.valueOf(true));
    c(true);
    return true;
  }

  private void g()
  {
    if (UpgradeUtil.isNeedCheck(this))
    {
      WebServiceClient.getInstance(this);
      UpgradeService.start(this, 1);
    }
  }

  private boolean h()
  {
    boolean bool = true;
    if (!this.R)
      bool = false;
    while (this.S)
      return bool;
    this.S = bool;
    this.mHandler.sendEmptyMessageDelayed(272, 30000L);
    return bool;
  }

  private boolean i()
  {
    if (!this.R)
      return false;
    this.S = false;
    this.T = false;
    this.mHandler.removeMessages(272);
    return true;
  }

  private void j()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addListener(new aG(this));
    localValueAnimator.addUpdateListener(new aH(this));
    localValueAnimator.start();
  }

  private void k()
  {
    if (this.X.booleanValue())
      return;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(new aI(this));
    localValueAnimator.addUpdateListener(new au(this));
    localValueAnimator.start();
  }

  private void l()
  {
    c(false);
  }

  private void m()
  {
    if ((this.Y.booleanValue()) && (this.Z != null))
      this.Z.end();
    float f1 = Utils.convertDpToPixel(36.0F, this);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2900.0F });
    this.Z = localValueAnimator;
    localValueAnimator.setDuration(2900L);
    localValueAnimator.addListener(new av(this, f1));
    localValueAnimator.addUpdateListener(new aw(this, f1));
    localValueAnimator.start();
  }

  private void n()
  {
    this.o = ((SlidingUpPanelLayout)findViewById(2131165608));
    this.y = findViewById(2131165609);
    this.z = findViewById(2131165584);
    this.t = findViewById(2131165610);
    this.q = ((TextView)findViewById(2131165616));
    this.r = ((ImageView)findViewById(2131165524));
    this.s = ((ProgressBar)findViewById(2131165611));
    this.s.setIndeterminate(true);
    this.v = ((TextView)findViewById(2131165612));
    this.w = ((TextView)findViewById(2131165613));
    this.o.setOverlayed(true);
    this.o.setEnableDragViewTouchEvents(true);
    this.B = findViewById(2131165617);
    this.p = new LuaListAdapter(this, null);
    this.A = ((MyListView)findViewById(2131165615));
    this.A.setAdapter(this.p);
    this.A.setParentPanelLayout(this.o);
    this.o.setListAdapter(this.p);
    this.o.setPanelSlideListener(this.ab);
    LuaListAdapterFake localLuaListAdapterFake = new LuaListAdapterFake(this);
    localLuaListAdapterFake.add("我是第一条", "我是副标题1");
    localLuaListAdapterFake.add("我是第2条", "我是副标题2");
    localLuaListAdapterFake.add("我是第3条", "我是副标题3");
    ((ListView)findViewById(2131165618)).setAdapter(localLuaListAdapterFake);
    localLuaListAdapterFake.notifyDataSetChanged();
    if (Keeper.readIsPlayEnterAnimation().booleanValue())
    {
      this.z.setTranslationY(800.0F);
      Handler localHandler = new Handler();
      localHandler.postDelayed(new ax(this, localHandler), 1000L);
      return;
    }
    this.y.setBackgroundColor(-1);
    this.t.setX(this.H);
    this.t.setY(this.I);
    this.t.setVisibility(0);
    if (this.a != null)
      this.a.setVPHight();
    a();
  }

  private void o()
  {
    LuaListAdapterFake localLuaListAdapterFake = new LuaListAdapterFake(this);
    localLuaListAdapterFake.add("我是第一条", "我是副标题1");
    localLuaListAdapterFake.add("我是第2条", "我是副标题2");
    localLuaListAdapterFake.add("我是第3条", "我是副标题3");
    ((ListView)findViewById(2131165618)).setAdapter(localLuaListAdapterFake);
    localLuaListAdapterFake.notifyDataSetChanged();
  }

  private void p()
  {
    this.l = findViewById(2131165383);
    this.l.setOnClickListener(this);
    this.m = findViewById(2131165385);
    this.m.setOnClickListener(this);
    this.n = ((TextView)findViewById(2131165384));
  }

  private void q()
  {
    SportDay localSportDay = DataManager.getInstance().getCurDay();
    DataManager.getInstance().get(localSportDay);
    startActivity(DataChart.getInstance().executeLineChart(this, DataManager.getInstance().get(localSportDay)));
  }

  private void r()
  {
    Intent localIntent = new Intent(this, StatisticActivity.class);
    localIntent.putExtra("Mode", ChartData.getDynamicData().getCurrentMode());
    startActivity(localIntent);
  }

  private void s()
  {
    if (this.ad)
      return;
    this.ad = true;
    this.U.buildDrawingCache();
    MainMenuFragment localMainMenuFragment = new MainMenuFragment();
    localMainMenuFragment.setBackground(this.U.getDrawingCache());
    localMainMenuFragment.setListener(new ay(this));
    localMainMenuFragment.show(getFragmentManager().beginTransaction(), null);
  }

  private void t()
  {
    this.ae = ValueAnimator.ofFloat(new float[] { 0.0F, 800.0F });
    this.ae.setDuration(500L);
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    this.ae.setInterpolator(localDecelerateInterpolator);
    this.ae.addListener(new az(this));
    this.ae.addUpdateListener(new aA(this));
    this.ae.start();
  }

  public void listAnim()
  {
    LayoutAnimationController localLayoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130968584));
    localLayoutAnimationController.setOrder(0);
    localLayoutAnimationController.setInterpolator(new DecelerateInterpolator());
    localLayoutAnimationController.setDelay(0.5F);
    this.A.setLayoutAnimation(localLayoutAnimationController);
  }

  public void onBackPressed()
  {
    super.onBackPressed();
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    if (paramConnStatus == null)
      return;
    int i1 = this.D.a;
    Debug.i("MainUIActivity", "onBleStatusChanged:" + paramConnStatus);
    this.D = paramConnStatus;
    int i2 = paramConnStatus.a;
    if (this.q == null)
    {
      Debug.i("MainUIActivity", "onBleStatusChanged: mDynamicTip is null" + paramConnStatus);
      return;
    }
    if (i2 == 1)
    {
      i();
      this.C.setDefaultMsgs();
      restoreDownMsgList();
      if (this.a != null)
        this.a.setBindMode();
    }
    while (true)
    {
      Debug.i("MainUIActivity", "out onBleStatusChanged:" + paramConnStatus);
      return;
      if (i2 == 2)
      {
        pullDownMsgList(getString(2131493284), getString(2131493285));
        if (this.a != null)
          this.a.setConnectingAlpha(Boolean.valueOf(true));
      }
      else if (i2 == 3)
      {
        h();
        if (!this.T)
        {
          pullDownMsgList(getString(2131493284), getString(2131493285));
          if (this.a != null)
            this.a.setConnectingAlpha(Boolean.valueOf(true));
        }
      }
      else if (i2 == 4)
      {
        pullDownMsgList(getString(2131493280), getString(2131493281), 2, 0.0F);
      }
      else if (i2 == 5)
      {
        h();
        if (!this.T)
        {
          pullDownMsgList(getString(2131493284), getString(2131493285));
          if (this.a != null)
            this.a.setConnectingAlpha(Boolean.valueOf(true));
        }
      }
      else if (i2 == 6)
      {
        h();
        if (!this.T)
        {
          pullDownMsgList(getString(2131493284), getString(2131493285));
          if (this.a != null)
            this.a.setConnectingAlpha(Boolean.valueOf(true));
        }
      }
      else if (i2 == 7)
      {
        h();
        if (!this.T)
        {
          pullDownMsgList(getString(2131493284), getString(2131493285));
          if (this.a != null)
            this.a.setConnectingAlpha(Boolean.valueOf(true));
        }
      }
      else if (i2 == 8)
      {
        i();
        this.q.setVisibility(8);
        if ((this.a != null) && (i1 != i2))
          this.a.setConnectingAlpha(Boolean.valueOf(false));
        this.mHandler.sendEmptyMessageDelayed(274, 1000L);
      }
      else if (i2 == 9)
      {
        this.mHandler.removeMessages(274);
        int i4 = Math.max(0, Math.min(100, ((Integer)paramConnStatus.b).intValue()));
        String str2 = getString(2131493286);
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i4);
        pullDownMsgList(str2, getString(2131493287, arrayOfObject2));
      }
      else if (i2 == 10)
      {
        int i3 = Math.max(0, Math.min(100, ((Integer)paramConnStatus.b).intValue()));
        String str1 = getString(2131493286);
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(i3);
        pullDownMsgList(str1, getString(2131493287, arrayOfObject1));
      }
      else if (i2 == 11)
      {
        if (((Boolean)paramConnStatus.b).booleanValue())
          restoreDownMsgList();
        else
          pullDownMsgList(getString(2131493291), Utils.getSyncTime(this), 3, 0.0F);
      }
    }
  }

  public void onBtOnOff(EventBtOnOff paramEventBtOnOff)
  {
    Debug.i("MainUIActivity", "onBtOnOff:" + paramEventBtOnOff.type);
    if (paramEventBtOnOff.type == 1)
    {
      this.W = true;
      pullDownMsgList(getString(2131493280), getString(2131493281), 2, 0.0F);
    }
    while ((paramEventBtOnOff.type != 0) || (!this.W))
      return;
    this.W = false;
    this.mHandler.sendEmptyMessage(273);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165384:
    default:
    case 2131165383:
    case 2131165385:
    }
    do
    {
      return;
      Intent localIntent = new Intent(this, StatisticActivity.class);
      localIntent.putExtra("Mode", ChartData.getDynamicData().getCurrentMode());
      startActivity(localIntent);
      return;
    }
    while (this.ad);
    this.ad = true;
    this.U.buildDrawingCache();
    MainMenuFragment localMainMenuFragment = new MainMenuFragment();
    localMainMenuFragment.setBackground(this.U.getDrawingCache());
    localMainMenuFragment.setListener(new ay(this));
    localMainMenuFragment.show(getFragmentManager().beginTransaction(), null);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Debug.i("MainUIActivity", "onConfigurationChanged");
    f();
    Keeper.keepLocaleStr();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903130);
    getWindow().setWindowAnimations(2131623943);
    getString(2131493282);
    this.mHandler = new aC(this);
    this.g = new aD(this);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
    localIntentFilter.addAction("ACTION_BATTERY_LOW");
    registerReceiver(this.g, localIntentFilter);
    EventBus.getDefault().register(this);
    try
    {
      PackageInfo localPackageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      String str = localPackageInfo.versionName;
      int i1 = localPackageInfo.versionCode;
      Keeper.keepApkVersion(i1 + ":" + str);
      this.H = ((int)Utils.convertDpToPixel(this.M, this));
      this.I = ((int)Utils.convertDpToPixel(this.N, this));
      this.J = ((int)Utils.convertDpToPixel(this.O, this));
      this.K = ((int)Utils.convertDpToPixel(this.P, this));
      this.L = ((int)Utils.convertDpToPixel(this.Q, this));
      this.R = true;
      FragmentManager localFragmentManager = getFragmentManager();
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      this.a = ((DynamicFragment)Fragment.instantiate(this, DynamicFragment.class.getName()));
      localFragmentTransaction.add(2131165614, this.a, "DynamicFragment");
      localFragmentTransaction.commit();
      localFragmentManager.executePendingTransactions();
      this.C = LuaEvent.getInstance(this);
      this.o = ((SlidingUpPanelLayout)findViewById(2131165608));
      this.y = findViewById(2131165609);
      this.z = findViewById(2131165584);
      this.t = findViewById(2131165610);
      this.q = ((TextView)findViewById(2131165616));
      this.r = ((ImageView)findViewById(2131165524));
      this.s = ((ProgressBar)findViewById(2131165611));
      this.s.setIndeterminate(true);
      this.v = ((TextView)findViewById(2131165612));
      this.w = ((TextView)findViewById(2131165613));
      this.o.setOverlayed(true);
      this.o.setEnableDragViewTouchEvents(true);
      this.B = findViewById(2131165617);
      this.p = new LuaListAdapter(this, null);
      this.A = ((MyListView)findViewById(2131165615));
      this.A.setAdapter(this.p);
      this.A.setParentPanelLayout(this.o);
      this.o.setListAdapter(this.p);
      this.o.setPanelSlideListener(this.ab);
      LuaListAdapterFake localLuaListAdapterFake = new LuaListAdapterFake(this);
      localLuaListAdapterFake.add("我是第一条", "我是副标题1");
      localLuaListAdapterFake.add("我是第2条", "我是副标题2");
      localLuaListAdapterFake.add("我是第3条", "我是副标题3");
      ((ListView)findViewById(2131165618)).setAdapter(localLuaListAdapterFake);
      localLuaListAdapterFake.notifyDataSetChanged();
      if (Keeper.readIsPlayEnterAnimation().booleanValue())
      {
        this.z.setTranslationY(800.0F);
        Handler localHandler = new Handler();
        localHandler.postDelayed(new ax(this, localHandler), 1000L);
        this.l = findViewById(2131165383);
        this.l.setOnClickListener(this);
        this.m = findViewById(2131165385);
        this.m.setOnClickListener(this);
        this.n = ((TextView)findViewById(2131165384));
        this.U = findViewById(2131165608);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        this.y.setBackgroundColor(-1);
        this.t.setX(this.H);
        this.t.setY(this.I);
        this.t.setVisibility(0);
        if (this.a != null)
          this.a.setVPHight();
        a();
      }
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
    if (this.g != null)
    {
      unregisterReceiver(this.g);
      this.g = null;
    }
  }

  public void onEvent(EventApkupgrade paramEventApkupgrade)
  {
    Debug.i("MainUIActivity", "onEvent, + changelog=" + paramEventApkupgrade.getChangeLog() + ", force=" + paramEventApkupgrade.isForceCheck() + " HasWindowfocus=" + hasWindowFocus());
    if (this.f)
      Utils.checkXiaomiApkUpdate(this, paramEventApkupgrade.isForceCheck(), paramEventApkupgrade.getChangeLog());
  }

  public void onEvent(EventDynamicDetailSleepUserModified paramEventDynamicDetailSleepUserModified)
  {
    generateSleepReport();
  }

  protected void onHideApp()
  {
    super.onHideApp();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Debug.i("MainUIActivity", "onNewIntent");
    if (paramIntent.getExtras() == null);
    while (paramIntent.getIntExtra("notification_enter", 0) != 1)
      return;
    startActivity(new Intent(this, SettingActivity.class));
  }

  protected void onPause()
  {
    super.onPause();
    this.f = false;
    AnalyticsTrackerManager.endSession(this);
    AnalyticsTrackerManager.endTimedEvent(new String[] { "EventDynamicPage" });
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    this.f = true;
    if ((!Keeper.readLocaleStr().equals("")) && (!Keeper.readLocaleStr().equals(Locale.getDefault().toString())))
    {
      f();
      Keeper.keepLocaleStr();
    }
    while (true)
    {
      Utils.checkApkUpgrade(this, false);
      Debug.i("MainUIActivity", "onResume");
      long l1 = Keeper.readPersonInfo().uid;
      AnalyticsTrackerManager.startSession(this, l1);
      AnalyticsTrackerManager.trackActive(l1);
      UmengAnalytics.startSession(this);
      if (!this.W)
        this.mHandler.sendEmptyMessage(273);
      return;
      this.C.setDefaultMsgs();
      c(false);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onStop()
  {
    super.onStop();
    getWindow().setWindowAnimations(16973825);
  }

  public void pullDownMsgList()
  {
    if (this.o == null)
    {
      Debug.e("chenee", "not init layout");
      return;
    }
    this.E = Boolean.valueOf(true);
    this.t.setScaleX(1.0F);
    this.t.setScaleY(1.0F);
    this.t.setAlpha(1.0F);
    this.t.setTranslationY(this.I);
    this.q.setVisibility(8);
    this.o.smoothSlideTo(1.27F, 0);
  }

  public void pullDownMsgList(String paramString1, String paramString2)
  {
    pullDownMsgList(paramString1, paramString2, 1, 0.0F);
  }

  public void pullDownMsgList(String paramString1, String paramString2, int paramInt, float paramFloat)
  {
    this.u = paramInt;
    this.v.setText(paramString1);
    this.w.setText(paramString2);
    if (paramInt == 0)
    {
      float f1 = (paramFloat - 1.0F) / 0.5F;
      float f2 = this.I - this.J + f1 * this.K;
      this.t.setTranslationY(f2);
      if (paramFloat < 1.5F)
      {
        this.t.setScaleX(1.0F);
        this.t.setScaleY(1.0F);
        this.t.setAlpha(1.0F);
      }
      this.r.setVisibility(0);
      this.r.setImageResource(2130837654);
      this.s.setVisibility(8);
      this.v.setTextColor(-11184811);
      this.w.setTextColor(-6316129);
      return;
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      this.E = Boolean.valueOf(false);
      this.v.setTextColor(-2143214);
      this.w.setTextColor(-1400947);
      this.r.setVisibility(0);
      this.r.setImageResource(2130837655);
      this.s.setVisibility(8);
      pullDownMsgList();
      return;
    }
    this.v.setTextColor(-11184811);
    this.w.setTextColor(-6316129);
    pullDownMsgList();
    this.r.setVisibility(4);
    this.s.setVisibility(0);
  }

  public void restoreDownMsgList()
  {
    if (!this.E.booleanValue())
    {
      Debug.i("chenee", "not pulled down yet");
      return;
    }
    if (this.o == null)
    {
      Debug.e("chenee", "not init layout");
      return;
    }
    this.E = Boolean.valueOf(false);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addListener(new aG(this));
    localValueAnimator.addUpdateListener(new aH(this));
    localValueAnimator.start();
    c(false);
  }

  public void setTipMsg(String paramString, int paramInt)
  {
    if (paramInt < 0)
      return;
    this.q.setText(paramString);
    if (paramInt > 0)
    {
      if ((this.Y.booleanValue()) && (this.Z != null))
        this.Z.end();
      float f1 = Utils.convertDpToPixel(36.0F, this);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 2900.0F });
      this.Z = localValueAnimator;
      localValueAnimator.setDuration(2900L);
      localValueAnimator.addListener(new av(this, f1));
      localValueAnimator.addUpdateListener(new aw(this, f1));
      localValueAnimator.start();
      this.q.setOnClickListener(null);
      this.q.setBackgroundColor(-530995438);
      return;
    }
    this.q.setVisibility(0);
    this.q.setOnClickListener(null);
    this.q.setBackgroundColor(-522095308);
  }

  protected void updateDynamicList(boolean paramBoolean)
  {
    Debug.i("chenee", "updateUI.............");
    c(paramBoolean);
  }

  public void updateTitle(int paramInt)
  {
    this.n.setText(paramInt);
  }

  public void updateTitle(String paramString)
  {
    this.n.setText(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.MainUIActivity
 * JD-Core Version:    0.6.2
 */