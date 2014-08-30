package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity;

public class MainActivity extends Activity
{
  private static final String a = "MainActivity";
  private static final int b = 16;

  private void a()
  {
    Intent localIntent = new Intent();
    BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
    LoginData localLoginData = Keeper.readLoginData();
    PersonInfo localPersonInfo = Keeper.readPersonInfo();
    Debug.i("MainActivity", "MainActivity onCreate, Person:" + localPersonInfo + ", login: " + localLoginData);
    if ((localLoginData == null) || (!localLoginData.isValid()))
      localIntent.setClass(this, LoginActivity.class);
    while (true)
    {
      startActivity(localIntent);
      finish();
      overridePendingTransition(0, 0);
      return;
      if ((localPersonInfo == null) || (!localPersonInfo.isValid()))
      {
        localIntent.setClass(this, PersonInfoSetGenderActivity.class);
      }
      else if (((localBraceletBtInfo == null) || (!BluetoothAdapter.checkBluetoothAddress(localBraceletBtInfo.address))) && (Keeper.readNeedBind() == 1))
      {
        localIntent.setClass(this, SearchSingleBraceletActivity.class);
      }
      else
      {
        localIntent.setClass(this, MainUIActivity.class);
        Bundle localBundle = getIntent().getExtras();
        if (localBundle != null)
        {
          localIntent.putExtras(localBundle);
          Debug.i("MainActivity", "extras is :" + localBundle);
        }
        else
        {
          Debug.i("MainActivity", "extras is null!");
        }
      }
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 16)
      a();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    Debug.i("MainActivity", "Screen metrics =" + localDisplayMetrics);
    Intent localIntent = new Intent();
    if (Build.VERSION.SDK_INT == 18)
    {
      LoginData localLoginData = Keeper.readLoginData();
      if ((localLoginData == null) || (!localLoginData.isValid()))
      {
        localIntent.setClass(this, SystemLowActivity.class);
        startActivityForResult(localIntent, 16);
      }
    }
    else if (Build.VERSION.SDK_INT < 18)
    {
      localIntent.setClass(this, SystemNotSupportActivity.class);
      startActivity(localIntent);
      finish();
      return;
    }
    a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.MainActivity
 * JD-Core Version:    0.6.2
 */