package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VideoObject$1
  implements Parcelable.Creator<VideoObject>
{
  public VideoObject createFromParcel(Parcel paramParcel)
  {
    return new VideoObject(paramParcel);
  }

  public VideoObject[] newArray(int paramInt)
  {
    return new VideoObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.VideoObject.1
 * JD-Core Version:    0.6.2
 */