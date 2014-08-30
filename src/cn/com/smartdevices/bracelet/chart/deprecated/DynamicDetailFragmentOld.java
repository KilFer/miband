package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.chart.data.AsyncChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicDetailFragmentOld extends Fragment
{
  public static Handler sRefreshHander;
  private DynamicDetailChartViewOld a;
  private GestureDetector b;
  private DataManager c = DataManager.getInstance();
  private SportDay d;
  private SportDay e;
  private SportDay f;
  private SportDay g;
  private SportDay h;

  private static DynamicDetailChartViewOld.DynamicDetailChartData a(DaySportData paramDaySportData)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramDaySportData.getAnalysisData().iterator();
    Object localObject = null;
    DynamicDetailChartViewOld.DynamicDetailChartSleepData localDynamicDetailChartSleepData = null;
    int i = -1;
    int j = -1;
    if (!localIterator.hasNext())
    {
      DynamicDetailChartViewOld.DynamicDetailChartData localDynamicDetailChartData = new DynamicDetailChartViewOld.DynamicDetailChartData();
      localDynamicDetailChartData.sleepData = localArrayList1;
      localDynamicDetailChartData.stepData = localArrayList2;
      return localDynamicDetailChartData;
    }
    SportData localSportData = (SportData)localIterator.next();
    int k = localSportData.getSportMode();
    int m = localSportData.getStep();
    int n = localSportData.getTimeIndex();
    label212: int i1;
    if ((j != k) || (n == 1439))
    {
      if (localDynamicDetailChartSleepData != null)
      {
        localDynamicDetailChartSleepData.length = (n - localDynamicDetailChartSleepData.index);
        localDynamicDetailChartSleepData = null;
      }
      if ((k == 4) || (k == 5) || (k == 7))
      {
        localDynamicDetailChartSleepData = new DynamicDetailChartViewOld.DynamicDetailChartSleepData();
        localArrayList1.add(localDynamicDetailChartSleepData);
        localDynamicDetailChartSleepData.index = n;
      }
      switch (k)
      {
      case 6:
      default:
        i1 = k;
      case 4:
      case 5:
      case 7:
      }
    }
    while (true)
    {
      if ((k != 126) && (k != 127) && (k != 4) && (k != 5) && (k != 7) && (m > 0))
      {
        int i2 = n / 60;
        if (i2 != i)
        {
          DynamicDetailChartViewOld.DynamicDetailChartStepData localDynamicDetailChartStepData = new DynamicDetailChartViewOld.DynamicDetailChartStepData();
          localArrayList2.add(localDynamicDetailChartStepData);
          localDynamicDetailChartStepData.index = i2;
          localDynamicDetailChartStepData.step = m;
          localObject = localDynamicDetailChartStepData;
          i = i2;
          j = i1;
          break;
          localDynamicDetailChartSleepData.mode = 2;
          i1 = k;
          continue;
          localDynamicDetailChartSleepData.mode = 3;
          i1 = k;
          continue;
          localDynamicDetailChartSleepData.mode = 1;
          break label212;
        }
        localObject.step = (m + localObject.step);
      }
      j = i1;
      break;
      i1 = j;
    }
  }

  private static String a(int paramInt)
  {
    int i = paramInt / 60;
    int j = paramInt % 60;
    if ((i == 0) && (j == 0))
      return "00:00";
    if (j < 10)
      return i + ":0" + j;
    return i + ":" + j;
  }

  private static String a(SportDay paramSportDay)
  {
    return 1 + paramSportDay.mon + "." + paramSportDay.day;
  }

  public static String valueToTime(int paramInt)
  {
    int i = paramInt / 60;
    int j = paramInt % 60;
    if ((i == 0) && (j == 0))
      return "00:00";
    if (j < 10)
      return i + ":0" + j;
    return i + ":" + j;
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
    int i = paramInt / 60;
    int j = paramInt % 60;
    String[] arrayOfString = new String[2];
    if (i > 0)
      arrayOfString[0] = String.valueOf(i);
    arrayOfString[1] = String.valueOf(j);
    return arrayOfString;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903069, paramViewGroup, false);
    this.a = ((DynamicDetailChartViewOld)localView.findViewById(2131165339));
    this.b = new GestureDetector(getActivity(), new h(this));
    this.a.setOnTouchListener(new i(this));
    AsyncChartDataLoader localAsyncChartDataLoader = new AsyncChartDataLoader();
    localAsyncChartDataLoader.setLoadCallback(new j(this));
    this.a.setDataLoader(localAsyncChartDataLoader);
    this.a.setScrollable(true);
    k localk = new k(this);
    sRefreshHander = localk;
    localk.sendEmptyMessage(0);
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicDetailFragmentOld
 * JD-Core Version:    0.6.2
 */