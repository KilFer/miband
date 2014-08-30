package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class ParcelableCompat
{
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    if (Build.VERSION.SDK_INT >= 13)
      new b(paramParcelableCompatCreatorCallbacks);
    return new a(paramParcelableCompatCreatorCallbacks);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.ParcelableCompat
 * JD-Core Version:    0.6.2
 */