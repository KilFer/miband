package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StageSteps;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartSleepData;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartStepData;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class DynamicDetailFragment extends Fragment
  implements View.OnClickListener
{
  public static final String KEY_MODIFY_SLEEP_DAY = "CurrentDay";
  public static final String KEY_MODIFY_SLEEP_TIME_CURRENT_HOUR = "CurrentHour";
  public static final String KEY_MODIFY_SLEEP_TIME_CURRENT_MINUTE = "CurrentMinute";
  public static final String KEY_MODIFY_SLEEP_TIME_LIMIT_END = "LimitEnd";
  public static final String KEY_MODIFY_SLEEP_TIME_LIMIT_START = "LimitStart";
  public static final String KEY_MODIFY_SLEEP_TIME_MAX_HOUR = "MaxHour";
  public static final String KEY_MODIFY_SLEEP_TIME_MIN_HOUR = "MinHour";
  public static final String KEY_MODIFY_SLEEP_TYPE = "Type";
  public static final int MODIFY_SLEEP_TYPE_END = 16;
  public static final int MODIFY_SLEEP_TYPE_START = 1;
  public static final String REF_ACTION = "Action";
  private static final String a = "Dynamic.Detail";
  public static Handler sRefreshHander;
  private int A;
  private int B;
  private int C;
  private int D;
  private Animator E;
  private Animator F;
  private Animator G;
  private boolean H;
  private String I;
  private int J;
  private int K;
  private int L;
  private View b;
  private TextView c;
  private TextView d;
  private View e;
  private ImageButton f;
  private View g;
  private View h;
  private View i;
  private View j;
  private DynamicDetailChartView k;
  private TextView l;
  private View m;
  private View n;
  private GestureDetector o;
  private DataManager p = DataManager.getInstance();
  private SportDay q;
  private SportDay r;
  private SportDay s;
  private SportDay t;
  private SportDay u;
  private int v;
  private String w;
  private int x;
  private int y;
  private int z;

  private static int a(Calendar paramCalendar)
  {
    return -(60 * (-1 + (24 - paramCalendar.get(11))) + (60 - paramCalendar.get(12)));
  }

  private Animator a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AnimUtil.AnimSetBuilder.setFirstAnim(this.k.animRefresh(), paramLong);
    if (!paramBoolean)
    {
      View[] arrayOfView = new View[2];
      arrayOfView[0] = this.b;
      arrayOfView[1] = ((View)this.k.getParent());
      AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(paramInt1, paramInt2, arrayOfView), paramLong / 2L);
    }
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.addListener(new Q(this));
    return localAnimatorSet;
  }

  private DynamicDetailChartView.DynamicDetailChartData a(DaySportData paramDaySportData)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramDaySportData.getAnalysisData().iterator();
    Object localObject = null;
    DynamicDetailChartView.DynamicDetailChartSleepData localDynamicDetailChartSleepData = null;
    int i1 = -1;
    int i2 = -1;
    DynamicDetailChartView.DynamicDetailChartData localDynamicDetailChartData;
    label71: int i3;
    int i4;
    int i5;
    if (!localIterator.hasNext())
    {
      localDynamicDetailChartData = new DynamicDetailChartView.DynamicDetailChartData();
      if (this.v == 16)
      {
        localDynamicDetailChartData.sleepData = localArrayList1;
        return localDynamicDetailChartData;
      }
    }
    else
    {
      SportData localSportData = (SportData)localIterator.next();
      i3 = localSportData.getSportMode();
      i4 = localSportData.getStep();
      i5 = localSportData.getTimeIndex();
      if ((i2 == i3) && (i5 != 1439))
        break label381;
      if (localDynamicDetailChartSleepData != null)
      {
        localDynamicDetailChartSleepData.length = (i5 - localDynamicDetailChartSleepData.index);
        localDynamicDetailChartSleepData = null;
      }
      if ((i3 == 4) || (i3 == 5) || (i3 == 7) || (i3 == 100))
      {
        localDynamicDetailChartSleepData = new DynamicDetailChartView.DynamicDetailChartSleepData();
        localArrayList1.add(localDynamicDetailChartSleepData);
        localDynamicDetailChartSleepData.index = i5;
        localDynamicDetailChartSleepData.length = 1;
        switch (i3)
        {
        default:
        case 4:
        case 5:
        case 7:
        case 100:
        }
      }
    }
    while (true)
    {
      if (i4 > 0)
      {
        int i6 = i5 / 60;
        if (i6 != i1)
        {
          DynamicDetailChartView.DynamicDetailChartStepData localDynamicDetailChartStepData = new DynamicDetailChartView.DynamicDetailChartStepData();
          localArrayList2.add(localDynamicDetailChartStepData);
          localDynamicDetailChartStepData.index = i6;
          localDynamicDetailChartStepData.step = i4;
          localObject = localDynamicDetailChartStepData;
          i1 = i6;
          i2 = i3;
          break;
          localDynamicDetailChartSleepData.mode = 2;
          continue;
          localDynamicDetailChartSleepData.mode = 3;
          continue;
          localDynamicDetailChartSleepData.mode = 1;
          continue;
          localDynamicDetailChartSleepData.mode = 4;
          continue;
        }
        localObject.step = (i4 + localObject.step);
      }
      i2 = i3;
      break;
      if (this.v != 1)
        break label71;
      localDynamicDetailChartData.stepData = localArrayList2;
      return localDynamicDetailChartData;
      label381: i3 = i2;
    }
  }

  private static String a(SportDay paramSportDay)
  {
    return 1 + paramSportDay.mon + "." + paramSportDay.day;
  }

  private void a()
  {
    View localView1 = (View)this.m.getParent().getParent();
    localView1.post(new N(this, localView1));
    View localView2 = (View)this.n.getParent().getParent();
    localView2.post(new O(this, localView2));
  }

  private void a(int paramInt)
  {
    this.c.setText(paramInt);
  }

  private void a(int paramInt, SportDay paramSportDay)
  {
    Date localDate1 = null;
    int i1 = 23;
    Debug.i("Dynamic.Detail", "Show Modify Sleep Time : " + paramInt);
    DaySportData localDaySportData = this.p.get(paramSportDay);
    if (localDaySportData != null);
    for (SleepInfo localSleepInfo1 = localDaySportData.getSleepInfo(); ; localSleepInfo1 = null)
    {
      if (localSleepInfo1 == null);
      for (SleepInfo localSleepInfo2 = new SleepInfo(); ; localSleepInfo2 = localSleepInfo1)
      {
        Date localDate2;
        Calendar localCalendar1;
        Calendar localCalendar2;
        int i2;
        label138: int i3;
        label158: int i14;
        int i15;
        int i6;
        int i7;
        switch (paramInt)
        {
        default:
          localDate2 = null;
          localCalendar1 = Calendar.getInstance();
          localCalendar1.setTime(localDate2);
          localCalendar2 = Calendar.getInstance();
          localCalendar2.setTime(localDate1);
          if (paramSportDay.addDay(-1).equals(localCalendar1))
          {
            i2 = a(localCalendar1);
            if (!paramSportDay.addDay(-1).equals(localCalendar2))
              break label462;
            i3 = a(localCalendar2);
            if (i2 >= 0)
              break label472;
            i14 = -1 + (i2 + 1) / 60;
            i15 = i2 % 60;
            if (i15 == 0)
              break label563;
            int i16 = i15 + 60;
            i6 = i14;
            i7 = i16;
          }
          break;
        case 1:
        case 16:
        }
        while (true)
        {
          label201: int i8 = i6 - 6;
          int i9 = i6 + 6;
          if (i8 < -24)
            i8 = -24;
          if (i9 > i1)
            i9 = i1;
          ChartData.UserSleepModify localUserSleepModify = ChartData.getDynamicData().getUserSleepModify(paramSportDay);
          int i10 = 0;
          int i11 = 0;
          int i12;
          label290: int i13;
          switch (paramInt)
          {
          default:
            i3 = -2147483648;
            i12 = -2147483648;
            if ((!localSleepInfo2.getHasSleep()) && (i10 == -2147483648))
              if (i11 == -2147483648)
              {
                i3 = -2147483648;
                i12 = -2147483648;
                i13 = -24;
              }
            break;
          case 1:
          case 16:
          }
          while (true)
          {
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("CurrentDay", paramSportDay);
            localBundle.putInt("Type", paramInt);
            localBundle.putInt("MinHour", i13);
            localBundle.putInt("MaxHour", i1);
            localBundle.putInt("CurrentHour", i6);
            localBundle.putInt("CurrentMinute", i7);
            localBundle.putInt("LimitStart", i12);
            localBundle.putInt("LimitEnd", i3);
            DimPanelFragment.showPanel(getActivity(), DynamicDetailSleepModifyFragment.class, localBundle);
            return;
            localDate2 = localSleepInfo2.getStartDate();
            localDate1 = localSleepInfo2.getStopDate();
            break;
            localDate2 = localSleepInfo2.getStopDate();
            localDate1 = localSleepInfo2.getStartDate();
            break;
            i2 = b(localCalendar1);
            break label138;
            label462: i3 = b(localCalendar2);
            break label158;
            label472: int i4 = i2 / 60;
            int i5 = i2 % 60;
            i6 = i4;
            i7 = i5;
            break label201;
            i10 = localUserSleepModify.sleepStart;
            i11 = localUserSleepModify.sleepEnd;
            i12 = -2147483648;
            break label290;
            i10 = localUserSleepModify.sleepEnd;
            i11 = localUserSleepModify.sleepStart;
            i12 = i3;
            i3 = -2147483648;
            break label290;
            i13 = -24;
            continue;
            i1 = i9;
            i13 = i8;
          }
          label563: i6 = i14;
          i7 = i15;
        }
      }
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    View localView2;
    int i3;
    int i2;
    View localView1;
    int i1;
    if (paramInt == 16)
    {
      a(2131493135);
      this.f.setImageResource(2130837540);
      View localView3 = this.h;
      localView2 = this.g;
      i3 = this.D;
      i2 = this.C;
      View localView4 = (View)this.m.getParent().getParent();
      localView4.post(new N(this, localView4));
      View localView5 = (View)this.n.getParent().getParent();
      localView5.post(new O(this, localView5));
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("mode", "EventModeSleep");
      UmengAnalytics.event(getActivity(), "EventDynamicDetail", localHashMap2);
      localView1 = localView3;
      i1 = 650;
    }
    while (true)
    {
      this.k.setMode(paramInt);
      ChartUtil.getDensity();
      if (paramBoolean)
      {
        this.b.setBackgroundColor(i2);
        ((View)this.k.getParent()).setBackgroundColor(i2);
        AnimUtil.infoSwitch((ViewGroup)localView1, (ViewGroup)localView2);
      }
      while (true)
      {
        long l1 = i1;
        AnimUtil.AnimSetBuilder.setFirstAnim(this.k.animRefresh(), l1);
        if (!paramBoolean)
        {
          View[] arrayOfView = new View[2];
          arrayOfView[0] = this.b;
          arrayOfView[1] = ((View)this.k.getParent());
          AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(i3, i2, arrayOfView), l1 / 2L);
        }
        AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
        localAnimatorSet.addListener(new Q(this));
        this.E = localAnimatorSet;
        sRefreshHander.sendEmptyMessage(0);
        return;
        if (paramInt != 1)
          break label447;
        if (!"DynamicView".equals(this.w))
          a(2131493138);
        this.f.setImageResource(2130837537);
        localView1 = this.g;
        localView2 = this.h;
        int i4 = this.C;
        int i5 = this.D;
        this.l.setVisibility(4);
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("mode", "EventModeStep");
        UmengAnalytics.event(getActivity(), "EventDynamicDetail", localHashMap1);
        i3 = i4;
        i2 = i5;
        i1 = 550;
        break;
        localView1.setVisibility(0);
        localView2.setVisibility(0);
        AnimUtil.animInfoSwitch((ViewGroup)localView1, (ViewGroup)localView2);
      }
      label447: localView1 = null;
      localView2 = null;
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
  }

  private void a(View paramView)
  {
    this.b = paramView.findViewById(2131165229);
    this.c = ((TextView)paramView.findViewById(2131165230));
    this.c.setOnClickListener(this);
    this.d = ((TextView)paramView.findViewById(2131165341));
    this.e = paramView.findViewById(2131165342);
    this.e.setOnClickListener(this);
    this.f = ((ImageButton)paramView.findViewById(2131165344));
    this.f.setOnClickListener(this);
    this.g = paramView.findViewById(2131165359);
    this.h = paramView.findViewById(2131165370);
    this.i = paramView.findViewById(2131165345);
    this.j = paramView.findViewById(2131165350);
    this.k = ((DynamicDetailChartView)paramView.findViewById(2131165339));
    this.l = ((TextView)paramView.findViewById(2131165343));
    this.m = paramView.findViewById(2131165364);
    this.n = paramView.findViewById(2131165367);
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    new GestureDetector(getActivity(), new M(this));
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new P(this));
    this.k.setDataLoader(localAsyncChartDataLoader);
    this.k.setScrollable(true);
    if (("DynamicView".equals(this.w)) && (this.v == 1))
    {
      this.k.setScrollable(false);
      ((View)this.f.getParent()).setVisibility(8);
    }
    this.k.attach();
  }

  private static void a(View paramView1, View paramView2)
  {
    int i1 = (int)(30.0F * ChartUtil.getDensity());
    Rect localRect = new Rect();
    paramView2.getHitRect(localRect);
    localRect.left -= i1;
    localRect.top -= i1;
    localRect.right = (i1 + localRect.right);
    localRect.bottom = (i1 + localRect.bottom);
    paramView1.setTouchDelegate(new TouchDelegate(localRect, paramView2));
  }

  private static void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    paramViewGroup1.setVisibility(4);
    paramViewGroup2.setVisibility(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(80L);
    localAnimationSet.addAnimation(localAlphaAnimation);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(100L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.addAnimation(localTranslateAnimation);
    paramViewGroup2.setLayoutAnimation(new LayoutAnimationController(localAnimationSet, 0.7F));
    paramViewGroup2.requestLayout();
  }

  private void a(SleepInfo paramSleepInfo, int paramInt1, int paramInt2, View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165360);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165361);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165362);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165365);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165368);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165369);
    localTextView1.setText(ChartData.formatTimeLength(getActivity(), paramSleepInfo.getSleepCount(), 14));
    localTextView2.setText(ChartData.formatTimeLength(getActivity(), paramSleepInfo.getNonRemCount(), 14));
    localTextView3.setText(ChartData.formatTimeLength(getActivity(), paramSleepInfo.getRemCount(), 14));
    localTextView4.setText(ChartData.formatTime(paramInt1));
    localTextView5.setText(ChartData.formatTime(paramInt2));
    localTextView6.setText(ChartData.formatTimeLength(getActivity(), paramSleepInfo.getAwakeCount(), 14));
  }

  private void a(StageSteps paramStageSteps, View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165351);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165353);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165355);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165354);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165357);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165358);
    localTextView1.setText(String.valueOf(paramStageSteps.steps));
    String[] arrayOfString1 = ChartData.formatTimeLengthHourMin(paramStageSteps.count);
    if (arrayOfString1[0].equals("0"))
    {
      localTextView2.setVisibility(8);
      localTextView4.setVisibility(8);
    }
    while (true)
    {
      localTextView3.setText(arrayOfString1[1]);
      String[] arrayOfString2 = ChartData.formatDistance(getActivity(), paramStageSteps.distance);
      localTextView5.setText(arrayOfString2[0]);
      localTextView6.setText(arrayOfString2[1]);
      return;
      localTextView2.setVisibility(0);
      localTextView4.setVisibility(0);
      localTextView2.setText(arrayOfString1[0]);
    }
  }

  private void a(StepsInfo paramStepsInfo, View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165371);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165372);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165358);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165373);
    TextView localTextView5 = (TextView)paramView.findViewById(2131165375);
    TextView localTextView6 = (TextView)paramView.findViewById(2131165376);
    TextView localTextView7 = (TextView)paramView.findViewById(2131165377);
    localTextView1.setText(String.valueOf(paramStepsInfo.getStepsCount()));
    String[] arrayOfString = ChartData.formatDistance(getActivity(), paramStepsInfo.getDistance());
    localTextView2.setText(arrayOfString[0]);
    localTextView3.setText(arrayOfString[1]);
    localTextView4.setText(String.valueOf(paramStepsInfo.getCalories()));
    localTextView5.setText(ChartData.formatTimeLength(getActivity(), paramStepsInfo.getActMinutes(), 14));
    localTextView6.setText(ChartData.formatTimeLength(getActivity(), paramStepsInfo.getStepsTimeCount(), 14));
    localTextView7.setText(ChartData.formatTimeLength(getActivity(), paramStepsInfo.getRunTimeCount(), 14));
  }

  private void a(BarChart.BarItem paramBarItem, View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131165346);
    TextView localTextView2 = (TextView)paramView.findViewById(2131165348);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165349);
    String str1 = ChartData.formatTime(paramBarItem.index);
    String str2 = ChartData.formatTime(paramBarItem.index + paramBarItem.scope);
    paramView.findViewById(2131165347).setVisibility(0);
    switch (paramBarItem.value)
    {
    default:
    case 3:
    case 2:
    case 1:
    case 4:
    }
    while (true)
    {
      localTextView2.setText(str1);
      localTextView3.setText(str2);
      return;
      localTextView1.setText(2131493139);
      continue;
      localTextView1.setText(2131493140);
      continue;
      if (paramBarItem.index == this.K)
      {
        localTextView1.setText(2131493142);
      }
      else if (paramBarItem.index + paramBarItem.scope == this.L)
      {
        localTextView1.setText(2131493143);
      }
      else
      {
        localTextView1.setText(2131493141);
        continue;
        paramView.findViewById(2131165347).setVisibility(8);
        localTextView1.setText(2131493279);
      }
    }
  }

  private void a(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Log.d("Dynamic.Detail", "Current Sync Status : " + paramConnStatus);
    switch (paramConnStatus.a)
    {
    default:
      this.d.setText(Utils.getSyncTime(getActivity()));
      return;
    case 9:
      TextView localTextView2 = this.d;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(0);
      localTextView2.setText(getString(2131493149, arrayOfObject2));
      return;
    case 10:
    }
    TextView localTextView1 = this.d;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ((Integer)paramConnStatus.b);
    localTextView1.setText(getString(2131493149, arrayOfObject1));
  }

  private void a(String paramString)
  {
    this.c.setText(paramString);
  }

  private static int b(Calendar paramCalendar)
  {
    return 60 * paramCalendar.get(11) + paramCalendar.get(12);
  }

  private static Animator b(View paramView)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    AnimUtil.AnimSetBuilder.setFirstAnim(localObjectAnimator1);
    AnimUtil.AnimSetBuilder.addAnim(localObjectAnimator2);
    AnimUtil.AnimSetBuilder.addAnim(localObjectAnimator3);
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    return localAnimatorSet;
  }

  private ChartDataLoader.LoadCallback b()
  {
    return new P(this);
  }

  private void b(int paramInt)
  {
    SportDay localSportDay = DataManager.getInstance().getCurDay();
    DaySportData localDaySportData = DataManager.getInstance().get(localSportDay);
    ShareData localShareData;
    if (paramInt == 16)
    {
      ChartData.DynamicData localDynamicData = ChartData.getDynamicData();
      int i3 = localDynamicData.getSleepTime();
      localShareData = new ShareData(2);
      localShareData.title = getString(2131493201);
      localShareData.content = i3;
      this.r = this.p.getCurDay();
      localShareData.time = this.r.formatStringDay(getActivity());
      int i4 = localDynamicData.getSleepDeepTime();
      int i5 = localDynamicData.getSleepTime() - i4;
      Date localDate1 = localDynamicData.getSleepStartDate();
      Date localDate2 = localDynamicData.getSleepStopDate();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
      Object[] arrayOfObject4 = new Object[6];
      arrayOfObject4[0] = Integer.valueOf(i4 / 60);
      arrayOfObject4[1] = Integer.valueOf(i4 % 60);
      arrayOfObject4[2] = Integer.valueOf(i5 / 60);
      arrayOfObject4[3] = Integer.valueOf(i5 % 60);
      arrayOfObject4[4] = localSimpleDateFormat.format(localDate1);
      arrayOfObject4[5] = localSimpleDateFormat.format(localDate2);
      localShareData.description = getString(2131493217, arrayOfObject4);
    }
    while (true)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getActivity(), ShareActivity.class);
      localIntent.putExtra("share_data", localShareData);
      getActivity().startActivity(localIntent);
      return;
      if (paramInt == 1)
      {
        localShareData = new ShareData();
        if ("DynamicView".equals(this.w))
        {
          localShareData.setType(9);
          String str4 = getString(2131493244);
          switch (this.J)
          {
          default:
          case 0:
          case 2:
          case 1:
          }
          while (true)
          {
            Object[] arrayOfObject2 = new Object[1];
            Object[] arrayOfObject3 = new Object[2];
            arrayOfObject3[0] = ChartData.formatTime(this.x);
            arrayOfObject3[1] = ChartData.formatTime(this.y);
            arrayOfObject2[0] = getString(2131492893, arrayOfObject3);
            localShareData.title = getString(2131493137, arrayOfObject2);
            localShareData.content = this.A;
            localShareData.contentUnit = getString(2131492927);
            String[] arrayOfString2 = ChartData.formatDistance(getActivity(), this.B);
            localShareData.description = (new StringBuilder(String.valueOf(str4)).append(arrayOfString2[0]).append(arrayOfString2[1]).append("\n").toString() + this.I);
            localShareData.time = localSportDay.formatStringDay(getActivity());
            break;
            str4 = getString(2131493244);
            continue;
            str4 = getString(2131493303);
            continue;
            str4 = getString(2131493244);
          }
        }
        StepsInfo localStepsInfo;
        label592: String str2;
        if ((localDaySportData == null) || (localDaySportData.getStepsInfo() == null))
        {
          localStepsInfo = new StepsInfo();
          int i1 = localStepsInfo.getCalories();
          int i2 = Keeper.readPersonInfo().getDaySportGoalSteps();
          String[] arrayOfString1 = ChartData.formatDistance(getActivity(), localStepsInfo.getDistance());
          String str1 = arrayOfString1[0] + arrayOfString1[1];
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = str1;
          arrayOfObject1[1] = Integer.valueOf(i1);
          str2 = getString(2131493208, arrayOfObject1);
          if (i2 <= localStepsInfo.getStepsCount())
            break label792;
          localShareData = new ShareData(1);
          localShareData.title = getString(2131493207);
        }
        for (String str3 = str2 + getString(2131493009); ; str3 = str2 + getString(2131493008))
        {
          localShareData.content = localStepsInfo.getStepsCount();
          localShareData.description = str3;
          localShareData.contentUnit = getString(2131492927);
          break;
          localStepsInfo = localDaySportData.getStepsInfo();
          break label592;
          label792: localShareData = new ShareData(0);
          localShareData.title = getString(2131493205);
        }
      }
      localShareData = null;
    }
  }

  private Animator c(View paramView)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F });
    AnimUtil.AnimSetBuilder.setFirstAnim(localObjectAnimator1);
    AnimUtil.AnimSetBuilder.addAnim(localObjectAnimator2);
    AnimUtil.AnimSetBuilder.addAnim(localObjectAnimator3);
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.setStartDelay(600L);
    localAnimatorSet.setInterpolator(new AccelerateInterpolator(2.0F));
    localAnimatorSet.addListener(new R(this, paramView));
    return localAnimatorSet;
  }

  private ShareData c(int paramInt)
  {
    SportDay localSportDay = DataManager.getInstance().getCurDay();
    DaySportData localDaySportData = DataManager.getInstance().get(localSportDay);
    if (paramInt == 16)
    {
      ChartData.DynamicData localDynamicData = ChartData.getDynamicData();
      int i3 = localDynamicData.getSleepTime();
      ShareData localShareData2 = new ShareData(2);
      localShareData2.title = getString(2131493201);
      localShareData2.content = i3;
      this.r = this.p.getCurDay();
      localShareData2.time = this.r.formatStringDay(getActivity());
      int i4 = localDynamicData.getSleepDeepTime();
      int i5 = localDynamicData.getSleepTime() - i4;
      Date localDate1 = localDynamicData.getSleepStartDate();
      Date localDate2 = localDynamicData.getSleepStopDate();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
      Object[] arrayOfObject4 = new Object[6];
      arrayOfObject4[0] = Integer.valueOf(i4 / 60);
      arrayOfObject4[1] = Integer.valueOf(i4 % 60);
      arrayOfObject4[2] = Integer.valueOf(i5 / 60);
      arrayOfObject4[3] = Integer.valueOf(i5 % 60);
      arrayOfObject4[4] = localSimpleDateFormat.format(localDate1);
      arrayOfObject4[5] = localSimpleDateFormat.format(localDate2);
      localShareData2.description = getString(2131493217, arrayOfObject4);
      return localShareData2;
    }
    if (paramInt == 1)
    {
      ShareData localShareData1 = new ShareData();
      if ("DynamicView".equals(this.w))
      {
        localShareData1.setType(9);
        String str4 = getString(2131493244);
        switch (this.J)
        {
        default:
        case 0:
        case 2:
        case 1:
        }
        while (true)
        {
          Object[] arrayOfObject2 = new Object[1];
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = ChartData.formatTime(this.x);
          arrayOfObject3[1] = ChartData.formatTime(this.y);
          arrayOfObject2[0] = getString(2131492893, arrayOfObject3);
          localShareData1.title = getString(2131493137, arrayOfObject2);
          localShareData1.content = this.A;
          localShareData1.contentUnit = getString(2131492927);
          String[] arrayOfString2 = ChartData.formatDistance(getActivity(), this.B);
          localShareData1.description = (new StringBuilder(String.valueOf(str4)).append(arrayOfString2[0]).append(arrayOfString2[1]).append("\n").toString() + this.I);
          localShareData1.time = localSportDay.formatStringDay(getActivity());
          return localShareData1;
          str4 = getString(2131493244);
          continue;
          str4 = getString(2131493303);
          continue;
          str4 = getString(2131493244);
        }
      }
      StepsInfo localStepsInfo;
      label552: String str2;
      if ((localDaySportData == null) || (localDaySportData.getStepsInfo() == null))
      {
        localStepsInfo = new StepsInfo();
        int i1 = localStepsInfo.getCalories();
        int i2 = Keeper.readPersonInfo().getDaySportGoalSteps();
        String[] arrayOfString1 = ChartData.formatDistance(getActivity(), localStepsInfo.getDistance());
        String str1 = arrayOfString1[0] + arrayOfString1[1];
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = str1;
        arrayOfObject1[1] = Integer.valueOf(i1);
        str2 = getString(2131493208, arrayOfObject1);
        if (i2 <= localStepsInfo.getStepsCount())
          break label752;
        localShareData1 = new ShareData(1);
        localShareData1.title = getString(2131493207);
      }
      for (String str3 = str2 + getString(2131493009); ; str3 = str2 + getString(2131493008))
      {
        localShareData1.content = localStepsInfo.getStepsCount();
        localShareData1.description = str3;
        localShareData1.contentUnit = getString(2131492927);
        break;
        localStepsInfo = localDaySportData.getStepsInfo();
        break label552;
        label752: localShareData1 = new ShareData(0);
        localShareData1.title = getString(2131493205);
      }
    }
    return null;
  }

  private void c()
  {
    if ((this.E != null) && (this.E.isStarted()))
      return;
    this.k.setScrollable(false);
    this.i.setVisibility(4);
    this.j.setVisibility(4);
    this.H = false;
    if (this.v == 16)
      this.v = 1;
    while (true)
    {
      a(this.v, false);
      return;
      if (this.v == 1)
        this.v = 16;
    }
  }

  private static String[] d(int paramInt)
  {
    String[] arrayOfString = new String[2];
    if (paramInt < 100);
    for (String str = String.valueOf(paramInt); ; str = String.valueOf(paramInt))
    {
      arrayOfString[0] = str;
      return arrayOfString;
    }
  }

  protected String formatTime(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
      return "00:00";
    if (paramInt2 < 10)
      return paramInt1 + ":0" + paramInt2;
    return paramInt1 + ":" + paramInt2;
  }

  protected String[] formatTimeHourMin(int paramInt)
  {
    int i1 = paramInt / 60;
    int i2 = paramInt % 60;
    String[] arrayOfString = new String[2];
    if (i1 > 0)
      arrayOfString[0] = String.valueOf(i1);
    arrayOfString[1] = String.valueOf(i2);
    return arrayOfString;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    View localView = getView();
    this.b = localView.findViewById(2131165229);
    this.c = ((TextView)localView.findViewById(2131165230));
    this.c.setOnClickListener(this);
    this.d = ((TextView)localView.findViewById(2131165341));
    this.e = localView.findViewById(2131165342);
    this.e.setOnClickListener(this);
    this.f = ((ImageButton)localView.findViewById(2131165344));
    this.f.setOnClickListener(this);
    this.g = localView.findViewById(2131165359);
    this.h = localView.findViewById(2131165370);
    this.i = localView.findViewById(2131165345);
    this.j = localView.findViewById(2131165350);
    this.k = ((DynamicDetailChartView)localView.findViewById(2131165339));
    this.l = ((TextView)localView.findViewById(2131165343));
    this.m = localView.findViewById(2131165364);
    this.n = localView.findViewById(2131165367);
    this.m.setVisibility(0);
    this.n.setVisibility(0);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    new GestureDetector(getActivity(), new M(this));
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new P(this));
    this.k.setDataLoader(localAsyncChartDataLoader);
    this.k.setScrollable(true);
    if (("DynamicView".equals(this.w)) && (this.v == 1))
    {
      this.k.setScrollable(false);
      ((View)this.f.getParent()).setVisibility(8);
    }
    this.k.attach();
    sRefreshHander = new L(this);
    a(this.v, true);
    EventBus.getDefault().register(this);
    if ("RefCompleteGoal".equals(this.w))
    {
      b(this.v);
      getActivity().finish();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131165230:
    case 2131165342:
    case 2131165344:
      do
      {
        return;
        getActivity().finish();
        return;
        b(this.v);
        return;
      }
      while ((this.E != null) && (this.E.isStarted()));
      this.k.setScrollable(false);
      this.i.setVisibility(4);
      this.j.setVisibility(4);
      this.H = false;
      if (this.v == 16)
        this.v = 1;
      while (true)
      {
        a(this.v, false);
        return;
        if (this.v == 1)
          this.v = 16;
      }
    case 2131165364:
      a(1, this.r);
      return;
    case 2131165367:
    }
    a(16, this.r);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.v = localBundle.getInt("Mode");
      Debug.i("Dynamic.Detail", "Mode : " + this.v);
      this.J = localBundle.getInt("DynamicActivityMode");
      this.w = localBundle.getString("Action");
      this.x = localBundle.getInt("DynamicStartTime");
      this.I = localBundle.getString("DynamicActivitySubTitle");
      this.y = localBundle.getInt("DynamicEndTime");
      this.z = localBundle.getInt("DynamicActiveTime");
      this.A = localBundle.getInt("DynamicStep");
      this.B = localBundle.getInt("DynamicStepDistance");
    }
    Resources localResources = getActivity().getResources();
    this.C = localResources.getColor(2131230772);
    this.D = localResources.getColor(2131230773);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903071, paramViewGroup, false);
  }

  public void onDestroy()
  {
    sRefreshHander = null;
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  public void onDetach()
  {
    super.onDetach();
    this.k.detach();
  }

  public void onEvent(EventDynamicDetailSleepUserModified paramEventDynamicDetailSleepUserModified)
  {
    Debug.i("Dynamic.Detail", "User Modified : Reload!!");
    sRefreshHander.sendEmptyMessage(0);
  }

  public void onEvent(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Debug.i("Dynamic.Detail", "On BLE Status Changed : " + paramConnStatus.a);
    if (isVisible())
    {
      a(paramConnStatus);
      if ((paramConnStatus.a == 11) && (((Boolean)paramConnStatus.b).booleanValue()))
        sRefreshHander.sendEmptyMessage(0);
    }
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageDynamicDetail");
  }

  public void onResume()
  {
    super.onResume();
    a(BaseSCActivity.mConnStatus);
    UmengAnalytics.startPage("PageDynamicDetail");
  }

  public void onStop()
  {
    super.onStop();
    if ((this.G != null) && (this.G.isStarted()))
      this.G.end();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicDetailFragment
 * JD-Core Version:    0.6.2
 */