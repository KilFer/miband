package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

public class JpegTools
{
  public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
  public static final int ORIENTATION_FLIP_VERTICAL = 4;
  public static final int ORIENTATION_NORMAL = 1;
  public static final int ORIENTATION_ROTATE_180 = 3;
  public static final int ORIENTATION_ROTATE_270 = 8;
  public static final int ORIENTATION_ROTATE_90 = 6;
  public static final int ORIENTATION_TRANSPOSE = 5;
  public static final int ORIENTATION_TRANSVERSE = 7;
  public static final int ORIENTATION_UNDEFINED = 0;
  public static final String TAG = "MicroMsg.JpegTools";
  private i a = null;
  private int b = -1;
  private boolean c = true;

  public JpegTools(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte);
  }

  private void a(int paramInt)
  {
    int i = this.a.b().position();
    this.a.b().position(i + paramInt);
  }

  public static String byte2HexString(byte paramByte)
  {
    String str = Integer.toHexString(paramByte & 0xFF);
    if (str.length() == 1)
      str = "0" + str;
    return "" + str.toUpperCase();
  }

  public int getOreiValue()
  {
    if (this.b != -1);
    switch (this.b)
    {
    case 2:
    case 4:
    case 5:
    case 7:
    default:
      return -1;
    case 6:
      return 90;
    case 3:
      return 180;
    case 8:
      return 270;
    case 1:
    }
    return 0;
  }

  public int parserJpeg()
  {
    while (true)
    {
      int i5;
      int i6;
      String str;
      int i12;
      int i11;
      int i13;
      int i15;
      try
      {
        byte b1 = this.a.b().get();
        byte b2 = this.a.b().get();
        if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("D8")))
        {
          i = 1;
          if (i != 0)
            break label922;
          Log.w("MicroMsg.JpegTools", "this is not jpeg or no exif data!!!");
          return -1;
          byte b3 = this.a.b().get();
          byte b4 = this.a.b().get();
          this.a.b().get();
          int k = this.a.b().get();
          int m;
          if (!byte2HexString(b3).equals("FF"))
          {
            m = -1;
            if (m < 0)
            {
              Log.w("MicroMsg.JpegTools", "datalen is error ");
              return -1;
            }
          }
          else
          {
            if ((byte2HexString(b3).equals("FF")) && (byte2HexString(b4).equals("E1")))
            {
              m = -2 + (k & 0xFF);
              continue;
            }
            if ((byte2HexString(b3).equals("FF")) && (byte2HexString(b4).equals("D9")))
            {
              m = -1;
              continue;
            }
            int i16 = -2 + (k + this.a.a());
            this.a.b().position(i16);
            j++;
            if (j <= 100)
              continue;
            Log.e("MicroMsg.JpegTools", "error while!");
            m = -1;
            continue;
          }
          int n = this.a.b().get();
          int i1 = this.a.b().get();
          int i2 = this.a.b().get();
          int i3 = this.a.b().get();
          if (!((char)n + (char)i1 + (char)i2 + (char)i3).equals("Exif"))
            break label928;
          i4 = 1;
          if (i4 == 0)
          {
            Log.w("MicroMsg.JpegTools", "checkExifTag is error");
            return -1;
          }
          a(2);
          i5 = this.a.b().get();
          i6 = this.a.b().get();
          if (((char)i5 != 'M') || ((char)i6 != 'M'))
            break label934;
          str = "MM";
          if ((!str.equals("MM")) && (!str.equals("II")))
          {
            Log.w("MicroMsg.JpegTools", "byteOrder  is error " + str);
            return -1;
          }
          this.c = str.equals("MM");
          boolean bool1 = this.c;
          byte b5 = this.a.b().get();
          byte b6 = this.a.b().get();
          int i7;
          if ((bool1) && (byte2HexString(b5).equals("00")) && (byte2HexString(b6).equals("2A")))
          {
            i7 = 1;
            if (i7 == 0)
            {
              Log.w("MicroMsg.JpegTools", "checkTiffTag  is error ");
              return -1;
            }
          }
          else
          {
            if ((byte2HexString(b5).equals("2A")) && (byte2HexString(b6).equals("00")))
            {
              i7 = 1;
              continue;
            }
            Log.w("MicroMsg.JpegTools", "checkTiffTag: " + byte2HexString(b5) + " " + byte2HexString(b6));
            i7 = 0;
            continue;
          }
          a(4);
          int i8 = this.a.b().get();
          int i9 = this.a.b().get();
          int i10 = i8 & 0xFF;
          if (!this.c)
            break label964;
          i10 = i9 & 0xFF;
          break label964;
          byte b7;
          byte b8;
          if ((i12 < i10) && (i12 < 255))
          {
            b7 = this.a.b().get();
            b8 = this.a.b().get();
            if ((this.c) && (byte2HexString(b7).equals("01")) && (byte2HexString(b8).equals("12")))
            {
              i11 = 1;
              a(2);
              a(4);
              if (i11 == 0)
                continue;
              boolean bool2 = this.c;
              i13 = this.a.b().get();
              int i14 = this.a.b().get();
              a(2);
              if (!bool2)
                break label973;
              i15 = i14 & 0xFF;
              this.b = i15;
            }
          }
          else
          {
            Log.d("MicroMsg.JpegTools", "orei " + this.b);
            return getOreiValue();
          }
          if ((this.c) || (!byte2HexString(b7).equals("12")) || (!byte2HexString(b8).equals("01")))
            continue;
          i11 = 1;
          continue;
          a(4);
          i12++;
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.JpegTools", "parser jpeg error");
        return -1;
      }
      int i = 0;
      continue;
      label922: int j = 0;
      continue;
      label928: int i4 = 0;
      continue;
      label934: if (((char)i5 == 'I') && ((char)i6 == 'I'))
      {
        str = "II";
      }
      else
      {
        str = "";
        continue;
        label964: i11 = 0;
        i12 = 0;
        continue;
        label973: i15 = i13 & 0xFF;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.JpegTools
 * JD-Core Version:    0.6.2
 */