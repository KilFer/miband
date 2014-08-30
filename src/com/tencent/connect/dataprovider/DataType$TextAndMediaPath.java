package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DataType$TextAndMediaPath
  implements Parcelable
{
  public static final Parcelable.Creator<TextAndMediaPath> CREATOR = new b();
  private String a;
  private String b;

  private DataType$TextAndMediaPath(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }

  public DataType$TextAndMediaPath(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getMediaPath()
  {
    return this.b;
  }

  public String getText()
  {
    return this.a;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.dataprovider.DataType.TextAndMediaPath
 * JD-Core Version:    0.6.2
 */