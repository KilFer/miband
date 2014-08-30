package com.google.zxing.qrcode.decoder;

final class k extends c
{
  private k()
  {
    super((byte)0);
  }

  final boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    return (0x1 & (i & 0x1) + i % 3) == 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.k
 * JD-Core Version:    0.6.2
 */