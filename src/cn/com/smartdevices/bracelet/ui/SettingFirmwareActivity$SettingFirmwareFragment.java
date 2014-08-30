package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import cn.com.smartdevices.bracelet.upgrade.UpgradeService;
import cn.com.smartdevices.bracelet.webapi.BraceletHttpClient;
import com.loopj.android.http.AsyncHttpClient;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.io.File;
import java.io.IOException;

public class SettingFirmwareActivity$SettingFirmwareFragment extends Fragment
{
  public static final int MSG_UPDATE_FIRMWARE_INFO = 1;
  public static final String SUFFIX_FIRMWARE = ".fw";
  public static final String SUFFIX_TEMP = ".tmp";
  private static final String a = "Setting.Firmware";
  private static final int b = 4098;
  public static Handler mHandler;
  private TextView c;
  private TextView d;
  private TextView e;
  private View f;
  private ProgressDialog g;
  private IMiLiProfile.DeviceInfo h;
  private OtaVersionInfo i;

  private void a()
  {
    mHandler = new bq(this);
  }

  private void a(int paramInt)
  {
    if (this.g == null)
    {
      this.g = new ProgressDialog(getActivity());
      this.g.setMax(paramInt);
      this.g.setProgress(0);
      this.g.setTitle("固件升级");
      this.g.setMessage("升级进度");
      this.g.setCancelable(false);
      this.g.setProgressStyle(1);
      this.g.setIndeterminate(false);
      this.g.show();
    }
  }

  private void a(View paramView)
  {
    this.c = ((TextView)paramView.findViewById(2131165452));
    this.d = ((TextView)paramView.findViewById(2131165453));
    this.e = ((TextView)paramView.findViewById(2131165454));
    this.f = ((TextView)paramView.findViewById(2131165455));
    this.f.setOnClickListener(new bp(this));
    this.f.setEnabled(false);
  }

  private void a(OtaVersionInfo paramOtaVersionInfo)
  {
    this.d.setText(paramOtaVersionInfo.firmwareVersion);
    this.e.setText(paramOtaVersionInfo.firmwareInfo);
    this.f.setEnabled(UpgradeService.checkFirmwareUpgradeState(paramOtaVersionInfo, this.h));
  }

  private void a(String paramString1, String paramString2)
  {
    new BleFwUpgradeTask(paramString1, paramString2, new bt(this, paramString2)).work();
  }

  private void b()
  {
    int j = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getFirmwareUpdatingProgress().progress;
    if (this.g != null)
      this.g.setProgress(j);
    mHandler.sendEmptyMessageDelayed(4098, 1000L);
  }

  private void b(int paramInt)
  {
    if (this.g != null)
      this.g.setProgress(paramInt);
  }

  private void b(OtaVersionInfo paramOtaVersionInfo)
  {
    File localFile = new File(new File(new StringBuilder(String.valueOf(((BraceletApp)getActivity().getApplication()).getStoragePath())).append("/bracelet.fw").toString()).getPath() + ".tmp");
    if (!localFile.exists());
    try
    {
      localFile.getParentFile().mkdirs();
      localFile.createNewFile();
      BraceletHttpClient.client.get(paramOtaVersionInfo.firmwareUrl, new SettingFirmwareActivity.SettingFirmwareFragment.DownloadFirmwareHandler(this, getActivity(), localFile, paramOtaVersionInfo));
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  private void c()
  {
    if (this.g != null)
    {
      this.g.dismiss();
      this.g = null;
    }
    mHandler.removeMessages(4098);
  }

  public void confirmFwUpgrade()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    localBuilder.setTitle("固件升级");
    String str1 = ((BraceletApp)getActivity().getApplication()).getStoragePath() + "/bracelet.fw";
    File localFile = new File(str1);
    String str2;
    if ((localFile.exists()) && (localFile.canRead()))
    {
      str2 = "手环固件路径：" + str1 + "\n确定升级？";
      localBuilder.setPositiveButton("确定", new br(this, str1));
    }
    while (true)
    {
      localBuilder.setMessage(str2);
      localBuilder.setNegativeButton("取消", new bs(this));
      localBuilder.show();
      return;
      str2 = "手环固件路径：" + str1 + "不存在,请把固件复制到目标地址后重试！";
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903104, paramViewGroup, false);
    this.c = ((TextView)localView.findViewById(2131165452));
    this.d = ((TextView)localView.findViewById(2131165453));
    this.e = ((TextView)localView.findViewById(2131165454));
    this.f = ((TextView)localView.findViewById(2131165455));
    this.f.setOnClickListener(new bp(this));
    this.f.setEnabled(false);
    mHandler = new bq(this);
    this.h = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getCachedDeviceInfo();
    this.c.setText(this.h.getFirmwareVersionStr());
    UpgradeService.start(getActivity(), 2);
    return localView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity.SettingFirmwareFragment
 * JD-Core Version:    0.6.2
 */