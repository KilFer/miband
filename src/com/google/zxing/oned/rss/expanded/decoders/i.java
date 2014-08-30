package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class i extends h
{
  i(BitArray paramBitArray)
  {
    super(paramBitArray);
  }

  protected abstract int a(int paramInt);

  protected abstract void a(StringBuilder paramStringBuilder, int paramInt);

  protected final void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = getGeneralDecoder().a(paramInt1, paramInt2);
    a(paramStringBuilder, i);
    int j = a(i);
    int k = 100000;
    for (int m = 0; m < 5; m++)
    {
      if (j / k == 0)
        paramStringBuilder.append('0');
      k /= 10;
    }
    paramStringBuilder.append(j);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.i
 * JD-Core Version:    0.6.2
 */