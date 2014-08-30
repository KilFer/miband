package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.UserInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetPersonalInfoTask extends BleTask
{
  private IMiLiProfile.UserInfo a = null;

  public BleSetPersonalInfoTask(PersonInfo paramPersonInfo, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    byte[] arrayOfByte1 = paramPersonInfo.nickname.getBytes();
    if (arrayOfByte1.length <= i)
      i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    this.a = new IMiLiProfile.UserInfo((int)paramPersonInfo.uid, (byte)paramPersonInfo.gender, (byte)paramPersonInfo.age, (byte)paramPersonInfo.height, (byte)paramPersonInfo.weight, arrayOfByte2);
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    boolean bool = this.gattPeripheral.setUserInfo(this.a);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetPersonalInfoTask
 * JD-Core Version:    0.6.2
 */