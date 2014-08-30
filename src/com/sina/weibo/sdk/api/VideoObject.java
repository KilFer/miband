package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoObject extends BaseMediaObject
{
  public static final Parcelable.Creator<VideoObject> CREATOR = new VideoObject.1();
  public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
  public String dataHdUrl;
  public String dataUrl;
  public String defaultText;
  public int duration;
  public String h5Url;

  public VideoObject()
  {
  }

  public VideoObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.h5Url = paramParcel.readString();
    this.dataUrl = paramParcel.readString();
    this.dataHdUrl = paramParcel.readString();
    this.duration = paramParcel.readInt();
  }

  public boolean checkArgs()
  {
    if (!super.checkArgs())
      return false;
    if ((this.dataUrl != null) && (this.dataUrl.length() > 512))
    {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataUrl is invalid");
      return false;
    }
    if ((this.dataHdUrl != null) && (this.dataHdUrl.length() > 512))
    {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataHdUrl is invalid");
      return false;
    }
    if (this.duration <= 0)
    {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, duration is invalid");
      return false;
    }
    return true;
  }

  public int getObjType()
  {
    return 4;
  }

  protected BaseMediaObject toExtraMediaObject(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    try
    {
      this.defaultText = new JSONObject(paramString).optString("extra_key_defaulttext");
      return this;
    }
    catch (JSONException localJSONException)
    {
    }
    return this;
  }

  protected String toExtraMediaString()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(this.defaultText))
        localJSONObject.put("extra_key_defaulttext", this.defaultText);
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.h5Url);
    paramParcel.writeString(this.dataUrl);
    paramParcel.writeString(this.dataHdUrl);
    paramParcel.writeInt(this.duration);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.VideoObject
 * JD-Core Version:    0.6.2
 */