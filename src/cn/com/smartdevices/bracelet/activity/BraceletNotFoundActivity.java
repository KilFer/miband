package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.HelpActivity;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;

public class BraceletNotFoundActivity extends Activity
  implements View.OnClickListener
{
  public void onBackPressed()
  {
    Toast.makeText(this, 2131492940, 0).show();
    setResult(0);
    finish();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165327:
      startActivity(new Intent(this, SearchSingleBraceletActivity.class));
      finish();
      return;
    case 2131165325:
      Keeper.keepNeedBind(0);
      startActivity(new Intent(this, MainUIActivity.class));
      finish();
      return;
    case 2131165326:
    }
    startActivity(new Intent(this, HelpActivity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903062);
    ((Button)findViewById(2131165327)).setOnClickListener(this);
    findViewById(2131165326).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131165325);
    localTextView.setText(Html.fromHtml("<u>" + getString(2131493184) + "</u>"));
    localTextView.setOnClickListener(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageBraceletNotFound");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageBraceletNotFound");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.BraceletNotFoundActivity
 * JD-Core Version:    0.6.2
 */