package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter
  implements Closeable, Flushable
{
  private static final String[] a = new String[''];
  private static final String[] b;
  private final Writer c;
  private int[] d = new int[32];
  private int e = 0;
  private String f;
  private String g;
  private boolean h;
  private boolean i;
  private String j;
  private boolean k;

  static
  {
    for (int m = 0; m <= 31; m++)
    {
      String[] arrayOfString2 = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(m);
      arrayOfString2[m] = String.format("\\u%04x", arrayOfObject);
    }
    a[34] = "\\\"";
    a[92] = "\\\\";
    a[9] = "\\t";
    a[8] = "\\b";
    a[10] = "\\n";
    a[13] = "\\r";
    a[12] = "\\f";
    String[] arrayOfString1 = (String[])a.clone();
    b = arrayOfString1;
    arrayOfString1[60] = "\\u003c";
    b[62] = "\\u003e";
    b[38] = "\\u0026";
    b[61] = "\\u003d";
    b[39] = "\\u0027";
  }

  public JsonWriter(Writer paramWriter)
  {
    a(6);
    this.g = ":";
    this.k = true;
    if (paramWriter == null)
      throw new NullPointerException("out == null");
    this.c = paramWriter;
  }

  private int a()
  {
    if (this.e == 0)
      throw new IllegalStateException("JsonWriter is closed.");
    return this.d[(-1 + this.e)];
  }

  private JsonWriter a(int paramInt1, int paramInt2, String paramString)
  {
    int m = a();
    if ((m != paramInt2) && (m != paramInt1))
      throw new IllegalStateException("Nesting problem.");
    if (this.j != null)
      throw new IllegalStateException("Dangling name: " + this.j);
    this.e = (-1 + this.e);
    if (m == paramInt2)
      c();
    this.c.write(paramString);
    return this;
  }

  private JsonWriter a(int paramInt, String paramString)
  {
    a(true);
    a(paramInt);
    this.c.write(paramString);
    return this;
  }

  private void a(int paramInt)
  {
    if (this.e == this.d.length)
    {
      int[] arrayOfInt2 = new int[this.e << 1];
      System.arraycopy(this.d, 0, arrayOfInt2, 0, this.e);
      this.d = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.d;
    int m = this.e;
    this.e = (m + 1);
    arrayOfInt1[m] = paramInt;
  }

  private void a(String paramString)
  {
    int m = 0;
    if (this.i);
    int n;
    int i1;
    int i2;
    for (String[] arrayOfString = b; ; arrayOfString = a)
    {
      this.c.write("\"");
      n = paramString.length();
      for (i1 = 0; ; i1++)
      {
        if (i1 >= n)
          break label141;
        i2 = paramString.charAt(i1);
        if (i2 >= 128)
          break;
        str = arrayOfString[i2];
        if (str != null)
          break label90;
      }
    }
    if (i2 == 8232);
    for (String str = "\\u2028"; ; str = "\\u2029")
    {
      label90: if (m < i1)
        this.c.write(paramString, m, i1 - m);
      this.c.write(str);
      m = i1 + 1;
      break;
      if (i2 != 8233)
        break;
    }
    label141: if (m < n)
      this.c.write(paramString, m, n - m);
    this.c.write("\"");
  }

  private void a(boolean paramBoolean)
  {
    switch (a())
    {
    case 3:
    case 5:
    default:
      throw new IllegalStateException("Nesting problem.");
    case 7:
      if (!this.h)
        throw new IllegalStateException("JSON must have only one top-level value.");
    case 6:
      if ((!this.h) && (!paramBoolean))
        throw new IllegalStateException("JSON must start with an array or an object.");
      b(7);
      return;
    case 1:
      b(2);
      c();
      return;
    case 2:
      this.c.append(',');
      c();
      return;
    case 4:
    }
    this.c.append(this.g);
    b(5);
  }

  private void b()
  {
    int m;
    if (this.j != null)
    {
      m = a();
      if (m != 5)
        break label49;
      this.c.write(44);
    }
    label49: 
    while (m == 3)
    {
      c();
      b(4);
      a(this.j);
      this.j = null;
      return;
    }
    throw new IllegalStateException("Nesting problem.");
  }

  private void b(int paramInt)
  {
    this.d[(-1 + this.e)] = paramInt;
  }

  private void c()
  {
    if (this.f == null);
    while (true)
    {
      return;
      this.c.write("\n");
      int m = 1;
      int n = this.e;
      while (m < n)
      {
        this.c.write(this.f);
        m++;
      }
    }
  }

  private void d()
  {
    int m = a();
    if (m == 5)
      this.c.write(44);
    while (m == 3)
    {
      c();
      b(4);
      return;
    }
    throw new IllegalStateException("Nesting problem.");
  }

  public JsonWriter beginArray()
  {
    b();
    return a(1, "[");
  }

  public JsonWriter beginObject()
  {
    b();
    return a(3, "{");
  }

  public void close()
  {
    this.c.close();
    int m = this.e;
    if ((m > 1) || ((m == 1) && (this.d[(m - 1)] != 7)))
      throw new IOException("Incomplete document");
    this.e = 0;
  }

  public JsonWriter endArray()
  {
    return a(1, 2, "]");
  }

  public JsonWriter endObject()
  {
    return a(3, 5, "}");
  }

  public void flush()
  {
    if (this.e == 0)
      throw new IllegalStateException("JsonWriter is closed.");
    this.c.flush();
  }

  public final boolean getSerializeNulls()
  {
    return this.k;
  }

  public final boolean isHtmlSafe()
  {
    return this.i;
  }

  public boolean isLenient()
  {
    return this.h;
  }

  public JsonWriter name(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("name == null");
    if (this.j != null)
      throw new IllegalStateException();
    if (this.e == 0)
      throw new IllegalStateException("JsonWriter is closed.");
    this.j = paramString;
    return this;
  }

  public JsonWriter nullValue()
  {
    if (this.j != null)
    {
      if (this.k)
        b();
    }
    else
    {
      a(false);
      this.c.write("null");
      return this;
    }
    this.j = null;
    return this;
  }

  public final void setHtmlSafe(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public final void setIndent(String paramString)
  {
    if (paramString.length() == 0)
    {
      this.f = null;
      this.g = ":";
      return;
    }
    this.f = paramString;
    this.g = ": ";
  }

  public final void setLenient(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public final void setSerializeNulls(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public JsonWriter value(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramDouble);
    b();
    a(false);
    this.c.append(Double.toString(paramDouble));
    return this;
  }

  public JsonWriter value(long paramLong)
  {
    b();
    a(false);
    this.c.write(Long.toString(paramLong));
    return this;
  }

  public JsonWriter value(Number paramNumber)
  {
    if (paramNumber == null)
      return nullValue();
    b();
    String str = paramNumber.toString();
    if ((!this.h) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN"))))
      throw new IllegalArgumentException("Numeric values must be finite, but was " + paramNumber);
    a(false);
    this.c.append(str);
    return this;
  }

  public JsonWriter value(String paramString)
  {
    if (paramString == null)
      return nullValue();
    b();
    a(false);
    a(paramString);
    return this;
  }

  public JsonWriter value(boolean paramBoolean)
  {
    b();
    a(false);
    Writer localWriter = this.c;
    if (paramBoolean);
    for (String str = "true"; ; str = "false")
    {
      localWriter.write(str);
      return this;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.stream.JsonWriter
 * JD-Core Version:    0.6.2
 */