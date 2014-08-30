package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.view.DayRepeatAdapter;
import cn.com.smartdevices.bracelet.view.SelectDaysView;

public class AlarmRepeatActivity extends Activity
  implements View.OnClickListener
{
  private static final String a = "AlarmRepeatActivity";
  private SelectDaysView b;
  private int c;
  private TextView d;

  private void a()
  {
    int i = 0;
    int j = 0;
    while (true)
    {
      if (i >= AlarmClockItem.WEEK_MASK.length)
      {
        Debug.i("AlarmRepeatActivity", "bits=" + j);
        TextView localTextView = this.d;
        String str = getString(2131493192);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(j);
        localTextView.setText(String.format(str, arrayOfObject));
        return;
      }
      if ((AlarmClockItem.WEEK_MASK[i] & this.c) != 0)
        j++;
      i++;
    }
  }

  private void b()
  {
    findViewById(2131165243).setOnClickListener(this);
    findViewById(2131165244).setOnClickListener(this);
    this.d = ((TextView)findViewById(2131165319));
    this.b = ((SelectDaysView)findViewById(2131165320));
    Debug.i("AlarmRepeatActivity", "Days : " + this.c);
    String[] arrayOfString = getResources().getStringArray(2131558400);
    this.b.setAdapter(new DayRepeatAdapter(this, arrayOfString, this.c));
    this.b.setOnItemClickListener(new i(this));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165243:
      finish();
      return;
    case 2131165244:
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Days", this.c);
    setResult(-1, localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903060);
    Intent localIntent = getIntent();
    if (localIntent == null)
      this.c = 0;
    this.c = localIntent.getIntExtra("Days", 0);
    findViewById(2131165243).setOnClickListener(this);
    findViewById(2131165244).setOnClickListener(this);
    this.d = ((TextView)findViewById(2131165319));
    this.b = ((SelectDaysView)findViewById(2131165320));
    Debug.i("AlarmRepeatActivity", "Days : " + this.c);
    String[] arrayOfString = getResources().getStringArray(2131558400);
    this.b.setAdapter(new DayRepeatAdapter(this, arrayOfString, this.c));
    this.b.setOnItemClickListener(new i(this));
    a();
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageAlarmNewRepeatCustom");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageAlarmNewRepeatCustom");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.AlarmRepeatActivity
 * JD-Core Version:    0.6.2
 */