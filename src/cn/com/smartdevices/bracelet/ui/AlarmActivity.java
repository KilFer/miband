package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.google.gson.Gson;
import de.greenrobot.event.EventBus;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class AlarmActivity extends Activity
  implements View.OnClickListener
{
  public static final int ALARM_NUM = 3;
  public static final String ALARM_TIME = "alarmtime";
  public static final String ALERT = "alert";
  public static final String DAYS_OF_WEEK = "daysofweek";
  public static final String ENABLED = "enabled";
  public static final String HOUR = "hour";
  public static final String ID = "_id";
  public static final String MESSAGE = "message";
  public static final String MINUTES = "minutes";
  public static final String REF_ALARM_INDEX = "ref_alarm_index";
  public static final String VIBRATE = "vibrate";
  private static final int a = 257;
  private static final int b = 1;
  private static final String c = "AlarmActivity";
  private static final String d = "ALARM_ONCE_TRIGGLED";
  private static final String l = "content://com.android.deskclock/alarm";
  private Activity e;
  private Handler f;
  private PersonInfo g;
  private ListView h;
  private e i;
  private ArrayList<AlarmClockItem> j = new ArrayList();
  private int k;
  private BroadcastReceiver m;
  private View n;
  private TextView o;
  private View p;
  private boolean q;

  private void a()
  {
    this.n.setVisibility(8);
    this.p.setBackgroundResource(2131230780);
  }

  private void a(ContentResolver paramContentResolver)
  {
    String str1 = Settings.System.getString(paramContentResolver, "alarm_alert");
    String str2 = Settings.System.getString(paramContentResolver, "next_alarm_formatted");
    Debug.i("AlarmActivity", "system alarm = " + str1 + ", nextAlarm=" + str2);
    Uri localUri = Uri.parse("content://com.android.deskclock/alarm");
    Cursor localCursor = this.e.getContentResolver().query(localUri, new String[] { "_id", "hour", "minutes", "daysofweek", "enabled" }, null, null, null);
    Object localObject1 = null;
    if (localCursor != null);
    try
    {
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0))
            break label407;
          Debug.i("AlarmActivity", Utils.getGson().toJson(localObject1));
          Keeper.keepMorningAlarms(Utils.getGson().toJson(localObject1));
          return;
        }
        Debug.i("AlarmActivity", "id: " + localCursor.getInt(0) + "\t hour: " + localCursor.getInt(localCursor.getColumnIndex("hour")) + ", min=" + localCursor.getInt(localCursor.getColumnIndex("minutes")) + ", enabled=" + localCursor.getInt(localCursor.getColumnIndex("enabled")));
        int i1 = localCursor.getInt(localCursor.getColumnIndex("hour"));
        int i2 = localCursor.getInt(localCursor.getColumnIndex("minutes"));
        if (localCursor.getInt(localCursor.getColumnIndex("enabled")) != 1)
          break;
        i3 = 1;
        if ((i3 != 0) && (i1 >= 5) && (i1 <= 10))
        {
          if (localObject1 == null)
            localObject1 = new ArrayList(3);
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.set(11, i1);
          localCalendar.set(12, i2);
          ((ArrayList)localObject1).add(localCalendar);
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        return;
        int i3 = 0;
        continue;
        label407: Keeper.keepMorningAlarms("");
      }
    }
    finally
    {
      localCursor.close();
    }
  }

  private void b()
  {
    this.n.setVisibility(0);
    this.p.setBackgroundResource(2131230781);
  }

  private void c()
  {
    this.m = new b(this);
    this.e.registerReceiver(this.m, new IntentFilter("ALARM_ONCE_TRIGGLED"));
  }

  private void d()
  {
    this.h = ((ListView)findViewById(2131165318));
    this.i = new e(this);
    this.h.setAdapter(this.i);
    this.n = findViewById(2131165226);
    this.o = ((TextView)findViewById(2131165230));
    this.o.setOnClickListener(this);
    this.p = findViewById(2131165317);
  }

  private void e()
  {
    try
    {
      ContentResolver localContentResolver = this.e.getContentResolver();
      localContentResolver.registerContentObserver(Uri.parse("content://com.android.deskclock/alarm"), true, new d(this, null, localContentResolver));
      a(localContentResolver);
      this.j = this.g.getAlarmClockItems();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void f()
  {
    this.f.removeMessages(1);
    this.f.sendMessageDelayed(this.f.obtainMessage(1), 2000L);
  }

  private void g()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      String str = URLEncoder.encode(Utils.getGson().toJson(this.j), "utf-8");
      localHashMap.put("alarm_clock", str);
      Debug.i("AlarmActivity", "alarm encoded str = " + str);
      Utils.updateProfile(this.g, localHashMap, new c(this));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  private void h()
  {
    ContentResolver localContentResolver = this.e.getContentResolver();
    localContentResolver.registerContentObserver(Uri.parse("content://com.android.deskclock/alarm"), true, new d(this, null, localContentResolver));
    a(localContentResolver);
  }

  public static void setAlarmItems(AlarmClockItem paramAlarmClockItem, Context paramContext)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(localCalendar1.get(1), localCalendar1.get(2), localCalendar1.get(5), paramAlarmClockItem.getHour(), paramAlarmClockItem.getMinute(), 0);
    Calendar localCalendar2 = Calendar.getInstance();
    if ((paramAlarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE) && (localCalendar1.before(localCalendar2)))
    {
      localCalendar1.add(6, 1);
      Debug.i("AlarmActivity", "after add one day :" + localCalendar1);
    }
    paramAlarmClockItem.setCalendar(localCalendar1);
    paramAlarmClockItem.setUpdate(true);
    if (paramAlarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE)
    {
      long l1 = localCalendar1.getTimeInMillis();
      Intent localIntent = new Intent("ALARM_ONCE_TRIGGLED");
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, localCalendar1.hashCode(), localIntent, 134217728);
      ((AlarmManager)paramContext.getSystemService("alarm")).set(0, l1, localPendingIntent);
    }
  }

  public void checkOnceAlarmIfExpired()
  {
    this.j = this.g.getAlarmClockItems();
    Calendar localCalendar = Calendar.getInstance();
    Iterator localIterator = this.j.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Keeper.keepPersonInfo(this.g);
        this.i.notifyDataSetChanged();
        return;
      }
      AlarmClockItem localAlarmClockItem = (AlarmClockItem)localIterator.next();
      if ((localAlarmClockItem.getDays() == AlarmClockItem.ALARM_ONCE) && (localAlarmClockItem.getCalendar().before(localCalendar)))
        localAlarmClockItem.setEnabled(false);
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 257) && (paramInt2 == -1))
    {
      AlarmClockItem localAlarmClockItem = AlarmClockItem.fromJson(paramIntent.getStringExtra("alarms"));
      this.j.set(this.k, localAlarmClockItem);
      this.i.notifyDataSetChanged();
      this.g.setNeedSyncServer(2);
      Keeper.keepPersonInfo(this.g);
      f();
    }
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    if (paramConnStatus.a == 8)
    {
      this.n.setVisibility(8);
      this.p.setBackgroundResource(2131230780);
    }
    while (paramConnStatus.a >= 8)
      return;
    b();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventBus.getDefault().register(this, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
    setContentView(2130903059);
    this.e = this;
    this.f = new a(this);
    this.g = Keeper.readPersonInfo();
    try
    {
      ContentResolver localContentResolver = this.e.getContentResolver();
      localContentResolver.registerContentObserver(Uri.parse("content://com.android.deskclock/alarm"), true, new d(this, null, localContentResolver));
      a(localContentResolver);
      this.j = this.g.getAlarmClockItems();
      this.h = ((ListView)findViewById(2131165318));
      this.i = new e(this);
      this.h.setAdapter(this.i);
      this.n = findViewById(2131165226);
      this.o = ((TextView)findViewById(2131165230));
      this.o.setOnClickListener(this);
      this.p = findViewById(2131165317);
      this.m = new b(this);
      this.e.registerReceiver(this.m, new IntentFilter("ALARM_ONCE_TRIGGLED"));
      if (!Utils.isBraceletConnected())
        b();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
    this.e.unregisterReceiver(this.m);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageAlarm");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    checkOnceAlarmIfExpired();
    new DateFormat();
    this.q = DateFormat.is24HourFormat(this);
    if (this.i != null)
      this.i.notifyDataSetChanged();
    UmengAnalytics.startPage("PageAlarm");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.AlarmActivity
 * JD-Core Version:    0.6.2
 */