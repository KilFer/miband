package com.xiaomi.hm.bleservice.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class Helper
{
  public static final UUID UUID_DESCRIPTOR_CHARACTERISTIC_USER_CONFIGURATION;
  public static final UUID UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION;
  private static final String a = "0000%4s-0000-1000-8000-00805f9b34fb";
  private static final String b = String.format("0000%4s-0000-1000-8000-00805f9b34fb", new Object[] { "...." });
  private static final int[] c = arrayOfInt;
  private static final byte d = 1;
  private static final byte e = 2;
  private static final byte f = 3;
  private static final byte g = 6;
  private static final byte h = 7;
  private static final byte i = 8;
  private static final byte j = 9;
  private static final byte k = 10;
  private static final byte l = 20;
  private static final byte m = 21;
  private static final byte n = -1;

  static
  {
    UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION = UUID16("2902");
    UUID_DESCRIPTOR_CHARACTERISTIC_USER_CONFIGURATION = UUID16("2901");
    int[] arrayOfInt = new int[256];
    arrayOfInt[1] = 49345;
    arrayOfInt[2] = 49537;
    arrayOfInt[3] = 320;
    arrayOfInt[4] = 49921;
    arrayOfInt[5] = 960;
    arrayOfInt[6] = 640;
    arrayOfInt[7] = 49729;
    arrayOfInt[8] = 50689;
    arrayOfInt[9] = 1728;
    arrayOfInt[10] = 1920;
    arrayOfInt[11] = 51009;
    arrayOfInt[12] = 1280;
    arrayOfInt[13] = 50625;
    arrayOfInt[14] = 50305;
    arrayOfInt[15] = 1088;
    arrayOfInt[16] = 52225;
    arrayOfInt[17] = 3264;
    arrayOfInt[18] = 3456;
    arrayOfInt[19] = 52545;
    arrayOfInt[20] = 3840;
    arrayOfInt[21] = 53185;
    arrayOfInt[22] = 52865;
    arrayOfInt[23] = 3648;
    arrayOfInt[24] = 2560;
    arrayOfInt[25] = 51905;
    arrayOfInt[26] = 52097;
    arrayOfInt[27] = 2880;
    arrayOfInt[28] = 51457;
    arrayOfInt[29] = 2496;
    arrayOfInt[30] = 2176;
    arrayOfInt[31] = 51265;
    arrayOfInt[32] = 55297;
    arrayOfInt[33] = 6336;
    arrayOfInt[34] = 6528;
    arrayOfInt[35] = 55617;
    arrayOfInt[36] = 6912;
    arrayOfInt[37] = 56257;
    arrayOfInt[38] = 55937;
    arrayOfInt[39] = 6720;
    arrayOfInt[40] = 7680;
    arrayOfInt[41] = 57025;
    arrayOfInt[42] = 57217;
    arrayOfInt[43] = 8000;
    arrayOfInt[44] = 56577;
    arrayOfInt[45] = 7616;
    arrayOfInt[46] = 7296;
    arrayOfInt[47] = 56385;
    arrayOfInt[48] = 5120;
    arrayOfInt[49] = 54465;
    arrayOfInt[50] = 54657;
    arrayOfInt[51] = 5440;
    arrayOfInt[52] = 55041;
    arrayOfInt[53] = 6080;
    arrayOfInt[54] = 5760;
    arrayOfInt[55] = 54849;
    arrayOfInt[56] = 53761;
    arrayOfInt[57] = 4800;
    arrayOfInt[58] = 4992;
    arrayOfInt[59] = 54081;
    arrayOfInt[60] = 4352;
    arrayOfInt[61] = 53697;
    arrayOfInt[62] = 53377;
    arrayOfInt[63] = 4160;
    arrayOfInt[64] = 61441;
    arrayOfInt[65] = 12480;
    arrayOfInt[66] = 12672;
    arrayOfInt[67] = 61761;
    arrayOfInt[68] = 13056;
    arrayOfInt[69] = 62401;
    arrayOfInt[70] = 62081;
    arrayOfInt[71] = 12864;
    arrayOfInt[72] = 13824;
    arrayOfInt[73] = 63169;
    arrayOfInt[74] = 63361;
    arrayOfInt[75] = 14144;
    arrayOfInt[76] = 62721;
    arrayOfInt[77] = 13760;
    arrayOfInt[78] = 13440;
    arrayOfInt[79] = 62529;
    arrayOfInt[80] = 15360;
    arrayOfInt[81] = 64705;
    arrayOfInt[82] = 64897;
    arrayOfInt[83] = 15680;
    arrayOfInt[84] = 65281;
    arrayOfInt[85] = 16320;
    arrayOfInt[86] = 16000;
    arrayOfInt[87] = 65089;
    arrayOfInt[88] = 64001;
    arrayOfInt[89] = 15040;
    arrayOfInt[90] = 15232;
    arrayOfInt[91] = 64321;
    arrayOfInt[92] = 14592;
    arrayOfInt[93] = 63937;
    arrayOfInt[94] = 63617;
    arrayOfInt[95] = 14400;
    arrayOfInt[96] = 10240;
    arrayOfInt[97] = 59585;
    arrayOfInt[98] = 59777;
    arrayOfInt[99] = 10560;
    arrayOfInt[100] = 60161;
    arrayOfInt[101] = 11200;
    arrayOfInt[102] = 10880;
    arrayOfInt[103] = 59969;
    arrayOfInt[104] = 60929;
    arrayOfInt[105] = 11968;
    arrayOfInt[106] = 12160;
    arrayOfInt[107] = 61249;
    arrayOfInt[108] = 11520;
    arrayOfInt[109] = 60865;
    arrayOfInt[110] = 60545;
    arrayOfInt[111] = 11328;
    arrayOfInt[112] = 58369;
    arrayOfInt[113] = 9408;
    arrayOfInt[114] = 9600;
    arrayOfInt[115] = 58689;
    arrayOfInt[116] = 9984;
    arrayOfInt[117] = 59329;
    arrayOfInt[118] = 59009;
    arrayOfInt[119] = 9792;
    arrayOfInt[120] = 8704;
    arrayOfInt[121] = 58049;
    arrayOfInt[122] = 58241;
    arrayOfInt[123] = 9024;
    arrayOfInt[124] = 57601;
    arrayOfInt[125] = 8640;
    arrayOfInt[126] = 8320;
    arrayOfInt[127] = 57409;
    arrayOfInt[''] = 40961;
    arrayOfInt[''] = 24768;
    arrayOfInt[''] = 24960;
    arrayOfInt[''] = 41281;
    arrayOfInt[''] = 25344;
    arrayOfInt[''] = 41921;
    arrayOfInt[''] = 41601;
    arrayOfInt[''] = 25152;
    arrayOfInt[''] = 26112;
    arrayOfInt[''] = 42689;
    arrayOfInt[''] = 42881;
    arrayOfInt[''] = 26432;
    arrayOfInt[''] = 42241;
    arrayOfInt[''] = 26048;
    arrayOfInt[''] = 25728;
    arrayOfInt[''] = 42049;
    arrayOfInt[''] = 27648;
    arrayOfInt[''] = 44225;
    arrayOfInt[''] = 44417;
    arrayOfInt[''] = 27968;
    arrayOfInt[''] = 44801;
    arrayOfInt[''] = 28608;
    arrayOfInt[''] = 28288;
    arrayOfInt[''] = 44609;
    arrayOfInt[''] = 43521;
    arrayOfInt[''] = 27328;
    arrayOfInt[''] = 27520;
    arrayOfInt[''] = 43841;
    arrayOfInt[''] = 26880;
    arrayOfInt[''] = 43457;
    arrayOfInt[''] = 43137;
    arrayOfInt[''] = 26688;
    arrayOfInt[' '] = 30720;
    arrayOfInt['¡'] = 47297;
    arrayOfInt['¢'] = 47489;
    arrayOfInt['£'] = 31040;
    arrayOfInt['¤'] = 47873;
    arrayOfInt['¥'] = 31680;
    arrayOfInt['¦'] = 31360;
    arrayOfInt['§'] = 47681;
    arrayOfInt['¨'] = 48641;
    arrayOfInt['©'] = 32448;
    arrayOfInt['ª'] = 32640;
    arrayOfInt['«'] = 48961;
    arrayOfInt['¬'] = 32000;
    arrayOfInt['­'] = 48577;
    arrayOfInt['®'] = 48257;
    arrayOfInt['¯'] = 31808;
    arrayOfInt['°'] = 46081;
    arrayOfInt['±'] = 29888;
    arrayOfInt['²'] = 30080;
    arrayOfInt['³'] = 46401;
    arrayOfInt['´'] = 30464;
    arrayOfInt['µ'] = 47041;
    arrayOfInt['¶'] = 46721;
    arrayOfInt['·'] = 30272;
    arrayOfInt['¸'] = 29184;
    arrayOfInt['¹'] = 45761;
    arrayOfInt['º'] = 45953;
    arrayOfInt['»'] = 29504;
    arrayOfInt['¼'] = 45313;
    arrayOfInt['½'] = 29120;
    arrayOfInt['¾'] = 28800;
    arrayOfInt['¿'] = 45121;
    arrayOfInt['À'] = 20480;
    arrayOfInt['Á'] = 37057;
    arrayOfInt['Â'] = 37249;
    arrayOfInt['Ã'] = 20800;
    arrayOfInt['Ä'] = 37633;
    arrayOfInt['Å'] = 21440;
    arrayOfInt['Æ'] = 21120;
    arrayOfInt['Ç'] = 37441;
    arrayOfInt['È'] = 38401;
    arrayOfInt['É'] = 22208;
    arrayOfInt['Ê'] = 22400;
    arrayOfInt['Ë'] = 38721;
    arrayOfInt['Ì'] = 21760;
    arrayOfInt['Í'] = 38337;
    arrayOfInt['Î'] = 38017;
    arrayOfInt['Ï'] = 21568;
    arrayOfInt['Ð'] = 39937;
    arrayOfInt['Ñ'] = 23744;
    arrayOfInt['Ò'] = 23936;
    arrayOfInt['Ó'] = 40257;
    arrayOfInt['Ô'] = 24320;
    arrayOfInt['Õ'] = 40897;
    arrayOfInt['Ö'] = 40577;
    arrayOfInt['×'] = 24128;
    arrayOfInt['Ø'] = 23040;
    arrayOfInt['Ù'] = 39617;
    arrayOfInt['Ú'] = 39809;
    arrayOfInt['Û'] = 23360;
    arrayOfInt['Ü'] = 39169;
    arrayOfInt['Ý'] = 22976;
    arrayOfInt['Þ'] = 22656;
    arrayOfInt['ß'] = 38977;
    arrayOfInt['à'] = 34817;
    arrayOfInt['á'] = 18624;
    arrayOfInt['â'] = 18816;
    arrayOfInt['ã'] = 35137;
    arrayOfInt['ä'] = 19200;
    arrayOfInt['å'] = 35777;
    arrayOfInt['æ'] = 35457;
    arrayOfInt['ç'] = 19008;
    arrayOfInt['è'] = 19968;
    arrayOfInt['é'] = 36545;
    arrayOfInt['ê'] = 36737;
    arrayOfInt['ë'] = 20288;
    arrayOfInt['ì'] = 36097;
    arrayOfInt['í'] = 19904;
    arrayOfInt['î'] = 19584;
    arrayOfInt['ï'] = 35905;
    arrayOfInt['ð'] = 17408;
    arrayOfInt['ñ'] = 33985;
    arrayOfInt['ò'] = 34177;
    arrayOfInt['ó'] = 17728;
    arrayOfInt['ô'] = 34561;
    arrayOfInt['õ'] = 18368;
    arrayOfInt['ö'] = 18048;
    arrayOfInt['÷'] = 34369;
    arrayOfInt['ø'] = 33281;
    arrayOfInt['ù'] = 17088;
    arrayOfInt['ú'] = 17280;
    arrayOfInt['û'] = 33601;
    arrayOfInt['ü'] = 16640;
    arrayOfInt['ý'] = 33217;
    arrayOfInt['þ'] = 32897;
    arrayOfInt['ÿ'] = 16448;
  }

  public static byte[] AESDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"));
      byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte2);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      while (true)
        localNoSuchPaddingException.printStackTrace();
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      while (true)
        localInvalidKeyException.printStackTrace();
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      while (true)
        localIllegalBlockSizeException.printStackTrace();
    }
    catch (BadPaddingException localBadPaddingException)
    {
      while (true)
        localBadPaddingException.printStackTrace();
    }
  }

  public static byte[] AESEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(1, new SecretKeySpec(paramArrayOfByte1, "AES"));
      byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte2);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      while (true)
        localNoSuchPaddingException.printStackTrace();
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      while (true)
        localInvalidKeyException.printStackTrace();
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      while (true)
        localIllegalBlockSizeException.printStackTrace();
    }
    catch (BadPaddingException localBadPaddingException)
    {
      while (true)
        localBadPaddingException.printStackTrace();
    }
  }

  public static int CRC16(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int i2 = 65535;
    while (true)
    {
      if (i1 >= paramArrayOfByte.length)
        return i2 & 0xFFFF;
      int i3 = 0xFFFF & (i2 >>> 8 | i2 << 8) ^ 0xFF & paramArrayOfByte[i1];
      int i4 = i3 ^ (i3 & 0xFF) >> 4;
      int i5 = i4 ^ 0xFFFF & i4 << 12;
      i2 = i5 ^ 0xFFFF & (i5 & 0xFF) << 5;
      i1++;
    }
  }

  public static int CRC8(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int i2 = 0;
    int i3;
    while (true)
    {
      if (i1 >= paramArrayOfByte.length)
        return i2;
      i2 ^= 0xFF & paramArrayOfByte[i1];
      i3 = 0;
      if (i3 < 8)
        break;
      i1++;
    }
    if ((i2 & 0x1) != 0);
    for (i2 = 0x8C ^ 0xFF & i2 >> 1; ; i2 = 0xFF & i2 >> 1)
    {
      i3++;
      break;
    }
  }

  public static UUID UUID(byte[] paramArrayOfByte)
  {
    switch (paramArrayOfByte.length)
    {
    default:
      return null;
    case 2:
      Object[] arrayOfObject5 = new Object[2];
      arrayOfObject5[0] = Byte.valueOf(paramArrayOfByte[0]);
      arrayOfObject5[1] = Byte.valueOf(paramArrayOfByte[1]);
      return UUID16(String.format("%02x%02x", arrayOfObject5));
    case 16:
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Byte.valueOf(paramArrayOfByte[0]);
    arrayOfObject1[1] = Byte.valueOf(paramArrayOfByte[1]);
    arrayOfObject1[2] = Byte.valueOf(paramArrayOfByte[2]);
    arrayOfObject1[3] = Byte.valueOf(paramArrayOfByte[3]);
    localStringBuilder.append(String.format("%02x%02x%02x%02x", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Byte.valueOf(paramArrayOfByte[4]);
    arrayOfObject2[1] = Byte.valueOf(paramArrayOfByte[5]);
    arrayOfObject2[2] = Byte.valueOf(paramArrayOfByte[6]);
    arrayOfObject2[3] = Byte.valueOf(paramArrayOfByte[7]);
    localStringBuilder.append(String.format("-%02x%02x-%02x%02x", arrayOfObject2));
    Object[] arrayOfObject3 = new Object[4];
    arrayOfObject3[0] = Byte.valueOf(paramArrayOfByte[8]);
    arrayOfObject3[1] = Byte.valueOf(paramArrayOfByte[9]);
    arrayOfObject3[2] = Byte.valueOf(paramArrayOfByte[10]);
    arrayOfObject3[3] = Byte.valueOf(paramArrayOfByte[11]);
    localStringBuilder.append(String.format("-%02x%02x-%02x%02x", arrayOfObject3));
    Object[] arrayOfObject4 = new Object[4];
    arrayOfObject4[0] = Byte.valueOf(paramArrayOfByte[12]);
    arrayOfObject4[1] = Byte.valueOf(paramArrayOfByte[13]);
    arrayOfObject4[2] = Byte.valueOf(paramArrayOfByte[14]);
    arrayOfObject4[3] = Byte.valueOf(paramArrayOfByte[15]);
    localStringBuilder.append(String.format("%02x%02x%02x%02x", arrayOfObject4));
    return UUID128(localStringBuilder.toString());
  }

  public static UUID UUID128(String paramString)
  {
    return UUID.fromString(paramString);
  }

  public static UUID UUID16(String paramString)
  {
    return UUID.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", new Object[] { paramString }));
  }

  private static int a(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int i2 = paramArrayOfByte.length;
    int i3 = 0;
    while (true)
    {
      if (i1 >= i2)
        return i3;
      int i4 = paramArrayOfByte[i1];
      i3 = i3 >>> 8 ^ c[(0xFF & (i3 ^ i4))];
      i1++;
    }
  }

  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    Debug.ASSERT_NOT_NULL(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfByte.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return localStringBuilder.substring(0, -1 + localStringBuilder.length());
      byte b1 = paramArrayOfByte[i2];
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Byte.valueOf(b1);
      localStringBuilder.append(String.format("%02x ", arrayOfObject));
    }
  }

  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    return bytesToInt(paramArrayOfByte, paramInt, 4);
  }

  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    int i1 = 0;
    boolean bool2;
    label26: int i2;
    if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
    {
      bool2 = bool1;
      Debug.ASSERT_TRUE(bool2);
      if (paramInt2 > 4)
        break label48;
      Debug.ASSERT_TRUE(bool1);
      i2 = 0;
    }
    while (true)
    {
      if (i1 >= paramInt2)
      {
        return i2;
        bool2 = false;
        break;
        label48: bool1 = false;
        break label26;
      }
      i2 |= (0xFF & paramArrayOfByte[(paramInt1 + i1)]) << i1 * 8;
      i1++;
    }
  }

  public static boolean isDeviceValid(byte[] paramArrayOfByte, UUID[] paramArrayOfUUID)
  {
    boolean bool;
    int i1;
    if (paramArrayOfByte.length == 62)
    {
      bool = true;
      Debug.ASSERT_TRUE(bool);
      i1 = 0;
    }
    while (true)
    {
      label15: int i2 = i1 + 1;
      int i3 = paramArrayOfByte[i1];
      if (i3 == 0)
        break label557;
      i1 = i2 + 1;
      int i4 = paramArrayOfByte[i2];
      if ((i4 == 3) || (i4 == 2))
      {
        int i5 = 0;
        label56: int i7;
        String str1;
        int i8;
        if (i5 < i3 - 1)
        {
          byte[] arrayOfByte1 = new byte[2];
          int i6 = i1 + 1;
          arrayOfByte1[0] = paramArrayOfByte[i1];
          i7 = i6 + 1;
          arrayOfByte1[1] = paramArrayOfByte[i6];
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Byte.valueOf(arrayOfByte1[1]);
          arrayOfObject1[1] = Byte.valueOf(arrayOfByte1[0]);
          str1 = String.format("%02x%02x", arrayOfObject1);
          i8 = paramArrayOfUUID.length;
        }
        for (int i9 = 0; ; i9++)
        {
          if (i9 >= i8)
          {
            i5 += 2;
            i1 = i7;
            break label56;
            break label15;
            bool = false;
            break;
          }
          if (parseUUID(paramArrayOfUUID[i9]).equals(str1))
            label176: return true;
        }
      }
      if ((i4 == 7) || (i4 == 6))
      {
        int i10 = 0;
        label201: byte[] arrayOfByte2;
        int i11;
        int i12;
        label222: String str2;
        int i14;
        if (i10 < i3 - 1)
        {
          arrayOfByte2 = new byte[16];
          i11 = i1;
          i12 = 0;
          if (i12 < 16)
            break label465;
          Object[] arrayOfObject2 = new Object[16];
          arrayOfObject2[0] = Byte.valueOf(arrayOfByte2[15]);
          arrayOfObject2[1] = Byte.valueOf(arrayOfByte2[14]);
          arrayOfObject2[2] = Byte.valueOf(arrayOfByte2[13]);
          arrayOfObject2[3] = Byte.valueOf(arrayOfByte2[12]);
          arrayOfObject2[4] = Byte.valueOf(arrayOfByte2[11]);
          arrayOfObject2[5] = Byte.valueOf(arrayOfByte2[10]);
          arrayOfObject2[6] = Byte.valueOf(arrayOfByte2[9]);
          arrayOfObject2[7] = Byte.valueOf(arrayOfByte2[8]);
          arrayOfObject2[8] = Byte.valueOf(arrayOfByte2[7]);
          arrayOfObject2[9] = Byte.valueOf(arrayOfByte2[6]);
          arrayOfObject2[10] = Byte.valueOf(arrayOfByte2[5]);
          arrayOfObject2[11] = Byte.valueOf(arrayOfByte2[4]);
          arrayOfObject2[12] = Byte.valueOf(arrayOfByte2[3]);
          arrayOfObject2[13] = Byte.valueOf(arrayOfByte2[2]);
          arrayOfObject2[14] = Byte.valueOf(arrayOfByte2[1]);
          arrayOfObject2[15] = Byte.valueOf(arrayOfByte2[0]);
          str2 = String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", arrayOfObject2);
          i14 = paramArrayOfUUID.length;
        }
        for (int i15 = 0; ; i15++)
        {
          if (i15 >= i14)
          {
            i10 += 16;
            i1 = i11;
            break label201;
            break;
            label465: int i13 = i11 + 1;
            arrayOfByte2[i12] = paramArrayOfByte[i11];
            i12++;
            i11 = i13;
            break label222;
          }
          UUID localUUID = paramArrayOfUUID[i15];
          Debug.DEBUG(localUUID.toString() + "==" + str2);
          if (parseUUID(localUUID).equals(str2))
            break label176;
        }
      }
      i1 += i3 - 1;
    }
    label557: return false;
  }

  public static void parseAdvData(byte[] paramArrayOfByte)
  {
    boolean bool1;
    int i1;
    label15: int i3;
    int i4;
    byte b1;
    byte[] arrayOfByte11;
    int i37;
    if (paramArrayOfByte.length == 62)
    {
      bool1 = true;
      Debug.ASSERT_TRUE(bool1);
      i1 = 0;
      int i2 = i1 + 1;
      i3 = paramArrayOfByte[i1];
      if (i3 == 0)
        return;
      i4 = i2 + 1;
      b1 = paramArrayOfByte[i2];
      switch (b1)
      {
      case 0:
      case 4:
      case 5:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      default:
        arrayOfByte11 = new byte[i3 - 1];
        i1 = i4;
        i37 = 0;
      case 1:
      case 3:
      case 2:
      case 7:
      case 6:
      case 20:
      case 21:
      case 9:
      case 8:
      case 10:
      case -1:
      }
    }
    while (true)
    {
      if (i37 >= i3 - 1)
      {
        StringBuilder localStringBuilder8 = new StringBuilder("      ");
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Byte.valueOf(b1);
        Debug.DEBUG(String.format("[0x%02x]", arrayOfObject2) + ": " + bytesToHexString(arrayOfByte11));
        break label15;
        bool1 = false;
        break;
        if (i3 == 2);
        for (boolean bool2 = true; ; bool2 = false)
        {
          Debug.ASSERT_TRUE(bool2);
          i1 = i4 + 1;
          byte b2 = paramArrayOfByte[i4];
          StringBuilder localStringBuilder7 = new StringBuilder("        flag: ");
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Byte.valueOf(b2);
          Debug.DEBUG(String.format("%02x", arrayOfObject1));
          break;
        }
        StringBuilder localStringBuilder6 = new StringBuilder();
        i1 = i4;
        int i33 = 0;
        if (i33 >= i3 - 1)
        {
          Debug.DEBUG("      serv16: " + localStringBuilder6.toString());
          break label15;
        }
        byte[] arrayOfByte10 = new byte[2];
        int i34 = i1;
        int i35 = 0;
        while (true)
        {
          if (i35 >= 2)
          {
            localStringBuilder6.append(bytesToHexString(arrayOfByte10));
            localStringBuilder6.append("; ");
            i33 += 2;
            i1 = i34;
            break;
          }
          int i36 = i34 + 1;
          arrayOfByte10[i35] = paramArrayOfByte[i34];
          i35++;
          i34 = i36;
        }
        StringBuilder localStringBuilder5 = new StringBuilder();
        i1 = i4;
        int i29 = 0;
        if (i29 >= i3 - 1)
        {
          Debug.DEBUG("   (*)serv16: " + localStringBuilder5.toString());
          break label15;
        }
        byte[] arrayOfByte9 = new byte[2];
        int i30 = i1;
        int i31 = 0;
        while (true)
        {
          if (i31 >= 2)
          {
            localStringBuilder5.append(bytesToHexString(arrayOfByte9));
            localStringBuilder5.append("; ");
            i29 += 2;
            i1 = i30;
            break;
          }
          int i32 = i30 + 1;
          arrayOfByte9[i31] = paramArrayOfByte[i30];
          i31++;
          i30 = i32;
        }
        StringBuilder localStringBuilder4 = new StringBuilder();
        i1 = i4;
        int i25 = 0;
        if (i25 >= i3 - 1)
        {
          Debug.DEBUG("     serv128: " + localStringBuilder4.toString());
          break label15;
        }
        byte[] arrayOfByte8 = new byte[16];
        int i26 = i1;
        int i27 = 0;
        while (true)
        {
          if (i27 >= 16)
          {
            localStringBuilder4.append(bytesToHexString(arrayOfByte8));
            localStringBuilder4.append("; ");
            i25 += 16;
            i1 = i26;
            break;
          }
          int i28 = i26 + 1;
          arrayOfByte8[i27] = paramArrayOfByte[i26];
          i27++;
          i26 = i28;
        }
        StringBuilder localStringBuilder3 = new StringBuilder();
        i1 = i4;
        int i21 = 0;
        if (i21 >= i3 - 1)
        {
          Debug.DEBUG("  (*)serv128: " + localStringBuilder3.toString());
          break label15;
        }
        byte[] arrayOfByte7 = new byte[16];
        int i22 = i1;
        int i23 = 0;
        while (true)
        {
          if (i23 >= 16)
          {
            localStringBuilder3.append(bytesToHexString(arrayOfByte7));
            localStringBuilder3.append("; ");
            i21 += 16;
            i1 = i22;
            break;
          }
          int i24 = i22 + 1;
          arrayOfByte7[i23] = paramArrayOfByte[i22];
          i23++;
          i22 = i24;
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        i1 = i4;
        int i17 = 0;
        if (i17 >= i3 - 1)
        {
          Debug.DEBUG("   solicit16: " + localStringBuilder2.toString());
          break label15;
        }
        byte[] arrayOfByte6 = new byte[2];
        int i18 = i1;
        int i19 = 0;
        while (true)
        {
          if (i19 >= 2)
          {
            localStringBuilder2.append(bytesToHexString(arrayOfByte6));
            localStringBuilder2.append("; ");
            i17 += 2;
            i1 = i18;
            break;
          }
          int i20 = i18 + 1;
          arrayOfByte6[i19] = paramArrayOfByte[i18];
          i19++;
          i18 = i20;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        i1 = i4;
        int i13 = 0;
        if (i13 >= i3 - 1)
        {
          Debug.DEBUG("  solicit128: " + localStringBuilder1.toString());
          break label15;
        }
        byte[] arrayOfByte5 = new byte[16];
        int i14 = i1;
        int i15 = 0;
        while (true)
        {
          if (i15 >= 16)
          {
            localStringBuilder1.append(bytesToHexString(arrayOfByte5));
            localStringBuilder1.append("; ");
            i13 += 16;
            i1 = i14;
            break;
          }
          int i16 = i14 + 1;
          arrayOfByte5[i15] = paramArrayOfByte[i14];
          i15++;
          i14 = i16;
        }
        byte[] arrayOfByte4 = new byte[i3 - 1];
        i1 = i4;
        int i11 = 0;
        while (true)
        {
          if (i11 >= i3 - 1)
          {
            String str4 = new String(arrayOfByte4);
            Debug.DEBUG("        name: " + str4);
            break;
          }
          int i12 = i1 + 1;
          arrayOfByte4[i11] = paramArrayOfByte[i1];
          i11++;
          i1 = i12;
        }
        byte[] arrayOfByte3 = new byte[i3 - 1];
        i1 = i4;
        int i9 = 0;
        while (true)
        {
          if (i9 >= i3 - 1)
          {
            String str3 = new String(arrayOfByte3);
            Debug.DEBUG("     (*)name: " + str3);
            break;
          }
          int i10 = i1 + 1;
          arrayOfByte3[i9] = paramArrayOfByte[i1];
          i9++;
          i1 = i10;
        }
        byte[] arrayOfByte2 = new byte[i3 - 1];
        i1 = i4;
        int i7 = 0;
        while (true)
        {
          if (i7 >= i3 - 1)
          {
            String str2 = bytesToHexString(arrayOfByte2);
            Debug.DEBUG("    tx level: " + str2);
            break;
          }
          int i8 = i1 + 1;
          arrayOfByte2[i7] = paramArrayOfByte[i1];
          i7++;
          i1 = i8;
        }
        byte[] arrayOfByte1 = new byte[i3 - 1];
        i1 = i4;
        int i5 = 0;
        while (true)
        {
          if (i5 >= i3 - 1)
          {
            String str1 = bytesToHexString(arrayOfByte1);
            Debug.DEBUG("    manufact: " + str1);
            break;
          }
          int i6 = i1 + 1;
          arrayOfByte1[i5] = paramArrayOfByte[i1];
          i5++;
          i1 = i6;
        }
      }
      int i38 = i1 + 1;
      arrayOfByte11[i37] = paramArrayOfByte[i1];
      i37++;
      i1 = i38;
    }
  }

  public static String parsePermissions(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt & 0x1) > 0)
      localStringBuilder.append("READ ");
    if ((paramInt & 0x2) > 0)
      localStringBuilder.append("READ_ENCRYPTED ");
    if ((paramInt & 0x4) > 0)
      localStringBuilder.append("READ_ENCRYPTED_MITM ");
    if ((paramInt & 0x10) > 0)
      localStringBuilder.append("WRITE ");
    if ((paramInt & 0x20) > 0)
      localStringBuilder.append("WRITE_ENCRYPTED ");
    if ((paramInt & 0x40) > 0)
      localStringBuilder.append("WRITE_ENCRYPTED_MITM ");
    if ((paramInt & 0x80) > 0)
      localStringBuilder.append("WRITE_SIGNED ");
    if ((paramInt & 0x100) > 0)
      localStringBuilder.append("WRITE_SIGNED_MITM ");
    return localStringBuilder.toString();
  }

  public static String parseProperties(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt & 0x1) > 0)
      localStringBuilder.append("BROADCAST ");
    if ((paramInt & 0x80) > 0)
      localStringBuilder.append("EXTENDED_PROPS ");
    if ((paramInt & 0x20) > 0)
      localStringBuilder.append("INDICATE ");
    if ((paramInt & 0x10) > 0)
      localStringBuilder.append("NOTIFY ");
    if ((paramInt & 0x2) > 0)
      localStringBuilder.append("READ ");
    if ((paramInt & 0x40) > 0)
      localStringBuilder.append("SIGNED_WRITE ");
    if ((paramInt & 0x8) > 0)
      localStringBuilder.append("WRITE ");
    if ((paramInt & 0x4) > 0)
      localStringBuilder.append("WRITE_NO_RESPONSE ");
    return localStringBuilder.toString();
  }

  public static String parseUUID(UUID paramUUID)
  {
    String str = paramUUID.toString();
    if (str.matches(b))
      str = str.substring(4, 8);
    return str;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.util.Helper
 * JD-Core Version:    0.6.2
 */