package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

public final class QRCode
{
  public static final int NUM_MASK_PATTERNS = 8;
  private Mode a = null;
  private ErrorCorrectionLevel b = null;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private ByteMatrix j = null;

  public static boolean isValidMaskPattern(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }

  public final int at(int paramInt1, int paramInt2)
  {
    int k = this.j.get(paramInt1, paramInt2);
    if ((k != 0) && (k != 1))
      throw new IllegalStateException("Bad value");
    return k;
  }

  public final ErrorCorrectionLevel getECLevel()
  {
    return this.b;
  }

  public final int getMaskPattern()
  {
    return this.e;
  }

  public final ByteMatrix getMatrix()
  {
    return this.j;
  }

  public final int getMatrixWidth()
  {
    return this.d;
  }

  public final Mode getMode()
  {
    return this.a;
  }

  public final int getNumDataBytes()
  {
    return this.g;
  }

  public final int getNumECBytes()
  {
    return this.h;
  }

  public final int getNumRSBlocks()
  {
    return this.i;
  }

  public final int getNumTotalBytes()
  {
    return this.f;
  }

  public final int getVersion()
  {
    return this.c;
  }

  public final boolean isValid()
  {
    return (this.a != null) && (this.b != null) && (this.c != -1) && (this.d != -1) && (this.e != -1) && (this.f != -1) && (this.g != -1) && (this.h != -1) && (this.i != -1) && (isValidMaskPattern(this.e)) && (this.f == this.g + this.h) && (this.j != null) && (this.d == this.j.getWidth()) && (this.j.getWidth() == this.j.getHeight());
  }

  public final void setECLevel(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    this.b = paramErrorCorrectionLevel;
  }

  public final void setMaskPattern(int paramInt)
  {
    this.e = paramInt;
  }

  public final void setMatrix(ByteMatrix paramByteMatrix)
  {
    this.j = paramByteMatrix;
  }

  public final void setMatrixWidth(int paramInt)
  {
    this.d = paramInt;
  }

  public final void setMode(Mode paramMode)
  {
    this.a = paramMode;
  }

  public final void setNumDataBytes(int paramInt)
  {
    this.g = paramInt;
  }

  public final void setNumECBytes(int paramInt)
  {
    this.h = paramInt;
  }

  public final void setNumRSBlocks(int paramInt)
  {
    this.i = paramInt;
  }

  public final void setNumTotalBytes(int paramInt)
  {
    this.f = paramInt;
  }

  public final void setVersion(int paramInt)
  {
    this.c = paramInt;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n matrixWidth: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n numTotalBytes: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n numDataBytes: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n numECBytes: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n numRSBlocks: ");
    localStringBuilder.append(this.i);
    if (this.j == null)
      localStringBuilder.append("\n matrix: null\n");
    while (true)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.j.toString());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.QRCode
 * JD-Core Version:    0.6.2
 */