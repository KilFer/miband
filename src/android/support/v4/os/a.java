package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a<T>
  implements Parcelable.Creator<T>
{
  private ParcelableCompatCreatorCallbacks<T> a;

  public a(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    this.a = paramParcelableCompatCreatorCallbacks;
  }

  public final T createFromParcel(Parcel paramParcel)
  {
    return this.a.createFromParcel(paramParcel, null);
  }

  public final T[] newArray(int paramInt)
  {
    return this.a.newArray(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.a
 * JD-Core Version:    0.6.2
 */