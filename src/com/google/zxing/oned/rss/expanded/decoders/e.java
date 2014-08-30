package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class e extends i
{
  private static final int a = 8;
  private static final int b = 20;
  private static final int c = 16;
  private final String d;
  private final String e;

  e(BitArray paramBitArray, String paramString1, String paramString2)
  {
    super(paramBitArray);
    this.d = paramString2;
    this.e = paramString1;
  }

  private void c(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = getGeneralDecoder().a(68, 16);
    if (i == 38400)
      return;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.d);
    paramStringBuilder.append(')');
    int j = i % 32;
    int k = i / 32;
    int m = 1 + k % 12;
    int n = k / 12;
    if (n / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(n);
    if (m / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(m);
    if (j / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(j);
  }

  protected final int a(int paramInt)
  {
    return paramInt % 100000;
  }

  protected final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = paramInt / 100000;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.e);
    paramStringBuilder.append(i);
    paramStringBuilder.append(')');
  }

  public final String parseInformation()
  {
    if (getInformation().getSize() != 84)
      throw NotFoundException.getNotFoundInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    b(localStringBuilder, 48, 20);
    int i = getGeneralDecoder().a(68, 16);
    if (i != 38400)
    {
      localStringBuilder.append('(');
      localStringBuilder.append(this.d);
      localStringBuilder.append(')');
      int j = i % 32;
      int k = i / 32;
      int m = 1 + k % 12;
      int n = k / 12;
      if (n / 10 == 0)
        localStringBuilder.append('0');
      localStringBuilder.append(n);
      if (m / 10 == 0)
        localStringBuilder.append('0');
      localStringBuilder.append(m);
      if (j / 10 == 0)
        localStringBuilder.append('0');
      localStringBuilder.append(j);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.e
 * JD-Core Version:    0.6.2
 */