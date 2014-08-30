package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

final class a extends c
{
  a()
  {
    super(null, null);
  }

  final void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4)
  {
    a(paramFloat1, paramFloat2, paramRect, paramFloat4);
  }

  final void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    float f1 = Edge.LEFT.getCoordinate();
    float f2 = Edge.TOP.getCoordinate();
    float f3 = Edge.RIGHT.getCoordinate();
    float f4 = Edge.BOTTOM.getCoordinate();
    float f5 = (f1 + f3) / 2.0F;
    float f6 = (f2 + f4) / 2.0F;
    float f7 = paramFloat1 - f5;
    float f8 = paramFloat2 - f6;
    Edge.LEFT.offset(f7);
    Edge.TOP.offset(f8);
    Edge.RIGHT.offset(f7);
    Edge.BOTTOM.offset(f8);
    if (Edge.LEFT.isOutsideMargin(paramRect, paramFloat3))
    {
      float f12 = Edge.LEFT.snapToRect(paramRect);
      Edge.RIGHT.offset(f12);
    }
    do
      while (Edge.TOP.isOutsideMargin(paramRect, paramFloat3))
      {
        float f11 = Edge.TOP.snapToRect(paramRect);
        Edge.BOTTOM.offset(f11);
        return;
        if (Edge.RIGHT.isOutsideMargin(paramRect, paramFloat3))
        {
          float f9 = Edge.RIGHT.snapToRect(paramRect);
          Edge.LEFT.offset(f9);
        }
      }
    while (!Edge.BOTTOM.isOutsideMargin(paramRect, paramFloat3));
    float f10 = Edge.BOTTOM.snapToRect(paramRect);
    Edge.TOP.offset(f10);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.a
 * JD-Core Version:    0.6.2
 */