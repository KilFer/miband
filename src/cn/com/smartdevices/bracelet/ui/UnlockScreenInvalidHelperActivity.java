package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class UnlockScreenInvalidHelperActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903057);
    findViewById(2131165315).setOnClickListener(new bR(this));
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageUnlockInvaildHelp");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageUnlockInvaildHelp");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.UnlockScreenInvalidHelperActivity
 * JD-Core Version:    0.6.2
 */