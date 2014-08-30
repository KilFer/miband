package com.google.zxing.common;

import java.util.HashMap;
import java.util.Map;

public enum CharacterSetECI
{
  private static final Map<Integer, CharacterSetECI> a;
  private static final Map<String, CharacterSetECI> b;
  private final int[] c;
  private final String[] d;

  static
  {
    ISO8859_10 = new CharacterSetECI("ISO8859_10", 10, 12, new String[] { "ISO-8859-10" });
    ISO8859_11 = new CharacterSetECI("ISO8859_11", 11, 13, new String[] { "ISO-8859-11" });
    ISO8859_13 = new CharacterSetECI("ISO8859_13", 12, 15, new String[] { "ISO-8859-13" });
    ISO8859_14 = new CharacterSetECI("ISO8859_14", 13, 16, new String[] { "ISO-8859-14" });
    ISO8859_15 = new CharacterSetECI("ISO8859_15", 14, 17, new String[] { "ISO-8859-15" });
    ISO8859_16 = new CharacterSetECI("ISO8859_16", 15, 18, new String[] { "ISO-8859-16" });
    SJIS = new CharacterSetECI("SJIS", 16, 20, new String[] { "Shift_JIS" });
    Cp1250 = new CharacterSetECI("Cp1250", 17, 21, new String[] { "windows-1250" });
    Cp1251 = new CharacterSetECI("Cp1251", 18, 22, new String[] { "windows-1251" });
    Cp1252 = new CharacterSetECI("Cp1252", 19, 23, new String[] { "windows-1252" });
    Cp1256 = new CharacterSetECI("Cp1256", 20, 24, new String[] { "windows-1256" });
    UnicodeBigUnmarked = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[] { "UTF-16BE", "UnicodeBig" });
    UTF8 = new CharacterSetECI("UTF8", 22, 26, new String[] { "UTF-8" });
    ASCII = new CharacterSetECI("ASCII", 23, new int[] { 27, 170 }, new String[] { "US-ASCII" });
    Big5 = new CharacterSetECI("Big5", 24, 28);
    GB18030 = new CharacterSetECI("GB18030", 25, 29, new String[] { "GB2312", "EUC_CN", "GBK" });
    EUC_KR = new CharacterSetECI("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    CharacterSetECI[] arrayOfCharacterSetECI1 = new CharacterSetECI[27];
    arrayOfCharacterSetECI1[0] = Cp437;
    arrayOfCharacterSetECI1[1] = ISO8859_1;
    arrayOfCharacterSetECI1[2] = ISO8859_2;
    arrayOfCharacterSetECI1[3] = ISO8859_3;
    arrayOfCharacterSetECI1[4] = ISO8859_4;
    arrayOfCharacterSetECI1[5] = ISO8859_5;
    arrayOfCharacterSetECI1[6] = ISO8859_6;
    arrayOfCharacterSetECI1[7] = ISO8859_7;
    arrayOfCharacterSetECI1[8] = ISO8859_8;
    arrayOfCharacterSetECI1[9] = ISO8859_9;
    arrayOfCharacterSetECI1[10] = ISO8859_10;
    arrayOfCharacterSetECI1[11] = ISO8859_11;
    arrayOfCharacterSetECI1[12] = ISO8859_13;
    arrayOfCharacterSetECI1[13] = ISO8859_14;
    arrayOfCharacterSetECI1[14] = ISO8859_15;
    arrayOfCharacterSetECI1[15] = ISO8859_16;
    arrayOfCharacterSetECI1[16] = SJIS;
    arrayOfCharacterSetECI1[17] = Cp1250;
    arrayOfCharacterSetECI1[18] = Cp1251;
    arrayOfCharacterSetECI1[19] = Cp1252;
    arrayOfCharacterSetECI1[20] = Cp1256;
    arrayOfCharacterSetECI1[21] = UnicodeBigUnmarked;
    arrayOfCharacterSetECI1[22] = UTF8;
    arrayOfCharacterSetECI1[23] = ASCII;
    arrayOfCharacterSetECI1[24] = Big5;
    arrayOfCharacterSetECI1[25] = GB18030;
    arrayOfCharacterSetECI1[26] = EUC_KR;
    e = arrayOfCharacterSetECI1;
    a = new HashMap();
    b = new HashMap();
    for (CharacterSetECI localCharacterSetECI : values())
    {
      for (int i2 : localCharacterSetECI.c)
        a.put(Integer.valueOf(i2), localCharacterSetECI);
      b.put(localCharacterSetECI.name(), localCharacterSetECI);
      for (String str : localCharacterSetECI.d)
        b.put(str, localCharacterSetECI);
    }
  }

  private CharacterSetECI(int paramInt)
  {
    this(new int[] { 28 }, new String[0]);
  }

  private CharacterSetECI(int paramInt, String[] paramArrayOfString)
  {
    this.c = new int[] { paramInt };
    this.d = paramArrayOfString;
  }

  private CharacterSetECI(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    this.c = paramArrayOfInt;
    this.d = paramArrayOfString;
  }

  public static CharacterSetECI getCharacterSetECIByName(String paramString)
  {
    return (CharacterSetECI)b.get(paramString);
  }

  public static CharacterSetECI getCharacterSetECIByValue(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 900))
      throw new IllegalArgumentException("Bad ECI value: " + paramInt);
    return (CharacterSetECI)a.get(Integer.valueOf(paramInt));
  }

  public final int getValue()
  {
    return this.c[0];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.CharacterSetECI
 * JD-Core Version:    0.6.2
 */