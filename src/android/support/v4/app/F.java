package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class F
  implements Parcelable.Creator<FragmentTabHost.SavedState>
{
  private static FragmentTabHost.SavedState a(Parcel paramParcel)
  {
    return new FragmentTabHost.SavedState(paramParcel, (byte)0);
  }

  private static FragmentTabHost.SavedState[] a(int paramInt)
  {
    return new FragmentTabHost.SavedState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.F
 * JD-Core Version:    0.6.2
 */