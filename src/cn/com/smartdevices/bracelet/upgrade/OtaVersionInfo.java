package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OtaVersionInfo
  implements Parcelable
{
  public static final Parcelable.Creator<OtaVersionInfo> CREATOR = new a();
  public String firmwareInfo;
  public String firmwareMd5;
  public int firmwareSize;
  public String firmwareUrl;
  public String firmwareVersion;
  public float firmwareVersionCode;

  public OtaVersionInfo()
  {
  }

  private OtaVersionInfo(Parcel paramParcel)
  {
    this.firmwareUrl = paramParcel.readString();
    this.firmwareVersionCode = paramParcel.readFloat();
    this.firmwareVersion = paramParcel.readString();
    this.firmwareInfo = paramParcel.readString();
    this.firmwareSize = paramParcel.readInt();
    this.firmwareMd5 = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "\n" + this.firmwareUrl + "\n" + this.firmwareVersionCode + "\n" + this.firmwareVersion + "\n" + this.firmwareInfo + "\n" + this.firmwareSize + "\n" + this.firmwareMd5;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.firmwareUrl);
    paramParcel.writeFloat(this.firmwareVersionCode);
    paramParcel.writeString(this.firmwareVersion);
    paramParcel.writeString(this.firmwareInfo);
    paramParcel.writeFloat(this.firmwareSize);
    paramParcel.writeString(this.firmwareMd5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo
 * JD-Core Version:    0.6.2
 */