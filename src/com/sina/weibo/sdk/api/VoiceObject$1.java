package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VoiceObject$1
  implements Parcelable.Creator<VoiceObject>
{
  public VoiceObject createFromParcel(Parcel paramParcel)
  {
    return new VoiceObject(paramParcel);
  }

  public VoiceObject[] newArray(int paramInt)
  {
    return new VoiceObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.VoiceObject.1
 * JD-Core Version:    0.6.2
 */