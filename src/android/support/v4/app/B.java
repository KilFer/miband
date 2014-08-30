package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class B
  implements Parcelable.Creator<FragmentManagerState>
{
  private static FragmentManagerState a(Parcel paramParcel)
  {
    return new FragmentManagerState(paramParcel);
  }

  private static FragmentManagerState[] a(int paramInt)
  {
    return new FragmentManagerState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.B
 * JD-Core Version:    0.6.2
 */