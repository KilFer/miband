package cn.com.smartdevices.bracelet.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShareData
  implements Parcelable
{
  private static final int COLOR_ACTIVITY_STEP = -15165244;
  private static final int COLOR_CONTINUE_SUCC = -1754044;
  private static final int COLOR_GOAL_FAILED = -15165244;
  private static final int COLOR_GOAL_SUCC = -691920;
  private static final int COLOR_LAST_NIGHT_SLEEP = -13157004;
  private static final int COLOR_MONTH_SLEEP = -11982228;
  private static final int COLOR_MONTH_STEP = -15228318;
  private static final int COLOR_NEW_RECORD = -1157324;
  private static final int COLOR_WEEK_SLEEP = -11982228;
  private static final int COLOR_WEEK_STEP = -15228318;
  public static final Parcelable.Creator<ShareData> CREATOR = new ShareData.1();
  public static final int SHARE_TYPE_ACTIVITY_STEP = 9;
  public static final int SHARE_TYPE_CONTINUE_SUCC = 8;
  public static final int SHARE_TYPE_GOAL_FAILED = 1;
  public static final int SHARE_TYPE_GOAL_SUCC = 0;
  public static final int SHARE_TYPE_LAST_NIGHT_SLEEP = 2;
  public static final int SHARE_TYPE_MONTH_AVE_STEPS = 6;
  public static final int SHARE_TYPE_MONTH_SLEEP = 4;
  public static final int SHARE_TYPE_NEW_RECORD = 5;
  public static final int SHARE_TYPE_WEEK_AVE_STEPS = 7;
  public static final int SHARE_TYPE_WEEK_SLEEP = 3;
  public int color = 0;
  public String content = "";
  public String contentUnit = "";
  public String description = "";
  public String time = "";
  public String time_tips = "";
  public String title = "";
  public int type = 0;

  public ShareData()
  {
  }

  public ShareData(int paramInt)
  {
    setType(paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean isSleepType()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 3);
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.color = -691920;
      return;
    case 1:
      this.color = -15165244;
      return;
    case 2:
      this.color = -13157004;
      return;
    case 6:
      this.color = -15228318;
      return;
    case 4:
      this.color = -11982228;
      return;
    case 5:
      this.color = -1157324;
      return;
    case 7:
      this.color = -15228318;
      return;
    case 3:
      this.color = -11982228;
      return;
    case 8:
      this.color = -1754044;
      return;
    case 9:
    }
    this.color = -15165244;
  }

  public String toString()
  {
    return "type:" + this.type + "\ntitle:" + this.title + "\ncontent:" + this.content + "\ncontentUnit:" + this.contentUnit + "\ntime:" + this.time + "\ntime_tips:" + this.time_tips + "\ndescription:" + this.description + "\ncolor:" + this.color;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.contentUnit);
    paramParcel.writeString(this.time);
    paramParcel.writeString(this.time_tips);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.color);
    paramParcel.writeInt(this.type);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareData
 * JD-Core Version:    0.6.2
 */