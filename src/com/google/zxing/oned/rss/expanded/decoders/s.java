package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class s
{
  private final BitArray a;
  private final l b = new l();
  private final StringBuilder c = new StringBuilder();

  s(BitArray paramBitArray)
  {
    this.a = paramBitArray;
  }

  static int a(BitArray paramBitArray, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt2 > 32)
      throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
    for (int j = 0; j < paramInt2; j++)
      if (paramBitArray.get(paramInt1 + j))
        i |= 1 << -1 + (paramInt2 - j);
    return i;
  }

  private o a()
  {
    int i = this.b.a();
    label18: int k;
    int m;
    label66: int n;
    int i1;
    n localn;
    label111: k localk;
    boolean bool;
    if (this.b.b())
    {
      k = this.b.a();
      if (k + 5 <= this.a.getSize())
      {
        int i3 = a(k, 5);
        if ((i3 >= 5) && (i3 < 16))
        {
          m = 1;
          if (m == 0)
            break label464;
          n = this.b.a();
          i1 = a(n, 5);
          if (i1 != 15)
            break label249;
          localn = new n(n + 5, '$');
          this.b.a(localn.e());
          if (!localn.b())
            break label448;
          localk = new k(new o(this.b.a(), this.c.toString()), true);
          bool = localk.b();
          label166: if (i == this.b.a())
            break label609;
        }
      }
    }
    label448: label464: label609: for (int j = 1; ((j == 0) && (!bool)) || (bool); j = 0)
    {
      return localk.a();
      if (k + 6 <= this.a.getSize())
      {
        int i4 = a(k, 6);
        if ((i4 >= 16) && (i4 < 63))
        {
          m = 1;
          break label66;
        }
      }
      m = 0;
      break label66;
      label249: if ((i1 >= 5) && (i1 < 15))
      {
        localn = new n(n + 5, (char)(-5 + (i1 + 48)));
        break label111;
      }
      int i2 = a(n, 6);
      if ((i2 >= 32) && (i2 < 58))
      {
        localn = new n(n + 6, (char)(i2 + 33));
        break label111;
      }
      char c1;
      switch (i2)
      {
      default:
        throw new IllegalStateException("Decoding invalid alphanumeric value: " + i2);
      case 58:
        c1 = '*';
      case 59:
      case 60:
      case 61:
      case 62:
      }
      while (true)
      {
        localn = new n(n + 6, c1);
        break;
        c1 = ',';
        continue;
        c1 = '-';
        continue;
        c1 = '.';
        continue;
        c1 = '/';
      }
      this.c.append(localn.a());
      break label18;
      if (h(this.b.a()))
      {
        this.b.b(3);
        this.b.d();
      }
      while (!g(this.b.a()))
      {
        localk = new k(false);
        break;
      }
      if (5 + this.b.a() < this.a.getSize())
        this.b.b(5);
      while (true)
      {
        this.b.f();
        break;
        this.b.a(this.a.getSize());
      }
      if (this.b.c())
      {
        localk = c();
        bool = localk.b();
        break label166;
      }
      localk = b();
      bool = localk.b();
      break label166;
    }
  }

  private boolean a(int paramInt)
  {
    if (paramInt + 7 > this.a.getSize())
      return paramInt + 4 <= this.a.getSize();
    for (int i = paramInt; ; i++)
    {
      if (i >= paramInt + 3)
        break label57;
      if (this.a.get(i))
        break;
    }
    label57: return this.a.get(paramInt + 3);
  }

  private k b()
  {
    while (true)
    {
      int i = this.b.a();
      boolean bool;
      int i1;
      int i5;
      p localp;
      if (i + 7 > this.a.getSize())
        if (i + 4 <= this.a.getSize())
        {
          bool = true;
          if (!bool)
            break;
          i1 = this.b.a();
          if (i1 + 7 <= this.a.getSize())
            break label236;
          i5 = a(i1, 4);
          if (i5 != 0)
            break label211;
          localp = new p(this.a.getSize(), 10, 10);
          label99: this.b.a(localp.e());
          if (!localp.c())
            break label318;
          if (!localp.d())
            break label287;
        }
      label287: for (o localo = new o(this.b.a(), this.c.toString()); ; localo = new o(this.b.a(), this.c.toString(), localp.b()))
      {
        return new k(localo, true);
        bool = false;
        break;
        for (int j = i; ; j++)
        {
          if (j >= i + 3)
            break label197;
          if (this.a.get(j))
          {
            bool = true;
            break;
          }
        }
        label197: bool = this.a.get(i + 3);
        break;
        label211: localp = new p(this.a.getSize(), i5 - 1, 10);
        break label99;
        label236: int i2 = a(i1, 7);
        int i3 = (i2 - 8) / 11;
        int i4 = (i2 - 8) % 11;
        localp = new p(i1 + 7, i3, i4);
        break label99;
      }
      label318: this.c.append(localp.a());
      if (localp.d())
        return new k(new o(this.b.a(), this.c.toString()), true);
      this.c.append(localp.b());
    }
    int k = this.b.a();
    int n;
    if (k + 1 > this.a.getSize())
      n = 0;
    while (true)
    {
      if (n != 0)
      {
        this.b.e();
        this.b.b(4);
      }
      return new k(false);
      for (int m = 0; ; m++)
      {
        if ((m >= 4) || (m + k >= this.a.getSize()))
          break label491;
        if (this.a.get(k + m))
        {
          n = 0;
          break;
        }
      }
      label491: n = 1;
    }
  }

  private p b(int paramInt)
  {
    if (paramInt + 7 > this.a.getSize())
    {
      int m = a(paramInt, 4);
      if (m == 0)
        return new p(this.a.getSize(), 10, 10);
      return new p(this.a.getSize(), m - 1, 10);
    }
    int i = a(paramInt, 7);
    int j = (i - 8) / 11;
    int k = (i - 8) % 11;
    return new p(paramInt + 7, j, k);
  }

  private k c()
  {
    while (true)
    {
      int i = this.b.a();
      int j;
      int k;
      int m;
      n localn;
      if (i + 5 <= this.a.getSize())
      {
        int i2 = a(i, 5);
        if ((i2 >= 5) && (i2 < 16))
        {
          j = 1;
          if (j == 0)
            break;
          k = this.b.a();
          m = a(k, 5);
          if (m != 15)
            break label226;
          localn = new n(k + 5, '$');
        }
      }
      while (true)
      {
        this.b.a(localn.e());
        if (!localn.b())
          break label639;
        return new k(new o(this.b.a(), this.c.toString()), true);
        if (i + 7 <= this.a.getSize())
        {
          int i3 = a(i, 7);
          if ((i3 >= 64) && (i3 < 116))
          {
            j = 1;
            break;
          }
          if (i + 8 <= this.a.getSize())
          {
            int i4 = a(i, 8);
            if ((i4 >= 232) && (i4 < 253))
            {
              j = 1;
              break;
            }
          }
        }
        j = 0;
        break;
        label226: if ((m >= 5) && (m < 15))
        {
          localn = new n(k + 5, (char)(-5 + (m + 48)));
        }
        else
        {
          int n = a(k, 7);
          if ((n >= 64) && (n < 90))
          {
            localn = new n(k + 7, (char)(n + 1));
          }
          else
          {
            if ((n < 90) || (n >= 116))
              break label343;
            localn = new n(k + 7, (char)(n + 7));
          }
        }
      }
      label343: int i1 = a(k, 8);
      char c1;
      switch (i1)
      {
      default:
        throw new IllegalArgumentException("Decoding invalid ISO/IEC 646 value: " + i1);
      case 232:
        c1 = '!';
      case 233:
      case 234:
      case 235:
      case 236:
      case 237:
      case 238:
      case 239:
      case 240:
      case 241:
      case 242:
      case 243:
      case 244:
      case 245:
      case 246:
      case 247:
      case 248:
      case 249:
      case 250:
      case 251:
      case 252:
      }
      while (true)
      {
        localn = new n(k + 8, c1);
        break;
        c1 = '"';
        continue;
        c1 = '%';
        continue;
        c1 = '&';
        continue;
        c1 = '\'';
        continue;
        c1 = '(';
        continue;
        c1 = ')';
        continue;
        c1 = '*';
        continue;
        c1 = '+';
        continue;
        c1 = ',';
        continue;
        c1 = '-';
        continue;
        c1 = '.';
        continue;
        c1 = '/';
        continue;
        c1 = ':';
        continue;
        c1 = ';';
        continue;
        c1 = '<';
        continue;
        c1 = '=';
        continue;
        c1 = '>';
        continue;
        c1 = '?';
        continue;
        c1 = '_';
        continue;
        c1 = ' ';
      }
      label639: this.c.append(localn.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a()))
      return new k(false);
    if (5 + this.b.a() < this.a.getSize())
      this.b.b(5);
    while (true)
    {
      this.b.e();
      break;
      this.b.a(this.a.getSize());
    }
  }

  private boolean c(int paramInt)
  {
    if (paramInt + 5 > this.a.getSize());
    int k;
    do
    {
      do
      {
        do
        {
          return false;
          int i = a(paramInt, 5);
          if ((i >= 5) && (i < 16))
            return true;
        }
        while (paramInt + 7 > this.a.getSize());
        int j = a(paramInt, 7);
        if ((j >= 64) && (j < 116))
          return true;
      }
      while (paramInt + 8 > this.a.getSize());
      k = a(paramInt, 8);
    }
    while ((k < 232) || (k >= 253));
    return true;
  }

  private k d()
  {
    while (true)
    {
      int i = this.b.a();
      int j;
      int k;
      int m;
      n localn;
      if (i + 5 <= this.a.getSize())
      {
        int i1 = a(i, 5);
        if ((i1 >= 5) && (i1 < 16))
        {
          j = 1;
          if (j == 0)
            break;
          k = this.b.a();
          m = a(k, 5);
          if (m != 15)
            break label182;
          localn = new n(k + 5, '$');
        }
      }
      label182: int n;
      while (true)
      {
        this.b.a(localn.e());
        if (!localn.b())
          break label375;
        return new k(new o(this.b.a(), this.c.toString()), true);
        if (i + 6 <= this.a.getSize())
        {
          int i2 = a(i, 6);
          if ((i2 >= 16) && (i2 < 63))
          {
            j = 1;
            break;
          }
        }
        j = 0;
        break;
        if ((m >= 5) && (m < 15))
        {
          localn = new n(k + 5, (char)(-5 + (m + 48)));
        }
        else
        {
          n = a(k, 6);
          if ((n < 32) || (n >= 58))
            break label264;
          localn = new n(k + 6, (char)(n + 33));
        }
      }
      label264: char c1;
      switch (n)
      {
      default:
        throw new IllegalStateException("Decoding invalid alphanumeric value: " + n);
      case 58:
        c1 = '*';
      case 59:
      case 60:
      case 61:
      case 62:
      }
      while (true)
      {
        localn = new n(k + 6, c1);
        break;
        c1 = ',';
        continue;
        c1 = '-';
        continue;
        c1 = '.';
        continue;
        c1 = '/';
      }
      label375: this.c.append(localn.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a()))
      return new k(false);
    if (5 + this.b.a() < this.a.getSize())
      this.b.b(5);
    while (true)
    {
      this.b.f();
      break;
      this.b.a(this.a.getSize());
    }
  }

  private n d(int paramInt)
  {
    int i = a(paramInt, 5);
    if (i == 15)
      return new n(paramInt + 5, '$');
    if ((i >= 5) && (i < 15))
      return new n(paramInt + 5, (char)(-5 + (i + 48)));
    int j = a(paramInt, 7);
    if ((j >= 64) && (j < 90))
      return new n(paramInt + 7, (char)(j + 1));
    if ((j >= 90) && (j < 116))
      return new n(paramInt + 7, (char)(j + 7));
    int k = a(paramInt, 8);
    char c1;
    switch (k)
    {
    default:
      throw new IllegalArgumentException("Decoding invalid ISO/IEC 646 value: " + k);
    case 232:
      c1 = '!';
    case 233:
    case 234:
    case 235:
    case 236:
    case 237:
    case 238:
    case 239:
    case 240:
    case 241:
    case 242:
    case 243:
    case 244:
    case 245:
    case 246:
    case 247:
    case 248:
    case 249:
    case 250:
    case 251:
    case 252:
    }
    while (true)
    {
      return new n(paramInt + 8, c1);
      c1 = '"';
      continue;
      c1 = '%';
      continue;
      c1 = '&';
      continue;
      c1 = '\'';
      continue;
      c1 = '(';
      continue;
      c1 = ')';
      continue;
      c1 = '*';
      continue;
      c1 = '+';
      continue;
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
      continue;
      c1 = ':';
      continue;
      c1 = ';';
      continue;
      c1 = '<';
      continue;
      c1 = '=';
      continue;
      c1 = '>';
      continue;
      c1 = '?';
      continue;
      c1 = '_';
      continue;
      c1 = ' ';
    }
  }

  private boolean e(int paramInt)
  {
    if (paramInt + 5 > this.a.getSize());
    int j;
    do
    {
      do
      {
        return false;
        int i = a(paramInt, 5);
        if ((i >= 5) && (i < 16))
          return true;
      }
      while (paramInt + 6 > this.a.getSize());
      j = a(paramInt, 6);
    }
    while ((j < 16) || (j >= 63));
    return true;
  }

  private n f(int paramInt)
  {
    int i = a(paramInt, 5);
    if (i == 15)
      return new n(paramInt + 5, '$');
    if ((i >= 5) && (i < 15))
      return new n(paramInt + 5, (char)(-5 + (i + 48)));
    int j = a(paramInt, 6);
    if ((j >= 32) && (j < 58))
      return new n(paramInt + 6, (char)(j + 33));
    char c1;
    switch (j)
    {
    default:
      throw new IllegalStateException("Decoding invalid alphanumeric value: " + j);
    case 58:
      c1 = '*';
    case 59:
    case 60:
    case 61:
    case 62:
    }
    while (true)
    {
      return new n(paramInt + 6, c1);
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
    }
  }

  private boolean g(int paramInt)
  {
    if (paramInt + 1 > this.a.getSize());
    int i;
    do
    {
      return false;
      i = 0;
      if ((i >= 5) || (i + paramInt >= this.a.getSize()))
        break label74;
      if (i != 2)
        break;
    }
    while (!this.a.get(paramInt + 2));
    while (!this.a.get(paramInt + i))
    {
      i++;
      break;
    }
    return false;
    label74: return true;
  }

  private boolean h(int paramInt)
  {
    if (paramInt + 3 > this.a.getSize())
      return false;
    for (int i = paramInt; ; i++)
    {
      if (i >= paramInt + 3)
        break label41;
      if (this.a.get(i))
        break;
    }
    label41: return true;
  }

  private boolean i(int paramInt)
  {
    if (paramInt + 1 > this.a.getSize())
      return false;
    for (int i = 0; ; i++)
    {
      if ((i >= 4) || (i + paramInt >= this.a.getSize()))
        break label54;
      if (this.a.get(paramInt + i))
        break;
    }
    label54: return true;
  }

  final int a(int paramInt1, int paramInt2)
  {
    return a(this.a, paramInt1, paramInt2);
  }

  final o a(int paramInt, String paramString)
  {
    this.c.setLength(0);
    if (paramString != null)
      this.c.append(paramString);
    this.b.a(paramInt);
    label140: label540: label692: label696: 
    while (true)
    {
      int i = this.b.a();
      int k;
      int m;
      label95: int n;
      int i1;
      n localn;
      k localk;
      boolean bool;
      if (this.b.b())
      {
        k = this.b.a();
        if (k + 5 <= this.a.getSize())
        {
          int i3 = a(k, 5);
          if ((i3 >= 5) && (i3 < 16))
          {
            m = 1;
            if (m == 0)
              break label540;
            n = this.b.a();
            i1 = a(n, 5);
            if (i1 != 15)
              break label325;
            localn = new n(n + 5, '$');
            this.b.a(localn.e());
            if (!localn.b())
              break label524;
            localk = new k(new o(this.b.a(), this.c.toString()), true);
            bool = localk.b();
            label198: if (i == this.b.a())
              break label692;
          }
        }
      }
      for (int j = 1; ; j = 0)
      {
        if (((j != 0) || (bool)) && (!bool))
          break label696;
        o localo = localk.a();
        if ((localo == null) || (!localo.b()))
          break label698;
        return new o(this.b.a(), this.c.toString(), localo.c());
        if (k + 6 <= this.a.getSize())
        {
          int i4 = a(k, 6);
          if ((i4 >= 16) && (i4 < 63))
          {
            m = 1;
            break label95;
          }
        }
        m = 0;
        break label95;
        label325: if ((i1 >= 5) && (i1 < 15))
        {
          localn = new n(n + 5, (char)(-5 + (i1 + 48)));
          break label140;
        }
        int i2 = a(n, 6);
        if ((i2 >= 32) && (i2 < 58))
        {
          localn = new n(n + 6, (char)(i2 + 33));
          break label140;
        }
        char c1;
        switch (i2)
        {
        default:
          throw new IllegalStateException("Decoding invalid alphanumeric value: " + i2);
        case 58:
          c1 = '*';
        case 59:
        case 60:
        case 61:
        case 62:
        }
        while (true)
        {
          localn = new n(n + 6, c1);
          break;
          c1 = ',';
          continue;
          c1 = '-';
          continue;
          c1 = '.';
          continue;
          c1 = '/';
        }
        this.c.append(localn.a());
        break;
        if (h(this.b.a()))
        {
          this.b.b(3);
          this.b.d();
        }
        while (!g(this.b.a()))
        {
          localk = new k(false);
          break;
        }
        if (5 + this.b.a() < this.a.getSize())
          this.b.b(5);
        while (true)
        {
          this.b.f();
          break;
          this.b.a(this.a.getSize());
        }
        if (this.b.c())
        {
          localk = c();
          bool = localk.b();
          break label198;
        }
        localk = b();
        bool = localk.b();
        break label198;
      }
    }
    label524: label698: return new o(this.b.a(), this.c.toString());
  }

  final String a(StringBuilder paramStringBuilder, int paramInt)
  {
    String str1 = null;
    o localo = a(paramInt, str1);
    String str2 = r.a(localo.a());
    if (str2 != null)
      paramStringBuilder.append(str2);
    if (localo.b());
    for (str1 = String.valueOf(localo.c()); ; str1 = null)
    {
      if (paramInt == localo.e())
        break label72;
      paramInt = localo.e();
      break;
    }
    label72: return paramStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.s
 * JD-Core Version:    0.6.2
 */