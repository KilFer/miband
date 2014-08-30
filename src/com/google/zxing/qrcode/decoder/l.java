package com.google.zxing.qrcode.decoder;

final class l extends c
{
  private l()
  {
    super((byte)0);
  }

  final boolean a(int paramInt1, int paramInt2)
  {
    return (0x1 & (0x1 & paramInt1 + paramInt2) + paramInt1 * paramInt2 % 3) == 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.l
 * JD-Core Version:    0.6.2
 */