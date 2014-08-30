package com.google.zxing.qrcode.decoder;

public final class Version$ECBlocks
{
  private final int a;
  private final Version.ECB[] b;

  Version$ECBlocks(int paramInt, Version.ECB[] paramArrayOfECB)
  {
    this.a = paramInt;
    this.b = paramArrayOfECB;
  }

  public final Version.ECB[] getECBlocks()
  {
    return this.b;
  }

  public final int getECCodewordsPerBlock()
  {
    return this.a;
  }

  public final int getNumBlocks()
  {
    int i = 0;
    Version.ECB[] arrayOfECB = this.b;
    int j = arrayOfECB.length;
    int k = 0;
    while (i < j)
    {
      k += arrayOfECB[i].getCount();
      i++;
    }
    return k;
  }

  public final int getTotalECCodewords()
  {
    return this.a * getNumBlocks();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version.ECBlocks
 * JD-Core Version:    0.6.2
 */