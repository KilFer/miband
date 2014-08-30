package android.support.v4.view;

import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

final class aG
  implements ParcelableCompatCreatorCallbacks<ViewPager.SavedState>
{
  private static ViewPager.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new ViewPager.SavedState(paramParcel, paramClassLoader);
  }

  private static ViewPager.SavedState[] a(int paramInt)
  {
    return new ViewPager.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.aG
 * JD-Core Version:    0.6.2
 */