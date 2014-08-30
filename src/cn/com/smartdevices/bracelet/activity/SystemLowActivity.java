package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class SystemLowActivity extends Activity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165244:
    }
    setResult(-1);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903133);
    ((Button)findViewById(2131165244)).setOnClickListener(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageSystemLow");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageSystemLow");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.SystemLowActivity
 * JD-Core Version:    0.6.2
 */