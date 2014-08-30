package cn.com.smartdevices.bracelet.lua;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class SlidingUpPanelLayout$SavedState extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new m();
  n a;

  private SlidingUpPanelLayout$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    try
    {
      this.a = ((n)Enum.valueOf(n.class, paramParcel.readString()));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.a = n.b;
    }
  }

  SlidingUpPanelLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a.toString());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.SavedState
 * JD-Core Version:    0.6.2
 */