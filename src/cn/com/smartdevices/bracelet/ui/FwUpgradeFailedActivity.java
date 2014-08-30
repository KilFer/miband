package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class FwUpgradeFailedActivity extends Activity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165227:
    case 2131165228:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    findViewById(2131165227).setOnClickListener(this);
    findViewById(2131165228).setOnClickListener(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.FwUpgradeFailedActivity
 * JD-Core Version:    0.6.2
 */