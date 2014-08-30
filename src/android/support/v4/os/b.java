package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class b<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final ParcelableCompatCreatorCallbacks<T> a;

  public b(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    this.a = paramParcelableCompatCreatorCallbacks;
  }

  public final T createFromParcel(Parcel paramParcel)
  {
    return this.a.createFromParcel(paramParcel, null);
  }

  public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.a.createFromParcel(paramParcel, paramClassLoader);
  }

  public final T[] newArray(int paramInt)
  {
    return this.a.newArray(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.b
 * JD-Core Version:    0.6.2
 */