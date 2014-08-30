package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class H
  implements ParcelableCompatCreatorCallbacks<VerticalViewPager.SavedState>
{
  private static VerticalViewPager.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new VerticalViewPager.SavedState(paramParcel, paramClassLoader);
  }

  private static VerticalViewPager.SavedState[] a(int paramInt)
  {
    return new VerticalViewPager.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.H
 * JD-Core Version:    0.6.2
 */