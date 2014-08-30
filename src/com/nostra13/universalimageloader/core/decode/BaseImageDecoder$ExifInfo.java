package com.nostra13.universalimageloader.core.decode;

public class BaseImageDecoder$ExifInfo
{
  public final boolean flipHorizontal;
  public final int rotation;

  protected BaseImageDecoder$ExifInfo()
  {
    this.rotation = 0;
    this.flipHorizontal = false;
  }

  protected BaseImageDecoder$ExifInfo(int paramInt, boolean paramBoolean)
  {
    this.rotation = paramInt;
    this.flipHorizontal = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.BaseImageDecoder.ExifInfo
 * JD-Core Version:    0.6.2
 */