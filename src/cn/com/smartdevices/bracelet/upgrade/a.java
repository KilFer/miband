package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<OtaVersionInfo>
{
  private static OtaVersionInfo a(Parcel paramParcel)
  {
    return new OtaVersionInfo(paramParcel, (byte)0);
  }

  private static OtaVersionInfo[] a(int paramInt)
  {
    return new OtaVersionInfo[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.a
 * JD-Core Version:    0.6.2
 */