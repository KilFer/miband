package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.AspectRatioUtil;

final class d extends c
{
  private Edge a;

  d(Edge paramEdge)
  {
    super(paramEdge, null);
    this.a = paramEdge;
  }

  final void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4)
  {
    this.a.adjustCoordinate(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = (AspectRatioUtil.calculateWidth(f2, Edge.BOTTOM.getCoordinate(), paramFloat3) - (f3 - f1)) / 2.0F;
    float f5 = f1 - f4;
    float f6 = f4 + f3;
    Edge.LEFT.setCoordinate(f5);
    Edge.RIGHT.setCoordinate(f6);
    if ((Edge.LEFT.isOutsideMargin(paramRect, paramFloat4)) && (!this.a.isNewRectangleOutOfBounds(Edge.LEFT, paramRect, paramFloat3)))
    {
      float f8 = Edge.LEFT.snapToRect(paramRect);
      Edge.RIGHT.offset(-f8);
      this.a.adjustCoordinate(paramFloat3);
    }
    if ((Edge.RIGHT.isOutsideMargin(paramRect, paramFloat4)) && (!this.a.isNewRectangleOutOfBounds(Edge.RIGHT, paramRect, paramFloat3)))
    {
      float f7 = Edge.RIGHT.snapToRect(paramRect);
      Edge.LEFT.offset(-f7);
      this.a.adjustCoordinate(paramFloat3);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.d
 * JD-Core Version:    0.6.2
 */