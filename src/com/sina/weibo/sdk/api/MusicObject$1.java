package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MusicObject$1
  implements Parcelable.Creator<MusicObject>
{
  public MusicObject createFromParcel(Parcel paramParcel)
  {
    return new MusicObject(paramParcel);
  }

  public MusicObject[] newArray(int paramInt)
  {
    return new MusicObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.MusicObject.1
 * JD-Core Version:    0.6.2
 */