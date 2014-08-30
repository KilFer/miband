package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BleTask.BleResetTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class BraceletSettingsFragment extends PreferenceFragment
{
  private final int a;
  private ProgressDialog b = null;
  private Handler c = null;

  private void a()
  {
    ArrayList localArrayList = Keeper.readAlarms();
    Preference localPreference = findPreference("settings_alarm_clock");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
    {
      localPreference.setSummary("未开启");
      return;
    }
    Iterator localIterator = localArrayList.iterator();
    do
      if (!localIterator.hasNext())
      {
        localPreference.setSummary("未开启");
        return;
      }
    while (!((AlarmClockItem)localIterator.next()).isEnabled());
    localPreference.setSummary("已开启");
  }

  private void a(int paramInt)
  {
    if (this.b == null)
    {
      this.b = new ProgressDialog(getActivity());
      this.b.setMax(paramInt);
      this.b.setProgress(0);
      this.b.setTitle("固件升级");
      this.b.setMessage("升级进度");
      this.b.setCancelable(false);
      this.b.setProgressStyle(1);
      this.b.setIndeterminate(false);
      this.b.show();
    }
  }

  private void a(String paramString1, String paramString2)
  {
    new BleFwUpgradeTask(paramString1, paramString2, new J(this, paramString2)).work();
  }

  private void b()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle("重置手环");
    localBuilder.setMessage("将清除手环中的运动记录和个人信息，确定重置？");
    localBuilder.setNegativeButton("取消", new C(this));
    localBuilder.setPositiveButton("确定", new D(this));
    localBuilder.show();
  }

  private void b(int paramInt)
  {
    if (this.b != null)
      this.b.setProgress(paramInt);
  }

  private void c()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setView(LayoutInflater.from(getActivity()).inflate(2130903140, null));
    localBuilder.setPositiveButton("确定", new E(this));
    localBuilder.setNegativeButton("取消", new F(this));
    localBuilder.show();
  }

  private void d()
  {
    new BleResetTask(new G(this)).work();
  }

  private void e()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle("固件升级");
    String str1 = ((BraceletApp)getActivity().getApplication()).getStoragePath() + "/bracelet.fw";
    File localFile = new File(str1);
    String str2;
    if ((localFile.exists()) && (localFile.canRead()))
    {
      str2 = "手环固件路径：" + str1 + "\n确定升级？";
      localBuilder.setPositiveButton("确定", new H(this, str1));
    }
    while (true)
    {
      localBuilder.setMessage(str2);
      localBuilder.setNegativeButton("取消", new I(this));
      localBuilder.show();
      return;
      str2 = "手环固件路径：" + str1 + "不存在,请把固件复制到目标地址后重试！";
    }
  }

  private void f()
  {
    int i = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getFirmwareUpdatingProgress().progress;
    if (this.b != null)
      this.b.setProgress(i);
    this.c.sendEmptyMessageDelayed(4098, 1000L);
  }

  private void g()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
    this.c.removeMessages(4098);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131034113);
    this.c = new B(this);
  }

  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (paramPreference.getKey().equals("settings_bracelet_reset"))
    {
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(getActivity());
      localBuilder1.setTitle("重置手环");
      localBuilder1.setMessage("将清除手环中的运动记录和个人信息，确定重置？");
      localBuilder1.setNegativeButton("取消", new C(this));
      localBuilder1.setPositiveButton("确定", new D(this));
      localBuilder1.show();
      return true;
    }
    String str1;
    String str2;
    if (paramPreference.getKey().equals("settings_fw_upgrade"))
    {
      AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(getActivity());
      localBuilder2.setTitle("固件升级");
      str1 = ((BraceletApp)getActivity().getApplication()).getStoragePath() + "/bracelet.fw";
      File localFile = new File(str1);
      if ((localFile.exists()) && (localFile.canRead()))
      {
        str2 = "手环固件路径：" + str1 + "\n确定升级？";
        localBuilder2.setPositiveButton("确定", new H(this, str1));
        localBuilder2.setMessage(str2);
        localBuilder2.setNegativeButton("取消", new I(this));
        localBuilder2.show();
      }
    }
    while (true)
    {
      return super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference);
      str2 = "手环固件路径：" + str1 + "不存在,请把固件复制到目标地址后重试！";
      break;
      if (paramPreference.getKey().equals("settings_push_goals_progress"))
      {
        AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(getActivity());
        localBuilder3.setView(LayoutInflater.from(getActivity()).inflate(2130903140, null));
        localBuilder3.setPositiveButton("确定", new E(this));
        localBuilder3.setNegativeButton("取消", new F(this));
        localBuilder3.show();
      }
    }
  }

  public void onResume()
  {
    super.onResume();
    ArrayList localArrayList = Keeper.readAlarms();
    Preference localPreference = findPreference("settings_alarm_clock");
    if ((localArrayList == null) || (localArrayList.size() <= 0))
    {
      localPreference.setSummary("未开启");
      return;
    }
    Iterator localIterator = localArrayList.iterator();
    do
      if (!localIterator.hasNext())
      {
        localPreference.setSummary("未开启");
        return;
      }
    while (!((AlarmClockItem)localIterator.next()).isEnabled());
    localPreference.setSummary("已开启");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.BraceletSettingsFragment
 * JD-Core Version:    0.6.2
 */