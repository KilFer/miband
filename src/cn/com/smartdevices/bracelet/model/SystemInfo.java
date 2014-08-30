package cn.com.smartdevices.bracelet.model;

public class SystemInfo
{
  public String braceletMacAddress = "";
  public String deviceId = "";
  public String fwVersion = "";
  public String miuiVersionCode = "";
  public String miuiVersionName = "";
  public String phoneBrand = "";
  public String phoneModel = "";
  public String phoneSystem = "";
  public String softVersion = "";

  public String toString()
  {
    return "deviceId:" + this.deviceId + "\nbraceletMacAddress:" + this.braceletMacAddress + "\nmiuiVersionName:" + this.miuiVersionName + "\nmiuiVersionCode:" + this.miuiVersionCode + "\nphoneBrand:" + this.phoneBrand + "\nphoneModel:" + this.phoneModel + "\nphoneSystem:" + this.phoneSystem + "\nfwVersion:" + this.fwVersion + "\nsoftVersion:" + this.softVersion;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SystemInfo
 * JD-Core Version:    0.6.2
 */