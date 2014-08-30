package cn.com.smartdevices.bracelet.ui.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;

public class PersonInfoBaseActivity extends Activity
  implements View.OnClickListener
{
  private static final String a = "PersonInfoBaseActivity";
  private View b = null;
  private View c = null;
  protected PersonInfo mPersonInfo = null;

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Debug.i("PersonInfoBaseActivity", "onActivityResult: " + getLocalClassName() + ", requestCode=" + paramInt1 + ", result:" + paramInt2);
    if (paramInt1 == 6)
    {
      if (paramInt2 == -1)
      {
        Debug.i("PersonInfoBaseActivity", "finish page: " + getLocalClassName());
        setResult(-1);
        finish();
      }
    }
    else
      return;
    this.mPersonInfo = Keeper.readPersonInfo();
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    onCancel();
  }

  public void onCancel()
  {
    Debug.i("PersonInfoBaseActivity", "onCancel");
    Keeper.keepPersonInfo(this.mPersonInfo);
    setResult(0);
    finish();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165333:
    default:
      return;
    case 2131165332:
      onCancel();
      return;
    case 2131165334:
    }
    onNext();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mPersonInfo = Keeper.readPersonInfo();
    this.b = findViewById(2131165334);
    this.b.setOnClickListener(this);
    this.c = findViewById(2131165332);
    this.c.setOnClickListener(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onNext()
  {
    Debug.i("PersonInfoBaseActivity", "onNext(), personInfo = " + this.mPersonInfo);
    Keeper.keepPersonInfo(this.mPersonInfo);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.person.PersonInfoBaseActivity
 * JD-Core Version:    0.6.2
 */