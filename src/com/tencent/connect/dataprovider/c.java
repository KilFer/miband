package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<DataType.TextOnly>
{
  private static DataType.TextOnly a(Parcel paramParcel)
  {
    return new DataType.TextOnly(paramParcel, (byte)0);
  }

  private static DataType.TextOnly[] a(int paramInt)
  {
    return new DataType.TextOnly[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.dataprovider.c
 * JD-Core Version:    0.6.2
 */