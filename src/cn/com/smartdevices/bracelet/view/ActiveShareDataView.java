package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.DynamicShareChartView;
import java.util.HashMap;

public class ActiveShareDataView extends FrameLayout
{
  private DynamicShareChartView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;

  public ActiveShareDataView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ActiveShareDataView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ActiveShareDataView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2130903135, this);
    this.a = ((DynamicShareChartView)findViewById(2131165631));
    this.b = ((TextView)findViewById(2131165624));
    this.c = ((TextView)findViewById(2131165626));
    this.d = ((TextView)findViewById(2131165630));
    this.e = ((TextView)findViewById(2131165629));
  }

  private static HashMap<Integer, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(1000));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2000));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(3000));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(4000));
    localHashMap.put(Integer.valueOf(10), Integer.valueOf(5000));
    localHashMap.put(Integer.valueOf(13), Integer.valueOf(6000));
    localHashMap.put(Integer.valueOf(14), Integer.valueOf(7000));
    return localHashMap;
  }

  public static String[] formatDistance(Context paramContext, int paramInt)
  {
    String[] arrayOfString = new String[2];
    float f = paramInt;
    if (paramInt >= 1000)
    {
      arrayOfString[0] = String.valueOf(Math.round(100.0F * (f / 1000.0F)) / 100.0F);
      arrayOfString[1] = paramContext.getString(2131492924);
      return arrayOfString;
    }
    arrayOfString[0] = String.valueOf(paramInt);
    arrayOfString[1] = paramContext.getString(2131492925);
    return arrayOfString;
  }

  public void bindStepData(HashMap<Integer, Integer> paramHashMap)
  {
    this.a.bindStepData(paramHashMap);
  }

  public void setStepCalorie(int paramInt)
  {
    this.e.setText(String.valueOf(paramInt));
  }

  public void setStepCount(int paramInt)
  {
    this.b.setText(String.valueOf(paramInt));
  }

  public void setStepDistance(int paramInt)
  {
    String[] arrayOfString = formatDistance(getContext(), paramInt);
    this.c.setText(arrayOfString[0]);
    this.d.setText(arrayOfString[1]);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.ActiveShareDataView
 * JD-Core Version:    0.6.2
 */