package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ImageObject$1
  implements Parcelable.Creator<ImageObject>
{
  public ImageObject createFromParcel(Parcel paramParcel)
  {
    return new ImageObject(paramParcel);
  }

  public ImageObject[] newArray(int paramInt)
  {
    return new ImageObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ImageObject.1
 * JD-Core Version:    0.6.2
 */