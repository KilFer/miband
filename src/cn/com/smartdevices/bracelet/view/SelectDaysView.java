package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SelectDaysView extends LinearLayout
{
  private ListView a = null;
  private Context b = null;
  private int c;
  private String[] d;
  private WeekAdapter e;

  public SelectDaysView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SelectDaysView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    View localView = LayoutInflater.from(this.b).inflate(2130903137, null);
    this.a = ((ListView)localView.findViewById(2131165638));
    addView(localView);
  }

  public int getDays()
  {
    return this.e.getDays();
  }

  public void setAdapter(WeekAdapter paramWeekAdapter)
  {
    this.e = paramWeekAdapter;
    this.a.setAdapter(paramWeekAdapter);
  }

  public void setDays(int paramInt)
  {
    this.e.setDays(paramInt);
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setOnItemClickListener(paramOnItemClickListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.SelectDaysView
 * JD-Core Version:    0.6.2
 */