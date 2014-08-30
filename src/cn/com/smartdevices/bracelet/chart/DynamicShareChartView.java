package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.util.AttributeSet;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DynamicShareChartView extends BaseChartView<DynamicShareChart>
{
  private static final String a = "Chart.DynamicShareChartView";
  private Renderer b;

  public DynamicShareChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DynamicShareChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicShareChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new DynamicShareChart(paramContext);
    this.b = new ColorRenderer(1090519039);
  }

  private void a(List<DynamicDetailChartView.DynamicDetailChartStepData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        ((DynamicShareChart)this.mChart).fillItems(localArrayList);
        ((DynamicShareChart)this.mChart).notifyChanged();
        return;
      }
      DynamicDetailChartView.DynamicDetailChartStepData localDynamicDetailChartStepData = (DynamicDetailChartView.DynamicDetailChartStepData)localIterator.next();
      DynamicShareChart.DynamicShareBarItem localDynamicShareBarItem = new DynamicShareChart.DynamicShareBarItem();
      localDynamicShareBarItem.value = localDynamicDetailChartStepData.step;
      localDynamicShareBarItem.index = localDynamicDetailChartStepData.index;
      localDynamicShareBarItem.setRenderer(this.b);
      localArrayList.add(localDynamicShareBarItem);
    }
  }

  public void bindStepData(HashMap<Integer, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    int i = ((DynamicShareChart)this.mChart).getTotalHours();
    Iterator localIterator = paramHashMap.keySet().iterator();
    int j = 0;
    int n;
    int k;
    if (!localIterator.hasNext())
    {
      Debug.i("Chart.DynamicShareChartView", "Max Index : " + j);
      if (j <= i)
        break label247;
      n = j - i;
      if (n % 2 == 0)
        break label175;
      k = n + 2;
    }
    while (true)
    {
      label90: Debug.i("Chart.DynamicShareChartView", "Index Offset: " + k);
      ((DynamicShareChart)this.mChart).setOffsetHour(k);
      for (int m = k; ; m++)
      {
        if (m >= k + i)
        {
          a(localArrayList);
          return;
          Integer localInteger = (Integer)localIterator.next();
          if (localInteger.intValue() <= j)
            break;
          j = localInteger.intValue();
          break;
          label175: k = n + 1;
          break label90;
        }
        DynamicDetailChartView.DynamicDetailChartStepData localDynamicDetailChartStepData = new DynamicDetailChartView.DynamicDetailChartStepData();
        localDynamicDetailChartStepData.index = m;
        if (paramHashMap.get(Integer.valueOf(m)) != null)
          localDynamicDetailChartStepData.step = ((Integer)paramHashMap.get(Integer.valueOf(m))).intValue();
        localArrayList.add(localDynamicDetailChartStepData);
      }
      label247: k = 1;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicShareChartView
 * JD-Core Version:    0.6.2
 */