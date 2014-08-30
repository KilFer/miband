package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;

final class b extends c
{
  b(Edge paramEdge1, Edge paramEdge2)
  {
    super(paramEdge1, paramEdge2);
  }

  final void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4)
  {
    EdgePair localEdgePair = a(paramFloat1, paramFloat2, paramFloat3);
    Edge localEdge1 = localEdgePair.primary;
    Edge localEdge2 = localEdgePair.secondary;
    localEdge1.adjustCoordinate(paramFloat1, paramFloat2, paramRect, paramFloat4, paramFloat3);
    localEdge2.adjustCoordinate(paramFloat3);
    if (localEdge2.isOutsideMargin(paramRect, paramFloat4))
    {
      localEdge2.snapToRect(paramRect);
      localEdge1.adjustCoordinate(paramFloat3);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.b
 * JD-Core Version:    0.6.2
 */