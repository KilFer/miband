package cn.com.smartdevices.bracelet.upgrade;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity.SettingFirmwareFragment;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;

public class UpgradeService extends IntentService
{
  public static final int REQUEST_APP_UPGRADE = 1;
  public static final int REQUEST_FIRMWARE_OTA = 2;
  private static final String a = "UpgradeService";

  public UpgradeService()
  {
    super("UpgradeService");
  }

  private void a()
  {
    NewVersionInfo localNewVersionInfo = UpgradeUtil.getNetVersionInfo(this, UpgradeUtil.getUpgradeURL());
    Debug.i("UpgradeService", "VersionInfo : " + localNewVersionInfo.toString());
    int i = UpgradeUtil.getApkVersionCode(this, getPackageName());
    if (i < localNewVersionInfo.getVersionCode())
    {
      Message localMessage = new Message();
      localMessage.what = 263;
      Bundle localBundle = new Bundle();
      localBundle.putString("ChangeLog", localNewVersionInfo.getChangeLog());
      localBundle.putInt("NewVersion", localNewVersionInfo.getVersionCode());
      String str = new String();
      if (i < localNewVersionInfo.getVersionCode())
        str = localNewVersionInfo.getFileUrl();
      localBundle.putString("DownUrl", str);
      localMessage.setData(localBundle);
    }
  }

  private void b()
  {
    OtaVersionInfo localOtaVersionInfo = UpgradeUtil.getOtaVersionInfo(this, UpgradeUtil.getOtaUrl());
    Debug.e("DDDD", "OTAInfo : " + localOtaVersionInfo);
    if (SettingFirmwareActivity.SettingFirmwareFragment.mHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.obj = localOtaVersionInfo;
      SettingFirmwareActivity.SettingFirmwareFragment.mHandler.sendMessage(localMessage);
    }
  }

  public static boolean checkFirmwareUpgradeState(OtaVersionInfo paramOtaVersionInfo, IMiLiProfile.DeviceInfo paramDeviceInfo)
  {
    Debug.e("DDDD", "DeviceInfo : " + paramDeviceInfo);
    String str = paramDeviceInfo.getFirmwareVersionMajor() + "." + paramDeviceInfo.getFirmwareVersionMinor() + paramDeviceInfo.getFirmwareVersionRevision() + paramDeviceInfo.getFirmwareVersionBuild();
    Debug.e("DDDD", "DeviceFirmwareVersionCode : " + str);
    boolean bool1 = paramOtaVersionInfo.firmwareVersionCode < Float.valueOf(str).floatValue();
    boolean bool2 = false;
    if (bool1)
    {
      Debug.e("DDDD", "Need Upgrade Firmware : " + Float.valueOf(str) + " , " + paramOtaVersionInfo.firmwareVersionCode);
      bool2 = true;
    }
    return bool2;
  }

  public static void start(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, UpgradeService.class);
    localIntent.putExtra("Request", paramInt);
    paramContext.startService(localIntent);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    switch (paramIntent.getIntExtra("Request", 0))
    {
    default:
    case 1:
    case 2:
    }
    OtaVersionInfo localOtaVersionInfo;
    do
    {
      NewVersionInfo localNewVersionInfo;
      int i;
      do
      {
        return;
        localNewVersionInfo = UpgradeUtil.getNetVersionInfo(this, UpgradeUtil.getUpgradeURL());
        Debug.i("UpgradeService", "VersionInfo : " + localNewVersionInfo.toString());
        i = UpgradeUtil.getApkVersionCode(this, getPackageName());
      }
      while (i >= localNewVersionInfo.getVersionCode());
      Message localMessage2 = new Message();
      localMessage2.what = 263;
      Bundle localBundle = new Bundle();
      localBundle.putString("ChangeLog", localNewVersionInfo.getChangeLog());
      localBundle.putInt("NewVersion", localNewVersionInfo.getVersionCode());
      String str = new String();
      if (i < localNewVersionInfo.getVersionCode())
        str = localNewVersionInfo.getFileUrl();
      localBundle.putString("DownUrl", str);
      localMessage2.setData(localBundle);
      return;
      localOtaVersionInfo = UpgradeUtil.getOtaVersionInfo(this, UpgradeUtil.getOtaUrl());
      Debug.e("DDDD", "OTAInfo : " + localOtaVersionInfo);
    }
    while (SettingFirmwareActivity.SettingFirmwareFragment.mHandler == null);
    Message localMessage1 = new Message();
    localMessage1.what = 1;
    localMessage1.obj = localOtaVersionInfo;
    SettingFirmwareActivity.SettingFirmwareFragment.mHandler.sendMessage(localMessage1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.UpgradeService
 * JD-Core Version:    0.6.2
 */