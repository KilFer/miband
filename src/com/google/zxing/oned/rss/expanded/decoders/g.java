package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class g extends h
{
  private static final int a = 4;

  g(BitArray paramBitArray)
  {
    super(paramBitArray);
  }

  public final String parseInformation()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(01)");
    int i = localStringBuilder.length();
    localStringBuilder.append(getGeneralDecoder().a(4, 4));
    a(localStringBuilder, 8, i);
    return getGeneralDecoder().a(localStringBuilder, 48);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.g
 * JD-Core Version:    0.6.2
 */