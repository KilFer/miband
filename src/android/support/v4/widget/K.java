package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class K
  implements Parcelable.Creator<SlidingPaneLayout.SavedState>
{
  private static SlidingPaneLayout.SavedState a(Parcel paramParcel)
  {
    return new SlidingPaneLayout.SavedState(paramParcel, (byte)0);
  }

  private static SlidingPaneLayout.SavedState[] a(int paramInt)
  {
    return new SlidingPaneLayout.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.K
 * JD-Core Version:    0.6.2
 */