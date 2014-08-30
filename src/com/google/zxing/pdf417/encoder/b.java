package com.google.zxing.pdf417.encoder;

final class b
{
  private final byte[] a;
  private int b;

  b(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.a;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      arrayOfByte[paramInt] = ((byte)i);
      return;
    }
  }

  private byte[] a()
  {
    return this.a;
  }

  final void a(int paramInt, byte paramByte)
  {
    this.a[paramInt] = paramByte;
  }

  final void a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      int j = this.b;
      this.b = (j + 1);
      byte[] arrayOfByte = this.a;
      if (paramBoolean);
      for (int k = 1; ; k = 0)
      {
        arrayOfByte[j] = ((byte)k);
        i++;
        break;
      }
    }
  }

  final byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * this.a.length];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = this.a[(i / paramInt)];
    return arrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.b
 * JD-Core Version:    0.6.2
 */