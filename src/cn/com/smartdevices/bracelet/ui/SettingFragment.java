package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.BleTask.BleGetBatteryInfoTask;
import cn.com.smartdevices.bracelet.BleTask.BleNotifyTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder;
import cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import de.greenrobot.event.EventBus;
import java.util.Calendar;

public class SettingFragment extends Fragment
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final long BAT_ANIM_DURATION = 500L;
  public static final String REF_MILI_NAME = "REF_MILI_NAME";
  private static final String a = "SettingFragment";
  private static final int b = 256;
  private static final int c = 100;
  private static final long d = 10L;
  private static final int e = 76;
  private static final boolean f = true;
  private float A;
  private Switch B = null;
  private View C;
  private boolean D;
  private int E;
  private TextView F;
  private SlidingUpPanelLayout.PanelSlideListener G = new bv(this);
  private IMiLiProfile.BatteryInfo g = null;
  private PersonInfo h;
  private TextView i;
  private TextView j;
  private TextView k = null;
  private TextView l;
  private TextView m;
  private View n;
  private View o;
  private LinePieChartView p;
  private Animator q;
  private TextView r;
  private TextView s;
  private View t;
  private ImageView u;
  private String v;
  private AsyncTask<String, String, String> w;
  private TextView x;
  private SlidingUpPanelLayout y;
  private RotateAnimation z;

  private static long a(int paramInt)
  {
    return 100 - paramInt;
  }

  private void a()
  {
    if (Utils.isBraceletConnected())
    {
      g();
      MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      if (localMiLiProfile != null)
      {
        IMiLiProfile.BatteryInfo localBatteryInfo = localMiLiProfile.getCachedBatteryInfo();
        if (localBatteryInfo != null)
        {
          this.g = localBatteryInfo;
          Debug.i("SettingFragment", "getCachedBatteryInfo = " + this.g);
        }
      }
      this.g = this.g;
      if (this.g != null)
        b(true);
      for (boolean bool = false; ; bool = true)
      {
        a(bool);
        return;
      }
    }
    h();
  }

  private void a(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
      return;
    float f1 = 90.0F - paramFloat * 90.0F;
    this.p.setRotationX(f1);
    this.p.setAlpha(paramFloat);
    float f2 = -this.A * (1.0F - paramFloat);
    Debug.i("SettingFragment", "centerYOffset=" + f2);
    this.C.setTranslationY(f2);
    this.m.setAlpha(paramFloat);
  }

  private void a(View paramView)
  {
    this.y = ((SlidingUpPanelLayout)paramView.findViewById(2131165583));
    this.y.setOverlayed(true);
    this.y.setEnableDragViewTouchEvents(true);
    this.y.setPanelSlideListener(this.G);
    paramView.findViewById(2131165230).setOnClickListener(this);
    this.j = ((TextView)paramView.findViewById(2131165605));
    this.i = ((TextView)paramView.findViewById(2131165589));
    this.k = ((TextView)paramView.findViewById(2131165603));
    this.x = ((TextView)paramView.findViewById(2131165607));
    paramView.findViewById(2131165586).setOnClickListener(this);
    paramView.findViewById(2131165586).setOnLongClickListener(this);
    paramView.findViewById(2131165588).setOnClickListener(this);
    paramView.findViewById(2131165602).setOnClickListener(this);
    paramView.findViewById(2131165590).setOnClickListener(this);
    paramView.findViewById(2131165592).setOnClickListener(this);
    paramView.findViewById(2131165600).setOnClickListener(this);
    paramView.findViewById(2131165604).setOnClickListener(this);
    paramView.findViewById(2131165597).setOnClickListener(this);
    paramView.findViewById(2131165606).setOnClickListener(this);
    View localView = paramView.findViewById(2131165594);
    localView.setOnClickListener(this);
    if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
    {
      paramView.findViewById(2131165596).setVisibility(8);
      localView.setVisibility(8);
    }
    this.l = ((TextView)paramView.findViewById(2131165530));
    this.t = paramView.findViewById(2131165531);
    this.m = ((TextView)paramView.findViewById(2131165533));
    this.u = ((ImageView)paramView.findViewById(2131165532));
    this.C = paramView.findViewById(2131165528);
    this.n = paramView.findViewById(2131165226);
    this.o = paramView.findViewById(2131165585);
    this.p = ((LinePieChartView)paramView.findViewById(2131165529));
    this.p.setMode(1);
    this.r = ((TextView)paramView.findViewById(2131165591));
    this.s = ((TextView)paramView.findViewById(2131165593));
    this.A = TypedValue.applyDimension(1, 76.0F, getResources().getDisplayMetrics());
    this.h.setInComingCallTime(20);
    Keeper.keepPersonInfo(this.h);
    this.F = ((TextView)paramView.findViewById(2131165598));
    this.B = ((Switch)paramView.findViewById(2131165599));
    this.B.setOnCheckedChangeListener(new by(this));
  }

  private void a(boolean paramBoolean)
  {
    new BleGetBatteryInfoTask(new bx(this, paramBoolean)).work();
  }

  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }

  private Animator b(int paramInt)
  {
    AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch2(100, paramInt, this.l));
    AnimUtil.AnimSetBuilder.addAnim(this.p.animRefresh(), 500L);
    return AnimUtil.AnimSetBuilder.build();
  }

  private IMiLiProfile.BatteryInfo b()
  {
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    if (localMiLiProfile != null)
    {
      IMiLiProfile.BatteryInfo localBatteryInfo = localMiLiProfile.getCachedBatteryInfo();
      if (localBatteryInfo != null)
      {
        this.g = localBatteryInfo;
        Debug.i("SettingFragment", "getCachedBatteryInfo = " + this.g);
      }
    }
    return this.g;
  }

  private void b(boolean paramBoolean)
  {
    Debug.i("SettingFragment", "updateLeftBattery mBatteryInfo =" + this.g + ", isVisible=" + isVisible() + ", showAnimation = " + paramBoolean);
    if ((this.g != null) && (getActivity() != null));
    switch (this.g.status)
    {
    default:
      return;
    case 0:
    case 1:
    case 4:
      this.p.dismissLoading();
      this.p.setMode(1);
      if (this.g.level <= 5)
      {
        this.v = getString(2131493221);
        this.m.setText(this.v);
        if ((this.q != null) && (this.q.isStarted()))
          this.q.end();
        if (!paramBoolean)
          break label346;
        AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch2(100, this.g.level, this.l));
        AnimUtil.AnimSetBuilder.addAnim(this.p.animRefresh(), 500L);
        this.q = AnimUtil.AnimSetBuilder.build();
        this.p.postDelayed(new bA(this), 350L);
      }
      while (true)
      {
        this.u.setVisibility(8);
        this.l.setVisibility(0);
        this.t.setVisibility(0);
        return;
        String str = 1L + (Calendar.getInstance().getTimeInMillis() - this.g.lastCharge.getTimeInMillis()) / 86400000L;
        this.v = String.format(getResources().getText(2131493173).toString(), new Object[] { str });
        this.m.setText(this.v);
        break;
        this.p.setMaxValue(100L);
        this.p.setValue(100 - this.g.level);
        this.l.setText(this.g.level);
      }
    case 2:
      label346: this.p.setMode(2);
      this.p.showLoading(10L);
      this.m.setText(2131493222);
      this.u.setImageResource(2130837658);
      this.u.setVisibility(0);
      this.l.setVisibility(8);
      this.t.setVisibility(8);
      return;
    case 3:
    }
    this.p.dismissLoading();
    this.p.setMaxValue(100L);
    this.p.setValue(0);
    this.p.setMode(1);
    this.m.setText(2131493220);
    this.u.setVisibility(8);
    this.l.setText("100");
    this.l.setVisibility(0);
    this.t.setVisibility(0);
  }

  private void c()
  {
    if (a(this.z))
      return;
    int i1 = 1 + this.E;
    this.E = i1;
    if (i1 >= 3)
    {
      this.E = -1000;
      Toast.makeText(getActivity(), 2131493316, 1).show();
    }
    new BleNotifyTask(null).work();
    this.u.setVisibility(0);
    this.z.reset();
    this.u.startAnimation(this.z);
  }

  private void d()
  {
    this.z = new RotateAnimation(-5.0F, 5.0F, 0, Utils.convertDpToPixel(16.0F, getActivity()), 0, Utils.convertDpToPixel(33.0F, getActivity()));
    this.z.setAnimationListener(new bz(this));
    this.z.setDuration(50L);
    this.z.setRepeatCount(20);
    this.z.setInterpolator(new AccelerateDecelerateInterpolator());
    this.z.setRepeatMode(2);
  }

  private void e()
  {
    startActivity(new Intent(getActivity(), UnBindActivity.class));
  }

  private void f()
  {
    Intent localIntent = new Intent(getActivity(), SearchSingleBraceletActivity.class);
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }

  private void g()
  {
    Debug.i("SettingFragment", "enableUI");
    this.n.setVisibility(4);
    this.k.setVisibility(0);
    this.o.setBackgroundResource(2131230780);
    this.l.setVisibility(0);
    this.t.setVisibility(0);
    this.u.setVisibility(4);
  }

  private void h()
  {
    this.n.setVisibility(0);
    this.k.setVisibility(4);
    this.o.setBackgroundResource(2131230781);
    this.m.setText(2131493186);
    this.l.setVisibility(4);
    this.t.setVisibility(4);
    this.p.dismissLoading();
    this.u.setImageResource(2130837686);
    this.u.setVisibility(0);
    this.p.setMaxValue(100L);
    this.p.setValue(100L);
    this.p.setMode(0);
    this.p.refresh(false);
    if (Utils.isBinded())
    {
      this.x.setText(2131493169);
      return;
    }
    this.x.setText(2131492991);
  }

  private void i()
  {
    m();
    if (BraceletApp.BLEService != null)
    {
      MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      if (localMiLiProfile != null)
      {
        IMiLiProfile.DeviceInfo localDeviceInfo = localMiLiProfile.getCachedDeviceInfo();
        if (localDeviceInfo != null)
          this.j.setText(localDeviceInfo.getFirmwareVersionStr());
      }
    }
    if ("BLUE".equals(this.h.getMiliColor()))
    {
      this.r.setText(2131493174);
      if (!"LEFT_HAND".equals(this.h.getMiliWearHand()))
        break label268;
      this.s.setText(2131493167);
      label99: if (!this.h.isInComingCallEnabled())
        break label281;
      this.B.setChecked(true);
    }
    while (true)
    {
      Debug.i("SettingFragment", "inComingCallTime = " + this.h.getInComingCallTime());
      TextView localTextView = this.F;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.h.getInComingCallTime());
      localTextView.setText(getString(2131493241, arrayOfObject));
      return;
      if ("ORANGE".equals(this.h.getMiliColor()))
      {
        this.r.setText(2131493177);
        break;
      }
      if ("GREEN".equals(this.h.getMiliColor()))
      {
        this.r.setText(2131493176);
        break;
      }
      if (!"RED".equals(this.h.getMiliColor()))
        break;
      this.r.setText(2131493175);
      break;
      label268: this.s.setText(2131493168);
      break label99;
      label281: this.B.setChecked(false);
    }
  }

  private void j()
  {
    if (this.h.isInComingCallEnabled())
      this.B.setChecked(true);
    while (true)
    {
      Debug.i("SettingFragment", "inComingCallTime = " + this.h.getInComingCallTime());
      TextView localTextView = this.F;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.h.getInComingCallTime());
      localTextView.setText(getString(2131493241, arrayOfObject));
      return;
      this.B.setChecked(false);
    }
  }

  private void k()
  {
    if ("LEFT_HAND".equals(this.h.getMiliWearHand()))
    {
      this.s.setText(2131493167);
      return;
    }
    this.s.setText(2131493168);
  }

  private void l()
  {
    if ("BLUE".equals(this.h.getMiliColor()))
      this.r.setText(2131493174);
    do
    {
      return;
      if ("ORANGE".equals(this.h.getMiliColor()))
      {
        this.r.setText(2131493177);
        return;
      }
      if ("GREEN".equals(this.h.getMiliColor()))
      {
        this.r.setText(2131493176);
        return;
      }
    }
    while (!"RED".equals(this.h.getMiliColor()));
    this.r.setText(2131493175);
  }

  private void m()
  {
    this.i.setText(this.h.getDaySportGoalSteps() + getString(2131493172));
  }

  private void n()
  {
    if (BraceletApp.BLEService == null);
    IMiLiProfile.DeviceInfo localDeviceInfo;
    do
    {
      MiLiProfile localMiLiProfile;
      do
      {
        return;
        localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      }
      while (localMiLiProfile == null);
      localDeviceInfo = localMiLiProfile.getCachedDeviceInfo();
    }
    while (localDeviceInfo == null);
    this.j.setText(localDeviceInfo.getFirmwareVersionStr());
  }

  public static SettingFragment newInstance()
  {
    SettingFragment localSettingFragment = new SettingFragment();
    localSettingFragment.setArguments(new Bundle());
    return localSettingFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Debug.i("SettingFragment", "onActivityResult: " + paramInt1 + " result:" + paramInt2);
    if ((paramInt1 == 256) && (paramInt2 == -1))
    {
      this.h = Keeper.readPersonInfo();
      m();
    }
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    if (paramConnStatus.a == 8)
    {
      Debug.i("SettingFragment", "connect success");
      if (Utils.isBraceletConnected())
        g();
      if (this.g == null)
        a(true);
    }
    do
    {
      return;
      b(false);
      return;
      if (paramConnStatus.a == 9)
      {
        Debug.i("SettingFragment", "sync data start");
        return;
      }
      if (paramConnStatus.a == 10)
      {
        Debug.i("SettingFragment", "sync data progress : " + paramConnStatus.b);
        return;
      }
      if (paramConnStatus.a == 11)
      {
        Debug.i("SettingFragment", "sync data stop");
        return;
      }
    }
    while (paramConnStatus.a >= 8);
    h();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131165230:
      do
        return;
      while (getActivity() == null);
      getActivity().finish();
      return;
    case 2131165588:
      startActivityForResult(new Intent(getActivity(), HealthGoalsActivity.class), 256);
      return;
    case 2131165602:
      e();
      return;
    case 2131165606:
      if (Utils.isBinded())
      {
        e();
        return;
      }
      Intent localIntent2 = new Intent(getActivity(), SearchSingleBraceletActivity.class);
      localIntent2.setFlags(268468224);
      startActivity(localIntent2);
      return;
    case 2131165586:
      c();
      return;
    case 2131165590:
      DimPanelFragment.showPanel(getActivity(), PersonInfoSetLightColorFragment.class);
      return;
    case 2131165592:
      DimPanelFragment.showPanel(getActivity(), PersonInfoWearHandFragment.class);
      return;
    case 2131165604:
      BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
      Activity localActivity = getActivity();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localBraceletBtInfo.name;
      arrayOfObject[1] = localBraceletBtInfo.address;
      String str = localActivity.getString(2131492882, arrayOfObject);
      Toast.makeText(getActivity(), str, 1).show();
      return;
    case 2131165600:
      startActivity(new Intent(getActivity(), BindWeixinActivity.class));
      return;
    case 2131165597:
      this.B.toggle();
      return;
    case 2131165594:
    }
    Intent localIntent1 = new Intent();
    localIntent1.setClass(getActivity(), UnlockScreenHelperActivity.class);
    getActivity().startActivity(localIntent1);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventBus.getDefault().register(this);
    EventBus.getDefault().register(this, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903129, paramViewGroup, false);
    this.h = Keeper.readPersonInfo();
    this.y = ((SlidingUpPanelLayout)localView1.findViewById(2131165583));
    this.y.setOverlayed(true);
    this.y.setEnableDragViewTouchEvents(true);
    this.y.setPanelSlideListener(this.G);
    localView1.findViewById(2131165230).setOnClickListener(this);
    this.j = ((TextView)localView1.findViewById(2131165605));
    this.i = ((TextView)localView1.findViewById(2131165589));
    this.k = ((TextView)localView1.findViewById(2131165603));
    this.x = ((TextView)localView1.findViewById(2131165607));
    localView1.findViewById(2131165586).setOnClickListener(this);
    localView1.findViewById(2131165586).setOnLongClickListener(this);
    localView1.findViewById(2131165588).setOnClickListener(this);
    localView1.findViewById(2131165602).setOnClickListener(this);
    localView1.findViewById(2131165590).setOnClickListener(this);
    localView1.findViewById(2131165592).setOnClickListener(this);
    localView1.findViewById(2131165600).setOnClickListener(this);
    localView1.findViewById(2131165604).setOnClickListener(this);
    localView1.findViewById(2131165597).setOnClickListener(this);
    localView1.findViewById(2131165606).setOnClickListener(this);
    View localView2 = localView1.findViewById(2131165594);
    localView2.setOnClickListener(this);
    if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
    {
      localView1.findViewById(2131165596).setVisibility(8);
      localView2.setVisibility(8);
    }
    this.l = ((TextView)localView1.findViewById(2131165530));
    this.t = localView1.findViewById(2131165531);
    this.m = ((TextView)localView1.findViewById(2131165533));
    this.u = ((ImageView)localView1.findViewById(2131165532));
    this.C = localView1.findViewById(2131165528);
    this.n = localView1.findViewById(2131165226);
    this.o = localView1.findViewById(2131165585);
    this.p = ((LinePieChartView)localView1.findViewById(2131165529));
    this.p.setMode(1);
    this.r = ((TextView)localView1.findViewById(2131165591));
    this.s = ((TextView)localView1.findViewById(2131165593));
    this.A = TypedValue.applyDimension(1, 76.0F, getResources().getDisplayMetrics());
    this.h.setInComingCallTime(20);
    Keeper.keepPersonInfo(this.h);
    this.F = ((TextView)localView1.findViewById(2131165598));
    this.B = ((Switch)localView1.findViewById(2131165599));
    this.B.setOnCheckedChangeListener(new by(this));
    this.z = new RotateAnimation(-5.0F, 5.0F, 0, Utils.convertDpToPixel(16.0F, getActivity()), 0, Utils.convertDpToPixel(33.0F, getActivity()));
    this.z.setAnimationListener(new bz(this));
    this.z.setDuration(50L);
    this.z.setRepeatCount(20);
    this.z.setInterpolator(new AccelerateDecelerateInterpolator());
    this.z.setRepeatMode(2);
    this.D = true;
    return localView1;
  }

  public void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    Debug.i("SettingFragment", "onDestroyView");
    if (this.w != null)
    {
      this.w.cancel(true);
      this.w = null;
    }
  }

  public void onEvent(EventBatteryStatus paramEventBatteryStatus)
  {
    Debug.i("SettingFragment", "EventBatteryStatus onEvent: status = " + paramEventBatteryStatus.status + ", charges =" + paramEventBatteryStatus.level);
    a(false);
  }

  public void onEvent(EventSettingFragmentUpdate paramEventSettingFragmentUpdate)
  {
    this.h = Keeper.readPersonInfo();
    Debug.i("SettingFragment", "update ... ui " + this.h);
    i();
    WebAPI.updateProfile(Keeper.readLoginData(), this.h, new bw(this));
  }

  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return true;
    case 2131165586:
    }
    if (this.w == null)
    {
      Debug.i("SettingFragment", "mShowOffTask" + this.w + " start ");
      c();
      this.w = new bB(this, (byte)0).execute(new String[0]);
      return true;
    }
    Debug.i("SettingFragment", "mShowOffTask" + this.w + " cancel ");
    this.w.cancel(true);
    this.w = null;
    return true;
  }

  public void onPause()
  {
    super.onPause();
    if (a(this.z))
    {
      this.u.clearAnimation();
      this.u.setVisibility(4);
    }
    AnalyticsTrackerManager.endTimedEvent(new String[] { "EventSettingPage" });
    UmengAnalytics.endPage("PageBracelet");
  }

  public void onResume()
  {
    super.onResume();
    Debug.i("SettingFragment", "onResume");
    i();
    boolean bool;
    if (this.D)
    {
      if (!Utils.isBraceletConnected())
        break label169;
      g();
      MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      if (localMiLiProfile != null)
      {
        IMiLiProfile.BatteryInfo localBatteryInfo = localMiLiProfile.getCachedBatteryInfo();
        if (localBatteryInfo != null)
        {
          this.g = localBatteryInfo;
          Debug.i("SettingFragment", "getCachedBatteryInfo = " + this.g);
        }
      }
      this.g = this.g;
      if (this.g == null)
        break label164;
      b(true);
      bool = false;
      a(bool);
    }
    while (true)
    {
      this.D = false;
      if (!isHidden())
        AnalyticsTrackerManager.trackTimedEvent("EventSettingPage");
      if (this.h.getNeedSyncServer() != 0)
        EventBus.getDefault().post(new EventPersonInfoUpdate());
      UmengAnalytics.startPage("PageBracelet");
      return;
      label164: bool = true;
      break;
      label169: h();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFragment
 * JD-Core Version:    0.6.2
 */