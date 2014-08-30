package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.view.RoundProgressBar;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.io.InputStream;

public class FwUpgradeActivity extends Activity
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 1000;
  private static String e = "FwUpgradeActivity";
  private Context d = null;
  private Handler f = null;
  private boolean g = false;
  private TextView h = null;
  private RoundProgressBar i = null;
  private TextView j = null;
  private TextView k = null;
  private BluetoothDevice l = null;
  private int m = 0;
  private Animator n;

  private void a(int paramInt1, int paramInt2)
  {
    if ((this.n != null) && (this.n.isStarted()))
      this.n.end();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new ah(this));
    localValueAnimator.setDuration(1000L);
    localValueAnimator.start();
    this.n = localValueAnimator;
  }

  private void b()
  {
    getWindow().addFlags(128);
  }

  private void c()
  {
    getWindow().clearFlags(128);
  }

  private void d()
  {
    BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
    try
    {
      InputStream localInputStream = getResources().getAssets().open("Mili.fw");
      Debug.i(e, "new fw length:" + localInputStream.available());
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      localInputStream.close();
      new BleFwUpgradeTask(localBraceletBtInfo.address, arrayOfByte, new ab(this)).work();
      return;
    }
    catch (Exception localException)
    {
      Debug.i(e, localException.getMessage());
    }
  }

  private void e()
  {
    Toast.makeText(this.d, getString(2131493071), 0).show();
    finish();
  }

  private void f()
  {
    IMiLiProfile.Progress localProgress = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getFirmwareUpdatingProgress();
    int i1;
    if (localProgress.total == -1)
    {
      this.m = 0;
      this.i.setMax(100);
      i1 = 0;
    }
    while (true)
    {
      int i2 = this.m;
      if ((this.n != null) && (this.n.isStarted()))
        this.n.end();
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i2, i1 });
      localValueAnimator.addUpdateListener(new ah(this));
      localValueAnimator.setDuration(1000L);
      localValueAnimator.start();
      this.n = localValueAnimator;
      this.m = i1;
      if ((!this.g) && (this.f != null))
        this.f.sendEmptyMessageDelayed(1, 1000L);
      return;
      if (localProgress.total == 0)
      {
        this.m = 100;
        this.i.setMax(100);
        i1 = 100;
      }
      else
      {
        i1 = localProgress.progress;
        this.i.setMax(localProgress.total);
      }
    }
  }

  public void enterAnimation()
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, 2130968577);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this, 2130968577);
    Animation localAnimation3 = AnimationUtils.loadAnimation(this, 2130968577);
    Animation localAnimation4 = AnimationUtils.loadAnimation(this, 2130968577);
    localAnimation1.setStartOffset(0L);
    localAnimation2.setStartOffset(100L);
    localAnimation3.setStartOffset(150L);
    localAnimation4.setStartOffset(200L);
    localAnimation4.setAnimationListener(new ac(this));
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    localAnimation1.setInterpolator(localDecelerateInterpolator);
    localAnimation2.setInterpolator(localDecelerateInterpolator);
    localAnimation3.setInterpolator(localDecelerateInterpolator);
    localAnimation4.setInterpolator(localDecelerateInterpolator);
    this.i.startAnimation(localAnimation1);
    this.j.startAnimation(localAnimation2);
    this.k.startAnimation(localAnimation3);
    this.h.startAnimation(localAnimation4);
  }

  public void finishAnimation()
  {
    Animation localAnimation1 = AnimationUtils.loadAnimation(this, 2130968578);
    Animation localAnimation2 = AnimationUtils.loadAnimation(this, 2130968578);
    Animation localAnimation3 = AnimationUtils.loadAnimation(this, 2130968578);
    Animation localAnimation4 = AnimationUtils.loadAnimation(this, 2130968578);
    localAnimation1.setStartOffset(0L);
    localAnimation4.setStartOffset(100L);
    localAnimation3.setStartOffset(150L);
    localAnimation2.setStartOffset(200L);
    localAnimation1.setAnimationListener(new ad(this));
    localAnimation2.setAnimationListener(new ae(this));
    localAnimation3.setAnimationListener(new af(this));
    localAnimation4.setAnimationListener(new ag(this));
    AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator(2.0F);
    localAnimation1.setInterpolator(localAccelerateInterpolator);
    localAnimation2.setInterpolator(localAccelerateInterpolator);
    localAnimation3.setInterpolator(localAccelerateInterpolator);
    localAnimation4.setInterpolator(localAccelerateInterpolator);
    this.i.startAnimation(localAnimation1);
    this.j.startAnimation(localAnimation2);
    this.k.startAnimation(localAnimation3);
    this.h.startAnimation(localAnimation4);
  }

  public void onBackPressed()
  {
    if (this.g)
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Debug.i(e, "in onCreate");
    this.d = this;
    setTheme(2131623946);
    setContentView(2130903080);
    this.j = ((TextView)findViewById(2131165389));
    this.k = ((TextView)findViewById(2131165390));
    this.h = ((TextView)findViewById(2131165392));
    this.i = ((RoundProgressBar)findViewById(2131165391));
    this.f = new aa(this);
    getWindow().addFlags(128);
    enterAnimation();
  }

  protected void onDestroy()
  {
    Debug.i(e, "in onDestroy");
    super.onDestroy();
    this.f.removeCallbacksAndMessages(null);
    this.f = null;
    getWindow().clearFlags(128);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.FwUpgradeActivity
 * JD-Core Version:    0.6.2
 */