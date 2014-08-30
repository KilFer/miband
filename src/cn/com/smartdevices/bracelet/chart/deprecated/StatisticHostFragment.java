package cn.com.smartdevices.bracelet.chart.deprecated;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventSwitchViewMode;
import cn.com.smartdevices.bracelet.eventbus.EventUpdateTitle;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.view.CustomViewPager;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.util.ArrayList;

public class StatisticHostFragment extends TabsFragment
  implements View.OnClickListener
{
  public static final int DEFAULT_MODE = 257;
  public static final int MODE_AVERAGE = 256;
  public static final int MODE_DETAIL = 16;
  public static final int MODE_SIMPLE = 1;
  public static final int MODE_TOTAL = 4096;
  private static final String a = "Statistic.Host";
  public static int sMode;
  private View b;
  private View c;
  private TextView d;
  private View e;
  private View f;
  private View g;
  private View h;

  private int a(Context paramContext)
  {
    int i = 257;
    int j = paramContext.getSharedPreferences("StatisticViewMode", 0).getInt("Mode", i);
    if (((j & 0x1) == 0) && ((j & 0x10) == 0))
      Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
    while (true)
    {
      a(paramContext, i);
      Debug.i("Statistic.Host", "Read Mode : " + Integer.toHexString(i));
      return i;
      if (((j & 0x100) == 0) && ((j & 0x1000) == 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else if (((j & 0x1) > 0) && ((j & 0x10) > 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else if (((j & 0x100) > 0) && ((j & 0x1000) > 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else
        i = j;
    }
  }

  private void a()
  {
    View localView = getView().findViewById(2131165184);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp.jpg";
    Utils.saveBitmapToFile(str, localBitmap);
    localView.findViewById(2131165184).destroyDrawingCache();
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), ShareActivity.class);
    localIntent.putExtra("date", this.d.getText());
    localIntent.putExtra("Mode", 1);
    localIntent.putExtra("Image", str);
    startActivityForResult(localIntent, 32769);
  }

  private void a(int paramInt)
  {
    if ((paramInt & sMode) == 0)
    {
      i = sMode;
      if ((paramInt != 1) && (paramInt != 16))
        break label67;
    }
    for (int i = 0xFFFFFFEF & (0xFFFFFFFE & sMode); ; i = 0xFFFFEFFF & (0xFFFFFEFF & sMode))
      label67: 
      do
      {
        int j = i | paramInt;
        sMode = j;
        a(getActivity(), j);
        b();
        EventBus.getDefault().post(new EventSwitchViewMode());
        return;
      }
      while ((paramInt != 256) && (paramInt != 4096));
  }

  private static void a(Context paramContext, int paramInt)
  {
    Debug.i("Statistic.Host", "Save Mode : " + Integer.toHexString(paramInt));
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("StatisticViewMode", 0).edit();
    localEditor.putInt("Mode", paramInt);
    localEditor.commit();
  }

  private void b()
  {
    if ((0x1 & sMode) > 0)
    {
      this.e.setActivated(true);
      this.f.setActivated(false);
    }
    do
      while ((0x100 & sMode) > 0)
      {
        this.g.setActivated(true);
        this.h.setActivated(false);
        return;
        if ((0x10 & sMode) > 0)
        {
          this.e.setActivated(false);
          this.f.setActivated(true);
        }
      }
    while ((0x1000 & sMode) <= 0);
    this.g.setActivated(false);
    this.h.setActivated(true);
  }

  public void fillFragmentTabs(ArrayList<TabsFragment.FragmentTab> paramArrayList)
  {
    TabsFragment.FragmentTab localFragmentTab1 = new TabsFragment.FragmentTab(this);
    localFragmentTab1.a = getString(2131493189);
    localFragmentTab1.b = StatisticDailyFragment.class;
    paramArrayList.add(localFragmentTab1);
    TabsFragment.FragmentTab localFragmentTab2 = new TabsFragment.FragmentTab(this);
    localFragmentTab2.a = getString(2131493314);
    localFragmentTab2.b = StatisticWeeklyFragment.class;
    paramArrayList.add(localFragmentTab2);
    TabsFragment.FragmentTab localFragmentTab3 = new TabsFragment.FragmentTab(this);
    localFragmentTab3.a = getString(2131493315);
    localFragmentTab3.b = StatisticMonthlyFragment.class;
    paramArrayList.add(localFragmentTab3);
  }

  protected int inflateLayout()
  {
    return 2130903110;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mPager.setOnPageChangeListener(new t(this));
    ((CustomViewPager)this.mPager).setSwipeable(false);
    this.b = getView().findViewById(2131165230);
    this.b.setOnClickListener(this);
    this.c = getView().findViewById(2131165342);
    this.c.setOnClickListener(this);
    this.d = ((TextView)getView().findViewById(2131165387));
    this.e = getView().findViewById(2131165504);
    this.f = getView().findViewById(2131165505);
    this.g = getView().findViewById(2131165507);
    this.h = getView().findViewById(2131165508);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    b();
  }

  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
      getActivity().finish();
      return;
    case 2131165342:
      View localView = getView().findViewById(2131165184);
      localView.buildDrawingCache();
      Bitmap localBitmap = localView.getDrawingCache();
      String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp.jpg";
      Utils.saveBitmapToFile(str, localBitmap);
      localView.findViewById(2131165184).destroyDrawingCache();
      Intent localIntent = new Intent();
      localIntent.setClass(getActivity(), ShareActivity.class);
      localIntent.putExtra("date", this.d.getText());
      localIntent.putExtra("Mode", 1);
      localIntent.putExtra("Image", str);
      startActivityForResult(localIntent, 32769);
      return;
    case 2131165504:
      a(1);
      return;
    case 2131165505:
      a(16);
      return;
    case 2131165507:
      a(256);
      return;
    case 2131165508:
    }
    a(4096);
  }

  public void onCreate(Bundle paramBundle)
  {
    int i = 257;
    super.onCreate(paramBundle);
    EventBus.getDefault().register(this);
    Activity localActivity = getActivity();
    int j = localActivity.getSharedPreferences("StatisticViewMode", 0).getInt("Mode", i);
    if (((j & 0x1) == 0) && ((j & 0x10) == 0))
      Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
    while (true)
    {
      a(localActivity, i);
      Debug.i("Statistic.Host", "Read Mode : " + Integer.toHexString(i));
      sMode = i;
      return;
      if (((j & 0x100) == 0) && ((j & 0x1000) == 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else if (((j & 0x1) > 0) && ((j & 0x10) > 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else if (((j & 0x100) > 0) && ((j & 0x1000) > 0))
        Debug.w("Statistic.Host", "Invalid Mode Code : " + j);
      else
        i = j;
    }
  }

  public void onDestroy()
  {
    EventBus.getDefault().unregister(this);
    super.onDestroy();
  }

  public void onEvent(EventUpdateTitle paramEventUpdateTitle)
  {
    this.d.setText(paramEventUpdateTitle.title);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticHostFragment
 * JD-Core Version:    0.6.2
 */