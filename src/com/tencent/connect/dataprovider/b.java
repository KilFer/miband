package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<DataType.TextAndMediaPath>
{
  private static DataType.TextAndMediaPath a(Parcel paramParcel)
  {
    return new DataType.TextAndMediaPath(paramParcel, (byte)0);
  }

  private static DataType.TextAndMediaPath[] a(int paramInt)
  {
    return new DataType.TextAndMediaPath[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.dataprovider.b
 * JD-Core Version:    0.6.2
 */