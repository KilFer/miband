package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.Usage;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import org.json.JSONObject;

public class BleStatisticTask extends BleTask
{
  public BleStatisticTask(BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.gattPeripheral != null)
      {
        IMiLiProfile.Usage localUsage = this.gattPeripheral._getUsage();
        if (localUsage != null)
          localJSONObject.put("usage", localUsage.toString());
        IMiLiProfile.BatteryInfo localBatteryInfo = this.gattPeripheral._getBatteryInfo();
        if (localBatteryInfo != null)
          localJSONObject.put("battery_info", localBatteryInfo.toString());
        IMiLiProfile.DeviceInfo localDeviceInfo = this.gattPeripheral.getDeviceInfo();
        if (localDeviceInfo != null)
          localJSONObject.put("device_info", localDeviceInfo.toString());
      }
      label101: if (paramBleCallBack != null)
      {
        String str = localJSONObject.toString();
        if ((str != null) && ((str.contains("usage")) || (str.contains("battery_info"))))
          paramBleCallBack.sendOnFinishMessage(str);
      }
      else
      {
        return;
      }
      paramBleCallBack.sendOnFinishMessage(null);
      return;
    }
    catch (Exception localException)
    {
      break label101;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleStatisticTask
 * JD-Core Version:    0.6.2
 */