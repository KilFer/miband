package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
  implements Closeable
{
  private static final int A = 6;
  private static final int B = 7;
  private static final char[] a = ")]}'\n".toCharArray();
  private static final long b = -922337203685477580L;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  private static final int i = 6;
  private static final int j = 7;
  private static final int k = 8;
  private static final int l = 9;
  private static final int m = 10;
  private static final int n = 11;
  private static final int o = 12;
  private static final int p = 13;
  private static final int q = 14;
  private static final int r = 15;
  private static final int s = 16;
  private static final int t = 17;
  private static final int u = 0;
  private static final int v = 1;
  private static final int w = 2;
  private static final int x = 3;
  private static final int y = 4;
  private static final int z = 5;
  private final Reader C;
  private boolean D = false;
  private final char[] E = new char[1024];
  private int F = 0;
  private int G = 0;
  private int H = 0;
  private int I = 0;
  private int J = 0;
  private long K;
  private int L;
  private String M;
  private int[] N = new int[32];
  private int O = 0;

  static
  {
    com.google.gson.internal.JsonReaderInternalAccess.INSTANCE = new a();
  }

  public JsonReader(Reader paramReader)
  {
    int[] arrayOfInt = this.N;
    int i1 = this.O;
    this.O = (i1 + 1);
    arrayOfInt[i1] = 6;
    if (paramReader == null)
      throw new NullPointerException("in == null");
    this.C = paramReader;
  }

  private int a()
  {
    int i1 = this.N[(-1 + this.O)];
    int i3;
    if (i1 == 1)
    {
      this.N[(-1 + this.O)] = 2;
      switch (a(true))
      {
      default:
        this.F = (-1 + this.F);
        if (this.O == 1)
          h();
        i3 = b();
        if (i3 == 0)
          break;
      case 93:
      case 44:
      case 59:
      case 39:
      case 34:
      case 91:
      case 123:
      }
    }
    label621: 
    do
    {
      return i3;
      if (i1 == 2)
      {
        switch (a(true))
        {
        case 44:
        default:
          throw b("Unterminated array");
        case 93:
          this.J = 4;
          return 4;
        case 59:
        }
        h();
        break;
      }
      if ((i1 == 3) || (i1 == 5))
      {
        this.N[(-1 + this.O)] = 4;
        if (i1 == 5)
          switch (a(true))
          {
          default:
            throw b("Unterminated object");
          case 125:
            this.J = 2;
            return 2;
          case 59:
            h();
          case 44:
          }
        int i2 = a(true);
        switch (i2)
        {
        default:
          h();
          this.F = (-1 + this.F);
          if (a((char)i2))
          {
            this.J = 14;
            return 14;
          }
          break;
        case 34:
          this.J = 13;
          return 13;
        case 39:
          h();
          this.J = 12;
          return 12;
        case 125:
          if (i1 != 5)
          {
            this.J = 2;
            return 2;
          }
          throw b("Expected name");
        }
        throw b("Expected name");
      }
      if (i1 == 4)
      {
        this.N[(-1 + this.O)] = 5;
        switch (a(true))
        {
        case 58:
        case 59:
        case 60:
        default:
          throw b("Expected ':'");
        case 61:
        }
        h();
        if (((this.F >= this.G) && (!b(1))) || (this.E[this.F] != '>'))
          break;
        this.F = (1 + this.F);
        break;
      }
      if (i1 == 6)
      {
        if (this.D)
        {
          a(true);
          this.F = (-1 + this.F);
          if ((this.F + a.length <= this.G) || (b(a.length)))
          {
            for (int i4 = 0; i4 < a.length; i4++)
              if (this.E[(i4 + this.F)] != a[i4])
                break label621;
            this.F += a.length;
          }
        }
        this.N[(-1 + this.O)] = 7;
        break;
      }
      if (i1 == 7)
      {
        if (a(false) == -1)
        {
          this.J = 17;
          return 17;
        }
        h();
        this.F = (-1 + this.F);
        break;
      }
      if (i1 != 8)
        break;
      throw new IllegalStateException("JsonReader is closed");
      if (i1 == 1)
      {
        this.J = 4;
        return 4;
      }
      if ((i1 == 1) || (i1 == 2))
      {
        h();
        this.F = (-1 + this.F);
        this.J = 7;
        return 7;
      }
      throw b("Unexpected value");
      h();
      this.J = 8;
      return 8;
      if (this.O == 1)
        h();
      this.J = 9;
      return 9;
      this.J = 3;
      return 3;
      this.J = 1;
      return 1;
      i3 = c();
    }
    while (i3 != 0);
    if (!a(this.E[this.F]))
      throw b("Expected value");
    h();
    this.J = 10;
    return 10;
  }

  private int a(boolean paramBoolean)
  {
    char[] arrayOfChar = this.E;
    int i1 = this.F;
    int i2 = this.G;
    while (true)
    {
      int i3;
      if (i1 == i2)
      {
        this.F = i1;
        if (b(1))
        {
          i1 = this.F;
          i2 = this.G;
        }
      }
      else
      {
        i3 = i1 + 1;
        int i4 = arrayOfChar[i1];
        if (i4 == 10)
        {
          this.H = (1 + this.H);
          this.I = i3;
          i1 = i3;
          continue;
        }
        if ((i4 == 32) || (i4 == 13) || (i4 == 9))
          break label482;
        if (i4 == 47)
        {
          this.F = i3;
          if (i3 == i2)
          {
            this.F = (-1 + this.F);
            boolean bool = b(2);
            this.F = (1 + this.F);
            if (!bool)
              return i4;
          }
          h();
          switch (arrayOfChar[this.F])
          {
          default:
            return i4;
          case '*':
            this.F = (1 + this.F);
            while ((this.F + "*/".length() <= this.G) || (b("*/".length())))
              if (this.E[this.F] == '\n')
              {
                this.H = (1 + this.H);
                this.I = (1 + this.F);
                this.F = (1 + this.F);
              }
              else
              {
                for (int i5 = 0; ; i5++)
                {
                  if (i5 >= "*/".length())
                    break label326;
                  if (this.E[(i5 + this.F)] != "*/".charAt(i5))
                    break;
                }
              }
            for (int i6 = 1; i6 == 0; i6 = 0)
              throw b("Unterminated comment");
            i1 = 2 + this.F;
            i2 = this.G;
            break;
          case '/':
            label326: this.F = (1 + this.F);
            i();
            i1 = this.F;
            i2 = this.G;
            break;
          }
        }
        if (i4 == 35)
        {
          this.F = i3;
          h();
          i();
          i1 = this.F;
          i2 = this.G;
          continue;
        }
        this.F = i3;
        return i4;
      }
      if (paramBoolean)
        throw new EOFException("End of input at line " + (1 + this.H) + " column " + g());
      return -1;
      label482: i1 = i3;
    }
  }

  private void a(int paramInt)
  {
    if (this.O == this.N.length)
    {
      int[] arrayOfInt2 = new int[this.O << 1];
      System.arraycopy(this.N, 0, arrayOfInt2, 0, this.O);
      this.N = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.N;
    int i1 = this.O;
    this.O = (i1 + 1);
    arrayOfInt1[i1] = paramInt;
  }

  private boolean a(char paramChar)
  {
    switch (paramChar)
    {
    default:
      return true;
    case '#':
    case '/':
    case ';':
    case '=':
    case '\\':
      h();
    case '\t':
    case '\n':
    case '\f':
    case '\r':
    case ' ':
    case ',':
    case ':':
    case '[':
    case ']':
    case '{':
    case '}':
    }
    return false;
  }

  private boolean a(String paramString)
  {
    while (true)
    {
      if (this.F + paramString.length() > this.G)
      {
        boolean bool2 = b(paramString.length());
        bool1 = false;
        if (!bool2)
          break label117;
      }
      if (this.E[this.F] != '\n')
        break;
      this.H = (1 + this.H);
      this.I = (1 + this.F);
      this.F = (1 + this.F);
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramString.length())
        break label115;
      if (this.E[(i1 + this.F)] != paramString.charAt(i1))
        break;
    }
    label115: boolean bool1 = true;
    label117: return bool1;
  }

  private int b()
  {
    int i1 = this.E[this.F];
    String str1;
    String str2;
    int i2;
    int i3;
    if ((i1 == 116) || (i1 == 84))
    {
      str1 = "true";
      str2 = "TRUE";
      i2 = 5;
      i3 = str1.length();
    }
    for (int i4 = 1; ; i4++)
    {
      if (i4 >= i3)
        break label170;
      if ((i4 + this.F >= this.G) && (!b(i4 + 1)))
      {
        return 0;
        if ((i1 == 102) || (i1 == 70))
        {
          str1 = "false";
          str2 = "FALSE";
          i2 = 6;
          break;
        }
        if ((i1 == 110) || (i1 == 78))
        {
          str1 = "null";
          str2 = "NULL";
          i2 = 7;
          break;
        }
        return 0;
      }
      int i5 = this.E[(i4 + this.F)];
      if ((i5 != str1.charAt(i4)) && (i5 != str2.charAt(i4)))
        return 0;
    }
    label170: if (((i3 + this.F < this.G) || (b(i3 + 1))) && (a(this.E[(i3 + this.F)])))
      return 0;
    this.F = (i3 + this.F);
    this.J = i2;
    return i2;
  }

  private IOException b(String paramString)
  {
    throw new MalformedJsonException(paramString + " at line " + (1 + this.H) + " column " + g());
  }

  private String b(char paramChar)
  {
    char[] arrayOfChar = this.E;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int i1 = this.F;
      int i2 = this.G;
      int i3 = i1;
      while (i3 < i2)
      {
        int i4 = i3 + 1;
        char c1 = arrayOfChar[i3];
        if (c1 == paramChar)
        {
          this.F = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          return localStringBuilder.toString();
        }
        if (c1 == '\\')
        {
          this.F = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          localStringBuilder.append(j());
          i1 = this.F;
          i2 = this.G;
          i3 = i1;
        }
        else
        {
          if (c1 == '\n')
          {
            this.H = (1 + this.H);
            this.I = i4;
          }
          i3 = i4;
        }
      }
      localStringBuilder.append(arrayOfChar, i1, i3 - i1);
      this.F = i3;
    }
    while (b(1));
    throw b("Unterminated string");
  }

  private boolean b(int paramInt)
  {
    char[] arrayOfChar = this.E;
    this.I -= this.F;
    if (this.G != this.F)
    {
      this.G -= this.F;
      System.arraycopy(arrayOfChar, this.F, arrayOfChar, 0, this.G);
    }
    while (true)
    {
      this.F = 0;
      do
      {
        int i1 = this.C.read(arrayOfChar, this.G, arrayOfChar.length - this.G);
        bool = false;
        if (i1 == -1)
          break;
        this.G = (i1 + this.G);
        if ((this.H == 0) && (this.I == 0) && (this.G > 0) && (arrayOfChar[0] == 65279))
        {
          this.F = (1 + this.F);
          this.I = (1 + this.I);
          paramInt++;
        }
      }
      while (this.G < paramInt);
      boolean bool = true;
      return bool;
      this.G = 0;
    }
  }

  private int c()
  {
    char[] arrayOfChar = this.E;
    int i1 = this.F;
    int i2 = this.G;
    long l1 = 0L;
    int i3 = 0;
    int i4 = 1;
    int i5 = 0;
    int i6 = 0;
    int i7 = i2;
    int i8 = i1;
    char c1;
    int i9;
    int i11;
    int i10;
    long l2;
    if (i8 + i6 == i7)
    {
      if (i6 == arrayOfChar.length)
        return 0;
      if (b(i6 + 1))
      {
        i8 = this.F;
        i7 = this.G;
      }
    }
    else
    {
      c1 = arrayOfChar[(i8 + i6)];
      switch (c1)
      {
      default:
        if ((c1 < '0') || (c1 > '9'))
        {
          if (!a(c1))
            break label519;
          return 0;
        }
        break;
      case '-':
        if (i5 == 0)
        {
          i9 = 1;
          int i14 = i4;
          i11 = 1;
          i10 = i14;
          l2 = l1;
        }
        break;
      case '+':
      case 'E':
      case 'e':
      case '.':
      }
    }
    while (true)
    {
      i6++;
      int i12 = i10;
      i5 = i9;
      int i13 = i11;
      i4 = i12;
      l1 = l2;
      i3 = i13;
      break;
      if (i5 == 5)
      {
        i9 = 6;
        i10 = i4;
        i11 = i3;
        l2 = l1;
      }
      else
      {
        return 0;
        if (i5 == 5)
        {
          i9 = 6;
          i10 = i4;
          i11 = i3;
          l2 = l1;
        }
        else
        {
          return 0;
          if ((i5 == 2) || (i5 == 4))
          {
            i9 = 5;
            i10 = i4;
            i11 = i3;
            l2 = l1;
          }
          else
          {
            return 0;
            if (i5 == 2)
            {
              i9 = 3;
              i10 = i4;
              i11 = i3;
              l2 = l1;
            }
            else
            {
              return 0;
              if ((i5 == 1) || (i5 == 0))
              {
                long l3 = -(c1 - '0');
                i9 = 2;
                i10 = i4;
                i11 = i3;
                l2 = l3;
              }
              else
              {
                if (i5 == 2)
                {
                  if (l1 == 0L)
                    return 0;
                  long l4 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l4 < l1)));
                  for (int i15 = 1; ; i15 = 0)
                  {
                    int i16 = i15 & i4;
                    i11 = i3;
                    l2 = l4;
                    int i17 = i5;
                    i10 = i16;
                    i9 = i17;
                    break;
                  }
                }
                if (i5 == 3)
                {
                  i9 = 4;
                  i10 = i4;
                  i11 = i3;
                  l2 = l1;
                }
                else if ((i5 == 5) || (i5 == 6))
                {
                  i9 = 7;
                  i10 = i4;
                  i11 = i3;
                  l2 = l1;
                  continue;
                  label519: if ((i5 == 2) && (i4 != 0) && ((l1 != -9223372036854775808L) || (i3 != 0)))
                  {
                    if (i3 != 0);
                    while (true)
                    {
                      this.K = l1;
                      this.F = (i6 + this.F);
                      this.J = 15;
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i5 == 2) || (i5 == 4) || (i5 == 7))
                  {
                    this.L = i6;
                    this.J = 16;
                    return 16;
                  }
                  return 0;
                }
                else
                {
                  i9 = i5;
                  i10 = i4;
                  i11 = i3;
                  l2 = l1;
                }
              }
            }
          }
        }
      }
    }
  }

  private void c(char paramChar)
  {
    char[] arrayOfChar = this.E;
    do
    {
      int i1 = this.F;
      int i2 = this.G;
      while (i1 < i2)
      {
        int i3 = i1 + 1;
        char c1 = arrayOfChar[i1];
        if (c1 == paramChar)
        {
          this.F = i3;
          return;
        }
        if (c1 == '\\')
        {
          this.F = i3;
          j();
          i1 = this.F;
          i2 = this.G;
        }
        else
        {
          if (c1 == '\n')
          {
            this.H = (1 + this.H);
            this.I = i3;
          }
          i1 = i3;
        }
      }
      this.F = i1;
    }
    while (b(1));
    throw b("Unterminated string");
  }

  private String d()
  {
    StringBuilder localStringBuilder = null;
    int i1 = 0;
    while (true)
      if (i1 + this.F < this.G)
      {
        switch (this.E[(i1 + this.F)])
        {
        default:
          i1++;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          h();
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          label178: if (localStringBuilder != null);
          break;
        }
      }
      else
      {
        for (String str = new String(this.E, this.F, i1); ; str = localStringBuilder.toString())
        {
          this.F = (i1 + this.F);
          return str;
          if (i1 < this.E.length)
          {
            if (!b(i1 + 1))
              break label178;
            break;
          }
          if (localStringBuilder == null)
            localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.E, this.F, i1);
          this.F = (i1 + this.F);
          if (b(1))
            break label307;
          i1 = 0;
          break label178;
          localStringBuilder.append(this.E, this.F, i1);
        }
        label307: i1 = 0;
      }
  }

  private void e()
  {
    do
    {
      int i1 = 0;
      while (i1 + this.F < this.G)
        switch (this.E[(i1 + this.F)])
        {
        default:
          i1++;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          h();
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          this.F = (i1 + this.F);
          return;
        }
      this.F = (i1 + this.F);
    }
    while (b(1));
  }

  private int f()
  {
    return 1 + this.H;
  }

  private int g()
  {
    return 1 + (this.F - this.I);
  }

  private void h()
  {
    if (!this.D)
      throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
  }

  private void i()
  {
    while (true)
    {
      int i2;
      if ((this.F < this.G) || (b(1)))
      {
        char[] arrayOfChar = this.E;
        int i1 = this.F;
        this.F = (i1 + 1);
        i2 = arrayOfChar[i1];
        if (i2 != 10)
          break label65;
        this.H = (1 + this.H);
        this.I = this.F;
      }
      label65: 
      while (i2 == 13)
        return;
    }
  }

  private char j()
  {
    if ((this.F == this.G) && (!b(1)))
      throw b("Unterminated escape sequence");
    char[] arrayOfChar = this.E;
    int i1 = this.F;
    this.F = (i1 + 1);
    char c1 = arrayOfChar[i1];
    switch (c1)
    {
    default:
      return c1;
    case 'u':
      if ((4 + this.F > this.G) && (!b(4)))
        throw b("Unterminated escape sequence");
      int i2 = this.F;
      int i3 = i2 + 4;
      char c2 = '\000';
      int i4 = i2;
      if (i4 < i3)
      {
        int i5 = this.E[i4];
        int i6 = (char)(c2 << '\004');
        if ((i5 >= 48) && (i5 <= 57))
          c2 = (char)(i6 + (i5 - 48));
        while (true)
        {
          i4++;
          break;
          if ((i5 >= 97) && (i5 <= 102))
          {
            c2 = (char)(i6 + (10 + (i5 - 97)));
          }
          else
          {
            if ((i5 < 65) || (i5 > 70))
              break label282;
            c2 = (char)(i6 + (10 + (i5 - 65)));
          }
        }
        throw new NumberFormatException("\\u" + new String(this.E, this.F, 4));
      }
      this.F = (4 + this.F);
      return c2;
    case 't':
      return '\t';
    case 'b':
      return '\b';
    case 'n':
      return '\n';
    case 'r':
      return '\r';
    case 'f':
      label282: return '\f';
    case '\n':
    }
    this.H = (1 + this.H);
    this.I = this.F;
    return c1;
  }

  private void k()
  {
    a(true);
    this.F = (-1 + this.F);
    if ((this.F + a.length > this.G) && (!b(a.length)))
      return;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= a.length)
        break label79;
      if (this.E[(i1 + this.F)] != a[i1])
        break;
    }
    label79: this.F += a.length;
  }

  public void beginArray()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 3)
    {
      a(1);
      this.J = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public void beginObject()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 1)
    {
      a(3);
      this.J = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public void close()
  {
    this.J = 0;
    this.N[0] = 8;
    this.O = 1;
    this.C.close();
  }

  public void endArray()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 4)
    {
      this.O = (-1 + this.O);
      this.J = 0;
      return;
    }
    throw new IllegalStateException("Expected END_ARRAY but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public void endObject()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 2)
    {
      this.O = (-1 + this.O);
      this.J = 0;
      return;
    }
    throw new IllegalStateException("Expected END_OBJECT but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public boolean hasNext()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    return (i1 != 2) && (i1 != 4);
  }

  public final boolean isLenient()
  {
    return this.D;
  }

  public boolean nextBoolean()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 5)
    {
      this.J = 0;
      return true;
    }
    if (i1 == 6)
    {
      this.J = 0;
      return false;
    }
    throw new IllegalStateException("Expected a boolean but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public double nextDouble()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 15)
    {
      this.J = 0;
      return this.K;
    }
    if (i1 == 16)
    {
      this.M = new String(this.E, this.F, this.L);
      this.F += this.L;
    }
    double d1;
    do
      while (true)
      {
        this.J = 11;
        d1 = Double.parseDouble(this.M);
        if ((this.D) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1))))
          break label275;
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + d1 + " at line " + (1 + this.H) + " column " + g());
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8);
          for (char c1 = '\''; ; c1 = '"')
          {
            this.M = b(c1);
            break;
          }
        }
        if (i1 != 10)
          break;
        this.M = d();
      }
    while (i1 == 11);
    throw new IllegalStateException("Expected a double but was " + peek() + " at line " + (1 + this.H) + " column " + g());
    label275: this.M = null;
    this.J = 0;
    return d1;
  }

  public int nextInt()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 15)
    {
      int i4 = (int)this.K;
      if (this.K != i4)
        throw new NumberFormatException("Expected an int but was " + this.K + " at line " + (1 + this.H) + " column " + g());
      this.J = 0;
      return i4;
    }
    int i2;
    if (i1 == 16)
    {
      this.M = new String(this.E, this.F, this.L);
      this.F += this.L;
      this.J = 11;
      double d1 = Double.parseDouble(this.M);
      i2 = (int)d1;
      if (i2 != d1)
        throw new NumberFormatException("Expected an int but was " + this.M + " at line " + (1 + this.H) + " column " + g());
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8);
        for (char c1 = '\''; ; c1 = '"')
        {
          this.M = b(c1);
          try
          {
            int i3 = Integer.parseInt(this.M);
            this.J = 0;
            return i3;
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          break;
        }
      }
      throw new IllegalStateException("Expected an int but was " + peek() + " at line " + (1 + this.H) + " column " + g());
    }
    this.M = null;
    this.J = 0;
    return i2;
  }

  public long nextLong()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 15)
    {
      this.J = 0;
      return this.K;
    }
    long l1;
    if (i1 == 16)
    {
      this.M = new String(this.E, this.F, this.L);
      this.F += this.L;
      this.J = 11;
      double d1 = Double.parseDouble(this.M);
      l1 = ()d1;
      if (l1 != d1)
        throw new NumberFormatException("Expected a long but was " + this.M + " at line " + (1 + this.H) + " column " + g());
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8);
        for (char c1 = '\''; ; c1 = '"')
        {
          this.M = b(c1);
          try
          {
            long l2 = Long.parseLong(this.M);
            this.J = 0;
            return l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          break;
        }
      }
      throw new IllegalStateException("Expected a long but was " + peek() + " at line " + (1 + this.H) + " column " + g());
    }
    this.M = null;
    this.J = 0;
    return l1;
  }

  public String nextName()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    String str;
    if (i1 == 14)
      str = d();
    while (true)
    {
      this.J = 0;
      return str;
      if (i1 == 12)
      {
        str = b('\'');
      }
      else
      {
        if (i1 != 13)
          break;
        str = b('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public void nextNull()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    if (i1 == 7)
    {
      this.J = 0;
      return;
    }
    throw new IllegalStateException("Expected null but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public String nextString()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    String str;
    if (i1 == 10)
      str = d();
    while (true)
    {
      this.J = 0;
      return str;
      if (i1 == 8)
      {
        str = b('\'');
      }
      else if (i1 == 9)
      {
        str = b('"');
      }
      else if (i1 == 11)
      {
        str = this.M;
        this.M = null;
      }
      else if (i1 == 15)
      {
        str = Long.toString(this.K);
      }
      else
      {
        if (i1 != 16)
          break;
        str = new String(this.E, this.F, this.L);
        this.F += this.L;
      }
    }
    throw new IllegalStateException("Expected a string but was " + peek() + " at line " + (1 + this.H) + " column " + g());
  }

  public JsonToken peek()
  {
    int i1 = this.J;
    if (i1 == 0)
      i1 = a();
    switch (i1)
    {
    default:
      throw new AssertionError();
    case 1:
      return JsonToken.BEGIN_OBJECT;
    case 2:
      return JsonToken.END_OBJECT;
    case 3:
      return JsonToken.BEGIN_ARRAY;
    case 4:
      return JsonToken.END_ARRAY;
    case 12:
    case 13:
    case 14:
      return JsonToken.NAME;
    case 5:
    case 6:
      return JsonToken.BOOLEAN;
    case 7:
      return JsonToken.NULL;
    case 8:
    case 9:
    case 10:
    case 11:
      return JsonToken.STRING;
    case 15:
    case 16:
      return JsonToken.NUMBER;
    case 17:
    }
    return JsonToken.END_DOCUMENT;
  }

  public final void setLenient(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }

  public void skipValue()
  {
    int i1 = 0;
    int i2 = this.J;
    if (i2 == 0)
      i2 = a();
    if (i2 == 3)
    {
      a(1);
      i1++;
    }
    while (true)
    {
      label29: this.J = 0;
      if (i1 != 0)
        break;
      return;
      if (i2 == 1)
      {
        a(3);
        i1++;
      }
      else if (i2 == 4)
      {
        this.O = (-1 + this.O);
        i1--;
      }
      else if (i2 == 2)
      {
        this.O = (-1 + this.O);
        i1--;
      }
      else if ((i2 == 14) || (i2 == 10))
      {
        do
        {
          int i3 = 0;
          while (true)
            if (i3 + this.F < this.G)
              switch (this.E[(i3 + this.F)])
              {
              default:
                i3++;
                break;
              case '#':
              case '/':
              case ';':
              case '=':
              case '\\':
                h();
              case '\t':
              case '\n':
              case '\f':
              case '\r':
              case ' ':
              case ',':
              case ':':
              case '[':
              case ']':
              case '{':
              case '}':
                this.F = (i3 + this.F);
                break label29;
              }
          this.F = (i3 + this.F);
        }
        while (b(1));
      }
      else if ((i2 == 8) || (i2 == 12))
      {
        c('\'');
      }
      else if ((i2 == 9) || (i2 == 13))
      {
        c('"');
      }
      else if (i2 == 16)
      {
        this.F += this.L;
      }
    }
  }

  public String toString()
  {
    return getClass().getSimpleName() + " at line " + (1 + this.H) + " column " + g();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.stream.JsonReader
 * JD-Core Version:    0.6.2
 */