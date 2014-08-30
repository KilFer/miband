package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;

public class MultiBraceletErrActivity extends Activity
  implements View.OnClickListener
{
  private static final String a = "MultiBraceletErrActivity";

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 6) && (paramInt2 == -1))
      finish();
  }

  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165536:
      localIntent.putExtra("REF_SEARCH_DEV_MODE", false);
      localIntent.setClass(this, SearchSingleBraceletActivity.class);
      startActivity(localIntent);
      finish();
      return;
    case 2131165535:
      localIntent.putExtra("REF_SEARCH_DEV_MODE", true);
      localIntent.setClass(this, SearchSingleBraceletActivity.class);
      startActivityForResult(localIntent, 6);
      return;
    case 2131165325:
    }
    Keeper.keepNeedBind(0);
    localIntent.setClass(this, MainUIActivity.class);
    startActivity(localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903119);
    int i = getIntent().getIntExtra("REF_NOT_KNOCKED", -1);
    Debug.i("MultiBraceletErrActivity", "infoResId " + i);
    if (i > 0)
      ((TextView)findViewById(2131165534)).setText(i);
    findViewById(2131165536).setOnClickListener(this);
    findViewById(2131165535).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131165325);
    localTextView.setText(Html.fromHtml("<u>" + getString(2131493184) + "</u>"));
    localTextView.setOnClickListener(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletConnectFailed");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletConnectFailed");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.MultiBraceletErrActivity
 * JD-Core Version:    0.6.2
 */