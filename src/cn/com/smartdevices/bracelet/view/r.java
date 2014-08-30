package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class r
  implements Parcelable.Creator<PagerSlidingTabStrip.SavedState>
{
  private static PagerSlidingTabStrip.SavedState a(Parcel paramParcel)
  {
    return new PagerSlidingTabStrip.SavedState(paramParcel, (byte)0);
  }

  private static PagerSlidingTabStrip.SavedState[] a(int paramInt)
  {
    return new PagerSlidingTabStrip.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.r
 * JD-Core Version:    0.6.2
 */