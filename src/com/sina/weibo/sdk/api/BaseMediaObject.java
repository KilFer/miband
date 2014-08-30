package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;

public abstract class BaseMediaObject
  implements Parcelable
{
  public static final int MEDIA_TYPE_CMD = 7;
  public static final int MEDIA_TYPE_IMAGE = 2;
  public static final int MEDIA_TYPE_MUSIC = 3;
  public static final int MEDIA_TYPE_TEXT = 1;
  public static final int MEDIA_TYPE_VIDEO = 4;
  public static final int MEDIA_TYPE_VOICE = 6;
  public static final int MEDIA_TYPE_WEBPAGE = 5;
  public String actionUrl;
  public String description;
  public String identify;
  public String schema;
  public byte[] thumbData;
  public String title;

  public BaseMediaObject()
  {
  }

  public BaseMediaObject(Parcel paramParcel)
  {
    this.actionUrl = paramParcel.readString();
    this.schema = paramParcel.readString();
    this.identify = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.thumbData = paramParcel.createByteArray();
  }

  protected boolean checkArgs()
  {
    if ((this.actionUrl == null) || (this.actionUrl.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
      return false;
    }
    if ((this.identify == null) || (this.identify.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
      return false;
    }
    if ((this.thumbData == null) || (this.thumbData.length > 32768))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, thumbData is invalid,size is " + this.thumbData.length + "! more then 32768.");
      return false;
    }
    if ((this.title == null) || (this.title.length() > 512))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
      return false;
    }
    if ((this.description == null) || (this.description.length() > 1024))
    {
      LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
      return false;
    }
    return true;
  }

  public int describeContents()
  {
    return 0;
  }

  public abstract int getObjType();

  // ERROR //
  public final void setThumbImage(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 110	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 111	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: getstatic 117	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   12: bipush 85
    //   14: aload_2
    //   15: invokevirtual 123	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: pop
    //   19: aload_0
    //   20: aload_2
    //   21: invokevirtual 126	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   24: putfield 56	com/sina/weibo/sdk/api/BaseMediaObject:thumbData	[B
    //   27: aload_2
    //   28: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   31: return
    //   32: astore_3
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_3
    //   36: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   39: ldc 66
    //   41: ldc 134
    //   43: invokestatic 74	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   50: return
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   67: aload 4
    //   69: athrow
    //   70: astore 5
    //   72: aload 5
    //   74: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   77: goto -10 -> 67
    //   80: astore 8
    //   82: aload 8
    //   84: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   87: return
    //   88: astore 4
    //   90: goto -27 -> 63
    //   93: astore_3
    //   94: goto -59 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/Exception
    //   46	50	51	java/io/IOException
    //   0	8	59	finally
    //   63	67	70	java/io/IOException
    //   27	31	80	java/io/IOException
    //   8	27	88	finally
    //   35	46	88	finally
    //   8	27	93	java/lang/Exception
  }

  protected abstract BaseMediaObject toExtraMediaObject(String paramString);

  protected abstract String toExtraMediaString();

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.schema);
    paramParcel.writeString(this.identify);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeByteArray(this.thumbData);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.BaseMediaObject
 * JD-Core Version:    0.6.2
 */