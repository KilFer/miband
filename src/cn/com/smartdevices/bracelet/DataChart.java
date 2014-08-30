package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.view.View;
import cn.com.smartdevices.bracelet.analysis.StageSteps;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class DataChart
{
  private static DataChart a = null;
  private ArrayList<SportData> b = null;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;

  public static DataChart getInstance()
  {
    if (a == null)
      a = new DataChart();
    return a;
  }

  public List deepCopy(List paramList)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramList);
    return (List)new ObjectInputStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray())).readObject();
  }

  public Intent executeBarChart(Context paramContext, DaySportData paramDaySportData)
  {
    String[] arrayOfString = { "静止", "慢走", "跑步", "没戴", "浅睡眠", "深睡眠" };
    XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
    XYSeries localXYSeries1 = new XYSeries(arrayOfString[0]);
    XYSeries localXYSeries2 = new XYSeries(arrayOfString[1]);
    XYSeries localXYSeries3 = new XYSeries(arrayOfString[2]);
    XYSeries localXYSeries4 = new XYSeries(arrayOfString[3]);
    XYSeries localXYSeries5 = new XYSeries(arrayOfString[4]);
    XYSeries localXYSeries6 = new XYSeries(arrayOfString[5]);
    ArrayList localArrayList = paramDaySportData.data();
    int i = localArrayList.size();
    int j = 0;
    int k = 0;
    int[] arrayOfInt;
    PointStyle[] arrayOfPointStyle;
    XYMultipleSeriesRenderer localXYMultipleSeriesRenderer;
    int i1;
    label358: int i3;
    if (k >= 1440)
    {
      localXYMultipleSeriesDataset.addSeries(localXYSeries1);
      localXYMultipleSeriesDataset.addSeries(localXYSeries2);
      localXYMultipleSeriesDataset.addSeries(localXYSeries3);
      localXYMultipleSeriesDataset.addSeries(localXYSeries4);
      localXYMultipleSeriesDataset.addSeries(localXYSeries5);
      localXYMultipleSeriesDataset.addSeries(localXYSeries6);
      arrayOfInt = new int[] { -16711936, -16776961, -16711681, -65536, -256, -65281 };
      arrayOfPointStyle = new PointStyle[6];
      arrayOfPointStyle[0] = PointStyle.CIRCLE;
      arrayOfPointStyle[1] = PointStyle.DIAMOND;
      arrayOfPointStyle[2] = PointStyle.POINT;
      arrayOfPointStyle[3] = PointStyle.TRIANGLE;
      arrayOfPointStyle[4] = PointStyle.SQUARE;
      arrayOfPointStyle[5] = PointStyle.CIRCLE;
      localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      localXYMultipleSeriesRenderer.setAxisTitleTextSize(16.0F);
      localXYMultipleSeriesRenderer.setChartTitleTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(15.0F);
      localXYMultipleSeriesRenderer.setPointSize(5.0F);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      localXYMultipleSeriesRenderer.setAntialiasing(true);
      int n = arrayOfInt.length;
      i1 = 0;
      if (i1 >= n)
      {
        int i2 = localXYMultipleSeriesRenderer.getSeriesRendererCount();
        i3 = 0;
        label375: if (i3 < i2)
          break label826;
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间（0-23小时）");
        localXYMultipleSeriesRenderer.setYTitle("每小时各活动时间(分钟)");
        localXYMultipleSeriesRenderer.setXAxisMin(0.0D);
        localXYMultipleSeriesRenderer.setXAxisMax(12.0D);
        localXYMultipleSeriesRenderer.setYAxisMin(0.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(80.0D);
        localXYMultipleSeriesRenderer.setAxesColor(-3355444);
        localXYMultipleSeriesRenderer.setLabelsColor(-3355444);
        localXYMultipleSeriesRenderer.setXLabels(10);
        localXYMultipleSeriesRenderer.setYLabels(10);
        localXYMultipleSeriesRenderer.setShowGrid(true);
        localXYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        localXYMultipleSeriesRenderer.setYLabelsAlign(Paint.Align.RIGHT);
        localXYMultipleSeriesRenderer.setBarSpacing(0.300000011920929D);
        return ChartFactory.getBarChartIntent(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, BarChart.Type.DEFAULT);
      }
    }
    else
    {
      if (k < i);
      switch (((SportData)localArrayList.get(k)).getSportMode())
      {
      default:
        label572: if ((k + 1) % 60 == 0)
        {
          localXYSeries1.add(j, this.c);
          localXYSeries2.add(j, this.d);
          localXYSeries3.add(j, this.e);
          localXYSeries4.add(j, this.f);
          localXYSeries5.add(j, this.g);
          localXYSeries6.add(j, this.h);
          this.c = 0;
          this.d = 0;
          this.e = 0;
          this.f = 0;
          this.g = 0;
          this.h = 0;
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    for (int m = j + 1; ; m = j)
    {
      k++;
      j = m;
      break;
      this.c = (1 + this.c);
      break label572;
      this.d = (1 + this.d);
      break label572;
      this.e = (1 + this.e);
      break label572;
      this.f = (1 + this.f);
      break label572;
      this.g = (1 + this.g);
      break label572;
      this.h = (1 + this.h);
      break label572;
      XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
      localXYSeriesRenderer.setColor(arrayOfInt[i1]);
      localXYSeriesRenderer.setPointStyle(arrayOfPointStyle[i1]);
      localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
      i1++;
      break label358;
      label826: ((XYSeriesRenderer)localXYMultipleSeriesRenderer.getSeriesRendererAt(i3)).setFillPoints(true);
      i3++;
      break label375;
    }
  }

  public Intent executeLineChart(Context paramContext, DaySportData paramDaySportData)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = paramDaySportData.data();
    int i = localArrayList7.size();
    int j = 0;
    label76: XYMultipleSeriesDataset localXYMultipleSeriesDataset;
    XYSeries localXYSeries1;
    int m;
    label138: XYSeries localXYSeries2;
    int n;
    label163: XYSeries localXYSeries3;
    int i1;
    label189: XYSeries localXYSeries4;
    int i2;
    label215: XYSeries localXYSeries5;
    int i3;
    label241: XYSeries localXYSeries6;
    int i4;
    label267: int[] arrayOfInt;
    PointStyle[] arrayOfPointStyle;
    XYMultipleSeriesRenderer localXYMultipleSeriesRenderer;
    int i6;
    label485: int i7;
    if (j >= i)
    {
      String[] arrayOfString = { "静止", "慢走", "跑步", "没戴", "浅睡眠", "深睡眠" };
      localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
      localXYSeries1 = new XYSeries(arrayOfString[0]);
      m = 0;
      if (m < localArrayList1.size())
        break label811;
      localXYSeries2 = new XYSeries(arrayOfString[1]);
      n = 0;
      if (n < localArrayList2.size())
        break label845;
      localXYSeries3 = new XYSeries(arrayOfString[2]);
      i1 = 0;
      if (i1 < localArrayList3.size())
        break label880;
      localXYSeries4 = new XYSeries(arrayOfString[3]);
      i2 = 0;
      if (i2 < localArrayList4.size())
        break label915;
      localXYSeries5 = new XYSeries(arrayOfString[4]);
      i3 = 0;
      if (i3 < localArrayList5.size())
        break label950;
      localXYSeries6 = new XYSeries(arrayOfString[5]);
      i4 = 0;
      if (i4 < localArrayList6.size())
        break label985;
      localXYMultipleSeriesDataset.addSeries(localXYSeries1);
      localXYMultipleSeriesDataset.addSeries(localXYSeries2);
      localXYMultipleSeriesDataset.addSeries(localXYSeries3);
      localXYMultipleSeriesDataset.addSeries(localXYSeries4);
      localXYMultipleSeriesDataset.addSeries(localXYSeries5);
      localXYMultipleSeriesDataset.addSeries(localXYSeries6);
      arrayOfInt = new int[] { -16711936, -16776961, -16711681, -65536, -256, -65281 };
      arrayOfPointStyle = new PointStyle[6];
      arrayOfPointStyle[0] = PointStyle.CIRCLE;
      arrayOfPointStyle[1] = PointStyle.DIAMOND;
      arrayOfPointStyle[2] = PointStyle.POINT;
      arrayOfPointStyle[3] = PointStyle.TRIANGLE;
      arrayOfPointStyle[4] = PointStyle.SQUARE;
      arrayOfPointStyle[5] = PointStyle.CIRCLE;
      localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      localXYMultipleSeriesRenderer.setAxisTitleTextSize(16.0F);
      localXYMultipleSeriesRenderer.setChartTitleTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(15.0F);
      localXYMultipleSeriesRenderer.setPointSize(5.0F);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      int i5 = arrayOfInt.length;
      i6 = 0;
      if (i6 < i5)
        break label1020;
      i7 = localXYMultipleSeriesRenderer.getSeriesRendererCount();
    }
    for (int i8 = 0; ; i8++)
    {
      if (i8 >= i7)
      {
        Calendar localCalendar = Calendar.getInstance();
        int i9 = localCalendar.get(11);
        int i10 = localCalendar.get(12) + i9 * 60;
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间（0-1339分钟）");
        localXYMultipleSeriesRenderer.setYTitle("每分钟活动量");
        localXYMultipleSeriesRenderer.setXAxisMin(i10 - 60);
        localXYMultipleSeriesRenderer.setXAxisMax(i10 + 10);
        localXYMultipleSeriesRenderer.setYAxisMin(-50.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(256.0D);
        localXYMultipleSeriesRenderer.setAxesColor(-3355444);
        localXYMultipleSeriesRenderer.setLabelsColor(-3355444);
        localXYMultipleSeriesRenderer.setXLabels(10);
        localXYMultipleSeriesRenderer.setYLabels(10);
        localXYMultipleSeriesRenderer.setShowGrid(true);
        localXYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        localXYMultipleSeriesRenderer.setYLabelsAlign(Paint.Align.RIGHT);
        return ChartFactory.getLineChartIntent(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, "hi,xiaomi!");
        SportData localSportData1 = (SportData)localArrayList7.get(j);
        int k = localSportData1.getSportMode();
        if (k == 127)
          break label76;
        switch (k)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        while (true)
        {
          j++;
          break;
          localArrayList1.add(localSportData1);
          continue;
          localArrayList2.add(localSportData1);
          continue;
          localArrayList3.add(localSportData1);
          continue;
          localArrayList4.add(localSportData1);
          continue;
          localArrayList5.add(localSportData1);
          continue;
          localArrayList6.add(localSportData1);
        }
        label811: SportData localSportData7 = (SportData)localArrayList1.get(m);
        localXYSeries1.add(localSportData7.getTimeIndex(), localSportData7.getActivity());
        m++;
        break label138;
        label845: SportData localSportData6 = (SportData)localArrayList2.get(n);
        localXYSeries2.add(localSportData6.getTimeIndex(), localSportData6.getStep());
        n++;
        break label163;
        label880: SportData localSportData5 = (SportData)localArrayList3.get(i1);
        localXYSeries3.add(localSportData5.getTimeIndex(), localSportData5.getStep());
        i1++;
        break label189;
        label915: SportData localSportData4 = (SportData)localArrayList4.get(i2);
        localXYSeries4.add(localSportData4.getTimeIndex(), localSportData4.getActivity());
        i2++;
        break label215;
        label950: SportData localSportData3 = (SportData)localArrayList5.get(i3);
        localXYSeries5.add(localSportData3.getTimeIndex(), localSportData3.getActivity());
        i3++;
        break label241;
        label985: SportData localSportData2 = (SportData)localArrayList6.get(i4);
        localXYSeries6.add(localSportData2.getTimeIndex(), localSportData2.getActivity());
        i4++;
        break label267;
        label1020: XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
        localXYSeriesRenderer.setColor(arrayOfInt[i6]);
        localXYSeriesRenderer.setPointStyle(arrayOfPointStyle[i6]);
        localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
        i6++;
        break label485;
      }
      ((XYSeriesRenderer)localXYMultipleSeriesRenderer.getSeriesRendererAt(i8)).setFillPoints(true);
    }
  }

  public View executeLineChartView(Context paramContext, DaySportData paramDaySportData)
  {
    if (paramDaySportData == null)
      return new View(paramContext);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = paramDaySportData.data();
    int i = localArrayList7.size();
    int j = 0;
    label93: XYMultipleSeriesDataset localXYMultipleSeriesDataset;
    XYSeries localXYSeries1;
    int m;
    label155: XYSeries localXYSeries2;
    int n;
    label180: XYSeries localXYSeries3;
    int i1;
    label206: XYSeries localXYSeries4;
    int i2;
    label232: XYSeries localXYSeries5;
    int i3;
    label258: XYSeries localXYSeries6;
    int i4;
    label284: int[] arrayOfInt;
    PointStyle[] arrayOfPointStyle;
    XYMultipleSeriesRenderer localXYMultipleSeriesRenderer;
    int i6;
    label508: int i7;
    if (j >= i)
    {
      j = i;
      String[] arrayOfString = { "静止", "慢走", "跑步", "没戴", "浅睡眠", "深睡眠" };
      localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
      localXYSeries1 = new XYSeries(arrayOfString[0]);
      m = 0;
      if (m < localArrayList1.size())
        break label811;
      localXYSeries2 = new XYSeries(arrayOfString[1]);
      n = 0;
      if (n < localArrayList2.size())
        break label845;
      localXYSeries3 = new XYSeries(arrayOfString[2]);
      i1 = 0;
      if (i1 < localArrayList3.size())
        break label880;
      localXYSeries4 = new XYSeries(arrayOfString[3]);
      i2 = 0;
      if (i2 < localArrayList4.size())
        break label915;
      localXYSeries5 = new XYSeries(arrayOfString[4]);
      i3 = 0;
      if (i3 < localArrayList5.size())
        break label950;
      localXYSeries6 = new XYSeries(arrayOfString[5]);
      i4 = 0;
      if (i4 < localArrayList6.size())
        break label985;
      localXYMultipleSeriesDataset.addSeries(localXYSeries1);
      localXYMultipleSeriesDataset.addSeries(localXYSeries2);
      localXYMultipleSeriesDataset.addSeries(localXYSeries3);
      localXYMultipleSeriesDataset.addSeries(localXYSeries4);
      localXYMultipleSeriesDataset.addSeries(localXYSeries5);
      localXYMultipleSeriesDataset.addSeries(localXYSeries6);
      arrayOfInt = new int[] { -16711936, -16776961, -16711681, -65536, -256, -65281 };
      arrayOfPointStyle = new PointStyle[6];
      arrayOfPointStyle[0] = PointStyle.CIRCLE;
      arrayOfPointStyle[1] = PointStyle.DIAMOND;
      arrayOfPointStyle[2] = PointStyle.POINT;
      arrayOfPointStyle[3] = PointStyle.TRIANGLE;
      arrayOfPointStyle[4] = PointStyle.SQUARE;
      arrayOfPointStyle[5] = PointStyle.CIRCLE;
      localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      localXYMultipleSeriesRenderer.setAxisTitleTextSize(16.0F);
      localXYMultipleSeriesRenderer.setChartTitleTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(15.0F);
      localXYMultipleSeriesRenderer.setPointSize(5.0F);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      localXYMultipleSeriesRenderer.setAntialiasing(true);
      int i5 = arrayOfInt.length;
      i6 = 0;
      if (i6 < i5)
        break label1020;
      i7 = localXYMultipleSeriesRenderer.getSeriesRendererCount();
    }
    for (int i8 = 0; ; i8++)
    {
      if (i8 >= i7)
      {
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间（0-1339分钟）");
        localXYMultipleSeriesRenderer.setYTitle("每分钟活动量");
        localXYMultipleSeriesRenderer.setXAxisMin(j - 60);
        localXYMultipleSeriesRenderer.setXAxisMax(j + 10);
        localXYMultipleSeriesRenderer.setYAxisMin(-50.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(256.0D);
        localXYMultipleSeriesRenderer.setAxesColor(-3355444);
        localXYMultipleSeriesRenderer.setLabelsColor(-3355444);
        localXYMultipleSeriesRenderer.setXLabels(10);
        localXYMultipleSeriesRenderer.setYLabels(10);
        localXYMultipleSeriesRenderer.setShowGrid(true);
        localXYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        localXYMultipleSeriesRenderer.setYLabelsAlign(Paint.Align.RIGHT);
        localXYMultipleSeriesRenderer.setBackgroundColor(-16777216);
        return ChartFactory.getLineChartView(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer);
        SportData localSportData1 = (SportData)localArrayList7.get(j);
        int k = localSportData1.getSportMode();
        if (k == 127)
          break label93;
        switch (k)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        while (true)
        {
          j++;
          break;
          localArrayList1.add(localSportData1);
          continue;
          localArrayList2.add(localSportData1);
          continue;
          localArrayList3.add(localSportData1);
          continue;
          localArrayList4.add(localSportData1);
          continue;
          localArrayList5.add(localSportData1);
          continue;
          localArrayList6.add(localSportData1);
        }
        label811: SportData localSportData7 = (SportData)localArrayList1.get(m);
        localXYSeries1.add(localSportData7.getTimeIndex(), localSportData7.getActivity());
        m++;
        break label155;
        label845: SportData localSportData6 = (SportData)localArrayList2.get(n);
        localXYSeries2.add(localSportData6.getTimeIndex(), localSportData6.getStep());
        n++;
        break label180;
        label880: SportData localSportData5 = (SportData)localArrayList3.get(i1);
        localXYSeries3.add(localSportData5.getTimeIndex(), localSportData5.getStep());
        i1++;
        break label206;
        label915: SportData localSportData4 = (SportData)localArrayList4.get(i2);
        localXYSeries4.add(localSportData4.getTimeIndex(), localSportData4.getActivity());
        i2++;
        break label232;
        label950: SportData localSportData3 = (SportData)localArrayList5.get(i3);
        localXYSeries5.add(localSportData3.getTimeIndex(), localSportData3.getActivity());
        i3++;
        break label258;
        label985: SportData localSportData2 = (SportData)localArrayList6.get(i4);
        localXYSeries6.add(localSportData2.getTimeIndex(), localSportData2.getActivity());
        i4++;
        break label284;
        label1020: XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
        localXYSeriesRenderer.setColor(arrayOfInt[i6]);
        localXYSeriesRenderer.setPointStyle(arrayOfPointStyle[i6]);
        localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
        i6++;
        break label508;
      }
      ((XYSeriesRenderer)localXYMultipleSeriesRenderer.getSeriesRendererAt(i8)).setFillPoints(true);
    }
  }

  public View executeLineChartView2(Context paramContext, DaySportData paramDaySportData, long paramLong)
  {
    if (paramDaySportData == null)
      return new View(paramContext);
    this.b = paramDaySportData.getAnalysisData();
    int i = this.b.size();
    if (i == 0)
      return new View(paramContext);
    ((SportData)this.b.get(i - 1)).getTimeIndex();
    String[] arrayOfString = { "活动", "静止", "慢走", "跑步", "没戴", "浅睡眠", "深睡眠" };
    XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
    XYSeries localXYSeries1 = new XYSeries(arrayOfString[0]);
    new XYSeries(arrayOfString[1]);
    new XYSeries(arrayOfString[2]);
    new XYSeries(arrayOfString[3]);
    new XYSeries(arrayOfString[4]);
    new XYSeries(arrayOfString[5]);
    new XYSeries(arrayOfString[6]);
    XYSeries localXYSeries2 = new XYSeries(arrayOfString[1]);
    XYSeries localXYSeries3 = new XYSeries(arrayOfString[2]);
    XYSeries localXYSeries4 = new XYSeries(arrayOfString[3]);
    XYSeries localXYSeries5 = new XYSeries(arrayOfString[4]);
    XYSeries localXYSeries6 = new XYSeries(arrayOfString[5]);
    XYSeries localXYSeries7 = new XYSeries(arrayOfString[6]);
    localXYMultipleSeriesDataset.addSeries(localXYSeries1);
    localXYMultipleSeriesDataset.addSeries(localXYSeries2);
    localXYMultipleSeriesDataset.addSeries(localXYSeries3);
    localXYMultipleSeriesDataset.addSeries(localXYSeries4);
    localXYMultipleSeriesDataset.addSeries(localXYSeries5);
    localXYMultipleSeriesDataset.addSeries(localXYSeries6);
    localXYMultipleSeriesDataset.addSeries(localXYSeries7);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 1;
    int m;
    int[] arrayOfInt;
    PointStyle[] arrayOfPointStyle;
    XYMultipleSeriesRenderer localXYMultipleSeriesRenderer;
    int i7;
    label738: int i8;
    if (k >= this.b.size())
    {
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("start", Integer.valueOf(j));
      localHashMap1.put("stop", Integer.valueOf(-1 + this.b.size()));
      localHashMap1.put("mode", Integer.valueOf(((SportData)this.b.get(j)).getSportMode()));
      localArrayList.add(localHashMap1);
      m = 0;
      if (m < localArrayList.size())
        break label1016;
      arrayOfInt = new int[7];
      arrayOfInt[0] = -16776961;
      arrayOfInt[1] = Color.argb(255, 171, 200, 139);
      arrayOfInt[2] = Color.argb(255, 245, 143, 152);
      arrayOfInt[3] = -65536;
      arrayOfInt[4] = -256;
      arrayOfInt[5] = Color.argb(255, 190, 215, 66);
      arrayOfInt[6] = Color.argb(255, 127, 184, 14);
      arrayOfPointStyle = new PointStyle[13];
      arrayOfPointStyle[0] = PointStyle.POINT;
      arrayOfPointStyle[1] = PointStyle.SQUARE;
      arrayOfPointStyle[2] = PointStyle.SQUARE;
      arrayOfPointStyle[3] = PointStyle.SQUARE;
      arrayOfPointStyle[4] = PointStyle.SQUARE;
      arrayOfPointStyle[5] = PointStyle.SQUARE;
      arrayOfPointStyle[6] = PointStyle.SQUARE;
      arrayOfPointStyle[7] = PointStyle.SQUARE;
      arrayOfPointStyle[8] = PointStyle.SQUARE;
      arrayOfPointStyle[9] = PointStyle.SQUARE;
      arrayOfPointStyle[10] = PointStyle.SQUARE;
      arrayOfPointStyle[11] = PointStyle.SQUARE;
      arrayOfPointStyle[12] = PointStyle.SQUARE;
      localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      localXYMultipleSeriesRenderer.setAxisTitleTextSize(16.0F);
      localXYMultipleSeriesRenderer.setChartTitleTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(15.0F);
      localXYMultipleSeriesRenderer.setPointSize(5.0F);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      localXYMultipleSeriesRenderer.setAntialiasing(true);
      int i6 = arrayOfInt.length;
      i7 = 0;
      if (i7 < i6)
        break label1284;
      i8 = localXYMultipleSeriesRenderer.getSeriesRendererCount();
    }
    for (int i9 = 0; ; i9++)
    {
      if (i9 >= i8)
      {
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间");
        localXYMultipleSeriesRenderer.setYTitle("每分钟活动量");
        localXYMultipleSeriesRenderer.setXAxisMin(0.0D);
        localXYMultipleSeriesRenderer.setXAxisMax(1440.0D);
        localXYMultipleSeriesRenderer.setYAxisMin(-50.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(256.0D);
        localXYMultipleSeriesRenderer.setAxesColor(-3355444);
        localXYMultipleSeriesRenderer.setLabelsColor(-3355444);
        localXYMultipleSeriesRenderer.setXLabels(10);
        localXYMultipleSeriesRenderer.setYLabels(10);
        localXYMultipleSeriesRenderer.setShowGrid(true);
        localXYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        localXYMultipleSeriesRenderer.setYLabelsAlign(Paint.Align.RIGHT);
        localXYMultipleSeriesRenderer.setBackgroundColor(-1);
        return ChartFactory.getBarChartView(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, BarChart.Type.STACKED);
        if (((SportData)this.b.get(k)).getSportMode() != ((SportData)this.b.get(k - 1)).getSportMode())
        {
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put("start", Integer.valueOf(j));
          localHashMap2.put("stop", Integer.valueOf(k - 1));
          localHashMap2.put("mode", Integer.valueOf(((SportData)this.b.get(j)).getSportMode()));
          localArrayList.add(localHashMap2);
          j = k;
        }
        k++;
        break;
        label1016: int n = Integer.parseInt(((HashMap)localArrayList.get(m)).get("start").toString());
        int i1 = Integer.parseInt(((HashMap)localArrayList.get(m)).get("stop").toString());
        int i2 = Integer.parseInt(((HashMap)localArrayList.get(m)).get("mode").toString());
        int i3 = n;
        int i4 = 0;
        int i5;
        while (true)
        {
          if (i3 > i1)
          {
            i5 = i4 / (i1 + 1 - n);
            if (i5 < 3)
              i5 = 3;
            if (n <= i1)
              break label1162;
            m++;
            break;
          }
          i4 += ((SportData)this.b.get(i3)).getActivity();
          i3++;
        }
        label1162: if (i2 == 0)
          localXYSeries2.add(n, i5);
        while (true)
        {
          n++;
          break;
          if (i2 == 1)
            localXYSeries3.add(n, i5);
          else if (i2 == 2)
            localXYSeries4.add(n, i5);
          else if (i2 == 3)
            localXYSeries5.add(n, i5);
          else if (i2 == 4)
            localXYSeries6.add(n, 50.0D);
          else if (i2 == 5)
            localXYSeries7.add(n, 35.0D);
        }
        label1284: XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
        localXYSeriesRenderer.setColor(arrayOfInt[i7]);
        localXYSeriesRenderer.setPointStyle(arrayOfPointStyle[i7]);
        localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
        i7++;
        break label738;
      }
      ((XYSeriesRenderer)localXYMultipleSeriesRenderer.getSeriesRendererAt(i9)).setFillPoints(true);
    }
  }

  public View executeLineChartView3(Context paramContext, DaySportData paramDaySportData, long paramLong)
  {
    if (paramDaySportData == null)
      return new View(paramContext);
    ArrayList localArrayList = paramDaySportData.data();
    int i = localArrayList.size();
    if (i == 0)
      return new View(paramContext);
    long l1 = paramLong + 60000 * ((SportData)localArrayList.get(i - 1)).getTimeIndex();
    Debug.i("BXL", "executeLineChartView size=" + i);
    String[] arrayOfString = { "活动", "静止", "慢走", "跑步", "没戴", "浅睡眠", "深睡眠", "赖床" };
    XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
    XYSeries localXYSeries1 = new XYSeries(arrayOfString[0]);
    XYSeries localXYSeries2 = new XYSeries(arrayOfString[1]);
    XYSeries localXYSeries3 = new XYSeries(arrayOfString[2]);
    XYSeries localXYSeries4 = new XYSeries(arrayOfString[3]);
    XYSeries localXYSeries5 = new XYSeries(arrayOfString[4]);
    XYSeries localXYSeries6 = new XYSeries(arrayOfString[5]);
    XYSeries localXYSeries7 = new XYSeries(arrayOfString[6]);
    XYSeries localXYSeries8 = new XYSeries(arrayOfString[1]);
    XYSeries localXYSeries9 = new XYSeries(arrayOfString[2]);
    XYSeries localXYSeries10 = new XYSeries(arrayOfString[3]);
    XYSeries localXYSeries11 = new XYSeries(arrayOfString[4]);
    XYSeries localXYSeries12 = new XYSeries(arrayOfString[5]);
    XYSeries localXYSeries13 = new XYSeries(arrayOfString[6]);
    XYSeries localXYSeries14 = new XYSeries(arrayOfString[7]);
    localXYMultipleSeriesDataset.addSeries(localXYSeries1);
    localXYMultipleSeriesDataset.addSeries(localXYSeries2);
    localXYMultipleSeriesDataset.addSeries(localXYSeries3);
    localXYMultipleSeriesDataset.addSeries(localXYSeries4);
    localXYMultipleSeriesDataset.addSeries(localXYSeries5);
    localXYMultipleSeriesDataset.addSeries(localXYSeries6);
    localXYMultipleSeriesDataset.addSeries(localXYSeries7);
    localXYMultipleSeriesDataset.addSeries(localXYSeries8);
    localXYMultipleSeriesDataset.addSeries(localXYSeries9);
    localXYMultipleSeriesDataset.addSeries(localXYSeries10);
    localXYMultipleSeriesDataset.addSeries(localXYSeries11);
    localXYMultipleSeriesDataset.addSeries(localXYSeries12);
    localXYMultipleSeriesDataset.addSeries(localXYSeries13);
    localXYMultipleSeriesDataset.addSeries(localXYSeries14);
    int j = 0;
    int i3;
    int[] arrayOfInt;
    PointStyle[] arrayOfPointStyle;
    XYMultipleSeriesRenderer localXYMultipleSeriesRenderer;
    int n;
    label833: int i1;
    if (j >= i)
    {
      this.b = paramDaySportData.getAnalysisData();
      if ((this.b != null) && (this.b.size() == i))
      {
        i3 = 0;
        if (i3 < i)
          break label1178;
      }
      arrayOfInt = new int[14];
      arrayOfInt[0] = -16776961;
      arrayOfInt[1] = -16711936;
      arrayOfInt[2] = -16711681;
      arrayOfInt[3] = -65536;
      arrayOfInt[4] = -256;
      arrayOfInt[5] = Color.argb(255, 190, 215, 66);
      arrayOfInt[6] = Color.argb(255, 127, 184, 14);
      arrayOfInt[7] = -16711936;
      arrayOfInt[8] = -16711681;
      arrayOfInt[9] = -65536;
      arrayOfInt[10] = -256;
      arrayOfInt[11] = Color.argb(255, 190, 215, 66);
      arrayOfInt[12] = Color.argb(255, 127, 184, 14);
      arrayOfInt[13] = Color.argb(255, 255, 102, 0);
      arrayOfPointStyle = new PointStyle[14];
      arrayOfPointStyle[0] = PointStyle.POINT;
      arrayOfPointStyle[1] = PointStyle.SQUARE;
      arrayOfPointStyle[2] = PointStyle.SQUARE;
      arrayOfPointStyle[3] = PointStyle.SQUARE;
      arrayOfPointStyle[4] = PointStyle.SQUARE;
      arrayOfPointStyle[5] = PointStyle.SQUARE;
      arrayOfPointStyle[6] = PointStyle.SQUARE;
      arrayOfPointStyle[7] = PointStyle.SQUARE;
      arrayOfPointStyle[8] = PointStyle.SQUARE;
      arrayOfPointStyle[9] = PointStyle.SQUARE;
      arrayOfPointStyle[10] = PointStyle.SQUARE;
      arrayOfPointStyle[11] = PointStyle.SQUARE;
      arrayOfPointStyle[12] = PointStyle.SQUARE;
      arrayOfPointStyle[13] = PointStyle.SQUARE;
      localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      localXYMultipleSeriesRenderer.setAxisTitleTextSize(16.0F);
      localXYMultipleSeriesRenderer.setChartTitleTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(15.0F);
      localXYMultipleSeriesRenderer.setPointSize(5.0F);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      localXYMultipleSeriesRenderer.setAntialiasing(true);
      int m = arrayOfInt.length;
      n = 0;
      if (n < m)
        break label1363;
      i1 = localXYMultipleSeriesRenderer.getSeriesRendererCount();
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间");
        localXYMultipleSeriesRenderer.setYTitle("每分钟活动量");
        localXYMultipleSeriesRenderer.setXAxisMin(l1 - 3600000L);
        localXYMultipleSeriesRenderer.setXAxisMax(3600000L + l1);
        localXYMultipleSeriesRenderer.setYAxisMin(-50.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(256.0D);
        localXYMultipleSeriesRenderer.setAxesColor(-3355444);
        localXYMultipleSeriesRenderer.setLabelsColor(-3355444);
        localXYMultipleSeriesRenderer.setXLabels(10);
        localXYMultipleSeriesRenderer.setYLabels(10);
        localXYMultipleSeriesRenderer.setShowGrid(true);
        localXYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        localXYMultipleSeriesRenderer.setYLabelsAlign(Paint.Align.RIGHT);
        localXYMultipleSeriesRenderer.setBackgroundColor(-1);
        return ChartFactory.getTimeChartView(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, "HH:mm");
        SportData localSportData1 = (SportData)localArrayList.get(j);
        int k = localSportData1.getSportMode();
        long l2;
        if (k != 127)
        {
          l2 = paramLong + 60000 * localSportData1.getTimeIndex();
          localXYSeries1.add(l2, localSportData1.getActivity());
          if (k != 0)
            break label1078;
          localXYSeries2.add(l2, -5.0D);
        }
        while (true)
        {
          j++;
          break;
          label1078: if (k == 1)
            localXYSeries3.add(l2, -10.0D);
          else if (k == 2)
            localXYSeries4.add(l2, -15.0D);
          else if (k == 3)
            localXYSeries5.add(l2, -20.0D);
          else if (k == 4)
            localXYSeries6.add(l2, -25.0D);
          else if (k == 5)
            localXYSeries7.add(l2, -30.0D);
        }
        label1178: SportData localSportData2 = (SportData)this.b.get(i3);
        int i4 = localSportData2.getSportMode();
        long l3;
        if (i4 != 127)
        {
          l3 = paramLong + 60000 * localSportData2.getTimeIndex();
          if (i4 != 0)
            break label1242;
          localXYSeries8.add(l3, 5.0D);
        }
        while (true)
        {
          i3++;
          break;
          label1242: if (i4 == 1)
            localXYSeries9.add(l3, 10.0D);
          else if (i4 == 2)
            localXYSeries10.add(l3, 15.0D);
          else if (i4 == 3)
            localXYSeries11.add(l3, 20.0D);
          else if (i4 == 4)
            localXYSeries12.add(l3, 25.0D);
          else if (i4 == 5)
            localXYSeries13.add(l3, 30.0D);
          else if (i4 == 7)
            localXYSeries14.add(l3, 35.0D);
        }
        label1363: XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
        localXYSeriesRenderer.setColor(arrayOfInt[n]);
        localXYSeriesRenderer.setPointStyle(arrayOfPointStyle[n]);
        localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
        n++;
        break label833;
      }
      ((XYSeriesRenderer)localXYMultipleSeriesRenderer.getSeriesRendererAt(i2)).setFillPoints(true);
    }
  }

  public Intent executePieChart(Context paramContext, DaySportData paramDaySportData)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ArrayList localArrayList7 = paramDaySportData.data();
    int i = 0;
    if (i >= localArrayList7.size());
    SportData localSportData;
    int j;
    do
    {
      CategorySeries localCategorySeries = new CategorySeries("饼图");
      localCategorySeries.add("静止", localArrayList1.size());
      localCategorySeries.add("慢走", localArrayList2.size());
      localCategorySeries.add("跑步", localArrayList3.size());
      localCategorySeries.add("没戴", localArrayList4.size());
      localCategorySeries.add("浅睡", localArrayList5.size());
      localCategorySeries.add("深睡", localArrayList6.size());
      DefaultRenderer localDefaultRenderer = new DefaultRenderer();
      SimpleSeriesRenderer localSimpleSeriesRenderer1 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer1.setColor(-16776961);
      SimpleSeriesRenderer localSimpleSeriesRenderer2 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer2.setColor(-65536);
      SimpleSeriesRenderer localSimpleSeriesRenderer3 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer3.setColor(-3355444);
      SimpleSeriesRenderer localSimpleSeriesRenderer4 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer4.setColor(-256);
      SimpleSeriesRenderer localSimpleSeriesRenderer5 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer5.setColor(-16711681);
      SimpleSeriesRenderer localSimpleSeriesRenderer6 = new SimpleSeriesRenderer();
      localSimpleSeriesRenderer6.setColor(-65281);
      localDefaultRenderer.setChartTitle("活动饼图");
      localDefaultRenderer.setChartTitleTextSize(20.0F);
      localDefaultRenderer.setLabelsTextSize(15.0F);
      localDefaultRenderer.setLegendTextSize(15.0F);
      localDefaultRenderer.setMargins(new int[] { 20, 30, 15, 10 });
      localDefaultRenderer.setStartAngle(0.0F);
      localDefaultRenderer.setAntialiasing(true);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer1);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer2);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer3);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer4);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer5);
      localDefaultRenderer.addSeriesRenderer(localSimpleSeriesRenderer6);
      return ChartFactory.getPieChartIntent(paramContext, localCategorySeries, localDefaultRenderer, "hi");
      localSportData = (SportData)localArrayList7.get(i);
      j = localSportData.getSportMode();
    }
    while (j == 127);
    switch (j)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      i++;
      break;
      localArrayList1.add(localSportData);
      continue;
      localArrayList2.add(localSportData);
      continue;
      localArrayList3.add(localSportData);
      continue;
      localArrayList4.add(localSportData);
      continue;
      localArrayList5.add(localSportData);
      continue;
      localArrayList6.add(localSportData);
    }
  }

  public Intent executeStepsBarChart(Context paramContext, StepsInfo paramStepsInfo)
  {
    XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
    ArrayList localArrayList = paramStepsInfo.getStageSteps();
    XYSeries localXYSeries = new XYSeries("计步");
    Iterator localIterator = localArrayList.iterator();
    int i = 20;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localXYMultipleSeriesDataset.addSeries(localXYSeries);
        XYMultipleSeriesRenderer localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
        localXYSeriesRenderer.setColor(-256);
        localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
        localXYMultipleSeriesRenderer.setLabelsTextSize(15.0F);
        localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
        localXYMultipleSeriesRenderer.setAxisTitleTextSize(20.0F);
        localXYMultipleSeriesRenderer.setXTitle("时间（0-23小时）");
        localXYMultipleSeriesRenderer.setYTitle("每小时步数");
        localXYMultipleSeriesRenderer.setXAxisMin(0.0D);
        localXYMultipleSeriesRenderer.setXAxisMax(24.0D);
        localXYMultipleSeriesRenderer.setYAxisMin(0.0D);
        localXYMultipleSeriesRenderer.setYAxisMax(i + i / 20);
        localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
        localXYMultipleSeriesRenderer.setAntialiasing(true);
        localXYMultipleSeriesRenderer.setBarSpacing(0.300000011920929D);
        return ChartFactory.getBarChartIntent(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, BarChart.Type.DEFAULT);
      }
      StageSteps localStageSteps = (StageSteps)localIterator.next();
      localXYSeries.add(localStageSteps.time, localStageSteps.steps);
      if (localStageSteps.steps > i)
        i = localStageSteps.steps;
    }
  }

  public Intent executeStepsBarChart(Context paramContext, DaySportData paramDaySportData)
  {
    XYMultipleSeriesDataset localXYMultipleSeriesDataset = new XYMultipleSeriesDataset();
    ArrayList localArrayList = paramDaySportData.data();
    CategorySeries localCategorySeries = new CategorySeries("计步");
    int i = 0;
    int j = 20;
    int k = localArrayList.size();
    int m = 0;
    if (m >= 1440)
    {
      localXYMultipleSeriesDataset.addSeries(localCategorySeries.toXYSeries());
      XYMultipleSeriesRenderer localXYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
      XYSeriesRenderer localXYSeriesRenderer = new XYSeriesRenderer();
      localXYSeriesRenderer.setColor(-256);
      localXYMultipleSeriesRenderer.addSeriesRenderer(localXYSeriesRenderer);
      localXYMultipleSeriesRenderer.setLabelsTextSize(20.0F);
      localXYMultipleSeriesRenderer.setLegendTextSize(20.0F);
      localXYMultipleSeriesRenderer.setXAxisMin(0.0D);
      localXYMultipleSeriesRenderer.setXAxisMax(24.0D);
      localXYMultipleSeriesRenderer.setYAxisMin(0.0D);
      localXYMultipleSeriesRenderer.setYAxisMax(j + j / 20);
      localXYMultipleSeriesRenderer.setMargins(new int[] { 50, 50, 50, 50 });
      localXYMultipleSeriesRenderer.setAntialiasing(true);
      localXYMultipleSeriesRenderer.setBarSpacing(0.300000011920929D);
      return ChartFactory.getBarChartIntent(paramContext, localXYMultipleSeriesDataset, localXYMultipleSeriesRenderer, BarChart.Type.DEFAULT);
    }
    SportData localSportData;
    if (m < k)
    {
      localSportData = (SportData)localArrayList.get(m);
      int i1 = localSportData.getSportMode();
      if ((i1 != 1) && (i1 != 2));
    }
    for (int n = i + localSportData.getStep(); ; n = i)
    {
      if ((m + 1) % 60 == 0)
      {
        localCategorySeries.add(n);
        if (n > j)
          label267: i = 0;
      }
      while (true)
      {
        m++;
        j = n;
        break;
        n = j;
        break label267;
        i = n;
        n = j;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.DataChart
 * JD-Core Version:    0.6.2
 */