package cn.com.smartdevices.bracelet.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ShareData$1
  implements Parcelable.Creator<ShareData>
{
  public ShareData createFromParcel(Parcel paramParcel)
  {
    ShareData localShareData = new ShareData();
    localShareData.title = paramParcel.readString();
    localShareData.content = paramParcel.readString();
    localShareData.contentUnit = paramParcel.readString();
    localShareData.time = paramParcel.readString();
    localShareData.time_tips = paramParcel.readString();
    localShareData.description = paramParcel.readString();
    localShareData.color = paramParcel.readInt();
    localShareData.type = paramParcel.readInt();
    return localShareData;
  }

  public ShareData[] newArray(int paramInt)
  {
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareData.1
 * JD-Core Version:    0.6.2
 */