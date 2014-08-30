package cn.com.smartdevices.bracelet.ui.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<TitlePageIndicator.SavedState>
{
  private static TitlePageIndicator.SavedState a(Parcel paramParcel)
  {
    return new TitlePageIndicator.SavedState(paramParcel, (byte)0);
  }

  private static TitlePageIndicator.SavedState[] a(int paramInt)
  {
    return new TitlePageIndicator.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.b
 * JD-Core Version:    0.6.2
 */