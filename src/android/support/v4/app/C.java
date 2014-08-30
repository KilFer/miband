package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C
  implements Parcelable.Creator<FragmentState>
{
  private static FragmentState a(Parcel paramParcel)
  {
    return new FragmentState(paramParcel);
  }

  private static FragmentState[] a(int paramInt)
  {
    return new FragmentState[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.C
 * JD-Core Version:    0.6.2
 */