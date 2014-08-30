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

public class PersonInfoSetHeightActivity extends PersonInfoBaseActivity
  implements View.OnClickListener
{
  private static final String a = "PersonInfoSetHeightActivity";
  private WheelView b;

  private void a()
  {
    this.mPersonInfo.height = (90 + this.b.getCurrentItem());
    Debug.i("PersonInfoSetHeightActivity", "height = " + this.mPersonInfo.height);
  }

  public void onCancel()
  {
    a();
    Debug.i("PersonInfoSetHeightActivity", "onCancel");
    super.onCancel();
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903050);
    super.onCreate(paramBundle);
    this.b = ((WheelView)findViewById(2131165264));
    this.b.setVisibleItems(5).setCenterDrawable(2130837683).setCenterStyle(getString(2131492959), 2131230725, 12, 40.0F, 5.5F).setViewAdapter(new PickAdapter(this, 90, 230, this.b, getResources().getColor(2131230724), getResources().getColor(2131230725), getResources().getColor(2131230765), false, 50, 16, 15, 15));
    if (this.mPersonInfo.height > 0)
    {
      this.b.setCurrentItem(-90 + this.mPersonInfo.height);
      return;
    }
    this.b.setCurrentItem(80);
  }

  public void onNext()
  {
    a();
    Debug.i("PersonInfoSetHeightActivity", "onNext");
    super.onNext();
    Intent localIntent = new Intent();
    localIntent.setClass(this, PersonInfoSetWeightActivity.class);
    startActivityForResult(localIntent, 6);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideHeight");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideHeight");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoSetHeightActivity
 * JD-Core Version:    0.6.2
 */