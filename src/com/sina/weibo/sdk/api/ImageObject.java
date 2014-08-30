package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.File;

public class ImageObject extends BaseMediaObject
{
  public static final Parcelable.Creator<ImageObject> CREATOR = new ImageObject.1();
  private static final int DATA_SIZE = 2097152;
  public byte[] imageData;
  public String imagePath;

  public ImageObject()
  {
  }

  public ImageObject(Parcel paramParcel)
  {
    this.imageData = paramParcel.createByteArray();
    this.imagePath = paramParcel.readString();
  }

  public boolean checkArgs()
  {
    if ((this.imageData == null) && (this.imagePath == null))
    {
      LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 2097152))
    {
      LogUtil.e("Weibo.ImageObject", "imageData is too large");
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 512))
    {
      LogUtil.e("Weibo.ImageObject", "imagePath is too length");
      return false;
    }
    if (this.imagePath != null)
    {
      File localFile = new File(this.imagePath);
      try
      {
        if ((!localFile.exists()) || (localFile.length() == 0L) || (localFile.length() > 10485760L))
        {
          LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
          return false;
        }
      }
      catch (SecurityException localSecurityException)
      {
        LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
        return false;
      }
    }
    return true;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getObjType()
  {
    return 2;
  }

  // ERROR //
  public final void setImageObject(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 88	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 89	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: getstatic 95	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   12: bipush 85
    //   14: aload_2
    //   15: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: pop
    //   19: aload_0
    //   20: aload_2
    //   21: invokevirtual 104	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   24: putfield 33	com/sina/weibo/sdk/api/ImageObject:imageData	[B
    //   27: aload_2
    //   28: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   31: return
    //   32: astore_3
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_3
    //   36: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   39: ldc 45
    //   41: ldc 112
    //   43: invokestatic 53	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   50: return
    //   51: astore 6
    //   53: aload 6
    //   55: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   67: aload 4
    //   69: athrow
    //   70: astore 5
    //   72: aload 5
    //   74: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   77: goto -10 -> 67
    //   80: astore 8
    //   82: aload 8
    //   84: invokevirtual 113	java/io/IOException:printStackTrace	()V
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

  protected BaseMediaObject toExtraMediaObject(String paramString)
  {
    return this;
  }

  protected String toExtraMediaString()
  {
    return "";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.imageData);
    paramParcel.writeString(this.imagePath);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ImageObject
 * JD-Core Version:    0.6.2
 */