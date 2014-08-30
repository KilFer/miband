package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class A
  implements Parcelable.Creator<SlideMenu.SavedState>
{
  private static SlideMenu.SavedState a(Parcel paramParcel)
  {
    return new SlideMenu.SavedState(paramParcel, (byte)0);
  }

  private static SlideMenu.SavedState[] a(int paramInt)
  {
    return new SlideMenu.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.A
 * JD-Core Version:    0.6.2
 */