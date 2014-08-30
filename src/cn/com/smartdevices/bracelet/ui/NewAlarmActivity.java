package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetAlarmClockTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.Event12HourUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventAmPmUpdate;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import kankan.wheel.widget.WheelView;

public class NewAlarmActivity extends Activity
  implements View.OnClickListener
{
  public static final int[] FIXED_DAYS = arrayOfInt;
  public static final int INDEX_AM = -11;
  public static final int INDEX_PM = -10;
  private static final String a = "NewAlarmActivity";
  private static final int b = 1;
  private static final int c = 30;
  private static final int d = 0;
  private static final int e = 23;
  private static final int f = 1;
  private static final int g;
  private AlarmClockItem h = null;
  private WheelView i;
  private WheelView j;
  private View k;
  private Context l = null;
  private TextView m;
  private PersonInfo n;
  private ArrayList<AlarmClockItem> o;
  private Switch p;
  private WheelView q;
  private boolean r;
  private PickAdapter s;

  static
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = AlarmClockItem.ALARM_ONCE;
    arrayOfInt[1] = AlarmClockItem.ALARM_EVERY_DAY;
    arrayOfInt[2] = AlarmClockItem.ALARM_MON_2_FRI;
    arrayOfInt[3] = -1;
  }

  private void a(int paramInt)
  {
    Debug.i("NewAlarmActivity", "updateHourByAmPm : " + paramInt);
    int i1;
    if (!this.r)
    {
      i1 = this.i.getCurrentItem();
      Debug.i("NewAlarmActivity", "cur hour =" + i1);
      if (paramInt != 0)
        break label101;
      if (i1 >= 12)
        i1 -= 12;
    }
    while (true)
    {
      Debug.i("NewAlarmActivity", "after hour =" + i1);
      this.i.setCurrentItemLooped(i1);
      return;
      label101: if (i1 < 12)
        i1 += 12;
    }
  }

  private void b(int paramInt)
  {
    Debug.i("NewAlarmActivity", "updateAmPmByHour hour=" + paramInt);
    WheelView localWheelView;
    if ((this.q != null) && (!this.r))
    {
      localWheelView = this.q;
      if (paramInt < 12)
        break label55;
    }
    label55: for (int i1 = 1; ; i1 = 0)
    {
      localWheelView.setCurrentItem(i1);
      return;
    }
  }

  private void c(int paramInt)
  {
    this.h.setDays(paramInt);
    this.m.setText(this.h.toWeekString(this.l));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Debug.i("NewAlarmActivity", "onActivityResult : " + paramInt1 + ", result:" + paramInt2 + " data=" + paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
      c(paramIntent.getIntExtra("Days", 0));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165245:
    case 2131165246:
    default:
      return;
    case 2131165244:
      int i1 = this.i.getCurrentItem();
      Debug.i("NewAlarmActivity", "ampm= " + this.q.getCurrentItem() + " hour =" + i1);
      this.h.set(i1, this.j.getCurrentItem(), true);
      AlarmActivity.setAlarmItems(this.h, this.l);
      new BleSetAlarmClockTask(this.o, new aM(this)).work();
      Intent localIntent = new Intent();
      localIntent.putExtra("alarms", this.h.toJson().toString());
      setResult(-1, localIntent);
      finish();
      return;
    case 2131165243:
      setResult(0);
      finish();
      return;
    case 2131165247:
    }
    Switch localSwitch = this.p;
    boolean bool1 = this.p.isChecked();
    boolean bool2 = false;
    if (bool1);
    while (true)
    {
      localSwitch.setChecked(bool2);
      return;
      bool2 = true;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    this.l = this;
    EventBus.getDefault().register(this);
    this.k = findViewById(2131165251);
    this.k.setOnClickListener(new aK(this));
    this.m = ((TextView)findViewById(2131165253));
    this.q = ((WheelView)findViewById(2131165254));
    PickAdapter localPickAdapter = new PickAdapter(this, -11, -10, this.q, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, false, 46, 6, 5, 7, 1);
    localPickAdapter.setUIStyle("normal");
    localPickAdapter.setMode(17);
    this.q.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle("", 18.0F).setViewAdapter(localPickAdapter);
    this.i = ((WheelView)findViewById(2131165255));
    this.s = new PickAdapter(this, 0, 23, this.i, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, true, 46, 8, 7, 7, 1);
    this.s.setMode(16);
    this.i.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493085), 2131230780, 18.0F).setViewAdapter(this.s);
    this.j = ((WheelView)findViewById(2131165256));
    this.j.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493075), 2131230780, 18.0F).setViewAdapter(new PickAdapter(this, 0, 59, this.j, getResources().getColor(2131230780), getResources().getColor(2131230737), -2003199591, true, 46, 8, 7, 7, 1));
    int i1 = getIntent().getIntExtra("ref_alarm_index", 0);
    this.n = Keeper.readPersonInfo();
    this.o = this.n.getAlarmClockItems();
    this.h = ((AlarmClockItem)this.o.get(i1));
    this.p = ((Switch)findViewById(2131165249));
    boolean bool1;
    Switch localSwitch;
    if (this.h.getDuration() > 0)
    {
      bool1 = true;
      Debug.i("NewAlarmActivity", "smartSwitch: " + bool1 + ", mItem duration=" + this.h.getDuration());
      localSwitch = this.p;
      if (this.h.getDuration() <= 0)
        break label617;
    }
    label617: for (boolean bool2 = true; ; bool2 = false)
    {
      localSwitch.setChecked(bool2);
      this.p.setOnCheckedChangeListener(new aL(this));
      findViewById(2131165247).setOnClickListener(this);
      this.m.setText(this.h.toWeekString(this.l));
      this.i.setCurrentItemLooped(this.h.getHour());
      this.j.setCurrentItemLooped(this.h.getMinute());
      findViewById(2131165244).setOnClickListener(this);
      findViewById(2131165243).setOnClickListener(this);
      return;
      bool1 = false;
      break;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  public void onEvent(Event12HourUpdate paramEvent12HourUpdate)
  {
    b(paramEvent12HourUpdate.getHour());
  }

  public void onEvent(EventAmPmUpdate paramEventAmPmUpdate)
  {
    int i1 = paramEventAmPmUpdate.getAmPm();
    Debug.i("NewAlarmActivity", "updateHourByAmPm : " + i1);
    int i2;
    if (!this.r)
    {
      i2 = this.i.getCurrentItem();
      Debug.i("NewAlarmActivity", "cur hour =" + i2);
      if (i1 != 0)
        break label106;
      if (i2 >= 12)
        i2 -= 12;
    }
    while (true)
    {
      Debug.i("NewAlarmActivity", "after hour =" + i2);
      this.i.setCurrentItemLooped(i2);
      return;
      label106: if (i2 < 12)
        i2 += 12;
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageAlarmNew");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    new DateFormat();
    this.r = DateFormat.is24HourFormat(this);
    if (this.r)
    {
      this.q.setVisibility(8);
      this.s.setMode(9);
      this.i.setViewAdapter(this.s);
    }
    while (true)
    {
      UmengAnalytics.startPage("PageAlarmNew");
      UmengAnalytics.startSession(this);
      return;
      this.q.setVisibility(0);
      this.s.setMode(16);
      this.i.setViewAdapter(this.s);
      b(this.h.getHour());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.NewAlarmActivity
 * JD-Core Version:    0.6.2
 */