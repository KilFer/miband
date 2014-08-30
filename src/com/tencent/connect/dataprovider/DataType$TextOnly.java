package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DataType$TextOnly
  implements Parcelable
{
  public static final Parcelable.Creator<TextOnly> CREATOR = new c();
  private String a;

  private DataType$TextOnly(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public DataType$TextOnly(String paramString)
  {
    this.a = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getText()
  {
    return this.a;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.dataprovider.DataType.TextOnly
 * JD-Core Version:    0.6.2
 */