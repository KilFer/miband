package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.AspectRatioUtil;

final class e extends c
{
  private Edge a;

  e(Edge paramEdge)
  {
    super(null, paramEdge);
    this.a = paramEdge;
  }

  final void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4)
  {
    this.a.adjustCoordinate(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    float f5 = (AspectRatioUtil.calculateHeight(f1, f3, paramFloat3) - (f4 - f2)) / 2.0F;
    float f6 = f2 - f5;
    float f7 = f5 + f4;
    Edge.TOP.setCoordinate(f6);
    Edge.BOTTOM.setCoordinate(f7);
    if ((Edge.TOP.isOutsideMargin(paramRect, paramFloat4)) && (!this.a.isNewRectangleOutOfBounds(Edge.TOP, paramRect, paramFloat3)))
    {
      float f9 = Edge.TOP.snapToRect(paramRect);
      Edge.BOTTOM.offset(-f9);
      this.a.adjustCoordinate(paramFloat3);
    }
    if ((Edge.BOTTOM.isOutsideMargin(paramRect, paramFloat4)) && (!this.a.isNewRectangleOutOfBounds(Edge.BOTTOM, paramRect, paramFloat3)))
    {
      float f8 = Edge.BOTTOM.snapToRect(paramRect);
      Edge.TOP.offset(-f8);
      this.a.adjustCoordinate(paramFloat3);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.e
 * JD-Core Version:    0.6.2
 */