package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.eventbus.EventLoadDataComplete;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import cn.com.smartdevices.bracelet.view.DynamicView;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.IRealtimeStepsChangedCB;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import java.util.HashMap;

public class DynamicFragment extends Fragment
  implements IMiLiProfile.IRealtimeStepsChangedCB
{
  public static final int LOAD_MORE_BLOGS = 1;
  public static final int MSG_TO_LAST_DAY = 4121;
  public static final int MSG_TO_NEXT_DAY = 4120;
  public static final int MSG_TO_PREV_DAY = 4119;
  public static final int MSG_UPDATE_STEPS = 4115;
  public static final int REFRESH_BLOGS = 0;
  private static final String a = "Dynamic.Main";
  public static Handler mHandler = null;
  private final int b;
  private final int c;
  private DataManager d = DataManager.getInstance();
  private int e = -1;
  private ViewPager f;
  private PageIndicator g;
  private X h;
  private BaseSCActivity.ConnStatus i = new BaseSCActivity.ConnStatus();
  private int j;
  private int k;
  private int l;
  private ValueAnimator m;
  private int n;
  private Boolean o = Boolean.valueOf(false);
  private boolean p = false;
  private Boolean q = Boolean.valueOf(false);

  private ValueAnimator a()
  {
    boolean bool = this.q.booleanValue();
    ValueAnimator localValueAnimator = null;
    if (!bool)
    {
      int i1 = this.j;
      int i2 = this.k;
      Debug.i("Dynamic.Main", "Build bg switch anim!!");
      View[] arrayOfView = new View[1];
      arrayOfView[0] = this.f;
      localValueAnimator = (ValueAnimator)AnimUtil.animColorTrans(i1, i2, arrayOfView);
    }
    return localValueAnimator;
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 16:
    case 1:
    }
    DynamicView localDynamicView;
    do
    {
      return;
      ((MainUIActivity)getActivity()).updateTitle(2131493129);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("mode", "EventModeSleep");
      UmengAnalytics.event(getActivity(), "EventDynamic", localHashMap2);
      return;
      ((MainUIActivity)getActivity()).updateTitle(2131493130);
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("mode", "EventModeStep");
      UmengAnalytics.event(getActivity(), "EventDynamic", localHashMap1);
      localDynamicView = this.h.a();
    }
    while (localDynamicView == null);
    localDynamicView.refresh(true);
  }

  private void a(int paramInt1, int paramInt2)
  {
    new Thread(new V(this, 0, 0)).start();
  }

  private void a(ChartData.DynamicData paramDynamicData)
  {
    Debug.i("Dynamic.Main", "Update Dynamic Tip!!");
    Calendar localCalendar1 = Calendar.getInstance();
    Debug.i("Dynamic.Main", "CurrentTime : " + localCalendar1);
    Calendar localCalendar2 = Calendar.getInstance();
    long l1 = Keeper.readSyncTime();
    String str1;
    label121: Calendar localCalendar3;
    long l2;
    label154: String str2;
    if (l1 == -1L)
    {
      localCalendar2.add(6, -1);
      Debug.i("Dynamic.Main", "LastSyncTime : " + localCalendar2);
      if (((localCalendar2.get(6) >= localCalendar1.get(6)) && (localCalendar2.get(11) >= 5)) || (localCalendar1.get(11) < 5))
        break label216;
      str1 = getString(2131493145);
      paramDynamicData.setSleepTip(str1);
      localCalendar3 = Calendar.getInstance();
      l2 = Keeper.readSyncRealStepTime();
      if (l2 != -1L)
        break label245;
      localCalendar3.add(6, -1);
      Debug.i("Dynamic.Main", "LastSyncRealStepTime : " + localCalendar3);
      if (localCalendar3.get(6) >= localCalendar1.get(6))
        break label255;
      str2 = getString(2131493146);
    }
    while (true)
    {
      paramDynamicData.setStepTip(str2);
      return;
      localCalendar2.setTimeInMillis(l1);
      break;
      label216: if (!paramDynamicData.isWeared())
      {
        str1 = getString(2131493144);
        break label121;
      }
      str1 = getString(2131493132);
      break label121;
      label245: localCalendar3.setTimeInMillis(l2);
      break label154;
      label255: long l3 = (int)((localCalendar1.getTimeInMillis() - localCalendar3.getTimeInMillis()) / 60000L);
      if (l3 >= 2L)
      {
        if (l3 >= 60L)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Long.valueOf(l3 / 60L);
          str2 = getString(2131493147, arrayOfObject2);
        }
        else
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Long.valueOf(l3);
          str2 = getString(2131493148, arrayOfObject1);
        }
      }
      else
        str2 = getString(2131493131);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (getActivity() == null);
    SportDay localSportDay;
    do
    {
      return;
      localSportDay = this.d.getStopDay();
    }
    while (localSportDay == null);
    Debug.i("DDDD", "Dynamic Current Day : " + localSportDay.formatString());
    DaySportData localDaySportData1 = this.d.get(localSportDay);
    StepsInfo localStepsInfo1 = null;
    SleepInfo localSleepInfo1 = null;
    if (localDaySportData1 != null)
    {
      localStepsInfo1 = localDaySportData1.getStepsInfo();
      localSleepInfo1 = localDaySportData1.getSleepInfo();
    }
    if (localStepsInfo1 == null);
    for (StepsInfo localStepsInfo2 = new StepsInfo(); ; localStepsInfo2 = localStepsInfo1)
    {
      boolean bool1;
      if (localSleepInfo1 == null)
      {
        localSleepInfo1 = new SleepInfo();
        bool1 = true;
      }
      while (true)
      {
        if ((bool1) && (localSportDay.calendar.get(11) >= 5))
          bool1 = false;
        Debug.i("DDDD", "Dynamic Show Previous Day's Sleep Info: " + bool1);
        if (bool1)
        {
          this.d.load(localSportDay.addDay(-1));
          DaySportData localDaySportData2 = this.d.get(localSportDay.addDay(-1));
          if (localDaySportData2 != null)
          {
            localSleepInfo2 = localDaySportData2.getSleepInfo();
            if (localSleepInfo2 != null);
          }
        }
        for (SleepInfo localSleepInfo2 = new SleepInfo(); ; localSleepInfo2 = localSleepInfo1)
        {
          int i1 = localStepsInfo2.getStepsCount();
          int i2 = localStepsInfo2.getDistance();
          int i3 = localStepsInfo2.getCalories();
          Debug.i("DDDD", "Dynamic Step Info : " + i1 + " , " + i2 + " , " + i3);
          Calendar localCalendar1 = Calendar.getInstance();
          localCalendar1.setTimeInMillis(Keeper.readSyncRealStepTime());
          if (!new SportDay(localCalendar1).equals(localSportDay))
            this.e = -1;
          ChartData.DynamicData localDynamicData;
          label520: Calendar localCalendar2;
          Calendar localCalendar3;
          long l1;
          label621: String str1;
          label690: Calendar localCalendar4;
          long l2;
          label724: String str2;
          label771: boolean bool2;
          label794: DynamicFragment.DynamicViewFragment localDynamicViewFragment2;
          boolean bool3;
          if (this.e != -1)
          {
            if (i1 != this.e)
            {
              if (i1 > 0)
              {
                i2 = i2 * this.e / i1;
                i3 = i3 * this.e / i1;
                Debug.i("bxl", "set Steps=" + this.e);
              }
            }
            else
            {
              i1 = this.e;
              localStepsInfo2.setRealtimeSteps(i1);
              Debug.i("bxl", "setRealtimeSteps=" + this.e);
              Debug.i("DDDD", "Dynamic Real-Step : " + i1 + " , " + i2 + " , " + i3);
            }
          }
          else
          {
            localDynamicData = ChartData.getDynamicData();
            localDynamicData.setStepCount(i1);
            localDynamicData.setStepDistance(i2);
            localDynamicData.setStepCalorie(i3);
            if ((localSleepInfo2.getHasSleep()) || (localSleepInfo2.getNosleepReason() != SleepInfo.NOSLEEP_NONWEAR))
              break label922;
            localDynamicData.setWeared(false);
            localDynamicData.setSleepTime(localSleepInfo2.getSleepCount());
            localDynamicData.setSleepDeepTime(localSleepInfo2.getNonRemCount());
            localDynamicData.setSleepStartDate(localSleepInfo2.getStartDate());
            localDynamicData.setSleepStopDate(localSleepInfo2.getStopDate());
            Debug.i("Dynamic.Main", "Update Dynamic Tip!!");
            localCalendar2 = Calendar.getInstance();
            Debug.i("Dynamic.Main", "CurrentTime : " + localCalendar2);
            localCalendar3 = Calendar.getInstance();
            l1 = Keeper.readSyncTime();
            if (l1 != -1L)
              break label931;
            localCalendar3.add(6, -1);
            Debug.i("Dynamic.Main", "LastSyncTime : " + localCalendar3);
            if (((localCalendar3.get(6) >= localCalendar2.get(6)) && (localCalendar3.get(11) >= 5)) || (localCalendar2.get(11) < 5))
              break label941;
            str1 = getString(2131493145);
            localDynamicData.setSleepTip(str1);
            localCalendar4 = Calendar.getInstance();
            l2 = Keeper.readSyncRealStepTime();
            if (l2 != -1L)
              break label971;
            localCalendar4.add(6, -1);
            Debug.i("Dynamic.Main", "LastSyncRealStepTime : " + localCalendar4);
            if (localCalendar4.get(6) >= localCalendar2.get(6))
              break label981;
            str2 = getString(2131493146);
            localDynamicData.setStepTip(str2);
            DynamicFragment.DynamicViewFragment localDynamicViewFragment1 = this.h.b();
            if (!paramBoolean)
              break label1092;
            bool2 = false;
            localDynamicViewFragment1.notifyDataSetChanged(bool2);
            localDynamicViewFragment2 = this.h.c();
            bool3 = false;
            if (!paramBoolean)
              break label1098;
          }
          while (true)
          {
            localDynamicViewFragment2.notifyDataSetChanged(bool3);
            return;
            if (localSleepInfo1.getSleepCount() != 0)
              break label1111;
            bool1 = true;
            break;
            PersonInfo localPersonInfo = Keeper.readPersonInfo();
            if ((localPersonInfo == null) || (localPersonInfo.height <= 0));
            for (double d1 = 0.714D; ; d1 = 0.42D * localPersonInfo.height / 100.0D)
            {
              i2 = (int)(d1 * this.e);
              i3 = (int)(1.19D * (2.2046D * localPersonInfo.weight) * this.e / 4000.0D);
              break;
            }
            label922: localDynamicData.setWeared(true);
            break label520;
            label931: localCalendar3.setTimeInMillis(l1);
            break label621;
            label941: if (!localDynamicData.isWeared())
            {
              str1 = getString(2131493144);
              break label690;
            }
            str1 = getString(2131493132);
            break label690;
            label971: localCalendar4.setTimeInMillis(l2);
            break label724;
            label981: long l3 = (int)((localCalendar2.getTimeInMillis() - localCalendar4.getTimeInMillis()) / 60000L);
            if (l3 >= 2L)
            {
              if (l3 >= 60L)
              {
                Object[] arrayOfObject2 = new Object[1];
                arrayOfObject2[0] = Long.valueOf(l3 / 60L);
                str2 = getString(2131493147, arrayOfObject2);
                break label771;
              }
              Object[] arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = Long.valueOf(l3);
              str2 = getString(2131493148, arrayOfObject1);
              break label771;
            }
            str2 = getString(2131493131);
            break label771;
            label1092: bool2 = true;
            break label794;
            label1098: bool3 = true;
          }
        }
        label1111: bool1 = false;
      }
    }
  }

  private void a(boolean paramBoolean, IMiLiProfile.IRealtimeStepsChangedCB paramIRealtimeStepsChangedCB)
  {
    if (!Utils.isBraceletConnected())
      return;
    new Thread(new W(this, paramBoolean, paramIRealtimeStepsChangedCB)).start();
  }

  private void b()
  {
    mHandler = new U(this);
  }

  private static void c()
  {
  }

  private static void d()
  {
  }

  private void e()
  {
    if (this.d.isStartDay())
    {
      Toast.makeText(getActivity(), "没有更早以前的数据！", 0).show();
      return;
    }
    this.d.setCurDay(-1, 0);
    a(0, 0);
  }

  private void f()
  {
    if (this.d.isStopDay())
    {
      Toast.makeText(getActivity(), "把握现在，健康明天", 0).show();
      return;
    }
    this.d.setCurDay(1, 0);
    a(0, 0);
  }

  private void g()
  {
    if (this.d.isStopDay())
      return;
    this.d.setCurDay(0, 2);
    a(0, 0);
  }

  public static DynamicFragment newInstance()
  {
    DynamicFragment localDynamicFragment = new DynamicFragment();
    localDynamicFragment.setArguments(new Bundle());
    return localDynamicFragment;
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Debug.i("Dynamic.Main", "onBleStatusChanged:" + paramConnStatus);
    this.i = paramConnStatus;
    int i1 = paramConnStatus.a;
    if (i1 == 8)
    {
      if (this.p)
        break label79;
      a(true, this);
    }
    while (true)
    {
      if ((i1 == 11) && (isAdded()))
      {
        Debug.i("DDDD", "Dynamic Update : Data Synced.");
        a(true);
      }
      return;
      label79: a(false, this);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p = false;
    mHandler = new U(this);
    EventBus.getDefault().register(this, "onGoalsSettingChanged", EventGoalsUpdated.class, new Class[0]);
    EventBus.getDefault().registerSticky(this, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
    EventBus.getDefault().registerSticky(this, "onLoadDataComplete", EventLoadDataComplete.class, new Class[0]);
    Resources localResources = getActivity().getResources();
    this.j = localResources.getColor(2131230772);
    this.k = localResources.getColor(2131230773);
    this.l = localResources.getColor(2131230774);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903070, null);
    this.f = ((ViewPager)localView.findViewById(2131165231));
    this.g = ((PageIndicator)localView.findViewById(2131165232));
    this.h = new X(this, getChildFragmentManager());
    this.f.setAdapter(this.h);
    this.g.setViewPager(this.f);
    this.g.setOnPageChangeListener(new T(this));
    this.m = a();
    this.n = 1;
    this.f.setCurrentItem(1, false);
    if (this.o.booleanValue())
      setVPHight();
    setIndicator(this.g);
    return localView;
  }

  public void onDestroy()
  {
    this.p = true;
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  public void onDetach()
  {
    super.onDetach();
    if (mHandler != null)
    {
      mHandler.removeCallbacksAndMessages(null);
      mHandler = null;
    }
  }

  public void onGoalsSettingChanged(EventGoalsUpdated paramEventGoalsUpdated)
  {
    Debug.i("Dynamic.Main", "onGoalsSettingChanged");
    if (isAdded())
    {
      Debug.i("DDDD", "Dynamic Update : Goal Changed.");
      a(true);
    }
  }

  public void onLoadDataComplete(EventLoadDataComplete paramEventLoadDataComplete)
  {
    Debug.i("Dynamic.Main", "onLoadDataComplete");
    if (isAdded())
    {
      Debug.i("DDDD", "Dynamic Update : Data Loaded,Animation");
      a(false);
    }
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageDynamic");
  }

  public void onResume()
  {
    super.onResume();
    Debug.i("Dynamic.Main", "onResume................");
    this.p = false;
    a(true, this);
    Debug.i("DDDD", "Dynamic Update : OnResume.");
    a(true);
    if (this.i.a != -1)
      onBleStatusChanged(this.i);
    UmengAnalytics.startPage("PageDynamic");
  }

  public void onStop()
  {
    super.onStop();
    Debug.i("Dynamic.Main", "onStop................");
    this.p = true;
    a(false, this);
  }

  public void process(int paramInt)
  {
    Debug.i("step", "process:" + paramInt);
    Message localMessage = new Message();
    localMessage.arg1 = paramInt;
    localMessage.what = 4115;
    mHandler.sendMessage(localMessage);
  }

  public void setBindMode()
  {
    if (Utils.isBinded());
    for (boolean bool = false; ; bool = true)
    {
      this.q = Boolean.valueOf(bool);
      Debug.i("chenee", "set bind mode:" + this.q);
      if (!this.q.booleanValue())
        break;
      this.f.setBackgroundColor(this.l);
      this.m = null;
      return;
    }
    int i1 = this.n;
    int i2 = 0;
    switch (i1)
    {
    default:
    case 16:
    case 1:
    }
    while (true)
    {
      this.f.setBackgroundColor(i2);
      this.m = a();
      return;
      i2 = this.j;
      continue;
      i2 = this.k;
    }
  }

  public void setConnectingAlpha(Boolean paramBoolean)
  {
    if (getActivity() == null)
      return;
    this.h.b().setConnectingAlpha(paramBoolean);
    this.h.c().setConnectingAlpha(paramBoolean);
  }

  public void setIndicator(PageIndicator paramPageIndicator)
  {
    if (getActivity() == null)
      return;
    this.h.b().setIndicator(paramPageIndicator);
    this.h.c().setIndicator(paramPageIndicator);
  }

  public void setSlideUpPosition(float paramFloat)
  {
    if (getActivity() == null)
      return;
    this.h.b().setSlideUpPosition(paramFloat);
    this.h.c().setSlideUpPosition(paramFloat);
  }

  public void setVPHight()
  {
    if (this.f == null)
    {
      this.o = Boolean.valueOf(true);
      return;
    }
    this.f.getHeight();
    this.f.getLayoutParams().height = ((int)Utils.convertDpToPixel(372.0F, getActivity()));
    this.f.requestLayout();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicFragment
 * JD-Core Version:    0.6.2
 */