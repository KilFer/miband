package cn.com.smartdevices.bracelet.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class SlideMenu$SavedState extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new A();
  public int currentContentOffset;
  public int currentState;
  public float primaryShadowWidth;
  public float secondaryShadaryWidth;
  public int slideDirectionFlag;
  public int slideMode;

  private SlideMenu$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.primaryShadowWidth = paramParcel.readFloat();
    this.secondaryShadaryWidth = paramParcel.readFloat();
    this.slideDirectionFlag = paramParcel.readInt();
    this.slideMode = paramParcel.readInt();
    this.currentState = paramParcel.readInt();
    this.currentContentOffset = paramParcel.readInt();
  }

  SlideMenu$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.primaryShadowWidth);
    paramParcel.writeFloat(this.secondaryShadaryWidth);
    paramParcel.writeInt(this.slideDirectionFlag);
    paramParcel.writeInt(this.slideMode);
    paramParcel.writeInt(this.currentState);
    paramParcel.writeInt(this.currentContentOffset);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.SlideMenu.SavedState
 * JD-Core Version:    0.6.2
 */