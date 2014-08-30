package com.nostra13.universalimageloader.core.assist;

public class ImageSize
{
  private static final int a = 9;
  private static final String b = "x";
  private final int c;
  private final int d;

  public ImageSize(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public ImageSize(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % 180 == 0)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    }
    this.c = paramInt2;
    this.d = paramInt1;
  }

  public int getHeight()
  {
    return this.d;
  }

  public int getWidth()
  {
    return this.c;
  }

  public ImageSize scale(float paramFloat)
  {
    return new ImageSize((int)(paramFloat * this.c), (int)(paramFloat * this.d));
  }

  public ImageSize scaleDown(int paramInt)
  {
    return new ImageSize(this.c / paramInt, this.d / paramInt);
  }

  public String toString()
  {
    return 9 + this.c + "x" + this.d;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageSize
 * JD-Core Version:    0.6.2
 */