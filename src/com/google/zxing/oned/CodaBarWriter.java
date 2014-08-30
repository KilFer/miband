package com.google.zxing.oned;

public class CodaBarWriter extends OneDimensionalCodeWriter
{
  public CodaBarWriter()
  {
    super(20);
  }

  public byte[] encode(String paramString)
  {
    if (!CodaBarReader.a(new char[] { 65, 66, 67, 68 }, Character.toUpperCase(paramString.charAt(0))))
      throw new IllegalArgumentException("Codabar should start with one of the following: 'A', 'B', 'C' or 'D'");
    if (!CodaBarReader.a(new char[] { 84, 78, 42, 69 }, Character.toUpperCase(paramString.charAt(-1 + paramString.length()))))
      throw new IllegalArgumentException("Codabar should end with one of the following: 'T', 'N', '*' or 'E'");
    char[] arrayOfChar = { 47, 58, 43, 46 };
    int i = 20;
    int j = 1;
    if (j < -1 + paramString.length())
    {
      if ((Character.isDigit(paramString.charAt(j))) || (paramString.charAt(j) == '-') || (paramString.charAt(j) == '$'))
        i += 9;
      while (true)
      {
        j++;
        break;
        if (!CodaBarReader.a(arrayOfChar, paramString.charAt(j)))
          break label202;
        i += 10;
      }
      label202: throw new IllegalArgumentException("Cannot encode : '" + paramString.charAt(j) + '\'');
    }
    byte[] arrayOfByte = new byte[i + (-1 + paramString.length())];
    int k = 0;
    int m = 0;
    int n;
    int i1;
    if (k < paramString.length())
    {
      n = Character.toUpperCase(paramString.charAt(k));
      if (k == -1 + paramString.length())
      {
        if (n == 42)
          n = 67;
      }
      else
      {
        i1 = 0;
        label299: if (i1 >= CodaBarReader.a.length)
          break label454;
        if (n != CodaBarReader.a[i1])
          break label409;
      }
    }
    label409: label425: label454: for (int i2 = CodaBarReader.b[i1]; ; i2 = 0)
    {
      int i3 = 0;
      int i4 = 1;
      int i5 = 0;
      while (true)
      {
        if (i3 >= 7)
          break label425;
        arrayOfByte[m] = i4;
        int i6 = m + 1;
        if (((0x1 & i2 >> 6 - i3) == 0) || (i5 == 1))
        {
          i4 = (byte)(i4 ^ 0x1);
          i3++;
          m = i6;
          i5 = 0;
          continue;
          if (n != 69)
            break;
          n = 68;
          break;
          i1++;
          break label299;
        }
        i5++;
        m = i6;
      }
      if (k < -1 + paramString.length())
      {
        arrayOfByte[m] = 0;
        m++;
      }
      k++;
      break;
      return arrayOfByte;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.CodaBarWriter
 * JD-Core Version:    0.6.2
 */