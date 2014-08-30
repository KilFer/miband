package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class HelpActivity extends Activity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165522:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903115);
    findViewById(2131165522).setOnClickListener(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletNotFoundHelp");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletNotFoundHelp");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.HelpActivity
 * JD-Core Version:    0.6.2
 */