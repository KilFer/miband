package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;

public class UnBindActivity extends Activity
  implements View.OnClickListener
{
  private void a()
  {
    Utils.showProgressDialog(this, 2131493200);
    Debug.f("switch", "unbind device now!");
    Keeper.keepBraceletBtInfo(new BraceletBtInfo());
    Keeper.keepSyncTime(-1L);
    Keeper.keepSyncRealStepTime(-1L);
    Keeper.keepNeedBind(0);
    Utils.switchBracelet(this, 0);
    new Handler().postDelayed(new bQ(this), 3000L);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165332:
      Utils.showProgressDialog(this, 2131493200);
      Debug.f("switch", "unbind device now!");
      Keeper.keepBraceletBtInfo(new BraceletBtInfo());
      Keeper.keepSyncTime(-1L);
      Keeper.keepSyncRealStepTime(-1L);
      Keeper.keepNeedBind(0);
      Utils.switchBracelet(this, 0);
      new Handler().postDelayed(new bQ(this), 3000L);
      return;
    case 2131165230:
    case 2131165334:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903088);
    findViewById(2131165230).setOnClickListener(this);
    findViewById(2131165332).setOnClickListener(this);
    findViewById(2131165334).setOnClickListener(this);
    if (!Utils.isSupportUnlockScreenByBracelet(this))
      ((TextView)findViewById(2131165404)).setVisibility(4);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletUnbind");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletUnbind");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.UnBindActivity
 * JD-Core Version:    0.6.2
 */