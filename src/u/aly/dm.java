package u.aly;

public abstract class dm
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public void a(int paramInt)
  {
  }

  public abstract boolean a();

  public abstract void b();

  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public abstract void c();

  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (true)
    {
      if (i >= paramInt2)
        return i;
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0)
        throw new dn("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
      i += j;
    }
  }

  public void d()
  {
  }

  public byte[] f()
  {
    return null;
  }

  public int g()
  {
    return 0;
  }

  public int h()
  {
    return -1;
  }

  public boolean i()
  {
    return a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.dm
 * JD-Core Version:    0.6.2
 */