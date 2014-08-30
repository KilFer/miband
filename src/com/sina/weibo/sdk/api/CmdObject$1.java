package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CmdObject$1
  implements Parcelable.Creator<CmdObject>
{
  public CmdObject createFromParcel(Parcel paramParcel)
  {
    return new CmdObject(paramParcel);
  }

  public CmdObject[] newArray(int paramInt)
  {
    return new CmdObject[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.CmdObject.1
 * JD-Core Version:    0.6.2
 */