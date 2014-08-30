package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import cn.com.smartdevices.bracelet.Debug;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.Handle;
import com.edmodo.cropper.util.AspectRatioUtil;
import com.edmodo.cropper.util.HandleUtil;
import com.edmodo.cropper.util.PaintUtil;

public class CropOverlayView extends View
{
  public static final float DEFAULT_SHOW_GUIDELINES_LIMIT = 100.0F;
  private static final int a = 6;
  private static final float b = 0.0F;
  private static final float c = 0.0F;
  private static final float d = 0.0F;
  private static final float e = 0.0F;
  private static final float f = 20.0F;
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = -1342177280;
  private static final int k = 1;
  private static final int l = 2;
  private static final String m = "CropOverlayView";
  private int A;
  private boolean B = false;
  private float C;
  private float D;
  private float E;
  private int F;
  private Paint n;
  private Paint o;
  private Paint p;
  private Paint q;
  private Rect r;
  private float s;
  private float t;
  private Pair<Float, Float> u;
  private Handle v;
  private boolean w = false;
  private int x = 1;
  private int y = 1;
  private float z = this.x / this.y;

  public CropOverlayView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public CropOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a()
  {
    if (this.v == null)
      return;
    this.v = null;
    invalidate();
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    this.v = HandleUtil.getPressedHandle(paramFloat1, paramFloat2, f1, f2, f3, f4, this.s);
    if (this.v == null)
      return;
    this.u = HandleUtil.getOffset(this.v, paramFloat1, paramFloat2, f1, f2, f3, f4);
    invalidate();
  }

  private void a(Context paramContext)
  {
    this.F = 1;
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.s = HandleUtil.getTargetRadius(paramContext);
    this.t = TypedValue.applyDimension(1, 6.0F, localDisplayMetrics);
    this.n = PaintUtil.newBorderPaint(paramContext);
    this.o = PaintUtil.newGuidelinePaint();
    PaintUtil.newBackgroundPaint(paramContext);
    this.p = PaintUtil.newCornerPaint(paramContext);
    this.D = (-TypedValue.applyDimension(1, d, localDisplayMetrics));
    this.C = (-this.D);
    this.E = TypedValue.applyDimension(1, 20.0F, localDisplayMetrics);
    this.A = 1;
  }

  private void a(Canvas paramCanvas)
  {
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    float f5 = Edge.getWidth() / 3.0F;
    float f6 = f1 + f5;
    paramCanvas.drawLine(f6, f2, f6, f4, this.o);
    float f7 = f3 - f5;
    paramCanvas.drawLine(f7, f2, f7, f4, this.o);
    float f8 = Edge.getHeight() / 3.0F;
    float f9 = f2 + f8;
    paramCanvas.drawLine(f1, f9, f3, f9, this.o);
    float f10 = f4 - f8;
    paramCanvas.drawLine(f1, f10, f3, f10, this.o);
  }

  private void a(Canvas paramCanvas, Rect paramRect)
  {
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    paramCanvas.save();
    setLayerType(1, null);
    paramCanvas.clipRect(new RectF(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom));
    if (this.F == 1)
    {
      Path localPath = new Path();
      localPath.addCircle(f1 + (f3 - f1) / 2.0F, f2 + (f4 - f2) / 2.0F, (f4 - f2) / 2.0F - this.n.getStrokeWidth(), Path.Direction.CW);
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
    }
    while (true)
    {
      paramCanvas.drawColor(-1342177280);
      paramCanvas.restore();
      return;
      if (this.F == 2)
        paramCanvas.clipRect(f1, f2, f3, f4, Region.Op.DIFFERENCE);
    }
  }

  private void a(Rect paramRect)
  {
    if ((paramRect.right - paramRect.left) * (paramRect.bottom - paramRect.top) <= 0)
    {
      Debug.i("CropOverlayView", "initCropWindow skipped 'cause bitmapRect is empty");
      return;
    }
    if (!this.B)
      this.B = true;
    if (this.w)
    {
      if (AspectRatioUtil.calculateAspectRatio(paramRect) > this.z)
      {
        Edge.TOP.setCoordinate(paramRect.top);
        Edge.BOTTOM.setCoordinate(paramRect.bottom);
        float f6 = getWidth() / 2.0F;
        float f7 = Math.max(60.0F, AspectRatioUtil.calculateWidth(Edge.TOP.getCoordinate(), Edge.BOTTOM.getCoordinate(), this.z));
        if (f7 == 60.0F)
          this.z = (60.0F / (Edge.BOTTOM.getCoordinate() - Edge.TOP.getCoordinate()));
        float f8 = f7 / 2.0F;
        Edge.LEFT.setCoordinate(f6 - f8);
        Edge.RIGHT.setCoordinate(f6 + f8);
        return;
      }
      Edge.LEFT.setCoordinate(paramRect.left);
      Edge.RIGHT.setCoordinate(paramRect.right);
      float f3 = getHeight() / 2.0F;
      float f4 = Math.max(60.0F, AspectRatioUtil.calculateHeight(Edge.LEFT.getCoordinate(), Edge.RIGHT.getCoordinate(), this.z));
      if (f4 == 60.0F)
        this.z = ((Edge.RIGHT.getCoordinate() - Edge.LEFT.getCoordinate()) / 60.0F);
      float f5 = f4 / 2.0F;
      Edge.TOP.setCoordinate(f3 - f5);
      Edge.BOTTOM.setCoordinate(f3 + f5);
      return;
    }
    float f1 = 0.1F * paramRect.width();
    float f2 = 0.1F * paramRect.height();
    Edge.LEFT.setCoordinate(f1 + paramRect.left);
    Edge.TOP.setCoordinate(f2 + paramRect.top);
    Edge.RIGHT.setCoordinate(paramRect.right - f1);
    Edge.BOTTOM.setCoordinate(paramRect.bottom - f2);
  }

  private void b(float paramFloat1, float paramFloat2)
  {
    if (this.v == null)
      return;
    float f1 = paramFloat1 + ((Float)this.u.first).floatValue();
    float f2 = paramFloat2 + ((Float)this.u.second).floatValue();
    if (this.w)
      this.v.updateCropWindow(f1, f2, this.z, this.r, this.t);
    while (true)
    {
      invalidate();
      return;
      this.v.updateCropWindow(f1, f2, this.r, this.t);
    }
  }

  private void b(Canvas paramCanvas)
  {
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    paramCanvas.drawLine(f1 - this.D, f2 - this.C, f1 - this.D, f2 + this.E, this.p);
    paramCanvas.drawLine(f1, f2 - this.D, f1 + this.E, f2 - this.D, this.p);
    paramCanvas.drawLine(f3 + this.D, f2 - this.C, f3 + this.D, f2 + this.E, this.p);
    paramCanvas.drawLine(f3, f2 - this.D, f3 - this.E, f2 - this.D, this.p);
    paramCanvas.drawLine(f1 - this.D, f4 + this.C, f1 - this.D, f4 - this.E, this.p);
    paramCanvas.drawLine(f1, f4 + this.D, f1 + this.E, f4 + this.D, this.p);
    paramCanvas.drawLine(f3 + this.D, f4 + this.C, f3 + this.D, f4 - this.E, this.p);
    paramCanvas.drawLine(f3, f4 + this.D, f3 - this.E, f4 + this.D, this.p);
  }

  public static boolean showGuidelines()
  {
    return (Math.abs(Edge.LEFT.getCoordinate() - Edge.RIGHT.getCoordinate()) >= 100.0F) && (Math.abs(Edge.TOP.getCoordinate() - Edge.BOTTOM.getCoordinate()) >= 100.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    Rect localRect = this.r;
    float f5 = Edge.LEFT.getCoordinate();
    float f6 = Edge.TOP.getCoordinate();
    float f7 = Edge.RIGHT.getCoordinate();
    float f8 = Edge.BOTTOM.getCoordinate();
    paramCanvas.save();
    setLayerType(1, null);
    paramCanvas.clipRect(new RectF(localRect.left, localRect.top, localRect.right, localRect.bottom));
    if (this.F == 1)
    {
      Path localPath = new Path();
      localPath.addCircle(f5 + (f7 - f5) / 2.0F, f6 + (f8 - f6) / 2.0F, (f8 - f6) / 2.0F - this.n.getStrokeWidth(), Path.Direction.CW);
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
      paramCanvas.drawColor(-1342177280);
      paramCanvas.restore();
      if (showGuidelines())
      {
        if (this.A != 2)
          break label569;
        a(paramCanvas);
      }
      label219: if (this.F != 2)
        break label592;
      paramCanvas.drawRect(f1, f2, f3, f4, this.n);
    }
    while (true)
    {
      float f9 = Edge.LEFT.getCoordinate();
      float f10 = Edge.TOP.getCoordinate();
      float f11 = Edge.RIGHT.getCoordinate();
      float f12 = Edge.BOTTOM.getCoordinate();
      paramCanvas.drawLine(f9 - this.D, f10 - this.C, f9 - this.D, f10 + this.E, this.p);
      paramCanvas.drawLine(f9, f10 - this.D, f9 + this.E, f10 - this.D, this.p);
      paramCanvas.drawLine(f11 + this.D, f10 - this.C, f11 + this.D, f10 + this.E, this.p);
      paramCanvas.drawLine(f11, f10 - this.D, f11 - this.E, f10 - this.D, this.p);
      paramCanvas.drawLine(f9 - this.D, f12 + this.C, f9 - this.D, f12 - this.E, this.p);
      paramCanvas.drawLine(f9, f12 + this.D, f9 + this.E, f12 + this.D, this.p);
      paramCanvas.drawLine(f11 + this.D, f12 + this.C, f11 + this.D, f12 - this.E, this.p);
      paramCanvas.drawLine(f11, f12 + this.D, f11 - this.E, f12 + this.D, this.p);
      return;
      if (this.F != 2)
        break;
      paramCanvas.clipRect(f5, f6, f7, f8, Region.Op.DIFFERENCE);
      break;
      label569: if ((this.A != 1) || (this.v == null))
        break label219;
      a(paramCanvas);
      break label219;
      label592: paramCanvas.drawCircle(f1 + (f3 - f1) / 2.0F, f2 + (f4 - f2) / 2.0F, (f4 - f2) / 2.0F - this.n.getStrokeWidth(), this.n);
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(this.r);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled())
      return false;
    switch (paramMotionEvent.getAction())
    {
    default:
      return false;
    case 0:
      float f5 = paramMotionEvent.getX();
      float f6 = paramMotionEvent.getY();
      float f7 = Edge.LEFT.getCoordinate();
      float f8 = Edge.TOP.getCoordinate();
      float f9 = Edge.RIGHT.getCoordinate();
      float f10 = Edge.BOTTOM.getCoordinate();
      this.v = HandleUtil.getPressedHandle(f5, f6, f7, f8, f9, f10, this.s);
      if (this.v != null)
      {
        this.u = HandleUtil.getOffset(this.v, f5, f6, f7, f8, f9, f10);
        invalidate();
      }
      return true;
    case 1:
    case 3:
      getParent().requestDisallowInterceptTouchEvent(false);
      if (this.v != null)
      {
        this.v = null;
        invalidate();
      }
      return true;
    case 2:
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3;
    float f4;
    if (this.v != null)
    {
      f3 = f1 + ((Float)this.u.first).floatValue();
      f4 = f2 + ((Float)this.u.second).floatValue();
      if (!this.w)
        break label274;
      this.v.updateCropWindow(f3, f4, this.z, this.r, this.t);
    }
    while (true)
    {
      invalidate();
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
      label274: this.v.updateCropWindow(f3, f4, this.r, this.t);
    }
  }

  public void resetCropOverlayView()
  {
    if (this.B)
    {
      a(this.r);
      invalidate();
    }
  }

  public void setAspectRatioX(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
    this.x = paramInt;
    this.z = (this.x / this.y);
    if (this.B)
    {
      a(this.r);
      invalidate();
    }
  }

  public void setAspectRatioY(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
    this.y = paramInt;
    this.z = (this.x / this.y);
    if (this.B)
    {
      a(this.r);
      invalidate();
    }
  }

  public void setBitmapRect(Rect paramRect)
  {
    this.r = paramRect;
    a(this.r);
  }

  public void setFixedAspectRatio(boolean paramBoolean)
  {
    this.w = paramBoolean;
    if (this.B)
    {
      a(this.r);
      invalidate();
    }
  }

  public void setGuidelines(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2))
      throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
    this.A = paramInt;
    if (this.B)
    {
      a(this.r);
      invalidate();
    }
  }

  public void setInitialAttributeValues(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2))
      throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
    this.A = paramInt1;
    this.w = paramBoolean;
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
    this.x = paramInt2;
    this.z = (this.x / this.y);
    if (paramInt3 <= 0)
      throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
    this.y = paramInt3;
    this.z = (this.x / this.y);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.CropOverlayView
 * JD-Core Version:    0.6.2
 */