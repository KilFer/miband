package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import de.greenrobot.event.EventBus;

public class UnlockScreenHelperActivity extends Activity
  implements View.OnClickListener
{
  private static final int a = 0;
  private static final int b = 1;
  private static final String c = "unlockscreen";
  private View d = null;
  private View e = null;
  private TextView f = null;
  private TextView g = null;
  private TextView h = null;
  private LinearLayout i = null;
  private LinearLayout j = null;
  private TextView k = null;
  private View l = null;
  private TextView m = null;
  private FrameLayout n = null;
  private TextView o = null;

  private void a()
  {
    boolean bool = b();
    if (bool)
    {
      this.d.setEnabled(false);
      this.g.setText(getString(2131493225));
      this.h.setTextColor(getResources().getColor(2131230723));
      this.e.setEnabled(true);
      this.f.setTextColor(getResources().getColor(2131230736));
      if ((!bool) || (!c()))
        break label172;
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(0);
    }
    label172: 
    do
    {
      return;
      this.d.setEnabled(true);
      this.g.setText(getString(2131493224));
      this.h.setTextColor(getResources().getColor(2131230736));
      this.e.setEnabled(false);
      this.f.setTextColor(getResources().getColor(2131230723));
      break;
      if (!Utils.isSupportMiuiUnlock(this))
      {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.n.setBackgroundColor(getResources().getColor(2131230781));
        this.o.setVisibility(0);
        return;
      }
      this.k.setVisibility(0);
      this.j.setVisibility(0);
      this.i.setVisibility(8);
      this.n.setBackgroundColor(getResources().getColor(2131230780));
      this.o.setVisibility(8);
    }
    while (Utils.isBraceletConnected());
    this.l.setVisibility(0);
  }

  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramInt == 1)
      localIntent.putExtra("android.bluetooth.device.extra.NAME", Keeper.readBraceletBtInfo().address);
    localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.MiuiSecurityBluetoothSettings"));
    startActivity(localIntent);
  }

  private boolean b()
  {
    return ((KeyguardManager)getSystemService("keyguard")).isKeyguardSecure();
  }

  // ERROR //
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 175	cn/com/smartdevices/bracelet/ui/UnlockScreenHelperActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: ldc 177
    //   6: invokestatic 183	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   9: istore_3
    //   10: iload_3
    //   11: istore_2
    //   12: aload_0
    //   13: invokevirtual 175	cn/com/smartdevices/bracelet/ui/UnlockScreenHelperActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   16: ldc 185
    //   18: invokestatic 188	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 4
    //   23: ldc 15
    //   25: new 190	java/lang/StringBuilder
    //   28: dup
    //   29: ldc 192
    //   31: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: iload_2
    //   35: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 201
    //   40: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 212	cn/com/smartdevices/bracelet/Debug:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: iload_2
    //   55: iconst_1
    //   56: if_icmpne +15 -> 71
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_1
    //   62: iconst_0
    //   63: istore_2
    //   64: aload_1
    //   65: invokevirtual 215	android/provider/Settings$SettingNotFoundException:printStackTrace	()V
    //   68: goto -14 -> 54
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_1
    //   74: goto -10 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   0	10	61	android/provider/Settings$SettingNotFoundException
    //   12	54	73	android/provider/Settings$SettingNotFoundException
  }

  private boolean d()
  {
    return Utils.isSupportMiuiUnlock(this);
  }

  public void onBleStatusChanged(BaseSCActivity.ConnStatus paramConnStatus)
  {
    if (paramConnStatus.a >= 8)
    {
      this.l.setVisibility(8);
      this.n.setBackgroundColor(getResources().getColor(2131230780));
    }
    while ((b()) && (c()))
      return;
    this.l.setVisibility(0);
    this.n.setBackgroundColor(getResources().getColor(2131230781));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165309:
      a(1);
      return;
    case 2131165303:
      finish();
      return;
    case 2131165307:
      a(0);
      return;
    case 2131165312:
    }
    startActivity(new Intent(this, UnlockScreenInvalidHelperActivity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    this.d = findViewById(2131165307);
    this.d.setOnClickListener(this);
    this.e = findViewById(2131165309);
    this.e.setOnClickListener(this);
    this.f = ((TextView)findViewById(2131165310));
    ((TextView)findViewById(2131165303)).setOnClickListener(this);
    this.i = ((LinearLayout)findViewById(2131165311));
    this.j = ((LinearLayout)findViewById(2131165305));
    this.l = findViewById(2131165313);
    this.k = ((TextView)findViewById(2131165304));
    this.m = ((TextView)findViewById(2131165312));
    int i1 = this.m.getPaint().getFlags();
    this.m.getPaint().setFlags(i1 | 0x8);
    this.m.setOnClickListener(this);
    this.g = ((TextView)findViewById(2131165306));
    this.h = ((TextView)findViewById(2131165308));
    this.n = ((FrameLayout)findViewById(2131165302));
    this.o = ((TextView)findViewById(2131165314));
    EventBus.getDefault().registerSticky(this, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  protected void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageUnlockHelp");
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    boolean bool = b();
    if (bool)
    {
      this.d.setEnabled(false);
      this.g.setText(getString(2131493225));
      this.h.setTextColor(getResources().getColor(2131230723));
      this.e.setEnabled(true);
      this.f.setTextColor(getResources().getColor(2131230736));
      if ((!bool) || (!c()))
        break label186;
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(0);
    }
    while (true)
    {
      UmengAnalytics.startPage("PageUnlockHelp");
      UmengAnalytics.startSession(this);
      return;
      this.d.setEnabled(true);
      this.g.setText(getString(2131493224));
      this.h.setTextColor(getResources().getColor(2131230736));
      this.e.setEnabled(false);
      this.f.setTextColor(getResources().getColor(2131230723));
      break;
      label186: if (!Utils.isSupportMiuiUnlock(this))
      {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.n.setBackgroundColor(getResources().getColor(2131230781));
        this.o.setVisibility(0);
      }
      else
      {
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        this.n.setBackgroundColor(getResources().getColor(2131230780));
        this.o.setVisibility(8);
        if (!Utils.isBraceletConnected())
          this.l.setVisibility(0);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.UnlockScreenHelperActivity
 * JD-Core Version:    0.6.2
 */