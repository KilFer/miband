package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder
  implements ImageDecoder
{
  protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
  protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
  protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
  protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
  protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
  protected final boolean loggingEnabled;

  public BaseImageDecoder(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }

  private static boolean a(String paramString1, String paramString2)
  {
    return (Build.VERSION.SDK_INT >= 5) && ("image/jpeg".equalsIgnoreCase(paramString2)) && (ImageDownloader.Scheme.ofUri(paramString1) == ImageDownloader.Scheme.FILE);
  }

  protected Bitmap considerExactScaleAndOrientatiton(Bitmap paramBitmap, ImageDecodingInfo paramImageDecodingInfo, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize1;
    ImageSize localImageSize2;
    ViewScaleType localViewScaleType;
    if ((localImageScaleType == ImageScaleType.EXACTLY) || (localImageScaleType == ImageScaleType.EXACTLY_STRETCHED))
    {
      localImageSize1 = new ImageSize(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      localImageSize2 = paramImageDecodingInfo.getTargetSize();
      localViewScaleType = paramImageDecodingInfo.getViewScaleType();
      if (localImageScaleType != ImageScaleType.EXACTLY_STRETCHED)
        break label279;
    }
    label279: for (boolean bool = true; ; bool = false)
    {
      float f = ImageSizeUtils.computeImageScale(localImageSize1, localImageSize2, localViewScaleType, bool);
      if (Float.compare(f, 1.0F) != 0)
      {
        localMatrix.setScale(f, f);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject3 = new Object[4];
          arrayOfObject3[0] = localImageSize1;
          arrayOfObject3[1] = localImageSize1.scale(f);
          arrayOfObject3[2] = Float.valueOf(f);
          arrayOfObject3[3] = paramImageDecodingInfo.getImageKey();
          L.d("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", arrayOfObject3);
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramImageDecodingInfo.getImageKey();
          L.d("Flip image horizontally [%s]", arrayOfObject2);
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Integer.valueOf(paramInt);
          arrayOfObject1[1] = paramImageDecodingInfo.getImageKey();
          L.d("Rotate image on %1$d° [%2$s]", arrayOfObject1);
        }
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (localBitmap != paramBitmap)
        paramBitmap.recycle();
      return localBitmap;
    }
  }

  public Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
  {
    InputStream localInputStream = getImageStream(paramImageDecodingInfo);
    BaseImageDecoder.ImageFileInfo localImageFileInfo;
    Bitmap localBitmap;
    try
    {
      localImageFileInfo = defineImageSizeAndRotation(localInputStream, paramImageDecodingInfo);
      localInputStream = resetStream(localInputStream, paramImageDecodingInfo);
      localBitmap = BitmapFactory.decodeStream(localInputStream, null, prepareDecodingOptions(localImageFileInfo.imageSize, paramImageDecodingInfo));
      IoUtils.closeSilently(localInputStream);
      if (localBitmap == null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramImageDecodingInfo.getImageKey();
        L.e("Image can't be decoded [%s]", arrayOfObject);
        return localBitmap;
      }
    }
    finally
    {
      IoUtils.closeSilently(localInputStream);
    }
    return considerExactScaleAndOrientatiton(localBitmap, paramImageDecodingInfo, localImageFileInfo.exif.rotation, localImageFileInfo.exif.flipHorizontal);
  }

  protected BaseImageDecoder.ExifInfo defineExifOrientation(String paramString)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      int j = new ExifInterface(ImageDownloader.Scheme.FILE.crop(paramString)).getAttributeInt("Orientation", 1);
      i = 0;
      switch (j)
      {
      case 1:
      default:
        bool = false;
      case 2:
      case 6:
      case 7:
      case 3:
      case 4:
      case 8:
      case 5:
      }
      while (true)
      {
        return new BaseImageDecoder.ExifInfo(i, bool);
        bool = false;
        i = 90;
        continue;
        bool = false;
        i = 180;
        continue;
        bool = false;
        i = 270;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Object[] arrayOfObject = new Object[bool];
        arrayOfObject[0] = paramString;
        L.w("Can't read EXIF tags from file [%s]", arrayOfObject);
      }
    }
  }

  protected BaseImageDecoder.ImageFileInfo defineImageSizeAndRotation(InputStream paramInputStream, ImageDecodingInfo paramImageDecodingInfo)
  {
    boolean bool = true;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = bool;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    String str1 = paramImageDecodingInfo.getImageUri();
    if (paramImageDecodingInfo.shouldConsiderExifParams())
    {
      String str2 = localOptions.outMimeType;
      if ((Build.VERSION.SDK_INT >= 5) && ("image/jpeg".equalsIgnoreCase(str2)) && (ImageDownloader.Scheme.ofUri(str1) == ImageDownloader.Scheme.FILE))
        if (!bool)
          break label122;
    }
    label122: for (BaseImageDecoder.ExifInfo localExifInfo = defineExifOrientation(str1); ; localExifInfo = new BaseImageDecoder.ExifInfo())
    {
      return new BaseImageDecoder.ImageFileInfo(new ImageSize(localOptions.outWidth, localOptions.outHeight, localExifInfo.rotation), localExifInfo);
      bool = false;
      break;
    }
  }

  protected InputStream getImageStream(ImageDecodingInfo paramImageDecodingInfo)
  {
    return paramImageDecodingInfo.getDownloader().getStream(paramImageDecodingInfo.getImageUri(), paramImageDecodingInfo.getExtraForDownloader());
  }

  protected BitmapFactory.Options prepareDecodingOptions(ImageSize paramImageSize, ImageDecodingInfo paramImageDecodingInfo)
  {
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    int i;
    if (localImageScaleType == ImageScaleType.NONE)
    {
      i = ImageSizeUtils.computeMinImageSampleSize(paramImageSize);
      if ((i > 1) && (this.loggingEnabled))
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramImageSize;
        arrayOfObject[1] = paramImageSize.scaleDown(i);
        arrayOfObject[2] = Integer.valueOf(i);
        arrayOfObject[3] = paramImageDecodingInfo.getImageKey();
        L.d("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", arrayOfObject);
      }
      BitmapFactory.Options localOptions = paramImageDecodingInfo.getDecodingOptions();
      localOptions.inSampleSize = i;
      return localOptions;
    }
    ImageSize localImageSize = paramImageDecodingInfo.getTargetSize();
    if (localImageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
    for (boolean bool = true; ; bool = false)
    {
      i = ImageSizeUtils.computeImageSampleSize(paramImageSize, localImageSize, paramImageDecodingInfo.getViewScaleType(), bool);
      break;
    }
  }

  protected InputStream resetStream(InputStream paramInputStream, ImageDecodingInfo paramImageDecodingInfo)
  {
    try
    {
      paramInputStream.reset();
      return paramInputStream;
    }
    catch (IOException localIOException)
    {
      IoUtils.closeSilently(paramInputStream);
    }
    return getImageStream(paramImageDecodingInfo);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.BaseImageDecoder
 * JD-Core Version:    0.6.2
 */