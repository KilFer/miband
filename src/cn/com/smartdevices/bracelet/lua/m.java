package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class m
  implements Parcelable.Creator<SlidingUpPanelLayout.SavedState>
{
  private static SlidingUpPanelLayout.SavedState a(Parcel paramParcel)
  {
    return new SlidingUpPanelLayout.SavedState(paramParcel, (byte)0);
  }

  private static SlidingUpPanelLayout.SavedState[] a(int paramInt)
  {
    return new SlidingUpPanelLayout.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.m
 * JD-Core Version:    0.6.2
 */