package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Decoder
{
  private static final int[] a = { 0, 104, 240, 408, 608 };
  private static final int[] b = { 0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968 };
  private static final int[] c = { 0, 17, 40, 51, 76 };
  private static final int[] d = { 0, 21, 48, 60, 88, 120, 156, 196, 240, 230, 272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664 };
  private static final String[] e = { "CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
  private static final String[] f = { "CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS" };
  private static final String[] g = { "CTRL_PS", " ", "\001", "\002", "\003", "\004", "\005", "\006", "\007", "\b", "\t", "\n", "\013", "\f", "\r", "\033", "\034", "\035", "\036", "\037", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS" };
  private static final String[] h = { "", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL" };
  private static final String[] i = { "CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US" };
  private int j;
  private int k;
  private AztecDetectorResult l;
  private int m;

  private static int a(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    int n = 0;
    for (int i1 = paramInt1; i1 < paramInt1 + paramInt2; i1++)
    {
      n <<= 1;
      if (paramArrayOfBoolean[i1] != 0)
        n++;
    }
    return n;
  }

  private static b a(char paramChar)
  {
    switch (paramChar)
    {
    default:
      return b.a;
    case 'L':
      return b.b;
    case 'P':
      return b.e;
    case 'M':
      return b.c;
    case 'D':
      return b.d;
    case 'B':
    }
    return b.f;
  }

  private static String a(b paramb, int paramInt)
  {
    switch (a.a[paramb.ordinal()])
    {
    default:
      return "";
    case 2:
      return e[paramInt];
    case 3:
      return f[paramInt];
    case 4:
      return g[paramInt];
    case 5:
      return h[paramInt];
    case 6:
    }
    return i[paramInt];
  }

  private String a(boolean[] paramArrayOfBoolean)
  {
    int n = this.k * this.l.getNbDatablocks() - this.m;
    if (n > paramArrayOfBoolean.length)
      throw FormatException.getFormatInstance();
    Object localObject1 = b.a;
    Object localObject2 = b.a;
    int i1 = 0;
    StringBuilder localStringBuilder = new StringBuilder(20);
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    while (true)
    {
      label73: int i9;
      Object localObject3;
      int i10;
      int i8;
      if (i4 == 0)
      {
        int i11;
        if (i2 != 0)
        {
          i3 = 1;
          switch (a.a[localObject2.ordinal()])
          {
          default:
            i11 = 5;
            if (localObject2 == b.d)
              i11 = 4;
            if (n - i1 < i11)
            {
              i9 = 1;
              localObject3 = localObject2;
              i10 = i2;
              i8 = i1;
            }
            break;
          case 1:
          }
        }
        while (true)
        {
          if (i3 == 0)
            break label543;
          i4 = i9;
          i1 = i8;
          localObject2 = localObject1;
          i3 = 0;
          i2 = 0;
          break;
          localObject1 = localObject2;
          break label73;
          if (n - i1 < 8)
          {
            i9 = 1;
            localObject3 = localObject2;
            i10 = i2;
            i8 = i1;
          }
          else
          {
            int i5 = a(paramArrayOfBoolean, i1, 8);
            int i6 = i1 + 8;
            localStringBuilder.append((char)i5);
            int i7 = i2;
            i8 = i6;
            i9 = i4;
            localObject3 = localObject2;
            i10 = i7;
            continue;
            int i12 = a(paramArrayOfBoolean, i1, i11);
            int i13 = i1 + i11;
            String str;
            switch (a.a[localObject2.ordinal()])
            {
            default:
              str = "";
              if (str.startsWith("CTRL_"))
                switch (str.charAt(5))
                {
                default:
                  localObject2 = b.a;
                case 'L':
                case 'P':
                case 'M':
                case 'D':
                case 'B':
                }
              break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
              while (true)
              {
                label308: if (str.charAt(6) != 'S')
                  break label518;
                i8 = i13;
                int i14 = i4;
                localObject3 = localObject2;
                i10 = 1;
                i9 = i14;
                break;
                str = e[i12];
                break label308;
                str = f[i12];
                break label308;
                str = g[i12];
                break label308;
                str = h[i12];
                break label308;
                str = i[i12];
                break label308;
                localObject2 = b.b;
                continue;
                localObject2 = b.e;
                continue;
                localObject2 = b.c;
                continue;
                localObject2 = b.d;
                continue;
                localObject2 = b.f;
              }
            }
            localStringBuilder.append(str);
            label518: i9 = i4;
            localObject3 = localObject2;
            i10 = i2;
            i8 = i13;
          }
        }
      }
      return localStringBuilder.toString();
      label543: i1 = i8;
      i2 = i10;
      localObject2 = localObject3;
      i4 = i9;
    }
  }

  private boolean[] a(BitMatrix paramBitMatrix)
  {
    boolean[] arrayOfBoolean;
    int i2;
    int i3;
    int i4;
    int i5;
    if (this.l.isCompact())
    {
      if (this.l.getNbLayers() > a.length)
        throw FormatException.getFormatInstance();
      arrayOfBoolean = new boolean[a[this.l.getNbLayers()]];
      this.j = c[this.l.getNbLayers()];
      int n = this.l.getNbLayers();
      int i1 = paramBitMatrix.getHeight();
      i2 = 0;
      i3 = 0;
      i4 = i1;
      i5 = n;
    }
    while (true)
    {
      if (i5 == 0)
        break label390;
      int i6 = 0;
      int i7 = 0;
      while (true)
        if (i6 < -4 + i4 * 2)
        {
          arrayOfBoolean[(i3 + i6)] = paramBitMatrix.get(i2 + i7, i2 + i6 / 2);
          arrayOfBoolean[(i6 + (-4 + (i3 + i4 * 2)))] = paramBitMatrix.get(i2 + i6 / 2, -1 + (i2 + i4) - i7);
          i7 = (i7 + 1) % 2;
          i6++;
          continue;
          if (this.l.getNbLayers() > b.length)
            throw FormatException.getFormatInstance();
          arrayOfBoolean = new boolean[b[this.l.getNbLayers()]];
          this.j = d[this.l.getNbLayers()];
          break;
        }
      int i8 = 1 + i4 * 2;
      int i9 = 0;
      while (i8 > 5)
      {
        arrayOfBoolean[(1 + (-8 + (i3 + i4 * 4) + (i4 * 2 - i8)))] = paramBitMatrix.get(-1 + (i2 + i4) - i9, -1 + (i2 + i8 / 2));
        arrayOfBoolean[(1 + (-12 + (i3 + i4 * 6) + (i4 * 2 - i8)))] = paramBitMatrix.get(-1 + (i2 + i8 / 2), i2 + i9);
        i9 = (i9 + 1) % 2;
        i8--;
      }
      int i10 = i2 + 2;
      int i11 = i3 + (-16 + i4 * 8);
      int i12 = i5 - 1;
      i4 -= 4;
      i5 = i12;
      i2 = i10;
      i3 = i11;
    }
    label390: return arrayOfBoolean;
  }

  private static BitMatrix b(BitMatrix paramBitMatrix)
  {
    int n = 1 + 2 * ((-1 + paramBitMatrix.getWidth()) / 2 / 16);
    BitMatrix localBitMatrix = new BitMatrix(paramBitMatrix.getWidth() - n, paramBitMatrix.getHeight() - n);
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramBitMatrix.getWidth())
    {
      if ((paramBitMatrix.getWidth() / 2 - i1) % 16 != 0)
      {
        int i3 = 0;
        int i4 = 0;
        while (i3 < paramBitMatrix.getHeight())
        {
          if ((paramBitMatrix.getWidth() / 2 - i3) % 16 != 0)
          {
            if (paramBitMatrix.get(i1, i3))
              localBitMatrix.set(i2, i4);
            i4++;
          }
          i3++;
        }
        i2++;
      }
      i1++;
    }
    return localBitMatrix;
  }

  private boolean[] b(boolean[] paramArrayOfBoolean)
  {
    GenericGF localGenericGF;
    int n;
    int i1;
    int i2;
    label77: int[] arrayOfInt;
    if (this.l.getNbLayers() <= 2)
    {
      this.k = 6;
      localGenericGF = GenericGF.AZTEC_DATA_6;
      n = this.l.getNbDatablocks();
      if (!this.l.isCompact())
        break label223;
      i1 = a[this.l.getNbLayers()] - this.j * this.k;
      i2 = c[this.l.getNbLayers()] - n;
      arrayOfInt = new int[this.j];
    }
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= this.j)
        break label270;
      int i13 = 1;
      int i14 = 1;
      while (true)
        if (i13 <= this.k)
        {
          if (paramArrayOfBoolean[(i1 + (i3 * this.k + this.k - i13))] != 0)
            arrayOfInt[i3] = (i14 + arrayOfInt[i3]);
          i14 <<= 1;
          i13++;
          continue;
          if (this.l.getNbLayers() <= 8)
          {
            this.k = 8;
            localGenericGF = GenericGF.AZTEC_DATA_8;
            break;
          }
          if (this.l.getNbLayers() <= 22)
          {
            this.k = 10;
            localGenericGF = GenericGF.AZTEC_DATA_10;
            break;
          }
          this.k = 12;
          localGenericGF = GenericGF.AZTEC_DATA_12;
          break;
          label223: i1 = b[this.l.getNbLayers()] - this.j * this.k;
          i2 = d[this.l.getNbLayers()] - n;
          break label77;
        }
    }
    label270: boolean[] arrayOfBoolean;
    while (true)
    {
      int i4;
      int i7;
      int i8;
      int i10;
      try
      {
        new ReedSolomonDecoder(localGenericGF).decode(arrayOfInt, i2);
        this.m = 0;
        arrayOfBoolean = new boolean[n * this.k];
        i4 = 0;
        i5 = 0;
        if (i4 >= n)
          break;
        int i6 = 1 << -1 + this.k;
        i7 = 0;
        i8 = i6;
        i9 = 0;
        i10 = i5;
        i11 = 0;
        if (i7 >= this.k)
          break label470;
        if ((i8 & arrayOfInt[i4]) == i8)
        {
          i12 = 1;
          if (i9 != -1 + this.k)
            break label429;
          if (i12 != i11)
            break label398;
          throw FormatException.getFormatInstance();
        }
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw FormatException.getFormatInstance();
      }
      int i12 = 0;
      continue;
      label398: i10++;
      this.m = (1 + this.m);
      int i11 = 0;
      int i9 = 0;
      i8 >>>= 1;
      i7++;
      continue;
      label429: if (i11 == i12)
        i9++;
      while (true)
      {
        arrayOfBoolean[(i7 + i4 * this.k - i10)] = i12;
        break;
        i11 = i12;
        i9 = 1;
      }
      label470: i4++;
      int i5 = i10;
    }
    return arrayOfBoolean;
  }

  public final DecoderResult decode(AztecDetectorResult paramAztecDetectorResult)
  {
    this.l = paramAztecDetectorResult;
    Object localObject1 = paramAztecDetectorResult.getBits();
    if (!this.l.isCompact())
    {
      BitMatrix localBitMatrix1 = this.l.getBits();
      int i21 = 1 + 2 * ((-1 + localBitMatrix1.getWidth()) / 2 / 16);
      BitMatrix localBitMatrix2 = new BitMatrix(localBitMatrix1.getWidth() - i21, localBitMatrix1.getHeight() - i21);
      int i22 = 0;
      for (int i23 = 0; i23 < localBitMatrix1.getWidth(); i23++)
        if ((localBitMatrix1.getWidth() / 2 - i23) % 16 != 0)
        {
          int i24 = 0;
          for (int i25 = 0; i25 < localBitMatrix1.getHeight(); i25++)
            if ((localBitMatrix1.getWidth() / 2 - i25) % 16 != 0)
            {
              if (localBitMatrix1.get(i23, i25))
                localBitMatrix2.set(i22, i24);
              i24++;
            }
          i22++;
        }
      localObject1 = localBitMatrix2;
    }
    boolean[] arrayOfBoolean1;
    int n;
    int i1;
    int i2;
    int i3;
    if (this.l.isCompact())
    {
      if (this.l.getNbLayers() > a.length)
        throw FormatException.getFormatInstance();
      arrayOfBoolean1 = new boolean[a[this.l.getNbLayers()]];
      this.j = c[this.l.getNbLayers()];
      n = this.l.getNbLayers();
      i1 = ((BitMatrix)localObject1).getHeight();
      i2 = 0;
      i3 = 0;
    }
    while (true)
    {
      if (n == 0)
        break label544;
      int i17 = 0;
      int i18 = 0;
      while (true)
        if (i18 < -4 + i1 * 2)
        {
          arrayOfBoolean1[(i2 + i18)] = ((BitMatrix)localObject1).get(i3 + i17, i3 + i18 / 2);
          arrayOfBoolean1[(i18 + (-4 + (i2 + i1 * 2)))] = ((BitMatrix)localObject1).get(i3 + i18 / 2, -1 + (i3 + i1) - i17);
          i17 = (i17 + 1) % 2;
          i18++;
          continue;
          if (this.l.getNbLayers() > b.length)
            throw FormatException.getFormatInstance();
          arrayOfBoolean1 = new boolean[b[this.l.getNbLayers()]];
          this.j = d[this.l.getNbLayers()];
          break;
        }
      int i19 = 0;
      for (int i20 = 1 + i1 * 2; i20 > 5; i20--)
      {
        arrayOfBoolean1[(1 + (-8 + (i2 + i1 * 4) + (i1 * 2 - i20)))] = ((BitMatrix)localObject1).get(-1 + (i3 + i1) - i19, -1 + (i3 + i20 / 2));
        arrayOfBoolean1[(1 + (-12 + (i2 + i1 * 6) + (i1 * 2 - i20)))] = ((BitMatrix)localObject1).get(-1 + (i3 + i20 / 2), i3 + i19);
        i19 = (i19 + 1) % 2;
      }
      i3 += 2;
      i2 += -16 + i1 * 8;
      n--;
      i1 -= 4;
    }
    label544: boolean[] arrayOfBoolean2 = b(arrayOfBoolean1);
    int i4 = this.k * this.l.getNbDatablocks() - this.m;
    if (i4 > arrayOfBoolean2.length)
      throw FormatException.getFormatInstance();
    Object localObject2 = b.a;
    Object localObject3 = b.a;
    int i5 = 0;
    StringBuilder localStringBuilder = new StringBuilder(20);
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    while (true)
    {
      label628: int i10;
      Object localObject5;
      int i11;
      if (i8 == 0)
      {
        int i13;
        if (i6 != 0)
        {
          i7 = 1;
          switch (a.a[localObject3.ordinal()])
          {
          default:
            i13 = 5;
            if (localObject3 == b.d)
              i13 = 4;
            if (i4 - i5 < i13)
            {
              i10 = 1;
              int i16 = i6;
              localObject5 = localObject3;
              i11 = i16;
            }
            break;
          case 1:
          }
        }
        while (true)
        {
          if (i7 == 0)
            break label1105;
          localObject3 = localObject2;
          i8 = i10;
          i7 = 0;
          i6 = 0;
          break;
          localObject2 = localObject3;
          break label628;
          if (i4 - i5 < 8)
          {
            i10 = 1;
            int i12 = i6;
            localObject5 = localObject3;
            i11 = i12;
          }
          else
          {
            int i9 = a(arrayOfBoolean2, i5, 8);
            i5 += 8;
            localStringBuilder.append((char)i9);
            i10 = i8;
            Object localObject4 = localObject3;
            i11 = i6;
            localObject5 = localObject4;
            continue;
            int i14 = a(arrayOfBoolean2, i5, i13);
            int i15 = i13 + i5;
            String str;
            switch (a.a[localObject3.ordinal()])
            {
            default:
              str = "";
              if (str.startsWith("CTRL_"))
                switch (str.charAt(5))
                {
                default:
                  localObject3 = b.a;
                case 'L':
                case 'P':
                case 'M':
                case 'D':
                case 'B':
                }
              break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
              while (true)
              {
                label860: if (str.charAt(6) != 'S')
                  break label1066;
                localObject5 = localObject3;
                i11 = 1;
                i5 = i15;
                i10 = i8;
                break;
                str = e[i14];
                break label860;
                str = f[i14];
                break label860;
                str = g[i14];
                break label860;
                str = h[i14];
                break label860;
                str = i[i14];
                break label860;
                localObject3 = b.b;
                continue;
                localObject3 = b.e;
                continue;
                localObject3 = b.c;
                continue;
                localObject3 = b.d;
                continue;
                localObject3 = b.f;
              }
            }
            localStringBuilder.append(str);
            label1066: i5 = i15;
            i10 = i8;
            Object localObject7 = localObject3;
            i11 = i6;
            localObject5 = localObject7;
          }
        }
      }
      return new DecoderResult(null, localStringBuilder.toString(), null, null);
      label1105: i8 = i10;
      Object localObject6 = localObject5;
      i6 = i11;
      localObject3 = localObject6;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.decoder.Decoder
 * JD-Core Version:    0.6.2
 */