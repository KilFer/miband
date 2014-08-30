package com.loopj.android.http;

final class i extends g
{
  private static int f = 19;
  private static final byte[] g = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] h = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  public final boolean c;
  public final boolean d;
  public final boolean e;
  private final byte[] i;
  private int j;
  private int k;
  private final byte[] l;

  public i(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = null;
    boolean bool2;
    boolean bool3;
    label35: label47: byte[] arrayOfByte;
    if ((paramInt & 0x1) == 0)
    {
      bool2 = bool1;
      this.c = bool2;
      if ((paramInt & 0x2) != 0)
        break label106;
      bool3 = bool1;
      this.d = bool3;
      if ((paramInt & 0x4) == 0)
        break label112;
      this.e = bool1;
      if ((paramInt & 0x8) != 0)
        break label117;
      arrayOfByte = g;
      label64: this.l = arrayOfByte;
      this.i = new byte[2];
      this.j = 0;
      if (!this.d)
        break label125;
    }
    label106: label112: label117: label125: for (int m = 19; ; m = -1)
    {
      this.k = m;
      return;
      bool2 = false;
      break;
      bool3 = false;
      break label35;
      bool1 = false;
      break label47;
      arrayOfByte = h;
      break label64;
    }
  }

  public final int a(int paramInt)
  {
    return 10 + (paramInt << 3) / 5;
  }

  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte1 = this.l;
    byte[] arrayOfByte2 = this.a;
    int m = this.k;
    int n = paramInt2 + paramInt1;
    int i4;
    int i2;
    label58: int i36;
    int i37;
    int i6;
    int i5;
    switch (this.j)
    {
    default:
      i4 = -1;
      i2 = paramInt1;
      if (i4 != -1)
      {
        arrayOfByte2[0] = arrayOfByte1[(0x3F & i4 >> 18)];
        arrayOfByte2[1] = arrayOfByte1[(0x3F & i4 >> 12)];
        arrayOfByte2[2] = arrayOfByte1[(0x3F & i4 >> 6)];
        i36 = 4;
        arrayOfByte2[3] = arrayOfByte1[(i4 & 0x3F)];
        i37 = m - 1;
        if (i37 == 0)
        {
          if (this.e)
          {
            i36 = 5;
            arrayOfByte2[4] = 13;
          }
          i6 = i36 + 1;
          arrayOfByte2[i36] = 10;
          i5 = 19;
        }
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      int i31;
      int i30;
      label218: int i26;
      if (i2 + 3 > n)
      {
        if (!paramBoolean)
          break label1054;
        if (i2 - this.j != n - 1)
          break label726;
        if (this.j <= 0)
          break label704;
        byte[] arrayOfByte8 = this.i;
        i31 = 1;
        i30 = arrayOfByte8[0];
        int i32 = (i30 & 0xFF) << 4;
        this.j -= i31;
        int i33 = i6 + 1;
        arrayOfByte2[i6] = arrayOfByte1[(0x3F & i32 >> 6)];
        i26 = i33 + 1;
        arrayOfByte2[i33] = arrayOfByte1[(i32 & 0x3F)];
        if (this.c)
        {
          int i35 = i26 + 1;
          arrayOfByte2[i26] = 61;
          i26 = i35 + 1;
          arrayOfByte2[i35] = 61;
        }
        if (!this.d)
          break label1185;
        if (this.e)
        {
          int i34 = i26 + 1;
          arrayOfByte2[i26] = 13;
          i26 = i34;
        }
        i6 = i26 + 1;
        arrayOfByte2[i26] = 10;
        if ((this.j == 0) && (i2 == n))
          break label1092;
        throw new AssertionError();
        i4 = -1;
        i2 = paramInt1;
        break label58;
        if (paramInt1 + 2 > n)
          break;
        int i38 = (0xFF & this.i[0]) << 16;
        int i39 = paramInt1 + 1;
        int i40 = i38 | (0xFF & paramArrayOfByte[paramInt1]) << 8;
        int i41 = i39 + 1;
        int i42 = i40 | 0xFF & paramArrayOfByte[i39];
        this.j = 0;
        i4 = i42;
        i2 = i41;
        break label58;
        if (paramInt1 + 1 > n)
          break;
        int i1 = (0xFF & this.i[0]) << 16 | (0xFF & this.i[1]) << 8;
        i2 = paramInt1 + 1;
        int i3 = i1 | 0xFF & paramArrayOfByte[paramInt1];
        this.j = 0;
        i4 = i3;
        break label58;
      }
      int i7 = (0xFF & paramArrayOfByte[i2]) << 16 | (0xFF & paramArrayOfByte[(i2 + 1)]) << 8 | 0xFF & paramArrayOfByte[(i2 + 2)];
      arrayOfByte2[i6] = arrayOfByte1[(0x3F & i7 >> 18)];
      arrayOfByte2[(i6 + 1)] = arrayOfByte1[(0x3F & i7 >> 12)];
      arrayOfByte2[(i6 + 2)] = arrayOfByte1[(0x3F & i7 >> 6)];
      arrayOfByte2[(i6 + 3)] = arrayOfByte1[(i7 & 0x3F)];
      int i8 = i2 + 3;
      int i9 = i6 + 4;
      int i10 = i5 - 1;
      if (i10 == 0)
      {
        int i11;
        if (this.e)
        {
          i11 = i9 + 1;
          arrayOfByte2[i9] = 13;
        }
        while (true)
        {
          i6 = i11 + 1;
          arrayOfByte2[i11] = 10;
          i2 = i8;
          i5 = 19;
          break;
          label704: int i29 = i2 + 1;
          i30 = paramArrayOfByte[i2];
          i2 = i29;
          i31 = 0;
          break label218;
          label726: int i18;
          int i17;
          label763: int i21;
          label804: int i25;
          if (i2 - this.j == n - 2)
            if (this.j > 1)
            {
              byte[] arrayOfByte7 = this.i;
              i18 = 1;
              i17 = arrayOfByte7[0];
              int i19 = (i17 & 0xFF) << 10;
              if (this.j <= 0)
                break label980;
              byte[] arrayOfByte6 = this.i;
              int i28 = i18 + 1;
              i21 = arrayOfByte6[i18];
              i18 = i28;
              int i22 = i19 | (i21 & 0xFF) << 2;
              this.j -= i18;
              int i23 = i6 + 1;
              arrayOfByte2[i6] = arrayOfByte1[(0x3F & i22 >> 12)];
              int i24 = i23 + 1;
              arrayOfByte2[i23] = arrayOfByte1[(0x3F & i22 >> 6)];
              i25 = i24 + 1;
              arrayOfByte2[i24] = arrayOfByte1[(i22 & 0x3F)];
              if (!this.c)
                break label1192;
              i26 = i25 + 1;
              arrayOfByte2[i25] = 61;
            }
          while (true)
          {
            if (this.d)
            {
              if (this.e)
              {
                int i27 = i26 + 1;
                arrayOfByte2[i26] = 13;
                i26 = i27;
              }
              i6 = i26 + 1;
              arrayOfByte2[i26] = 10;
              break;
              int i16 = i2 + 1;
              i17 = paramArrayOfByte[i2];
              i2 = i16;
              i18 = 0;
              break label763;
              label980: int i20 = i2 + 1;
              i21 = paramArrayOfByte[i2];
              i2 = i20;
              break label804;
              if ((!this.d) || (i6 <= 0) || (i5 == 19))
                break;
              int i15;
              if (this.e)
              {
                i15 = i6 + 1;
                arrayOfByte2[i6] = 13;
              }
              while (true)
              {
                i6 = i15 + 1;
                arrayOfByte2[i15] = 10;
                break;
                label1054: if (i2 == n - 1)
                {
                  byte[] arrayOfByte5 = this.i;
                  int i14 = this.j;
                  this.j = (i14 + 1);
                  arrayOfByte5[i14] = paramArrayOfByte[i2];
                }
                while (true)
                {
                  label1092: this.b = i6;
                  this.k = i5;
                  return true;
                  if (i2 == n - 2)
                  {
                    byte[] arrayOfByte3 = this.i;
                    int i12 = this.j;
                    this.j = (i12 + 1);
                    arrayOfByte3[i12] = paramArrayOfByte[i2];
                    byte[] arrayOfByte4 = this.i;
                    int i13 = this.j;
                    this.j = (i13 + 1);
                    arrayOfByte4[i13] = paramArrayOfByte[(i2 + 1)];
                  }
                }
                i15 = i6;
              }
            }
            label1185: i6 = i26;
            break;
            label1192: i26 = i25;
          }
          i11 = i9;
        }
      }
      i5 = i10;
      i6 = i9;
      i2 = i8;
      continue;
      i5 = i37;
      i6 = i36;
      continue;
      i5 = m;
      i6 = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.i
 * JD-Core Version:    0.6.2
 */