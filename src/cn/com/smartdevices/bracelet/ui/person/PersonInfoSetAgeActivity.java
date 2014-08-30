package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.PickAdapter;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;

public class PersonInfoSetAgeActivity extends PersonInfoBaseActivity
  implements View.OnClickListener
{
  private static final String a = "PersonInfoSetAgeActivity";
  private WheelView b;

  private void a()
  {
    this.mPersonInfo.age = (5 + this.b.getCurrentItem());
    int i = Calendar.getInstance().get(1) - this.mPersonInfo.age;
    this.mPersonInfo.birthday = (i + "-01");
    Debug.i("PersonInfoSetAgeActivity", "birthday = " + this.mPersonInfo.birthday + ", age =" + this.mPersonInfo.age);
  }

  public void onCancel()
  {
    a();
    super.onCancel();
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903048);
    super.onCreate(paramBundle);
    this.b = ((WheelView)findViewById(2131165258));
    this.b.setVisibleItems(5).setCenterDrawable(2130837683).setCenterStyle(getString(2131493122), 2131230725, 12, 40.0F, 5.5F).setViewAdapter(new PickAdapter(this, 5, 100, this.b, getResources().getColor(2131230724), getResources().getColor(2131230725), getResources().getColor(2131230765), false, 50, 16, 15, 15));
    if (this.mPersonInfo.age > 0)
      this.b.setCurrentItem(-5 + this.mPersonInfo.age);
    while (true)
    {
      Intent localIntent = getIntent();
      String str1 = localIntent.getStringExtra("miliao_icon_url");
      if ((str1 != null) && (str1.length() > 0))
        this.mPersonInfo.avatarUrl = str1;
      String str2 = localIntent.getStringExtra("miliao_nick_name");
      if ((str2 != null) && (str2.length() > 0))
        this.mPersonInfo.nickname = localIntent.getStringExtra("miliao_nick_name");
      return;
      this.b.setCurrentItem(15);
    }
  }

  public void onNext()
  {
    a();
    super.onNext();
    Intent localIntent = new Intent();
    localIntent.setClass(this, PersonInfoSetHeightActivity.class);
    startActivityForResult(localIntent, 6);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideAge");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideAge");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoSetAgeActivity
 * JD-Core Version:    0.6.2
 */