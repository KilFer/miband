package com.edmodo.cropper.cropwindow.handle;

import android.graphics.Rect;
import com.edmodo.cropper.cropwindow.edge.Edge;

public enum Handle
{
  private c a;

  static
  {
    BOTTOM_LEFT = new Handle("BOTTOM_LEFT", 2, new b(Edge.BOTTOM, Edge.LEFT));
    BOTTOM_RIGHT = new Handle("BOTTOM_RIGHT", 3, new b(Edge.BOTTOM, Edge.RIGHT));
    LEFT = new Handle("LEFT", 4, new e(Edge.LEFT));
    TOP = new Handle("TOP", 5, new d(Edge.TOP));
    RIGHT = new Handle("RIGHT", 6, new e(Edge.RIGHT));
    BOTTOM = new Handle("BOTTOM", 7, new d(Edge.BOTTOM));
    CENTER = new Handle("CENTER", 8, new a());
    Handle[] arrayOfHandle = new Handle[9];
    arrayOfHandle[0] = TOP_LEFT;
    arrayOfHandle[1] = TOP_RIGHT;
    arrayOfHandle[2] = BOTTOM_LEFT;
    arrayOfHandle[3] = BOTTOM_RIGHT;
    arrayOfHandle[4] = LEFT;
    arrayOfHandle[5] = TOP;
    arrayOfHandle[6] = RIGHT;
    arrayOfHandle[7] = BOTTOM;
    arrayOfHandle[8] = CENTER;
  }

  private Handle(c arg3)
  {
    Object localObject;
    this.a = localObject;
  }

  public final void updateCropWindow(float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, float paramFloat4)
  {
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramRect, paramFloat4);
  }

  public final void updateCropWindow(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    this.a.a(paramFloat1, paramFloat2, paramRect, paramFloat3);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.handle.Handle
 * JD-Core Version:    0.6.2
 */