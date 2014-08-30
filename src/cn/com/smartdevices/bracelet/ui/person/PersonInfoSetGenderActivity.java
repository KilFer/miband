package cn.com.smartdevices.bracelet.ui.person;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.DimPanelBottomBar;

public class PersonInfoSetGenderActivity extends PersonInfoBaseActivity
  implements View.OnClickListener
{
  private static final String a = "PersonInfoSetGenderActivity";
  private ImageView b;
  private ImageView c;
  private View d;
  private DimPanelBottomBar e;

  private void a()
  {
    int i = this.mPersonInfo.gender;
    if (i == 1)
    {
      this.b.setImageResource(2130837635);
      this.c.setImageResource(2130837595);
      this.d.setBackgroundResource(2131230784);
      this.e.setLeftButtonTextColor(getResources().getColor(2131230725));
      this.e.setRightButtonTextColor(getResources().getColor(2131230724));
      return;
    }
    if (i == 0)
    {
      this.c.setImageResource(2130837596);
      this.b.setImageResource(2130837634);
      this.d.setBackgroundResource(2131230783);
      this.e.setLeftButtonTextColor(getResources().getColor(2131230725));
      this.e.setRightButtonTextColor(getResources().getColor(2131230724));
      return;
    }
    this.e.setLeftButtonTextColor(getResources().getColor(2131230725));
    this.e.setRightButtonTextColor(getResources().getColor(2131230789));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131165262:
    case 2131165263:
    }
    while (true)
    {
      super.onClick(paramView);
      return;
      this.mPersonInfo.gender = 1;
      a();
      continue;
      this.mPersonInfo.gender = 0;
      a();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903049);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("miliao_icon_url");
    if ((str1 != null) && (str1.length() > 0))
      this.mPersonInfo.avatarUrl = str1;
    String str2 = localIntent.getStringExtra("miliao_nick_name");
    if ((str2 != null) && (str2.length() > 0))
      this.mPersonInfo.nickname = localIntent.getStringExtra("miliao_nick_name");
    this.b = ((ImageView)findViewById(2131165262));
    this.b.setOnClickListener(this);
    this.c = ((ImageView)findViewById(2131165263));
    this.c.setOnClickListener(this);
    this.e = ((DimPanelBottomBar)findViewById(2131165259));
    this.d = findViewById(2131165260);
    a();
  }

  public void onNext()
  {
    super.onNext();
    if ((this.mPersonInfo.gender != 1) && (this.mPersonInfo.gender != 0))
    {
      Toast.makeText(this, 2131493119, 0).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, PersonInfoSetAgeActivity.class);
    startActivityForResult(localIntent, 6);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonGuideGender");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonGuideGender");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity
 * JD-Core Version:    0.6.2
 */