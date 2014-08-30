package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.PickAdapter;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import kankan.wheel.widget.WheelView;

public class PersonInfoSetSportGoalActivity extends PersonInfoBaseActivity
  implements View.OnClickListener
{
  public static final int VALUE_GAP = 1000;
  private static final String a = "PersonInfoSetSportGoalActivity";
  private WheelView b;
  private TextView c;

  private void a()
  {
    this.mPersonInfo.setDaySportGoals(2000 + 1000 * this.b.getCurrentItem());
    Debug.i("PersonInfoSetSportGoalActivity", "goalStep = " + this.mPersonInfo.getDaySportGoalSteps());
  }

  private void a(boolean paramBoolean)
  {
    setResult(-1);
    finish();
    Intent localIntent = new Intent();
    localIntent.setClass(this, SearchSingleBraceletActivity.class);
    startActivity(localIntent);
  }

  public void onCancel()
  {
    a();
    Debug.i("PersonInfoSetSportGoalActivity", "onCancel");
    super.onCancel();
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903051);
    super.onCreate(paramBundle);
    this.b = ((WheelView)findViewById(2131165266));
    this.b.setVisibleItems(5).setCenterDrawable(2130837683).setCenterStyle(getString(2131492985), 2131230725, 12, 60.0F, 5.5F).setViewAdapter(new PickAdapter(this, 2, 30, this.b, getResources().getColor(2131230724), getResources().getColor(2131230725), getResources().getColor(2131230765), false, 50, 16, 15, 15, 1000));
    this.c = ((TextView)findViewById(2131165265));
    if (this.mPersonInfo.age < 17)
    {
      this.c.setText(2131493011);
      if (this.mPersonInfo.getDaySportGoalSteps() < 0)
        this.mPersonInfo.setDaySportGoals(12000);
    }
    while (true)
    {
      int i = (-2000 + this.mPersonInfo.getDaySportGoalSteps()) / 1000;
      Debug.i("PersonInfoSetSportGoalActivity", "curitem:" + i);
      this.b.setCurrentItem(i);
      return;
      this.c.setText(2131493010);
      if (this.mPersonInfo.getDaySportGoalSteps() < 0)
        this.mPersonInfo.setDaySportGoals(8000);
    }
  }

  public void onNext()
  {
    a();
    Debug.i("PersonInfoSetSportGoalActivity", "onNext");
    super.onNext();
    this.mPersonInfo.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.mPersonInfo);
    updateProfile(this.mPersonInfo);
    setResult(-1);
    finish();
    Intent localIntent = new Intent();
    localIntent.setClass(this, SearchSingleBraceletActivity.class);
    startActivity(localIntent);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideGoal");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideGoal");
    UmengAnalytics.startSession(this);
  }

  public void updateProfile(PersonInfo paramPersonInfo)
  {
    LoginData localLoginData = Keeper.readLoginData();
    paramPersonInfo.uid = localLoginData.uid;
    WebAPI.updateProfile(localLoginData, paramPersonInfo, new a(this, paramPersonInfo));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoSetSportGoalActivity
 * JD-Core Version:    0.6.2
 */