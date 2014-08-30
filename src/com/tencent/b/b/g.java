package com.tencent.b.b;

final class g
{
  private g(a parama)
  {
  }

  public final boolean a(String paramString1, String paramString2)
  {
    int i = a.a(paramString1);
    int j = 0x1F & 36 + (10 + i * 9) / 3;
    if (paramString2.charAt(4) != s.a.charAt(j));
    int i7;
    do
    {
      int i5;
      int i6;
      do
      {
        int i3;
        do
        {
          int i2;
          do
          {
            int i1;
            do
            {
              int n;
              do
              {
                int m;
                do
                {
                  int k;
                  do
                  {
                    return false;
                    k = 0x1F & (11 + i * 5) / 5;
                  }
                  while (paramString2.charAt(7) != s.a.charAt(k));
                  m = 0x1F & (i + 10) / 3 << 3;
                }
                while (paramString2.charAt(12) != s.a.charAt(m));
                n = 0x1F & (19 + i * 3) / 9;
              }
              while (paramString2.charAt(14) != s.a.charAt(n));
              i1 = 0x1F & (39 + i * 3) / 8;
            }
            while (paramString2.charAt(19) != s.a.charAt(i1));
            i2 = 0x1F & (67 + i / 23) / 7;
          }
          while (paramString2.charAt(21) != s.a.charAt(i2));
          i3 = 0x1F & 7 * (3 + (i + 23) / 6);
        }
        while (paramString2.charAt(26) != s.a.charAt(i3));
        int i4 = 0;
        i5 = 0;
        while (i4 < paramString1.length())
        {
          i5 = 0xFF & i5 >> 8 ^ s.b[(0xFF & (i5 ^ s.a(paramString1.charAt(i4))))];
          i4++;
        }
        i6 = i5 & 0x1F;
      }
      while (paramString2.charAt(0) != s.a.charAt(i6));
      i7 = 0x1F & i5 >> 5;
    }
    while (paramString2.charAt(1) != s.a.charAt(i7));
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.g
 * JD-Core Version:    0.6.2
 */