package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.edge.EdgePair;
import com.edmodo.cropper.util.AspectRatioUtil;

abstract class c
{
  private static final float a = 1.0F;
  private Edge b;
  private Edge c;
  private EdgePair d;

  c(Edge paramEdge1, Edge paramEdge2)
  {
    this.b = paramEdge1;
    this.c = paramEdge2;
    this.d = new EdgePair(this.b, this.c);
  }

  private float a(float paramFloat1, float paramFloat2)
  {
    float f1;
    float f2;
    if (this.c == Edge.LEFT)
    {
      f1 = paramFloat1;
      if (this.b != Edge.TOP)
        break label64;
      f2 = paramFloat2;
      label25: if (this.c != Edge.RIGHT)
        break label75;
      label35: if (this.b != Edge.BOTTOM)
        break label85;
    }
    while (true)
    {
      return AspectRatioUtil.calculateAspectRatio(f1, f2, paramFloat1, paramFloat2);
      f1 = Edge.LEFT.getCoordinate();
      break;
      label64: f2 = Edge.TOP.getCoordinate();
      break label25;
      label75: paramFloat1 = Edge.RIGHT.getCoordinate();
      break label35;
      label85: paramFloat2 = Edge.BOTTOM.getCoordinate();
    }
  }

  private EdgePair a()
  {
    return this.d;
  }

  final EdgePair a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1;
    float f2;
    if (this.c == Edge.LEFT)
    {
      f1 = paramFloat1;
      if (this.b != Edge.TOP)
        break label98;
      f2 = paramFloat2;
      label26: if (this.c != Edge.RIGHT)
        break label109;
      label36: if (this.b != Edge.BOTTOM)
        break label119;
      label46: if (AspectRatioUtil.calculateAspectRatio(f1, f2, paramFloat1, paramFloat2) <= paramFloat3)
        break label129;
      this.d.primary = this.c;
    }
    for (this.d.secondary = this.b; ; this.d.secondary = this.c)
    {
      return this.d;
      f1 = Edge.LEFT.getCoordinate();
      break;
      label98: f2 = Edge.TOP.getCoordinate();
      break label26;
      label109: paramFloat1 = Edge.RIGHT.getCoordinate();
      break label36;
      label119: paramFloat2 = Edge.BOTTOM.getCoordinate();
      break label46;
      label129: this.d.primary = this.b;
    }
  }

  abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4);

  void a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    EdgePair localEdgePair = this.d;
    Edge localEdge1 = localEdgePair.primary;
    Edge localEdge2 = localEdgePair.secondary;
    if (localEdge1 != null)
      localEdge1.adjustCoordinate(paramFloat1, paramFloat2, paramRect, paramFloat3, 1.0F);
    if (localEdge2 != null)
      localEdge2.adjustCoordinate(paramFloat1, paramFloat2, paramRect, paramFloat3, 1.0F);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.c
 * JD-Core Version:    0.6.2
 */