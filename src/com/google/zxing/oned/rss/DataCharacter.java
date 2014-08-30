package com.google.zxing.oned.rss;

public class DataCharacter
{
  private final int a;
  private final int b;

  public DataCharacter(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int getChecksumPortion()
  {
    return this.b;
  }

  public int getValue()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.DataCharacter
 * JD-Core Version:    0.6.2
 */