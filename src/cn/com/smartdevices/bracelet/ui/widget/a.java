package cn.com.smartdevices.bracelet.ui.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<CirclePageIndicator.SavedState>
{
  private static CirclePageIndicator.SavedState a(Parcel paramParcel)
  {
    return new CirclePageIndicator.SavedState(paramParcel, (byte)0);
  }

  private static CirclePageIndicator.SavedState[] a(int paramInt)
  {
    return new CirclePageIndicator.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.a
 * JD-Core Version:    0.6.2
 */