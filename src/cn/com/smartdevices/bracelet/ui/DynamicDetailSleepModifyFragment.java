package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify;
import cn.com.smartdevices.bracelet.eventbus.EventDynamicDetailSleepUserModified;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicDetailSleepModifyFragment extends DimPanelFragment
  implements OnWheelChangedListener
{
  private static final String a = "Dynamic.Detail.SleepModify";
  private TextView b;
  private TextView c;
  private WheelView d;
  private WheelView e;
  private SportDay f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;

  private int a()
  {
    return this.d.getCurrentItem() + this.h;
  }

  private static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      return -1440 + (paramInt2 + 60 * (paramInt1 + 24));
    return paramInt2 + paramInt1 * 60;
  }

  private void a(int paramInt)
  {
    this.d.setCurrentItem(paramInt - this.h);
  }

  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131165378));
    this.c = ((TextView)paramView.findViewById(2131165379));
    this.d = ((WheelView)paramView.findViewById(2131165380));
    this.e = ((WheelView)paramView.findViewById(2131165381));
    Bundle localBundle = getArguments();
    this.f = ((SportDay)localBundle.getSerializable("CurrentDay"));
    this.g = localBundle.getInt("Type");
    this.h = localBundle.getInt("MinHour");
    this.i = localBundle.getInt("MaxHour");
    this.j = localBundle.getInt("CurrentHour");
    this.k = localBundle.getInt("CurrentMinute");
    this.l = localBundle.getInt("LimitStart");
    this.m = localBundle.getInt("LimitEnd");
    switch (this.g)
    {
    default:
      if (this.j >= 0)
        this.c.setText(2131492887);
      break;
    case 1:
    case 16:
    }
    while (true)
    {
      PickAdapter localPickAdapter1 = new PickAdapter(getActivity(), this.h, this.i, this.d, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, false, 46, 8, 7, 7, 1);
      localPickAdapter1.setMode(9);
      this.d.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493085), 2131230780, 18.0F).setViewAdapter(localPickAdapter1);
      a(this.j);
      this.d.addChangingListener(this);
      PickAdapter localPickAdapter2 = new PickAdapter(getActivity(), 0, 59, this.e, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, true, 46, 8, 7, 7, 1);
      this.e.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493075), 2131230780, 18.0F).setViewAdapter(localPickAdapter2);
      b(this.k);
      this.e.addChangingListener(this);
      return;
      this.b.setText(2131493151);
      break;
      this.b.setText(2131493152);
      break;
      this.c.setText(2131492888);
    }
  }

  private static void a(DaySportData paramDaySportData)
  {
    if (paramDaySportData == null)
      return;
    SleepInfo localSleepInfo = paramDaySportData.getSleepInfo();
    if (localSleepInfo == null)
      localSleepInfo = new SleepInfo();
    ChartData.DynamicData localDynamicData = ChartData.getDynamicData();
    localDynamicData.setSleepTime(localSleepInfo.getSleepCount());
    localDynamicData.setSleepDeepTime(localSleepInfo.getNonRemCount());
    localDynamicData.setSleepStartDate(localSleepInfo.getStartDate());
    localDynamicData.setSleepStopDate(localSleepInfo.getStopDate());
  }

  private int b()
  {
    return this.e.getCurrentItem() % 60;
  }

  private void b(int paramInt)
  {
    this.e.setCurrentItemLooped(paramInt);
  }

  private void b(DaySportData paramDaySportData)
  {
    if (paramDaySportData == null)
      return;
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("date", this.f.getKey());
      localJSONObject.put("summary", paramDaySportData.getSummary());
      localJSONArray.put(localJSONObject);
      WebAPI.syncSummaryToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, localJSONArray.toString(), new S(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private static int[] c(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt < 0)
    {
      arrayOfInt[0] = (-1 + (paramInt + 1) / 60);
      arrayOfInt[1] = (paramInt % 60);
      if (arrayOfInt[1] != 0)
        arrayOfInt[1] = (60 + arrayOfInt[1]);
      return arrayOfInt;
    }
    arrayOfInt[0] = (paramInt / 60);
    arrayOfInt[1] = (paramInt % 60);
    return arrayOfInt;
  }

  protected int inflateLayout()
  {
    return 2130903076;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    View localView = getView();
    this.b = ((TextView)localView.findViewById(2131165378));
    this.c = ((TextView)localView.findViewById(2131165379));
    this.d = ((WheelView)localView.findViewById(2131165380));
    this.e = ((WheelView)localView.findViewById(2131165381));
    Bundle localBundle = getArguments();
    this.f = ((SportDay)localBundle.getSerializable("CurrentDay"));
    this.g = localBundle.getInt("Type");
    this.h = localBundle.getInt("MinHour");
    this.i = localBundle.getInt("MaxHour");
    this.j = localBundle.getInt("CurrentHour");
    this.k = localBundle.getInt("CurrentMinute");
    this.l = localBundle.getInt("LimitStart");
    this.m = localBundle.getInt("LimitEnd");
    switch (this.g)
    {
    default:
      if (this.j >= 0)
        this.c.setText(2131492887);
      break;
    case 1:
    case 16:
    }
    while (true)
    {
      PickAdapter localPickAdapter1 = new PickAdapter(getActivity(), this.h, this.i, this.d, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, false, 46, 8, 7, 7, 1);
      localPickAdapter1.setMode(9);
      this.d.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493085), 2131230780, 18.0F).setViewAdapter(localPickAdapter1);
      a(this.j);
      this.d.addChangingListener(this);
      PickAdapter localPickAdapter2 = new PickAdapter(getActivity(), 0, 59, this.e, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, true, 46, 8, 7, 7, 1);
      this.e.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493075), 2131230780, 18.0F).setViewAdapter(localPickAdapter2);
      b(this.k);
      this.e.addChangingListener(this);
      return;
      this.b.setText(2131493151);
      break;
      this.b.setText(2131493152);
      break;
      this.c.setText(2131492888);
    }
  }

  public void onChanged(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i2;
    int[] arrayOfInt;
    if (paramWheelView == this.d)
    {
      if (paramInt2 + this.h >= 0)
        this.c.setText(2131492887);
    }
    else
    {
      int n = a();
      int i1 = b();
      i2 = a(n, i1);
      StringBuilder localStringBuilder1 = new StringBuilder("Selection Time : ").append(n).append(":");
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i1);
      Debug.i("Dynamic.Detail.SleepModify", String.format("%02d", arrayOfObject1) + " , " + i2);
      if ((this.l <= -2147483648) || (i2 >= this.l))
        break label346;
      arrayOfInt = c(this.l);
      StringBuilder localStringBuilder4 = new StringBuilder("Selection Time Is Before : ").append(arrayOfInt[0]).append(":");
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(arrayOfInt[1]);
      Log.w("Dynamic.Detail.SleepModify", String.format("%02d", arrayOfObject4));
    }
    while (true)
    {
      Calendar localCalendar = Calendar.getInstance();
      int i5 = 60 * localCalendar.get(11) + localCalendar.get(12);
      if (i2 > i5)
      {
        arrayOfInt = c(i5);
        StringBuilder localStringBuilder3 = new StringBuilder("Selection Time Is After : ").append(arrayOfInt[0]).append(":");
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(arrayOfInt[1]);
        Log.w("Dynamic.Detail.SleepModify", String.format("%02d", arrayOfObject3));
      }
      if (arrayOfInt != null)
      {
        a(arrayOfInt[0]);
        b(arrayOfInt[1]);
      }
      return;
      this.c.setText(2131492888);
      break;
      label346: int i3 = this.m;
      arrayOfInt = null;
      if (i3 > -2147483648)
      {
        int i4 = this.m;
        arrayOfInt = null;
        if (i2 > i4)
        {
          arrayOfInt = c(this.m);
          StringBuilder localStringBuilder2 = new StringBuilder("Selection Time Is After : ").append(arrayOfInt[0]).append(":");
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(arrayOfInt[1]);
          Log.w("Dynamic.Detail.SleepModify", String.format("%02d", arrayOfObject2));
        }
      }
    }
  }

  public void onPause()
  {
    super.onPause();
    String str = "PageDynamicDetailModifySleep";
    if (this.g == 1)
      str = "PageDynamicDetailModifySleepStart";
    while (true)
    {
      UmengAnalytics.endPage(str);
      return;
      if (this.g == 16)
        str = "PageDynamicDetailModifySleepEnd";
    }
  }

  public void onResume()
  {
    super.onResume();
    String str = "PageDynamicDetailModifySleep";
    if (this.g == 1)
      str = "PageDynamicDetailModifySleepStart";
    while (true)
    {
      UmengAnalytics.startPage(str);
      return;
      if (this.g == 16)
        str = "PageDynamicDetailModifySleepEnd";
    }
  }

  protected void onRightButtomClicked()
  {
    int n = a();
    int i1 = b();
    int i2;
    ChartData.UserSleepModify localUserSleepModify;
    if ((n != this.j) || (i1 != this.k))
    {
      i2 = a(n, i1);
      StringBuilder localStringBuilder = new StringBuilder("Sleep Time Modified : ").append(n).append(":");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      Debug.i("Dynamic.Detail.SleepModify", String.format("%02d", arrayOfObject) + " , " + i2 + " , " + this.g + " , " + this.f);
      localUserSleepModify = ChartData.getDynamicData().getUserSleepModify(this.f);
      switch (this.g)
      {
      default:
      case 1:
      case 16:
      }
    }
    while (true)
    {
      ChartData.getDynamicData().putUserSleepModify(this.f, localUserSleepModify);
      DataManager localDataManager = DataManager.getInstance();
      DaySportData localDaySportData = localDataManager.get(this.f);
      if (localDaySportData != null)
      {
        localDaySportData.setNeedSync(true);
        localDaySportData.setNeedPostProcess(true);
      }
      localDataManager.analysis();
      localDataManager.saveToDb();
      if (localDaySportData != null)
      {
        SleepInfo localSleepInfo = localDaySportData.getSleepInfo();
        if (localSleepInfo == null)
          localSleepInfo = new SleepInfo();
        ChartData.DynamicData localDynamicData = ChartData.getDynamicData();
        localDynamicData.setSleepTime(localSleepInfo.getSleepCount());
        localDynamicData.setSleepDeepTime(localSleepInfo.getNonRemCount());
        localDynamicData.setSleepStartDate(localSleepInfo.getStartDate());
        localDynamicData.setSleepStopDate(localSleepInfo.getStopDate());
      }
      EventBus.getDefault().post(new EventDynamicDetailSleepUserModified());
      dismiss();
      return;
      localUserSleepModify.sleepStart = i2;
      continue;
      localUserSleepModify.sleepEnd = i2;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicDetailSleepModifyFragment
 * JD-Core Version:    0.6.2
 */