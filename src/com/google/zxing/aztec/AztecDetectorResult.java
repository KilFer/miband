package com.google.zxing.aztec;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;

public final class AztecDetectorResult extends DetectorResult
{
  private final boolean a;
  private final int b;
  private final int c;

  public AztecDetectorResult(BitMatrix paramBitMatrix, ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBitMatrix, paramArrayOfResultPoint);
    this.a = paramBoolean;
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public final int getNbDatablocks()
  {
    return this.b;
  }

  public final int getNbLayers()
  {
    return this.c;
  }

  public final boolean isCompact()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.AztecDetectorResult
 * JD-Core Version:    0.6.2
 */