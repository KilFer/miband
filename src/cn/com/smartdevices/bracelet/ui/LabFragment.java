package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.com.smartdevices.bracelet.DataChart;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LabFragment extends Fragment
{
  public static LabFragment newInstance()
  {
    LabFragment localLabFragment = new LabFragment();
    localLabFragment.setArguments(new Bundle());
    return localLabFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903083, null);
    localView.findViewById(2131165396);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131165394);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131165395);
    SportDay localSportDay = DataManager.getInstance().getCurDay();
    DaySportData localDaySportData = DataManager.getInstance().get(localSportDay);
    String str = localSportDay.toString();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      Date localDate2 = localSimpleDateFormat.parse(str);
      localDate1 = localDate2;
      localLinearLayout1.addView(DataChart.getInstance().executeLineChartView3(getActivity(), localDaySportData, localDate1.getTime()));
      localLinearLayout2.addView(DataChart.getInstance().executeLineChartView2(getActivity(), localDaySportData, localDate1.getTime()));
      localLinearLayout2.setVisibility(8);
      setHasOptionsMenu(true);
      return localView;
    }
    catch (Exception localException)
    {
      while (true)
        Date localDate1 = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.LabFragment
 * JD-Core Version:    0.6.2
 */