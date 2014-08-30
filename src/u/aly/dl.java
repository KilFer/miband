package u.aly;

public final class dl extends dm
{
  private byte[] a;
  private int b;
  private int c;

  public dl()
  {
  }

  public dl(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
  }

  public dl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c(paramArrayOfByte, paramInt1, paramInt2);
  }

  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = h();
    if (paramInt2 > i)
      paramInt2 = i;
    if (paramInt2 > 0)
    {
      System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
      a(paramInt2);
    }
    return paramInt2;
  }

  public final void a(int paramInt)
  {
    this.b = (paramInt + this.b);
  }

  public final void a(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public final boolean a()
  {
    return true;
  }

  public final void b()
  {
  }

  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("No writing allowed!");
  }

  public final void c()
  {
  }

  public final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
  }

  public final void e()
  {
    this.a = null;
  }

  public final byte[] f()
  {
    return this.a;
  }

  public final int g()
  {
    return this.b;
  }

  public final int h()
  {
    return this.c - this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.dl
 * JD-Core Version:    0.6.2
 */