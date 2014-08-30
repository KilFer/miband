package com.edmodo.cropper.cropwindow.edge;

import android.graphics.Rect;
import android.view.View;
import com.edmodo.cropper.util.AspectRatioUtil;

public enum Edge
{
  public static final int MIN_CROP_LENGTH_PX = 60;
  private float a;

  static
  {
    RIGHT = new Edge("RIGHT", 2);
    BOTTOM = new Edge("BOTTOM", 3);
    Edge[] arrayOfEdge = new Edge[4];
    arrayOfEdge[0] = LEFT;
    arrayOfEdge[1] = TOP;
    arrayOfEdge[2] = RIGHT;
    arrayOfEdge[3] = BOTTOM;
  }

  private static float a(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    float f1 = (1.0F / 1.0F);
    if (paramFloat1 - paramRect.left < paramFloat2)
      return paramRect.left;
    if (paramFloat1 >= RIGHT.getCoordinate() - 60.0F);
    for (float f2 = RIGHT.getCoordinate() - 60.0F; ; f2 = f1)
    {
      if ((RIGHT.getCoordinate() - paramFloat1) / paramFloat3 <= 60.0F)
        f1 = RIGHT.getCoordinate() - 60.0F * paramFloat3;
      return Math.min(paramFloat1, Math.min(f2, f1));
    }
  }

  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Rect paramRect)
  {
    return (paramFloat1 < paramRect.top) || (paramFloat2 < paramRect.left) || (paramFloat3 > paramRect.bottom) || (paramFloat4 > paramRect.right);
  }

  private static float b(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    float f1 = (1.0F / -1.0F);
    if (paramRect.right - paramFloat1 < paramFloat2)
      return paramRect.right;
    if (paramFloat1 <= 60.0F + LEFT.getCoordinate());
    for (float f2 = 60.0F + LEFT.getCoordinate(); ; f2 = f1)
    {
      if ((paramFloat1 - LEFT.getCoordinate()) / paramFloat3 <= 60.0F)
        f1 = LEFT.getCoordinate() + 60.0F * paramFloat3;
      return Math.max(paramFloat1, Math.max(f2, f1));
    }
  }

  private static float c(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    float f1 = (1.0F / 1.0F);
    if (paramFloat1 - paramRect.top < paramFloat2)
      return paramRect.top;
    if (paramFloat1 >= BOTTOM.getCoordinate() - 60.0F);
    for (float f2 = BOTTOM.getCoordinate() - 60.0F; ; f2 = f1)
    {
      if (paramFloat3 * (BOTTOM.getCoordinate() - paramFloat1) <= 60.0F)
        f1 = BOTTOM.getCoordinate() - 60.0F / paramFloat3;
      return Math.min(paramFloat1, Math.min(f2, f1));
    }
  }

  private static float d(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    float f1 = (1.0F / -1.0F);
    if (paramRect.bottom - paramFloat1 < paramFloat2)
      return paramRect.bottom;
    if (paramFloat1 <= 60.0F + TOP.getCoordinate());
    for (float f2 = 60.0F + TOP.getCoordinate(); ; f2 = f1)
    {
      if (paramFloat3 * (paramFloat1 - TOP.getCoordinate()) <= 60.0F)
        f1 = TOP.getCoordinate() + 60.0F / paramFloat3;
      return Math.max(paramFloat1, Math.max(f1, f2));
    }
  }

  public static float getHeight()
  {
    return BOTTOM.getCoordinate() - TOP.getCoordinate();
  }

  public static float getWidth()
  {
    return RIGHT.getCoordinate() - LEFT.getCoordinate();
  }

  public final void adjustCoordinate(float paramFloat)
  {
    float f1 = LEFT.getCoordinate();
    float f2 = TOP.getCoordinate();
    float f3 = RIGHT.getCoordinate();
    float f4 = BOTTOM.getCoordinate();
    switch (a()[ordinal()])
    {
    default:
      return;
    case 1:
      this.a = AspectRatioUtil.calculateLeft(f2, f3, f4, paramFloat);
      return;
    case 2:
      this.a = AspectRatioUtil.calculateTop(f1, f3, f4, paramFloat);
      return;
    case 3:
      this.a = AspectRatioUtil.calculateRight(f1, f2, f4, paramFloat);
      return;
    case 4:
    }
    this.a = AspectRatioUtil.calculateBottom(f1, f2, f3, paramFloat);
  }

  public final void adjustCoordinate(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3, float paramFloat4)
  {
    float f1 = (1.0F / 1.0F);
    float f2 = (1.0F / -1.0F);
    float f10;
    switch (a()[ordinal()])
    {
    default:
      return;
    case 1:
      if (paramFloat1 - paramRect.left < paramFloat3)
      {
        f10 = paramRect.left;
        this.a = f10;
        return;
      }
      if (paramFloat1 < RIGHT.getCoordinate() - 60.0F)
        break;
    case 2:
    case 3:
    case 4:
    }
    for (float f9 = RIGHT.getCoordinate() - 60.0F; ; f9 = f1)
    {
      if ((RIGHT.getCoordinate() - paramFloat1) / paramFloat4 <= 60.0F)
        f1 = RIGHT.getCoordinate() - 60.0F * paramFloat4;
      f10 = Math.min(paramFloat1, Math.min(f9, f1));
      break;
      float f8;
      if (paramFloat2 - paramRect.top < paramFloat3)
      {
        f8 = paramRect.top;
        this.a = f8;
        return;
      }
      if (paramFloat2 >= BOTTOM.getCoordinate() - 60.0F);
      for (float f7 = BOTTOM.getCoordinate() - 60.0F; ; f7 = f1)
      {
        if (paramFloat4 * (BOTTOM.getCoordinate() - paramFloat2) <= 60.0F)
          f1 = BOTTOM.getCoordinate() - 60.0F / paramFloat4;
        f8 = Math.min(paramFloat2, Math.min(f7, f1));
        break;
        float f6;
        if (paramRect.right - paramFloat1 < paramFloat3)
        {
          f6 = paramRect.right;
          this.a = f6;
          return;
        }
        if (paramFloat1 <= 60.0F + LEFT.getCoordinate());
        for (float f5 = 60.0F + LEFT.getCoordinate(); ; f5 = f2)
        {
          if ((paramFloat1 - LEFT.getCoordinate()) / paramFloat4 <= 60.0F)
            f2 = LEFT.getCoordinate() + 60.0F * paramFloat4;
          f6 = Math.max(paramFloat1, Math.max(f5, f2));
          break;
          float f4;
          if (paramRect.bottom - paramFloat2 < paramFloat3)
          {
            f4 = paramRect.bottom;
            this.a = f4;
            return;
          }
          if (paramFloat2 <= 60.0F + TOP.getCoordinate());
          for (float f3 = 60.0F + TOP.getCoordinate(); ; f3 = f2)
          {
            if (paramFloat4 * (paramFloat2 - TOP.getCoordinate()) <= 60.0F)
              f2 = TOP.getCoordinate() + 60.0F / paramFloat4;
            f4 = Math.max(paramFloat2, Math.max(f2, f3));
            break;
          }
        }
      }
    }
  }

  public final float getCoordinate()
  {
    return this.a;
  }

  public final boolean isNewRectangleOutOfBounds(Edge paramEdge, Rect paramRect, float paramFloat)
  {
    float f1 = paramEdge.snapOffset(paramRect);
    switch (a()[ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (paramEdge.equals(TOP))
            {
              float f23 = paramRect.top;
              float f24 = BOTTOM.getCoordinate() - f1;
              float f25 = RIGHT.getCoordinate();
              return a(f23, AspectRatioUtil.calculateLeft(f23, f25, f24, paramFloat), f24, f25, paramRect);
            }
          }
          while (!paramEdge.equals(BOTTOM));
          float f20 = paramRect.bottom;
          float f21 = TOP.getCoordinate() - f1;
          float f22 = RIGHT.getCoordinate();
          return a(f21, AspectRatioUtil.calculateLeft(f21, f22, f20, paramFloat), f20, f22, paramRect);
          if (paramEdge.equals(LEFT))
          {
            float f17 = paramRect.left;
            float f18 = RIGHT.getCoordinate() - f1;
            float f19 = BOTTOM.getCoordinate();
            return a(AspectRatioUtil.calculateTop(f17, f18, f19, paramFloat), f17, f19, f18, paramRect);
          }
        }
        while (!paramEdge.equals(RIGHT));
        float f14 = paramRect.right;
        float f15 = LEFT.getCoordinate() - f1;
        float f16 = BOTTOM.getCoordinate();
        return a(AspectRatioUtil.calculateTop(f15, f14, f16, paramFloat), f15, f16, f14, paramRect);
        if (paramEdge.equals(TOP))
        {
          float f11 = paramRect.top;
          float f12 = BOTTOM.getCoordinate() - f1;
          float f13 = LEFT.getCoordinate();
          return a(f11, f13, f12, AspectRatioUtil.calculateRight(f13, f11, f12, paramFloat), paramRect);
        }
      }
      while (!paramEdge.equals(BOTTOM));
      float f8 = paramRect.bottom;
      float f9 = TOP.getCoordinate() - f1;
      float f10 = LEFT.getCoordinate();
      return a(f9, f10, f8, AspectRatioUtil.calculateRight(f10, f9, f8, paramFloat), paramRect);
      if (paramEdge.equals(LEFT))
      {
        float f5 = paramRect.left;
        float f6 = RIGHT.getCoordinate() - f1;
        float f7 = TOP.getCoordinate();
        return a(f7, f5, AspectRatioUtil.calculateBottom(f5, f7, f6, paramFloat), f6, paramRect);
      }
    }
    while (!paramEdge.equals(RIGHT));
    float f2 = paramRect.right;
    float f3 = LEFT.getCoordinate() - f1;
    float f4 = TOP.getCoordinate();
    return a(f4, f3, AspectRatioUtil.calculateBottom(f3, f4, f2, paramFloat), f2, paramRect);
  }

  public final boolean isOutsideFrame(Rect paramRect)
  {
    boolean bool = true;
    switch (a()[ordinal()])
    {
    default:
      bool = false;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
        {
          do
            return bool;
          while (this.a - paramRect.left < 0.0D);
          return false;
        }
        while (this.a - paramRect.top < 0.0D);
        return false;
      }
      while (paramRect.right - this.a < 0.0D);
      return false;
    }
    while (paramRect.bottom - this.a < 0.0D);
    return false;
  }

  public final boolean isOutsideMargin(Rect paramRect, float paramFloat)
  {
    boolean bool = true;
    switch (a()[ordinal()])
    {
    default:
      bool = false;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
        {
          do
            return bool;
          while (this.a - paramRect.left < paramFloat);
          return false;
        }
        while (this.a - paramRect.top < paramFloat);
        return false;
      }
      while (paramRect.right - this.a < paramFloat);
      return false;
    }
    while (paramRect.bottom - this.a < paramFloat);
    return false;
  }

  public final void offset(float paramFloat)
  {
    this.a = (paramFloat + this.a);
  }

  public final void setCoordinate(float paramFloat)
  {
    this.a = paramFloat;
  }

  public final float snapOffset(Rect paramRect)
  {
    float f1 = this.a;
    float f2;
    switch (a()[ordinal()])
    {
    default:
      f2 = f1;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return f2 - f1;
      f2 = paramRect.left;
      continue;
      f2 = paramRect.top;
      continue;
      f2 = paramRect.right;
      continue;
      f2 = paramRect.bottom;
    }
  }

  public final float snapToRect(Rect paramRect)
  {
    float f = this.a;
    switch (a()[ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return this.a - f;
      this.a = paramRect.left;
      continue;
      this.a = paramRect.top;
      continue;
      this.a = paramRect.right;
      continue;
      this.a = paramRect.bottom;
    }
  }

  public final void snapToView(View paramView)
  {
    switch (a()[ordinal()])
    {
    default:
      return;
    case 1:
      this.a = 0.0F;
      return;
    case 2:
      this.a = 0.0F;
      return;
    case 3:
      this.a = paramView.getWidth();
      return;
    case 4:
    }
    this.a = paramView.getHeight();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.cropwindow.edge.Edge
 * JD-Core Version:    0.6.2
 */