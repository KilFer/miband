package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.PickAdapter;
import kankan.wheel.widget.WheelView;

public class PersonInfoSetWeightActivity extends PersonInfoBaseActivity
  implements View.OnClickListener
{
  private static final String a = "PersonInfoSetWeightActivity";
  private WheelView b;

  private void a()
  {
    this.mPersonInfo.weight = (20 + this.b.getCurrentItem());
    Debug.i("PersonInfoSetWeightActivity", "weight = " + this.mPersonInfo.weight);
  }

  public void onCancel()
  {
    a();
    Debug.i("PersonInfoSetWeightActivity", "onCancel");
    super.onCancel();
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903052);
    super.onCreate(paramBundle);
    this.b = ((WheelView)findViewById(2131165267));
    this.b.setVisibleItems(5).setCenterDrawable(2130837683).setCenterStyle(getString(2131492964), 2131230725, 12, 40.0F, 5.5F).setViewAdapter(new PickAdapter(this, 20, 205, this.b, getResources().getColor(2131230724), getResources().getColor(2131230725), getResources().getColor(2131230765), false, 50, 16, 15, 15));
    if (this.mPersonInfo.weight > 0)
    {
      this.b.setCurrentItem(-20 + this.mPersonInfo.weight);
      return;
    }
    this.b.setCurrentItem(40);
  }

  public void onNext()
  {
    a();
    Debug.i("PersonInfoSetWeightActivity", "onNext");
    super.onNext();
    Intent localIntent = new Intent();
    localIntent.setClass(this, PersonInfoSetSportGoalActivity.class);
    startActivityForResult(localIntent, 6);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideWeight");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideWeight");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoSetWeightActivity
 * JD-Core Version:    0.6.2
 */