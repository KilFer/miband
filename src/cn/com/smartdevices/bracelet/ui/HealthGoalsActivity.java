package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleSetGoalsTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventGoalsUpdated;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

public class HealthGoalsActivity extends Activity
  implements View.OnClickListener
{
  private static final String a = "HealthGoalsActivity";
  private static final int b = 1000;
  private PersonInfo c;
  private WheelView d;
  private TextView e;

  private void a()
  {
    this.d = ((WheelView)findViewById(2131165266));
    this.d.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131492985), 2131230737, 12, 60.0F, 5.5F).setViewAdapter(new PickAdapter(this, 2, 30, this.d, getResources().getColor(2131230736), getResources().getColor(2131230738), getResources().getColor(2131230739), false, 50, 16, 15, 15, 1000));
    this.e = ((TextView)findViewById(2131165265));
    if (this.c.age < 17)
    {
      this.e.setText(2131493011);
      if (this.c.getDaySportGoalSteps() < 0)
        this.c.setDaySportGoals(12000);
    }
    while (true)
    {
      int i = (-2000 + this.c.getDaySportGoalSteps()) / 1000;
      Debug.i("HealthGoalsActivity", "curitem:" + i);
      this.d.setCurrentItem(i);
      findViewById(2131165243).setOnClickListener(this);
      findViewById(2131165244).setOnClickListener(this);
      return;
      this.e.setText(2131493010);
      if (this.c.getDaySportGoalSteps() < 0)
        this.c.setDaySportGoals(8000);
    }
  }

  private void b()
  {
    this.c.setDaySportGoals(2000 + 1000 * this.d.getCurrentItem());
    Debug.i("HealthGoalsActivity", "goalStep = " + this.c.getDaySportGoalSteps());
    new BleSetGoalsTask(this.c.getDaySportGoalSteps(), new ai(this)).work();
    Keeper.keepPersonInfo(this.c);
    updateProfile(this.c);
    Debug.i("HealthGoalsActivity", "sync goal to mili ok.");
    EventBus.getDefault().post(new EventGoalsUpdated());
    setResult(-1);
    finish();
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
    this.c.setDaySportGoals(2000 + 1000 * this.d.getCurrentItem());
    Debug.i("HealthGoalsActivity", "goalStep = " + this.c.getDaySportGoalSteps());
    new BleSetGoalsTask(this.c.getDaySportGoalSteps(), new ai(this)).work();
    Keeper.keepPersonInfo(this.c);
    updateProfile(this.c);
    Debug.i("HealthGoalsActivity", "sync goal to mili ok.");
    EventBus.getDefault().post(new EventGoalsUpdated());
    setResult(-1);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903114);
    this.c = Keeper.readPersonInfo();
    this.d = ((WheelView)findViewById(2131165266));
    this.d.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131492985), 2131230737, 12, 60.0F, 5.5F).setViewAdapter(new PickAdapter(this, 2, 30, this.d, getResources().getColor(2131230736), getResources().getColor(2131230738), getResources().getColor(2131230739), false, 50, 16, 15, 15, 1000));
    this.e = ((TextView)findViewById(2131165265));
    if (this.c.age < 17)
    {
      this.e.setText(2131493011);
      if (this.c.getDaySportGoalSteps() < 0)
        this.c.setDaySportGoals(12000);
    }
    while (true)
    {
      int i = (-2000 + this.c.getDaySportGoalSteps()) / 1000;
      Debug.i("HealthGoalsActivity", "curitem:" + i);
      this.d.setCurrentItem(i);
      findViewById(2131165243).setOnClickListener(this);
      findViewById(2131165244).setOnClickListener(this);
      return;
      this.e.setText(2131493010);
      if (this.c.getDaySportGoalSteps() < 0)
        this.c.setDaySportGoals(8000);
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
    super.onResume();
    UmengAnalytics.endPage("PageBraceletGoal");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletGoal");
    UmengAnalytics.startSession(this);
  }

  public void updateProfile(PersonInfo paramPersonInfo)
  {
    LoginData localLoginData = Keeper.readLoginData();
    paramPersonInfo.uid = localLoginData.uid;
    WebAPI.updateProfile(localLoginData, paramPersonInfo, new aj(this, paramPersonInfo));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.HealthGoalsActivity
 * JD-Core Version:    0.6.2
 */