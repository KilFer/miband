package android.support.v4.os;

import android.os.Parcelable.Creator;

final class c
{
  static <T> Parcelable.Creator<T> a(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    return new b(paramParcelableCompatCreatorCallbacks);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.c
 * JD-Core Version:    0.6.2
 */