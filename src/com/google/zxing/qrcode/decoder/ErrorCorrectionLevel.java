package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel
{
  private static final ErrorCorrectionLevel[] a = arrayOfErrorCorrectionLevel2;
  private final int b;

  static
  {
    H = new ErrorCorrectionLevel("H", 3, 2);
    ErrorCorrectionLevel[] arrayOfErrorCorrectionLevel1 = new ErrorCorrectionLevel[4];
    arrayOfErrorCorrectionLevel1[0] = L;
    arrayOfErrorCorrectionLevel1[1] = M;
    arrayOfErrorCorrectionLevel1[2] = Q;
    arrayOfErrorCorrectionLevel1[3] = H;
    c = arrayOfErrorCorrectionLevel1;
    ErrorCorrectionLevel[] arrayOfErrorCorrectionLevel2 = new ErrorCorrectionLevel[4];
    arrayOfErrorCorrectionLevel2[0] = M;
    arrayOfErrorCorrectionLevel2[1] = L;
    arrayOfErrorCorrectionLevel2[2] = H;
    arrayOfErrorCorrectionLevel2[3] = Q;
  }

  private ErrorCorrectionLevel(int paramInt)
  {
    this.b = paramInt;
  }

  public static ErrorCorrectionLevel forBits(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a.length))
      throw new IllegalArgumentException();
    return a[paramInt];
  }

  public final int getBits()
  {
    return this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
 * JD-Core Version:    0.6.2
 */