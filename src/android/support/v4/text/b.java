package android.support.v4.text;

final class b
{
  private static final int a = 1792;
  private static final byte[] b = new byte[1792];
  private final String c;
  private final boolean d;
  private final int e;
  private int f;
  private char g;

  static
  {
    for (int i = 0; i < 1792; i++)
      b[i] = Character.getDirectionality(i);
  }

  b(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.d = false;
    this.e = paramString.length();
  }

  private static byte a(char paramChar)
  {
    if (paramChar < '܀')
      return b[paramChar];
    return Character.getDirectionality(paramChar);
  }

  private byte c()
  {
    byte b1 = 12;
    this.g = this.c.charAt(this.f);
    int i1;
    if (Character.isHighSurrogate(this.g))
    {
      i1 = Character.codePointAt(this.c, this.f);
      this.f += Character.charCount(i1);
    }
    byte b2;
    label102: label234: char c1;
    do
    {
      b1 = Character.getDirectionality(i1);
      while (this.f >= this.e)
      {
        return b1;
        this.f = (1 + this.f);
        b2 = a(this.g);
        if (!this.d)
          break;
        if (this.g == '<')
        {
          int j = this.f;
          while (true)
          {
            if (this.f >= this.e)
              break label234;
            String str2 = this.c;
            int k = this.f;
            this.f = (k + 1);
            this.g = str2.charAt(k);
            if (this.g == '>')
              break;
            if ((this.g == '"') || (this.g == '\''))
            {
              int m = this.g;
              if (this.f < this.e)
              {
                String str3 = this.c;
                int n = this.f;
                this.f = (n + 1);
                char c2 = str3.charAt(n);
                this.g = c2;
                if (c2 != m)
                  break label102;
              }
            }
          }
          this.f = j;
          this.g = '<';
          return 13;
        }
        if (this.g != '&')
          break;
      }
      String str1 = this.c;
      int i = this.f;
      this.f = (i + 1);
      c1 = str1.charAt(i);
      this.g = c1;
    }
    while (c1 != ';');
    return b1;
    return b2;
  }

  private byte d()
  {
    byte b1 = 12;
    this.g = this.c.charAt(-1 + this.f);
    if (Character.isLowSurrogate(this.g))
    {
      int i2 = Character.codePointBefore(this.c, this.f);
      this.f -= Character.charCount(i2);
      b1 = Character.getDirectionality(i2);
      return b1;
    }
    this.f = (-1 + this.f);
    byte b2 = a(this.g);
    if (this.d)
    {
      if (this.g == '>')
      {
        int k = this.f;
        while (true)
        {
          label104: if (this.f <= 0)
            break label237;
          String str2 = this.c;
          int m = -1 + this.f;
          this.f = m;
          this.g = str2.charAt(m);
          if (this.g == '<')
            break;
          if (this.g == '>')
            break label237;
          if ((this.g == '"') || (this.g == '\''))
          {
            int n = this.g;
            if (this.f > 0)
            {
              String str3 = this.c;
              int i1 = -1 + this.f;
              this.f = i1;
              char c1 = str3.charAt(i1);
              this.g = c1;
              if (c1 != n)
                break label104;
            }
          }
        }
        label237: this.f = k;
        this.g = '>';
        return 13;
      }
      if (this.g == ';')
      {
        int i = this.f;
        do
        {
          if (this.f <= 0)
            break label322;
          String str1 = this.c;
          int j = -1 + this.f;
          this.f = j;
          this.g = str1.charAt(j);
          if (this.g == '&')
            break;
        }
        while (this.g != ';');
        label322: this.f = i;
        this.g = ';';
        return 13;
      }
    }
    return b2;
  }

  private byte e()
  {
    int i = this.f;
    while (true)
    {
      if (this.f >= this.e)
        break label134;
      String str1 = this.c;
      int j = this.f;
      this.f = (j + 1);
      this.g = str1.charAt(j);
      if (this.g == '>')
        return 12;
      if ((this.g == '"') || (this.g == '\''))
      {
        int k = this.g;
        if (this.f < this.e)
        {
          String str2 = this.c;
          int m = this.f;
          this.f = (m + 1);
          char c1 = str2.charAt(m);
          this.g = c1;
          if (c1 != k)
            break;
        }
      }
    }
    label134: this.f = i;
    this.g = '<';
    return 13;
  }

  private byte f()
  {
    int i = this.f;
    while (true)
    {
      if (this.f <= 0)
        break label135;
      String str1 = this.c;
      int j = -1 + this.f;
      this.f = j;
      this.g = str1.charAt(j);
      if (this.g == '<')
        return 12;
      if (this.g == '>')
        break label135;
      if ((this.g == '"') || (this.g == '\''))
      {
        int k = this.g;
        if (this.f > 0)
        {
          String str2 = this.c;
          int m = -1 + this.f;
          this.f = m;
          char c1 = str2.charAt(m);
          this.g = c1;
          if (c1 != k)
            break;
        }
      }
    }
    label135: this.f = i;
    this.g = '>';
    return 13;
  }

  private byte g()
  {
    char c1;
    do
    {
      if (this.f >= this.e)
        break;
      String str = this.c;
      int i = this.f;
      this.f = (i + 1);
      c1 = str.charAt(i);
      this.g = c1;
    }
    while (c1 != ';');
    return 12;
  }

  private byte h()
  {
    int i = this.f;
    do
    {
      if (this.f <= 0)
        break;
      String str = this.c;
      int j = -1 + this.f;
      this.f = j;
      this.g = str.charAt(j);
      if (this.g == '&')
        return 12;
    }
    while (this.g != ';');
    this.f = i;
    this.g = ';';
    return 13;
  }

  final int a()
  {
    this.f = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    label11: 
    while ((this.f < this.e) && (i == 0))
    {
      this.g = this.c.charAt(this.f);
      int m;
      if (Character.isHighSurrogate(this.g))
      {
        int i5 = Character.codePointAt(this.c, this.f);
        this.f += Character.charCount(i5);
        m = Character.getDirectionality(i5);
      }
      while (true)
        switch (m)
        {
        case 9:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 10:
        case 11:
        case 12:
        case 13:
        default:
          i = k;
          break label11;
          this.f = (1 + this.f);
          m = a(this.g);
          if (this.d)
            if (this.g == '<')
            {
              int i1 = this.f;
              while (true)
              {
                if (this.f >= this.e)
                  break label360;
                String str2 = this.c;
                int i2 = this.f;
                this.f = (i2 + 1);
                this.g = str2.charAt(i2);
                if (this.g == '>')
                {
                  m = 12;
                  break;
                }
                if ((this.g == '"') || (this.g == '\''))
                {
                  int i3 = this.g;
                  char c2;
                  do
                  {
                    if (this.f >= this.e)
                      break;
                    String str3 = this.c;
                    int i4 = this.f;
                    this.f = (i4 + 1);
                    c2 = str3.charAt(i4);
                    this.g = c2;
                  }
                  while (c2 != i3);
                }
              }
              label360: this.f = i1;
              this.g = '<';
              m = 13;
            }
            else if (this.g == '&')
            {
              char c1;
              do
              {
                if (this.f >= this.e)
                  break;
                String str1 = this.c;
                int n = this.f;
                this.f = (n + 1);
                c1 = str1.charAt(n);
                this.g = c1;
              }
              while (c1 != ';');
              m = 12;
            }
          break;
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 0:
        case 1:
        case 2:
        }
      k++;
      j = -1;
      continue;
      k++;
      j = 1;
      continue;
      k--;
      j = 0;
      continue;
      if (k == 0)
        return -1;
      i = k;
      continue;
      if (k == 0)
        return 1;
      i = k;
    }
    if (i == 0)
      return 0;
    if (j != 0)
      return j;
    while (true)
    {
      if (this.f <= 0)
        break label585;
      switch (d())
      {
      default:
        break;
      case 14:
      case 15:
        if (i == k)
          break;
        k--;
        break;
      case 16:
      case 17:
        if (i == k)
          return 1;
        k--;
        break;
      case 18:
        k++;
      }
    }
    label585: return 0;
  }

  final int b()
  {
    this.f = this.e;
    int i = 0;
    int j = 0;
    while (true)
    {
      int k = this.f;
      int m = 0;
      if (k > 0);
      switch (d())
      {
      case 9:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 10:
      case 11:
      case 12:
      case 13:
      default:
        if (i == 0)
          i = j;
        break;
      case 0:
        if (j == 0)
        {
          m = -1;
          return m;
        }
        if (i == 0)
          i = j;
        break;
      case 14:
      case 15:
        if (i == j)
          return -1;
        j--;
        break;
      case 1:
      case 2:
        if (j == 0)
          return 1;
        if (i == 0)
          i = j;
        break;
      case 16:
      case 17:
        if (i == j)
          return 1;
        j--;
        break;
      case 18:
        j++;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.b
 * JD-Core Version:    0.6.2
 */