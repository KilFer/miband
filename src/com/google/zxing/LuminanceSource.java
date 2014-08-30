package com.google.zxing;

public abstract class LuminanceSource
{
  private final int a;
  private final int b;

  protected LuminanceSource(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }

  public final int getHeight()
  {
    return this.b;
  }

  public abstract byte[] getMatrix();

  public abstract byte[] getRow(int paramInt, byte[] paramArrayOfByte);

  public final int getWidth()
  {
    return this.a;
  }

  public boolean isCropSupported()
  {
    return false;
  }

  public boolean isRotateSupported()
  {
    return false;
  }

  public LuminanceSource rotateCounterClockwise()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation.");
  }

  public String toString()
  {
    byte[] arrayOfByte1 = new byte[this.a];
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    byte[] arrayOfByte2 = arrayOfByte1;
    for (int i = 0; i < this.b; i++)
    {
      arrayOfByte2 = getRow(i, arrayOfByte2);
      int j = 0;
      if (j < this.a)
      {
        int k = 0xFF & arrayOfByte2[j];
        char c;
        if (k < 64)
          c = '#';
        while (true)
        {
          localStringBuilder.append(c);
          j++;
          break;
          if (k < 128)
            c = '+';
          else if (k < 192)
            c = '.';
          else
            c = ' ';
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.LuminanceSource
 * JD-Core Version:    0.6.2
 */