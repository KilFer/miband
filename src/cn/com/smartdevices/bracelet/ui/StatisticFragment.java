package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.StatisticChart.StatisticBarItem;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.model.SportDay;
import de.greenrobot.event.EventBus;
import java.util.HashMap;

public class StatisticFragment extends Fragment
  implements View.OnClickListener
{
  private static final String a = "Statistic.Main";
  private static final int b = 1;
  private static final int c = 16;
  private static final int d = 256;
  private static final int e = 11;
  private static final int f = 7;
  private static final int g = 5;
  private boolean A;
  private String B;
  private String C;
  private HashMap<String, DaySportData.Summary> D;
  private View E;
  private TextView F;
  private TextView G;
  private View H;
  private StatisticChartView I;
  private StatisticChartView J;
  private StatisticChartView K;
  private StatisticChartView L;
  private ImageButton M;
  private View N;
  private View O;
  private SparseArray<View> P;
  private SparseArray<View> Q;
  private View R;
  private View S;
  private int T;
  private int U;
  private Animator V;
  private Animator W;
  private boolean X;
  private boolean Y;
  private SportDay Z;
  private int aa;
  private int h;
  private int i;
  private DataManager j;
  private SportDay k;
  private SportDay l;
  private SportDay m;
  private SportDay n;
  private SportDay o;
  private SportDay p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private BarChart.BarItem v;
  private bM w;
  private SparseArray<bM> x;
  private ChartDataLoader.LoadCallback y;
  private SparseArray<ChartDataLoader> z;

  private Animator a(int paramInt1, int paramInt2, long paramLong)
  {
    Animator localAnimator = this.K.animRefreshTo(325L, 0.0F, 0.0F);
    localAnimator.addListener(new bI(this, 650L));
    localAnimator.setInterpolator(new AccelerateInterpolator(1.5F));
    AnimUtil.AnimSetBuilder.setFirstAnim(localAnimator);
    View[] arrayOfView = new View[2];
    arrayOfView[0] = this.E;
    arrayOfView[1] = ((View)this.K.getParent());
    AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(paramInt1, paramInt2, arrayOfView), 432L);
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.addListener(new bJ(this));
    return localAnimatorSet;
  }

  private Animator a(StatisticChartView paramStatisticChartView1, StatisticChartView paramStatisticChartView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Animator localAnimator1 = AnimUtil.animScaleX(paramStatisticChartView1, paramInt1 / paramInt2, 1.0F);
    Animator localAnimator2 = AnimUtil.animScaleX(paramStatisticChartView2, 1.0F, paramInt2 / paramInt1);
    Animator localAnimator3 = AnimUtil.animFade(paramStatisticChartView2, 1.0F, 0.0F);
    AnimUtil.AnimSetBuilder.setFirstAnim(localAnimator1, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(localAnimator2, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(localAnimator3, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(paramStatisticChartView1.animRefresh(paramInt5, paramInt3, paramInt4));
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.addListener(new bK(this, paramStatisticChartView1, paramStatisticChartView2));
    return localAnimatorSet;
  }

  private void a()
  {
    AnimUtil.dismissChildren((ViewGroup)this.P.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(256));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(256));
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1;
    if (paramInt1 == 16)
      localView1 = (View)this.P.get(paramInt3);
    while (true)
    {
      label19: View localView2;
      if (paramInt2 == 16)
      {
        localView2 = (View)this.P.get(paramInt4);
        label39: switch (paramInt4)
        {
        default:
        case 1:
        case 16:
        case 256:
        }
      }
      StatisticChartView localStatisticChartView2;
      while (true)
      {
        this.w = ((bM)this.x.get(paramInt4));
        this.S = localView1;
        this.R = localView2;
        StatisticChartView localStatisticChartView1 = this.K;
        ChartDataLoader.LoadCallback localLoadCallback = this.y;
        ChartDataLoader localChartDataLoader = (ChartDataLoader)this.z.get(paramInt4);
        localChartDataLoader.setLoadCallback(localLoadCallback);
        localStatisticChartView1.setDataLoader(localChartDataLoader);
        localStatisticChartView2 = this.K;
        switch (paramInt4)
        {
        default:
          return;
          if (paramInt1 != 1)
            break label410;
          localView1 = (View)this.Q.get(paramInt3);
          break label19;
          localView2 = null;
          if (paramInt2 != 1)
            break label39;
          localView2 = (View)this.Q.get(paramInt4);
          break label39;
          this.O.setEnabled(true);
          this.N.setEnabled(false);
          HashMap localHashMap3 = new HashMap();
          localHashMap3.put("level", "EventStatisticLevelDaily");
          UmengAnalytics.event(getActivity(), "EventStatistic", localHashMap3);
          continue;
          this.O.setEnabled(true);
          this.N.setEnabled(true);
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put("level", "EventStatisticLevelWeekly");
          UmengAnalytics.event(getActivity(), "EventStatistic", localHashMap2);
          continue;
          this.O.setEnabled(false);
          this.N.setEnabled(true);
          HashMap localHashMap1 = new HashMap();
          localHashMap1.put("level", "EventStatisticLevelMonthly");
          UmengAnalytics.event(getActivity(), "EventStatistic", localHashMap1);
        case 1:
        case 16:
        case 256:
        }
      }
      localStatisticChartView2.updateBarItemCount(11);
      return;
      localStatisticChartView2.updateBarItemCount(7);
      return;
      localStatisticChartView2.updateBarItemCount(5);
      return;
      label410: localView1 = null;
    }
  }

  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.h, this.h, paramInt1, paramInt2);
  }

  private static void a(int paramInt, ChartDataLoader.LoadCallback paramLoadCallback, SparseArray<ChartDataLoader> paramSparseArray)
  {
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(paramLoadCallback);
    paramSparseArray.put(paramInt, localAsyncChartDataLoader);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int i2;
    int i1;
    if (paramInt == 16)
    {
      this.M.setImageResource(2130837540);
      int i5 = this.U;
      int i6 = this.T;
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("mode", "EventModeSleep");
      UmengAnalytics.event(getActivity(), "EventStatistic", localHashMap2);
      i2 = i5;
      i1 = i6;
    }
    while (true)
    {
      if (paramBoolean)
      {
        this.E.setBackgroundColor(i1);
        ((View)this.K.getParent()).setBackgroundColor(i1);
        this.I.setMode(paramInt);
        this.J.setMode(paramInt);
      }
      while (true)
      {
        a(this.m);
        return;
        if (paramInt != 1)
          break label314;
        this.M.setImageResource(2130837537);
        int i3 = this.T;
        int i4 = this.U;
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("mode", "EventModeStep");
        UmengAnalytics.event(getActivity(), "EventStatistic", localHashMap1);
        i2 = i3;
        i1 = i4;
        break;
        Animator localAnimator = this.K.animRefreshTo(325L, 0.0F, 0.0F);
        localAnimator.addListener(new bI(this, 650L));
        localAnimator.setInterpolator(new AccelerateInterpolator(1.5F));
        AnimUtil.AnimSetBuilder.setFirstAnim(localAnimator);
        View[] arrayOfView = new View[2];
        arrayOfView[0] = this.E;
        arrayOfView[1] = ((View)this.K.getParent());
        AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animColorTrans(i2, i1, arrayOfView), 432L);
        AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
        localAnimatorSet.addListener(new bJ(this));
        this.V = localAnimatorSet;
        this.V.start();
      }
      label314: i1 = 0;
      i2 = 0;
    }
  }

  private void a(View paramView)
  {
    this.E = paramView.findViewById(2131165229);
    this.F = ((TextView)paramView.findViewById(2131165230));
    this.F.setOnClickListener(this);
    this.G = ((TextView)paramView.findViewById(2131165341));
    this.H = paramView.findViewById(2131165342);
    this.H.setOnClickListener(this);
    this.I = ((StatisticChartView)paramView.findViewById(2131165461));
    this.J = ((StatisticChartView)paramView.findViewById(2131165462));
    this.M = ((ImageButton)paramView.findViewById(2131165344));
    this.M.setOnClickListener(this);
    this.O = paramView.findViewById(2131165469);
    this.N = paramView.findViewById(2131165470);
    this.O.setOnClickListener(this);
    this.N.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131165463);
    View localView2 = paramView.findViewById(2131165464);
    View localView3 = paramView.findViewById(2131165465);
    View localView4 = paramView.findViewById(2131165466);
    View localView5 = paramView.findViewById(2131165467);
    View localView6 = paramView.findViewById(2131165468);
    this.P = new SparseArray(3);
    this.Q = new SparseArray(3);
    this.P.put(1, localView1);
    this.P.put(16, localView2);
    this.P.put(256, localView3);
    this.Q.put(1, localView4);
    this.Q.put(16, localView5);
    this.Q.put(256, localView6);
    AnimUtil.dismissChildren((ViewGroup)this.P.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(256));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(256));
  }

  private static void a(StatisticChartView paramStatisticChartView, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramStatisticChartView.updateBarItemCount(11);
      return;
    case 16:
      paramStatisticChartView.updateBarItemCount(7);
      return;
    case 256:
    }
    paramStatisticChartView.updateBarItemCount(5);
  }

  private void a(StatisticChartView paramStatisticChartView, ChartDataLoader.LoadCallback paramLoadCallback, int paramInt)
  {
    ChartDataLoader localChartDataLoader = (ChartDataLoader)this.z.get(paramInt);
    localChartDataLoader.setLoadCallback(paramLoadCallback);
    paramStatisticChartView.setDataLoader(localChartDataLoader);
  }

  private void a(SportDay paramSportDay)
  {
    String str1;
    if (this.h == 16)
    {
      if (this.w == null)
        break label197;
      String str3 = this.B;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.w.a(paramSportDay);
      str1 = String.format(str3, arrayOfObject2);
    }
    while (true)
    {
      if (((this.i == 1) && (paramSportDay.equals(this.k))) || ((this.i == 16) && (paramSportDay.offsetWeek(this.k) == 0)) || ((this.i == 256) && (paramSportDay.offsetMonth(this.k) == 0)))
        ((View)this.G.getParent()).setVisibility(0);
      while (true)
      {
        this.F.setText(str1);
        return;
        if ((this.h != 1) || (this.w == null))
          break label197;
        String str2 = this.C;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.w.a(paramSportDay);
        str1 = String.format(str2, arrayOfObject1);
        break;
        ((View)this.G.getParent()).setVisibility(8);
      }
      label197: str1 = null;
    }
  }

  private void a(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Log.d("Statistic.Main", "Current Sync Status : " + paramConnStatus);
    switch (paramConnStatus.a)
    {
    default:
      this.G.setText(Utils.getSyncTime(getActivity()));
      return;
    case 9:
      TextView localTextView2 = this.G;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(0);
      localTextView2.setText(getString(2131493149, arrayOfObject2));
      return;
    case 10:
    }
    TextView localTextView1 = this.G;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ((Integer)paramConnStatus.b);
    localTextView1.setText(getString(2131493149, arrayOfObject1));
  }

  private void a(String paramString)
  {
    this.F.setText(paramString);
  }

  private Animator b(StatisticChartView paramStatisticChartView1, StatisticChartView paramStatisticChartView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    float f1 = paramInt1 / paramInt2;
    Animator localAnimator1 = AnimUtil.animFade(paramStatisticChartView1, 0.0F, 1.0F);
    Animator localAnimator2 = AnimUtil.animScaleX(paramStatisticChartView1, f1, 1.0F);
    Animator localAnimator3 = AnimUtil.animScaleX(paramStatisticChartView2, 1.0F, paramInt2 / paramInt1);
    AnimUtil.AnimSetBuilder.setFirstAnim(localAnimator2, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(localAnimator1, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(localAnimator3, paramInt5);
    AnimUtil.AnimSetBuilder.addAnim(paramStatisticChartView2.animRefreshTo(paramInt5, paramInt3, paramInt4));
    AnimatorSet localAnimatorSet = AnimUtil.AnimSetBuilder.build();
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.addListener(new bL(this, paramStatisticChartView1, paramStatisticChartView2));
    return localAnimatorSet;
  }

  private void b()
  {
    this.y = new bH(this);
    this.z = new SparseArray(3);
    a(1, this.y, this.z);
    a(16, this.y, this.z);
    a(256, this.y, this.z);
    int i1 = Keeper.readPersonInfo().getDaySportGoalSteps();
    this.I.setScrollable(true);
    this.I.setStepGoal(i1);
    this.J.setScrollable(true);
    this.J.setStepGoal(i1);
    this.I.attach();
    this.J.attach();
    this.J.setVisibility(4);
    this.K = this.I;
    this.x = new SparseArray(3);
    this.x.put(1, new bN(this));
    this.x.put(16, new bP(this));
    this.x.put(256, new bO(this));
  }

  private void b(int paramInt, boolean paramBoolean)
  {
    a(this.h, this.h, paramInt, paramInt);
  }

  private ChartDataLoader.LoadCallback c()
  {
    return new bH(this);
  }

  private void d()
  {
    ShareData localShareData = this.w.a(this.m, this.h);
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), ShareActivity.class);
    localIntent.putExtra("share_data", localShareData);
    getActivity().startActivity(localIntent);
  }

  private ShareData e()
  {
    return this.w.a(this.m, this.h);
  }

  private void f()
  {
    if ((this.V != null) && (this.V.isStarted()));
    while ((this.W != null) && (this.W.isStarted()))
      return;
    this.I.setScrollable(false);
    this.J.setScrollable(false);
    int i1 = this.h;
    if (i1 == 16)
      this.h = 1;
    while (true)
    {
      a(this.h, this.A);
      int i2 = this.h;
      int i3 = this.i;
      int i4 = this.i;
      a(i1, i2, i3, i4);
      AnimUtil.animInfoSwitch((ViewGroup)this.S, (ViewGroup)this.R);
      return;
      if (i1 == 1)
        this.h = 16;
    }
  }

  private void g()
  {
    if ((this.W != null) && (this.W.isStarted()));
    while ((this.V != null) && (this.V.isStarted()))
      return;
    this.v = this.K.getBarItem(this.h, this.q);
    int i1;
    if (this.v != null)
    {
      this.t = ((int)this.v.getRect().height());
      int i2 = this.v.value;
      int i3 = ((StatisticChart.StatisticBarItem)this.v).value1;
      this.u = ((int)(this.t * (i3 / i2)));
      Debug.i("Statistic.Main", "BarItem Height : " + this.t);
      i1 = this.i;
      if (this.i != 256)
        break label321;
      this.i = 16;
      this.s = this.m.offsetWeek(this.l);
      Debug.i("Statistic.Main", "Offset Week From Month : " + this.s);
      this.K = this.J;
      this.L = this.I;
    }
    while (true)
    {
      if (this.q != this.r)
        this.p = this.m;
      this.r = 2147483647;
      a(i1, this.i, this.A);
      this.I.setScrollable(false);
      this.J.setScrollable(false);
      this.K.clearData();
      this.K.loadStatisticData(this.s);
      this.K.offsetTo(this.s);
      this.X = true;
      this.Y = true;
      return;
      this.t = 0;
      this.u = 0;
      break;
      label321: if (this.i == 16)
      {
        this.i = 1;
        this.s = this.m.offsetDay(this.l);
        Debug.i("Statistic.Main", "Offset Day : " + this.s);
        this.K = this.I;
        this.L = this.J;
      }
    }
  }

  private void h()
  {
    if ((this.W != null) && (this.W.isStarted()));
    while ((this.V != null) && (this.V.isStarted()))
      return;
    int i1 = this.i;
    if (this.i == 1)
    {
      this.i = 16;
      this.s = this.m.offsetWeek(this.l);
      Debug.i("Statistic.Main", "Offset Week From Day : " + this.s);
      this.K = this.J;
      this.L = this.I;
    }
    while (true)
    {
      this.q = 2147483647;
      this.r = 2147483647;
      this.p = this.m;
      a(i1, this.i, this.A);
      this.I.setScrollable(false);
      this.J.setScrollable(false);
      this.K.clearData();
      this.K.loadStatisticData(this.s);
      this.K.offsetTo(this.s);
      this.X = true;
      this.Y = false;
      return;
      if (this.i == 16)
      {
        this.i = 256;
        this.s = this.m.offsetMonth(this.l);
        Debug.i("Statistic.Main", "Offset Month : " + this.s);
        this.K = this.I;
        this.L = this.J;
      }
    }
  }

  private void i()
  {
    Debug.i("Statistic.Main", "Current Index : " + this.q + " Last Index : " + this.r);
    Debug.i("Statistic.Main", "Current Day : " + this.m + " Last Day : " + this.p);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    View localView1 = getView();
    this.E = localView1.findViewById(2131165229);
    this.F = ((TextView)localView1.findViewById(2131165230));
    this.F.setOnClickListener(this);
    this.G = ((TextView)localView1.findViewById(2131165341));
    this.H = localView1.findViewById(2131165342);
    this.H.setOnClickListener(this);
    this.I = ((StatisticChartView)localView1.findViewById(2131165461));
    this.J = ((StatisticChartView)localView1.findViewById(2131165462));
    this.M = ((ImageButton)localView1.findViewById(2131165344));
    this.M.setOnClickListener(this);
    this.O = localView1.findViewById(2131165469);
    this.N = localView1.findViewById(2131165470);
    this.O.setOnClickListener(this);
    this.N.setOnClickListener(this);
    View localView2 = localView1.findViewById(2131165463);
    View localView3 = localView1.findViewById(2131165464);
    View localView4 = localView1.findViewById(2131165465);
    View localView5 = localView1.findViewById(2131165466);
    View localView6 = localView1.findViewById(2131165467);
    View localView7 = localView1.findViewById(2131165468);
    this.P = new SparseArray(3);
    this.Q = new SparseArray(3);
    this.P.put(1, localView2);
    this.P.put(16, localView3);
    this.P.put(256, localView4);
    this.Q.put(1, localView5);
    this.Q.put(16, localView6);
    this.Q.put(256, localView7);
    AnimUtil.dismissChildren((ViewGroup)this.P.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.P.get(256));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(1));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(16));
    AnimUtil.dismissChildren((ViewGroup)this.Q.get(256));
    this.y = new bH(this);
    this.z = new SparseArray(3);
    a(1, this.y, this.z);
    a(16, this.y, this.z);
    a(256, this.y, this.z);
    int i1 = Keeper.readPersonInfo().getDaySportGoalSteps();
    this.I.setScrollable(true);
    this.I.setStepGoal(i1);
    this.J.setScrollable(true);
    this.J.setStepGoal(i1);
    this.I.attach();
    this.J.attach();
    this.J.setVisibility(4);
    this.K = this.I;
    this.x = new SparseArray(3);
    this.x.put(1, new bN(this));
    this.x.put(16, new bP(this));
    this.x.put(256, new bO(this));
    this.A = true;
    a(this.h, this.A);
    int i2 = this.i;
    a(this.h, this.h, i2, i2);
    this.K.clearData();
    this.K.loadStatisticData(0);
    EventBus.getDefault().register(this);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131165230:
    case 2131165342:
    case 2131165344:
    case 2131165469:
    case 2131165470:
    }
    do
    {
      do
      {
        do
        {
          return;
          getActivity().finish();
          return;
          ShareData localShareData = this.w.a(this.m, this.h);
          Intent localIntent = new Intent();
          localIntent.setClass(getActivity(), ShareActivity.class);
          localIntent.putExtra("share_data", localShareData);
          getActivity().startActivity(localIntent);
          return;
        }
        while (((this.V != null) && (this.V.isStarted())) || ((this.W != null) && (this.W.isStarted())));
        this.I.setScrollable(false);
        this.J.setScrollable(false);
        int i5 = this.h;
        if (i5 == 16)
          this.h = 1;
        while (true)
        {
          a(this.h, this.A);
          int i6 = this.h;
          int i7 = this.i;
          int i8 = this.i;
          a(i5, i6, i7, i8);
          AnimUtil.animInfoSwitch((ViewGroup)this.S, (ViewGroup)this.R);
          return;
          if (i5 == 1)
            this.h = 16;
        }
      }
      while (((this.W != null) && (this.W.isStarted())) || ((this.V != null) && (this.V.isStarted())));
      int i4 = this.i;
      if (this.i == 1)
      {
        this.i = 16;
        this.s = this.m.offsetWeek(this.l);
        Debug.i("Statistic.Main", "Offset Week From Day : " + this.s);
        this.K = this.J;
        this.L = this.I;
      }
      while (true)
      {
        this.q = 2147483647;
        this.r = 2147483647;
        this.p = this.m;
        a(i4, this.i, this.A);
        this.I.setScrollable(false);
        this.J.setScrollable(false);
        this.K.clearData();
        this.K.loadStatisticData(this.s);
        this.K.offsetTo(this.s);
        this.X = true;
        this.Y = false;
        return;
        if (this.i == 16)
        {
          this.i = 256;
          this.s = this.m.offsetMonth(this.l);
          Debug.i("Statistic.Main", "Offset Month : " + this.s);
          this.K = this.I;
          this.L = this.J;
        }
      }
    }
    while (((this.W != null) && (this.W.isStarted())) || ((this.V != null) && (this.V.isStarted())));
    this.v = this.K.getBarItem(this.h, this.q);
    int i1;
    if (this.v != null)
    {
      this.t = ((int)this.v.getRect().height());
      int i2 = this.v.value;
      int i3 = ((StatisticChart.StatisticBarItem)this.v).value1;
      this.u = ((int)(this.t * (i3 / i2)));
      Debug.i("Statistic.Main", "BarItem Height : " + this.t);
      i1 = this.i;
      if (this.i != 256)
        break label872;
      this.i = 16;
      this.s = this.m.offsetWeek(this.l);
      Debug.i("Statistic.Main", "Offset Week From Month : " + this.s);
      this.K = this.J;
      this.L = this.I;
    }
    while (true)
    {
      if (this.q != this.r)
        this.p = this.m;
      this.r = 2147483647;
      a(i1, this.i, this.A);
      this.I.setScrollable(false);
      this.J.setScrollable(false);
      this.K.clearData();
      this.K.loadStatisticData(this.s);
      this.K.offsetTo(this.s);
      this.X = true;
      this.Y = true;
      return;
      this.t = 0;
      this.u = 0;
      break;
      label872: if (this.i == 16)
      {
        this.i = 1;
        this.s = this.m.offsetDay(this.l);
        Debug.i("Statistic.Main", "Offset Day : " + this.s);
        this.K = this.I;
        this.L = this.J;
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.h = localBundle.getInt("Mode", 1);
      Debug.i("Statistic.Main", "Mode : " + this.h);
    }
    this.i = 1;
    this.j = DataManager.getInstance();
    this.k = this.j.getToday();
    this.l = this.j.getCurDay();
    this.n = this.j.getStartDay();
    this.o = this.j.getStopDay();
    this.m = this.l;
    Debug.i("Statistic.Main", "Today : " + this.k + " , StartDay : " + this.n + " , StopDay : " + this.o + " , CurrentDay : " + this.m);
    this.B = getString(2131493134);
    this.C = getString(2131493136);
    this.D = new HashMap();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903108, paramViewGroup, false);
    Resources localResources = getActivity().getResources();
    this.T = localResources.getColor(2131230772);
    this.U = localResources.getColor(2131230773);
    return localView;
  }

  public void onDestroy()
  {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  public void onDetach()
  {
    super.onDetach();
    this.I.detach();
    this.J.detach();
  }

  public void onEvent(BaseSCActivity.ConnStatus paramConnStatus)
  {
    Debug.i("Statistic.Main", "On BLE Status Changed : " + paramConnStatus.a);
    if (isVisible())
    {
      a(paramConnStatus);
      if ((paramConnStatus.a == 11) && (((Boolean)paramConnStatus.b).booleanValue()))
      {
        this.A = true;
        this.D.clear();
        ChartDataLoader localChartDataLoader = this.K.getDataLoader();
        localChartDataLoader.cancel();
        localChartDataLoader.clearData();
        this.K.clearData();
        this.K.loadStatisticData(0);
      }
    }
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageStatistic");
  }

  public void onResume()
  {
    super.onResume();
    a(BaseSCActivity.mConnStatus);
    UmengAnalytics.startPage("PageStatistic");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.StatisticFragment
 * JD-Core Version:    0.6.2
 */