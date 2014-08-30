package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.view.View.BaseSavedState;

public class VerticalViewPager$SavedState extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new H());
  int a;
  Parcelable b;
  ClassLoader c;

  VerticalViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    if (paramClassLoader == null)
      paramClassLoader = getClass().getClassLoader();
    this.a = paramParcel.readInt();
    this.b = paramParcel.readParcelable(paramClassLoader);
    this.c = paramClassLoader;
  }

  public VerticalViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }

  public String toString()
  {
    return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.VerticalViewPager.SavedState
 * JD-Core Version:    0.6.2
 */