package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.Debug;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.ImageViewUtil;
import com.xiaomi.hm.health.R.styleable;

public class CropImageView extends FrameLayout
{
  public static final int DEFAULT_ASPECT_RATIO_X = 1;
  public static final int DEFAULT_ASPECT_RATIO_Y = 1;
  public static final boolean DEFAULT_FIXED_ASPECT_RATIO = false;
  public static final int DEFAULT_GUIDELINES = 1;
  private static final Rect a = new Rect();
  private static final int b = 0;
  private static final String c = "DEGREES_ROTATED";
  private static final String d = "CropImageView";
  private ImageView e;
  private CropOverlayView f;
  private Bitmap g;
  private int h = 0;
  private int i;
  private int j;
  private int k = 1;
  private boolean l = false;
  private int m = 1;
  private int n = 1;
  private int o = 0;

  public CropImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CropImageView, 0, 0);
    try
    {
      this.k = localTypedArray.getInteger(0, 1);
      this.l = localTypedArray.getBoolean(1, false);
      this.m = localTypedArray.getInteger(2, 1);
      this.n = localTypedArray.getInteger(3, 1);
      this.o = localTypedArray.getResourceId(4, 0);
      localTypedArray.recycle();
      a(paramContext);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        localTypedArray.recycle();
      }
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 1073741824)
      return paramInt2;
    if (paramInt1 == -2147483648)
      return Math.min(paramInt3, paramInt2);
    return paramInt3;
  }

  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903064, this, true);
    this.e = ((ImageView)localView.findViewById(2131165329));
    setImageResource(this.o);
    this.f = ((CropOverlayView)localView.findViewById(2131165330));
    this.f.setInitialAttributeValues(this.k, this.l, this.m, this.n);
  }

  public RectF getActualCropRect()
  {
    Rect localRect = ImageViewUtil.getBitmapRectCenterInside(this.g, this.e);
    float f1 = this.g.getWidth() / localRect.width();
    float f2 = this.g.getHeight() / localRect.height();
    float f3 = Edge.LEFT.getCoordinate() - localRect.left;
    float f4 = Edge.TOP.getCoordinate() - localRect.top;
    float f5 = Edge.getWidth();
    float f6 = Edge.getHeight();
    float f7 = f3 * f1;
    float f8 = f4 * f2;
    float f9 = f7 + f1 * f5;
    float f10 = f8 + f2 * f6;
    return new RectF(Math.max(0.0F, f7), Math.max(0.0F, f8), Math.min(this.g.getWidth(), f9), Math.min(this.g.getHeight(), f10));
  }

  public Bitmap getCroppedImage(int paramInt1, int paramInt2)
  {
    if (this.g == null)
      return null;
    Rect localRect = ImageViewUtil.getBitmapRectCenterInside(this.g, this.e);
    float f1 = this.g.getWidth() / localRect.width();
    float f2 = this.g.getHeight() / localRect.height();
    float f3 = Edge.LEFT.getCoordinate() - localRect.left;
    float f4 = Edge.TOP.getCoordinate() - localRect.top;
    float f5 = Edge.getWidth();
    float f6 = Edge.getHeight();
    float f7 = f3 * f1;
    float f8 = f4 * f2;
    float f9 = f5 * f1;
    float f10 = f6 * f2;
    Debug.i("CropImageView", ", actualCropWidth=" + f9 + ", actualCropHeight=" + f10);
    if ((f9 < 100.0F) || (f10 < 100.0F))
      return this.g;
    Matrix localMatrix = new Matrix();
    if ((paramInt1 < f9) || (paramInt2 < f10))
    {
      float f11 = paramInt1 / f9;
      float f12 = paramInt2 / f10;
      Debug.i("CropImageView", "scaleWidth = " + f11 + ", scaleHeight=" + f12);
      localMatrix.postScale(f11, f12);
    }
    return Bitmap.createBitmap(this.g, (int)f7, (int)f8, (int)f9, (int)f10, localMatrix, false);
  }

  public int getImageResource()
  {
    return this.o;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.i > 0) && (this.j > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.width = this.i;
      localLayoutParams.height = this.j;
      setLayoutParams(localLayoutParams);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if (this.g != null)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (i4 == 0)
        i4 = this.g.getHeight();
      if (i2 >= this.g.getWidth())
        break label297;
    }
    label297: for (double d1 = i2 / this.g.getWidth(); ; d1 = (1.0D / 0.0D))
    {
      if (i4 < this.g.getHeight());
      for (double d2 = i4 / this.g.getHeight(); ; d2 = (1.0D / 0.0D))
      {
        int i6;
        int i5;
        if ((d1 != (1.0D / 0.0D)) || (d2 != (1.0D / 0.0D)))
          if (d1 <= d2)
          {
            i6 = (int)(d1 * this.g.getHeight());
            i5 = i2;
          }
        while (true)
        {
          int i7 = a(i1, i2, i5);
          int i8 = a(i3, i4, i6);
          this.i = i7;
          this.j = i8;
          Rect localRect = ImageViewUtil.getBitmapRectCenterInside(this.g.getWidth(), this.g.getHeight(), this.i, this.j);
          this.f.setBitmapRect(localRect);
          setMeasuredDimension(this.i, this.j);
          return;
          i5 = (int)(d2 * this.g.getWidth());
          i6 = i4;
          continue;
          i5 = this.g.getWidth();
          i6 = this.g.getHeight();
        }
        this.f.setBitmapRect(a);
        setMeasuredDimension(i2, i4);
        return;
      }
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      if (this.g != null)
      {
        this.h = localBundle.getInt("DEGREES_ROTATED");
        int i1 = this.h;
        rotateImage(this.h);
        this.h = i1;
      }
      super.onRestoreInstanceState(localBundle.getParcelable("instanceState"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putInt("DEGREES_ROTATED", this.h);
    return localBundle;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.g != null)
    {
      Rect localRect = ImageViewUtil.getBitmapRectCenterInside(this.g, this);
      this.f.setBitmapRect(localRect);
      return;
    }
    this.f.setBitmapRect(a);
  }

  public void rotateImage(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    this.g = Bitmap.createBitmap(this.g, 0, 0, this.g.getWidth(), this.g.getHeight(), localMatrix, true);
    setImageBitmap(this.g);
    this.h = (paramInt + this.h);
    this.h %= 360;
  }

  public void setAspectRatio(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.f.setAspectRatioX(this.m);
    this.n = paramInt2;
    this.f.setAspectRatioY(this.n);
  }

  public void setFixedAspectRatio(boolean paramBoolean)
  {
    this.f.setFixedAspectRatio(paramBoolean);
  }

  public void setGuidelines(int paramInt)
  {
    this.f.setGuidelines(paramInt);
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
    this.e.setImageBitmap(this.g);
    if (this.f != null)
      this.f.resetCropOverlayView();
  }

  public void setImageBitmap(Bitmap paramBitmap, ExifInterface paramExifInterface)
  {
    if (paramBitmap == null)
      return;
    if (paramExifInterface == null)
    {
      setImageBitmap(paramBitmap);
      return;
    }
    Matrix localMatrix = new Matrix();
    int i1;
    switch (paramExifInterface.getAttributeInt("Orientation", 1))
    {
    case 4:
    case 5:
    case 7:
    default:
      i1 = -1;
    case 8:
    case 3:
    case 6:
    }
    while (i1 == -1)
    {
      setImageBitmap(paramBitmap);
      return;
      i1 = 270;
      continue;
      i1 = 180;
      continue;
      i1 = 90;
    }
    localMatrix.postRotate(i1);
    setImageBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true));
    paramBitmap.recycle();
  }

  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
      setImageBitmap(BitmapFactory.decodeResource(getResources(), paramInt));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.CropImageView
 * JD-Core Version:    0.6.2
 */