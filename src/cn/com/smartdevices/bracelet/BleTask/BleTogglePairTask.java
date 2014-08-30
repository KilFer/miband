package cn.com.smartdevices.bracelet.BleTask;

import android.bluetooth.BluetoothDevice;
import android.util.Pair;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.SwitchOperator;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BleTogglePairTask extends BleTask
{
  private static Object c = new Object();
  private static Object d = new Object();
  private IMiLiProfile.UserInfo a = null;
  private PersonInfo b = null;

  public BleTogglePairTask(PersonInfo paramPersonInfo, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.b = paramPersonInfo;
  }

  public static void waiting(int paramInt)
  {
    synchronized (c)
    {
      Debug.i(TAG, "before waiting...");
    }
    try
    {
      c.wait(paramInt);
      label22: Debug.i(TAG, "after waiting..." + d);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label22;
    }
  }

  public static void waitingNotify(Object paramObject)
  {
    Debug.i(TAG, "waitingNotify:" + paramObject);
    synchronized (c)
    {
      d = paramObject;
      c.notify();
      return;
    }
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    int i = 1;
    d = Integer.valueOf(-1);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    SwitchOperator localSwitchOperator = Keeper.readSwitchOperator();
    String str1 = this.gattPeripheral.getDevice().getAddress();
    if ((localSwitchOperator.type == i) && (localSwitchOperator.lastUid != -1L) && (this.b.uid == localSwitchOperator.lastUid) && (!str1.equalsIgnoreCase(localSwitchOperator.lastMacAddress)))
    {
      localSwitchOperator.enableClearData = i;
      localSwitchOperator.enableSteps = i;
    }
    byte[] arrayOfByte1;
    if (this.b.isValid())
    {
      arrayOfByte1 = this.b.nickname.getBytes();
      if (arrayOfByte1.length > 10)
        break label1678;
    }
    label1666: label1678: for (int i1 = arrayOfByte1.length; ; i1 = 10)
    {
      byte[] arrayOfByte2 = new byte[i1];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i1);
      if (localSwitchOperator.enableClearData)
        Debug.f(TAG, "SWITCH_UNBIND will clear data!");
      label539: label562: label698: label752: label1017: int i3;
      for (int i2 = i; ; i3 = 0)
      {
        this.a = new IMiLiProfile.UserInfo((int)this.b.uid, (byte)this.b.gender, (byte)this.b.age, (byte)this.b.height, (byte)this.b.weight, i2, arrayOfByte2);
        Debug.i(TAG, "user info:\n" + this.a);
        Debug.f(TAG, "user info:\n" + this.a);
        if (!this.gattPeripheral.setUserInfo(this.a))
          if (paramBleCallBack != null)
            paramBleCallBack.sendOnFinishMessage(null);
        do
        {
          return;
          Debug.i(TAG, "Person info is InValid! " + this.b);
          Debug.f(TAG, "Person info is InValid! " + this.b);
          if (paramBleCallBack == null)
            break;
          paramBleCallBack.sendOnFinishMessage(null);
          return;
          if (((Integer)d).intValue() == -1)
            waiting(10000);
          if (((Integer)d).intValue() == 5)
            if (paramBleCallBack != null)
              paramBleCallBack.sendOnProgressMessage(5);
          do
          {
            do
            {
              localSwitchOperator.enableClearData = false;
              localSwitchOperator.lastUid = -1L;
              if (this.gattPeripheral._setDateTime(Calendar.getInstance()))
                break label562;
              Keeper.keepSwitchOperator(localSwitchOperator);
              if (paramBleCallBack == null)
                break;
              paramBleCallBack.sendOnFinishMessage(null);
              return;
              if (((Integer)d).intValue() != 6)
                break label539;
              d = Integer.valueOf(-1);
              waiting(30000);
              if (((Integer)d).intValue() == -1)
              {
                if (paramBleCallBack == null)
                  break;
                paramBleCallBack.sendOnFinishMessage(null);
                return;
              }
              if (((Integer)d).intValue() == 9)
              {
                if (paramBleCallBack == null)
                  break;
                paramBleCallBack.sendOnFinishMessage(null);
                return;
              }
            }
            while ((((Integer)d).intValue() == 10) || (((Integer)d).intValue() != 13));
            Debug.i(TAG, "Cancel pair now!");
            return;
          }
          while (((Integer)d).intValue() != -1);
        }
        while (paramBleCallBack == null);
        paramBleCallBack.sendOnFinishMessage(null);
        return;
        ArrayList localArrayList;
        int j;
        String str3;
        int n;
        label830: String str2;
        label923: byte b2;
        if (localSwitchOperator.type != -1)
        {
          Pair localPair = this.gattPeripheral._getDateTime();
          if (localPair == null)
            break label1308;
          Debug.i(TAG, "new time:" + ((Calendar)localPair.first).getTime().toString() + ",old time:" + ((Calendar)localPair.second).getTime().toString());
          Debug.f(TAG, "new time:" + ((Calendar)localPair.first).getTime().toString() + ",old time:" + ((Calendar)localPair.second).getTime().toString());
          if (this.b.getDaySportGoalSteps() <= 0)
            break label1329;
          Debug.i(TAG, "setGoal:" + this.b.getDaySportGoalSteps());
          this.gattPeripheral.setGoal((byte)0, this.b.getDaySportGoalSteps());
          localArrayList = this.b.getAlarmClockItems();
          j = 0;
          if (j < localArrayList.size())
            break label1341;
          if ((this.b.miliConfig == null) || (this.b.miliConfig.lightColor == null))
            break label1558;
          str3 = this.b.miliConfig.lightColor;
          n = 1542;
          if (!str3.equals("BLUE"))
            break label1501;
          n = 1542;
          byte b3 = (byte)(n >> 16);
          byte b4 = (byte)(n >> 8);
          byte b5 = (byte)n;
          Debug.i(TAG, "setColorTheme r=" + b3 + ",g=" + b4 + ",b=" + b5);
          if (!this.gattPeripheral.setColorTheme(b3, b4, b5, (byte)0))
            Debug.f(TAG, "setColorTheme failed");
          if ((this.b.miliConfig == null) || (this.b.miliConfig.wearHand == null))
            break label1587;
          str2 = this.b.miliConfig.wearHand;
          if (!str2.equals("LEFT_HAND"))
            break label1570;
          b2 = 0;
        }
        while (true)
        {
          label972: Debug.i(TAG, "setWearLocation : " + b2);
          if (!this.gattPeripheral.setWearLocation(b2))
            Debug.f(TAG, "setWearLocation failed!");
          localSwitchOperator.type = -1;
          if (localSwitchOperator.enableSteps)
          {
            if (!localSwitchOperator.date.equals(new SportDay().getKey()))
            {
              localSwitchOperator.steps = 0;
              Debug.f(TAG, "switch date:" + localSwitchOperator.date + ",current date:" + new SportDay().getKey());
            }
            if (localSwitchOperator.steps > 0)
              break label1599;
          }
          while (true)
          {
            if (i == 0)
            {
              Debug.i(TAG, "setRealtimeSteps:" + localSwitchOperator.steps + " failed!!!");
              Debug.f(TAG, "setRealtimeSteps:" + localSwitchOperator.steps + " failed!!!");
            }
            localSwitchOperator.enableSteps = false;
            Keeper.keepSwitchOperator(localSwitchOperator);
            IMiLiProfile.BatteryInfo localBatteryInfo = this.gattPeripheral._getBatteryInfo();
            Debug.i(TAG, "battery info : " + localBatteryInfo);
            Debug.f(TAG, "battery info : " + localBatteryInfo);
            IMiLiProfile.DeviceInfo localDeviceInfo = this.gattPeripheral.getDeviceInfo();
            Debug.i(TAG, "device info : " + localDeviceInfo);
            Debug.f(TAG, "device info : " + localDeviceInfo);
            if (paramBleCallBack == null)
              break;
            paramBleCallBack.sendOnFinishMessage(localDeviceInfo);
            return;
            label1308: Debug.i(TAG, "can not get bracelet time after _setDateTime");
            Debug.f(TAG, "can not get bracelet time after _setDateTime");
            break label698;
            label1329: Debug.i(TAG, "day sport goals is inValid!");
            break label752;
            label1341: AlarmClockItem localAlarmClockItem = (AlarmClockItem)localArrayList.get(j);
            int k = localAlarmClockItem.getCoded();
            Debug.i(TAG, "Set alarm at: " + j + ", alarm = " + localAlarmClockItem.toJson());
            Debug.f(TAG, "Set alarm at: " + j + ", " + localAlarmClockItem.toJson());
            MiLiProfile localMiLiProfile = this.gattPeripheral;
            byte b1 = (byte)j;
            if (localAlarmClockItem.isEnabled());
            for (int m = i; ; m = 0)
            {
              localMiLiProfile.setTimer(b1, (byte)m, localAlarmClockItem.getCalendar(), (byte)localAlarmClockItem.getDuration(), (byte)k);
              localAlarmClockItem.setUpdate(false);
              j++;
              break;
            }
            label1501: if (str3.equals("GREEN"))
            {
              n = 263424;
              break label830;
            }
            if (str3.equals("RED"))
            {
              n = 393474;
              break label830;
            }
            if (!str3.equals("ORANGE"))
              break label830;
            n = 393728;
            break label830;
            label1558: Debug.f(TAG, "miliConfig is null or lightColor is null");
            break label923;
            label1570: if (!str2.equals("RIGHT_HAND"))
              break label1666;
            b2 = i;
            break label972;
            label1587: Debug.f(TAG, "miliConfig is null or wearHand is null");
            break label1017;
            label1599: Debug.i(TAG, "setRealtimeSteps:" + localSwitchOperator.steps);
            Debug.f(TAG, "setRealtimeSteps:" + localSwitchOperator.steps);
            boolean bool = this.gattPeripheral.setRealtimeSteps(localSwitchOperator.steps);
          }
          b2 = 0;
        }
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleTogglePairTask
 * JD-Core Version:    0.6.2
 */