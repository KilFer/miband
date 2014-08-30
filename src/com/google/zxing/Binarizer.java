package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource a;

  protected Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.a = paramLuminanceSource;
  }

  public abstract Binarizer createBinarizer(LuminanceSource paramLuminanceSource);

  public abstract BitMatrix getBlackMatrix();

  public abstract BitArray getBlackRow(int paramInt, BitArray paramBitArray);

  public int getHeight()
  {
    return this.a.getHeight();
  }

  public LuminanceSource getLuminanceSource()
  {
    return this.a;
  }

  public int getWidth()
  {
    return this.a.getWidth();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.Binarizer
 * JD-Core Version:    0.6.2
 */