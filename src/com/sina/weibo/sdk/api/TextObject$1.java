package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class TextObject$1
  implements Parcelable.Creator<TextObject>
{
  public TextObject createFromParcel(Parcel paramParcel)
  {
    return new TextObject(paramParcel);
  }

  public TextObject[] newArray(int paramInt)
  {
    return new TextObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.TextObject.1
 * JD-Core Version:    0.6.2
 */