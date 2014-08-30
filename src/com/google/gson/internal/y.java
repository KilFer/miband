package com.google.gson.internal;

import java.io.Writer;

final class y extends Writer
{
  private final Appendable a;
  private final z b = new z();

  private y(Appendable paramAppendable)
  {
    this.a = paramAppendable;
  }

  public final void close()
  {
  }

  public final void flush()
  {
  }

  public final void write(int paramInt)
  {
    this.a.append((char)paramInt);
  }

  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.b.a = paramArrayOfChar;
    this.a.append(this.b, paramInt1, paramInt1 + paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.y
 * JD-Core Version:    0.6.2
 */